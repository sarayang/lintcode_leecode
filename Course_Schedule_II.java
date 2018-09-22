package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-22.
 */
public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        HashMap<Integer, HashSet<Integer>> courseMap = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> preqs = new HashSet<>();
            courseMap.put(i, preqs);
        }

        for (int j = 0; j < prerequisites.length; j++) {
            courseMap.get(prerequisites[j][1]).add(prerequisites[j][0]);
        }

        int[] numPreq = new int[numCourses];
        for (int k = 0; k < numCourses; k++) {
            for (int after : courseMap.get(k)) {
                numPreq[after]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPreq[i] == 0) {
                queue.offer(i);
            }
        }

        //BFS
        int[] order = new int[numCourses];
        int counter = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int after : courseMap.get(course)) {
                numPreq[after]--;
                if (numPreq[after] == 0) {
                    queue.offer(after);
                }
            }
            order[counter++] = course;
        }

        if (counter == numCourses) {
            return order;
        }

        return new int[0];
    }

    // new version wrote on 9/22
    public int[] findOrder_lintcode(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }

            return result;
        }

        // build map which map independency -> dependencies.
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] course : prerequisites) {
            if (map.containsKey(course[1])) {
                map.get(course[1]).add(course[0]);
            } else {
                HashSet<Integer> dependencies = new HashSet<>();
                dependencies.add(course[0]);
                map.put(course[1], dependencies);
            }
        }

        // compute the indegree: each course number is the index, indegree of that course is value according to that index.
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
        }

        for (Integer indep : map.keySet()) {
            for (Integer dep : map.get(indep)) {
                indegree[dep]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }


        System.out.println(indegree);
        int counter = 0;
        while (!queue.isEmpty() && counter < numCourses) {
            int course = queue.poll();
            result[counter] = course;
            counter++;

            if (map.get(course) != null) {
                for (Integer dep : map.get(course)) {
                    indegree[dep]--;
                    if (indegree[dep] == 0) {
                        queue.offer(dep);
                    }
                }
            }
        }

        return counter == numCourses ? result : new int[0];
    }
}

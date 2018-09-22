package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-22.
 */
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // write your code here
        HashMap<Integer, HashSet<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> set = new HashSet<>();
            courseMap.put(i, set);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            courseMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] numPrereq = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int after : courseMap.get(i)) {
                numPrereq[after]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (numPrereq[i] == 0) {
                queue.offer(i);
            }
        }

        int course = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            for (int after : courseMap.get(currentCourse)) {
                numPrereq[after]--;
                if (numPrereq[after] == 0) {
                    queue.offer(after);
                }
            }
            course++;
        }

        return course == numCourses;
    }


    // another version wrote on 9/22
    public boolean canFinish_rewrote(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || prerequisites[0].length == 0
                || prerequisites == null) {
            return true;
        }

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] courses : prerequisites) {
            if (map.containsKey(courses[1])) {
                map.get(courses[1]).add(courses[0]);
                // map.put(courses[1], map.get(courses[1]));
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(courses[0]);
                map.put(courses[1], set);
            }
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            indegree[i] = 0;
        }

        for (Integer i : map.keySet()) {
            for (Integer dep : map.get(i)) {
                indegree[dep]++;
            }
        }

        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty() && numCourses > 0) {

            int val = queue.poll();
            numCourses--;
            if (map.containsKey(val)) {
                HashSet<Integer> neig = map.get(val);
                for (Integer n : neig) {
                    indegree[n]--;
                    if (indegree[n] == 0) {
                        queue.offer(n);
                    }
                }
            }

        }
        return numCourses == 0 ? true : false;
    }
}

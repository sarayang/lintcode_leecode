package lintcode.lintcode_leecode;

import java.util.*;

/**
 * Created by YANGSONG on 2018-09-09.
 */
public class Sequence_Reconstruction {
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();

        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {
            count += seq.length;
            if (seq.length >= 1 && (seq[0] <= 0 || seq[0] > n))
                return false;
            for (int i = 1; i < seq.length; i++) {
                if (seq[i] <= 0 || seq[i] > n)
                    return false;
                if (map.get(seq[i - 1]).add(seq[i]))
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
            }
        }

        // case: [1], []
        if (count < n)
            return false;

        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int key : indegree.keySet())
            if (indegree.get(key) == 0)
                q.add(key);

        System.out.println(map);
        System.out.println(indegree);
        int cnt = 0;
        while (q.size() == 1) {
            int ele = q.poll();
            System.out.println(ele);
            for (int next : map.get(ele)) {
                System.out.println("next: " + next);
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
            if (ele != org[cnt]) {
                return false;
            }
            cnt++;
        }

        return cnt == org.length;
    }

    // copied directly from lintcode
    public boolean sequenceReconstruction_lintcode(int[] org, int[][] seqs) {
        // write your code here

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < org.length; i++) {
            map.put(org[i], new HashSet<Integer>());
            indegree.put(org[i], 0);
        }

        int counter = 0;
        int n = org.length;
        for (int[] seq : seqs) {
            counter += seq.length;
            for (int k = 0; k < seq.length; k++) {
                if (seq[k] <= 0 || seq[k] > 10_000) {
                    return false;
                }
            }
            for (int j = 1; j < seq.length; j++) {

                if (map.get(seq[j - 1]) != null && map.get(seq[j - 1]).add(seq[j]))  {

                    if (indegree.get(seq[j]) != null) {
                        indegree.put(seq[j], indegree.get(seq[j]) + 1);
                    } else {
                        indegree.put(seq[j], 0);
                    }

                }
            }
        }

        if (counter < n) return false;

        Deque<Integer> queue = new LinkedList<>();
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                queue.offer(key);
            }
        }

        int steps = 0;
        while (queue.size() == 1) {
            int cur = queue.poll();
            for (Integer after : map.get(cur)) {
                indegree.put(after, indegree.get(after) - 1);
                if (indegree.get(after) == 0) {
                    queue.offer(after);
                }
            }
            if (cur != org[steps]) {
                return false;
            }
            steps++;
        }
        return steps == org.length;
    }


    public static void main(String[] args) {
        Sequence_Reconstruction s = new Sequence_Reconstruction();

        int[] org = {4, 1, 5, 2, 6, 3};
        int[][] seq = {{5, 2, 6, 3}, {4, 1, 5, 2}};

        System.out.println(s.sequenceReconstruction(org, seq));
    }

}

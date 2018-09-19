package lintcode.lintcode_leecode;

import java.util.*;

/**
 * Created by YANGSONG on 2018-09-19.
 */
class Sum {
    public int aIndex;
    public int bIndex;
    public int sum;
    public Sum(int aindex, int bindex, int s) {
        this.aIndex = aindex;
        this.bIndex = bindex;
        this.sum = s;
    }

    @Override
    public String toString() {
        return Integer.toString(this.sum);
    }
}

class SumComparator implements Comparator<Sum> {
    @Override
    public int compare(Sum s1, Sum s2) {
        return s1.sum - s2.sum;
    }
}
public class KtSmallest_Sum_In_Two_Sorted_Arrays {
    public int kthSmallestSum(int[] A, int[] B, int k) {
        PriorityQueue<Sum> minHeap = new PriorityQueue<>(A.length + B.length, new SumComparator());
        int aSize = A.length;
        int bSize = B.length;

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        boolean[][] hash = new boolean[aSize][bSize];
        Sum initial = new Sum(0, 0, A[0] + B[0]);

        minHeap.offer(initial);
        System.out.println(Arrays.toString(minHeap.toArray()));
        for (int i = 0; i < k - 1; i++) {
            Sum sum = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nextA = sum.aIndex + dx[j];
                int nextB = sum.bIndex + dy[j];
                System.out.println(nextA + ", " + nextB);
                Sum nextSum = new Sum(nextA, nextB, 0);
                if (nextA < aSize && nextB < bSize && !hash[nextA][nextB]) {
                    hash[nextA][nextB] = true;
                    nextSum.sum = A[nextA] + B[nextB];
                    minHeap.offer(nextSum);
                }
            }

            System.out.println(Arrays.toString(minHeap.toArray()));
            // hash[nextA] = false;
        }

        return minHeap.peek().sum;

    }
    private Map<String, List> getEmailToIds(List<List<String>> accounts) {
        Map<String, List> emailToIds = new HashMap<>();
        for (int user_id  = 0; user_id < accounts.size(); user_id++) {
            List<String> account = accounts.get(user_id);
            for (int i = 1; i < account.size(); i++) {
                List<Integer> ids = emailToIds.getOrDefault(account.get(i), new ArrayList<Integer>());

                ids.add(user_id);
                emailToIds.put(account.get(i), ids);
            }
        }
        return emailToIds;
    }

    public static void main(String[] args) {
        KtSmallest_Sum_In_Two_Sorted_Arrays k = new KtSmallest_Sum_In_Two_Sorted_Arrays();
        List<List<String>> accounts = new ArrayList<>();

        List<String> list1 = new ArrayList<>();
        list1.add("Mary");
        list1.add("mary@mail.com");

        List<String> list2 = new ArrayList<>();
        list2.add("John");
        list2.add("johnsmith@mail.com");
        list2.add("john00@mail.com");

        List<String> list3 = new ArrayList<>();
        list3.add("John");
        list3.add("johnnybravo@mail.com");

        List<String> list4 = new ArrayList<>();
        list4.add("John");
        list4.add("johnsmith@mail.com");
        list4.add("john_newyork@mail.com");

        accounts.add(list1);
        accounts.add(list2);
        accounts.add(list3);
        accounts.add(list4);

        System.out.println(k.getEmailToIds(accounts));
    }
}

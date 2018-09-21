package lintcode.lintcode_leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Created by YANGSONG on 2018-09-20.
 */
public class Sliding_Window_Maximum {
    void inQueue(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }

    void outQueue(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }

    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Deque<Integer> deque = new ArrayDeque<Integer>();
        if (nums.length == 0) {
            return ans;
        }
        for (int i = 0; i < k - 1; i++) {
            inQueue(deque, nums[i]);
        }

        for(int i = k - 1; i < nums.length; i++) {
            inQueue(deque, nums[i]);
            ans.add(deque.peekFirst());
            outQueue(deque, nums[i - k + 1]);
        }
        return ans;

    }

    public static void main(String[] args) {
        Sliding_Window_Maximum s = new Sliding_Window_Maximum();
        int[] nums = {1,2,7,7,2};
        System.out.println(s.maxSlidingWindow(nums, 3));
    }
}

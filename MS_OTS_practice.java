package lintcode.lintcode_leecode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-13.
 */
public class MS_OTS_practice {

    public static void main(String[] args) {
        LinkedList<Integer> n1 = new LinkedList<>();
        LinkedList<Integer> n2 = new LinkedList<>();

        n1.offer(9);
        n1.offer(6);
        n1.offer(4);

        n2.offer(4);
        n2.offer(5);
        n2.offer(6);

        LinkedList<Integer> odd = new LinkedList<>();
        LinkedList<Integer> even = new LinkedList<>();

        int size = n2.size();

        for (int i = 0; i < size; i++) {
            if (n2.peek() != null) {
                if (i % 2 == 0) {
                    even.offer(n2.poll());
                } else {
                    odd.offer(n2.poll());
                }
            }

        }


        for (int i = 0; i < 12; i++) {
            for (int j = 0; j <60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == 8) {
                    System.out.println(String.format("%d:%02d", i, j));
                }
            }
        }

        int i = -12000000;
        String k = Integer.toString(i);
        for (char c : k.toCharArray()) {
            System.out.println(c);
        }


        HashMap<Integer, Integer> map = new HashMap<>();






//        LinkedList<Integer> result = new LinkedList<>();
//        int size = Math.max(n1.size(), n2.size());
//        int carry = 0;
//
//        for (int i = 0; i< size + 1; i++) {
//            if (n1.peekLast() != null && n2.peekLast() != null) {
//                Integer sumOrig = n1.pollLast() + n2.pollLast();
//
//                Integer sum = (sumOrig + carry) % 10;
//                System.out.println(sum);
//                carry = sumOrig >= 10 ? 1 : 0;
//
//                result.addFirst(sum);
//            }
//            else if (n1.peekLast() == null && n2.peekLast() == null && carry != 0) {
//                result.addFirst(carry);
//            }
//            else if (n1.peekLast() == null) {
//                Integer added = n2.pollLast() + carry;
//                carry = added >= 10 ? 1 : 0;
//                result.addFirst(added % 10);
//            }
//
//            else if (n2.peekLast() == null) {
//                Integer added = n1.pollLast() + carry;
//                carry = added >= 10 ? 1 : 0;
//                result.addFirst(added % 10);
//            }
//
//
//
//        }
//        System.out.println(result);



    }
}

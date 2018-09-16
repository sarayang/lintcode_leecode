package lintcode.lintcode_leecode;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by YANGSONG on 2018-09-09.
 */
public class Binary_Tree_Level_Order_Traversal {
    public TreeNode root = new TreeNode(3);
    public class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            value = val;
            left = this.right = null;
        }
    }

    public List<List<Integer>> bsf(TreeNode node) {
        List<List<Integer>> result = new ArrayList<>();
        if (node == null) {
            return result;
        }



        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                level.add(n.value);
                if (n.left != null) {
                    queue.offer(n.left);

                }
                if (n.right != null) {
                    queue.offer(n.right);
                }

            }
            result.add(level);


        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        Binary_Tree_Level_Order_Traversal b = new Binary_Tree_Level_Order_Traversal();
        Binary_Tree_Level_Order_Traversal.TreeNode root = b.new TreeNode(1);

        root.left = b.new TreeNode(2);
        root.right = b.new TreeNode(3);
        root.left.left = b.new TreeNode(4);
        root.left.right = b.new TreeNode(5);
        root.right.right = b.new TreeNode(6);


        System.out.println(b.bsf(root));

        ArrayList<HashSet<Integer>> record = new ArrayList<HashSet<Integer>>();
        HashSet<Integer> zero = new HashSet<>();
        HashSet<Integer> first = new HashSet<>();
        HashSet<Integer> third = new HashSet<>();
        zero.add(1);
        zero.add(2);
        record.add(zero);
        record.add(first);
        record.add(third);

        HashSet<Integer> second = new HashSet<>();
        second.add(2);
        second.add(3);
        record.add(second);

        int[] numPre = new int[4];
        for(int i = 0;i<4;i++){
            for(int after : record.get(i)){
                System.out.print(after);
                numPre[after]++;
            }
        }

        System.out.println(Arrays.toString(numPre));


    }
}

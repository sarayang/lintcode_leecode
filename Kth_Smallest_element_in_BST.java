package lintcode.lintcode_leecode;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by YANGSONG on 2018-09-16.
 */
public class Kth_Smallest_element_in_BST {
    class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private int kth = 0;
    private int smallest = Integer.MAX_VALUE;
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        for (int i = 0; i < k - 1; i++) {
            TreeNode node = stack.peek();

            if (node.right == null) {
                node = stack.pop();
                while (!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }

        return stack.peek().val;
    }

    private int findKthSmallest(TreeNode node) {
        if (node == null) {
            return smallest;
        }

        int left = findKthSmallest(node.left);
        if (left == Integer.MAX_VALUE) {
            findKthSmallest(node.right);
        }
        kth--;

        return node.val;
    }

    public static void main(String[] args) {
        Kth_Smallest_element_in_BST k = new Kth_Smallest_element_in_BST();
        TreeNode root = k.new TreeNode(13);
        TreeNode left_9 = k.new TreeNode(9);
        TreeNode left_11 = k.new TreeNode(11);
        TreeNode left_23 = k.new TreeNode(23);
        TreeNode left_26 = k.new TreeNode(26);
        TreeNode left_8 = k.new TreeNode(8);
        TreeNode left_10 = k.new TreeNode(10);
        TreeNode left_25 = k.new TreeNode(25);

        root.left = left_10;
        root.right = left_25;
        left_10.left = left_8;
        left_10.right = left_11;

        left_25.left = left_23;
        left_25.right = left_26;
        left_8.right = left_9;

        ArrayList<Integer> preorder = k.preorderTraversal_stack(root);

        ArrayList<Integer> result = new ArrayList<>();
        k.preorderTraversal_recusive(root, result);
//        System.out.println(preorder);
//        System.out.println(result);
//
//        System.out.println(k.postorderTraversal_stack(root));
        System.out.println(k.inorderTraversal_stack(root));
        System.out.println(k.postorerTraversal(root));
    }

    private ArrayList<Integer> preorderTraversal_stack(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root != null) {
            stack.add(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);
            if (node.right != null) {
                stack.offer(node.right);
            }

            if (node.left != null) {
                stack.offer(node.left);
            }
        }

        return result;
    }

    private void preorderTraversal_recusive(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }

        result.add(root.val);
        preorderTraversal_recusive(root.left, result);
        preorderTraversal_recusive(root.right, result);
    }

    private ArrayList<Integer> inorderTraversal_stack(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();

        Kth_Smallest_element_in_BST.pullAllLeftNodes(root, stack);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peekLast();
            list.add(node.val);

            if (node.right == null) {

                node = stack.pollLast();

                while (!stack.isEmpty() && stack.peekLast().right == node) {
                    node = stack.pollLast();
                }
            } else {
                node = node.right;
                Kth_Smallest_element_in_BST.pullAllLeftNodes(node, stack);
            }
        }

        return list;
    }


    // helper function for in-order traversal
    private static void pullAllLeftNodes(TreeNode node, Deque<TreeNode> result) {
        while (node != null) {
            result.offer(node);
            node = node.left;
        }
    }

    private ArrayList<Integer> postorerTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode prev = null;
        TreeNode cur;

        if (root == null) {
            return result;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.peekLast();
            if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
                if (cur.left != null) {
                    stack.offer(cur.left);
                } else if (cur.right != null) {
                    stack.offer(cur.right);
                }
            } else if (cur.left == prev) { // traverse up the tree from the left, if right is not null push it into the stack
                if (cur.right != null) {
                    stack.offer(cur.right);
                }
            } else { // which traverses up the tree from the right
                result.add(cur.val);
                stack.pollLast();
            }
            prev = cur;
        }
        return result;
    }
}

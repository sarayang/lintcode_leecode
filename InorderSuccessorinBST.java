package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-25.
 *
 * 448. Inorder Successor in BST
 Given a binary search tree (See Definition) and a node in it, find the in-order successor of that node in the BST.

 If the given node has no in-order successor in the tree, return null.

 Example
 Given tree = [2,1] and node = 1:

 2
 /
 1
 return node 2.

 Given tree = [2,1,3] and node = 2:

 2
 / \
 1   3
 return node 3.

 Challenge
 O(h), where h is the height of the BST.

 Notice
 It's guaranteed p is one node in the given tree. (You can directly compare the memory address to find p)
 */

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class InorderSuccessorinBST {

    // using queue to record the tree
    Deque<TreeNode> queue = new LinkedList<>();
    int counter = 0;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        if (root == null) {
            return null;
        }
        traverseTree(root, p);
        while (!queue.isEmpty() && queue.peekFirst().val != p.val) {
            queue.pollFirst();
        }

        if (queue.peekFirst().val == p.val) {
            queue.pollFirst();
        }

        return queue.isEmpty() ? null : queue.pollFirst();
    }

    private void traverseTree(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return;
        }

        traverseTree(root.left, p);
        queue.offer(root);
        if (counter > 1) {
            return;
        }
        if (root.val == p.val) {
            counter++;
        }

        traverseTree(root.right, p);
    }

    public TreeNode inorderSuccessor_recursive(TreeNode root, TreeNode p) {
        // use recursion to find the successor of p
        // 以当前的root作为标杆 如果要是root <= p which means p is on the right side of root. recusively visting root right subtree. it is okay if the right subtree is null
        // if root > p, which mean p is on the left side of root. recursively visiting root left subtree, if left node reachs to a null, its root is the successor (next node)

        // same thing applys on precedessor (previous node)

        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }
    }

    public TreeNode inorderPrecedessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val >= p.val) {
            return inorderPrecedessor(root.left, p);
        } else {
            TreeNode right = inorderPrecedessor(root.right, p);
            return right == null ? root : right;
        }
    }
}

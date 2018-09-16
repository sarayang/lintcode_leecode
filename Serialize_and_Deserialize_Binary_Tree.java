package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-10.
 */
public class Serialize_and_Deserialize_Binary_Tree {

    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }


    private String bfsSerialize(TreeNode node) {


        // get all the treenode from node
        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(node);
        for (int i = 0; i < list.size(); i++) {
            TreeNode n = list.get(i);
            if (n != null) {
                list.add(n.left);
                list.add(n.right);
            }
        }

        while (list.get(list.size() - 1) == null) {
            list.remove(list.size() - 1);
        }

        String s = "{";
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j) != null) {
                s += Integer.toString(list.get(j).val) + ",";
            } else {
                s += "#,";
            }
        }
        s = s.substring(0, s.length() - 1);
        s += "}";


        return s;




    }

    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

//        String[] str = data.substring(1, data.length() - 1).split(",");
//
//        ArrayList<TreeNode> list = new ArrayList<>();
//
//        for (String s : str) {
//            if (s.equals("#")) {
//                list.add(null);
//            } else {
//                list.add(new TreeNode(Integer.parseInt(s)));
//            }
//        }
//
//        for (int i = 0; i < list.size() / 2; i++) {
//            if (list.get(i) == null) {
//                continue;
//            }
//            if (list.get(2*i + 1) != null) {
//
//                list.get(i).left = list.get(2 * i + 1);
//            }
//            if (list.get(2*i + 2) != null) {
//                list.get(i).right = list.get(2*i + 2);
//            }
//
//        }
//
//        return list.get(0);

        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;



    }

//    public TreeNode deserialize(String data) {
//        if (data == null) {
//            return null;
//        }
//
//        String[] str = data.substring(1, data.length() - 1).split(",");
//
//        Deque<String> queue = new LinkedList<>();
//
//        queue.addAll(Arrays.asList(str));
//
//        return deserialize(queue);
//
//
//    }

    private TreeNode deserialize(Deque<String> nodes) {

        String nodeVal = nodes.pollFirst();
        if (nodeVal == null) {
            return null;
        }

        if(nodeVal.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(nodeVal));
            node.left = deserialize(nodes);
            node.right = deserialize(nodes);
            return node;
        }


    }


    public static void main(String[] args) {
        Serialize_and_Deserialize_Binary_Tree s = new Serialize_and_Deserialize_Binary_Tree();

        TreeNode node_3 = s.new TreeNode(3);
        TreeNode node_9 = s.new TreeNode(9);
        TreeNode node_20 = s.new TreeNode(20);
        TreeNode node_15 = s.new TreeNode(15);
        TreeNode node_7 = s.new TreeNode(7);


        node_3.left = node_9;
        node_3.right = node_20;
        node_20.left = node_15;
        node_20.right = node_7;


        String str = s.bfsSerialize(node_3);
//        System.out.println(str);

        String input = "{1,2,#,3,#,4}";
//
        TreeNode root = s.deserialize(input);
        System.out.println(root.val);

//        for (TreeNode n : str) {
//            if (n != null) {
//                System.out.println(Integer.toString(n.val));
//            } else {
//                System.out.println("#");
//            }
//
//        }
//        System.out.println(str);


        String data = "{1,#,2}";
        String[] t = data.substring(1, data.length() - 1).split(",");
//        System.out.println(Arrays.toString(t));

        int i = 1 << 10;

        System.out.println(Integer.bitCount(i));

        int j = 1;
        int index = j ^ 1;
        int now = index ^ 1;
        int index_1 = now ^ 1;
        System.out.println(index);
        System.out.println(now);
        System.out.println(index_1);

    }


}

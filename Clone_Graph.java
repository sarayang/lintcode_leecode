package lintcode.lintcode_leecode;

import java.util.*;

/**
 * Created by YANGSONG on 2018-09-10.
 */
public class Clone_Graph {
    class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return node;
        }

        // use bfs algorithm to traverse the graph and get all nodes.
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);

        // copy nodes, store the old->new mapping information in a hash map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes) {
            mapping.put(n, new UndirectedGraphNode(n.label));
        }

        // copy neighbors(edges)
        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = mapping.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = mapping.get(neighbor);
                newNode.neighbors.add(newNeighbor);
            }
        }

        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

    public static void main(String[] args) {
        Clone_Graph cg = new Clone_Graph();
        UndirectedGraphNode n0 = cg.new UndirectedGraphNode(0);
        UndirectedGraphNode n1 = cg.new UndirectedGraphNode(1);
        UndirectedGraphNode n2 = cg.new UndirectedGraphNode(2);

        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);

        UndirectedGraphNode newNode = cg.cloneGraph(n0);
        System.out.println(newNode.label + ": ");

        for (UndirectedGraphNode node : newNode.neighbors) {
            System.out.println(node.label + "|");
            for (UndirectedGraphNode n : node.neighbors) {
                System.out.println(n.label);
            }
        }

        String animals = "dog,cat,#,#,giraffe,";

        String[] animalsArray = animals.split(",");

        System.out.println(Arrays.deepToString(animalsArray));




    }
}

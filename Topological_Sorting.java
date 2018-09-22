package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-16.
 */
public class Topological_Sorting {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
     class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    }
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            if (node.neighbors.size() != 0) {
                for (DirectedGraphNode neighbor : node.neighbors) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                }
            }
        }

        Deque<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                queue.offer(node);
            }
        }

        int nodeNums = 0;
        ArrayList<DirectedGraphNode> orderedGraph = new ArrayList<>();
        while (!queue.isEmpty()) {
            DirectedGraphNode n = queue.poll();
            orderedGraph.add(n);
            for (DirectedGraphNode neighbor : n.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
            nodeNums++;
        }
        for (DirectedGraphNode node : orderedGraph) {
            System.out.println(node.label + " | ");
        }

        return orderedGraph;
    }

    // new version  wrote on 9/22/2018
    public ArrayList<DirectedGraphNode> topSort_lintcode(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        if (graph == null || graph.size() < 1) {
            return result;
        }

        HashMap<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                } else {
                    indegree.put(neighbor, 1);
                }
            }
        }

        Deque<DirectedGraphNode> queue = new LinkedList<>();
        for (DirectedGraphNode node : graph) {
            if (!indegree.containsKey(node)) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode n = queue.poll();
            result.add(n);
            for (DirectedGraphNode neig : n.neighbors) {
                indegree.put(neig, indegree.get(neig) - 1);
                if (indegree.get(neig) == 0) {
                    queue.offer(neig);
                }
            }
        }

        return result;
    }
}

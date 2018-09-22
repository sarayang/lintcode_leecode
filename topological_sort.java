package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-22.
 */
class DirectedNode {
    public int val;
    public ArrayList<DirectedNode> neighbours;
    DirectedNode(int value, ArrayList<DirectedNode> neig) {
        this.val = value;
        this.neighbours = neig;
    }
}
public class topological_sort {
    public ArrayList<DirectedNode> topologicalSort(ArrayList<DirectedNode> graph) {
        ArrayList<DirectedNode> result = new ArrayList<>();
        if (graph == null) {
            return result;
        }
        // a hashmap to record the indegree of each directed node
        HashMap<DirectedNode, Integer> indegreeMap = new HashMap<>();

        // double for loop since the neighbour has indegree instead of the current node,
        // current node has only outdegree
        for (DirectedNode node : graph) {
            for (DirectedNode neig : node.neighbours) {
                if (indegreeMap.containsKey(neig)) {
                    indegreeMap.put(neig, indegreeMap.get(neig) + 1);
                } else {
                    indegreeMap.put(neig, 1);
                }
            }
        }

        Deque<DirectedNode> queue = new LinkedList<>();
        for (DirectedNode node : graph) {
            if (!indegreeMap.containsKey(node)) {
                queue.offer(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedNode n = queue.poll();
            result.add(n);
            for (DirectedNode neigbour : n.neighbours) {
                indegreeMap.put(neigbour, indegreeMap.get(neigbour) - 1);
                if (indegreeMap.get(neigbour) == 0) {
                    queue.offer(neigbour);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DirectedNode n1 = new DirectedNode(1, new ArrayList<>());
        DirectedNode n2 = new DirectedNode(2, new ArrayList<>());
        DirectedNode n3 = new DirectedNode(3, new ArrayList<>());
        n1.neighbours.add(n2);
        n2.neighbours.add(n3);

        ArrayList<DirectedNode> re = new ArrayList<>();
        re.add(n1);
        re.add(n2);
        re.add(n3);

        topological_sort t = new topological_sort();
        t.anotherFunc();
        ArrayList<DirectedNode>  d = t.topologicalSort(re);
        for (DirectedNode i :  d) {
            System.out.println(i.val);
        }


    }

    public void func(int x) {
        x = x + 1;
    }

    public void anotherFunc() {
        int x = 0;
        func(x);
        System.out.println(x);
    }
}

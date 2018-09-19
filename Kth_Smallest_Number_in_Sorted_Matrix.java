package lintcode.lintcode_leecode;

import java.util.*;
/**
 * Created by YANGSONG on 2018-09-19.
 */

class Point {
    public int x;
    public int y;
    public int val;
    public Point(int x_cor, int y_cor, int value) {
        this.x = x_cor;
        this.y = y_cor;
        this.val = value;
    }
}
class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        return p1.val - p2.val;
    }
}

public class Kth_Smallest_Number_in_Sorted_Matrix {
    public int kthSmallest_CORRECT_VERSION(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        PriorityQueue<Point> minHeap =
                new PriorityQueue<>(Math.max(rows, cols), new PointComparator());

        // HashMap<Point, Boolean> hash = new HashMap<>();
        boolean[][] hash = new boolean[rows][cols];


        int[] dx = {1, 0};
        int[] dy = {0, 1};

        Point initial = new Point(0, 0, matrix[0][0]);
        hash[0][0] = true;
        minHeap.offer(initial);
        for (int i = 0; i < k - 1; i++) {
            Point p = minHeap.poll();
            for (int j = 0; j < 2; j ++) {
                System.out.println("initial: " + p.x + "," + p.y);
                int nextX = p.x + dx[j];
                int nextY = p.y + dy[j];

                if (nextX < rows && nextY < cols && !hash[nextX][nextY]) {
                    Point nextP = new Point(nextX, nextY, matrix[nextX][nextY]);

                    hash[nextX][nextY] = true;
                    minHeap.offer(nextP);

                }
            }
        }

        return minHeap.poll().val;
    }


    // my own version but only 18% test cases passed
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int counter = k;

        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        if (matrix[0][1] < matrix[1][0]) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (k > 0) {
                        heap.add(matrix[i][j]);
                        k--;
                    } else {
                        break;
                    }

                }
            }
        } else {

            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < rows; i++) {
                    if (k > 0) {
                        System.out.println(i + "," + j + ":" +matrix[j][i]);
                        heap.add(matrix[i][j]);
                        k--;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(heap);
        }

        int result = Integer.MAX_VALUE;
        while (counter > 0) {
            result = heap.poll();
            counter--;
        }

        return result;
    }
}

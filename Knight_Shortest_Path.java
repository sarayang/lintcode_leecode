package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by YANGSONG on 2018-09-09.
 */
public class Knight_Shortest_Path {
    public class Point {
        public int x, y;
        public Point() {
            x = 0; y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    private static final int[] DIRECTION_X = {1, 1, -1, -1, 2, 2, -2, -2};
    private static final int[] DIRECTION_Y = {2, -2, 2, -2, 1, -1, 1, -1};


    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return -1;
        }

//        Deque<Point> queue = new LinkedList<>();
//        queue.offer(source);
//
//        int[] directionX = new int[] {1, 1, -1, -1, 2, 2, -2, -2};
//        int[] directionY = new int[] {2, 2, -2, -2, 1, 1, -1, -1};
//
//        int step = 0;
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Point pt = queue.poll();
//                if (pt.x == destination.x && pt.y == destination.y) {
//                    return step;
//                }
//
//                for (int j = 0; j < 8; j++) {
//                    Point next = new Point(pt.x + directionX[j], pt.y + directionY[j]);
//                    if (inBound(grid, next) && !grid[next.x][next.y]) {
//                        queue.offer(next);
//                        grid[next.x][next.y] = true; // true = 1 (barrier), false = 0 (could use)
//                    }
//                }
//            }
//            step++;
//        }
//
//        return -1;



        Deque<Point> queue = new LinkedList<>();
        queue.offer(source);

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point pt = queue.poll();
                if (pt.x == destination.x && pt.y == destination.y) {
                    return step;
                }
                for (int j = 0; j < 8; j++) {
                    Point next = new Point(pt.x + DIRECTION_X[j], pt.y + DIRECTION_Y[j]);
                    if (inBound(grid, next) && !grid[next.x][next.y]) {
                        queue.offer(next);
                        grid[next.x][next.y] = true;
                    }
                }
            }
            step++;
        }
        return -1;


//        if (grid == null || grid.length == 0 || grid[0].length == 0) {
//            return -1;
//        }
//
//        n = grid.length;
//        m = grid[0].length;
//
//        Queue<Point> queue = new LinkedList<>();
//        queue.offer(source);
//
//        int steps = 0;
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Point point = queue.poll();
//                if (point.x == destination.x && point.y == destination.y) {
//                    return steps;
//                }
//
//                for (int direction = 0; direction < 8; direction++) {
//                    Point nextPoint = new Point(
//                            point.x + deltaX[direction],
//                            point.y + deltaY[direction]
//                    );
//
//                    if (!inBound(nextPoint, grid)) {
//                        continue;
//                    }
//
//                    queue.offer(nextPoint);
//                    // mark the point not accessible
//                    grid[nextPoint.x][nextPoint.y] = true;
//                }
//            }
//            steps++;
//        }
//
//        return -1;

    }

    private boolean inBound(boolean[][] grid, Point p) {
//        if (p.x < grid.length && p.y < grid[0].length && p.x >= 0 && p.y >= 0) {
//            return true;
//        }
//
//        return false;
        return p.x < grid.length && p.y < grid[0].length && p.x >= 0 && p.y >= 0;
    }

    public static void main(String[] args) {
        boolean[][] grid = {{false, false, false}, {false, false, false}, {false, false, false}};
        Knight_Shortest_Path k = new Knight_Shortest_Path();
        Point source = k.new Point(2, 0);
        Point target = k.new Point(2, 2);

        int des = k.shortestPath(grid, source, target);
        System.out.print(des);


    }

//    private boolean inBound(Point point, boolean[][] grid) {
//        if (point.x < 0 || point.x >= n) {
//            return false;
//        }
//        if (point.y < 0 || point.y >= m) {
//            return false;
//        }
//        return (grid[point.x][point.y] == false);
//    }

}

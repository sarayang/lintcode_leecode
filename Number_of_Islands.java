package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-09.
 */
public class Number_of_Islands {
    final static int[] directX = {-1, 1, 0, 0};
    final static int[] directY = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {

//        Deque<ArrayList<Integer>> queue = new LinkedList<>();
//        ArrayList<Integer> coordinate = new ArrayList<>();
//        coordinate.add(0);
//        coordinate.add(0);
//        queue.offer(coordinate);

        int land = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    land++;
                    grid[i][j] = '0';
                    dfsCheck(grid, i, j);
                }
            }
        }

        return land;
    }

    private void dfsCheck(char[][] grid, int x, int y) {
        if (grid[x][y] == '1') {
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (inbound(grid, x + directX[i], y + directY[i]) && grid[x + directX[i]][y + directY[i]] == '1') {
                grid[x + directX[i]][y + directY[i]] = '0';
                dfsCheck(grid, x + directX[i], y + directY[i]);
            }
        }
    }

    private boolean inbound(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }



    public static void main(String[] args) {
        Number_of_Islands n = new Number_of_Islands();
        char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};

        int step = n.numIslands(grid);
        System.out.println(step);
    }
}

package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-23.
 */
public class Word_Search_II {
    public static int[] xCoors = {-1, 1, 0, 0};
    public static int[] yCoors = {0, 0, -1, 1};

    public List<String> wordSearchII(char[][] board, List<String> words) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        HashMap<String, Boolean> prefixIsWord = getPrefixIsWord(words);
        // define it as hashset in order to remove duplicated case.
        HashSet<String> result = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < board[i].length; j++) {
                visited[i][j] = true;
                dfs(board, prefixIsWord, String.valueOf(board[i][j]), i, j, result, visited);
                visited[i][j] = false;
            }
        }

        return new ArrayList<>(result);
    }

    private void dfs(char[][] board,
                     HashMap<String, Boolean> prefixIsWord,
                     String s,
                     int x,
                     int y,
                     HashSet<String> result,
                     boolean[][] visited) {

        if (!prefixIsWord.containsKey(s)) {
            return;
        }

        if (prefixIsWord.get(s)) {
            result.add(s);
        }

        for (int i = 0; i < 4; i++) {
            int adjacentX = x + xCoors[i];
            int adjacentY = y + yCoors[i];

            if (!coorOnBoard(adjacentX, adjacentY, board) || visited[adjacentX][adjacentY]) {
                continue;
            }

            visited[adjacentX][adjacentY] = true;
            dfs(board, prefixIsWord, s + board[adjacentX][adjacentY], adjacentX, adjacentY, result, visited);
            visited[adjacentX][adjacentY] = false;
        }
    }

    private boolean coorOnBoard(int x, int y, char[][] board) {

        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private HashMap<String, Boolean> getPrefixIsWord(List<String> words) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                // this is the thing i need to pay attention. without this check
                // map will update the value of an existing key which will error out;
                if (!map.containsKey(prefix)) {
                    map.put(prefix, false);
                }
            }
            map.put(word, true);
        }

        System.out.println(map);

        return map;
    }
}

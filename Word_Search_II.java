package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-23.
 */
public class Word_Search_II {
    public static int[] xCoor = {-1, 1, 0, 0};
    public static int[] yCoor = {0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        if (board.length == 0 || board[0].length == 0 || words.length == 0) {
            return new ArrayList<>();
        }
        HashSet<String> result = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        HashMap<String, Boolean> prefixIsWord = getPrefix(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                dfs(i, j, board, String.valueOf(board[i][j]), prefixIsWord, visited, result);
                visited[i][j] = false;
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(int x,
                     int y,
                     char[][] board,
                     String word,
                     HashMap<String, Boolean> prefixMap,
                     boolean[][] visited,
                     HashSet<String> result) {
        if (!prefixMap.containsKey(word)) {
            return;
        }

        if (prefixMap.get(word)) {
            result.add(word);
        }

        for (int i = 0; i < 4; i++) {
            int adjacentX = x + xCoor[i];
            int adjacentY = y + yCoor[i];

            if (!coorOnBoard(adjacentX, adjacentY, board) || visited[adjacentX][adjacentY]) {
                continue;
            }
            visited[adjacentX][adjacentY] = true;
            dfs(adjacentX, adjacentY, board, word + board[adjacentX][adjacentY], prefixMap, visited, result);
            visited[adjacentX][adjacentY] = false;
        }
    }

    private boolean coorOnBoard(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }

    private HashMap<String, Boolean> getPrefix(String[] words) {
        HashMap<String, Boolean> prefixMap = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String prefix = word.substring(0, i + 1);
                if (!prefixMap.containsKey(prefix)) {
                    prefixMap.put(prefix, false);
                }
            }
            prefixMap.put(word, true);
        }
        return prefixMap;
    }
}

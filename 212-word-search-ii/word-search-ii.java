import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if (board == null || board.length == 0 ||
            board[0].length == 0) {
            return result;
        }

        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';

                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }

                node = node.children[index];
            }

            node.word = word;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c,
                     TrieNode node, List<String> result) {

        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#') return;

        TrieNode next = node.children[ch - 'a'];

        if (next == null) return;

        if (next.word != null) {
            result.add(next.word);
            next.word = null; // Avoid duplicate results.
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, next, result);
        dfs(board, r - 1, c, next, result);
        dfs(board, r, c + 1, next, result);
        dfs(board, r, c - 1, next, result);

        board[r][c] = ch;
    }
}
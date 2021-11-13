package leetcode.medium;

/**
 * https://leetcode.com/problems/word-search/
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean value = traverse(board, word, 0, i, j);
                if(value) return true;
            }
        }
        return false;
    }

    public boolean traverse(char[][] board, String word, int wordIndex, int i, int j) {
        if (i > board.length - 1 || i < 0 || j < 0 || j > board[0].length - 1 || wordIndex > word.length() - 1) {
            return false;
        }
        if (board[i][j] == word.charAt(wordIndex) && word.length() - 1 == wordIndex) {
            return true;
        }
        if(board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        board[i][j] += 256;
        if (traverse(board, word, wordIndex + 1, i + 1, j)
                || traverse(board, word, wordIndex + 1, i, j + 1)
                || traverse(board, word, wordIndex + 1, i - 1, j)
                || traverse(board, word, wordIndex + 1, i, j - 1)) {
            return true;
        }
        board[i][j] -= 256;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(board, "ABCCEDD"));
    }

}

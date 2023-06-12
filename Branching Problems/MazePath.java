import java.util.*;

public class MazePath {
    public static void main(String[] args) {
        int boardSize = 4;
        System.out.println(getAllPath(boardSize));
    }

    public static ArrayList<ArrayList<String>> getAllPath(int size) {
        int[][] board = new int[size][size];
        return findPath(board, 0, 0, "");
    }

    public static ArrayList<ArrayList<String>> findPath(int[][] board, int row, int col, String path) {
        ArrayList<ArrayList<String>> list1 = new ArrayList<>();
        if (row == board.length - 1 && col == board.length - 1) {
            ArrayList<String> li = new ArrayList<String>();
            li.add(path);
            list1.add(new ArrayList<>(li));
            return list1;
        }
        ArrayList<ArrayList<String>> list2 = new ArrayList<>();
        if (row < board.length && col < board.length) {
            list1 = findPath(board, row, col + 1, path + "R");
            list2 = findPath(board, row + 1, col, path + "D");
        }
        list1.addAll(list2);
        return list1;
    }

}
import java.util.*;
public class Branching {
    public static void main(String [] args){
        int n = 5;
        boolean [][] visited = new boolean[n][n];
        int [][] board = new int[n][n];
        ArrayList<ArrayList<String>> list = findPath(board  , 0, 0 ,"" );
        System.out.println("Possible ways to reach to last :"+list);
        ArrayList<ArrayList<Integer>> list1 = findCombinations(13 , 1,6 , new ArrayList<Integer>());
        System.out.println("Possible combinations :"+list1);

    }

    public static ArrayList<ArrayList<String>> findPath(int [][] board  ,int row , int col , String path){
        ArrayList<ArrayList<String>>  list1 = new ArrayList<>();
        if(row == board.length-1 && col == board.length-1 ){
            ArrayList<String> li = new ArrayList<String>();
            li.add(path);
            list1.add(new ArrayList<>(li));
            return list1;
        }
        ArrayList<ArrayList<String>>  list2 = new ArrayList<>();
        if( row < board.length && col <board.length){
            list1 = findPath(board  ,row , col+1 , path+"R");
            list2 = findPath(board  ,row+1 , col , path+"D");
        }
        list1.addAll(list2) ;
        return list1;
    }
    public static ArrayList<ArrayList<Integer>> findCombinations(int board,int number  ,int dice  , List<Integer> li){
        ArrayList<ArrayList<Integer>>  list1 = new ArrayList<>();
        if(board == 0){
            list1.add(new ArrayList(li));
            return list1;
        }
        ArrayList<ArrayList<Integer>>  list2 = new ArrayList<>();
            if(number<=dice && (board-number)>=0){
                li.add(number);
                list1 = findCombinations(board-number ,number,  dice , li  );
                li.remove(li.size()-1);
                list2 = findCombinations(board,number+1 , dice , li);
            }
        list1.addAll(list2) ;
        return list1;
    }

}

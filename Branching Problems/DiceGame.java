import java.util.*;

public class DiceGame {
    public static void main(String[] args) {
        int totalNumberOnDice = 6;
        int targetNumber = 10;
        System.out.println(findCombinations(targetNumber, totalNumberOnDice));
    }

    public static ArrayList<ArrayList<Integer>> findCombinations(int target, int dice) {
        return Combinations(target, 1, dice, new ArrayList<>(dice));
    }

    public static ArrayList<ArrayList<Integer>> Combinations(int board, int number, int dice, List<Integer> li) {
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        if (board == 0) {
            list1.add(new ArrayList(li));
            return list1;
        }
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        if (number <= dice && (board - number) >= 0) {
            li.add(number);
            list1 = Combinations(board - number, number, dice, li);
            li.remove(li.size() - 1);
            list2 = Combinations(board, number + 1, dice, li);
        }
        list1.addAll(list2);
        return list1;
    }

}

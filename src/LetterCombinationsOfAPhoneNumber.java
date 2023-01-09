import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 */
public class LetterCombinationsOfAPhoneNumber {
    
    public List<String> letterCombinations(String digits) {
        HashMap<Character,List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        if (digits == null) return null;

        if (digits.isEmpty()) return new ArrayList<>();

        LinkedList<String> tempList = new LinkedList<>();
        tempList.add("");
        for (int i = 0; i < digits.length(); i++) {
            int size = tempList.size();
            for (int j = 0; j < size; j++) {
                String prefix = tempList.pop();
                List<Character> chars = map.get(digits.charAt(i));
                for (Character c : chars) {
                    tempList.add(prefix + c);
                }
            }
        }

        return tempList;
    }
}

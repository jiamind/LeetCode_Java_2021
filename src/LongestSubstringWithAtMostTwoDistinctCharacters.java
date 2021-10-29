import java.util.HashSet;
import java.util.Set;

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 1) return s.length();

        char[] array = s.toCharArray();
        Set<Character> set = new HashSet<>();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            set.clear();
            set.add(array[i]);
            for (int j = i + 1; j < array.length; j++) {
                set.add(array[j]);
                if (set.size() <= 2) {
                    result = Math.max(result, j - i + 1);
                } else if (set.size() == 3) {
                    break;
                }
            }
        }

        return result;
    }
}

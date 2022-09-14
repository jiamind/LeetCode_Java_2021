import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) return s.length();

        int startIndex = 0, endIndex = 0, maxLength = 0;
        Set<Character> set = new HashSet<>();
        
        while (endIndex < s.length()) {
            if (!set.contains(s.charAt(endIndex))) {
                set.add(s.charAt(endIndex));
            } else {
                maxLength = Math.max(maxLength, endIndex - startIndex);
                while (s.charAt(startIndex) != s.charAt(endIndex)) {
                    set.remove(s.charAt(startIndex));
                    startIndex++;
                }
                startIndex++;
            }
            endIndex++;
        }

        maxLength = Math.max(maxLength, endIndex - startIndex);

        return maxLength;
    }
}

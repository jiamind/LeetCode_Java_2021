/**
 * 242. Valid Anagram
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int base = 'a';
        int[] map = new int[26];
        int length = s.length();
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i) - base]++;
        }

        for (int i = 0; i < t.length(); i++) {
            if (map[t.charAt(i) - base] <= 0) {
                return false;
            }

            map[t.charAt(i) - base]--;
            length--;
        }

        return length == 0;
    }
}

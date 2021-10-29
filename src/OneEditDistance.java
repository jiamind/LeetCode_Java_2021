/**
 * 161. One Edit Distance
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1) return false;

        if (s.length() < t.length()) {
            // insert one char in s
            int offset = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i + offset)) continue;
                if (offset != 0) return false;
                offset++;
                i--;
            }

            return true;
        } else if (s.length() == t.length()) {
            // exact match or replace one char in s
            boolean replaced = false;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(i)) continue;
                if (replaced) return false;
                replaced = true;
            }

            return replaced;
        } else {
            // delete one char in s
            int offset = 0;
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i + offset) == t.charAt(i)) continue;
                if (offset != 0) return false;
                offset++;
                i--;
            }

            return true;
        }
    }
}

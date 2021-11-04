/**
 * 5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    // dp[i][j]: true if substring from index i to j (inclusive) is palindromic.
    public String longestPalindrome_dp(String s) {
        if (s.length() == 0) return "";
        int startIndex = 0, endIndex = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i > 0) {
                dp[i][i - 1] = true;
            }
        }

        // i: center index; j: expand size.
        for (int j = 1; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + j < s.length() && i - j >= 0) {
                    // odd
                    dp[i - j][i + j] = dp[i - j + 1][i + j - 1] && (s.charAt(i - j) == s.charAt(i + j));
                    if (dp[i - j][i + j] && 2 * j > endIndex - startIndex) {
                        startIndex = i - j;
                        endIndex = i + j;
                    }
                }
            }
        }

        // i: center left index; j: expand size.
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < s.length(); i++) {
                if (i + j + 1 < s.length() && i - j >= 0) {
                    // even
                    dp[i - j][i + j + 1] = dp[i - j + 1][i + j] && (s.charAt(i - j) == s.charAt(i + j + 1));
                    if (dp[i - j][i + j + 1] && 2 * j + 1 > endIndex - startIndex) {
                        startIndex = i - j;
                        endIndex = i + j + 1;
                    }
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 0) return s;

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] odd = palindromeHalfLength(s, i, i);
            int[] even = palindromeHalfLength(s, i, i + 1);
            if (odd[1] - odd[0] > endIndex - startIndex) {
                startIndex = odd[0];
                endIndex = odd[1];
            }

            if (even[1] > even[0] && even[1] - even[0] > endIndex - startIndex) {
                startIndex = even[0];
                endIndex = even[1];
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

    private int[] palindromeHalfLength(String s, int leftIndex, int rightIndex) {
        int[] indexes = new int[2];
        int i = 0;
        for (; leftIndex - i >= 0 && rightIndex + i < s.length(); i++) {
            if (s.charAt(leftIndex-i) != s.charAt(rightIndex+i)) {
                indexes[0] = leftIndex-i + 1;
                indexes[1] = rightIndex+i -1;
                return indexes;
            }
        }
        indexes[0] = leftIndex-i + 1;
        indexes[1] = rightIndex+i -1;
        return indexes;
    }
}

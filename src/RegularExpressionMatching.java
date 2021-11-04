/**
 * 10. Regular Expression Matching
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s.length(); i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= p.length(); i++) {
            if (i == 1) {
                dp[0][1] = false;
            } else {
                dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
            }
        }

        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                dp[j][i] = (dp[j - 1][i - 1] && (s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '.')) || // exact match or any single char
                        (p.charAt(i - 1) == '*' && (dp[j][i - 2] ||   // empty char
                                p.charAt(i - 2) == '.' && dp[j - 1][i] || // any char
                                s.charAt(j - 1) == p.charAt(i - 2) && dp[j - 1][i]));   // last char
            }
        }

        return dp[s.length()][p.length()];
    }
}

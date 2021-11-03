/**
 * 186. Reverse Words in a String II
 */
public class ReverseWordsInAStringII {
    public void reverseWords(char[] s) {
        reverseSubString(s, 0, s.length - 1);

        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] != ' ') continue;
            reverseSubString(s, start, i - 1);
            start = i + 1;
        }

        reverseSubString(s, start, s.length - 1);
    }

    private void reverseSubString(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

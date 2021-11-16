import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 68. Text Justification
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        if (words == null) return null;

        if (words.length == 0) return Collections.emptyList();

        List<String> result = new ArrayList<>();
        List<String> lineOfWords = new ArrayList<>();
        lineOfWords.add(words[0]);
        int lineLen = words[0].length();

        for (int i = 1; i < words.length; i++) {
            if (lineLen + words[i].length() + 1 > maxWidth) {
                result.add(formatLine(lineOfWords, maxWidth,false));
                lineOfWords.clear();
                lineOfWords.add(words[i]);
                lineLen = words[i].length();
            } else {
                lineOfWords.add(words[i]);
                lineLen = lineLen + words[i].length() + 1;
            }
        }

        result.add(formatLine(lineOfWords, maxWidth, true));

        return result;
    }

    private String formatLine(List<String> words, int maxWidth, boolean isLastLine) {
        if (isLastLine || words.size() <= 1) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.join(" ", words));
            int len = sb.length();
            for (int i = len; i < maxWidth; i++) {
                sb.append(" ");
            }

            return sb.toString();
        } else {
            int wordLen = words.stream().map(w -> w.length()).reduce(0,Integer::sum);
            int numOfSpaces = maxWidth - wordLen;
            int defaultSpace = numOfSpaces / (words.size() - 1);
            int extraSpaces = numOfSpaces % (words.size() - 1);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < words.size() - 1; i++) {
                sb.append(words.get(i));
                sb.append(" ".repeat(defaultSpace));
                if (extraSpaces > 0) {
                    sb.append(" ");
                    extraSpaces--;
                }
            }

            sb.append(words.get(words.size() - 1));

            return sb.toString();
        }
    }
}

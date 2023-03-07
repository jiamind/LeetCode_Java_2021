import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // fail fast if beginWord equals endWord
        if (beginWord.equals(endWord)) return 0;

        // convert wordList of List to Set for O(1) lookup
        Set<String> wordSet = new HashSet<String>(wordList);
        // fail fast if wordSet doesn't contain endWord
        if (!wordSet.contains(endWord)) return 0;

        // a set to record visited word (to avoid loop)
        Set<String> visited = new HashSet<String>();

        int result = 1;
        // A queue for BFS at each level
        Queue<String> level = new LinkedList<>();
        level.add(beginWord);
        while (!level.isEmpty()) {
            int size = level.size();
            for (int i = 0; i < size; i++) {
                String currentWord = level.poll();
                if (currentWord.equals(endWord)) {
                    return result;
                }

                if (!visited.contains(currentWord)) {
                    visited.add(currentWord);
                    for (int j = 0; j < currentWord.length(); j++) {
                        StringBuilder sb = new StringBuilder(currentWord);
                        for (int k = 0; k < 26; k++) {
                            sb.setCharAt(j, (char) ('a' + k));
                            if (wordSet.contains(sb.toString())) level.add(sb.toString());
                        }
                    }
                }
            }

            result++;
        }

        return 0;
    }
}

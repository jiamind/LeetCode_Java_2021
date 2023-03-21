import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 126. Word Ladder II
 * Idea: BFS. Remember paths in a Map then build the path output list.
 * Time complexity: 
 * |- Need to visit each one of the word in the wordlist;
 * |- For each char in the word, replace it with all possible characters
 * |- Add to parent map happens at each level, each word can only add as parent once
 * |- Therefore: M is length of word, N is number of words, E is the number of edges in the graph. 
 * |- O(N * M + N + E)
 * Space complexity:
 * |- <Set> wordSet: O(N * M)
 * |- <Map> parents: O(N * M)
 * |- <Queue> level: O(N * M)
 * |- <Map> levelParents: O(N * M)
 * |- O(N * M)
 */
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();        

        // fail fast if beginWord equals endWord
        if (beginWord.equals(endWord)) return result;

        // convert wordList of List to Set for O(1) lookup
        Set<String> wordSet = new HashSet<String>(wordList);
        // fail fast if wordSet doesn't contain endWord
        if (!wordSet.contains(endWord)) return result;

        // a map to keep track of how we arrive at each word
        // key is the current word, the value is a list of parents
        // since there can be multiple words transform to a word (hot, dot -> lot)
        Map<String,List<String>> parents = new HashMap<>();

        // A queue for BFS at each level
        Queue<String> level = new LinkedList<>();
        level.add(beginWord);
        parents.put(beginWord, null);
        boolean found = false;
        while (!level.isEmpty() && !found) {
            int size = level.size();
            // a map for storing parents for the current level
            // multiple words can transform to a word at the same level 
            // (all are shortest paths to the word)
            Map<String,List<String>> levelParents = new HashMap<>();
            for (int i = 0; i < size; i++) {
                String currentWord = level.poll();
                if (currentWord.equals(endWord)) {
                    found = true;
                    break;
                }

                for (int j = 0; j < currentWord.length(); j++) {
                    StringBuilder sb = new StringBuilder(currentWord);
                    for (int k = 0; k < 26; k++) {
                        sb.setCharAt(j, (char) ('a' + k));
                        if (wordSet.contains(sb.toString())) {
                            // if this word has seen previously on the same level, 
                            // add it to the level parent map because it has multiple parents
                            // (all are shortest paths to the word)
                            if (levelParents.containsKey(sb.toString())) {
                                levelParents.get(sb.toString()).add(currentWord);
                            // Otherwise, it's the first time we see this word.
                            // we do not add parent if the word is seen before the current level because then this is not a shortest path.
                            } else if (!parents.containsKey(sb.toString())) {
                                List<String> plist = new ArrayList<>();
                                plist.add(currentWord);
                                levelParents.put(sb.toString(), plist);
                                level.add(sb.toString());
                            }
                        }
                    }
                }
            }

            parents.putAll(levelParents);
        }

        if (!found) return result;

        // find a path from the endWord to the beginWord
        findPath(beginWord, endWord, parents, new ArrayList<String>(), result);

        return result;
    }

    public void findPath(String targetWord, String currentWord, Map<String,List<String>> parents, List<String> currentPath, List<List<String>> result) {
        currentPath.add(currentWord);

        if (currentWord.equals(targetWord)) {
            Collections.reverse(currentPath);
            result.add(currentPath);
            return;
        }

        List<String> parentList = parents.get(currentWord);
        for (String parent : parentList) {
            findPath(targetWord, parent, parents, new ArrayList<>(currentPath), result);
        }
    }
}

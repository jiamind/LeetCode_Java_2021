/**
 * 245. Shortest Word Distance III
 */
public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int lastSeenWord1Index = -1, lastSeenWord2Index = -1;
        int dist = wordsDict.length;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1) && wordsDict[i].equals(word2)) {
                if (lastSeenWord1Index >= 0) {
                    dist = Math.min(dist, Math.abs(lastSeenWord1Index - i));
                }

                lastSeenWord1Index = i;
            } else if (wordsDict[i].equals(word1)) {
                lastSeenWord1Index = i;
                if (lastSeenWord2Index >= 0) {
                    dist = Math.min(dist, Math.abs(lastSeenWord1Index - lastSeenWord2Index));
                }
            } else if (wordsDict[i].equals(word2)) {
                lastSeenWord2Index = i;
                if (lastSeenWord1Index >= 0) {
                    dist = Math.min(dist, Math.abs(lastSeenWord1Index - lastSeenWord2Index));
                }
            }
        }

        return dist;
    }
}

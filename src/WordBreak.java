import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>(wordDict);
        Boolean[] memory = new Boolean[s.length()+1];

        return isBreakable(s, 0, dictionary, memory);
    }

    private boolean isBreakable(String s, int index, Set<String> dictionary, Boolean[] memory) {
        if (index > s.length() - 1) return true;
        
        if (memory[index] != null) {
            return memory[index];
        }
        
        StringBuilder sb = new StringBuilder();

        boolean breakable = false;
        for (int i = index; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (dictionary.contains(sb.toString())) {
                breakable = isBreakable(s, i+1, dictionary, memory);
                memory[i+1] = breakable; 
                if (breakable) break;
            }
        }

        return breakable;
    }
}

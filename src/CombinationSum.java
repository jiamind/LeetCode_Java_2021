import java.util.ArrayList;
import java.util.List;

/**
 * 39. Combination Sum
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int index) {
        List<List<Integer>> result = new ArrayList<>();

        if (target < 0) return result;

        if (target == 0) {
            result.add(new ArrayList<>());
            return result;
        }


        for (int i = index; i < candidates.length; i++) {
            List<List<Integer>> combinations = combinationSum(candidates, target - candidates[i], i);
            for (List<Integer> combination : combinations) {
                List<Integer> copy = new ArrayList<>(combination);
                copy.add(candidates[i]);
                result.add(copy);
            }
        }

        return result;
    }
}
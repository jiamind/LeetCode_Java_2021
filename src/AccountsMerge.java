import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 721. Accounts Merge
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String,HashMap<String,Integer>> nameEmailIndexMap = new HashMap<>();
        int[] indexMap = new int[accounts.size()];
        for (int i = 0; i < indexMap.length; i++) {
            indexMap[i] = i;
        }

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            if (!nameEmailIndexMap.containsKey(name)) nameEmailIndexMap.put(name, new HashMap<>());
            
            HashMap<String,Integer> emailIndexMap = nameEmailIndexMap.get(name);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailIndexMap.containsKey(email)) {
                    indexMap[getParent(i,indexMap)] = getParent(emailIndexMap.get(email), indexMap);
                    continue;
                }
                
                emailIndexMap.put(email, i);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String,HashMap<String,Integer>> nameEmailIndexMapEntry : nameEmailIndexMap.entrySet()) {
            String name = nameEmailIndexMapEntry.getKey();
            HashMap<Integer,List<String>> indexEmailMap = new HashMap<>();
            for (Map.Entry<String,Integer> emailIndexMapEntry : nameEmailIndexMapEntry.getValue().entrySet()) {
                int parent = getParent(emailIndexMapEntry.getValue(), indexMap);
                if (!indexEmailMap.containsKey(parent)) indexEmailMap.put(parent, new ArrayList<>());
                indexEmailMap.get(parent).add(emailIndexMapEntry.getKey());
            }
            
            List<List<String>> nameEmailList = new ArrayList<>();
            for(Map.Entry<Integer, List<String>> entry : indexEmailMap.entrySet()) {
                List<String> emailList = new ArrayList<>(entry.getValue());
                Collections.sort(emailList);
                emailList.add(0, name);
                nameEmailList.add(emailList);
            }

            result.addAll(nameEmailList);
        }

        return result;
    }

    private int getParent(int index, int[] indexMap) {
        if (indexMap[index] == index) return index;

        return getParent(indexMap[index], indexMap);
    }
}

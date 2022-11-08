import java.util.HashMap;
import java.util.TreeMap;

/**
 * 981. Time Based Key-Value Store
 */
public class TimeMap {

    HashMap<String, TreeMap<Integer,String>> map;
    
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            TreeMap<Integer,String> tmap = map.get(key);
            tmap.put(timestamp, value);
        } else {
            TreeMap<Integer,String> tmap = new TreeMap<>();
            tmap.put(timestamp, value);
            map.put(key, tmap);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer,String> tmap = map.get(key);

        Integer floorKey = tmap.floorKey(timestamp);

        return floorKey == null ? "" : tmap.get(floorKey);
    }
}

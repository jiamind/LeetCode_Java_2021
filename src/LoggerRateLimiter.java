import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter
 */
public class LoggerRateLimiter {

    Map<String, Integer> messageLastPrintTimeMap;

    public LoggerRateLimiter() {
        messageLastPrintTimeMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if(!messageLastPrintTimeMap.containsKey(message) || timestamp - messageLastPrintTimeMap.get(message) >= 10) {
            messageLastPrintTimeMap.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * 388. Longest Absolute File Path
 */
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        List<Integer> lengthToDepth = new ArrayList<>();
        int maxFileLength = 0;

        String[] paths = input.split("\n");
        for (String path : paths) {
            int depth = 0;
            int pointer = 0;
            char[] array = path.toCharArray();

            while (pointer < path.length() && array[pointer] == '\t') {
                depth++;
                pointer++;
            }

            String directoryOrFileName = String.copyValueOf(array, pointer, array.length - pointer);
            boolean isFile = directoryOrFileName.contains(".");
            if (isFile) {
                int length = (depth == 0 ? 0 : lengthToDepth.get(depth - 1)) + depth + directoryOrFileName.length();
                maxFileLength = Math.max(maxFileLength, length);
            } else {
                if (lengthToDepth.size() < depth + 1) {
                    lengthToDepth.add((depth == 0 ? 0 : lengthToDepth.get(depth - 1)) + directoryOrFileName.length());
                } else {
                    lengthToDepth.set(depth, (depth == 0 ? 0 : lengthToDepth.get(depth - 1)) + directoryOrFileName.length());
                }
            }
        }

        return maxFileLength;
    }
}

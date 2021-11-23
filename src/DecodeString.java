/**
 * 394. Decode String
 */
public class DecodeString {

    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;

        int p = 0;
        char[] array = s.toCharArray();
        StringBuilder resultBuilder = new StringBuilder();
        while (p < array.length) {
            if (Character.isAlphabetic(array[p])) {
                resultBuilder.append(array[p]);
                p++;
            } else {
                StringBuilder kBuilder = new StringBuilder();
                while (Character.isDigit(array[p])) {
                    kBuilder.append(array[p]);
                    p++;
                }
                int k = Integer.valueOf(kBuilder.toString());
                if (array[p] == '[') {
                    // find closing ']'
                    p++;
                    int startIndex = p;
                    int count = -1;
                    while (count != 0 && p < array.length) {
                        if (array[p] == '[') {
                            count--;
                        } else if (array[p] == ']') {
                            count++;
                        }
                        p++;
                    }
                    String innerDecodedString = decodeString(s.substring(startIndex, p-1));
                    for (int i = 0; i < k; i++) {
                        resultBuilder.append(innerDecodedString);
                    }
                } else {
                    resultBuilder.append(kBuilder.toString());
                }
            }
        }

        return resultBuilder.toString();
    }
}

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (freq.get(ch) == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        char result1 = findFirstNonRepeatingChar("swiss");
        if (result1 != '\0') {
            System.out.println("First Non-Repeating Character: '" + result1 + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }

        char result2 = findFirstNonRepeatingChar("aabbcc");
        if (result2 != '\0') {
            System.out.println("First Non-Repeating Character: '" + result2 + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
}

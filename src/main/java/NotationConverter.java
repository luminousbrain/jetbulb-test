import java.util.HashMap;
import java.util.Map;

public class NotationConverter {
    private final static Map<Character, Integer> converterMap = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int toArabic(String romanNotation) throws InvalidValueException {
        if (romanNotation == null || romanNotation.isEmpty() || !romanNotation.matches("[IVXLCDM]*")) {
            throw new InvalidValueException("String must contain only valid roman numerals [I, V, X, L, C, D, M].");
        }
        final int length = romanNotation.length() - 1;
        int result = converterMap.get(romanNotation.charAt(length));
        for (int i = 0; i < length;) {
            int left = converterMap.get(romanNotation.charAt(i));
            int right = converterMap.get(romanNotation.charAt(++i));
            if (right > left) {
                result -= left;
            } else {
                result += left;
            }
        }
        return result;
    }
}

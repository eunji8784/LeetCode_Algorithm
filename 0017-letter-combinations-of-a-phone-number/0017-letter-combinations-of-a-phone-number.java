import java.util.*;

class Solution {
    private static final char[][] DIGITS = { {}, {}, { 'a', 'b', 'c' }, { 'd', 'e', 'f' }, { 'g', 'h', 'i' },
            { 'j', 'k', 'l' }, { 'm', 'n', 'o' }, { 'p', 'q', 'r', 's' }, { 't', 'u', 'v' }, { 'w', 'x', 'y', 'z' } };

    private static int n;
    private static List<String> result;
    private static int[] digit;

    public List<String> letterCombinations(String digits) {
        n = digits.length();
        result = new ArrayList<>();

        if (n != 0) {
            digit = new int[n];
            for (int i = 0; i < n; i++) {
                digit[i] = digits.charAt(i) - '0';
            }
            solve(0, "");
        }

        return result;
    }

    private static void solve(int index, String letter) {
        if (index == n) {
            result.add(letter);
            return;
        }

        char[] arr = DIGITS[digit[index]];

        for (int i = 0; i < arr.length; i++) {
            solve(index + 1, letter + arr[i]);
        }
    }
}
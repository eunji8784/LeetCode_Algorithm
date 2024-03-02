import java.util.*;

class Solution {
    private static final String[] DIGITS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static List<String> result;

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        
        result = new ArrayList<>();
        solve(0, "", digits);
        
        return result;
    }

    private static void solve(int index, String letter, String digits) {
        if (index == digits.length()) {
            result.add(letter);
            return;
        }

        String arr = DIGITS[digits.charAt(index) - '0'];

        for (int i = 0; i < arr.length(); i++) {
            solve(index + 1, letter + arr.charAt(i), digits);
        }
    }
}
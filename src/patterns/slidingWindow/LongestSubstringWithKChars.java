package patterns.slidingWindow;

import java.util.HashMap;

public class LongestSubstringWithKChars {
    /*
     * Given a string, find the length of the longest substring in it with no more than K distinct characters.
     * */
    public static int findLongestSubstringWithKDisctinctChars(int k, String word) {
        if (word == null || word.length() == 0) return 0;
        int windowStart = 0;
        int maxLength = 0;
        int wordLength = word.length();
        HashMap<Character, Integer> charFrequency = new HashMap<>();
        for (int windowEnd = 0; windowEnd < wordLength; windowEnd++) {
            char right = word.charAt(windowEnd);
            charFrequency.put(right, charFrequency.getOrDefault(right, 0) + 1);

            while (charFrequency.size() > k) {
                char left = word.charAt(windowStart);
                charFrequency.put(left, charFrequency.get(left) - 1);
                if (charFrequency.get(left) == 0) {
                    charFrequency.remove(left);

                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int res = findLongestSubstringWithKDisctinctChars(2, "araaci");
        System.out.println(res);
    }
}

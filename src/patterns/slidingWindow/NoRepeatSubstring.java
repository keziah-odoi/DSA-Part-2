package patterns.slidingWindow;

import java.util.HashMap;

/*
 * Given a string, find the length of the longest substring which has no repeating characters.
 * */
public class NoRepeatSubstring {
    public static int findLongestSubstringWithoutRepeatChars(String word) {
        if (word == null || word.equals("")) return 0;
        int maxLength = 0;
        int windowStart = 0;
        int length = word.length();
        HashMap<Character, Integer> charFreqMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            char right = word.charAt(windowEnd);
            charFreqMap.put(right, charFreqMap.getOrDefault(right, 0) + 1);

            while (charFreqMap.get(right) >= 2) {
                charFreqMap.put(right, charFreqMap.get(right) - 1);
                if (charFreqMap.get(right) == 0)
                    charFreqMap.remove(right);
                windowStart = windowEnd;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        int res = findLongestSubstringWithoutRepeatChars("aabccbb");
        int res2 = findLongestSubstringWithoutRepeatChars("abbbb");
        int res3 = findLongestSubstringWithoutRepeatChars("abccde");
        int res4 = findLongestSubstringWithoutRepeatChars("");

        System.out.println(res);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
    }
}

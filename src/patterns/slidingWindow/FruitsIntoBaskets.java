package patterns.slidingWindow;

import java.util.HashMap;

public class FruitsIntoBaskets {
    public static int findMaxNumberOfFruits(char[] treeArray) {
        if (treeArray == null || treeArray.length == 0) return 0;
        HashMap<Character, Integer> fruitFreq = new HashMap<>();
        int windowStart = 0;
        int maxFruits = 0;
        int length = treeArray.length;
        for (int windowEnd = 0; windowEnd < length; windowEnd++) {
            char fruit = treeArray[windowEnd];
            fruitFreq.put(fruit, fruitFreq.getOrDefault(fruit, 0) + 1);

            while (fruitFreq.size() > 2) {
                char removeFruit = treeArray[windowStart];
                fruitFreq.put(removeFruit, fruitFreq.get(removeFruit) - 1);
                if (fruitFreq.get(removeFruit) == 0) {
                    fruitFreq.remove(removeFruit);
                }
                windowStart++;
            }
            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);

        }
        return maxFruits;

    }

    public static void main(String[] args) {
        int res = findMaxNumberOfFruits(new char[]{'A', 'B', 'C', 'A', 'C'});
        int res2 = findMaxNumberOfFruits(new char[]{'A', 'B', 'C', 'B', 'B', 'C'});
        System.out.println(res);
        System.out.println(res2);
    }
}

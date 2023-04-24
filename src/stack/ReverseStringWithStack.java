package stack;

import java.util.Stack;

public class ReverseStringWithStack {

    public static String reverseString(String word){
      char[] charArray = word.toCharArray();
      Stack<Character> charStack = new Stack<>();
      for (char letter:charArray) {
          charStack.push(letter);
      }
      StringBuilder reversedWord = new StringBuilder();
      int length = word.length()-1;
      while (length>=0){
          reversedWord.append(charStack.pop());
          //StringBuilder.append() is preferred here because java string concatenation creates a new String object each time.
          length--;
      }
      return reversedWord.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
        System.out.println(reverseString("orange is the new black123"));
    }
}

package leetcode.easy;

public class ReverseString {
    /* LeetCode Question 344 - Reverse String */

    /* Reverse string with O(1) extra memory
    */
    public void reverseString(char[] s) {
        int length = s.length;
        int j=1;
        for (int i=0; i<length/2; i++){
            char temp = s[i];
            s[i] = s[length-j];
            s[length-j]=temp;
            j++;
        }
    }


}

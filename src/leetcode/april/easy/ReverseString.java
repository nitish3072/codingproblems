package leetcode.april.easy;

/**
 * https://leetcode.com/problems/reverse-string/
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int firstPointer = 0;
        int lastPointer = s.length-1;
        while (firstPointer<lastPointer) {
            char temp = s[firstPointer];
            s[firstPointer] = s[lastPointer];
            s[lastPointer] = temp;
            firstPointer++;lastPointer--;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        char[] chars = {'h','e','l','l','o'};
        reverseString.reverseString(chars);
        System.out.println("Hello");
    }
}

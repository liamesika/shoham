/** Checks if a given string is a palindrome. */
public class Palindrome {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Palindrome <string>");
            System.out.println("Example: java Palindrome kayak");
            return;
        }
        System.out.println(isPalindrome(args[0]));
    }

    /** Checks if the given string is a palindrome. */
    public static boolean isPalindrome(String s) {
        int a = s.length();

        if (a <= 1) {
            return true;
        }

        if (s.charAt(0) != s.charAt(a - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, a - 1));
    }
}

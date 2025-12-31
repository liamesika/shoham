/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);;
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    public static String toBinary(int x) {
        // Base cases
        if (x == 0) {
            return "0";
        }
        if (x == 1) {
            return "1";
        }
        return toBinary(x / 2) + (x % 2);
    }    
 }

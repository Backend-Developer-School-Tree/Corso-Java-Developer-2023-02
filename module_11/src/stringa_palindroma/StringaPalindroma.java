package stringa_palindroma;

public class StringaPalindroma {
    public static boolean isPalindrome(String str) {
        if (str.length() == 1) return true;
        if (str.length() == 0) return true;

        if (str.charAt(0) != str.charAt(str.length()-1))
            return false;

        return isPalindrome(str.substring(1, str.length()-1));
    }

    public static boolean isPalindrome2(String str) {
        return isPalindrome2(str, 0, str.length()-1);
    }

    private static boolean isPalindrome2(String str, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) return true;
        if (leftIndex > rightIndex) return true;

        if (str.charAt(leftIndex) != str.charAt(rightIndex)) return false;

        return isPalindrome2(str, ++leftIndex, --rightIndex);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("itopinonavevanonipoti"));
        System.out.println(isPalindrome2("itopinonavevanonipoti"));
    }
}

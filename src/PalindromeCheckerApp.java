import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input text:");
        String word = sc.nextLine();
        boolean isPalindrome;
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--)
        {
            reversed = reversed + word.charAt(i);
        }

        // Compare original and reversed using equals()
        if (word.equals(reversed))
        {
            isPalindrome = true;
        }
        else
        {
            isPalindrome = false;
        }
        System.out.println("Is it a Palindrome? : " +isPalindrome);
    }
}
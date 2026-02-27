import java.util.*;
public class PalindromeCheckerApp {



        // Method to check palindrome
        public static boolean isPalindrome(String input) {

            // 1. Normalize string
            String processed = input
                    .replaceAll("\\s+", "")   // Remove spaces
                    .toLowerCase();           // Convert to lowercase

            int start = 0;
            int end = processed.length() - 1;

            // 2. Apply palindrome logic
            while (start < end) {
                if (processed.charAt(start) != processed.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            if (isPalindrome(input)) {
                System.out.println("Palindrome (Ignoring case & spaces)");
            } else {
                System.out.println("Not Palindrome");
            }

            scanner.close();
        }
    }
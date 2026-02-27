import java.util.Scanner;
import java.util.Stack;

// Service class (Encapsulation)
class PalindromeChecker {

    public boolean checkPalindrome(String input) {

        // Normalize string (ignore spaces and case)
        String processed = input
                .replaceAll("\\s+", "")
                .toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters to stack
        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters
        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PalindromeChecker checker = new PalindromeChecker();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (checker.checkPalindrome(input)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        scanner.close();
    }
}
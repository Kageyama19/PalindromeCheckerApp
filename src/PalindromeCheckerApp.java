import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Deque Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Preprocess input
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Step 1: Create Deque
        Deque<Character> deque = new ArrayDeque<>();

        // Step 2: Insert characters into deque
        for (int i = 0; i < processedInput.length(); i++) {
            deque.addLast(processedInput.charAt(i));
        }

        boolean isPalindrome = true;

        // Step 3: Compare front and rear
        while (deque.size() > 1) {

            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Step 4: Print result
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome ✅");
        } else {
            System.out.println("Result: Not a Palindrome ❌");
        }

        scanner.close();
    }
}
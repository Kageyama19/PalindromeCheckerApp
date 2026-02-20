import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Queue + Stack Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Preprocess input
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Step 1: Enqueue and Push characters
        for (int i = 0; i < processedInput.length(); i++) {
            char ch = processedInput.charAt(i);
            queue.add(ch);     // Enqueue (FIFO)
            stack.push(ch);    // Push (LIFO)
        }

        boolean isPalindrome = true;

        // Step 2: Compare dequeue vs pop
        while (!queue.isEmpty()) {

            char fromQueue = queue.remove();  // Dequeue
            char fromStack = stack.pop();     // Pop

            if (fromQueue != fromStack) {
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Print result
        if (isPalindrome) {
            System.out.println("Result: It is a Palindrome ✅");
        } else {
            System.out.println("Result: Not a Palindrome ❌");
        }

        scanner.close();
    }
}
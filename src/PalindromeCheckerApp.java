import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    // Stack Approach
    public static boolean stackMethod(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // Deque Approach
    public static boolean dequeMethod(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : processed.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // Two Pointer Approach (Most Efficient)
    public static boolean twoPointerMethod(String input) {

        String processed = input.replaceAll("\\s+", "").toLowerCase();

        int start = 0;
        int end = processed.length() - 1;

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

        // Large test input for realistic comparison
        String input = "Never Odd Or Even Never Odd Or Even Never Odd Or Even";

        System.out.println("Running Performance Comparison...\n");

        // Stack Timing
        long start1 = System.nanoTime();
        stackMethod(input);
        long end1 = System.nanoTime();

        // Deque Timing
        long start2 = System.nanoTime();
        dequeMethod(input);
        long end2 = System.nanoTime();

        // Two Pointer Timing
        long start3 = System.nanoTime();
        twoPointerMethod(input);
        long end3 = System.nanoTime();

        System.out.println("Stack Method Time: " + (end1 - start1) + " ns");
        System.out.println("Deque Method Time: " + (end2 - start2) + " ns");
        System.out.println("Two Pointer Method Time: " + (end3 - start3) + " ns");
    }
}
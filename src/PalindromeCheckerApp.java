//public class PalindromeCheckerApp{
//
//
//    static final String version = "1.0";
//    public static void main(String[] args){
//        System.out.println("Welecone to the palindrome Checker Application");
//        System.out.println("Version"+ version);
//        System.out.println("System Initialized Successfully");
//
//    }
//
//}
////public static boolean  PalindromeCheckerApp(String str) {
////    for(int i=0;i<str.length()/2;i++){
////        int n= str.length();
////        if(str.charAt(i) != str.charAt(n-1-i)){
////            //not a palindrome
////            return false;
////
////        }
////    }
////    return true;
////}
////public static void main (String[] args){
////    String str= "madam";
////    System.out.println(PalindromeCheckerApp(str));
////}
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Stack Based Palindrome Checker ===");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Convert to lowercase and remove spaces for better validation
        String processedInput = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Step 1: Push all characters into stack
        for (int i = 0; i < processedInput.length(); i++) {
            stack.push(processedInput.charAt(i));
        }

        // Step 2: Pop and compare
        String reversedString = "";

        while (!stack.isEmpty()) {
            reversedString += stack.pop();
        }

        // Step 3: Validate
        if (processedInput.equals(reversedString)) {
            System.out.println("Result: It is a Palindrome ✅");
        } else {
            System.out.println("Result: Not a Palindrome ❌");
        }

        scanner.close();
    }
}
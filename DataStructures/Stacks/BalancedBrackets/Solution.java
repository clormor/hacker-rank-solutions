import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    static Stack<Character> stack = new Stack<>();

    static boolean isBalanced(String s) {
        stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ']':
                    if (!expect('[')) return false;
                    break;
                case ')':
                    if (!expect('(')) return false;
                    break;
                case '}':
                    if (!expect('{')) return false;
                    break;
                default:
                    stack.add(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    static boolean expect(char c) {
        if (stack.isEmpty() || stack.pop() != c) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));) {

            int t = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int tItr = 0; tItr < t; tItr++) {
                String s = scanner.nextLine();
                bufferedWriter.write(isBalanced(s) ? "YES" : "NO");
                bufferedWriter.newLine();
            }
        }
    }
}

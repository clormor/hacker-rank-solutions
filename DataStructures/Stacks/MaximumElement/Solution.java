import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Stack<MaxStack> stack = new Stack<>();

        try (Scanner s = new Scanner(System.in)) {
            int max = 0;
            for (int n = s.nextInt(); n > 0; n--) {
                int instruction = s.nextInt();
                switch (instruction) {
                    case 1:
                        int value = s.nextInt();
                        max = Math.max(value, max);
                        stack.add(new MaxStack(value, max));
                        break;
                    case 2:
                        stack.pop();
                        max = stack.isEmpty() ? 0 : stack.peek().max;
                        break;
                    case 3:
                        System.out.printf("%d%n", max);
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
            }
        }
    }
}

class MaxStack {
    int value;
    int max;

    MaxStack(int v, int m) {
        value = v;
        max = m;
    }
}

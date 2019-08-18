import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        // this is not a pure heap, cheating by using a
        // tree set since we need to support arbitrary deletion
        TreeSet<Integer> minHeap = new TreeSet<>();
        StringBuilder result = new StringBuilder();

        try (Scanner s = new Scanner(System.in)) {
            int q = s.nextInt();

            for (int i = 0; i < q; i++) {
                switch (s.nextInt()) {
                    case 1:
                        minHeap.add(s.nextInt());
                        break;
                    case 2:
                        minHeap.remove(s.nextInt());
                        break;
                    case 3:
                        result.append(minHeap.first())
                                .append(System.lineSeparator());
                        break;
                    default:
                        throw new RuntimeException("Invalid operation!");
                }
            }
            System.out.println(result);
        }
    }
}


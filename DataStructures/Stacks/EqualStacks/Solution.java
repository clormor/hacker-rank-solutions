import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    static int equalStacks(Deque<Cylinder> h1, Deque<Cylinder> h2, Deque<Cylinder> h3) {
        while (true) {
            if (h1.peekLast().totalHeight == h2.peekLast().totalHeight
                    && h1.peekLast().totalHeight == h3.peekLast().totalHeight) {
                return h1.peekLast().totalHeight;
            }

            Deque<Cylinder> tmp;
            if (h2.peekLast().totalHeight > h1.peekLast().totalHeight) {
                tmp = h1;
                h1 = h2;
                h2 = tmp;
            }

            if (h3.peekLast().totalHeight > h1.peekLast().totalHeight) {
                tmp = h1;
                h1 = h3;
                h3 = tmp;
            }

            h1.pollLast();
        }
    }

    private static Deque<Cylinder> initCylinders(int numCylinders, Scanner s) {
        Deque<Integer> cylinders = new LinkedList<>();
        for (int i = 0; i < numCylinders; i++) {
            cylinders.add(s.nextInt());
        }

        Deque<Cylinder> result = new LinkedList<>();
        result.add(new Cylinder());
        for (int i = 0; i < numCylinders; i++) {
            result.add(new Cylinder(cylinders.pollLast(), result.peekLast().totalHeight));
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")))) {

            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int n3 = scanner.nextInt();

            Deque<Cylinder> c1 = initCylinders(n1, scanner);
            Deque<Cylinder> c2 = initCylinders(n2, scanner);
            Deque<Cylinder> c3 = initCylinders(n3, scanner);

            int result = equalStacks(c1, c2, c3);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }
    }
}

class Cylinder {
    int height;
    int totalHeight;

    Cylinder(int height, int totalHeight) {
        this.height = height;
        this.totalHeight = totalHeight + height;
    }

    Cylinder() {
        this.height = 0;
        this.totalHeight = 0;
    }
}

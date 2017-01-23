import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN = 11;
    private static final int MAX = 100;

    public static void main(String[] args) {
        printFibonacciNumbers(7);
        printVampirNumbers();
    }

    private static void printFibonacciNumbers(int n) {
        int beforePrev = ZERO;
        int prev = ONE;
        int current;

        for (int i = ZERO; i < n; i++) {
            current = beforePrev + prev;
            System.out.print(current + " ");

            if (i != ZERO) {
                beforePrev = prev;
                prev = current;
            }
        }

        System.out.println();
    }

    private static void printVampirNumbers() {
        int counter = ONE;
        for (int i = MIN; i < MAX; i++) {
            for (int j = i; j < MAX; j++) {
                int result = i * j;

                List<Integer> fangs = (i + "" + j).chars().mapToObj(c -> c).sorted().collect(Collectors.toList());
                List<Integer> number = (result + "").chars().mapToObj(c -> c).sorted().collect(Collectors.toList());

                if (number.equals(fangs)) {
                    System.out.println(counter++ + ") " + result + " = " + i + " * " + j);
                }
            }
        }
    }
}

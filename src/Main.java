import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int MIN = 11;
    private static final int MAX = 100;

    public static void main(String[] args) {
        printFibonacciNumbers(7);
        printVampireNumbers();
        printParserAnalize();
    }

    private static void printParserAnalize() {
        long startTime;

        System.out.println("parseInt\tvalueOf");
        List<Integer> parseInt = new ArrayList<>();
        List<Integer> valueOf = new ArrayList<>();

        for (int i = ZERO; i < MAX; i++) {
            startTime = System.nanoTime();
            Integer.parseInt("12345611", 8);
            printTime(startTime, parseInt);

            startTime = System.nanoTime();
            Integer.valueOf("12345611");
            printTime(startTime, valueOf);
            System.out.println();
        }

        System.out.println("-------------------");
        System.out.println(getAverage(parseInt) + "\t\t" + getAverage(valueOf));
        printLastLine();
    }

    private static void printTime(long startTime, List<Integer> list) {
        long stopTime = System.nanoTime();
        int elapsedTime = (int) (stopTime - startTime);
        list.add(elapsedTime);
        System.out.print(elapsedTime + "\t");
    }

    private static int getAverage(List<Integer> list) {
        Integer sum = 0;
        if (!list.isEmpty()) {
            for (Integer mark : list) {
                sum += mark;
            }
            return (int) (sum.doubleValue() / list.size());
        }

        return 0;
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

        printLastLine();
    }

    private static void printVampireNumbers() {
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
        printLastLine();
    }

    private static void printLastLine() {
        System.out.println("\n********************\n\n");
    }
}

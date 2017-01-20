import java.util.Random;

public class Main {
    private static int min = 1;
    private static int max = 100;
    private static int current = 0;
    private static int prev = 0;
    private static int limit = 25;
    private static Random rn = new Random();
    private static final int ZERO = 0;
    private static final int TWO = 2;

    public static void main(String[] args) {
        firstTask();
        secondTask();
        thirdTask();
    }

    private static void firstTask() {
        for (int i = min; i <= max; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void secondTask() {
        for (int i = ZERO; i < limit; i++) {
            current = rn.nextInt(max);

            if (current < prev) {
                System.out.print(" < ");

            } else if (current > prev) {
                System.out.print(" > ");

            } else {
                System.out.print(" = ");
            }

            System.out.print(current);

            prev = current;
        }
        System.out.println();
    }

    private static void thirdTask() {
        for (int i = min; i < max; i++) {
            int k = ZERO;
            for(int j = min; j < max; j++) {
                if(i % j == ZERO) {
                    k++;
                }
            }

            if(k == TWO){
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

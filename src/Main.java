
public class Main {
    public static void main(String[] args) {
        fibonacci(Integer.valueOf(args[0]));
    }

    private static void fibonacci(int n) {
        int beforePrev = 0;
        int prev = 1;
        int current;

        for (int i = 0; i < n; i++) {
            current = beforePrev + prev;
            System.out.print(current + " ");

            if (i != 0) {
                beforePrev = prev;
                prev = current;
            }
        }
    }
}

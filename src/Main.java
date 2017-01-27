import java.util.*;

public class Main {
    private static final int N = 7;

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<Integer> values = new HashSet<>();

        int central = N % 2 == 0 ? N / 2 : (N / 2) + 1;

        Random r = new Random();

        for (int i = 0; i < N * N; i++) {
            while (values.size() != i + 1) {
                values.add(r.nextInt(800) + 100);
            }
        }

        List<Integer> vals = new ArrayList<>();
        for (int value: values) {
            vals.add(value);
        }
        for (int i = 0; i < N; i++) {
            lists.add(vals.subList(i * N, i * N + N));
        }

        printLists(lists);

        Point point = findMax(lists);
        int cent = lists.get(central).get(central);
        lists.get(central).get(central) = lists.get(point.getI()).get(point.getJ());
        lists.get(point.getI()).get(point.getJ()) = cent;

        printLists(lists);
    }

    private static void printLists(List<List<Integer>> lists) {
        for(List<Integer> list: lists) {
            for (int i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static Point findMax(List<List<Integer>> lists) {
        Point point = new Point(0, 0);
        int current = lists.get(0).get(0);
        int max = current;

        for (int i = 0; i < lists.size(); i++) {
            int pos = lists.get(i).get(i);
            int neg = lists.get(lists.size() - i).get(i);
            current = pos > neg ? pos : neg;
            if(current > max) {
                max = current;
                point.setI(pos > neg ? i : lists.size() - i);
                point.setJ(i);
            }
        }

        return point;
    }
}

import framework.Core;
import framework.proxy.ProxyService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        ProxyService.createProxies();


        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Core.execute(str);
    }
}
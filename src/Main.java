import code.Printer;
import framework.proxy.Proxy;
import framework.proxy.ProxyService;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ProxyService.createBeans();

        Printer p2 = (Printer) Proxy.get(Printer.class);
        p2.printWithoutWhitespaces("Hello world");
        p2.print("abc");
        p2.printReversed("abc");
    }
}
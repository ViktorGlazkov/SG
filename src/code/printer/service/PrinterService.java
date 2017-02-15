package code.printer.service;

import framework.annotation.Async;
import framework.annotation.Component;

@Component
public class PrinterService implements Printer {
    @Async
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Async
    @Override
    public void printReverted(String text) {
        System.out.println(new StringBuilder(text).reverse());
    }
}

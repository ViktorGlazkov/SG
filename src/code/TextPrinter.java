package code;

import framework.annotation.Async;
import framework.annotation.FrameworkClass;

@FrameworkClass
public class TextPrinter implements Printer {
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void printReversed(String text) {
        System.out.println(new StringBuilder(text).reverse().toString());
    }

    @Async
    @Override
    public void printWithoutWhitespaces(String text) {
        text = text.replaceAll("\\s+", " ");
        System.out.println(text);
    }
}

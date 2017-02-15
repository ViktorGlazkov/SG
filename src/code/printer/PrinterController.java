package code.printer;

import code.printer.service.Printer;
import framework.annotation.Autowired;
import framework.annotation.Controller;
import framework.annotation.Path;

@Controller
public class PrinterController {
    @Autowired
    Printer printer;

    @Path(path = "print")
    public void print(String text) {
        printer.print(text);
    }
}

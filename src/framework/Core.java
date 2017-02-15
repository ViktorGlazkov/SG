package framework;

import framework.annotation.Controller;
import framework.annotation.Path;
import framework.finder.ClassFinder;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Core {
    public static void execute(String str) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        String[] strings = str.split(" ");
        List<Class<?>> classes = ClassFinder.findAnotated("code", Controller.class);
        for (Class clazz : classes) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Path.class) && method.getAnnotation(Path.class).path().equals(strings[0])) {
                    method.invoke(clazz.newInstance(), strings[1]);
                    break;
                }
            }
        }
    }
}

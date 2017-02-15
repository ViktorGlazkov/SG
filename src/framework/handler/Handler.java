package framework.handler;

import framework.annotation.Async;
import framework.annotation.Autowired;
import framework.annotation.Controller;
import framework.finder.ClassFinder;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;


public class Handler implements InvocationHandler {
    private final Object original;

    public Handler(Object original) throws IllegalAccessException, InstantiationException {
        this.original = original;
        for (Field field : original.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
//                field.getType().newInstance();
                  ClassFinder.findAllMatchingTypes(field.getType()).get(0).newInstance();
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException {

        if (isMethodAnnotatedOfCustom(method, Async.class)) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.print("\nRunning method " + method.getName() + " in new Thread\n");
                        method.invoke(original, args);
                        System.out.print("Done\n");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } else if (method.getClass().isAnnotationPresent(Controller.class)) {

        } else {
            method.invoke(original, args);

        }

        return null;
    }

    private boolean isMethodAnnotatedOfCustom(Method method, Class annotation) throws NoSuchMethodException {
        return original.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(annotation);
    }
}

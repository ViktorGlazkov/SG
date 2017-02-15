package framework.handler;

import framework.annotation.Async;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


public class Handler implements InvocationHandler {
    private final Object original;

    public Handler(Object original) {
        this.original = original;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException {
        if(isMethodAnnotatedOfCustom(method, Async.class)) {
            new Thread(new Runnable() {
                public void run()
                {
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

        } else {
            method.invoke(original, args);
        }

        return null;
    }

    private boolean isMethodAnnotatedOfCustom(Method method, Class annotation) throws NoSuchMethodException {
        return original.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(annotation);
    }
}

package framework.proxy;

import framework.annotation.Component;
import framework.annotation.Controller;
import framework.finder.ClassFinder;
import framework.handler.Handler;

import java.util.List;

public class ProxyService {
    public static void createProxies() throws IllegalAccessException, InstantiationException {
        List<Class<?>> classes = ClassFinder.find("code");

        for (Class cl : classes) {
            if (isAnnotatedClass(cl)) {
                Handler handler = new Handler(cl.newInstance());
                Object object = java.lang.reflect.Proxy.newProxyInstance(cl.getInterfaces()[0].getClassLoader(),
                        new Class[]{cl.getInterfaces()[0]},
                        handler);
                Proxy.put(cl.getInterfaces()[0], object);
            }
        }
    }

    public static Object createProxy(Class clazz, Object object) throws IllegalAccessException, InstantiationException {

        if (!isAnnotatedClass(clazz)) return object;

        Handler handler = new Handler(object);
        Object ob = java.lang.reflect.Proxy.newProxyInstance(clazz.getInterfaces()[0].getClassLoader(),
                new Class[]{clazz.getInterfaces()[0]},
                handler);
        return ob;
    }

    private static boolean isAnnotatedClass(Class cl) {
        return cl.isAnnotationPresent(Component.class)
                || cl.isAnnotationPresent(Controller.class) && !cl.isInterface();
    }
}

package framework.proxy;

import framework.annotation.FrameworkClass;
import framework.finder.ClassFinder;
import framework.handler.Handler;

import java.util.List;

public class ProxyService {
    public static void createBeans() throws IllegalAccessException, InstantiationException {
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

    private static boolean isAnnotatedClass(Class cl) {
        return cl.isAnnotationPresent(FrameworkClass.class) && !cl.isInterface();
    }
}

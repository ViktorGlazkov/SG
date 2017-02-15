package framework.proxy;

import java.util.HashMap;
import java.util.Map;

public class Proxy {
    private static Map<Class, Object> beans = new HashMap<>();
    private static Proxy ourInstance = new Proxy();

    public static Proxy getInstance() {
        return ourInstance;
    }

    private Proxy() {
    }

    public static void put(Class key, Object value) {
        beans.put(key, value);
    }

    public static Object get(Class key) {
        return beans.get(key);
    }
}

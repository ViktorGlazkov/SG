package framework.proxy;

import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

public class Proxy {
    private static Map<Class, Object> proxies = new HashMap<>();
    private static Proxy ourInstance = new Proxy();

    public static Proxy getInstance() {
        return ourInstance;
    }

    private Proxy() {
    }

    public static void put(Class clazz, Object value) {
        proxies.put(clazz, value);
    }

    public static void put(List<Class> list, Class clazz) {
        //proxies.putAll(map);
    }

    public static Object get(Object key) {
        return proxies.get(key.hashCode());
    }
}

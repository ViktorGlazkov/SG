package framework.finder;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ClassFinder {
    private static final char PKG_SEPARATOR = '.';
    private static final char DIR_SEPARATOR = '/';
    private static final String CLASS_FILE_SUFFIX = ".class";
    private static final String BAD_PACKAGE_ERROR
            = "Unable to get resources from path '%s'. Are you sure the package '%s' exists?";

    public static List<Class<?>> find(String scannedPackage) {
        File scannedDir = getFile(scannedPackage);
        return getClasses(scannedPackage, scannedDir);
    }

    public static List<Class<?>> findAnotated(String scannedPackage, Class annotation) {
        File scannedDir = getFile(scannedPackage);
        return getAnnotatedClasses(scannedPackage, scannedDir, annotation);
    }

    private static File getFile(String scannedPackage) {
        String scannedPath = scannedPackage.replace(PKG_SEPARATOR, DIR_SEPARATOR);
        URL scannedUrl = Thread.currentThread().getContextClassLoader().getResource(scannedPath);

        if (scannedUrl == null) {
            throw new IllegalArgumentException(String.format(BAD_PACKAGE_ERROR, scannedPath, scannedPackage));
        }

        return new File(scannedUrl.getFile());
    }

    private static List<Class<?>> find(File file, String scannedPackage) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        String resource = scannedPackage + PKG_SEPARATOR + file.getName();

        if (file.isDirectory()) {
            classes.addAll(getClasses(resource, file));

        } else if (resource.endsWith(CLASS_FILE_SUFFIX)) {
            classes.add(getClass(resource));
        }

        return classes;
    }

    private static Class getClass(String resource) {
        int endIndex = resource.length() - CLASS_FILE_SUFFIX.length();
        String className = resource.substring(0, endIndex);

        try {
            return Class.forName(className);
        } catch (ClassNotFoundException ignore) {
        }

        return null;
    }

    private static List<Class<?>> getClasses(String scannedPackage, File scannedDir) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (File file : scannedDir.listFiles()) {
            classes.addAll(find(file, scannedPackage));
        }
        return classes;
    }

    private static List<Class<?>> getAnnotatedClasses(String scannedPackage, File scannedDir, Class annotation) {
        List<Class<?>> classes = new ArrayList<Class<?>>();
        for (File file : scannedDir.listFiles()) {
            for(Class clazz: find(file, scannedPackage)) {
                if(clazz.isAnnotationPresent(annotation)) {
                    classes.add(clazz);
                }
            }
        }
        return classes;
    }

    public static <T> List<Class<? extends T>> findAllMatchingTypes(Class<T> toFind) {
        List<Class<?>> foundClasses = new ArrayList<Class<?>>();
        List<Class<? extends T>> returnedClasses = new ArrayList<Class<? extends T>>();

        for (Class<?> clazz : foundClasses) {
            returnedClasses.add((Class<? extends T>) clazz);
        }
        return returnedClasses;
    }
}
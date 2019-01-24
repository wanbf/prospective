package com.angel.prospective.util.loader;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wanbf
 * @date 2019/1/23 11:18
 */
public class ProspectiveLoader {
    private static final String SERVICES_DIRECTORY = "META-INF/services/";
    private static final String PROSPECTIVE_DIRECTORY = "META-INF/prospective/";
    private static Map<Class, List<Class>> providers = new ConcurrentHashMap<Class, List<Class>>();

    public static <S> S load(Class<S> service, ClassLoader loader) throws PreNestableRuntimeException {
        return loadFile(service, null, loader);
    }

    public static <S> S load(Class<S> service) throws PreNestableRuntimeException {
        return loadFile(service, null, findClassLoader());
    }

    public static <S> S load(Class<S> service, String activateName, ClassLoader loader) throws PreNestableRuntimeException {
        return loadFile(service, activateName, loader);
    }

    @SuppressWarnings("rawtypes")
    public static <S> List<Class> getAllExtensionClass(Class<S> service) {
        return findAllExtensionClass(service, null, findClassLoader());
    }

    @SuppressWarnings("rawtypes")
    public static <S> List<Class> getAllExtensionClass(Class<S> service, ClassLoader loader) {
        return findAllExtensionClass(service, null, loader);
    }



    @SuppressWarnings("rawtypes")
    private static <S> S loadFile(Class<S> service, String activateName, ClassLoader loader) {
        try {
            boolean foundFromCache = true;
            List<Class> extensions = providers.get(service);
            if (extensions == null) {
                synchronized (service) {
                    extensions = providers.get(service);
                    if (extensions == null) {
                        extensions = findAllExtensionClass(service, activateName, loader);
                        foundFromCache = false;
                        providers.put(service, extensions);
                    }
                }
            }

            // 为避免被覆盖，每个activateName的查找，允许再加一层子目录
            if (StringUtils.isNotEmpty(activateName)) {
                loadFile(service, PROSPECTIVE_DIRECTORY + activateName.toLowerCase() + "/", loader, extensions);

                List<Class> activateExtensions = new ArrayList<Class>();
                for (int i = 0; i < extensions.size(); i++) {
                    Class clz = extensions.get(i);
                    @SuppressWarnings("unchecked")
                    LoadLevel activate = (LoadLevel) clz.getAnnotation(LoadLevel.class);
                    if (activate != null && activateName.equals(activate.name())) {
                        activateExtensions.add(clz);
                    }
                }

                extensions = activateExtensions;
            }

            if (extensions.isEmpty()) {
                throw new PreNestableRuntimeException("not found service provider for : " + service.getName() + "[" + activateName
                        + "] and classloader : " + ObjectUtils.toString(loader));
            }
            Class<?> extension = extensions.get(extensions.size() - 1);// 最大的一个
            S result = service.cast(extension.newInstance());
            return result;
        } catch (Throwable e) {
            if (e instanceof PreNestableRuntimeException) {
                throw (PreNestableRuntimeException) e;
            } else {
                throw new PreNestableRuntimeException(
                        "not found service provider for : " + service.getName() + " caused by " + ExceptionUtils.getFullStackTrace(e));
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private static void loadFile(Class<?> service, String dir, ClassLoader classLoader, List<Class> extensions) throws IOException {
        String fileName = dir + service.getName();
        Enumeration<URL> urls;
        if (classLoader != null) {
            urls = classLoader.getResources(fileName);
        } else {
            urls = ClassLoader.getSystemResources(fileName);
        }

        if (urls != null) {
            while (urls.hasMoreElements()) {
                java.net.URL url = urls.nextElement();
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        final int ci = line.indexOf('#');
                        if (ci >= 0) {
                            line = line.substring(0, ci);
                        }
                        line = line.trim();
                        if (line.length() > 0) {
                            extensions.add(Class.forName(line, true, classLoader));
                        }
                    }
                } catch (ClassNotFoundException e) {
                    // ignore
                } catch (Throwable e) {
                     // 记录一下失败日志
                } finally {
                    try {
                        if (reader != null) {
                            reader.close();
                        }
                    } catch (IOException ioe) {
                        // ignore
                    }
                }
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private static <S> List<Class> findAllExtensionClass(Class<S> service, String activateName, ClassLoader loader) {
        List<Class> extensions = new ArrayList<Class>();
        try {
            loadFile(service, SERVICES_DIRECTORY, loader, extensions);
            loadFile(service, PROSPECTIVE_DIRECTORY, loader, extensions);
        } catch (IOException e) {
            throw new PreNestableRuntimeException(e);
        }

        if (extensions.isEmpty()) {
            return extensions;
        }

        // 做一下排序
        Collections.sort(extensions, new Comparator<Class>() {
            @Override
            public int compare(Class c1, Class c2) {
                Integer o1 = 0;
                Integer o2 = 0;
                @SuppressWarnings("unchecked")
                LoadLevel a1 = (LoadLevel) c1.getAnnotation(LoadLevel.class);
                @SuppressWarnings("unchecked")
                LoadLevel a2 = (LoadLevel) c2.getAnnotation(LoadLevel.class);

                if (a1 != null) {
                    o1 = a1.order();
                }

                if (a2 != null) {
                    o2 = a2.order();
                }

                return o1.compareTo(o2);

            }
        });

        return extensions;
    }

    private static ClassLoader findClassLoader() {
        // 不能使用TCCL,在pandora容器中会导致无法加载plugin中的类
        return ProspectiveLoader.class.getClassLoader();
    }

}

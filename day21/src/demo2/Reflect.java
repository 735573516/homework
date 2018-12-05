package demo2;

import java.io.FileInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        ClassLoader cl = new ClassLoader() {
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    FileInputStream in  = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java\\20\\Treasure.class");
                    byte[] bytes = new byte[1024*8];
                    int len = in.read(bytes);

                    // 调用父类的方法根据字节数组加载类
                    return defineClass(name, bytes, 0, len);
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };

        Class<?> clazz = cl.loadClass("com.westos.Treasure"); // 根据类名加载类, 得到类对象
        Constructor<?> cons = clazz.getDeclaredConstructor ( );
        cons.setAccessible ( true );
        Object test= cons.newInstance (  );
        HashSet <Method> methods1 = new HashSet <> ( );
        for (Method method : clazz.getMethods()) {
            methods1.add ( method );
        }
        Map <Annotation[], List <Method>> collect = methods1.stream ( ).collect ( Collectors.groupingBy ( a -> a.getDeclaredAnnotations ( ) ) );
        collect.forEach ( (a,b)->{
            if (b.size ()==1){
                b.stream ().forEach ( c->{
                    c.setAccessible ( true );
                    try {
                        c.invoke ( test );
                    } catch (IllegalAccessException e) {
                        e.printStackTrace ( );
                    } catch (InvocationTargetException e) {
                        e.printStackTrace ( );
                    }
                } );
            }
        } );
    }
}

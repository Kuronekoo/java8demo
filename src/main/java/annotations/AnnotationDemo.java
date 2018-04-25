package annotations;

import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @program: java8demo
 * @description: ${description}
 * @author: Kuroneko
 * @create: 2018-04-25 22:38
 **/
public class AnnotationDemo {

    @Test
    public void testAno() throws NoSuchMethodException {
        Class<AnnotationDemo> annotationDemoClass = AnnotationDemo.class;
        Method show = annotationDemoClass.getMethod("show");
        MyAnnotation[] myAnnotations = show.getDeclaredAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation annotation:
             myAnnotations) {
            System.out.println(annotation.value());
        }
    }


    @MyAnnotation("hello")
    @MyAnnotation("java8")
    public void show(){

    }
}

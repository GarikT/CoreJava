package homework.Chapter12;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}
@What(description = "An annotaion test class")
@MyAnno(str = "Meta3", val = 99)
public class Meta3 {
    @What(description = "An annotation test method")
    @MyAnno(str = "Testing", val = 100)
    public static void myMeth(String s, double d){
        Meta3 ob = new Meta3();
        try{
            Annotation annos[] = ob.getClass().getAnnotations();
            System.out.println("All annotations for Meta3");
            for (Annotation anno : annos) {
                System.out.println(anno);
            }
            System.out.println();

            Method m = ob.getClass().getMethod("myMeth", String.class, double.class);
            annos = m.getAnnotations();
            System.out.println("All annotation for myMeth");
            for (Annotation anno : annos) {
                System.out.println(anno);
            }
        }catch (NoSuchMethodException exc){
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth("Hello", 0.99);
    }
}

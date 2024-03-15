package homework.Chapter12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno4{
    String str() default "Testing";
    int val() default 9000;
}
public class Meta4 {
    @MyAnno4()
    public static void myMeth(){
        Meta4 ob = new Meta4();
        try{
            Class<?> c = ob.getClass();
            Method m = c.getMethod("myMeth");
            MyAnno4 anno = m.getAnnotation(MyAnno4.class);
            System.out.println(anno.str() + " " + anno.val());
        }catch (NoSuchMethodException e){
            System.out.println("Method Not Found.");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}

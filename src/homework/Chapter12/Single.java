package homework.Chapter12;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MySingle{
    int value();
}
public class Single {
    @MySingle(100) //stex petq che nshel value = 100; menak 100 grel@ bavakan e
    public static void myMeth(){
        Single ob = new Single();
        try{
            Method m = ob.getClass().getMethod("myMeth");
            MySingle anno = m.getAnnotation(MySingle.class);
            System.out.println(anno.value());
        }catch (NoSuchMethodException e){
            System.out.println("Method Not Found");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}

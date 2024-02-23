package homework.chapter8;

public class Rectangle extends Figure{
    Rectangle(double a, double b){
        super(a, b);
    }
    double area(){
        System.out.println("Inside Area of Rectangle.");
        return dim1 * dim2;
    }
}

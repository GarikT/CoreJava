package classwork.chapter14;

public class Storage<T> {
    private Object[] objects = new Object[10];
    private int size;

    public void add(T value){
        if(objects.length ==  size){
            extend();
        }
        objects[size++] = value;
    }

    public T getByIndex(int index){
        return (T) objects[index];
    }

    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(objects[i]);
        }
    }
    private void extend(){
        Object[] temp = new Object[objects.length + 10];
        System.arraycopy(objects, 0, temp, 0, objects.length);
        objects = temp;
    }
}

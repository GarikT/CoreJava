package homework.DynamicArray;

public class DynamicArray {

    //սա մեր հիմնական մասիվն է, որտեղ պահելու ենք ավելացվող էլեմենտները
    private int[] array = new int[10];
    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստուգել եթե մասիվի մեջ տեղ չկա-> կանչել extend()
    //և ավելացնենք
    public void add(int value) {
        if(size == array.length){
            extend();
            array[size] = value;
            size++;
        }else{
            array[size] = value;
            size++;
        }
    }

    //1․ ստեղծել հին մասիվից 10 էլեմենտ ավելի մեծ մասիվ
    //2․ քցել հին մասիվի էլեմենտները նորի մեջ
    //3․ հին մասիվի հղումը կապենք նոր մասիվի հղման հետ։
    private void extend() {
        int[] newArray = new int[array.length + 10];
        System.arraycopy(array,0, newArray, 0, array.length);
//        for (int i = 0; i < array.length; i++) {
//            newArray[i] = array[i];
//        }
        array = newArray;
    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է, վերադարձնել
    // մասիվի index-երրորդ էլեմենտը։ Հակառակ դեպքում վերադարձնել -1։
    public int getByIndex(int index) {
        int result = -1;
        if( (index < size) && (index > -1) ){
            result = array[index];
        }
        return result;
    }

    //տպել մասիվի ավելացված էլեմենտները
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    //ջնջել մասիվի index-երորդ էլեմենտը
    //եթե չկա նման ինդեքսով էլեմենտ, տպել, որ չկա նման էլեմենտ
    public void deleteByIndex(int index) {
        if(index < 0 || index >=size){
            System.out.println("Index does not exist");
        }else {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            array[size] = 0;
            size--;
        }
    }
    //տրված value-ն դնելու ենք տրված index-ով էլեմենտի տեղը։
    //Հին արժեքը կկորի
    //եթե նման ինդեքսով էլեմենտ չկա, գրում ենք որ չկա։
    public void set(int index, int value) {
        if(index < 0 || index >=size){
            System.out.println("Index does not exist");
        }else{
            array[index] = value;
        }
    }

    //ավելացնել տրված value-ն տրված ինդեքսում, իսկ էղած էլեմենտները մի հատ աջ տանել։
    //Եթե չկա նման ինդեքս, տպել որ չկա
    public void add(int index, int value) {
        if(index < 0 || index >=size){
            System.out.println("Index does not exist");
        }else{
            if(array.length - size < 1){
                extend();
            }
            for (int i = size-1; i >= index ; i--) {
                array[i + 1] = array[i];
            }
            array[index] = value;
            size++;
        }
    }
    //Վերադարձնել true եթե տրված value-ն կա մեր մասիվի մեջ, եթե ոչ false
    public boolean exists(int value) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if(array[i] == value){
                result = true;
                break;
            }
        }
        return result;
    }
    //Վերադարձնել տրված value-ի ինդեքսը, եթե շատ կա տվյալ թվից, վերադարձնել առաջին ինդեքսը։
//եթե չկա, -1
    public int getIndexByValue(int value) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if(array[i] == value){
                result = i;
                break;
            }
        }
        return result;
    }

}

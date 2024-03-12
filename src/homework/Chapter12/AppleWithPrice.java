package homework.Chapter12;

public enum AppleWithPrice {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15),
    Cortland(8);

    private int price;
    AppleWithPrice(int p){
        price = p;
    }
    int getPrice(){
        return price;
    }
}

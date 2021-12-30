public class Item {
    String name;
    double price;
    int quantity;

    Item(){
        name = "N/A";
        price = 0;
        quantity = 0;
    }

    Item(String n, double p, int q){
        name = n;
        price = p;
        quantity = q;
    }
}

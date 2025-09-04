import java.util.ArrayList;
import java.util.List;


class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return name + ":|Price:" + price + ":|quantity:" + quantity;
    }
}
class Inventory{
    private List<Product> products=new ArrayList<>();
    public void addproduct(Product p){
        products.add(p);
    }
    public void viewInventory (){
        for(Product p:products) System.out.println(p);

    }
    public void ShowlowStock(){
        for (Product p:products){
            if(p.getQuantity()<5){
                System.out.println("Low stock:"+p);
            }
        }
    }

}

public class InventoryApp {
    public static void main(String[] args) {
        Inventory inv = new Inventory();
        inv.addproduct(new Product("pen",5,4));
        inv.addproduct(new Product("notebook",20,30));
        System.out.println("\nInventory");
        inv.viewInventory();
        System.out.println("\nShowLowStock");
        inv.ShowlowStock();

    }
}



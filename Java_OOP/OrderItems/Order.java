import java.util.*;

public class Order{
    public String name;
    public double total;
    public boolean ready = false;
    ArrayList<Item> items = new ArrayList<Item>();
    public Order(){}

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void addItems(Item item){
    this.total += item.price;

    this.items.add(item);
}

    public double orderTotal(){
        return this.total;
    }

    public void orderReady(){
        this.ready = true;
        System.out.println("Order Ready");
    }
}
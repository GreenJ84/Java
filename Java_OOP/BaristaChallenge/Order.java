import java.util.*;

public class Order{
    private String name;
    private boolean ready;
    ArrayList<Item> items;
    
    public Order(){
        this.name = "Guest";
        this.items = new ArrayList<Item>();
    }

        public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }    
    
    public String getName(){
        return this.name;
    }

    public boolean orderReadyStatus(){
        return this.ready;
    }

        public ArrayList<Item> getItems(){
        return this.items;
    }

    public void setName(String name){
        this.name = name;
    }

    public void orderReady(boolean ready){
        this.ready = ready;
    }


    public void addItems(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if (this.ready == true) {
            return ("Your order is ready!");
        } else {
            return ("Thank you for waitng. Your order will be ready soon.");
        }
    }

    public double getOrderTotal(){
        double total = 0.0;
        for (Item item: this.items){
            total += item.getPrice();
        }
        return total;
    }

    public void displayOrder(){
        System.out.println("Customer Name: " +this.name);
        double total = this.getOrderTotal();
        for (Item item: this.items){
            System.out.println(item.getName() + " - $" + item.getPrice());
        }
        System.out.println("Total: $" + total);
    }

}
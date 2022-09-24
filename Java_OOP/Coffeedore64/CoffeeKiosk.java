import java.util.*;
import java.util.concurrent.TimeUnit;

public class CoffeeKiosk{
    public ArrayList<Item> menu;
    public ArrayList<Order> orders;

    public CoffeeKiosk(){
        this.menu = new ArrayList<Item>();
        this.orders = new ArrayList<Order>();
    }

    public void addMenuItem(String name, double price){
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int newItemIndex = menu.size() - 1;
        newItem.setIndex(newItemIndex);
        System.out.println(newItem.getIndex());

        displayMenu();
    }

    public void addMenuItemByInput(){
        System.out.println("Menu Item Name: ");
        String name = System.console().readLine();
        System.out.println("Menu Item Price: ");
        String itemPrice = System.console().readLine();
        Double price = Double.parseDouble(itemPrice);
        Item newItem = new Item(name, price);
        menu.add(newItem);
        int newItemIndex = menu.size() - 1;
        newItem.setIndex(newItemIndex);
        System.out.println(newItem.getIndex());

        String another = System.console().readLine();
        if (another.equals("y")){
                addMenuItemByInput();
        } else if (another.equals("n")){
                
        } else {
                System.out.println("I dont undersatnd,\n Would you like to add another your Item? (y or n)<--ONLY");
                another = System.console().readLine();
        }
        displayMenu();

    }

    public void displayMenu(){
        for (Item item: menu){
            System.out.println(""+ item.getIndex() + " " + item.getName() + " --  $" + item.getPrice() );
        }
    }

    public void newOrder(){
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
        Order newOrder = new Order(name);
        orderScreen(newOrder);
    }

    public void orderScreen(Order newOrder){
        displayMenu();
        System.out.println("Please enter a menu item index, s to submit, or q to quit:");
        String itemNumber = System.console().readLine();

        while(!itemNumber.equals("q") && !itemNumber.equals("s") && !itemNumber.equals("r")) {
            newOrder.addItems(menu.get(Integer.parseInt(itemNumber)));

            System.out.println("Please enter a menu item number to add! (s to submit, r to restart, or q to quit):");
            itemNumber = System.console().readLine();
        }
        if (itemNumber.equals("s")){
            orders.add(newOrder);
            processOrder(newOrder);
        }
        if (itemNumber.equals("r")){
            System.out.println("Would you like to restart your order? (y or n)");
            String restart = System.console().readLine();
            System.out.println(restart);
            if (restart.equals("y")){
                newOrder = null;
                newOrder();
            } else if (restart.equals("n")){
                newOrder = null;
                System.out.print("Sorry you didn't end up dining with us!");
            } else {
                System.out.println("I dont undersatnd,\n Would you like to restart your order? (y or n)<--ONLY");
                restart = System.console().readLine();
            }
            
        }
        if (itemNumber.equals("q")){
            menu.clear();
            newOrder = null;
            System.out.print("Sorry you didn't end up dining with us!");
        }
    }

    public void processOrder(Order order){
        System.out.println("We are getting right on that!");

        try {

            System.out.println("Start..." + new Date());
            order.getStatusMessage();


            TimeUnit.SECONDS.sleep(5);
            System.out.println("End..." + new Date());

            order.orderReady(true);
            System.out.println(order.getStatusMessage());

        } catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
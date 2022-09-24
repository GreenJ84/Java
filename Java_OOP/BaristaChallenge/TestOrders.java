
public class TestOrders{
    public static void main(String[] args){
        Item item1 = new Item("Drip Cofee", 2.25);
        Item item2 = new Item("Mocha", 3.25);
        Item item3 = new Item("Latte", 4.25);
        Item item4 = new Item("Cappuccino", 4.75);

        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order("Cindhuri");
        Order order4 = new Order("Jimmy");
        Order order5 = new Order("Noah");
        Order order6 = new Order("Sam");

        order1.addItems(item2);
        order1.addItems(item3);
        order1.addItems(item3);

        order2.addItems(item1);
        order2.addItems(item3);

        order3.addItems(item4);
        order3.addItems(item2);

        order4.addItems(item4);
        order4.addItems(item3);

        order5.addItems(item1);
        order5.addItems(item1);
        order5.addItems(item2);
        order5.addItems(item3);

        order2.orderReady(true);
        order3.orderReady(true);
        order4.orderReady(true);

        System.out.println(order1.getStatusMessage());
        System.out.println(order2.getStatusMessage());
        System.out.println(order3.getStatusMessage());
        System.out.println(order4.getStatusMessage());
        System.out.println(order5.getStatusMessage());

        System.out.println(order1.getOrderTotal());
        System.out.println(order5.getOrderTotal());

        order1.displayOrder();
        order2.displayOrder();
        order3.displayOrder();
        order4.displayOrder();
        order5.displayOrder();

    }
}
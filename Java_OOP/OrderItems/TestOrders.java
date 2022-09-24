
public class TestOrders{
    public static void main(String[] args){
        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        item1.setName("Drip Cofee");
        item1.setPrice(2.25);

        item2.setName("Mocha");
        item2.setPrice(3.25);

        item3.setName("Latte");
        item3.setPrice(4.25);

        item4.setName("Cappuccino");
        item4.setPrice(4.75);


        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        Order order4 = new Order();

        order1.setName("Cindhuri");
        order2.setName("Jimmy");
        order3.setName("Noah");
        order4.setName("Sam");


        order2.addItems(item1);
        System.out.println(order2.total);

        order3.addItems(item4);
        System.out.println(order3.total);

        order4.addItems(item3);
        System.out.println(order4.total);

        order1.orderReady();
        System.out.println(order1.ready);

        order4.addItems(item3);
        order4.addItems(item3);
        System.out.println(order4.total);

        order2.orderReady();
        System.out.println(order2.ready);



    }
}
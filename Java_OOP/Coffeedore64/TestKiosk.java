
public class TestKiosk{
    public static void main(String[] args){
        
        CoffeeKiosk drips = new CoffeeKiosk();

        drips.addMenuItem("Drip Coffee", 2.25);
        drips.addMenuItem("Mocha", 3.25);
        drips.addMenuItem("Cappuccino", 3.75);
        drips.addMenuItem("Latte", 4.25);
        drips.addMenuItem("Muffin", 2.50);
        drips.addMenuItemByInput();

        drips.newOrder();
    }
}
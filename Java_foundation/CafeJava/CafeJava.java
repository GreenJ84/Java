public class CafeJava {
    public static void main(String[] args) {

        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double dripCoffeePrice = 2.25;
        double mochaPrice = 3.5;
        double cappuccinoPrice = 4.5;
        double lattePrice = 4.25;
    
        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions (add yours below)
        boolean isReadyOrder1 = true;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = true;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1);
        System.out.println(displayTotalMessage + dripCoffeePrice);
        if (isReadyOrder1){
            System.out.println(customer1 + readyMessage);}
        else{
            System.out.println(customer1 + pendingMessage);
        }


        System.out.println(generalGreeting + customer4);
        if (isReadyOrder4){
            System.out.println(customer4 + readyMessage);}
        else{
            System.out.println(customer4 + pendingMessage);
        }


        System.out.println(generalGreeting + customer2);
        System.out.println(displayTotalMessage + (2 * lattePrice));
        if (isReadyOrder2){
            System.out.println(customer2 + readyMessage);}
        else{
            System.out.println(customer2 + pendingMessage);
        }

        System.out.println(generalGreeting + customer3);
        System.out.println(displayTotalMessage + dripCoffeePrice);
        double difference = lattePrice - dripCoffeePrice;
        System.out.println("Thank you for letting us know about the undercharge! You will only pay the differnece! " + displayTotalMessage + difference);
        if (isReadyOrder3){
            System.out.println(customer3 + readyMessage);}
        else{
            System.out.println(customer3 + pendingMessage);
        }





    }
}
import java.util.*;
import java.text.*;

public class CafeUtil{

    public int getStreakGoal(){
        int streakLength = 10;
        int purchasesNeeded = 0;
        while (streakLength > 0){
            purchasesNeeded +=  streakLength;
            streakLength = streakLength - 1;
        }
        return purchasesNeeded;
    }
    public int getStreakGoal(int num){
        int streakLength = num;
        int purchasesNeeded = 0;
        while (streakLength > 0){
            purchasesNeeded +=  streakLength;
            streakLength = streakLength - 1;
        }
        return purchasesNeeded;
    }

    public double getOrderTotal(double[] lineItems){
        double total = 0.0;
        // for (int i = 0; i < lineItems.size(); i++){
        for (double item : lineItems){
            total += item;
        }
        return total;
    }

    public void displayMenu(ArrayList menu){
        for (int i = 0; i < menu.size(); i++){
            System.out.println("" +i + " " +menu.get(i));
        }
    }

    public void addCustomer(ArrayList customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello, " + userName);
        int ahead = customers.size();
        System.out.println("There are " +ahead +" people in front of you");
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for ( int i = 1; i <= maxQuantity; i++){
            double discount = .5 * (i-1);
            double cost = price * i - discount; 
            System.out.format("%d - $%.2f \n", i, cost);
        }
        System.out.println("\n");
    }
    
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if (menuItems.size() != prices.size()){
            return false;
        }
        for (int i = 0; i < menuItems.size(); i++){
            System.out.println(i +" " +menuItems.get(i) +" -- $" +prices.get(i));
        }
        return true;
    }
}
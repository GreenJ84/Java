import java.util.*;
import java.lang.*;
import java.math.*;

public class BankAccount{
    private double checkingBalance;
    private double savingBalance;
    private String accountNumber;
    public static int numberOfAccounts = 0;
    public static int totalMoneyStored = 0;
    public static ArrayList<String> accountNumbers = new ArrayList<String>();

    public BankAccount(){

        checkingBalance = 0;
        savingBalance = 0;
        numberOfAccounts++;
        accountNumber();
    }
    public BankAccount(int savingDeposit, int checkingDeposit){
        checkingBalance = checkingDeposit;
        savingBalance = savingDeposit;
        numberOfAccounts++;
        totalMoneyStored += checkingDeposit + savingDeposit;
    }

    public void accountNumber(){
        String numberTest = numGenerator();
        if ( accountNumbers.contains(numberTest)){
            numberTest = numGenerator();
            while ( accountNumbers.contains(numberTest)){
                numberTest = numGenerator();
            }
        }
        accountNumbers.add(numberTest);
        accountNumber = numberTest;
    }

    private String numGenerator(){
        int i = 0;
        int y;
        String x = "";
        while (i < 10){
            y = (int)(Math.random()*9);
            x += ""+y;
            i++;
        }
        return x;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public double getCheckingBalance(){
        return checkingBalance;
    }

    public double getSavingBalance(){
        return savingBalance;
    }

    public double getBalances(){
        double balance = savingBalance + checkingBalance;
        return balance;
    }

    public void depositChecking(double deposit){
        this.checkingBalance += deposit;
        totalMoneyStored += deposit;
    }
    public void depositSaving(double deposit){
        this.savingBalance += deposit;
        totalMoneyStored += deposit;
    }

    public void withdrawlChecking(double withdrawl){
        if (this.checkingBalance < withdrawl){
            System.out.println("Insufficient Funds!");
            return;
        }
        this.checkingBalance -= withdrawl;
        totalMoneyStored -= withdrawl;
    }
    public void withdrawlSaving(double withdrawl){
        if (this.savingBalance < withdrawl){
            System.out.println("Insufficient Funds!");
            return;
        }else{
        this.savingBalance -= withdrawl;
        totalMoneyStored -= withdrawl;
        }
    }
}
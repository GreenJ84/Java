public class BankAccountTest{
    public static void main(String[] args){
        BankAccount jesse = new BankAccount();
        System.out.println(jesse.getCheckingBalance());
        System.out.println(jesse.getSavingBalance());
        System.out.println(jesse.getAccountNumber());

        jesse.depositSaving(25.08);
        jesse.depositChecking(11.86);
        System.out.println(jesse.getBalances());
        System.out.println(jesse.getSavingBalance());
        System.out.println(jesse.getCheckingBalance());

        jesse.withdrawlSaving(100.08);
        jesse.withdrawlChecking(1.86);

        System.out.println(jesse.getSavingBalance());
        System.out.println(jesse.getCheckingBalance());
    }
}
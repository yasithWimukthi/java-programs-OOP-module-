package AutoboxingAndUnboxing;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank("BOC");
        bank.addBranch("Colombo");

        bank.addCustomer("Colombo","Tim",1000.00);
        bank.addCustomer("Colombo","Tom",5000.00);
        bank.addCustomer("Colombo","Percy",4500.00);

        bank.addBranch("Matara");
        bank.addCustomer("Matara","Mike",2000.00);

        bank.addCustomerTransaction("Colombo","Tim",2500.00);
        bank.addCustomerTransaction("Colombo","Tim",4000.00);

        bank.listCustomers("Colombo",false);
    }
}

import Models.Customer;
import Utilities.DBUtility;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = DBUtility.getCustomers();
        System.out.println("customers size: "+customers.size());

    }
}

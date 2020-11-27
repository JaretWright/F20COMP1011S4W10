import Models.Customer;
import Utilities.DBUtility;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Customer> customers = DBUtility.getCustomers();
        System.out.println("customers size: "+customers.size());

        //Display all the customers in the console
//        for (Customer customer : customers) {
//            if (customer.getPhoneNumber().getAreaCode().equalsIgnoreCase("705"))
//                System.out.println(customer);
//        }

        //the same thing, using Streams
        System.out.println("Printed from a stream");
        customers.stream().forEach(System.out::println);

        //using a stream, display all the phone numbers in the 705 area code
        System.out.println("the number of customers in the 705 area code is: "+
                customers.stream()
                        .map(Customer::getPhoneNumber)  //the stream converts from a stream of
                                                // Customer objects to a stream of PhoneNumber
                                                //objects
                        .filter(phoneNumber -> phoneNumber.getAreaCode().equals("705"))
                        .count());


    }
}

import Models.Customer;
import Utilities.DBUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;

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


        //display all the customers over 18
        List<Customer> over65 = customers.stream()
                                .filter(customer -> customer.getAge()>=65)
                                .collect(Collectors.toList());

        System.out.println("# of Customers over 18: "+over65.size());

        OptionalDouble avgAge = customers.stream()
                                .mapToDouble(Customer::getAge)
                                .average();

        if (avgAge.isPresent())
            System.out.println("Average age is: "+avgAge.getAsDouble());

        Map<String, Long> bloodTypeCount = customers.stream()
                                                .map(Customer::getBloodType)
                                                .collect(Collectors.groupingBy(Function.identity(),
                                                                Collectors.counting()));
        System.out.println(bloodTypeCount);
    }
}

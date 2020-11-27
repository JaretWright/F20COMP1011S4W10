package Utilities;

import Models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "student";
    private static String password = "student";
    private static String connString = "jdbc:mysql://localhost:3306/F20COMP1011Test2";

    public static ArrayList<Customer> getCustomers()
    {
        ArrayList<Customer> customers = new ArrayList<>();
       try(
            Connection conn = DriverManager.getConnection(connString, user, password);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");
               )
       {
           while (resultSet.next())
           {
               Customer newCustomer = new Customer(
                       resultSet.getInt("number"),
                       resultSet.getString("firstName"),
                       resultSet.getString("lastName"),
                       resultSet.getString("cctype"),
                       resultSet.getString("bloodtype"),
                       resultSet.getString("telephonenumber"),
                       Double.parseDouble(resultSet.getString("kilograms")),
                       Double.parseDouble(resultSet.getString("centimeters")));
               customers.add(newCustomer);
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
        return customers;
    }
}

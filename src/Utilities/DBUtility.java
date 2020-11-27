package Utilities;

import Models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
               String[] birthdayArray = resultSet.getString("birthday").split("/");
               int year = Integer.parseInt(birthdayArray[2]);
               int month = Integer.parseInt(birthdayArray[0]);
               int day = Integer.parseInt(birthdayArray[1]);

               LocalDate birthday = LocalDate.of(year, month, day);
               Customer newCustomer = new Customer(
                       resultSet.getInt("number"),
                       resultSet.getString("firstName"),
                       resultSet.getString("lastName"),
                       resultSet.getString("cctype"),
                       resultSet.getString("bloodtype"),
                       resultSet.getString("telephonenumber"),
                       Double.parseDouble(resultSet.getString("kilograms")),
                       Double.parseDouble(resultSet.getString("centimeters")),
                       birthday);
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

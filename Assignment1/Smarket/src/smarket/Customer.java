/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarket;

import java.util.Comparator;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Ankit
 */
public class Customer implements Comparator<Customer> {

    private String CN;
    private String name;
    private String address;
    private String tele_no;
    private String driv_lic;
    private int purchase;

    public Customer()
    {
    }

    
     /**
     *
     * @param unique_customer_number
     * @param name
     * @param address
     * @param telephone_number
     * @param driving_license
     * @param purchase
     */
    public Customer(String unique_customer_number, String customer_name, String customer_address, String telephone_number, String driving_license, int net_Purchase)
    {
        CN = unique_customer_number;
        name = customer_name;
        address = customer_address;
        tele_no = telephone_number;
        driv_lic = driving_license;
        purchase = 0;
    }

    public Customer(Scanner input)
    {
        CN = input.nextLine();
        name = input.nextLine();
        address = input.nextLine();
        tele_no = input.nextLine();
        driv_lic = input.nextLine();
        purchase = input.nextInt();
    }

    public void add_Purchase(int current_Purchase)
    {
        purchase += current_Purchase;
    }

    public String get_CN()
    {
        return CN;
    }

    public int get_Purchase()
    {
        return purchase;
    }

    public void reset_Purchase()
    {
        purchase = 0;
    }

    public void print_Customer_Info(Formatter output)
    {
        output.format("%s\n%s\n%s\n%s\n%s\n%d\n", CN, name, address, tele_no, driv_lic, purchase);
    }

    public void write_To_File(Formatter output)
    {
        output.format("%s\n%s\n%s\n%s\n%s\n%d\n", CN, name, address, tele_no, driv_lic, purchase);
    }
//    public int compareTo(Customer c1)
//    {
//        return c1.purchase-this.purchase;
//    }

    public int compare(Customer c1, Customer c2)
    {
        return c2.purchase - c1.purchase;
    }
}

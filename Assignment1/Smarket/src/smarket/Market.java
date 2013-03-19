/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarket;

import java.io.*;
import java.util.*;

/**
 *
 * @author Ankit
 */
public class Market {

    private Scanner cus_Read, sale_Read, winner_Read;
    private Formatter cus_Write, sale_Write, console_Write, winner_Write;
    private ArrayList<Customer> customer_Info;
    private ArrayList<Sales> sales_Info;
    private int total_Customer;
    private int total_Sales_Record;
    private String customer_File_name, sales_File_Name, winner_File_Name;
    private Scanner in;

    private void open_Files_To_Read()
    {
        try
        {
            cus_Read = new Scanner(new File(customer_File_name));
            // info=new Scanner(new File (info_Data_File));
            sale_Read = new Scanner(new File(sales_File_Name));
            //   winner_Read = new Scanner(new File(winner_File_Name));
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening File");
            //  System.exit(1);
        }
    }

    private void open_Files_To_Wright()
    {
        try
        {
            cus_Write = new Formatter(customer_File_name);
            sale_Write = new Formatter(sales_File_Name);
        }
        catch (FileNotFoundException fileNotFoundException)
        {
            System.err.println("Error opening/creating File");
            System.exit(1);
        }
    }

    Market()
    {
        customer_File_name = "customer_Data_File.txt";
        sales_File_Name = "sales_Data_File.txt";
        winner_File_Name = "winner_Data_File.txt";
        open_Files_To_Read();
        //totalCustomer=info.nextInt();
        console_Write = new Formatter(System.out);
        load_Records();
        update_Sales_Record();
        in = new Scanner(System.in);
    }

    Market(String customer_Data_File, String sales_Data_File, String winner_Data_File)
    {
        customer_File_name = customer_Data_File;
        sales_File_Name = sales_Data_File;
        winner_File_Name = winner_Data_File;
        open_Files_To_Read();
        //totalCustomer=info.nextInt();
        load_Records();
        update_Sales_Record();
        in = new Scanner(System.in);
    }

    public void save_Data_To_File()
    {
        open_Files_To_Wright();

        for (int i = 0; i < customer_Info.size(); i++)
        {
            customer_Info.get(i).write_To_File(cus_Write);
        }
        cus_Write.close();
        for (int i = 0; i < sales_Info.size(); i++)
        {
            sales_Info.get(i).write_To_File(sale_Write);
        }
        sale_Write.close();
    }

    public boolean update_Sales_Record()
    {
        int year;
        try
        {
            winner_Read = new Scanner(new File(winner_File_Name));
            year = winner_Read.nextInt();
            winner_Read.close();
        }
        catch (NoSuchElementException e)
        {
            winner_Read.close();
            year = 0;
        }
        catch (FileNotFoundException e)
        {
            year = 0;
        }
        Calendar cal = Calendar.getInstance();
        //    System.out.printf("%tc\n", cal);
        int totalsales = 0;
// if (( (cal.get(cal.YEAR) > year)))
        if ((cal.get(cal.DATE) == 31 && cal.get(cal.MONTH) == cal.DECEMBER && (cal.get(cal.YEAR) > year)))
        {
            try
            {
                winner_Write = new Formatter(new File(winner_File_Name));

                for (int i = 0; i < total_Customer; i++)
                {
                    totalsales += customer_Info.get(i).get_Purchase();

                }
                winner_Write.format("%d\r\n", cal.get(cal.YEAR));
                get_Gold_Coin_Customer();
                winner_Write.format("\r\n");
                get_Top_Customers();
                for (int i = 0; i < total_Customer; i++)
                {
                    customer_Info.get(i).reset_Purchase();

                }
                sales_Info.add(new Sales(totalsales, cal.get(cal.YEAR)));
                winner_Write.close();
                return true;
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
        //sales_Info.get(sales_Info.size() - 1).netsales = totalsales;
        return false;
    }

    private void load_Records()
    {
        customer_Info = new ArrayList();
        sales_Info = new ArrayList();
        if (cus_Read != null)
        {
            while (cus_Read.hasNext())
            {
                customer_Info.add(new Customer(cus_Read));
                cus_Read.nextLine();
            }
            cus_Read.close();
        }
        if (sale_Read != null)
        {
            while (sale_Read.hasNext())
            {
                sales_Info.add(new Sales(sale_Read));
            }
            total_Customer = customer_Info.size();
            total_Sales_Record = sales_Info.size();
            sale_Read.close();
        }


    }

    public void new_Customer_Record()
    {
        String CN, name = null, address = null, tele_no = null, driv_no = null;
        CN = "CN" + (++total_Customer);

        while (name == null)
        {
            System.out.print("Enter Name:");
            name = in.nextLine();
        }
        while (address == null)
        {
            System.out.print("Enter Address:");
            address = in.nextLine();
        }
        while (tele_no == null)
        {
            System.out.print("Enter Telephone Number:");
            tele_no = in.nextLine();
        }
        while (driv_no == null)
        {
            System.out.print("Enter Driving License Number:");
            driv_no = in.nextLine();
        }
        customer_Info.add(new Customer(CN, name, address, tele_no, driv_no, 0));
        System.out.println("Your Unique Costumer Number is : " + CN);
    }

    public void manager()
    {
        System.out.println("Welcome Manager");
        while (true)
        {
            System.out.println("Enter 1 to view sales recored");
            System.out.println("Enter 2 to view and store winners");
            System.out.println("Enter 0 to return to previous menu");
            int a = in.nextInt();
            switch (a)
            {
                case 0:
                    return;
                case 1:
                    show_Sales_Record();
                    break;
                case 2:
                    update_and_show_winner();
                    break;
                default:
                    System.out.println("Enter a valid number");
            }
        }
    }

    public void update_Purchase()
    {
        String CN;
        int purchase;
        System.out.print("Enter Unique Costumer Number:");
        CN = in.next();
        System.out.print("Enter Purchase:");
        purchase = in.nextInt();
        for (int i = 0; i < total_Customer; i++)
        {
            if (customer_Info.get(i).get_CN().contentEquals(CN))
            {
                customer_Info.get(i).add_Purchase(purchase);
                System.out.println("purchase sucessfully upated");
                return;
            }
        }

        System.out.println("Invlaid Unique Costumer Number : " + CN);

    }

    private void get_Gold_Coin_Customer()
    {
        for (int i = 0; i < total_Customer; i++)
        {
            if (customer_Info.get(i).get_Purchase() > 10000)
            {
                //    customer_Info.get(i).print_Customer_Info(console_Write);
                customer_Info.get(i).print_Customer_Info(winner_Write);
            }
        }
    }

    private void get_Top_Customers()
    {

        Collections.sort(customer_Info, new Customer());
        int i;
        for (i = 0; i < total_Customer && i < 10; i++)
        {

            //  customer_Info.get(i).print_Customer_Info(console_Write);
            customer_Info.get(i).print_Customer_Info(winner_Write);
        }
        while ((i < total_Customer) && (customer_Info.get(i).get_Purchase() == customer_Info.get(i - 1).get_Purchase()))
        {
            //  customer_Info.get(i).print_Customer_Info(console_Write);
            customer_Info.get(i).print_Customer_Info(winner_Write);
            i++;
        }
    }

    private void show_Sales_Record()
    {
        System.out.println("Year\tSales");
        int i;
        Calendar cal = Calendar.getInstance();
        for (i = 0; i < sales_Info.size(); i++)
        {
            System.out.println("" + sales_Info.get(i).year + "\t" + sales_Info.get(i).netsales);
        }

        if (sales_Info.size() == 0 || sales_Info.get(sales_Info.size() - 1).year < cal.get(cal.YEAR))
        {
            int totalsales = 0;
            for (i = 0; i < total_Customer; i++)
            {
                totalsales += customer_Info.get(i).get_Purchase();

            }
            System.out.println("" + cal.get(cal.YEAR) + "\t" + totalsales);
        }
    }

    private void update_and_show_winner()
    {
        update_Sales_Record();
        try
        {
            winner_Read = new Scanner(new File(winner_File_Name));
            winner_Read.nextLine();
            System.out.println("Gold coin customers:");
            System.out.println("CN\tName\tAddress\tTelephone\tdriving lic\tpurchase");
            String str = winner_Read.nextLine();
            while (!str.equals(""))
            {
                System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", str, winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine());
                str = winner_Read.nextLine();
            }
            System.out.println("Top customers:");
            System.out.println("CN\tName\tAddress\tTelephone\tdriving lic\tpurchase");
            while (true)
            {
                System.out.printf("%s\t%s\t%s\t%s\t%s\t%s\n", winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine(), winner_Read.nextLine());
            }

        }
        catch (NoSuchElementException e)
        {
            winner_Read.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("No winner list yet created");
        }

    }
}

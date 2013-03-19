/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarket;

import java.util.*;

/**
 *
 * @author Ankit
 */
public class Smarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        Market m1;
        if (args.length == 3)
        {
            m1 = new Market(args[0], args[1], args[2]);
        }
        else
        {
            m1 = new Market();
        }
        int a;
        while (true)
        {
            System.out.println("To Exit Enter 0");
            System.out.println("New Customer Enter 1");
            System.out.println("Staff Enter 2");
            System.out.println("Manager Enter 3");
            System.out.print("Enter Choice: ");
            a = in.nextInt();
            switch (a)
            {
                case 0:
                    m1.save_Data_To_File();
                    System.exit(0);
                    break;
                case 1:
                    m1.new_Customer_Record();
                    break;
                case 2:
                    m1.update_Purchase();
                    break;
                case 3:
                    m1.manager();
                    break;
                default:
                    System.out.println("Enter a valid number");

            }
        }

    }
}

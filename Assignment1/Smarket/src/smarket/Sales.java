/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package smarket;

import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Ankit
 */
public class Sales {

    public int netsales;
    public int year;

    Sales(int sale, int year_of_sale)
    {
        netsales = sale;
        year = year_of_sale;
    }

    Sales(Scanner input)
    {
        netsales = input.nextInt();
        year = input.nextInt();
    }

    public void write_To_File(Formatter output)
    {
        output.format("%d %d\n", netsales, year);
    }
}

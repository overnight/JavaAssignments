/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iitcoursemanagement;

/**
 *
 * @author Ankit
 */
public class IITCourseManagement {

    /**
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        String a = "A";
//        System.out.print(getEqPoint(a));
//        // TODO code application logic here
//    }
    public static int getEqPoint(String a)
    {
        switch (a)
        {
            case "EX":
                return 10;
            case "A":
                return 9;
            case "B":
                return 8;
            case "C":
                return 7;
            case "D":
                return 6;
            case "P":
                return 5;
            default:
                return -1;
        }
    }
}

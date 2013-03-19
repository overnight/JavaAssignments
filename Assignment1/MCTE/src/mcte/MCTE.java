/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcte;

/**
 *
 * @author Ankit
 */
public class MCTE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        MCTEFrame f1;
        if (args.length == 1)
        {
            f1 = new MCTEFrame(args[0]);
        }
        else
        {
            f1 = new MCTEFrame();
        }
        f1.setBounds(200, 200, 400, 400);
        f1.setVisible(true);
        f1.start();
        // TODO code application logic here
    }
}

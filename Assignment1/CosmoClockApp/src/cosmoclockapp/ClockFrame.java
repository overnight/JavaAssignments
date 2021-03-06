/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoclockapp;

import com.sun.awt.AWTUtilities;
import java.awt.*;
import java.util.*;

/**
 *
 * @author Ankit
 */
public class ClockFrame extends javax.swing.JFrame {

    /**
     * Creates new form ClockFrame
     */
    java.util.List componentList;
    ComponentWrangler wrangler;
    final int PAD = 10;

    public ClockFrame()
    {
        initComponents();

//        setUndecorated(false);
//setBackground(new Color(0,0,0,0));
     //   setOpacity(0.8f);
     //    AWTUtilities.setWindowOpacity(this, 0.40f);
        componentList = new ArrayList();
        wrangler = new ComponentWrangler();
        setLayout(null);
        setSize(360,260);

    }

    public void addNext(Component c)
    {
        componentList.add(c);
        c.addMouseListener(wrangler);
        c.addMouseMotionListener(wrangler);
        add(c);
        Dimension d = c.getPreferredSize();
        Point p = getNextLocation(d);
        c.setBounds(p.x, p.y, d.width, d.height);
        repaint();
    }

    private Point getNextLocation(Dimension d)
    {
        int maxX = 0, maxY = 0;
        Component c, last = null;
        Rectangle r;
        // find level of lowest component(s)
        for (int j = 0; j < componentList.size(); j++)
        {
            c = (Component) componentList.get(j);
            r = c.getBounds();
            if (r.y + r.height > maxY)
            {
                maxY = r.y + r.height;
                last = c;
            }
        }
        // find last (in row) of lowest components
        for (int j = 0; j < componentList.size(); j++)
        {
            c = (Component) componentList.get(j);
            r = c.getBounds();
            if (r.y + r.height == maxY && r.x + r.width > maxX)
            {
                maxX = r.x + r.width;
                last = c;
            }
        }
        // determine location of next component based on location of last
        Point p = new Point();
        if (last == null)                                // first component
        {
            p.x = PAD;
            p.y = PAD;
            return p;
        }
        r = last.getBounds();
        int x, y;
        if (r.x + r.width + PAD + d.width < getWidth())  // next in row
        {
            p.x = r.x + r.width + PAD;
            p.y = r.y;
        }
        else                                            // skip to new row
        {
            p.x = PAD;
            p.y = r.y + r.height + PAD;
        }
        return p;
    }

    /**
     * select and drag components with the mouse
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(10000, 10000));
        setPreferredSize(new java.awt.Dimension(700, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

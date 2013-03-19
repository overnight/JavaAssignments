/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoclockapp;

import java.util.Arrays;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.*;
import javax.swing.text.AbstractDocument;
import sun.misc.JavaxSecurityAuthKerberosAccess;

/**
 *
 * @author Ankit
 */
public class CosmoClockApplet extends javax.swing.JApplet {

    /**
     * Initializes the applet CosmoClockApplet
     */
    java.util.List componentList;
    ComponentWrangler wrangler;
    final int PAD = 10;
    ScheduledThreadPoolExecutor threadexecutor;
    Thread t1, t2, t3, t4, t5, t6;

    @Override
    public void init()
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }
        catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(CosmoClockApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(CosmoClockApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(CosmoClockApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(CosmoClockApplet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the applet */
        Calendar cal = Calendar.getInstance();
        ClockPanel p1 = new ClockPanel(cal);
        ClockPanel p2 = new ClockPanel(cal);
        ClockPanel p3 = new ClockPanel(cal);
        ClockPanel p4 = new ClockPanel(cal);
        ClockPanel p5 = new ClockPanel(cal);
        ClockPanel p6 = new ClockPanel(cal);

        resize(700, 600);
        Container content = getContentPane();

        //  content.setLayout(new GridLayout(2,3));
        addNext(p6, content);
        addNext(p5, content);
        addNext(p4, content);
        addNext(p3, content);
        addNext(p2, content);
        addNext(p1, content);
        // content.setLayout(null);
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(p1);
        threadExecutor.execute(p2);
        threadExecutor.execute(p3);
        threadExecutor.execute(p4);
        threadExecutor.execute(p5);
        threadExecutor.execute(p6);
        try
        {
            // javax.swing.SwingUtilities.invokeAndWait(p1);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }


    /* public void destroy()
     {
     threadexecutor.shutdownNow();
     }*/
    public CosmoClockApplet()
    {
        initComponents();
        componentList = new ArrayList();
        wrangler = new ComponentWrangler();
        setLayout(null);
    }

    public void addNext(Component c, Container g)
    {
        componentList.add(c);
        c.addMouseListener(wrangler);
        c.addMouseMotionListener(wrangler);
        g.add(c);
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
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(700, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

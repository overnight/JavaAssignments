/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoclockapp;

import java.awt.*;
import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

/**
 *
 * @author Ankit
 */
public class CosmoClockApp {

    public static void main(String[] args)
    {
        String zones[] = TimeZone.getAvailableIDs();
        Arrays.sort(zones);
        Calendar cal = Calendar.getInstance();

        ClockFrame f1 = new ClockFrame();
        ClockFrame f2 = new ClockFrame();
        ClockFrame f3 = new ClockFrame();
        ClockFrame f4 = new ClockFrame();
        ClockFrame f5 = new ClockFrame();
        ClockFrame f6 = new ClockFrame();
        ClockPanel p1 = new ClockPanel(cal);
        ClockPanel p2 = new ClockPanel(cal);
        ClockPanel p3 = new ClockPanel(cal);
        ClockPanel p4 = new ClockPanel(cal);
        ClockPanel p5 = new ClockPanel(cal);
        ClockPanel p6 = new ClockPanel(cal);
//         Thread t1 = new Thread(p1);
//         Thread t2 = new Thread(p6);
//         Thread t3 = new Thread(p5);
//         Thread t4 = new Thread(p4);
//         Thread t5 = new Thread(p3);
//         Thread t6 = new Thread(p2);
        f1.addNext(p1);
        f2.addNext(p2);
        f3.addNext(p3);
        f4.addNext(p4);
        f5.addNext(p5);
        f6.addNext(p6);
        ExecutorService threadExecutor = Executors.newCachedThreadPool();
        threadExecutor.execute(p1);
        threadExecutor.execute(p2);
        threadExecutor.execute(p3);
        threadExecutor.execute(p4);
        threadExecutor.execute(p5);
        threadExecutor.execute(p6);
//         ScheduledThreadPoolExecutor threadexecutor = new ScheduledThreadPoolExecutor(7);
//         threadexecutor.scheduleAtFixedRate(t1,1,50,TimeUnit.MILLISECONDS);
//         threadexecutor.scheduleAtFixedRate(t2,1,50,TimeUnit.MILLISECONDS);
//         threadexecutor.scheduleAtFixedRate(t3,1,50,TimeUnit.MILLISECONDS);
//         threadexecutor.scheduleAtFixedRate(t4,1,50,TimeUnit.MILLISECONDS);
//         threadexecutor.scheduleAtFixedRate(t5,1,50,TimeUnit.MILLISECONDS);
//         threadexecutor.scheduleAtFixedRate(t6,1,50,TimeUnit.MILLISECONDS);
        f1.setVisible(true);
         f2.setVisible(true);

          f3.setVisible(true);

           f4.setVisible(true);

            f5.setVisible(true);

             f6.setVisible(true);


        // t1.start();

    }
}

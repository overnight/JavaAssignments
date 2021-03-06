/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cosmoclockapp;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.*;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Ankit
 */
public class ClockPanel extends javax.swing.JPanel implements Runnable {

    /**
     * Creates new form NewJPanel
     */
    Calendar cal;
    boolean dot = false;
    String str;
    boolean TimeChange;
    int hr, mm, sec;
    int msec;
    String zones[];
    //   AnalogClockPanel ang;

    public ClockPanel(Calendar cal1)
    {
        initComponents();
//        jComboBoxCities.removeAllItems();
        zones = TimeZone.getAvailableIDs();
        List<String> zon = new ArrayList();
        HashSet hs = new HashSet();
        cal = Calendar.getInstance();
        TimeZone t = TimeZone.getDefault();
        for (int i = 0; i < zones.length; i++)
        {
            zon.add(TimeZone.getTimeZone(zones[i]).getDisplayName());

        }
        hs.addAll(zon);
        zon.clear();
        zon.addAll(hs);
        Collections.sort(zon);
        for (int i = 0; i < zon.size(); i++)
        {

            jComboBoxCities.addItem(zon.get(i));
            if (zon.get(i).equals(cal.getTimeZone().getDisplayName()))
            {
                jComboBoxCities.setSelectedItem(zon.get(i));
            }
        }
        sec = cal1.get(Calendar.SECOND);
        mm = cal1.get(Calendar.MINUTE);
        hr = cal1.get(Calendar.HOUR);
        msec = 0;
        if (cal1.get(Calendar.AM_PM) == 1)
        {
            hr += 12;
        }
        jCheckBoxCanChange.setEnabled(true);
        dot = true;
    }

    public void run()
    {
        while (true)
        {
            msec++;
            if (msec == 20)
            {
                msec = 0;

                sec++;
                if (sec >= 60)
                {
                    sec = 0;
                    mm++;
                }
                if (mm >= 60)
                {
                    mm = 0;
                    hr++;
                }
                if (hr >= 24)
                {
                    hr = 0;
                }


                jPanelAnalogClk.drawclock(hr, mm, sec);
                if (TimeChange == false)
                {
                    jTextFieldHr.setText("" + hr);
                    jTextFieldMm.setText("" + mm);
                    jTextFieldSec.setText("" + sec);
                }

            }
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException exception)
            {
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelAnalogClk = new AnalogClockPanel();
        jComboBoxCities = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jPanelDigiClock = new javax.swing.JPanel();
        jTextFieldHr = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldMm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldSec = new javax.swing.JTextField();
        jCheckBoxCanChange = new javax.swing.JCheckBox();
        jSliderClkSize = new javax.swing.JSlider();
        jLabel3 = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(329, 210));
        setPreferredSize(new java.awt.Dimension(329, 210));

        jPanelAnalogClk.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelAnalogClk.setFocusable(false);

        javax.swing.GroupLayout jPanelAnalogClkLayout = new javax.swing.GroupLayout(jPanelAnalogClk);
        jPanelAnalogClk.setLayout(jPanelAnalogClkLayout);
        jPanelAnalogClkLayout.setHorizontalGroup(
            jPanelAnalogClkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );
        jPanelAnalogClkLayout.setVerticalGroup(
            jPanelAnalogClkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 119, Short.MAX_VALUE)
        );

        jComboBoxCities.setMaximumSize(new java.awt.Dimension(283, 20));
        jComboBoxCities.setMinimumSize(new java.awt.Dimension(283, 20));
        jComboBoxCities.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBoxCitiesItemStateChanged(evt);
            }
        });

        jPanelDigiClock.setLayout(new javax.swing.BoxLayout(jPanelDigiClock, javax.swing.BoxLayout.LINE_AXIS));

        jTextFieldHr.setEditable(false);
        jTextFieldHr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldHr.setText("00");
        jPanelDigiClock.add(jTextFieldHr);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText(":");
        jPanelDigiClock.add(jLabel1);

        jTextFieldMm.setEditable(false);
        jTextFieldMm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldMm.setText("00");
        jPanelDigiClock.add(jTextFieldMm);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText(":");
        jPanelDigiClock.add(jLabel2);

        jTextFieldSec.setEditable(false);
        jTextFieldSec.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSec.setText("00");
        jPanelDigiClock.add(jTextFieldSec);

        jCheckBoxCanChange.setText("Change Time");
        jCheckBoxCanChange.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jCheckBoxCanChangeStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckBoxCanChange)
                .addContainerGap(57, Short.MAX_VALUE))
            .addComponent(jPanelDigiClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jPanelDigiClock, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBoxCanChange)
                .addContainerGap())
        );

        jSliderClkSize.setMajorTickSpacing(10);
        jSliderClkSize.setMinimum(40);
        jSliderClkSize.setMinorTickSpacing(1);
        jSliderClkSize.setPaintTicks(true);
        jSliderClkSize.setPaintTrack(false);
        jSliderClkSize.setValue(100);
        jSliderClkSize.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jSliderClkSizeStateChanged(evt);
            }
        });

        jLabel3.setText("Clock Size");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCities, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jSliderClkSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelAnalogClk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 28, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBoxCities, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelAnalogClk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSliderClkSize, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBoxCanChangeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBoxCanChangeStateChanged
        TimeChange = jCheckBoxCanChange.isSelected();


        jTextFieldHr.setEditable(TimeChange);
        jTextFieldMm.setEditable(TimeChange);
        jTextFieldSec.setEditable(TimeChange);
        if (TimeChange == false)
        {

            str = jTextFieldSec.getText();
            if (!str.equals(null))
            {
                sec = Integer.parseInt(str);
            }
            str = jTextFieldMm.getText();
            if (!str.equals(null))
            {
                mm = Integer.parseInt(str);
            }
            str = jTextFieldHr.getText();
            if (!str.equals(null))
            {
                hr = Integer.parseInt(str);
            }
        }

    }//GEN-LAST:event_jCheckBoxCanChangeStateChanged

    private void jComboBoxCitiesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCitiesItemStateChanged
        if (dot == true)
        {
            int currentofset = cal.get(Calendar.ZONE_OFFSET);
            String zoneDispName = (String) jComboBoxCities.getSelectedItem();
            TimeZone tz;
            int i = -1;
            do
            {
                i++;

                tz = TimeZone.getTimeZone(zones[i]);
            } while (!zoneDispName.equals(tz.getDisplayName()));
            cal.setTimeZone(tz);
            int newofset = cal.get(Calendar.ZONE_OFFSET);


            int offset = newofset - currentofset;


            hr += offset / 3600000;
            offset %= 3600000;

            mm += offset / 60000;
            offset %= 60000;
            sec += offset / 1000;
            if (sec < 0)
            {
                sec += 60;
                mm--;
            }
            if (sec >= 60)
            {
                sec %= 60;
                mm++;
            }
            if (mm < 0)
            {
                mm += 60;
                hr--;
            }
            if (mm >= 60)
            {
                mm %= 60;
                hr++;
            }
            if (hr < 0)
            {
                hr += 24;
            }
            if (hr >= 24)
            {
                hr %= 24;
            }


        }
    }//GEN-LAST:event_jComboBoxCitiesItemStateChanged

    private void jSliderClkSizeStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_jSliderClkSizeStateChanged
    {//GEN-HEADEREND:event_jSliderClkSizeStateChanged
        float val = (float) jSliderClkSize.getValue() / 100;
        jPanelAnalogClk.setscalefactor(val);
    }//GEN-LAST:event_jSliderClkSizeStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBoxCanChange;
    private javax.swing.JComboBox jComboBoxCities;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private AnalogClockPanel jPanelAnalogClk;
    private javax.swing.JPanel jPanelDigiClock;
    private javax.swing.JSlider jSliderClkSize;
    private javax.swing.JTextField jTextFieldHr;
    private javax.swing.JTextField jTextFieldMm;
    private javax.swing.JTextField jTextFieldSec;
    // End of variables declaration//GEN-END:variables
}

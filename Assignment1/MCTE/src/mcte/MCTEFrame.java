/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mcte;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Ankit
 */
public class MCTEFrame extends javax.swing.JFrame {

    /**
     * Creates new form MCTEFrame
     */
    private Scanner scannerTestFile, scannerStudent;
    private Formatter formatterStudRecord;
    private String currStudName, currStudRoll, testfilename;
    private int totalQuesCount, correctAnsCount, currentCorrectOption;
    private Dimension scrnsize;

    public MCTEFrame()
    {
        initComponents();
        //new resultsett
        getContentPane().removeAll();
        scrnsize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp = scrnsize.width / 2;
        scrnsize.width = scrnsize.height / 2;
        scrnsize.height = temp;
        setBounds(scrnsize.height - 50, scrnsize.height - 50, 100, 100);
        testfilename = "testfile.txt";

    }

    public MCTEFrame(String testfile)
    {
        initComponents();
        //new resultsett
        getContentPane().removeAll();
        scrnsize = Toolkit.getDefaultToolkit().getScreenSize();
        int temp = scrnsize.width / 2;
        scrnsize.width = scrnsize.height / 2;
        scrnsize.height = temp;
        setBounds(scrnsize.height - 50, scrnsize.height - 50, 100, 100);
        testfilename = testfile;

    }

    public void start()
    {
        selectUser();
    }

    private void selectUser()
    {

        getContentPane().removeAll();
        setVisible(false);
        while (true)
        {
            //  String a=JOptionPane.showInputDialog(this,"Student Enter 1\n Teacher Enter 2\nTo Exit Enter 3","1");
            //  int k = Integer.parseInt(a);
            int k = JOptionPane.showOptionDialog(this, "Select User", "User", JOptionPane.DEFAULT_OPTION, WIDTH, null, new String[]
                    {
                        "Student", "Teacher", "Exit"
                    }, new String("Student"));
            setVisible(true);
            if (k == 0)
            {
                getContentPane().add(jPanelStudLogin);
                setBounds(scrnsize.height - jPanelStudLogin.getPreferredSize().height / 2, scrnsize.width - jPanelStudLogin.getPreferredSize().width / 2, 50, 50);
                setSize(jPanelStudLogin.getPreferredSize());
                jTextFieldName.setText("");
                jTextFieldRollNo.setText("");
                break;
            }
            if (k == 1)
            {
                getContentPane().add(jPanelPerformance);
                setBounds(scrnsize.height - jPanelPerformance.getPreferredSize().height / 2, scrnsize.width - jPanelPerformance.getPreferredSize().width / 2, 50, 50);
                setSize(jPanelPerformance.getPreferredSize());
                dispTeacherRecords();
                break;
            }
            if (k == 2)
            {
                System.exit(0);
            }
        }
    }

    private void openTestFile()
    {
        try
        {
            scannerTestFile = new Scanner(new File(testfilename));
        }
        catch (FileNotFoundException e)
        {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    private void dispNextQues()
    {
        buttonGroupOptions.clearSelection();
        if (scannerTestFile.hasNext())
        {
            try
            {
                jTextAreaQuestion.setText("Question:" + (totalQuesCount + 1) + ">\n" + scannerTestFile.nextLine());
                jRadioButtonOption1.setText(scannerTestFile.nextLine());
                jRadioButtonOption2.setText(scannerTestFile.nextLine());
                jRadioButtonOption3.setText(scannerTestFile.nextLine());
                jRadioButtonOption4.setText(scannerTestFile.nextLine());
                currentCorrectOption = scannerTestFile.nextInt();
                scannerTestFile.nextLine();
                totalQuesCount++;
            }
            catch (NoSuchElementException e)
            {
                displayStudResult();
            }
        }
        else
        {
            displayStudResult();
        }
    }

    private void displayStudResult()
    {
        scannerTestFile.close();
        getContentPane().removeAll();
        getContentPane().add(jPanelStudResult);
        setBounds(scrnsize.height - jPanelStudResult.getPreferredSize().height / 2, scrnsize.width - jPanelStudResult.getPreferredSize().width / 2, 50, 50);
        setSize(jPanelStudResult.getPreferredSize());
        jTextFieldTotalQues.setText("" + totalQuesCount);
        jTextFieldCorrectAns.setText("" + correctAnsCount);
    }

    private boolean checkCurrentQues()
    {
        switch (currentCorrectOption)
        {
            case 1:
                return jRadioButtonOption1.isSelected();
            case 2:
                return jRadioButtonOption2.isSelected();
            case 3:
                return jRadioButtonOption3.isSelected();
            case 4:
                return jRadioButtonOption4.isSelected();
            default:
                return false;
        }
    }

    private void writeStudentToFile()
    {
        try
        {
            formatterStudRecord = (new Formatter((new FileWriter("student.txt", true))));
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        formatterStudRecord.format("%s\r\n%s\r\n%d %d\r\n", currStudName, currStudRoll, correctAnsCount, totalQuesCount);
        formatterStudRecord.close();
    }

    private void dispTeacherRecords()
    {

        try
        {
            scannerStudent = new Scanner(new File("student.txt"));
            populatePerformanceTable();
            populateStatTable();
        }
        catch (FileNotFoundException e)
        {
            JOptionPane.showMessageDialog(this, "No Student has yet taken test", "Error", JOptionPane.ERROR_MESSAGE);
            selectUser();
        }

    }

    private void populatePerformanceTable()
    {
        DefaultTableModel perModel = (DefaultTableModel) jTableStudPerformance.getModel();
        while (perModel.getRowCount() != 0)
        {
            perModel.removeRow(0);
        }

        String name, rollno;
        int total, score;
        while (scannerStudent.hasNext())
        {
            name = scannerStudent.nextLine(); //name
            rollno = scannerStudent.nextLine();
            score = scannerStudent.nextInt();
            total = scannerStudent.nextInt();
            scannerStudent.nextLine();
            perModel.addRow(new Object[]
                    {
                        name, rollno, score, total
                    });

        }
        scannerStudent.close();
        jTableStudPerformance.setModel(perModel);
    }

    private void populateStatTable()
    {
        DefaultTableModel perModel = (DefaultTableModel) jTableStudPerformance.getModel();
        int maxtotal = 0, temp;
        for (int i = 0; i < perModel.getRowCount(); i++)
        {

            temp = (int) perModel.getValueAt(i, 3);
            if (temp > maxtotal)
            {
                maxtotal = temp;
            }
        }
        int studentcount[] = new int[maxtotal + 1];
        for (int i = 0; i < perModel.getRowCount(); i++)
        {
            temp = (int) perModel.getValueAt(i, 2);
            studentcount[temp]++;
        }
        perModel = (DefaultTableModel) jTableStudStats.getModel();
        while (perModel.getRowCount() != 0)
        {
            perModel.removeRow(0);
        }
        for (int i = 0; i <= maxtotal; i++)
        {
            perModel.addRow(new Object[]
                    {
                        i, studentcount[i]
                    });
        }
        jTableStudStats.setModel(perModel);
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

        buttonGroupOptions = new javax.swing.ButtonGroup();
        jPanelPerformance = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableStudPerformance = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableStudStats = new javax.swing.JTable();
        jButtonExit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanelStudLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldRollNo = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jButtonStartTest = new javax.swing.JButton();
        jPanelStudResult = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldCorrectAns = new javax.swing.JTextField();
        jTextFieldTotalQues = new javax.swing.JTextField();
        jButtonOk = new javax.swing.JButton();
        jPanelTestPage = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaQuestion = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonOption1 = new javax.swing.JRadioButton();
        jRadioButtonOption2 = new javax.swing.JRadioButton();
        jRadioButtonOption3 = new javax.swing.JRadioButton();
        jRadioButtonOption4 = new javax.swing.JRadioButton();
        jButtonNext = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(444, 330));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelPerformance.setPreferredSize(new java.awt.Dimension(400, 300));

        jTableStudPerformance.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Student Name", "Student Roll No", "Score", "Total Ques"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableStudPerformance);

        jTableStudStats.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Score", "Number of Students"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTableStudStats);

        jButtonExit.setText("Exit");
        jButtonExit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonExitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Individual Students' Score");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Statistics");

        javax.swing.GroupLayout jPanelPerformanceLayout = new javax.swing.GroupLayout(jPanelPerformance);
        jPanelPerformance.setLayout(jPanelPerformanceLayout);
        jPanelPerformanceLayout.setHorizontalGroup(
            jPanelPerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPerformanceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanelPerformanceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelPerformanceLayout.setVerticalGroup(
            jPanelPerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPerformanceLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExit, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelPerformance, "card5");

        jPanelStudLogin.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanelStudLogin.setPreferredSize(new java.awt.Dimension(311, 150));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Roll No.");

        jTextFieldRollNo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldRollNo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldRollNoActionPerformed(evt);
            }
        });

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButtonStartTest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonStartTest.setText("Start Test");
        jButtonStartTest.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonStartTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelStudLoginLayout = new javax.swing.GroupLayout(jPanelStudLogin);
        jPanelStudLogin.setLayout(jPanelStudLoginLayout);
        jPanelStudLoginLayout.setHorizontalGroup(
            jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStudLoginLayout.createSequentialGroup()
                        .addComponent(jButtonStartTest)
                        .addGap(0, 139, Short.MAX_VALUE))
                    .addComponent(jTextFieldRollNo)
                    .addComponent(jTextFieldName)))
        );
        jPanelStudLoginLayout.setVerticalGroup(
            jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelStudLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonStartTest)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelStudLogin, "card2");

        jPanelStudResult.setPreferredSize(new java.awt.Dimension(229, 170));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total Questions");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Correctly Answered");

        jTextFieldCorrectAns.setEditable(false);
        jTextFieldCorrectAns.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldCorrectAns.setText("0");

        jTextFieldTotalQues.setEditable(false);
        jTextFieldTotalQues.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldTotalQues.setText("0");

        jButtonOk.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelStudResultLayout = new javax.swing.GroupLayout(jPanelStudResult);
        jPanelStudResult.setLayout(jPanelStudResultLayout);
        jPanelStudResultLayout.setHorizontalGroup(
            jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonOk)
                    .addGroup(jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCorrectAns, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jTextFieldTotalQues))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        jPanelStudResultLayout.setVerticalGroup(
            jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudResultLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldTotalQues, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelStudResultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldCorrectAns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(166, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelStudResult, "card4");

        jPanelTestPage.setPreferredSize(new java.awt.Dimension(332, 300));

        jTextAreaQuestion.setColumns(20);
        jTextAreaQuestion.setRows(5);
        jScrollPane1.setViewportView(jTextAreaQuestion);

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        buttonGroupOptions.add(jRadioButtonOption1);
        jRadioButtonOption1.setText("jRadioButton1");
        jPanel1.add(jRadioButtonOption1);

        buttonGroupOptions.add(jRadioButtonOption2);
        jRadioButtonOption2.setText("jRadioButton1");
        jPanel1.add(jRadioButtonOption2);

        buttonGroupOptions.add(jRadioButtonOption3);
        jRadioButtonOption3.setText("jRadioButton1");
        jPanel1.add(jRadioButtonOption3);

        buttonGroupOptions.add(jRadioButtonOption4);
        jRadioButtonOption4.setText("jRadioButton1");
        jPanel1.add(jRadioButtonOption4);

        jButtonNext.setText("Next Question");
        jButtonNext.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelTestPageLayout = new javax.swing.GroupLayout(jPanelTestPage);
        jPanelTestPage.setLayout(jPanelTestPageLayout);
        jPanelTestPageLayout.setHorizontalGroup(
            jPanelTestPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTestPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTestPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTestPageLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 137, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelTestPageLayout.setVerticalGroup(
            jPanelTestPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTestPageLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelTestPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelTestPage, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonStartTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartTestActionPerformed
        currStudName = jTextFieldName.getText();
        currStudRoll = jTextFieldRollNo.getText();
        if (currStudName.equals("") || currStudRoll.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Invalid name or roll no", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        getContentPane().removeAll();
        getContentPane().add(jPanelTestPage);
        setBounds(scrnsize.height - jPanelTestPage.getPreferredSize().height / 2, scrnsize.width - jPanelTestPage.getPreferredSize().width / 2, 50, 50);
        setSize(jPanelTestPage.getPreferredSize());
        totalQuesCount = 0;
        correctAnsCount = 0;
        openTestFile();
        dispNextQues();
    }//GEN-LAST:event_jButtonStartTestActionPerformed

    private void jTextFieldRollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRollNoActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        if (checkCurrentQues())
        {
            correctAnsCount++;
        }
        dispNextQues();
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        writeStudentToFile();
        selectUser();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        selectUser();        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExitActionPerformed
    /**
     * s
     *
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MCTEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MCTEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MCTEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MCTEFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MCTEFrame().setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupOptions;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonStartTest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelPerformance;
    private javax.swing.JPanel jPanelStudLogin;
    private javax.swing.JPanel jPanelStudResult;
    private javax.swing.JPanel jPanelTestPage;
    private javax.swing.JRadioButton jRadioButtonOption1;
    private javax.swing.JRadioButton jRadioButtonOption2;
    private javax.swing.JRadioButton jRadioButtonOption3;
    private javax.swing.JRadioButton jRadioButtonOption4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableStudPerformance;
    private javax.swing.JTable jTableStudStats;
    private javax.swing.JTextArea jTextAreaQuestion;
    private javax.swing.JTextField jTextFieldCorrectAns;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldRollNo;
    private javax.swing.JTextField jTextFieldTotalQues;
    // End of variables declaration//GEN-END:variables
}

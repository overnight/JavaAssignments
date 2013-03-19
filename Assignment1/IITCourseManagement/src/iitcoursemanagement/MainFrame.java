/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iitcoursemanagement;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankit
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    ObjectOutputStream outStud, outCourse, outFaculty;
    ObjectInputStream inStud, inCourse, inFaculty;
    String studFileName, courseFileName, facultyFileName;
    JTextField jTextFieldLoginID;
    JPasswordField jPasswordFieldLogintPassword;
    JComponent[] studlogin, facultylogin, deanlogin;
    ArrayList<Student> studentArray;
    ArrayList<Course> courseArray;
    ArrayList<Faculty> facultyArray;
    int defaultNosOfElectives, currentstudentindex;
    String deanID = "1234", deanPass = "1234";
    String currentcourse;

    public MainFrame()
    {
        initComponents();
        studFileName = "studfile.ser";
        courseFileName = "coursefile.ser";
        facultyFileName = "faculty.ser";

        initmycomp();
    }

    public MainFrame(String stud, String course, String faculty)
    {
        initComponents();

        studFileName = stud;
        courseFileName = course;
        facultyFileName = faculty;
        initmycomp();
    }

    private void initmycomp()
    {
        jTextFieldLoginID = new JTextField();
        jPasswordFieldLogintPassword = new JPasswordField();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        getContentPane().removeAll();
        studlogin = new JComponent[]
        {
            new JLabel("Enter Roll No"),
            jTextFieldLoginID,
            new JLabel("Password"),
            jPasswordFieldLogintPassword
        };
        facultylogin = new JComponent[]
        {
            new JLabel("Enter Faculty ID"),
            jTextFieldLoginID,
            new JLabel("Password"),
            jPasswordFieldLogintPassword
        };
        deanlogin = new JComponent[]
        {
            new JLabel("Enter Dean Rep ID"),
            jTextFieldLoginID,
            new JLabel("Password"),
            jPasswordFieldLogintPassword
        };
        studentArray = new ArrayList();
        courseArray = new ArrayList();
        facultyArray = new ArrayList();
        defaultNosOfElectives = 1;

    }

    public void clearLogin()
    {
        jTextFieldLoginID.setText("");
        jPasswordFieldLogintPassword.setText("");
    }

    public void showdia()
    {
        readDataFromFiles();
    }

    private void readDataFromFiles()
    {
        try
        {
            inCourse = null;
            inCourse = new ObjectInputStream(new FileInputStream(courseFileName));
            defaultNosOfElectives = inCourse.readInt();
            while (true)
            {
                courseArray.add((Course) inCourse.readObject());
            }
        }
        catch (Exception e)
        {
        }
        try
        {
            inStud = null;
            inStud = new ObjectInputStream(new FileInputStream(studFileName));
            while (true)
            {
                studentArray.add((Student) inStud.readObject());
            }
        }
        catch (Exception e)
        {
        }
        try
        {
            inFaculty = null;
            inFaculty = new ObjectInputStream(new FileInputStream(facultyFileName));
            while (true)
            {
                facultyArray.add((Faculty) inFaculty.readObject());
            }
        }
        catch (Exception e)
        {
        }
        try
        {
            if (inCourse != null)
            {
                inCourse.close();
            }
            if (inStud != null)
            {
                inStud.close();
            }
            if (inFaculty != null)
            {
                inFaculty.close();
            }
        }
        catch (Exception e)
        {
        }

    }

    private void writeDataToFiles()
    {
        try
        {
            outCourse = new ObjectOutputStream(new FileOutputStream(courseFileName));
            outCourse.writeInt(defaultNosOfElectives);
            for (int i = 0; i < courseArray.size(); i++)
            {
                outCourse.writeObject(courseArray.get(i));
            }
            outCourse.close();

        }
        catch (Exception e)
        {
        }
        try
        {
            outFaculty = new ObjectOutputStream(new FileOutputStream(facultyFileName));
            for (int i = 0; i < facultyArray.size(); i++)
            {
                outFaculty.writeObject(facultyArray.get(i));
            }
            outFaculty.close();
        }
        catch (Exception e)
        {
        }
        try
        {
            outStud = new ObjectOutputStream(new FileOutputStream(studFileName));
            for (int i = 0; i < studentArray.size(); i++)
            {
                outStud.writeObject(studentArray.get(i));
            }
            outStud.close();
        }
        catch (Exception e)
        {
        }

    }

    private boolean isValidGrade(String g)
    {
        if (g == null)
        {
            return false;
        }
        if (g.equals("EX") || g.equals("A") || g.equals("B") || g.equals("C") || g.equals("D") || g.equals("P") || g.equals("F"))
        {
            return true;
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        buttonGroupMenuItem = new javax.swing.ButtonGroup();
        jPanelAddFact = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldAddFactName = new javax.swing.JTextField();
        jTextFieldAddFactID = new javax.swing.JTextField();
        jButtonAddFactAdd = new javax.swing.JButton();
        jPasswordFieldAddFactPass = new javax.swing.JPasswordField();
        jPanelCourseDetail = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldCourseDetaiID = new javax.swing.JTextField();
        jTextFieldCourseDetaiProfID = new javax.swing.JTextField();
        jTextFieldCourseDetaiNosElective = new javax.swing.JTextField();
        jTextFieldCourseDetailName = new javax.swing.JTextField();
        jCheckBoxCourseDetailIsCore = new javax.swing.JCheckBox();
        jButtonCourseDetaiAddCourse = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldCourseDetailCredits = new javax.swing.JTextField();
        jButtonCourseDetaiUpdateElevtive = new javax.swing.JButton();
        jPanelStudInitReg = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldInitRegFacID = new javax.swing.JTextField();
        jTextFieldInitRegAddress = new javax.swing.JTextField();
        jTextFieldInitRegStudName = new javax.swing.JTextField();
        jPasswordFieldInitRegPass = new javax.swing.JPasswordField();
        jButtonInitRegRegister = new javax.swing.JButton();
        jPanelSemReg = new javax.swing.JPanel();
        jTextFieldSemRegRoll = new javax.swing.JTextField();
        jTextFieldSemRegName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSemRegElective = new javax.swing.JTable();
        jLabelSemRegElectives = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableSemRegCore = new javax.swing.JTable();
        jButtonSemRegRegister = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSemRegCGPA = new javax.swing.JTextField();
        jPanelGradeEntry = new javax.swing.JPanel();
        jTextFieldGradeEntryFacName = new javax.swing.JTextField();
        jComboBoxGradeEntryCourseList = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableGradeEntryStudList = new javax.swing.JTable();
        jButtonGradeEntryAddGrade = new javax.swing.JButton();
        jPanelSemTailoring = new javax.swing.JPanel();
        jTextFieldSemTailFacName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jComboBoxSemTailStudRollList = new javax.swing.JComboBox();
        jTextFieldSemTailStudName = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableSemTailElectives = new javax.swing.JTable();
        jButtonSemTailRemove = new javax.swing.JButton();
        jTextFieldSemTailCGPA = new javax.swing.JTextField();
        jPanelDispGrade = new javax.swing.JPanel();
        jTextFieldGradeDispRollNo = new javax.swing.JTextField();
        jTextFieldGradeDispName = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableGradeDispGradeList = new javax.swing.JTable();
        jTextFieldGradeDispSGPA = new javax.swing.JTextField();
        jTextFieldGradeDispMsg = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItemAddFaculty = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemCourseDetails = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemInitStudReg = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSemStudReg = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemGradeEntry = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemSemTailoring = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemGradeSheet = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItemExit = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanelAddFact.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Enter Name");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Enter Faculty ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Enter Password");

        jTextFieldAddFactName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jTextFieldAddFactID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButtonAddFactAdd.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonAddFactAdd.setText("Add");
        jButtonAddFactAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonAddFactAddActionPerformed(evt);
            }
        });

        jPasswordFieldAddFactPass.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanelAddFactLayout = new javax.swing.GroupLayout(jPanelAddFact);
        jPanelAddFact.setLayout(jPanelAddFactLayout);
        jPanelAddFactLayout.setHorizontalGroup(
            jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddFactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonAddFactAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddFactName, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(jTextFieldAddFactID)
                    .addComponent(jPasswordFieldAddFactPass))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanelAddFactLayout.setVerticalGroup(
            jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAddFactLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddFactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldAddFactID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelAddFactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordFieldAddFactPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddFactAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(164, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelAddFact, "card2");

        jPanelCourseDetail.setPreferredSize(new java.awt.Dimension(450, 450));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("New Course Details");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Cousre Name");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Course ID");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Proff Name");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Credits");

        jTextFieldCourseDetaiID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldCourseDetaiProfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldCourseDetaiNosElective.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldCourseDetailName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jCheckBoxCourseDetailIsCore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jCheckBoxCourseDetailIsCore.setSelected(true);
        jCheckBoxCourseDetailIsCore.setText("Core Course");

        jButtonCourseDetaiAddCourse.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCourseDetaiAddCourse.setText("Add Course");
        jButtonCourseDetaiAddCourse.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCourseDetaiAddCourseActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Nos of Electives To be taken");

        jTextFieldCourseDetailCredits.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonCourseDetaiUpdateElevtive.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonCourseDetaiUpdateElevtive.setText("Update Number");
        jButtonCourseDetaiUpdateElevtive.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonCourseDetaiUpdateElevtiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCourseDetailLayout = new javax.swing.GroupLayout(jPanelCourseDetail);
        jPanelCourseDetail.setLayout(jPanelCourseDetailLayout);
        jPanelCourseDetailLayout.setHorizontalGroup(
            jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCourseDetailName))
                    .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCourseDetaiID))
                    .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCourseDetaiProfID))
                    .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                        .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldCourseDetaiNosElective, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonCourseDetaiAddCourse)
                                    .addComponent(jButtonCourseDetaiUpdateElevtive))))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCourseDetailCredits))
                    .addComponent(jCheckBoxCourseDetailIsCore, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelCourseDetailLayout.setVerticalGroup(
            jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCourseDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldCourseDetailName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCourseDetaiID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldCourseDetaiProfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldCourseDetailCredits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBoxCourseDetailIsCore)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCourseDetaiAddCourse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCourseDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldCourseDetaiNosElective, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCourseDetaiUpdateElevtive))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCourseDetail, "card3");

        jPanelStudInitReg.setPreferredSize(new java.awt.Dimension(300, 300));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("FacAd ID");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Password");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Address");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Name");

        jTextFieldInitRegFacID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldInitRegAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldInitRegStudName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldInitRegStudName.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldInitRegStudNameActionPerformed(evt);
            }
        });

        jPasswordFieldInitRegPass.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonInitRegRegister.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonInitRegRegister.setText("Register");
        jButtonInitRegRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonInitRegRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelStudInitRegLayout = new javax.swing.GroupLayout(jPanelStudInitReg);
        jPanelStudInitReg.setLayout(jPanelStudInitRegLayout);
        jPanelStudInitRegLayout.setHorizontalGroup(
            jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldInitRegStudName, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldInitRegAddress))
                        .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldInitRegFacID)))
                    .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonInitRegRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldInitRegPass, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanelStudInitRegLayout.setVerticalGroup(
            jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStudInitRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldInitRegStudName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldInitRegAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldInitRegFacID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelStudInitRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jPasswordFieldInitRegPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonInitRegRegister)
                .addContainerGap(159, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelStudInitReg, "card4");

        jPanelSemReg.setPreferredSize(new java.awt.Dimension(600, 450));

        jTextFieldSemRegRoll.setEditable(false);
        jTextFieldSemRegRoll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldSemRegName.setEditable(false);
        jTextFieldSemRegName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Core Courses:");

        jTableSemRegElective.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "CourseID", "Course Name", "Faculty", "Credits", "OptIn"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, true
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
        jScrollPane1.setViewportView(jTableSemRegElective);

        jLabelSemRegElectives.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSemRegElectives.setText("Electives:");

        jTableSemRegCore.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "CourseID", "Course Name", "Faculty", "Credits"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        jScrollPane2.setViewportView(jTableSemRegCore);

        jButtonSemRegRegister.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSemRegRegister.setText("Register");
        jButtonSemRegRegister.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSemRegRegisterActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Enter CGPA");

        jTextFieldSemRegCGPA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelSemRegLayout = new javax.swing.GroupLayout(jPanelSemReg);
        jPanelSemReg.setLayout(jPanelSemRegLayout);
        jPanelSemRegLayout.setHorizontalGroup(
            jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSemRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelSemRegLayout.createSequentialGroup()
                        .addComponent(jTextFieldSemRegRoll, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSemRegName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSemRegLayout.createSequentialGroup()
                        .addGroup(jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabelSemRegElectives)
                            .addGroup(jPanelSemRegLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldSemRegCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jButtonSemRegRegister)))
                        .addGap(0, 88, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelSemRegLayout.setVerticalGroup(
            jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSemRegLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldSemRegRoll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSemRegName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelSemRegElectives)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelSemRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldSemRegCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSemRegRegister))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSemReg, "card5");

        jPanelGradeEntry.setPreferredSize(new java.awt.Dimension(400, 350));

        jTextFieldGradeEntryFacName.setEditable(false);
        jTextFieldGradeEntryFacName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jComboBoxGradeEntryCourseList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxGradeEntryCourseList.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBoxGradeEntryCourseListItemStateChanged(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Select Course:");

        jTableGradeEntryStudList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "Roll Number", "Name", "Grade"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, true
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
        jScrollPane3.setViewportView(jTableGradeEntryStudList);

        jButtonGradeEntryAddGrade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonGradeEntryAddGrade.setText("<html>\nAdd<br>\nGrades\n</html>\n");
        jButtonGradeEntryAddGrade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGradeEntryAddGrade.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonGradeEntryAddGradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGradeEntryLayout = new javax.swing.GroupLayout(jPanelGradeEntry);
        jPanelGradeEntry.setLayout(jPanelGradeEntryLayout);
        jPanelGradeEntryLayout.setHorizontalGroup(
            jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradeEntryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                    .addGroup(jPanelGradeEntryLayout.createSequentialGroup()
                        .addGroup(jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextFieldGradeEntryFacName)
                            .addGroup(jPanelGradeEntryLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxGradeEntryCourseList, 0, 181, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGradeEntryAddGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelGradeEntryLayout.setVerticalGroup(
            jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGradeEntryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelGradeEntryLayout.createSequentialGroup()
                        .addComponent(jTextFieldGradeEntryFacName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelGradeEntryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jComboBoxGradeEntryCourseList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonGradeEntryAddGrade))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanelGradeEntry, "card6");

        jPanelSemTailoring.setPreferredSize(new java.awt.Dimension(500, 400));

        jTextFieldSemTailFacName.setEditable(false);
        jTextFieldSemTailFacName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Select Student Roll No");

        jComboBoxSemTailStudRollList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBoxSemTailStudRollList.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBoxSemTailStudRollListItemStateChanged(evt);
            }
        });

        jTextFieldSemTailStudName.setEditable(false);
        jTextFieldSemTailStudName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableSemTailElectives.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "CourseID", "Course Name", "Faculty", "Credits", "OptIn"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, true
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
        jScrollPane5.setViewportView(jTableSemTailElectives);

        jButtonSemTailRemove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSemTailRemove.setText("<html><center>\nRemove<br>\nElectives");
        jButtonSemTailRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButtonSemTailRemoveActionPerformed(evt);
            }
        });

        jTextFieldSemTailCGPA.setEditable(false);
        jTextFieldSemTailCGPA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelSemTailoringLayout = new javax.swing.GroupLayout(jPanelSemTailoring);
        jPanelSemTailoring.setLayout(jPanelSemTailoringLayout);
        jPanelSemTailoringLayout.setHorizontalGroup(
            jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                        .addGroup(jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxSemTailStudRollList, 0, 140, Short.MAX_VALUE))
                            .addComponent(jTextFieldSemTailFacName))
                        .addGap(8, 8, 8)
                        .addComponent(jButtonSemTailRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                        .addComponent(jTextFieldSemTailStudName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldSemTailCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelSemTailoringLayout.setVerticalGroup(
            jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                        .addComponent(jTextFieldSemTailFacName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jComboBoxSemTailStudRollList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelSemTailoringLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonSemTailRemove, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanelSemTailoringLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldSemTailStudName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldSemTailCGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSemTailoring, "card7");

        jPanelDispGrade.setPreferredSize(new java.awt.Dimension(500, 400));

        jTextFieldGradeDispRollNo.setEditable(false);
        jTextFieldGradeDispRollNo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextFieldGradeDispRollNo.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jTextFieldGradeDispRollNoActionPerformed(evt);
            }
        });

        jTextFieldGradeDispName.setEditable(false);
        jTextFieldGradeDispName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTableGradeDispGradeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "CourseID", "Course Name", "Faculty", "Credits", "Grade"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false
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
        jScrollPane4.setViewportView(jTableGradeDispGradeList);

        jTextFieldGradeDispSGPA.setEditable(false);
        jTextFieldGradeDispSGPA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTextFieldGradeDispMsg.setEditable(false);
        jTextFieldGradeDispMsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanelDispGradeLayout = new javax.swing.GroupLayout(jPanelDispGrade);
        jPanelDispGrade.setLayout(jPanelDispGradeLayout);
        jPanelDispGradeLayout.setHorizontalGroup(
            jPanelDispGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jTextFieldGradeDispMsg)
                    .addGroup(jPanelDispGradeLayout.createSequentialGroup()
                        .addComponent(jTextFieldGradeDispSGPA, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelDispGradeLayout.createSequentialGroup()
                        .addComponent(jTextFieldGradeDispRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldGradeDispName, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelDispGradeLayout.setVerticalGroup(
            jPanelDispGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDispGradeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDispGradeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGradeDispRollNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldGradeDispName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldGradeDispSGPA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextFieldGradeDispMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelDispGrade, "card8");

        jMenu1.setText("Go To");

        buttonGroupMenuItem.add(jRadioButtonMenuItemAddFaculty);
        jRadioButtonMenuItemAddFaculty.setText("Add Faculty");
        jRadioButtonMenuItemAddFaculty.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jRadioButtonMenuItemAddFacultyStateChanged(evt);
            }
        });
        jRadioButtonMenuItemAddFaculty.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemAddFacultyItemStateChanged(evt);
            }
        });
        jRadioButtonMenuItemAddFaculty.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonMenuItemAddFacultyActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemAddFaculty);

        buttonGroupMenuItem.add(jRadioButtonMenuItemCourseDetails);
        jRadioButtonMenuItemCourseDetails.setText("Entering Course Details");
        jRadioButtonMenuItemCourseDetails.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                jRadioButtonMenuItemCourseDetailsStateChanged(evt);
            }
        });
        jRadioButtonMenuItemCourseDetails.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemCourseDetailsItemStateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemCourseDetails);

        buttonGroupMenuItem.add(jRadioButtonMenuItemInitStudReg);
        jRadioButtonMenuItemInitStudReg.setText("Initial Student registration");
        jRadioButtonMenuItemInitStudReg.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemInitStudRegItemStateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemInitStudReg);

        buttonGroupMenuItem.add(jRadioButtonMenuItemSemStudReg);
        jRadioButtonMenuItemSemStudReg.setText("Student registration for a semester");
        jRadioButtonMenuItemSemStudReg.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemSemStudRegItemStateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemSemStudReg);

        buttonGroupMenuItem.add(jRadioButtonMenuItemGradeEntry);
        jRadioButtonMenuItemGradeEntry.setText("Grade entry");
        jRadioButtonMenuItemGradeEntry.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemGradeEntryItemStateChanged(evt);
            }
        });
        jRadioButtonMenuItemGradeEntry.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonMenuItemGradeEntryActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemGradeEntry);

        buttonGroupMenuItem.add(jRadioButtonMenuItemSemTailoring);
        jRadioButtonMenuItemSemTailoring.setText("Semester tailoring");
        jRadioButtonMenuItemSemTailoring.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemSemTailoringItemStateChanged(evt);
            }
        });
        jRadioButtonMenuItemSemTailoring.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jRadioButtonMenuItemSemTailoringActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemSemTailoring);

        buttonGroupMenuItem.add(jRadioButtonMenuItemGradeSheet);
        jRadioButtonMenuItemGradeSheet.setText("Display grade sheet");
        jRadioButtonMenuItemGradeSheet.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemGradeSheetItemStateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemGradeSheet);

        jRadioButtonMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        buttonGroupMenuItem.add(jRadioButtonMenuItemExit);
        jRadioButtonMenuItemExit.setText("Exit");
        jRadioButtonMenuItemExit.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jRadioButtonMenuItemExitItemStateChanged(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonMenuItemGradeEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemGradeEntryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemGradeEntryActionPerformed

    private void jRadioButtonMenuItemAddFacultyStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemAddFacultyStateChanged
    }//GEN-LAST:event_jRadioButtonMenuItemAddFacultyStateChanged

    private void jRadioButtonMenuItemCourseDetailsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemCourseDetailsStateChanged
    }//GEN-LAST:event_jRadioButtonMenuItemCourseDetailsStateChanged

    private void jRadioButtonMenuItemAddFacultyItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemAddFacultyItemStateChanged
        if (jRadioButtonMenuItemAddFaculty.isSelected())
        {
            JOptionPane.showMessageDialog(this, deanlogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());
            if (ID.equals(deanID) && pass.equals(deanPass))
            {
                getContentPane().add(jPanelAddFact);
                jPanelAddFact.setVisible(true);
                setSize(jPanelAddFact.getPreferredSize());
                getContentPane().repaint();
                clearLogin();
                return;
            }
            JOptionPane.showMessageDialog(this, "Incorrect ID or Password", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            clearLogin();
            buttonGroupMenuItem.clearSelection();
            return;
        }

        getContentPane().removeAll();


    }//GEN-LAST:event_jRadioButtonMenuItemAddFacultyItemStateChanged

    private void jRadioButtonMenuItemCourseDetailsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemCourseDetailsItemStateChanged
        if (jRadioButtonMenuItemCourseDetails.isSelected())
        {
            JOptionPane.showMessageDialog(this, deanlogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());
            if (ID.equals(deanID) && pass.equals(deanPass))
            {
                getContentPane().add(jPanelCourseDetail);
                jPanelCourseDetail.setVisible(true);
                setSize(jPanelCourseDetail.getPreferredSize());
                getContentPane().repaint();
                clearLogin();
                return;
            }
            JOptionPane.showMessageDialog(this, "Incorrect ID or Password", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            buttonGroupMenuItem.clearSelection();
            clearLogin();
            return;
        }

        getContentPane().removeAll();

    }//GEN-LAST:event_jRadioButtonMenuItemCourseDetailsItemStateChanged

    private void jTextFieldInitRegStudNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldInitRegStudNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldInitRegStudNameActionPerformed

    private void jTextFieldGradeDispRollNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGradeDispRollNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGradeDispRollNoActionPerformed

    private void jRadioButtonMenuItemInitStudRegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemInitStudRegItemStateChanged
        if (jRadioButtonMenuItemInitStudReg.isSelected())
        {
            getContentPane().add(jPanelStudInitReg);
            setSize(jPanelStudInitReg.getPreferredSize());
            jPanelStudInitReg.setVisible(true);
            getContentPane().repaint();
            return;
        }
        getContentPane().removeAll();        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemInitStudRegItemStateChanged

    private void jRadioButtonMenuItemSemStudRegItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSemStudRegItemStateChanged
        if (jRadioButtonMenuItemSemStudReg.isSelected())
        {
            JOptionPane.showMessageDialog(this, studlogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());

            for (int i = 0; i < studentArray.size(); i++)
            {
                if (ID.equals(studentArray.get(i).getRollNo()) && pass.equals(studentArray.get(i).getPassword()))
                {
                    if (studentArray.get(i).getSemregestered())
                    {
                        JOptionPane.showMessageDialog(this, "Already Registerd for this Sem", "My custom dialog", JOptionPane.PLAIN_MESSAGE);
                        // jButtonSemRegRegister.setVisible(false);
                        clearLogin();
                        return;
                    }
                    currentstudentindex = i;
                    jTextFieldSemRegName.setText("Name: " + studentArray.get(i).getName());
                    jTextFieldSemRegRoll.setText("Roll No: " + studentArray.get(i).getRollNo());
                    jLabelSemRegElectives.setText("Select any " + defaultNosOfElectives + " electives");
                    DefaultTableModel coremodel = (DefaultTableModel) jTableSemRegCore.getModel();
                    DefaultTableModel electivemodel = (DefaultTableModel) jTableSemRegElective.getModel();
                    while (coremodel.getRowCount() > 0)
                    {
                        coremodel.removeRow(0);
                    }
                    while (electivemodel.getRowCount() > 0)
                    {
                        electivemodel.removeRow(0);
                    }
                    for (int j = 0; j < courseArray.size(); j++)
                    {
                        if (courseArray.get(j).isCoreCourse())
                        {
                            coremodel.addRow(new Object[]
                                    {
                                        courseArray.get(j).getCourseID(), courseArray.get(j).getName(), courseArray.get(j).getProfName(), courseArray.get(j).getCredits()
                                    });
                        }
                        else
                        {
                            electivemodel.addRow(new Object[]
                                    {
                                        courseArray.get(j).getCourseID(), courseArray.get(j).getName(), courseArray.get(j).getProfName(), courseArray.get(j).getCredits(), !courseArray.get(j).isCoreCourse()
                                    });
                        }
                    }
                    jTableSemRegCore.setModel(coremodel);
                    jTableSemRegElective.setModel(electivemodel);
                    getContentPane().add(jPanelSemReg);
                    setSize(jPanelSemReg.getPreferredSize());
                    jPanelSemReg.setVisible(true);
                    getContentPane().repaint();
                    clearLogin();
                    return;
                }

            }
            JOptionPane.showMessageDialog(this, "Password or ID incorrect", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            buttonGroupMenuItem.clearSelection();
            clearLogin();
            return;

        }

        getContentPane().removeAll();

    }//GEN-LAST:event_jRadioButtonMenuItemSemStudRegItemStateChanged

    private void jRadioButtonMenuItemGradeEntryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemGradeEntryItemStateChanged
        if (jRadioButtonMenuItemGradeEntry.isSelected())
        {

            JOptionPane.showMessageDialog(this, facultylogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());
            for (int i = 0; i < facultyArray.size(); i++)
            {
                if (ID.equals(facultyArray.get(i).getFacultyID()) && pass.equals(facultyArray.get(i).getPassword()))
                {
                    jTextFieldGradeEntryFacName.setText(facultyArray.get(i).getName());
                    jComboBoxGradeEntryCourseList.removeAllItems();
                    for (int j = 0; j < courseArray.size(); j++)
                    {
                        if (facultyArray.get(i).getName().equals(courseArray.get(j).getProfName()))
                        {
                            jComboBoxGradeEntryCourseList.addItem(courseArray.get(j).getCourseID());
                        }
                    }

                    getContentPane().add(jPanelGradeEntry);
                    setSize(jPanelGradeEntry.getPreferredSize());
                    jPanelGradeEntry.setVisible(true);
                    getContentPane().repaint();
                    clearLogin();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Password or ID incorrect", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            buttonGroupMenuItem.clearSelection();
            clearLogin();
            return;

        }
        getContentPane().removeAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemGradeEntryItemStateChanged

    private void jRadioButtonMenuItemSemTailoringItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemSemTailoringItemStateChanged
        if (jRadioButtonMenuItemSemTailoring.isSelected())
        {


            JOptionPane.showMessageDialog(this, facultylogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());
            for (int i = 0; i < facultyArray.size(); i++)
            {
                if (ID.equals(facultyArray.get(i).getFacultyID()) && pass.equals(facultyArray.get(i).getPassword()))
                {

                    add(jPanelSemTailoring);
                    setSize(jPanelSemTailoring.getPreferredSize());
                    jPanelSemTailoring.setVisible(true);
                    getContentPane().repaint();
                    jTextFieldSemTailFacName.setText(facultyArray.get(i).getName());
                    jComboBoxSemTailStudRollList.removeAllItems();
                    for (int j = 0; j < studentArray.size(); j++)
                    {
                        if (studentArray.get(j).getFacAdID().equals(facultyArray.get(i).getFacultyID()))
                        {
                            jComboBoxSemTailStudRollList.addItem(studentArray.get(j).getRollNo());
                        }
                    }
                    clearLogin();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Password or ID incorrect", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            buttonGroupMenuItem.clearSelection();
            clearLogin();
            return;
        }

        getContentPane().removeAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemSemTailoringItemStateChanged

    private void jRadioButtonMenuItemGradeSheetItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemGradeSheetItemStateChanged
        if (jRadioButtonMenuItemGradeSheet.isSelected())
        {
            JOptionPane.showMessageDialog(this, studlogin, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
            String ID = jTextFieldLoginID.getText();
            String pass = String.valueOf(jPasswordFieldLogintPassword.getPassword());

            for (int i = 0; i < studentArray.size(); i++)
            {
                if (ID.equals(studentArray.get(i).getRollNo()) && pass.equals(studentArray.get(i).getPassword()))
                {
                    jTextFieldGradeDispName.setText("Name: " + studentArray.get(i).getName());
                    jTextFieldGradeDispRollNo.setText("Roll No: " + studentArray.get(i).getRollNo());
                    float sg = studentArray.get(i).clacGPA();
                    jTextFieldGradeDispSGPA.setText("GPA: " + sg);
                    jTextFieldGradeDispMsg.setText("");
                    if (sg < 6)
                    {
                        jTextFieldGradeDispMsg.setText("IMPROVE YOUR SG. WORK DARD");
                    }
                    if (sg > 9)
                    {
                        jTextFieldGradeDispMsg.setText("Congratulations!! Keep it up");
                    }
                    DefaultTableModel model = (DefaultTableModel) jTableGradeDispGradeList.getModel();
                    while (model.getRowCount() != 0)
                    {
                        model.removeRow(0);
                    }
                    jTableGradeDispGradeList.setModel(studentArray.get(i).displayCoursesInTable(model));
                    getContentPane().add(jPanelDispGrade);
                    setSize(jPanelDispGrade.getPreferredSize());
                    getContentPane().repaint();
                    jPanelDispGrade.setVisible(true);
                    clearLogin();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Password or ID incorrect", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            buttonGroupMenuItem.clearSelection();
            clearLogin();
            return;
        }

        getContentPane().removeAll();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemGradeSheetItemStateChanged

    private void jButtonCourseDetaiAddCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCourseDetaiAddCourseActionPerformed
        //  courseArray.add(new Course(jTextFieldCourseDetailName.getText(),jTextFieldCourseDetaiID.getText(),jTextFieldCourseDetaiProfID.getText(),4,jCheckBoxCourseDetailIsCore.isSelected()));
        String id = jTextFieldCourseDetaiID.getText();
        id = id.toUpperCase();
        String facname = jTextFieldCourseDetaiProfID.getText();
        for (int i = 0; i < courseArray.size(); i++)
        {
            if (id.equals(courseArray.get(i).getCourseID()))
            {
                JOptionPane.showMessageDialog(this, "Course with given course id already exists", "My custom dialog", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        for (int i = 0; i < facultyArray.size(); i++)
        {
            if (facname.equals(facultyArray.get(i).getName()))
            {
                courseArray.add(new Course(jTextFieldCourseDetailName.getText(), jTextFieldCourseDetaiID.getText(), jTextFieldCourseDetaiProfID.getText(), Integer.parseInt(jTextFieldCourseDetailCredits.getText()), jCheckBoxCourseDetailIsCore.isSelected()));
                JOptionPane.showMessageDialog(this, "Course added", "My custom dialog", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "faculty does not exists\nMake sure of characters' case", "My custom dialog", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jButtonCourseDetaiAddCourseActionPerformed

    private void jButtonSemRegRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSemRegRegisterActionPerformed
        int count = 0, j = 0, i;
        String cg = jTextFieldSemRegCGPA.getText();
        if (cg.equals(""))
        {
            JOptionPane.showMessageDialog(this, "Enter CGPA", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }
        float cgpa = Float.parseFloat(cg);
        if (cgpa < 0 || cgpa > 10)
        {
            JOptionPane.showMessageDialog(this, "Enter valid CGPA", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }
        for (i = 0; i < jTableSemRegElective.getRowCount(); i++)
        {
            if ((boolean) jTableSemRegElective.getValueAt(i, 4))
            {
                count++;
            }
        }
        if (count != defaultNosOfElectives)
        {
            JOptionPane.showMessageDialog(this, "Please Choose " + defaultNosOfElectives + " Electives", "My custom dialog", JOptionPane.ERROR_MESSAGE);
            return;
        }
        i = 0;
        while (i < jTableSemRegCore.getRowCount())
        {

            if (courseArray.get(j).getCourseID().equals((String) jTableSemRegCore.getValueAt(i, 0)))
            {
                studentArray.get(currentstudentindex).addNewCourse(courseArray.get(j));
                i++;

            }
            j++;
        }
        j = 0;
        i = 0;
        while (i < jTableSemRegElective.getRowCount())
        {
            if ((boolean) jTableSemRegElective.getValueAt(i, 4))
            {
                if (courseArray.get(j).getCourseID().equals((String) jTableSemRegElective.getValueAt(i, 0)))
                {
                    studentArray.get(currentstudentindex).addNewCourse(courseArray.get(j));
                    i++;
                }
                j++;
            }
            else
            {
                i++;
            }

        }

        studentArray.get(currentstudentindex).setCgpa(cgpa);
        studentArray.get(currentstudentindex).setSemregestered(true);
        JOptionPane.showMessageDialog(this, "Registered For Sem", "My custom dialog", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButtonSemRegRegisterActionPerformed

    private void jRadioButtonMenuItemExitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemExitItemStateChanged
        if (jRadioButtonMenuItemExit.isSelected())
        {
            writeDataToFiles();
            System.exit(0);
        }
    }//GEN-LAST:event_jRadioButtonMenuItemExitItemStateChanged

    private void jRadioButtonMenuItemAddFacultyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItemAddFacultyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemAddFacultyActionPerformed

    private void jButtonAddFactAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddFactAddActionPerformed
        String name = jTextFieldAddFactName.getText();
        String id = jTextFieldAddFactID.getText();
        String pass = String.valueOf(jPasswordFieldAddFactPass.getPassword());
        for (int i = 0; i < facultyArray.size(); i++)
        {
            if (id.equals(facultyArray.get(i).getFacultyID()))
            {
                JOptionPane.showMessageDialog(this, "Faculty with given facid already exists", "My custom dialog", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (facultyArray.add(new Faculty(name, id, pass)))
        {
            JOptionPane.showMessageDialog(this, "Faculty added", "My custom dialog", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonAddFactAddActionPerformed

    private void jButtonInitRegRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInitRegRegisterActionPerformed
        String roll = "11CS" + (studentArray.size() + 1);
        String pass = String.valueOf(jPasswordFieldInitRegPass.getPassword());
        String facid = jTextFieldInitRegFacID.getText();
        facid = facid.toUpperCase();
        for (int i = 0; i < facultyArray.size(); i++)
        {
            if (facid.equals(facultyArray.get(i).getFacultyID()))
            {
                if (studentArray.add(new Student(jTextFieldInitRegStudName.getText(), roll, jTextFieldInitRegAddress.getText(), facid, pass)))
                {
                    JOptionPane.showMessageDialog(this, "INitial Reg done.\n Your Roll no is: " + roll, "My custom dialog", JOptionPane.INFORMATION_MESSAGE);
                }
                jTextFieldInitRegAddress.setText("");
                jTextFieldInitRegFacID.setText("");
                jTextFieldInitRegStudName.setText("");
                jPasswordFieldInitRegPass.setText("");
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Faculty ID does not exists", "My custom dialog", JOptionPane.ERROR_MESSAGE);


    }//GEN-LAST:event_jButtonInitRegRegisterActionPerformed

    private void jComboBoxGradeEntryCourseListItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBoxGradeEntryCourseListItemStateChanged
    {//GEN-HEADEREND:event_jComboBoxGradeEntryCourseListItemStateChanged
        String courseid = (String) jComboBoxGradeEntryCourseList.getSelectedItem();
        if (courseid != null)
        {
            currentcourse = courseid;
            DefaultTableModel grademodel = (DefaultTableModel) jTableGradeEntryStudList.getModel();
            while (grademodel.getRowCount() > 0)
            {
                grademodel.removeRow(0);
            }
            for (int i = 0; i < studentArray.size(); i++)
            {
                if (studentArray.get(i).hasCourse(courseid))
                {
                    grademodel.addRow(new Object[]
                            {
                                studentArray.get(i).getRollNo(), studentArray.get(i).getName(), studentArray.get(i).getGrade(courseid)
                            });
                }
            }
            jTableGradeEntryStudList.setModel(grademodel);
        }
    }//GEN-LAST:event_jComboBoxGradeEntryCourseListItemStateChanged

    private void jButtonGradeEntryAddGradeActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonGradeEntryAddGradeActionPerformed
    {//GEN-HEADEREND:event_jButtonGradeEntryAddGradeActionPerformed
        String id, grade;
        int j = 0;
        for (int i = 0; i < jTableGradeEntryStudList.getRowCount(); i++)
        {
            id = (String) jTableGradeEntryStudList.getValueAt(i, 0);
            grade = (String) jTableGradeEntryStudList.getValueAt(i, 2);
            if (!isValidGrade(grade))
            {
                JOptionPane.showMessageDialog(this, "incorrect grade at row " + (i + 1), "My custom dialog", JOptionPane.ERROR_MESSAGE);
                return;
            }
            while (!id.equals(studentArray.get(j).getRollNo()))
            {
                j++;
            }
            studentArray.get(j).addGrade(currentcourse, grade);
            j++;
        }
        JOptionPane.showMessageDialog(this, "Grades Added", "My custom dialog", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButtonGradeEntryAddGradeActionPerformed

    private void jButtonCourseDetaiUpdateElevtiveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonCourseDetaiUpdateElevtiveActionPerformed
    {//GEN-HEADEREND:event_jButtonCourseDetaiUpdateElevtiveActionPerformed
        try
        {
            defaultNosOfElectives = Integer.parseInt(jTextFieldCourseDetaiNosElective.getText());
            JOptionPane.showMessageDialog(this, "Number of Evectives updated to: " + defaultNosOfElectives, "My custom dialog", JOptionPane.INFORMATION_MESSAGE);

        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Enter a valid integer", "My custom dialog", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonCourseDetaiUpdateElevtiveActionPerformed

    private void jRadioButtonMenuItemSemTailoringActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jRadioButtonMenuItemSemTailoringActionPerformed
    {//GEN-HEADEREND:event_jRadioButtonMenuItemSemTailoringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonMenuItemSemTailoringActionPerformed

    private void jComboBoxSemTailStudRollListItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBoxSemTailStudRollListItemStateChanged
    {//GEN-HEADEREND:event_jComboBoxSemTailStudRollListItemStateChanged
        String currRoll = String.valueOf(jComboBoxSemTailStudRollList.getSelectedItem());
        for (int i = 0; i < studentArray.size(); i++)
        {
            if (currRoll.equals(studentArray.get(i).getRollNo()))
            {
                jTextFieldSemTailCGPA.setText("CGPA: " + studentArray.get(i).getCgpa());
                jTextFieldSemTailStudName.setText("Name: " + studentArray.get(i).getName());
                DefaultTableModel model = (DefaultTableModel) jTableSemTailElectives.getModel();
                while (model.getRowCount() > 0)
                {
                    model.removeRow(0);
                }
                studentArray.get(i).displayElectivesInTable(model);
                jTableSemTailElectives.setModel(model);
                return;
            }
        }
    }//GEN-LAST:event_jComboBoxSemTailStudRollListItemStateChanged

    private void jButtonSemTailRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButtonSemTailRemoveActionPerformed
    {//GEN-HEADEREND:event_jButtonSemTailRemoveActionPerformed
        String currRoll = String.valueOf(jComboBoxSemTailStudRollList.getSelectedItem());
        int count = 0;
        for (int i = 0; i < studentArray.size(); i++)
        {
            if (currRoll.equals(studentArray.get(i).getRollNo()))
            {
                for (int j = 0; j < jTableSemTailElectives.getRowCount(); j++)
                {
                    if (!((boolean) jTableSemTailElectives.getValueAt(j, 4)))
                    {
                        String courseID = String.valueOf(jTableSemTailElectives.getValueAt(j, 0));
                        studentArray.get(i).removeCourse(courseID);
                        count++;
                    }
                }
                JOptionPane.showMessageDialog(this, "Number of Evectives removed : " + count, "My custom dialog", JOptionPane.INFORMATION_MESSAGE);

                return;
            }
        }
    }//GEN-LAST:event_jButtonSemTailRemoveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
        MainFrame f1 = new MainFrame();
        f1.setVisible(true);
        f1.showdia();
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroupMenuItem;
    private javax.swing.JButton jButtonAddFactAdd;
    private javax.swing.JButton jButtonCourseDetaiAddCourse;
    private javax.swing.JButton jButtonCourseDetaiUpdateElevtive;
    private javax.swing.JButton jButtonGradeEntryAddGrade;
    private javax.swing.JButton jButtonInitRegRegister;
    private javax.swing.JButton jButtonSemRegRegister;
    private javax.swing.JButton jButtonSemTailRemove;
    private javax.swing.JCheckBox jCheckBoxCourseDetailIsCore;
    private javax.swing.JComboBox jComboBoxGradeEntryCourseList;
    private javax.swing.JComboBox jComboBoxSemTailStudRollList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSemRegElectives;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelAddFact;
    private javax.swing.JPanel jPanelCourseDetail;
    private javax.swing.JPanel jPanelDispGrade;
    private javax.swing.JPanel jPanelGradeEntry;
    private javax.swing.JPanel jPanelSemReg;
    private javax.swing.JPanel jPanelSemTailoring;
    private javax.swing.JPanel jPanelStudInitReg;
    private javax.swing.JPasswordField jPasswordFieldAddFactPass;
    private javax.swing.JPasswordField jPasswordFieldInitRegPass;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemAddFaculty;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemCourseDetails;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemExit;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemGradeEntry;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemGradeSheet;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemInitStudReg;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSemStudReg;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItemSemTailoring;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTableGradeDispGradeList;
    private javax.swing.JTable jTableGradeEntryStudList;
    private javax.swing.JTable jTableSemRegCore;
    private javax.swing.JTable jTableSemRegElective;
    private javax.swing.JTable jTableSemTailElectives;
    private javax.swing.JTextField jTextFieldAddFactID;
    private javax.swing.JTextField jTextFieldAddFactName;
    private javax.swing.JTextField jTextFieldCourseDetaiID;
    private javax.swing.JTextField jTextFieldCourseDetaiNosElective;
    private javax.swing.JTextField jTextFieldCourseDetaiProfID;
    private javax.swing.JTextField jTextFieldCourseDetailCredits;
    private javax.swing.JTextField jTextFieldCourseDetailName;
    private javax.swing.JTextField jTextFieldGradeDispMsg;
    private javax.swing.JTextField jTextFieldGradeDispName;
    private javax.swing.JTextField jTextFieldGradeDispRollNo;
    private javax.swing.JTextField jTextFieldGradeDispSGPA;
    private javax.swing.JTextField jTextFieldGradeEntryFacName;
    private javax.swing.JTextField jTextFieldInitRegAddress;
    private javax.swing.JTextField jTextFieldInitRegFacID;
    private javax.swing.JTextField jTextFieldInitRegStudName;
    private javax.swing.JTextField jTextFieldSemRegCGPA;
    private javax.swing.JTextField jTextFieldSemRegName;
    private javax.swing.JTextField jTextFieldSemRegRoll;
    private javax.swing.JTextField jTextFieldSemTailCGPA;
    private javax.swing.JTextField jTextFieldSemTailFacName;
    private javax.swing.JTextField jTextFieldSemTailStudName;
    // End of variables declaration//GEN-END:variables
}

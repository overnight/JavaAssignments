/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iitcoursemanagement;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ankit
 */
public class Student implements Serializable {

    private String name;
    private String rollNo;
    private String address;
    private String facAdID;
    private String password;
    private ArrayList<Course> coursestaken;
    // ArrayList<Character> coursesGrade;
    private float cgpa;
    private boolean semregestered;

    public Student(String name, String rollNo, String address, String facAdID, String password)
    {
        this.name = name;
        this.rollNo = rollNo;
        this.address = address;
        this.facAdID = facAdID;
        this.password = password;
        coursestaken = new ArrayList();
        semregestered = false;
        // coursesGrade = new ArrayList();
    }

    public boolean addNewCourse(Course cos)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (cos.getCourseID().equals(coursestaken.get(i).getCourseID()))
            {
                return false;
            }
        }
        coursestaken.add(new Course(cos));
        // coursesGrade.add('N');
        return true;

    }

    public boolean hasCourse(String courseID)
    {

        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (courseID.equals(coursestaken.get(i).getCourseID()))
            {
                return true;
            }
        }
        return false;
    }

    public String getGrade(String courseID)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (courseID.equals(coursestaken.get(i).getCourseID()))
            {
                return coursestaken.get(i).getGrade();
            }
        }
        return null;
    }

    public boolean addGrade(String courseID, String grade)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (courseID.equals(coursestaken.get(i).getCourseID()))
            {
                coursestaken.get(i).setGrade(grade);
                return true;
            }
        }
        return false;
    }

    public float clacGPA()
    {
        int totalcredits = 0, score = 0, temp;
        for (int i = 0; i < coursestaken.size(); i++)
        {
            temp = getEqPoint(coursestaken.get(i).getGrade());
            if (temp > 0)
            {
                totalcredits += coursestaken.get(i).getCredits();
                score += coursestaken.get(i).getCredits() * temp;
            }
        }

        return Float.parseFloat(new DecimalFormat("##.##").format(score / (float) totalcredits));
    }

    private int getEqPoint(String a)
    {
        if (a == null)
        {
            return 0;
        }
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
                return 0;
        }
    }

    public String getAddress()
    {
        return address;
    }

    public float getCgpa()
    {
        return cgpa;
    }

    public ArrayList<Course> getCoursestaken()
    {
        return coursestaken;
    }

    public String getFacAdID()
    {
        return facAdID;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return password;
    }

    public String getRollNo()
    {
        return rollNo;
    }

    public boolean getSemregestered()
    {
        return semregestered;
    }

    public void setSemregestered(boolean semregestered)
    {
        this.semregestered = semregestered;
    }

    public void setCgpa(float cgpa)
    {
        this.cgpa = cgpa;
    }

    public DefaultTableModel displayCoursesInTable(DefaultTableModel model)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            model.addRow(new Object[]
                    {
                        coursestaken.get(i).getCourseID(), coursestaken.get(i).getName(), coursestaken.get(i).getProfName(), coursestaken.get(i).getCredits(), coursestaken.get(i).getGrade()
                    });

        }
        return model;
    }

    public DefaultTableModel displayElectivesInTable(DefaultTableModel model)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (!coursestaken.get(i).isCoreCourse())
            {
                model.addRow(new Object[]
                        {
                            coursestaken.get(i).getCourseID(), coursestaken.get(i).getName(), coursestaken.get(i).getProfName(), coursestaken.get(i).getCredits(), true
                        });
            }

        }
        return model;
    }

    public void removeCourse(String courseID)
    {
        for (int i = 0; i < coursestaken.size(); i++)
        {
            if (courseID.equals(coursestaken.get(i).getCourseID()))
            {
                coursestaken.remove(i);
            }
        }
    }
}

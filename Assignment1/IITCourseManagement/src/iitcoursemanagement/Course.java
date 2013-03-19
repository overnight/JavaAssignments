/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iitcoursemanagement;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Ankit
 */
public class Course implements Serializable {

    private String name;
    private String courseID;
    private String profName;
    private int credits;
    private boolean isCore;
    private String grade;

    public Course(String name, String couresID, String profName, int credits, boolean isCore)
    {
        this.name = name;
        this.courseID = couresID;
        this.profName = profName;
        this.credits = credits;
        this.isCore = isCore;
    }

    public Course(Course c)
    {
        this.name = c.name;
        this.courseID = c.courseID;
        this.profName = c.profName;
        this.credits = c.credits;
        this.isCore = c.isCore;
    }

    public String getCourseID()
    {
        return courseID;
    }

    public int getCredits()
    {
        return credits;
    }

    public String getGrade()
    {
        return grade;
    }

    public String getName()
    {
        return name;
    }

    public String getProfName()
    {
        return profName;
    }

    public boolean isCoreCourse()
    {
        return isCore;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }
}

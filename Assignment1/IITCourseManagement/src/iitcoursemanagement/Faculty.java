/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package iitcoursemanagement;

import java.io.Serializable;

/**
 *
 * @author Ankit
 */
public class Faculty implements Serializable {

    private String name;
    private String facID;
    private String password;

    public Faculty(String name, String facID, String password)
    {
        this.name = name;
        this.facID = facID;
        this.password = password;
    }

    public String getFacultyID()
    {
        return facID;
    }

    public String getPassword()
    {
        return password;
    }

    public String getName()
    {
        return name;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Human {
    private int ID;
    private String Name;
    private Date dob;
    private boolean Gender;
    private HumanType type;

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the Gender
     */
    public boolean isGender() {
        return Gender;
    }

    /**
     * @param Gender the Gender to set
     */
    public void setGender(boolean Gender) {
        this.Gender = Gender;
    }

    /**
     * @return the type
     */
    public HumanType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(HumanType type) {
        this.type = type;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author manhpthe172481
 */
public abstract class Organization {
    protected int size;

    public Organization() {
    }

    public Organization(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public abstract void communicateByTool();

    @Override
    public String toString() {
        return "the organization’s size is" + this.size;
    }
    
    
}

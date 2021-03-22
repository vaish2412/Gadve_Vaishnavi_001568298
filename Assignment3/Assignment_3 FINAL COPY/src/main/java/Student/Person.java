/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import CourseSchedule.CourseOffer;
import Faculty.FacultyAssignment;
import Faculty.FacultyProfile;
import java.util.ArrayList;

/**
 *
 * @author ramulyarao
 */
public class Person {
    String id;
    String name;
    String address;
    String phonenumber;
    String role;
    
//    public Person (String id, String name, String address, int phonenumber){
//        
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phonenumber = phonenumber;
//    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
    public boolean isMatch(String id){
        if(getId().equals(id)) return true;
        return false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
        
    
    
}

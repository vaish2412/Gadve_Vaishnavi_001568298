/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CourseCatalog;

import Department.Department;
import Student.Person;
import java.util.ArrayList;

/**
 *
 * @author ramulyarao
 */
public class CourseCatalog {
    Department department;
    String lastupdated;
    public ArrayList<Course> courselist; 
    public CourseCatalog(Department d){
        courselist = new ArrayList();
        department = d;
    }
    
    public ArrayList<Course> getCourseList(){
        return courselist;
    }
    
    public Course newCourse(String n, String nm, int cr){
        Course c = new Course();
        c.setName(n);
        c.setCredits(cr);
        c.setNumber(nm);
        courselist.add(c);
        return c;
        
     
    }
    
    public Course getCourseByNumber(String n){
        
        for( Course c: courselist){
            
            if(c.getCOurseNumber().equals(n)) return c;
        }
        return null;
    }
}

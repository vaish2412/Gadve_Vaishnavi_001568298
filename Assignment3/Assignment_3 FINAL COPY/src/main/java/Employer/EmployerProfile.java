/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employer;

import EmploymentHistory.Employment;
import Student.Person;
import java.util.ArrayList;

/**
 *
 * @author ramulyarao
 */
public class EmployerProfile {
      public Person person;
    String name;
    ArrayList<Employment> employments;
    public EmployerProfile(Person p){  //could be company instead of just a name as a string
        person = p;
        
    }
         public boolean isMatch(String id){
        if(name.equals(id)) return true;             //String is an object and can do equal matach
        return false;
    }
}

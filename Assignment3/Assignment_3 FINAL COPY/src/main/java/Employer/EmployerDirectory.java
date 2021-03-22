/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employer;

import Department.Department;
import Student.Person;
import java.util.ArrayList;

/**
 *
 * @author ramulyarao
 */
public class EmployerDirectory {
    Department department;
    public ArrayList<EmployerProfile> employerlist;

    public EmployerDirectory(Department d) {

        department = d;
        employerlist = new ArrayList();

    }

    public EmployerProfile newEmployerProfile(Person p) {

        EmployerProfile sp = new EmployerProfile(p);
        employerlist.add(sp);
        return sp;
    }

    public ArrayList<EmployerProfile> getEmployerlist() {
        return employerlist;
    }
    
    

    public EmployerProfile findEmployer(String id) {

        for (EmployerProfile ep : employerlist) {

            if (ep.isMatch(id)) {
                return ep;
            }
        }
            return null; //not found after going through the whole list
         }
    
}

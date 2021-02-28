/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Person extends House{

    String firstName;
    int id;
    String lastName;
    LocalDate dob;
    String ageGroup;
 
    public Person(){
        
    }
  
    public void initializePerson() {
        Scanner scanner = new Scanner(System.in);
        updateInfo();
        System.out.println("\nEnter Community: ");
        this.commName = scanner.nextLine();
        
        System.out.println("\nEnter House No: ");
        this.houseNo = scanner.nextLine();
        
        System.out.println("\nEnter City: ");
        this.cityName = scanner.nextLine();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDOB() {
        return dob;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id =id;
    }

    
    

    public void setDob(LocalDate dob) {
        this.dob = dob;
        Period age = Period.between(dob, LocalDate.now());
        if(age.getYears() == 0 && age.getMonths() == 0){
            this.setAgeGroup("Newborn");
        }
        else if(age.getYears() == 0 && age.getMonths() <= 11 && age.getDays() <= 31){
            this.setAgeGroup("Infant");
        }
        else if(age.getYears() < 3 && age.getMonths() <= 11 && age.getDays() <= 31) {
            this.setAgeGroup("Toddler");
        }
        else if(age.getYears() < 5 && age.getMonths() <= 11 && age.getDays() <= 31) {
            this.setAgeGroup("Preschooler");
        }
        else if(age.getYears() < 12 && age.getMonths() <= 11 && age.getDays() <= 31){
            this.setAgeGroup("SchoolAge");
        }
        else {
            this.setAgeGroup("Adolescent");
        }
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }
    
    void updateInfo() {
        System.out.println("\nEnter Person's/ Patient's First Name: ");
        Scanner scanner = new Scanner(System.in);
        this.firstName = scanner.nextLine();
        System.out.println("\nEnter Person's/ Patient's Last Name: ");
        this.lastName = scanner.nextLine();
        System.out.println("\nEnter Person's/ Patient's DOB in (YYYY-MM-DD) format: ");
        Boolean date = false;
        while(!date) {
            try {
                this.setDob(LocalDate.parse(scanner.nextLine()));
                date = true;
                if(Period.between(dob, LocalDate.now()).getDays() < 0 ||
                        Period.between(dob, LocalDate.now()).getMonths() < 0 ||
                        Period.between(dob, LocalDate.now()).getYears() < 0){
                    System.out.println("\n\u001B[1m Kindly Enter the Past Date!!");
                    System.out.print("\nEnter DOB in YYYY-MM-DD Format: ");
                    date = false;
                }
            }
            catch (Exception e) {
                System.out.print("\nEnter DOB in YYYY-MM-DD Format: ");
            }
        }
    }    
        
    public String toString(){
        return "\n Person Name: " + "\u001B[1m" + this.getFullName() + "\n Date Of Birth: " + "\u001B[1m" + this.dob + "\n The Person belongs to Age Group : " + "\u001B[1m" +this.ageGroup + "\n Patiend ID: " + "\u001B[1m" + this.getId()+ super.toString();
    }
    
}

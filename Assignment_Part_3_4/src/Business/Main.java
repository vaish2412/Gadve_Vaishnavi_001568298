/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author  admin
 */
public class Main {
    
    static PatientDirectory patDir = new PatientDirectory();
    static PersonDirectory perDir = new PersonDirectory();
    static int patientID = 1000;
    
    
    public static void main(String args[]) throws Throwable{
        
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            mainMenu();
            choice = scanner.nextInt();
            
            switch(choice) {
                case 2:
                    showFullList();
                    break;
                case 1:
                    Person person = perDir.newPerson();
                    System.out.println("\n\u001B[1m Person " + person.getFullName() + " has been created successfully!!");
                    break;
                case 3:
                    Patient patient = patDir.newPatient();
                    //patDir.getDirectory().add(patient);
                    patient.newEncounter();
                    System.out.println("\n\u001B[1m Patient " + patient.getFullName() + " has been created successfully!!");
                    patient.setId(patientID + 1);
                    System.out.println("\u001B[1m The Patient ID is: "+ patient.getId());
                    break;   
                case 4:
                    showAllPatients();
                    break;
                case 5:
                    checkEachCommunity();
                    break;
              
                /*case 5:
                    showAllCityDetails();
                    break;
                case 6:
                    showAllCommunityDetails();
                    break;
                case 7:
                    ArrayList<Community> allComm;
                    int normal = 0;
                    int abnormal = 0;
                    System.out.println("\nEnter the Vital Signs: ");
                    scanner = new Scanner(System.in);
                    String vitalSignCheck = scanner.nextLine();
                    allComm = showAllCommunities(false);
                    Boolean vitalSignExists = true;
                    for (Community community: allComm) {
                        for(Patient p: patDir.getDirectory()) {
                            if(!p.getCommunityName().equals(community.getCommunityName()) ||
                                    !p.getCityName().equals(community.getCityName()))
                                continue;
                            if(p.isThisVitalSignNormal(vitalSignCheck) == null){
                                System.out.println("\u001B[1m Vital Sign does not exist!! \n");
                                vitalSignExists = false;
                                break;
                            }
                            if(p.isThisVitalSignNormal(vitalSignCheck))
                                normal++;
                            else
                                abnormal++;
                        }
                        if(!vitalSignExists)
                            break;
                        System.out.println("\u001B[1m Patients with Normal "+vitalSignCheck + " in "+community+":"+normal);
                        System.out.println("\u001B[1m Patients with abormal "+vitalSignCheck + " in "+community+":"+abnormal);
                    }
                    break;*/
                case 8:
                    return;
            }
        }while(choice != 9);
        
    }
    
    
    
    private static void mainMenu(){
        System.out.println("\nPick an option from Below:");
        System.out.println(" 1 - Add Person");
        System.out.println(" 2 - View All Person");
        System.out.println(" 3 - Add Patient");
        System.out.println(" 4 - View all Patients");
        System.out.println(" 5 - Abnormal BP in Each Community");
        //System.out.println(" 5 - View all Cities");
       // System.out.println(" 6 - View all Communities");
        
       // System.out.println(" 7 - Find the number of Abnormal Signs in each Community");
        System.out.println(" 8 - Exit");
        System.out.println("\n");
    }
    
    private static void checkEachCommunity(){
        
        HashMap<String, Integer> commVal = new HashMap<String, Integer>();
         for(Patient patient: patDir.getDirectory()) {
            if(!(commVal.containsKey(patient.getCommunityName()))){
                commVal.put(patient.getCommunityName(), 0);
            }
         }
         
         for(Patient patient: patDir.getDirectory()) {
             Integer abNormCount = commVal.get(patient.getCommunityName());
            if(commVal.containsKey(patient.getCommunityName()) && !patient.isPatientBpNormal()){
                abNormCount++;
                commVal.put(patient.getCommunityName(), abNormCount);
            }
         }
         
         System.out.println("\nCommunity: " + commVal.keySet().toString());
                System.out.println("\nAbnormal Count: " + commVal.values());
    
    }
    
    private static void showFullList(){
        
        int i = 1;
        int choice;
        if(perDir.getDirectory().isEmpty()) {
            String text = "No Person/Patient is created yet!!";
            System.out.println("\n\u001B[1m" + text);
            return;
        }
            
        Person selectedPerson;
        Scanner scanner = new Scanner(System.in);
        for(Person person: perDir.getDirectory()){
            System.out.printf("%3d. %s\n",i,person.getFullName());
            i++;
        }
        System.out.println("\n Choose a person to get their complete details: ");
        try {
            choice = scanner.nextInt();
            selectedPerson = perDir.perDirectory.get(choice - 1);
            showSelectedPerson(selectedPerson);
        }
        catch(Exception e){
            System.out.println("\n Navigating Back to Previous Menu\n");
        }
    }
    
    private static void showSelectedPerson(Person person){
        System.out.println(person);
        int choice;
        Scanner scanner = new Scanner(System.in);
        if(person instanceof Patient){
            System.out.println( "\n\u001B[1m" + person.getFullName() + " has visited the Hospital");
            patientMenu((Patient)person);
        }
        else {
            System.out.println("\n\nNote :");
            System.out.println(person.getFullName() + " has never visited the Hospital");
        }
    }
    
    private static void patientMenu(Patient patient) {
        int choice;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Choose one option from below for: "+ "'" +patient.getName() + "'");
            System.out.println("   1. Get Basic Details of: "+ "'" +patient.getName()+"'");
            System.out.println("   2. Get the Details of Hospitals Visit");
            System.out.println("   3. Get the Vital Signs from recent Hospital Visit");
            System.out.println("   4. Get the Vital Signs from the history of Hospital Visits");
            System.out.println("   5. Check if all Vital Signs are Normal");
            System.out.println("   6. Check for the Normality of given Vital Sign");
            System.out.println("   7. Add new visit to Hospital");
            System.out.println("   9. Previous Menu");
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println((Person)patient);
                    break;
                case 2:
                    int i = 1;
                    if(patient.getEncounterHistory().getHistory().size() == 0)
                        System.out.println("\u001B[1m Note : Patient had done only 1 visit\n");
                    else 
                        for(Encounter encounter: patient.getEncounterHistory().getHistory()) {
                            System.out.printf("%3d. %s\n",i,encounter.getEncounterDatetime());
                            i++;
                        }
                    System.out.printf("%3d. %s\n",i,patient.getEncounter().getEncounterDatetime());
                    break;
                case 3:
                    System.out.println(patient.getEncounter());
                    break;
                case 4:
                    patient.getEncounterHistory().printHistory();
                    System.out.println("Latest Visit: ");
                    System.out.println(patient.getEncounter());
                    break;
                case 5:
                    if(patient.isPatientNormal())
                        System.out.println("\u001B[1m Patient Vital Signs are in Normal Condition");
                    else
                        System.out.println("\u001B[1m Patient Vital Signs are Abnormal");
                    break;
                case 6:
                    System.out.print("\nChoose one of the Vital Signs from Below:\n"
                                + "1. Respiratory Rate\n"
                                + "2. Heart Rate\n"
                                + "3. SystolicBP\n"
                                + "4. Weight\n"
                                + "\n Enter a choice: ");
                    scanner = new Scanner(System.in);
                    String condition = "";
                    int userEntry = scanner.nextInt();
                   if(userEntry == 1) {
                    condition = "Respiratory Rate";
                   }else if(userEntry == 2) {
                    condition = "Heart Rate";
                   }else if(userEntry == 3) {
                    condition = "SystolicBP";
                   }else if(userEntry == 4) {
                    condition = "Weight";
                   }else{
                       System.out.println("\n\u001B[1m Invalid Choice Navigating Back to Previous Menu !!");
                   break;
                   }
                            
                    if(patient.isThisVitalSignNormal(condition)) 
                        System.out.println("\u001B[1m" + condition+" for "+patient.getName()+" is Normal");
                    else if(!patient.isThisVitalSignNormal(condition))
                        System.out.println("\u001B[1m" +condition+" for "+patient.getName()+" is Abnormal");
                    break;
                case 7:
                    patient.newEncounter();
                    break;
                case 9:
                    return;
            }
        }
    }
    
    private static void showAllPatients(){
        
        if(patDir.getDirectory().isEmpty()) {
            System.out.println("\u001B[1m There are no patients created !! ");
            return;
        }
        
        int i = 1;
        int choice;
        Scanner scanner = new Scanner(System.in);
        Patient selectedPatient;
        for(Patient patient: patDir.getDirectory()){
            System.out.printf("%3d. %s\n",i,patient.getFullName());
            i++;
        }
        System.out.println("\nChoose a patient to get their details: ");
        try {
            choice = scanner.nextInt();
            selectedPatient = patDir.getDirectory().get(choice - 1);
            patientMenu(selectedPatient);
        }
        catch(Exception e) {
            System.out.println("\u001B[1m  Navigating to Main Menu\n");
        }
    }

    private static void printPatient(Patient patient) {
        System.out.println("Encounter History of "+patient.getName()+":");
        patient.getEncounterHistory().printHistory();
        System.out.println("\nLatest Encounter Details: ");
        System.out.println("\u001B[1m " + patient.getEncounter());
    }

    private static Patient addVisit(Person person) {
        Patient patient = null;
        if (person instanceof Patient) {
            patient = (Patient)person;
            patient.newEncounter();
        }
        else {
            patient = new Patient(person);
            patDir.getDirectory().add(patient);
            patDir.getDirectory().remove(person);
            patDir.getDirectory().add(patient);
            patient.newEncounter();
        }
        return patient;
    }   

}

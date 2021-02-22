/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main {
    public static void main(String[] args) {
        
        ArrayList<Patient> pl = new ArrayList<Patient>();
        int patientId = 1000;
        Boolean checkPatStatus = false;
        Boolean noPat = false;
        Patient patient = new Patient();
        while (true){
        Scanner sc = new Scanner(System.in); 
        System.out.println("Please Enter your Choice: ");
        System.out.println("******************************************");
        System.out.println("Add");
        System.out.println("Check");
        System.out.println("History");
        System.out.println("Exit");
        System.out.println("******************************************");
        String userInput = sc.next();
        
        if (userInput.equalsIgnoreCase("Add")){
            
            VitalSigns v = new VitalSigns();
            System.out.println("Is an Existing Person? (Y/N)");
            String addStatus = sc.next();
            
            if(addStatus.equalsIgnoreCase("y") || addStatus.equalsIgnoreCase("n")){
                if(addStatus.equalsIgnoreCase("n")){  
                    System.out.println("Enter Patients Name: ");
                    String name = sc.next();
                    patient.setPatientName(name);
                    patientId = patientId+1;
                    patient.setPatientId(patientId);

                    System.out.println("The Patient ID is : "+ patientId);

                    System.out.println("Enter the Patient's Type: ");
                    String age = sc.next();
                    v.setAgeGroup(age);

                    System.out.println("*****************************************");
                    System.out.println("Kindly Enter Patient's Detail ");
                    System.out.println("*****************************************");

                    System.out.println("Enter Respiratory Rate: ");
                    v.setRespRate(sc.nextInt());

                    System.out.println("Enter Heart Rate: ");
                    v.setHeartRate(sc.nextInt());

                    System.out.println("Enter Blood Pressure: ");
                    v.setBp(sc.nextInt());

                    System.out.println("Enter Weight(in Kgs): ");
                    v.setWeightInKg(sc.nextFloat());

                    System.out.println("Enter Weight(in Pounds): ");
                    v.setWeightInPounds(sc.nextFloat());

                    boolean isPatientNormal = patient.isPatientNormal(v);
                    v.setPatStatus(isPatientNormal);
                    patient.vitalSignHistory.add(v);
                    pl.add(patient);

                    System.out.println("****************************************");
                    System.out.println("Is Patient Normal: ");
                    System.out.println(isPatientNormal);
                    System.out.println("****************************************");
                    System.out.println("Do you want to check the individual Vital Signs?? (Yes/ No)");
                    String userVal = sc.next();
                    if(!userVal.toLowerCase().equals("yes") && !userVal.toLowerCase().equals("no")){
                        System.out.println("Please enter Yes/ No");
                        userVal = sc.next();
                    }
                    if (userVal.toLowerCase().equals("yes")) {
                        System.out.println("Please Enter the Vital Sign: ");
                        String vitalSign = sc.nextLine();
                        vitalSign+=sc.nextLine();
                        vitalSign = vitalSign.toLowerCase();

                        boolean normal = Patient.isThisVitalSignNormal(v, vitalSign);

                        System.out.println("**********************************************");
                        System.out.println("Is " + vitalSign +" Normal: ");
                        System.out.println(normal);
                        System.out.println("**********************************************");
                    }  
                }else{
                    System.out.println("Please Enter Patient's ID: ");
                    int pId = sc.nextInt();
                    if(pl.size() != 0){
                        for(int i=0;i < pl.size() ;i++){
                    if(pl.get(i).getPatientId() == pId){
                    System.out.println("Enter the Patient's Type: ");
                    String ages = sc.next();
                    v.setAgeGroup(ages);
                    
                    System.out.println("*****************************************");
                    System.out.println("Kindly Enter Patient's Detail ");
                    System.out.println("*****************************************");

                    System.out.println("Enter Respiratory Rate: ");
                    v.setRespRate(sc.nextInt());

                    System.out.println("Enter Heart Rate: ");
                    v.setHeartRate(sc.nextInt());

                    System.out.println("Enter Blood Pressure: ");
                    v.setBp(sc.nextInt());

                    System.out.println("Enter Weight(in Kgs): ");
                    v.setWeightInKg(sc.nextFloat());

                    System.out.println("Enter Weight(in Pounds): ");
                    v.setWeightInPounds(sc.nextFloat());
                    
                    boolean isPatientNormal = patient.isPatientNormal(v);
                    v.setPatStatus(isPatientNormal);
                    
                    
                    pl.get(i).vitalSignHistory.add(v);

                    System.out.println("****************************************");
                    System.out.println("Is Patient Normal: ");
                    System.out.println(isPatientNormal);
                    System.out.println("****************************************");
                    System.out.println("Do you want to check the individual Vital Signs?? (Yes/ No)");
                    String userVal = sc.next();
                        if(!userVal.toLowerCase().equals("yes") && !userVal.toLowerCase().equals("no")){
                            System.out.println("Please enter Yes/ No");
                            userVal = sc.next();
                        }
                        if (userVal.toLowerCase().equals("yes")) {
                            System.out.println("Please Enter the Vital Sign: ");
                            String vitalSign = sc.nextLine();
                            vitalSign+=sc.nextLine();
                            vitalSign = vitalSign.toLowerCase();

                            boolean normal = Patient.isThisVitalSignNormal(v, vitalSign);

                            System.out.println("**********************************************");
                            System.out.println("Is" + userVal +" Normal: ");
                            System.out.println(normal);
                            System.out.println("**********************************************");
                        }  
                    }else{
                        System.out.println("Patient ID not Exists !!");
                    }    
                }
                    }else{
                    System.out.println("Please Add Patient First !!");
                }
                    
                
                }
            }
            
        }else if (userInput.equalsIgnoreCase("Check")){
            System.out.println("Please Enter the Patient ID:");
            int patientIds = sc.nextInt();
            int index =0;
            for(int i=0;i < pl.size() ;i++){
                if(pl.get(i).getPatientId() == patientIds){
                 index = i;  
                 break;
                }else{
                    noPat = true;
                }     
            }
            if(noPat == false){
            patient = pl.get(index);
            
            }else{
                System.out.println("Patient ID not Exists !!");
                 break;
            }
            System.out.println("**************************************************");
            System.out.println("Is Patient Normal: ");
            for (VitalSigns v : patient.vitalSignHistory) {
                checkPatStatus = v.getPatStatus();
            }
            System.out.println(checkPatStatus);
            System.out.println("**************************************************");
        }
        else if (userInput.equalsIgnoreCase("History")){
             System.out.println("Please Enter the Patient ID:");
            int id = sc.nextInt();
            int index =0;
            for(int i=0;i < pl.size() ;i++){
                if(pl.get(i).getPatientId() == id){
                 index = i;  
                 break;
                }else{
                    noPat = true;
                }     
            }
            if(noPat == false){
            patient = pl.get(index);
            
            }else{
                System.out.println("Patient ID not Exists !!");
            }
            System.out.println("\nPatient's Vital Signs: ");
            
            int m =0;
            System.out.println("Patient's name: " + patient.getPatientName());
            for (VitalSigns v : patient.vitalSignHistory) {
                m++;
                System.out.println("**************** Vital Sign - "+ m +"*******************************");
                System.out.println("Patient's Type: "+v.getAgeGroup());
                System.out.println("Patient's Respiratory Rate: "+v.getRespRate());
                System.out.println("Patient's Heart Rate: "+v.getHeartRate());
                System.out.println("Patients Blood Pressure: "+v.getBp());
                System.out.println("Patient's Weight(in Kgs): "+v.getWeightInKg());
                System.out.println("Patients Weight(in Pounds): "+v.getWeightInPounds()); 
                System.out.println("*********************************************************************");
            }
        }else if (userInput.equalsIgnoreCase("Exit")){
            System.out.println("\n Thank you !! ");
            break;
        }
    }
    }
}

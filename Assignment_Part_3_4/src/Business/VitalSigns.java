/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class VitalSigns {

    double respRate;
    double heartRate;
    double bp;
    double weightInKilos;
    double weightInPounds;
    Boolean areVitalSignsNormal;
    
    public VitalSigns(){
        Boolean good = false;
        Scanner scanner = new Scanner(System.in);
        while(!good) {
            try {
                scanner = new Scanner(System.in);
                System.out.println("\nPlease enter Respiratory Rate: ");
                this.respRate = scanner.nextDouble();
                System.out.println("\nPlease enter Heart Rate: ");
                this.heartRate = scanner.nextDouble();
                System.out.println("\nPlease enter SystolicBP: ");
                this.bp = scanner.nextDouble();
                System.out.println("\nPlease enter Weight(in Kgs): ");
                this.weightInKilos = scanner.nextDouble();
                this.weightInPounds = this.weightInKilos * 2.20462262;
                good = true;
            }
            catch(Exception e){
                System.out.println("Enter values in correct format.\n");
            }
        }
    }
    
    public VitalSigns(double respiratoryRate, double heartRate, double systolicBP, double weightInKilos) { //, double weightInPounds){
        this.respRate = respiratoryRate;
        this.heartRate = heartRate;
        this.bp = systolicBP;
        this.weightInKilos = weightInKilos;
        this.weightInPounds = weightInKilos * 2.20462262;
        
    }
    
    public void updateVitalSigns(double respiratoryRate, double heartRate, double systolicBP, double weightInKilos) { //, double weightInPounds){
        this.respRate = respiratoryRate;
        this.heartRate = heartRate;
        this.bp = systolicBP;
        this.weightInKilos = weightInKilos;
        this.weightInPounds = weightInKilos * 2.20462262;
    }

    public double getRespiratoryRate() {
        return respRate;
    }

    public void setRespiratoryRate(double respiratoryRate) {
        this.respRate = respiratoryRate;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getSystolicBP() {
        return bp;
    }

    public void setSystolicBP(double systolicBP) {
        this.bp = systolicBP;
    }

    public double getWeightInKilos() {
        return weightInKilos;
    }

    public void setWeightInKilos(double weightInKilos) {
        this.weightInKilos = weightInKilos;
    }

    public double getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public Boolean getAreVitalSignsNormal() {
        return areVitalSignsNormal;
    }

    public void setAreVitalSignsNormal(Boolean areVitalSignsNormal) {
        this.areVitalSignsNormal = areVitalSignsNormal;
    }

    
    Boolean isRespiratoryRateNormal(Patient patient){
        
        VitalSignsNormal vitalSignsNormal = new VitalSignsNormal();
        VitalSigns vitalSigns = patient.getVitalSigns();
        String ageGroup = patient.getAgeGroup();
        
        return vitalSigns.respRate >= Double.parseDouble(vitalSignsNormal.respiratoryRate.get(ageGroup).split("to")[0]) && 
                vitalSigns.respRate <= Double.parseDouble(vitalSignsNormal.respiratoryRate.get(ageGroup).split("to")[1]);
    }
    
    Boolean isHeartRateNormal(Patient patient){
        
        VitalSignsNormal vitalSignsNormal = new VitalSignsNormal();
        VitalSigns vitalSigns = patient.getVitalSigns();
        String ageGroup = patient.getAgeGroup();
        
        return vitalSigns.heartRate >= Double.parseDouble(vitalSignsNormal.heartRate.get(ageGroup).split("to")[0]) && 
                vitalSigns.heartRate <= Double.parseDouble(vitalSignsNormal.heartRate.get(ageGroup).split("to")[1]);
    }
    
    Boolean isSystolicBPNormal(Patient patient){
        
        VitalSignsNormal vitalSignsNormal = new VitalSignsNormal();
        VitalSigns vitalSigns = patient.getVitalSigns();
        String ageGroup = patient.getAgeGroup();
        
        return vitalSigns.bp >= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[0]) && 
                vitalSigns.bp <= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[1]);
    }
    
    Boolean isWeightNormal(Patient patient){
        
        VitalSignsNormal vitalSignsNormal = new VitalSignsNormal();
        VitalSigns vitalSigns = patient.getVitalSigns();
        String ageGroup = patient.getAgeGroup();
        
        return vitalSigns.weightInKilos >= Double.parseDouble(vitalSignsNormal.weightInKilos.get(ageGroup).split("to")[0]) && 
                vitalSigns.weightInKilos <= Double.parseDouble(vitalSignsNormal.weightInKilos.get(ageGroup).split("to")[1]);
    }

    Boolean areVitalSignsNormal(Patient patient) {
        return isRespiratoryRateNormal(patient) && isHeartRateNormal(patient) && isSystolicBPNormal(patient) && isWeightNormal(patient);
    }
     Boolean isBpNormal(Patient patient) {
        return isSystolicBPNormal(patient);
    }

    private int compareVitalSigns(VitalSigns vitalSigns, String ageGroup) {
        int result = 0;
        
        VitalSignsNormal vitalSignsNormal = new VitalSignsNormal();
        
       if(vitalSigns.respRate >= Double.parseDouble(vitalSignsNormal.respiratoryRate.get(ageGroup).split("to")[0]) && 
                vitalSigns.respRate <= Double.parseDouble(vitalSignsNormal.respiratoryRate.get(ageGroup).split("to")[1]))
            result = 0;
        
        else 
            return 1;
        
        if(vitalSigns.heartRate >= Double.parseDouble(vitalSignsNormal.heartRate.get(ageGroup).split("to")[0]) && 
                vitalSigns.heartRate <= Double.parseDouble(vitalSignsNormal.heartRate.get(ageGroup).split("to")[1]))
            result = 0;
        else 
            return 2;
        
        if(vitalSigns.bp >= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[0]) && 
                vitalSigns.bp <= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[1]))
            result = 0;
        else 
            return 3;
        
        if(vitalSigns.weightInKilos >= Double.parseDouble(vitalSignsNormal.weightInKilos.get(ageGroup).split("to")[0]) && 
                vitalSigns.weightInKilos <= Double.parseDouble(vitalSignsNormal.weightInKilos.get(ageGroup).split("to")[1]))
            result = 0;
        else 
            return 4;
        
        if(vitalSigns.weightInPounds >= Double.parseDouble(vitalSignsNormal.weightInPounds.get(ageGroup).split("to")[0]) && 
                vitalSigns.weightInPounds <= Double.parseDouble(vitalSignsNormal.weightInPounds.get(ageGroup).split("to")[1]))
            result = 0;
        else 
            return 5;
        if(vitalSigns.bp >= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[0]) && 
                vitalSigns.bp <= Double.parseDouble(vitalSignsNormal.systolicBP.get(ageGroup).split("to")[1]))
            result = 0;
        else 
            return 3;
        
        return result;
    }
    
    private int compareVitalSigns(Patient patient) {
        int result = 0;
        
        if(!isRespiratoryRateNormal(patient))
            return 1;
        
        if(!isHeartRateNormal(patient))
            return 2;
        
        if(!isSystolicBPNormal(patient))
            return 3;
        
       if(!isWeightNormal(patient))
            return 4;
        
        return result;
    }
    
    @Override
    public String toString(){
        return //"  DateTime: " + this.vitalSignDatetime + 
                "\n  Respiratory Rate: "+ this.respRate + "\n  Heart Rate: "+this.heartRate
                + "\n  Systolic Blood Pressure: "+this.bp+"\n  Weight(KG): "+this.weightInKilos
                + String.format("\n  Weight(lbs): %6.2f", this.weightInPounds);
    }

    Boolean isThisVitalSignNormal(Patient patient, String vitalSign) {
      
       if(vitalSign.toLowerCase().equals("Respiratory Rate".toLowerCase()))
            return isRespiratoryRateNormal(patient);
        else if (vitalSign.toLowerCase().equals("Heart Rate".toLowerCase()))
            return isHeartRateNormal(patient);
        else if (vitalSign.toLowerCase().equals("SystolicBP".toLowerCase()))
            return isSystolicBPNormal(patient);
        else if (vitalSign.toLowerCase().equals("Weight".toLowerCase()))
            return isWeightNormal(patient);
        if (vitalSign.toLowerCase().equals("SystolicBP".toLowerCase()))
            return isSystolicBPNormal(patient);
        else
            System.out.println("Given Vital Sign details are not found.\n");
        
        return null;
    }
    
}

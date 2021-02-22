/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import Business.VitalSigns;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Patient {
    
    private int patientId;
    private String patientName;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
    
    
    ArrayList<VitalSigns> vitalSignHistory = new ArrayList<VitalSigns>();

    public Boolean isPatientNormal(VitalSigns v) {
       
        if((v.getAgeGroup().toLowerCase().equals("newborn")) && 
                (v.getRespRate() > 29 && v.getRespRate() <51) && (v.getHeartRate() > 119 && v.getHeartRate() < 161) && 
                    (v.getBp() > 49 && v.getBp() < 71) &&(v.getWeightInKg() > 1 && v.getWeightInKg() < 4) && (v.getWeightInPounds() > 4.4 && v.getWeightInPounds() < 7.1)){
            return true;
        } else if((v.getAgeGroup().toLowerCase().equals("infant")) && 
                (v.getRespRate() > 19 && v.getRespRate() <31) && (v.getHeartRate() > 79 && v.getHeartRate() < 141) && 
                    (v.getBp() > 69 && v.getBp() < 101) &&(v.getWeightInKg() > 3 && v.getWeightInKg() < 11) && (v.getWeightInPounds() > 8 && v.getWeightInPounds() < 23)){
            return true;
        } else if((v.getAgeGroup().toLowerCase().equals("toddler")) && 
                (v.getRespRate() > 19 && v.getRespRate() <31) && (v.getHeartRate() > 79 && v.getHeartRate() < 131) && 
                    (v.getBp() > 79 && v.getBp() < 111) &&(v.getWeightInKg() > 9 && v.getWeightInKg() < 15) && (v.getWeightInPounds() > 21 && v.getWeightInPounds() <32 )){
            return true;
        }else if((v.getAgeGroup().toLowerCase().equals("preschooler")) && 
                (v.getRespRate() > 19 && v.getRespRate() <31) && (v.getHeartRate() > 79 && v.getHeartRate() < 121) && 
                    (v.getBp() > 79 && v.getBp() < 111) &&(v.getWeightInKg() > 13 && v.getWeightInKg() < 19) && (v.getWeightInPounds() > 30 && v.getWeightInPounds() <41 )){
            return true;
        }else if((v.getAgeGroup().toLowerCase().equals("schoolage")) && 
                (v.getRespRate() > 19 && v.getRespRate() <31) && (v.getHeartRate() > 69 && v.getHeartRate() < 111) && 
                    (v.getBp() > 79 && v.getBp() < 121) &&(v.getWeightInKg() > 19 && v.getWeightInKg() < 43) && (v.getWeightInPounds() > 40 && v.getWeightInPounds()<93 )){
            return true;
        }else if((v.getAgeGroup().toLowerCase().equals("adoloscent")) && 
                (v.getRespRate() > 11 && v.getRespRate() <21) && (v.getHeartRate() > 54 && v.getHeartRate() < 106) && 
                    (v.getBp() > 109 && v.getBp() < 121) &&(v.getWeightInKg() > 50) && (v.getWeightInPounds() > 110)){
            return true; 
        } 
        return false;  
    }

    public static boolean isThisVitalSignNormal(VitalSigns v, String type) {
        if(type.equalsIgnoreCase("Respiratory Rate")){
            if((v.getAgeGroup().equalsIgnoreCase("New Born")) && (v.getRespRate() > 29 && v.getRespRate() < 51)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Infant")) && (v.getRespRate() > 19 && v.getRespRate() < 31)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Toddler")) && (v.getRespRate() > 19 && v.getRespRate() < 31)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Preschooler")) && (v.getRespRate() > 19 && v.getRespRate() < 31)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("School age")) && (v.getRespRate() > 19 && v.getRespRate() < 31)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Adolescent")) && (v.getRespRate() > 11 && v.getRespRate() < 21)){
                return true;
            }
        }else if (type.equalsIgnoreCase("Heart Rate")){
            if((v.getAgeGroup().equalsIgnoreCase("New Born")) && (v.getHeartRate() > 119 && v.getHeartRate() < 161)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Infant")) && (v.getHeartRate() > 79 && v.getHeartRate() < 141)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Toddler")) && (v.getHeartRate() > 79 && v.getHeartRate() < 131)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Preschooler")) && (v.getHeartRate() > 79 && v.getHeartRate() < 119)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("School Age")) && (v.getHeartRate() > 69 && v.getHeartRate() < 109)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Adolescent")) && (v.getHeartRate() > 54 && v.getHeartRate() < 106)){
                return true;
            } 
        }else if (type.equalsIgnoreCase("Blood Pressure")){
            if((v.getAgeGroup().equalsIgnoreCase("New Born")) && (v.getBp()> 49 && v.getBp() < 71)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Infant")) && (v.getBp()> 69 && v.getBp() < 101)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Toddler")) && (v.getBp()> 79 && v.getBp() < 111)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Preschooler")) && (v.getBp()> 79 && v.getBp() < 111)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("School Age")) && (v.getBp()> 79 && v.getBp() < 121)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Adolescent")) && (v.getBp()> 109 && v.getBp() < 121)){
                return true;
            }
        }else if (type.equalsIgnoreCase("Weight in Kg")){
            if((v.getAgeGroup().equalsIgnoreCase("New Born")) && (v.getWeightInKg() > 1.9 && v.getWeightInKg() < 3.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Infant")) && (v.getWeightInKg() > 3.9 && v.getWeightInKg() < 10.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Toddler")) && (v.getWeightInKg() > 9.9 && v.getWeightInKg() < 14.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Preschooler")) && (v.getWeightInKg() > 13.9 && v.getWeightInKg() < 18.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("School Age")) && (v.getWeightInKg() > 19.9 && v.getWeightInKg() < 42.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Adolescent")) && (v.getWeightInKg() > 49.9)){
                return true;
            }
        }else if (type.equalsIgnoreCase("Weight in Pounds")){
            if((v.getAgeGroup().equalsIgnoreCase("New Born")) && (v.getWeightInPounds() > 4.4 && v.getWeightInPounds() < 7.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Infant")) && (v.getWeightInPounds() > 8.9 && v.getWeightInPounds() < 22.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Toddler")) && (v.getWeightInPounds() > 21.9 && v.getWeightInPounds() < 31.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Preschooler")) && (v.getWeightInPounds() > 30.9 && v.getWeightInPounds() < 41.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("School Age")) && (v.getWeightInPounds() > 40.9 && v.getWeightInPounds() < 92.1)){
                return true;
            }else if((v.getAgeGroup().equalsIgnoreCase("Adolescent")) && (v.getWeightInPounds() > 109)){
                return true;
            }
        }
        return false;
   }
}


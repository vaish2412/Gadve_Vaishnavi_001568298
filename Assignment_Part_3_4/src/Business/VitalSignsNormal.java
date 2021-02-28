/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
public class VitalSignsNormal {
    
    Map<String, String> respiratoryRate;
    Map<String, String> heartRate;
    Map<String, String> systolicBP;
    Map<String, String> weightInKilos;
    Map<String, String> weightInPounds;
    
    public VitalSignsNormal(){
        
        systolicBP = new HashMap<String, String>() {
            {
                put("NewBorn","50to70");
                put("Infant","70to100");
                put("Toddler","80to110");
                put("Preschooler","80to110");
                put("SchoolAge","80to120");
                put("Adolescent","110to120");
            }
        };
        
        respiratoryRate = new HashMap<String, String>() {
            {
                put("NewBorn","30to50");
                put("Infant","20to30");
                put("Toddler","20to30");
                put("Preschooler","20to30");
                put("SchoolAge","20to30");
                put("Adolescent","12to20");
            }
        };
        
        heartRate = new HashMap<String, String>() {
            {
                put("NewBorn","120to160");
                put("Infant","80to140");
                put("Toddler","80to130");
                put("Preschooler","80to120");
                put("SchoolAge","70to110");
                put("Adolescent","55to105");
            }
        };
        
        systolicBP = new HashMap<String, String>() {
            {
                put("NewBorn","50to70");
                put("Infant","70to100");
                put("Toddler","80to110");
                put("Preschooler","80to110");
                put("SchoolAge","80to120");
                put("Adolescent","110to120");
            }
        };
        
        weightInKilos = new HashMap<String, String>() {
            {
                put("NewBorn","2to3");
                put("Infant","4to10");
                put("Toddler","10to14");
                put("Preschooler","14to18");
                put("SchoolAge","20to42");
                put("Adolescent","50.00001to9999");
            }
        };
        
        weightInPounds = new HashMap<String, String>() {
            {
                put("NewBorn","4.5to7");
                put("Infant","9to22");
                put("Toddler","22to31");
                put("Preschooler","31to40");
                put("SchoolAge","41to92");
                put("Adolescent","110.0001to24999");
            }
        }; 
    }
    
}

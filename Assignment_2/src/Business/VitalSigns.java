
 //* To change this license header, choose License Headers in Project Properties.
 //* To change this template file, choose Tools | Templates
 //* and open the template in the editor.
 
package Business;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author admin
 */
public class VitalSigns {
    
    private String ageGroup;
    private int respRate;
    private int heartRate;
    private int bp;
    private float weightInKg;
    private float weightInPounds;
    private Boolean patStatus;
    private Instant date;
    
    
    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public int getRespRate() {
        return respRate;
    }

    public void setRespRate(int respRate) {
        this.respRate = respRate;
    }

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public int getBp() {
        return bp;
    }

    public void setBp(int bp) {
        this.bp = bp;
    }

    public float getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(float weightInKg) {
        this.weightInKg = weightInKg;
    }

    public float getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(float weightInPounds) {
        this.weightInPounds = weightInPounds;
    } 

    public Boolean getPatStatus() {
        return patStatus;
    }

    public void setPatStatus(Boolean patStatus) {
        this.patStatus = patStatus;
    }
  public Instant getDate() {
        Date d = new Date();
      return d.toInstant();
       
    }   

}

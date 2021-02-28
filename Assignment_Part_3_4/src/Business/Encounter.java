/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author  admin
 */
public class Encounter {

    VitalSigns vitalSigns;
    String encDate;

    public Encounter() {
        this.vitalSigns = new VitalSigns();
        this.encDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-DD hh:mm:ss"));
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }

    public String getEncounterDatetime() {
        return encDate;
    }

    public void setEncounterDatetime(String encounterDatetime) {
        this.encDate = encounterDatetime;
    }
    
    @Override
    public String toString(){
        return "\n The Encounter Datetime is : "+this.encDate +this.vitalSigns;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author admin
 */
public class Patient extends Person{

    Boolean isPatNormal;
    Encounter encounter;
    EncounterHistory encHistory;

    // Constructor for adding new person
    public Patient() {
       this.encHistory = new EncounterHistory(); 
    }
    
       // Constructor for getting Existing Person
    Patient(Person person) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.ageGroup = person.getAgeGroup();
        this.dob = person.getDOB();
        this.houseNo = person.getHouseNum();
        this.commName = person.getCommunityName();
        this.cityName = person.getCityName();
        this.encHistory = new EncounterHistory();
    }
    
    public Boolean isPatientNormal(){
        return encounter.getVitalSigns().areVitalSignsNormal(this);
    }
    public Boolean isPatientBpNormal(){
        return encounter.getVitalSigns().isBpNormal(this);
    }
    
    public Boolean isThisVitalSignNormal(String vitalSign){
        return encounter.getVitalSigns().isThisVitalSignNormal(this, vitalSign);
    }

    public Encounter getRecentEncounter() {
        return encounter;
    }
    
    public String getName() {
        return getFullName();
    }

    public void setEncounter(Encounter encounter) {
        this.encounter = encounter;
    }

    public EncounterHistory getEncounterHistory() {
        return encHistory;
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encHistory = encounterHistory;
    }
    
    public Encounter newEncounter(){
        if (this.encounter != null){
            this.encHistory.getHistory().add(this.encounter);
        }
        this.encounter = new Encounter();
        this.isPatNormal = this.isPatientNormal();
        encounter.vitalSigns.setAreVitalSignsNormal(this.isPatNormal);
       
        return this.encounter;
    }

    VitalSigns getVitalSigns() {
        return this.getRecentEncounter().getVitalSigns();
    }

    public Encounter getEncounter() {
        return encounter;
    }

    public Boolean getIsPatientNormal() {
        return isPatNormal;
    }

    void setVitalSigns(VitalSigns vitalSigns) {
        this.newEncounter();
        this.encounter.setVitalSigns(vitalSigns);
    }
    
}

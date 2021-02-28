/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
class EncounterHistory {
    
    ArrayList<Encounter> encHistory;
    
    public EncounterHistory() {
        encHistory = new ArrayList<Encounter>();
    } 

    public ArrayList<Encounter> getHistory() {
        return encHistory;
    }

    public void setHistory(ArrayList<Encounter> history) {
        this.encHistory = history;
    }
    
    public void printHistory() {
        System.out.println(this);
    }
    
    public String toString() {
        String returnString = new String();
        returnString += "";
        int i = 1;
        for (Encounter visit: getHistory()) {
            returnString+="\n Encounter History - "+i+": \n";
            returnString += visit;
            i++;
        }
        return returnString;
    }
    
}

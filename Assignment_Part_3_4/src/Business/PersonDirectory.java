/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import java.util.ArrayList;

/**
 *
 * @author  admin
 */
public class PersonDirectory {

    ArrayList<Person> perDirectory;
    
    public PersonDirectory() {
        perDirectory = new ArrayList<Person>();
    }

    public ArrayList<Person> getDirectory() {
        return perDirectory;
    }
    
    public Person newPerson(){
        Person person = new Person();
        person.initializePerson();
        perDirectory.add(person);
        return person;
    }
    
        @Override
    public String toString(){
        String returnString = new String();
        int i = 0;
        for (Person person: perDirectory){
            returnString += "Patient "+i+":\n";
            returnString += person + "\n";
            i++;
        }
        return returnString;
    }
    
}

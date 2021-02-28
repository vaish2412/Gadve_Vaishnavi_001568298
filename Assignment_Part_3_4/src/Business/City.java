/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author admin  
 * 
 */
public class City {

    String cityName;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String city) {
        this.cityName = city;
    }
    
    @Override
    public String toString(){
        return "\n The City is : " + "\u001B[1m" + this.cityName;
    }
    
}

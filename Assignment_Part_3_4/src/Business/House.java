/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

/**
 *
 * @author  admin
 */
public class House extends Community{

    String houseNo;
    
    public String getHouseNum() {
        return houseNo;
    }

    public void setHouseNum(String houseNum) {
        this.houseNo = houseNum;
    }
    
    @Override
    public String toString(){
        return "\n The House Number is : " + "\u001B[1m" + this.houseNo + super.toString();
    }
    
}

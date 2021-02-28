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
public class Community extends City{

    String commName;

    public String getCommunityName() {
        return commName;
    }

    public void setCommunityName(String communityName) {
        this.commName = communityName;
    }
    
    @Override
    public String toString(){
        return "\n The Community is : " + "\u001B[1m" + this.commName + super.toString();
    }
    
}

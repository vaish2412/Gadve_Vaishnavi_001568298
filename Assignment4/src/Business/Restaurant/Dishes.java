/*done
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

/**
 *
 * @author admin
 */
public class Dishes {
    
    private String name;
    private String description;
    private String price;

    
    public Dishes(String name,String description,String price){
        this.name = name;
        this.description = description;
        this.price = price;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

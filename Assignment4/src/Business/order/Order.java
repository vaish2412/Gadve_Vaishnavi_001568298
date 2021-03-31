/*done
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.order;

import Business.Restaurant.Dishes;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Order {
    private String orderId;
    private String restaurantName;
    private String CustomerName;
    private String DeliveryMan;
    private ArrayList<Dishes> Order;
    private String price;
    private String status;
    private String deliveryAddress;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getDeliveryMan() {
        return DeliveryMan;
    }

    public void setDeliveryMan(String DeliveryMan) {
        this.DeliveryMan = DeliveryMan;
    }

    public ArrayList<Dishes> getOrder() {
        return Order;
    }

    public void setOrder(ArrayList<Dishes> Order) {
        this.Order = Order;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    
    
    
    
    @Override
    public String toString() {
        return orderId;
    }
}

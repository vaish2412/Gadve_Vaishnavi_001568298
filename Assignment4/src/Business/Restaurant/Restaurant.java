/*done
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Restaurant;

import Business.order.Order;
import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class Restaurant {
    private String name;
    private String userName;
    private String address;
    private String number;
    private ArrayList<Dishes> Menu;
    private ArrayList<Order> orderList;

     public Restaurant(String userName){
        this.userName = userName;
        Menu = new ArrayList<Dishes>();
        orderList=new ArrayList<Order>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ArrayList<Dishes> getMenu() {
        return Menu;
    }

    public void setMenu(ArrayList<Dishes> Menu) {
        this.Menu = Menu;
    }
    
    public void addFoodItem(Dishes menu){
        Menu.add(menu);
    }
    
    public void removeFoodItem(Dishes menu){
         Menu.remove(menu);
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(ArrayList<Order> orderList) {
        this.orderList = orderList;
    }
    
    int id = 1;
      public void addOrder(String restaurentName, String customerName, String deliverMan, ArrayList<Dishes> Order, String price, String deliveryAddress) {
        Order order=new Order();
        order.setOrderId(String.valueOf(id));
        order.setCustomerName(customerName);
        order.setRestaurantName(restaurentName);
        order.setDeliveryMan(deliverMan);
        order.setOrder(Order);
        order.setPrice(price);
        order.setDeliveryAddress(deliveryAddress);
        order.setStatus("New Order");
        orderList.add(order);
        id++;
    }
    
    @Override
    public String toString() {
        return name;
    }
    
}

/*done
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    
    private ArrayList<Customer> customerDirectory;
    private Customer customer;
    
    public CustomerDirectory(){
        this.customerDirectory = new ArrayList<Customer>();
    }

    public ArrayList<Customer> getCustomerDirectory() {
        return customerDirectory;
    }

    public void setCustomerDirectory(ArrayList<Customer> customerDirectory) {
        this.customerDirectory = customerDirectory;
    }
    
    public Customer createUserAccount(String username){
        customer = new Customer(username);
        customerDirectory.add(customer);
        return customer;
    }
    
    
    public void deleteCustomer(String username){
        for(int i=0;i<customerDirectory.size();i++){
            if(customerDirectory.get(i).getUserName()==username){
                customerDirectory.remove(i);
            }
        }
    }
    
}

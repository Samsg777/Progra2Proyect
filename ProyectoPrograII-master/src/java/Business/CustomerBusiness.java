/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Data.CustomerData;
import Domain.Customer;
import Domain.User;
import Domain.UserOperations;
import Domain.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Arturo
 */
public class CustomerBusiness implements UserOperations {

    CustomerData customerData;

    public CustomerBusiness() {

        customerData = new CustomerData();
    }

    //TODO: APLICAR UNA REGLA DE NEGOCIO, un cliente no puede ser agregado más de una vez
    public void insertCustomer(Customer customer) {
        try {
            customerData.insertCustomer(customer);
        } catch (IOException ex) {
            Logger.getLogger(CustomerBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //TODO: APLICAR UNA REGLA DE NEGOCIO
    public void removeCustomer(Customer customer) {

//        customerData.removeCustomer(customer);
    }
     public ArrayList<Customer> getCustomersByVehicle(Vehicle vehicle) {
        return customerData.getCustomersByVehicle(vehicle);        
    }

    public LinkedList<Customer> getAllCustomers() {
        LinkedList<Customer> customers = new LinkedList<>();
        try {
            customers = customerData.getAllCustomers();
        } catch (java.text.ParseException ex) {
            Logger.getLogger(CustomerBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CustomerBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
//
//    public Customer[] getAllCustomersArray() {
//
////        return customerData.getAllCustomersArray();
//    }
//
//    //APLICA UNA REGLA DE NEGOCIO
//    public Customer findCustomerByName(String customerName) {
//        return customerData.findCustomerByName(customerName);
//    }
//
//    @Override
//    public User searchUser(String name) {
//
//        return findCustomerByName(name);
//
//    }
//
//    @Override
//    public User searchUser(User user) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public User searchUser(String username, String password) {
//
//        Customer customer = new Customer();
//        Customer[] allCustomersArray = getAllCustomersArray();
//        String loginDetails[] = {username, password};
//
//        for (Customer currentCustomer : allCustomersArray) {
//            if (currentCustomer.verifyUserLogin(loginDetails)) {
//                customer = currentCustomer;
//            }
//        }
//
//        return customer;
//    }
//
//    @Override
//    public ArrayList<User> sortUsers(User[] allUsers) {
//
//        //Esto se hace para convertir un ArrayList de Users
//        //a un ArrayList de Customers
//        ArrayList<User> customersToReturn = new ArrayList<>();
//        ArrayList<Customer> customerSorted = bubbleSort(allUsers);
//
//        for (int position = 0; position < customerSorted.size(); position++) {
//
//            customersToReturn.add(customerSorted.get(position));
//        }
//
//        return customersToReturn;
//
//    }
//
//    public static ArrayList<Customer> bubbleSort(User[] customers) {
//        int position;
//        boolean flag = true;
//        Customer temporalCustomer;
//        ArrayList<Customer> customerArrayList = new ArrayList<>();
//
//        while (flag) {
//            flag = false;
//            for (position = 0; position < customers.length - 1; position++) {
//                if (customers[position].getName().compareToIgnoreCase(customers[position + 1].getName()) > 0) // change to > for ascending sort
//                {
//                    temporalCustomer = (Customer) customers[position];                //swap elements
//                    customers[position] = customers[position + 1];
//                    customers[position + 1] = temporalCustomer;
//                    flag = true;
//                }
//            }
//        }
//
//        for (User customer : customers) {
//
//            customerArrayList.add((Customer) customer);
//        }
//
//        return customerArrayList;
//    }
//
//    @Override
//    public ArrayList<User> sortUsers(String identification, User[] allUsers) {
//
//        //Esto se hace para convertir un ArrayList de Users
//        //a un ArrayList de Customers
//        ArrayList<User> customersToReturn = new ArrayList<>();
//        ArrayList<Customer> customerSorted = quicksortP(allUsers, 0, allUsers.length - 1);
//
//        for (int position = 0; position < customerSorted.size(); position++) {
//
//            customersToReturn.add(customerSorted.get(position));
//        }
//
//        return customersToReturn;
//
//    }
//
//    public static ArrayList<Customer> quicksortP(User[] allUsers, int izq, int der) {
//
//        int i = izq;
//        int j = der;
//        int pivote = (i + j) / 2;
//        do {
//            while (allUsers[i].getIdentification().compareToIgnoreCase(allUsers[pivote].getIdentification()) < 0) {
//                i++;
//            }
//            while (allUsers[j].getIdentification().compareToIgnoreCase(allUsers[pivote].getIdentification()) > 0) {
//                j--;
//            }
//            if (i <= j) {
//                Customer temporalCustomer = (Customer) allUsers[i];
//                allUsers[i] = allUsers[j];
//                allUsers[j] = temporalCustomer;
//                i++;
//                j--;
//            }
//        } while (i <= j);
//        if (izq < j) {
//            quicksortP(allUsers, izq, j);
//        }
//        if (i < der) {
//            quicksortP(allUsers, i, der);
//        }
//
//        ArrayList<Customer> customerArrayList = new ArrayList<>();
//        for (int k = 0; k < allUsers.length; k++) {
//            customerArrayList.add((Customer) allUsers[k]);
//        }
//        return customerArrayList;
//    }

    @Override
    public User searchUser(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User searchUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User searchUser(String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> sortUsers(User[] allUsers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<User> sortUsers(String identification, User[] allUsers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

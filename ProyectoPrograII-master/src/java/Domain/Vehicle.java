/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class Vehicle {

    private String plate;
    private String color;
    private String brand;
    private String model;
    private ArrayList<Customer> customers;
    private VehicleType vehicleType;

    public Vehicle() {
        customers = new ArrayList<>();
    }

    public Vehicle(String plate, String color, String brand, String model, Customer customer, VehicleType vehicleType) {
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.customers.add(customer);
        this.vehicleType = vehicleType;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public VehicleType getVehiculeType() {
        return vehicleType;
    }

    public void setVehiculeType(VehicleType vehiculeType) {
        this.vehicleType = vehiculeType;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Customer;
//import Domain.ParkingLot;
import Domain.Vehicle;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class VehicleData {

    public static ArrayList<Vehicle> vehicles;

    public VehicleData() {

        vehicles = new ArrayList<>();
        //HandCoded
        for (int i = 0; i < 10; i++) {
            Vehicle vehicle = new Vehicle();
            vehicle.setPlate("A" + i);
            if (i == 2) {
                vehicle.setCustomer(new Customer("304450072", "Arturo", "turo", "1234", false));
                vehicle.setCustomer(new Customer("123452", "jose", "chepe", "siiiiii", true));
                vehicles.add(vehicle);
            } else {
                vehicles.add(vehicle);
            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(vehicles.get(i).getPlate());
        }
    }

    public Vehicle insertVehicle(Vehicle vehicle) {

        vehicles.add(vehicle);

        return vehicle;
    }

    public void removeVehicle(Vehicle vehicle) {

        vehicles.remove(vehicle);

    }

    public ArrayList<Vehicle> getAllVehicles() {

        return vehicles;
    }

    //este método encuentra el vehicle de un cliente
    public Vehicle findVehicleByCustomer(Customer customer) {

        Vehicle vehicle = new Vehicle();

//        for (int i = 0; i < vehicles.size(); i++) {
//            //comparamos cada cliente de los vehículos
//            //con el cliente pasado por parámetro
//            if (vehicles.get(i).getCustomer().equals(customer)) {
//                //cliente asociado al vehículo fue encontrado
//                //por ende, vamos a retornar el vehículo
//                vehicle = vehicles.get(i);
//            }
//        }
        return vehicle;
    }

//    public ArrayList<Vehicle> findVehiclesByParkingLot(ParkingLot parkingLot) {
//
//        return parkingLot.getVehicles();
//    }
    public Vehicle findVehicleByPlate(String plate) {
        Vehicle vehicleToReturn = new Vehicle();
        int index = 0;
        boolean found = false;
        while (index < vehicles.size() && !found) {
            if (vehicles.get(index).getPlate().equals(plate)) {
                vehicleToReturn = vehicles.get(index);
                found = !found;
            }
            index++;
        }
        return vehicleToReturn;
    }

}

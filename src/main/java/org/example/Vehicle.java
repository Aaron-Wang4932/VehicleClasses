package org.example;

import java.util.ArrayList;

public class Vehicle {
    public static ArrayList<Vehicle> activeVehicles = new ArrayList<>();
    private static double gasPrice;
    private static double distanceKM;
    private final String license;
    private final int numPassengers;
    private final double fare;
    private final double fuelEfficiency;

    public Vehicle(String license, int numPassengers, double fare, double fuelEfficiency) {
        this.license = license;
        this.numPassengers = numPassengers;
        this.fare = fare;
        this.fuelEfficiency = fuelEfficiency;
    }

    private double getRevenue() {
        return numPassengers * fare;
    }

    private double getTotalCost() {
        return fuelEfficiency * gasPrice * distanceKM;
    }

    public double getProfit() {
        double profit = getRevenue() - getTotalCost();
        profit = Math.round(profit * 100) / 100.0;
        return profit;
    }

    public static Vehicle compare(Vehicle a, Vehicle b) {
        return a.getProfit() > b.getProfit() ? a : b;
    }
    @Override
    public String toString() {
        return "License Plate: " + getLicense() +
                "\nPassengers: " + getNumPassengers() +
                "\nFare Per Passenger: $" + getFare() +
                "\nFuel Efficiency: " + getFuelEfficiency() + " L/km" +
                "\nProfit: $" + getProfit();
    }

    public static double getGasPrice() {
        return gasPrice;
    }

    public static void setGasPrice(double gasPrice) {
        Vehicle.gasPrice = gasPrice;
    }

    public static double getDistanceKM() {
        return distanceKM;
    }

    public static void setDistanceKM(double distanceKM) {
        Vehicle.distanceKM = distanceKM;
    }

    public String getLicense() {
        return license;
    }

    public int getNumPassengers() {
        return numPassengers;
    }

    public double getFare() {
        return Math.round(fare * 100) / 100.0;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public static Vehicle searchVehicles(String license) {
        for(Vehicle v : activeVehicles) {
            if(v.getLicense().equals(license)) return v;
        }
        return null;
    }
}

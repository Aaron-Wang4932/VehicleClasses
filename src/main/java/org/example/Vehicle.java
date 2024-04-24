package org.example;

public class Vehicle {
    private static double gasPrice;
    private static double distanceKM;
    private final String license;
    private final int numPassengers;
    private final double fare;
    private final double fuelEfficiency;

    Vehicle(String license, int numPassengers, double fare, double fuelEfficiency) {
        this.license = license;
        this.numPassengers = numPassengers;
        this.fare = fare;
        this.fuelEfficiency = fuelEfficiency;
    }

    private double getRevenue() {
        return Math.round(numPassengers * fare * 100) / 100.0; // Rounded to two decimal points
    }

    private double getTotalCost() {
        return Math.round(fuelEfficiency * gasPrice * distanceKM * 100) / 100.0; // Rounded to two decimal points
    }

    public double getProfit() {
        return getRevenue() - getTotalCost();
    }

    public static Vehicle compare(Vehicle a, Vehicle b) {
        return a.getProfit() > b.getProfit() ? a : b;
    }
    @Override
    public String toString() {
        return "License Plate: " + getLicense() +
                "\nPassengers: " + getNumPassengers() +
                "\nFare Per Passenger: $" + fare +
                "\nFuel Efficiency: " + getFuelEfficiency() + " L/kM" +
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
        return fare;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }
}

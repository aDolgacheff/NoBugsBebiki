package org.example.car;

public class Car implements Drivable {
    private String brand;
    private String model;
    private int year;

    //setter
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //getter
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public void start() {
        System.out.println(this.brand + this.model + " в пути!");
    }

    @Override
    public void stop() {
        System.out.println(this.brand + this.model + " движение прекращено.");
    }

    @Override
    public void distance(int distance) {
        System.out.println(this.brand + " " + this.model + " " + this.year + ": пробег - " + distance + " км.");
    }
}

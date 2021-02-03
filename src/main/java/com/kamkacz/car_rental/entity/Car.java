package com.kamkacz.car_rental.entity;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "manufacture_year")
    private String manufactureYear;

    @Column(name = "motor")
    private String motor;

    @Column(name = "gearbox")
    private String gearbox;

    @Column(name = "body_configuration")
    private String bodyConfiguration;

    @Column(name = "color")
    private String color;

    public Car() {
    }

    public Car(int id, String brand, String model, String manufactureYear, String motor, String gearbox, String bodyConfiguration, String color) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.motor = motor;
        this.gearbox = gearbox;
        this.bodyConfiguration = bodyConfiguration;
        this.color = color;
    }

    public Car(String brand, String model, String manufactureYear, String motor, String gearbox, String bodyConfiguration, String color) {
        this.brand = brand;
        this.model = model;
        this.manufactureYear = manufactureYear;
        this.motor = motor;
        this.gearbox = gearbox;
        this.bodyConfiguration = bodyConfiguration;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(String manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public String getBodyConfiguration() {
        return bodyConfiguration;
    }

    public void setBodyConfiguration(String bodyConfiguration) {
        this.bodyConfiguration = bodyConfiguration;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureYear='" + manufactureYear + '\'' +
                ", motor='" + motor + '\'' +
                ", gearbox='" + gearbox + '\'' +
                ", bodyConfiguration='" + bodyConfiguration + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}

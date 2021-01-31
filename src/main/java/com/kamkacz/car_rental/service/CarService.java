package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> findAll();

    public Car findById(int theId);

    public void save(Car theCar);

    public void deleteById(int theId);

    public List<Car> searchBy(String theName);
}

package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> findAll();

    Car findById(int theId);

    void save(Car theCar);

    void deleteById(int theId);

    List<Car> searchBy(String theName);
}

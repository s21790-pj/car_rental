package com.kamkacz.car_rental.repository;

import com.kamkacz.car_rental.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    // add a method to sort by Brand
    List<Car> findAllByOrderByBrandAsc();

    List<Car> findByBrandContainsOrModelContainsAllIgnoreCase(String brand, String model);
}

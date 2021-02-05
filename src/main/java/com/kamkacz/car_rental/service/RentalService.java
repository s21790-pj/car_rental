package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.Rental;

import java.util.List;

public interface RentalService {

    List<Rental> findAll();

    Rental findById(int theId);

    void save(Rental theRental);

    void deleteById(int theId);

}

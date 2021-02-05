package com.kamkacz.car_rental.repository;

import com.kamkacz.car_rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
}

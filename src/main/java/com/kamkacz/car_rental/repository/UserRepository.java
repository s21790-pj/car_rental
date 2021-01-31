package com.kamkacz.car_rental.repository;

import com.kamkacz.car_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

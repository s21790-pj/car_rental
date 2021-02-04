package com.kamkacz.car_rental.repository;

import com.kamkacz.car_rental.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // add a method to sort by Name
    List<User> findAllByOrderByLastNameAsc();

    List<User> findByFirstNameContainsOrLastNameContainsAllIgnoreCase(String name, String lname);
}

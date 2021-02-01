package com.kamkacz.car_rental.dao;

import com.kamkacz.car_rental.entity.User;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}

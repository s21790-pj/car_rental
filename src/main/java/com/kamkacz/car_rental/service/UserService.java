package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.User;
import com.kamkacz.car_rental.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);

    List<User> findAll();

    User findById(int theId);

    void saveUser(User theUser);

    void deleteById(int theId);

    List<User> searchBy(String theName);
}

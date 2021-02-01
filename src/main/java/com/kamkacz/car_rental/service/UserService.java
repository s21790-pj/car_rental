package com.kamkacz.car_rental.service;

import com.kamkacz.car_rental.entity.User;
import com.kamkacz.car_rental.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(CrmUser crmUser);
}

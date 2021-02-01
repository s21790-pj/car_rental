package com.kamkacz.car_rental.dao;

import com.kamkacz.car_rental.entity.Role;

public interface RoleDao {

    Role findRoleByName(String theRoleName);
}

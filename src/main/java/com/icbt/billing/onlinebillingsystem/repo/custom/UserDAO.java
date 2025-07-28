package com.icbt.billing.onlinebillingsystem.repo.custom;

import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.CrudDAO;

import java.sql.SQLException;
import java.util.Optional;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public interface UserDAO extends CrudDAO<User,Integer> {
    Optional<User> findUserByUsername(String username) throws SQLException;
    boolean updateDeviceId(String username, String deviceId) throws SQLException;
}

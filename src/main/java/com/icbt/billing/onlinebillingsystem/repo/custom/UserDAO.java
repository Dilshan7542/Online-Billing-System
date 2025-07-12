package com.icbt.billing.onlinebillingsystem.repo.custom;

import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.CrudDAO;

import java.sql.SQLException;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public interface UserDAO extends CrudDAO<User,Integer> {
    boolean login(String username, String deviceId) throws SQLException;
}

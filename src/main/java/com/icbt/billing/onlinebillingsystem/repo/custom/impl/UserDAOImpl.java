package com.icbt.billing.onlinebillingsystem.repo.custom.impl;

import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.custom.UserDAO;
import com.icbt.billing.onlinebillingsystem.repo.util.CrudUtil;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {
    }

    @Override
    public boolean save(User entity) throws SQLException {
        return CrudUtil.execute(
                "INSERT INTO users(username, password,role) VALUES(?,?,?)",
                entity.getUsername(),
                entity.getPassword(),
                entity.getRole().name()
        );
    }

    @Override
    public boolean update(User entity) throws SQLException {
        return CrudUtil.execute(
                "UPDATE users SET password = ? WHERE user_id = ?",
                entity.getUsername(),
                entity.getPassword(),
                entity.getUserId()
        );
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public List<User> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<User> findByID(Integer integer) throws SQLException {
        return Optional.empty();
    }


    @Override
    public boolean login(String username, String deviceId) throws SQLException {
        return CrudUtil.execute(
                "UPDATE users SET device_id = ? WHERE username = ?",
                deviceId,
                username
        );
    }
}

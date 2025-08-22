package com.icbt.billing.onlinebillingsystem.repo.custom.impl;

import com.icbt.billing.onlinebillingsystem.entity.Role;
import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.custom.UserDAO;
import com.icbt.billing.onlinebillingsystem.repo.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                "UPDATE users SET username=?,password=?,device_id=?,token=?,role=? WHERE user_id =?",
                entity.getUsername(),
                entity.getPassword(),
                entity.getDeviceId(),
                entity.getToken(),
                entity.getRole().name(),
                entity.getUserId()
        );
    }

    @Override
    public boolean delete(Integer userId) throws SQLException {
        return CrudUtil.execute("DELETE FROM users WHERE user_id = ?", userId);
    }

    @Override
    public List<User> findAll() throws SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM users");
        ArrayList<User> list = new ArrayList<>();
        while (result.next()) {
           list.add(new User(
                    result.getInt("userId"),
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("deviceId"),
                    result.getString("token"),
                    Role.valueOf(result.getString("role").toUpperCase())
            ));
        }
        return list;
    }

    @Override
    public Optional<User> findByID(Integer id) throws SQLException {
        final String sql = "SELECT * FROM users WHERE user_id = ?";

        ResultSet rs = null;
        try {
            rs = CrudUtil.execute(sql, id); // returns ResultSet for SELECT
            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getInt("user_id"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password")); // hashed in DB
                u.setDeviceId(rs.getString("device_id"));
                u.setToken(rs.getString("token"));
                u.setRole(Role.valueOf(rs.getString("role").toUpperCase()));
                return Optional.of(u);
            }
            return Optional.empty();
        } finally {
            // only closing ResultSet (per your instruction)
            if (rs != null) {
                try { rs.close(); } catch (SQLException ignore) {}
            }
        }
    }


    @Override
    public Optional<User> findUserByUsername(String username) throws SQLException {
        ResultSet result = CrudUtil.execute("SELECT * FROM users WHERE username = ?", username);
        if (result.next()) {
            return Optional.of(new User(
                    result.getInt("user_id"),
                    result.getString("username"),
                    result.getString("password"),
                    result.getString("device_id"),
                    result.getString("token"),
                    Role.valueOf(result.getString("role").toUpperCase())
            ));
        }
        return Optional.empty();
    }

    @Override
    public boolean updateDeviceId(String username, String deviceId) throws SQLException {
        return CrudUtil.execute(
                "UPDATE users SET device_id = ? WHERE username = ?",
                deviceId,
                username
        );
    }
}

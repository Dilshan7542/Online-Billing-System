package com.icbt.billing.onlinebillingsystem.repo.custom.impl;

import com.icbt.billing.onlinebillingsystem.entity.Customer;
import com.icbt.billing.onlinebillingsystem.repo.custom.CustomerDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/12/2025
 */
public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean save(Customer entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<Customer> findByID(Integer integer) throws SQLException {
        return Optional.empty();
    }

}

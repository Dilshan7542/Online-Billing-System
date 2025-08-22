package com.icbt.billing.onlinebillingsystem.repo.custom.impl;

import com.icbt.billing.onlinebillingsystem.entity.Customer;
import com.icbt.billing.onlinebillingsystem.repo.custom.CustomerDAO;
import com.icbt.billing.onlinebillingsystem.repo.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAOImpl implements CustomerDAO {

    @Override
    public boolean save(Customer entity) throws SQLException {
        // If accountNo present use it, otherwise insert without it (handles both designs)
        if (entity.getAccountNo() > 0) {
            final String sql = "INSERT INTO customers(account_no, name, address, phone, units_consumed) VALUES (?,?,?,?,?)";
            return CrudUtil.execute(sql,
                    entity.getAccountNo(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getUnitsConsumed());
        } else {
            final String sql = "INSERT INTO customers(name, address, phone, units_consumed) VALUES (?,?,?,?)";
            return CrudUtil.execute(sql,
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getUnitsConsumed());
        }
    }

    @Override
    public boolean update(Customer entity) throws SQLException {
        final String sql = "UPDATE customers SET name = ?, address = ?, phone = ?, units_consumed = ? WHERE account_no = ?";
        return  CrudUtil.execute(sql,
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getUnitsConsumed(),
                entity.getAccountNo());
    }

    @Override
    public boolean delete(Integer accountNo) throws SQLException {
        final String sql = "DELETE FROM customers WHERE account_no = ?";
        return CrudUtil.execute(sql, accountNo);
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        final String sql = "SELECT account_no, name, address, phone, units_consumed FROM customers";
        ResultSet rs = null;
        List<Customer> list = new ArrayList<>();
        try {
            rs = CrudUtil.execute(sql);
            while (rs.next()) {
                Customer c = new Customer();
                c.setAccountNo(rs.getInt("account_no"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                c.setUnitsConsumed(rs.getInt("units_consumed"));
                list.add(c);
            }
            return list;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        }
    }

    @Override
    public Optional<Customer> findByID(Integer accountNo) throws SQLException {
        final String sql = "SELECT account_no, name, address, phone, units_consumed FROM customers WHERE account_no = ?";
        ResultSet rs = null;
        try {
            rs = CrudUtil.execute(sql, accountNo);
            if (rs.next()) {
                Customer c = new Customer();
                c.setAccountNo(rs.getInt("account_no"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                c.setUnitsConsumed(rs.getInt("units_consumed"));
                return Optional.of(c);
            }
            return Optional.empty();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        }
    }
}

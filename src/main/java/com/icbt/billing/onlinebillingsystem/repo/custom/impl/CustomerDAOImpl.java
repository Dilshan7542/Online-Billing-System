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
            final String sql = "INSERT INTO customers(account_no, name, address, phone, units_consumed) VALUES (?,?,?,?,?)";
            return CrudUtil.execute(sql,
                    entity.getAccountNo(),
                    entity.getName(),
                    entity.getAddress(),
                    entity.getPhone(),
                    entity.getUnitsConsumed());
        }
    @Override
    public boolean update(Customer entity) throws SQLException {
        final String sql = "UPDATE customers SET account_no=?,name = ?, address = ?, phone = ?, units_consumed = ? WHERE id = ?";
        return  CrudUtil.execute(sql,
                entity.getAccountNo(),
                entity.getName(),
                entity.getAddress(),
                entity.getPhone(),
                entity.getUnitsConsumed(),
                entity.getId()
        );
    }

    @Override
    public boolean delete(Integer id) throws SQLException {
        final String sql = "DELETE FROM customers WHERE id = ?";
        return CrudUtil.execute(sql, id);
    }

    @Override
    public List<Customer> findAll() throws SQLException {
        final String sql = "SELECT * FROM customers";
        ResultSet rs = null;
        List<Customer> list = new ArrayList<>();
        try {
            rs = CrudUtil.execute(sql);
            while (rs.next()) {
                list.add(mapCustomer(rs));
            }
            return list;
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        }
    }

    @Override
    public Optional<Customer> findByID(Integer id) throws SQLException {
        final String sql = "SELECT * FROM customers WHERE id = ?";
        ResultSet rs = null;
        try {
            rs = CrudUtil.execute(sql, id);
            if (rs.next()) {
                return Optional.of(mapCustomer(rs));
            }
            return Optional.empty();
        } finally {
            if (rs != null) try { rs.close(); } catch (SQLException ignore) {}
        }
    }

    private Customer mapCustomer(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setId(rs.getInt("id"));
        c.setAccountNo(rs.getString("account_no"));
        c.setName(rs.getString("name"));
        c.setAddress(rs.getString("address"));
        c.setPhone(rs.getString("phone"));
        c.setUnitsConsumed(rs.getInt("units_consumed"));
        return c;
    }
}

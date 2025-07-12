package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.CustomerDTO;
import com.icbt.billing.onlinebillingsystem.repo.DAOType;
import com.icbt.billing.onlinebillingsystem.repo.DaoFactory;
import com.icbt.billing.onlinebillingsystem.repo.custom.CustomerDAO;
import com.icbt.billing.onlinebillingsystem.service.custom.CustomerService;

import java.util.List;

/**
 * @author  : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
public class CustomerServiceImpl implements CustomerService {
    CustomerDAO customerDAO;
    public CustomerServiceImpl() {
        CustomerDAO customerDAO = (CustomerDAO) DaoFactory.getInstance().getDAO(DAOType.CUSTOMER);
    }

    @Override
    public boolean saveCustomer(CustomerDTO request) {
        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO request) {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) {
        return false;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return List.of();
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        return null;
    }
}

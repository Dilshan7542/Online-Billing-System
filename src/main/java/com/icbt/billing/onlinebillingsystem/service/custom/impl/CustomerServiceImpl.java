package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.CustomerDTO;
import com.icbt.billing.onlinebillingsystem.entity.Customer;
import com.icbt.billing.onlinebillingsystem.repo.DAOType;
import com.icbt.billing.onlinebillingsystem.repo.DaoFactory;
import com.icbt.billing.onlinebillingsystem.repo.custom.CustomerDAO;
import com.icbt.billing.onlinebillingsystem.repo.exception.SystemErrorException;
import com.icbt.billing.onlinebillingsystem.repo.exception.UserNotFoundException;
import com.icbt.billing.onlinebillingsystem.service.custom.CustomerService;
import com.icbt.billing.onlinebillingsystem.util.ResponseGenerator;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author  : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
public class CustomerServiceImpl implements CustomerService {
   private final CustomerDAO customerDAO;
    public CustomerServiceImpl() {
      customerDAO = (CustomerDAO) DaoFactory.getInstance().getDAO(DAOType.CUSTOMER);
    }

    @Override
    public String saveCustomer(CustomerDTO request) {
        try {
            if (customerDAO.save(this.dtoToEntity(request))) {
                return ResponseGenerator.generateSuccessResponse(null,"Customer has been saved successfully");
            }else{
                throw new SystemErrorException("Customer could not be saved");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new SystemErrorException("Customer could not be saved");
    }

    @Override
    public String updateCustomer(CustomerDTO request) {
        try {
             customerDAO.findByID(request.getId()).orElseThrow(UserNotFoundException::new);
            if (customerDAO.update(this.dtoToEntity(request))) {
                return ResponseGenerator.generateSuccessResponse(null,"Customer has been Update successfully");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new SystemErrorException("Customer could not be updated");
    }

    @Override
    public String deleteCustomer(int id) {
        try {
            customerDAO.findByID(id).orElseThrow(UserNotFoundException::new);
            if (customerDAO.delete(id)) {
                return ResponseGenerator.generateSuccessResponse(null,"Customer has been deleted successfully");
            }
        }catch (Exception e){
           e.printStackTrace();
        }
        throw new SystemErrorException("Transaction Failed");
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        try {
            return customerDAO.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public CustomerDTO searchCustomer(int id) {

        return null;
    }
    private CustomerDTO entityToDto(Customer customer) {
       return new CustomerDTO(
               customer.getId(),
                customer.getAccountNo(),
                customer.getName(),
                customer.getAddress(),
                customer.getPhone(),
                customer.getUnitsConsumed()
        );
    }
    private Customer dtoToEntity(CustomerDTO customerDTO) {
        return new Customer(
                customerDTO.getId(),
                customerDTO.getAccountNo(),
                customerDTO.getName(),
                customerDTO.getAddress(),
                customerDTO.getPhone(),
                customerDTO.getUnitsConsumed()
        );
    }
}

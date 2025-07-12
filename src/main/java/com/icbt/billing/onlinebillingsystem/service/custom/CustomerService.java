package com.icbt.billing.onlinebillingsystem.service.custom;

import com.icbt.billing.onlinebillingsystem.dto.CustomerDTO;
import com.icbt.billing.onlinebillingsystem.service.SuperService;

import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
public interface CustomerService extends SuperService {
    boolean saveCustomer(CustomerDTO request);

    boolean updateCustomer(CustomerDTO request);

    boolean deleteCustomer(String id);

    List<CustomerDTO> getAllCustomer();

    CustomerDTO searchCustomer(String id);
}

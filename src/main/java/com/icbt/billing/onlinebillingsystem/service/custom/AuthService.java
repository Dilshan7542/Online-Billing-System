package com.icbt.billing.onlinebillingsystem.service.custom;

import com.icbt.billing.onlinebillingsystem.dto.BillingDTO;
import com.icbt.billing.onlinebillingsystem.dto.CustomerDTO;
import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.service.SuperService;
import com.icbt.billing.onlinebillingsystem.util.ResponseEntity;

import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public interface AuthService extends SuperService {
    ResponseEntity<?> login(UserDTO request);
}

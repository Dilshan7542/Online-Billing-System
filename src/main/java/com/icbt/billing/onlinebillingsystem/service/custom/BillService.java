package com.icbt.billing.onlinebillingsystem.service.custom;

import com.icbt.billing.onlinebillingsystem.dto.BillingDTO;
import com.icbt.billing.onlinebillingsystem.service.SuperService;

import java.rmi.Remote;
import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public interface BillService extends SuperService {
    boolean saveBill(BillingDTO request);

    boolean updateBill(BillingDTO request);

    boolean deleteBill(String id);

    List<BillingDTO> getAllBill();

    BillingDTO searchBill(String id);
}

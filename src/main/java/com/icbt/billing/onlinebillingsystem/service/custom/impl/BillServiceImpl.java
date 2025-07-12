package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.BillingDTO;
import com.icbt.billing.onlinebillingsystem.service.custom.BillService;

import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/13/2025
 */
public class BillServiceImpl implements BillService {
    @Override
    public boolean saveBill(BillingDTO request) {
        return false;
    }

    @Override
    public boolean updateBill(BillingDTO request) {
        return false;
    }

    @Override
    public boolean deleteBill(String id) {
        return false;
    }

    @Override
    public List<BillingDTO> getAllBill() {
        return List.of();
    }

    @Override
    public BillingDTO searchBill(String id) {
        return null;
    }
}

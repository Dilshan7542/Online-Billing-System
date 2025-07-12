package com.icbt.billing.onlinebillingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDTO {
    private int billId;
    private int accountNo;
    private Date billDate;
    private int unitsConsumed;
    private double amount;
}

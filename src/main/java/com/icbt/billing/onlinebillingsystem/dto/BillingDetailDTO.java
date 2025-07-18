package com.icbt.billing.onlinebillingsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetailDTO {
    private int billItemId;
    private int billId;
    private int itemId;
    private int quantity;
    private double totalPrice;
}

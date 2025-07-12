package com.icbt.billing.onlinebillingsystem.entity;

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
public class Item implements SuperEntity{
    private int itemId;
    private String itemName;
    private double pricePerUnit;
}
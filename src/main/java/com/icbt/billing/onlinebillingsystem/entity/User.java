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
@AllArgsConstructor
@NoArgsConstructor
public class User implements SuperEntity {
    private int userId;
    private String username;
    private String password;
    private String deviceId;
    private String token;
    private Role role;
}

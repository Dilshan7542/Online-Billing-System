package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.DAOType;
import com.icbt.billing.onlinebillingsystem.repo.DaoFactory;
import com.icbt.billing.onlinebillingsystem.repo.custom.UserDAO;
import com.icbt.billing.onlinebillingsystem.repo.exception.SystemError;
import com.icbt.billing.onlinebillingsystem.service.custom.AuthService;

import java.sql.SQLException;

public class AuthServiceImpl implements AuthService {
   private final UserDAO userDAO;

    public AuthServiceImpl() {
        this.userDAO =(UserDAO) DaoFactory.getInstance().getDAO(DAOType.USER);
    }

    @Override
    public Object login(UserDTO request) {
        try {
            User user = userDAO.findUserByUsername(request.getUsername());
            if (!user.getPassword().equals(request.getPassword())) {
                return false;
            }
            return true;
        }catch (SQLException e) {
            e.printStackTrace();
           throw new SystemError("Login failed");
        }
    }
}

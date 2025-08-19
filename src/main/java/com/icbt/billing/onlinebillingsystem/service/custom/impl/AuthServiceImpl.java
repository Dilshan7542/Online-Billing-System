package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.DAOType;
import com.icbt.billing.onlinebillingsystem.repo.DaoFactory;
import com.icbt.billing.onlinebillingsystem.repo.custom.UserDAO;
import com.icbt.billing.onlinebillingsystem.repo.exception.SystemErrorException;
import com.icbt.billing.onlinebillingsystem.repo.exception.UserNotFoundException;
import com.icbt.billing.onlinebillingsystem.service.custom.AuthService;
import com.icbt.billing.onlinebillingsystem.util.ResponseEntity;

import java.sql.SQLException;

public class AuthServiceImpl implements AuthService {
    private final UserDAO userDAO;

    public AuthServiceImpl() {
        this.userDAO = (UserDAO) DaoFactory.getInstance().getDAO(DAOType.USER);
    }

    @Override
    public ResponseEntity<?> login(UserDTO request) {
        try {
            User user = userDAO.findUserByUsername(request.getUsername()).orElseThrow(UserNotFoundException::new);
            if (!user.getPassword().equals(request.getPassword())) {
                throw new UserNotFoundException();
            }
            return ResponseEntity.ok(user);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SystemErrorException("Login failed");
        }
    }
}

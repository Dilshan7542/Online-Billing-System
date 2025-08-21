package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.entity.User;
import com.icbt.billing.onlinebillingsystem.repo.DAOType;
import com.icbt.billing.onlinebillingsystem.repo.DaoFactory;
import com.icbt.billing.onlinebillingsystem.repo.custom.UserDAO;
import com.icbt.billing.onlinebillingsystem.repo.exception.SystemErrorException;
import com.icbt.billing.onlinebillingsystem.repo.exception.UserNotFoundException;
import com.icbt.billing.onlinebillingsystem.service.custom.AuthService;
import com.icbt.billing.onlinebillingsystem.util.JwtUtil;
import com.icbt.billing.onlinebillingsystem.util.ResponseEntity;
import com.icbt.billing.onlinebillingsystem.util.ResponseGenerator;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class AuthServiceImpl implements AuthService {
    private final UserDAO userDAO;

    public AuthServiceImpl() {
        this.userDAO = (UserDAO) DaoFactory.getInstance().getDAO(DAOType.USER);
    }

    @Override
    public String login(UserDTO request) {
        try {
            User user = userDAO.findUserByUsername(request.getUsername()).orElseThrow(UserNotFoundException::new);
            if (!user.getPassword().equals(request.getPassword())) {
                throw new UserNotFoundException();
            }
            System.out.println("User Is Valid");
            Map<String, String> claims = new HashMap<>();
            claims.put("userId", String.valueOf(user.getUserId()));
            claims.put("role", user.getRole().toString());
            String token = JwtUtil.generateToken(user.getUsername(), claims);
            System.out.println(token);
            user.setToken(token);
            if (userDAO.update(user)) {
            return ResponseGenerator.generateSuccessResponse(user,"Login Successful");
            }else{
                throw new SystemErrorException("System Failed!!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemErrorException("Login failed");
        }
    }
}

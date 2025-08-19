package com.icbt.billing.onlinebillingsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.service.ServiceFactory;
import com.icbt.billing.onlinebillingsystem.service.ServiceType;
import com.icbt.billing.onlinebillingsystem.service.custom.AuthService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/10/2025
 */
@WebServlet(urlPatterns = "/api/v1/auth")
public class AuthController extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    private final AuthService authService ;

    public AuthController() {
        authService=(AuthService) ServiceFactory.getInstance().getService(ServiceType.AUTH);
        if(authService==null){
            System.out.println("Auth Service not found");
        }else {
            System.out.println("Auth Service found");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Welcome to the Test Page!");
        req.getRequestDispatcher("/WEB-INF/views/post-login/customer.jsp").forward(req, resp);

    }

    @Override
    protected void doPatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPatch(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDTO userDTO = mapper.readValue(req.getInputStream(), UserDTO.class);
        System.out.println(userDTO);
        this.authService.login(userDTO);
        req.setAttribute("message", "Welcome to the Test Page!");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}

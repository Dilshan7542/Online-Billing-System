package com.icbt.billing.onlinebillingsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
@WebServlet(urlPatterns = "/api/v1/user")
public class UserController extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("message", "Welcome to the Test Page!");
        req.getRequestDispatcher("/WEB-INF/views/post-login/user.jsp").forward(req, resp);

    }
}

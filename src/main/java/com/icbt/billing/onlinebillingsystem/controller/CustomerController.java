package com.icbt.billing.onlinebillingsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icbt.billing.onlinebillingsystem.dto.CustomerDTO;
import com.icbt.billing.onlinebillingsystem.dto.UserDTO;
import com.icbt.billing.onlinebillingsystem.service.ServiceFactory;
import com.icbt.billing.onlinebillingsystem.service.ServiceType;
import com.icbt.billing.onlinebillingsystem.service.custom.AuthService;
import com.icbt.billing.onlinebillingsystem.service.custom.CustomerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/10/2025
 */
@WebServlet(urlPatterns = "/api/v1/customer")
public class CustomerController extends HttpServlet {
    ObjectMapper mapper = new ObjectMapper();
private final CustomerService customerService ;
    public CustomerController() {
        customerService=(CustomerService) ServiceFactory.getInstance().getService(ServiceType.CUSTOMER);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CustomerDTO> list = customerService.getAllCustomer();
        req.setAttribute("customerList", list);
        req.getRequestDispatcher("/WEB-INF/views/post-login/customer.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        resp.setContentType("application/json");
        resp.getWriter().write(this.customerService.saveCustomer(customerDTO));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CustomerDTO customerDTO = mapper.readValue(req.getInputStream(), CustomerDTO.class);
        resp.setContentType("application/json");
        resp.getWriter().write(this.customerService.updateCustomer(customerDTO));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        int customerId = Integer.parseInt(req.getParameter("customerId"));
        resp.getWriter().write(this.customerService.deleteCustomer(customerId));
    }
}

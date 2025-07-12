package com.icbt.billing.onlinebillingsystem.service;


import com.icbt.billing.onlinebillingsystem.service.custom.impl.CustomerServiceImpl;
import com.icbt.billing.onlinebillingsystem.service.custom.impl.ItemServiceImpl;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return serviceFactory==null ? serviceFactory=new ServiceFactory():serviceFactory;
    }
    public SuperService getService(ServiceType serviceType){
        return switch (serviceType) {
            case CUSTOMER -> new CustomerServiceImpl();
            case BILLING -> new CustomerServiceImpl();
            case ITEM -> new ItemServiceImpl();
            case USER -> new CustomerServiceImpl();
            default -> null;
        };
    }
}

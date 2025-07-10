package com.icbt.billing.onlinebillingsystem.service;



public class ServiceFactory {
    private static ServiceFactory serviceFactory;
    private ServiceFactory(){}
    public static ServiceFactory getInstance(){
        return serviceFactory==null ? serviceFactory=new ServiceFactory():serviceFactory;
    }
    public SuperService getService(ServiceType serviceType){
        return switch (serviceType) {
            case CUSTOMER -> new CustomerServiceImpl();
            default -> null;
        };
    }
}

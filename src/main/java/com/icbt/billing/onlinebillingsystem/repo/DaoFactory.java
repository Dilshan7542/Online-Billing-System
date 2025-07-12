package com.icbt.billing.onlinebillingsystem.repo;

import com.icbt.billing.onlinebillingsystem.repo.custom.impl.CustomerDAOImpl;
import com.icbt.billing.onlinebillingsystem.repo.custom.impl.ItemDAOImpl;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return daoFactory ==null ? daoFactory =new DaoFactory(): daoFactory;
    }
    public SuperDAO getDAO(DAOType daoType){
        return switch (daoType) {
            case ITEM -> new ItemDAOImpl();
            case CUSTOMER -> new CustomerDAOImpl();
            default -> null;
        };
    }

}


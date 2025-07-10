package com.icbt.billing.onlinebillingsystem.repo;

import lk.ijse.hardware.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){}
    public static DaoFactory getInstance(){
        return daoFactory ==null ? daoFactory =new DaoFactory(): daoFactory;
    }
    public SuperDAO getDAO(DAOType daoType){
        switch (daoType) {
            case CATEGORY:
                return new CategoryDAOImpl();
            default:
                return null;

        }
    }

}


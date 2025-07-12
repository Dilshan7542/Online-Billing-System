package com.icbt.billing.onlinebillingsystem.repo.custom;


import com.icbt.billing.onlinebillingsystem.entity.Item;
import com.icbt.billing.onlinebillingsystem.repo.CrudDAO;

import java.sql.SQLException;

public interface ItemDAO extends CrudDAO<Item,Integer> {
    boolean updateQtyAndRecodeGrn(String itemCode,int qty) throws SQLException;
    boolean removeQty(String itemCode,int qty) throws SQLException;
}

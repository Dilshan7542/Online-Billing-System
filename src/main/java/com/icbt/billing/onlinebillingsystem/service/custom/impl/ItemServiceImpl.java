package com.icbt.billing.onlinebillingsystem.service.custom.impl;

import com.icbt.billing.onlinebillingsystem.dto.ItemDTO;
import com.icbt.billing.onlinebillingsystem.service.custom.ItemService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : Dilshan Maduranga
 * @project : online-billing-system
 * @Day : 7/11/2025
 */
public class ItemServiceImpl implements ItemService {
    @Override
    public boolean updateQtyAndRecodeGrn(String itemCode, int qty) throws SQLException {
        return false;
    }

    @Override
    public boolean removeQty(String itemCode, int qty) throws SQLException {
        return false;
    }

    @Override
    public boolean saveItem(ItemDTO itemDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean updateItem(ItemDTO itemDTO) throws SQLException {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException {
        return false;
    }

    @Override
    public List<ItemDTO> getAllItem() throws SQLException {
        return List.of();
    }

    @Override
    public ItemDTO searchItem(String id) throws SQLException {
        return null;
    }

    @Override
    public String generateItemID() throws SQLException {
        return "";
    }
}

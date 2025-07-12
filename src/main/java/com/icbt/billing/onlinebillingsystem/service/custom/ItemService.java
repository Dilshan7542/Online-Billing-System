package com.icbt.billing.onlinebillingsystem.service.custom;



import com.icbt.billing.onlinebillingsystem.dto.ItemDTO;
import com.icbt.billing.onlinebillingsystem.service.SuperService;

import java.sql.SQLException;
import java.util.List;

public interface ItemService extends SuperService {
    boolean removeQty(String itemCode,int qty) throws SQLException;
    boolean saveItem(ItemDTO itemDTO)throws SQLException;
    boolean updateItem(ItemDTO itemDTO)throws SQLException;
    boolean deleteItem(String id)throws SQLException;
    List<ItemDTO> getAllItem()throws SQLException;
    ItemDTO searchItem(String id)throws SQLException;
}

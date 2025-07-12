package com.icbt.billing.onlinebillingsystem.repo.custom.impl;



import com.icbt.billing.onlinebillingsystem.entity.Item;
import com.icbt.billing.onlinebillingsystem.repo.custom.ItemDAO;
import com.icbt.billing.onlinebillingsystem.repo.util.CreateNewID;
import com.icbt.billing.onlinebillingsystem.repo.util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public boolean save(Item entity) throws SQLException {
        return CrudUtil.execute("INSERT INTO item VALUES(?,?,?,?,?,?,?,?,?,?)",
                entity.getItemId(),
                entity.getItemName(),
                entity.getPricePerUnit()
               );
    }

    @Override
    public boolean update(Item entity) throws SQLException {
        return CrudUtil.execute("UPDATE item SET categoryId=?,description=?,remind=?,utilPrice=?,status=? WHERE itemCode=?",
                entity.getItemId(),
                entity.getItemName(),
                entity.getPricePerUnit()

        );
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }


    @Override
    public List<Item> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM item");
        ArrayList<Item> list = new ArrayList<>();
        while (rst.next()) {
            list.add(new Item(
                    rst.getInt("itemCode"),
                    rst.getString("description"),
                    rst.getDouble("description")
            ));
        }
        return list;
    }

    @Override
    public Optional<Item> search(Integer integer) throws SQLException {
        return Optional.empty();
    }


    @Override
    public String generateID() throws SQLException {
        ResultSet resultSet = CrudUtil.execute("SELECT itemCode FROM item ORDER BY itemCode DESC LIMIT 1");
        if (resultSet.next())
            return CreateNewID.generateID("PR-", resultSet.getString(1));

        return CreateNewID.generateID("PR-", null);
    }

    @Override
    public boolean updateQtyAndRecodeGrn(String itemCode, int qty) throws SQLException {
        return CrudUtil.execute("UPDATE item SET qty=qty+?,recode=recode+? WHERE itemCode=?", qty, qty, itemCode);
    }

    @Override
    public boolean removeQty(String itemCode, int qty) throws SQLException {
        return CrudUtil.execute("UPDATE item SET qty=qty-? WHERE itemCode=?", qty, itemCode);
    }
}

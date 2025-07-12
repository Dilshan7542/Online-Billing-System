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
        return CrudUtil.execute("INSERT INTO items VALUES(?,?,?,?,?,?,?,?,?,?)",
                entity.getItemId(),
                entity.getItemName(),
                entity.getPricePerUnit()
               );
    }

    @Override
    public boolean update(Item entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(Integer integer) throws SQLException {
        return false;
    }


    @Override
    public List<Item> getAll() throws SQLException {
        ResultSet rst = CrudUtil.execute("SELECT * FROM items");
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
    public Optional<Item> findByID(Integer integer) throws SQLException {
        return Optional.empty();
    }




}

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
        return CrudUtil.execute(
                "UPDATE items SET item_name = ?, price_per_unit = ?,qty=? WHERE item_id = ?",
                entity.getItemName(),
                entity.getPricePerUnit(),
                entity.getQty(),
                entity.getItemId());
    }

    @Override
    public boolean delete(Integer itemId) throws SQLException {
        return CrudUtil.execute("DELETE FROM items WHERE item_id = ?", itemId);
    }


    @Override
    public List<Item> findAll() throws SQLException {
        ResultSet rs = CrudUtil.execute("SELECT * FROM items");
        ArrayList<Item> list = new ArrayList<>();
        while (rs.next()) {
            Item item = new Item();
            item.setItemId(rs.getInt("item_id"));
            item.setItemName(rs.getString("item_name"));
            item.setQty(rs.getInt("qty"));
            item.setPricePerUnit(rs.getDouble("price_per_unit"));
            list.add(item);
        }
        return list;
    }

    @Override
    public Optional<Item> findByID(Integer id) throws SQLException {
        final String sql = "SELECT * FROM items WHERE item_id = ?";

        ResultSet rs = null;
        try {
            rs = CrudUtil.execute(sql, id); // returns ResultSet for SELECT
            if (rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getInt("item_id"));
                item.setItemName(rs.getString("item_name"));
                item.setQty(rs.getInt("qty"));
                item.setPricePerUnit(rs.getDouble("price_per_unit"));
                return Optional.of(item);
            }
            return Optional.empty();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ignore) {
                }
            }
        }
    }


}

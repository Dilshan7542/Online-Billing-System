package com.icbt.billing.onlinebillingsystem.repo.util;



import com.icbt.billing.onlinebillingsystem.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CrudUtil {
    public static <T> T execute(String sql,Object... arg) throws SQLException {
        final PreparedStatement st = DBConnection.getInstance().getConnection().prepareStatement(sql);
        for (int i = 0; i < arg.length; i++) {
                st.setObject(i+1,arg[i]);
        }
        if(sql.startsWith("SELECT") | sql.startsWith("select") | sql.startsWith("Select")){
            return (T)st.executeQuery();
        }
        return (T)(Boolean)(st.executeUpdate()>1);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.doctor.idgenerator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lk.ijse.doctor.db.ConnectionFactory;

/**
 *
 * @author sameera
 */
public class IdController {

    private static Connection connection;

    public IdController() {

    }

    public static String getLastId(String tableName, String columnName) throws ClassNotFoundException, SQLException {
        String query = "select " + columnName + " from " + tableName + " order by 1 desc limit 1";

        connection = ConnectionFactory.getInstance().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst = stm.executeQuery(query);
        if (rst.next()) {
            return rst.getString(1);
        }
        return null;
    }

}

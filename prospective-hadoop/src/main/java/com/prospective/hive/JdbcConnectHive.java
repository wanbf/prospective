package com.prospective.hive;

import java.sql.*;
/**
 * @author wanbf
 * @date 2018/8/29 10:45
 */
public class JdbcConnectHive {

    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    public static void main(String[] args) throws SQLException, InterruptedException {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        Connection con = DriverManager.getConnection("jdbc:hive2://node2:10000/default", "root", "467958");


        String selectSql = "select * from tbl";
        PreparedStatement state = null;
        state = con.prepareStatement(selectSql);
        ResultSet resultSet = state.executeQuery();
        while (resultSet != null && resultSet.next()) {
            System.out.println(resultSet.getInt(1) + "  " + resultSet.getString(2));
        }
    }
}

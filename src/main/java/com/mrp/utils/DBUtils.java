package com.mrp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	private static ResultSet rs = null;
	private static Connection con = null;
	private static Statement stmt = null;

	public static void setConnection() {
		String DBAdress, DBuserName, DBpassword;
		if (GetConfigProperties.getPropValue("Env").equalsIgnoreCase("qa")) {
			DBAdress = GetConfigProperties.getPropValue("DBQAaddress");
			DBuserName = GetConfigProperties.getPropValue("DBQAuserName");
			DBpassword = GetConfigProperties.getPropValue("DBQApassword");
		} else {
			DBAdress = GetConfigProperties.getPropValue("DBProdaddress");
			DBuserName = GetConfigProperties.getPropValue("DBProduserName");
			DBpassword = GetConfigProperties.getPropValue("DBProdpassword");
		}

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://" + DBAdress + "/?useSSL=false", DBuserName, DBpassword);

			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static ResultSet getSqlResults(String sqlQuery) {
		setConnection();
		// ReportManagerRunner.getTest().log(Status.INFO, "Query :" +sqlQuery);
		try {
			rs = stmt.executeQuery(sqlQuery);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}
}

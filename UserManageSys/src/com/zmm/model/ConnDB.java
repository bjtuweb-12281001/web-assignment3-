package com.zmm.model;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnDB {
	private Connection ct = null;
	

	public Connection getConn()
	{
		try{
			//加载驱动
		    Class.forName("com.mysql.jdbc.Driver");
		    
		    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		    //链接的数据库地址
		    String DbConn = "jdbc:mysql://localhost:3306/spdb1";
		    //数据库密码
		    String DbPass="123456";
		    //得到链接
		    ct = java.sql.DriverManager.getConnection(DbConn,"root",DbPass);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ct;
	}
	
}

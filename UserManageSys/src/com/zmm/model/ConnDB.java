package com.zmm.model;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnDB {
	private Connection ct = null;
	

	public Connection getConn()
	{
		try{
			//��������
		    Class.forName("com.mysql.jdbc.Driver");
		    
		    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		    //���ӵ����ݿ��ַ
		    String DbConn = "jdbc:mysql://localhost:3306/spdb1";
		    //���ݿ�����
		    String DbPass="123456";
		    //�õ�����
		    ct = java.sql.DriverManager.getConnection(DbConn,"root",DbPass);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return ct;
	}
	
}

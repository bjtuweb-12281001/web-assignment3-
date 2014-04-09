package com.zmm.model;

import java.sql.*;
import java.util.*;

public class UserBeanDeal {
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection con = null;
	private PreparedStatement PS = null;
	
	
	public void close()
	{
		if(rs != null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
		if(stmt != null)
		{
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt =null;
		}
		if(con != null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con = null;
		}
	}
	
	public void closeIn()
	{
		if(PS!=null)
		{
			try {
				PS.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public boolean checkUser(String username,String passwd)
	{
		boolean b = false;
		try{
			con = new ConnDB().getConn();
			//创建Statement
		    stmt = con.createStatement();
		    //查询
		    rs = stmt.executeQuery("select passwd from users where userName='"+username+"'");
		    //看结果
		    if(rs.next() && rs.getString(1).equals(passwd))
		    {
		    	b= true;
		    }
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		return b;
	}
	public boolean addUser(String username,String passwd,String email)
	{
		System.out.print("h");
		boolean b=true;
		try{
			con = new ConnDB().getConn();
			//创建Statement
		    PS = con.prepareStatement("insert into users values(?,?,?,?,?)");
		    System.out.print("zham");
		    PS.setInt(1, 1);
		    PS.setString(2, username);
		    PS.setString(3, passwd);
		    PS.setString(4, email);
		    PS.setInt(5, 4);
		    PS.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			this.closeIn();
		}
		return b;
	}
	
}

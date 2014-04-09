package com.zmm.model;

public class Tools {
	public static String getNewString(String input)
	{
		String result="";
		try{
			result=new String(input.getBytes("iso-8859-1"),"gb2312");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
}

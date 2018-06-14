package com.sds.frame;

public class SQL {
	public static String insertCustomer =
			"INSERT INTO CUSTOMER VALUES (?,?,?)";
	public static String insertItem =
			"INSERT INTO useritem VALUES (?,?,?)";
	
	public static String getCustomer =
			"select * from CUSTOMER where id =?";
	
	public static String getCustomerItem =
			"select * from CUSTOMERITEM where id =?";
	
	public static String getAll =
			"select c.id, c.pwd, c.name, ci.name, ci.price from customer c, " +"customeritem ci "+ 
	"where c.id=ci.id";

}

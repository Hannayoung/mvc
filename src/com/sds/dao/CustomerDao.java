package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerDao extends Dao<String, CustomerVO> {

	@Override
	public void insert(CustomerVO v, Connection con) throws Exception {
		// COnnection을 통해 preparedStatement 전송
		//SQL 작성해서 DB전송
		//Resource Close
		PreparedStatement pstmt = null;
		try {
		pstmt = con.prepareStatement(SQL.insertCustomer);
		pstmt.setString(1,  v.getId());
		pstmt.setString(2,  v.getPwd());
		pstmt.setString(3,  v.getName());
		pstmt.executeUpdate();
		close(pstmt);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
		}
	}

	@Override
	public void delete(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CustomerVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerVO select(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		CustomerVO customerVo = null;
		String id = null;
		String name = null;
		String pwd = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(t);
		try {
			customerVo = new CustomerVO();
		pstmt = con.prepareStatement(SQL.getCustomer);
		pstmt.setString(1, t);

        rs = pstmt.executeQuery();
        
        while(rs.next()){   
        	customerVo.setId(t);
        	customerVo.setName(rs.getString("name"));
        	customerVo.setPwd(rs.getString("pwd"));
        }
      
        
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return customerVo;
		
	}

	@Override
	public ArrayList<CustomerVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		String price = null;
		String name = null;
		ArrayList<CustomerVO> customers = null;
		
		try {
			pstmt = con.prepareStatement(SQL.getAll);
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next())
			{
				customers = new ArrayList<CustomerVO>();
				CustomerVO customer = null;
				customer = new CustomerVO(rs.getString("ID"), 
						rs.getString("PWD"), rs.getString("NAME"));
				customer.setItem(new ItemVO(rs.getString("ID"), 
						rs.getString("name"), rs.getDouble("price")));
				customers.add(customer);
			}
		}catch(Exception e)
		{	
		
			throw e;
		}finally {
			close(pstmt);
			close(rs);
		}
		
		
		//new ArrayList<CustomerVO>()
		//cust = select(t, con);
		//ary.add(1,cust);
		return customers;
	}

}

package com.sds.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class ItemDao extends Dao<String, ItemVO> {

	private StringBuffer sql = null;

	@Override
	public void insert(ItemVO v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
		pstmt = con.prepareStatement(SQL.insertItem);
		pstmt.setString(1,  v.getId());
		pstmt.setString(2,  v.getName());
		pstmt.setDouble(3,  v.getPrice());
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
	public void update(ItemVO v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemVO select(String t, Connection con) throws Exception {
		// TODO Auto-generated method stub
		ItemVO itemvo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println(t);
		try {
			itemvo = new ItemVO();
			pstmt = con.prepareStatement(SQL.getCustomerItem);
			pstmt.setString(1, t);

			rs = pstmt.executeQuery();
        
			while(rs.next()){   
        	//System.out.println(rs.getString("name"));
				itemvo.setId(t);
				itemvo.setName(rs.getString("name"));
				itemvo.setPrice(rs.getDouble("price"));
			}
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return itemvo;
	}

	@Override
	public ArrayList<ItemVO> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

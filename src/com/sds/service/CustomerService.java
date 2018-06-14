package com.sds.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sds.dao.CustomerDao;
import com.sds.dao.ItemDao;
import com.sds.frame.Dao;
import com.sds.frame.SQL;
import com.sds.frame.Service;
import com.sds.vo.CustomerVO;
import com.sds.vo.ItemVO;

public class CustomerService extends Service<String, CustomerVO> {

	Dao<String, CustomerVO> cDao;
	Dao<String, ItemVO> iDao;
	
	public CustomerService() {
		this.cDao = new CustomerDao();
		this.iDao = new ItemDao();
	}
	
	
	@Override
	public void register(CustomerVO v) throws Exception {
		ItemVO item = new ItemVO(v.getId()," 칼",1000);
		Connection con = getConn();
		try {
			cDao.insert(v, con);
			iDao.insert(item, con);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
	}

	@Override
	public void remove(String t) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modify(CustomerVO v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CustomerVO get(String t) throws Exception {
		// TODO Auto-generated method stub
		

		CustomerVO customerVo = null;
		Connection con = getConn();
		
		
		try {
			
			customerVo=cDao.select(t, con);
			customerVo.setItem(iDao.select(t, con));
			con.commit();
			
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
			
		}
		return customerVo;
		
	}

	@Override
	public ArrayList<CustomerVO> get() throws Exception {
		ArrayList<CustomerVO> customers = null;
		Connection con = getConn();
		try {
			customers=cDao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
			
		}
		return customers;
	}

	
	
}

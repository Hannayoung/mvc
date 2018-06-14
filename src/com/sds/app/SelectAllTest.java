package com.sds.app;

import java.util.ArrayList;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class SelectAllTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service<String, CustomerVO> service = new CustomerService();
		
		ArrayList<CustomerVO> list =null;
		
		try {
			list = service.get();
			for(CustomerVO vo : list)
			{
				System.out.println(vo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("조회 실패라능");
			e.printStackTrace();
		}
		
	}

}

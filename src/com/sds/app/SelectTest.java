package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class SelectTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Service<String, CustomerVO> service = new CustomerService();
		
		CustomerVO getcustomer= null;
		
		try {
			getcustomer = service.get("id02");
			System.out.println(getcustomer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("조회 실패라능");
			e.printStackTrace();
		}
		
	}

}

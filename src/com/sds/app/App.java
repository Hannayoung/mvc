package com.sds.app;

import com.sds.frame.Service;
import com.sds.service.CustomerService;
import com.sds.vo.CustomerVO;

public class App {

	public static void main(String[] args) {
		Service<String, CustomerVO> service = new CustomerService();
		CustomerVO customer = new CustomerVO("id02","pwd02","김씨");
		try {
			service.register(customer);
			System.out.println("성공.");
		} catch (Exception e) {
			System.out.println("실패.");
			e.printStackTrace();
		}
	}

}

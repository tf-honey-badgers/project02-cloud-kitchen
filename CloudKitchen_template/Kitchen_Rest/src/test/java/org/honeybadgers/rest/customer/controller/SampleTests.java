package org.honeybadgers.rest.customer.controller;

import org.badgers.rest.customer.order.service.CustOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"})

public class SampleTests {

	@Setter(onMethod_ = {@Autowired})
	private CustOrderService service;
	
	@Test
	public void test() {
		try {
			log.info("----------------------------------------");
			service.excuteOrder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
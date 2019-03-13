package org.badgers.rest.customer.member.controller;

import javax.servlet.http.HttpSession;

import org.badgers.rest.customer.member.service.CustomerService;
import org.badgers.rest.model.CustomerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/customer")
@Log4j
public class CustomerController {

	@Setter(onMethod_ = { @Autowired })
	private CustomerService service;

	//회원가입
	@PostMapping(value = "/new", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> create(@RequestBody CustomerVO vo) throws Exception {
		boolean result = service.register(vo);
		log.info("insert result : " + result);

		return result ? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//로긴
	@GetMapping(value = "/login/{idx}", produces = { MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<CustomerVO> login(HttpSession session) {
		CustomerVO vo = (CustomerVO) session.getAttribute("login");
		String id = "zzz";
		String pw = "1243";
		try {
			id = vo.getId();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return new ResponseEntity<>(service.selectById(id), HttpStatus.OK);
	}

	
	// 수정

	@PutMapping("/modify/{id}")
	public int modify(@RequestBody CustomerVO vo) {

		int returnVal = 0;

		try {
			returnVal = service.modify(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnVal;
	}

	// 삭제
//	@RequestMapping(method = { RequestMethod.PUT,
//			RequestMethod.PATCH }, value = "/modify/{status}", consumes = "application/json", produces = {
//					MediaType.TEXT_PLAIN_VALUE })
//	public ResponseEntity<String> delete(@RequestBody CustomerVo vo, @PathVariable("status") String status)
//			throws Exception {
//		log.info(vo);
//		
//		vo.setStatus(vo.getStatus());
//
//		return service.delete(vo) ? new ResponseEntity<>("success", HttpStatus.OK)
//				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
	@PutMapping("/delete/{id}")
	public int delete(@RequestBody CustomerVO vo) {

		int returnValue = 0;

		try {
			returnValue = service.delete(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}
	
	
	
	

}
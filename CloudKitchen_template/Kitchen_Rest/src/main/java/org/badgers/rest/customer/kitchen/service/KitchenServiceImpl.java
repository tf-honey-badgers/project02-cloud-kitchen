package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.customer.kitchen.persistence.KitchenMapper;
import org.badgers.rest.model.BizVO;
import org.badgers.rest.model.KitchenBranchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class KitchenServiceImpl implements KitchenService {
	
	@Setter(onMethod_=@Autowired)
	private KitchenMapper mapper;
	
	@Override
	public List<KitchenBranchVO> kitchenbranchList(){
		System.out.println("키친 서비스");
		return mapper.kitchenbranchList();
	}
	
	@Override
	public List<BizVO> bizlist(){
		System.out.println("키친 서비스");
		return mapper.bizList();
	}
	
	@Override
	public List<BizVO> bizInfo(int bizIdx){
		System.out.println("bizInfo : 서비스");
		return mapper.bizInfo(bizIdx);
	}

	@Override
	public List<Object> getCategorization() {
		return mapper.getCategorization();
	}
}

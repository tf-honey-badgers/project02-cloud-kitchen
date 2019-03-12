package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.customer.kitchen.persistence.KitchenMapper;
import org.badgers.rest.model.BizVo;
import org.badgers.rest.model.KitchenBranchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;

@Service
public class KitchenServiceImpl implements KitchenService {
	
	@Setter(onMethod_=@Autowired)
	private KitchenMapper mapper;
	
	@Override
	public List<KitchenBranchVo> kitchenbranchList(){
		System.out.println("키친 서비스");
		return mapper.kitchenbranchList();
	}
	
	@Override
	public List<BizVo> bizlist(){
		System.out.println("키친 서비스");
		return mapper.bizList();
	}
	
	@Override
	public List<BizVo> bizInfo(){
		System.out.println("bizInfo : 서비스");
		return mapper.bizInfo();
	}
}

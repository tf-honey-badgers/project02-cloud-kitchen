package org.badgers.rest.customer.kitchen.service;

import java.util.List;

import org.badgers.rest.customer.kitchen.persistence.KitchenMapper;
import org.badgers.rest.model.BizVO;
import org.badgers.rest.model.KitchenBranchVO;
import org.badgers.rest.model.KitchenSelectCatVOExtend;
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
	public List<BizVO> bizInfo(String bizId){
		System.out.println("bizInfo : 서비스");
		return mapper.bizInfo(bizId);
	}

	@Override
	public List<Object> getCategorization() {
		return mapper.getCategorization();
	}

	@Override
	public List<KitchenSelectCatVOExtend> getCatKitchen(String comName) {
		return mapper.getCatKitchen(comName);
	}
}

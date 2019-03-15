package org.badgers.rest.business.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.badgers.rest.business.menu.persistence.MenuMapper;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Setter(onMethod_=@Autowired)
	private MenuMapper mapper;

	@Override
	public int addMenuCat(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx,
			List<MenuOptionClVOExtend> menuOptClVoEx,List<MenuOptionVOExtend> menuOptVoEx) {
		
		mapper.addMenuCat(menuCatVoEx);
		
		menuVoEx.setMenuCatCode(menuCatVoEx.getMcNo());
		mapper.addMenu(menuVoEx);
		
		List<Integer> optClIdx = new ArrayList<Integer>();
		
		for(int i=0;i<menuOptClVoEx.size();i++) {
			MenuOptionClVOExtend menuOptClVoEx1 = new MenuOptionClVOExtend();
			menuOptClVoEx1.setMocMenuCode(menuVoEx.getMCode());
			menuOptClVoEx1.setMocName(menuOptClVoEx.get(i).getMocName());
			menuOptClVoEx1.setMocMenuOptType(menuOptClVoEx.get(i).getMocMenuOptType());
			mapper.addMenuOptionCl(menuOptClVoEx1);
			optClIdx.add(menuOptClVoEx1.getMocNo());
		}
		
		for(int i=0;i<optClIdx.size();i++) {
			for(int y=0;y<menuOptVoEx.size();y++) {
				MenuOptionVOExtend menuOptVoEx1 = new MenuOptionVOExtend();
				menuOptVoEx1.setMoName(menuOptVoEx.get(y).getMoName());
				menuOptVoEx1.setMoAddPrice(menuOptVoEx.get(y).getMoAddPrice());
				menuOptVoEx1.setMoOptClNo(optClIdx.get(i));
				mapper.addMenuOption(menuOptVoEx1);
			}
		}
		
		return 0;
	}

}

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
			MenuOptionClVOExtend menuOptClVoEx,MenuOptionVOExtend menuOptVoEx) {
		
/*		System.out.println(menuCatVoEx);
		System.out.println();
		System.out.println(menuVoEx);
		System.out.println();
		System.out.println(menuOptClVoEx);*/
		int result = 0;
		mapper.addMenuCat(menuCatVoEx);
		result++;
		
		menuVoEx.setMenuCatCode(menuCatVoEx.getMcNo());
		mapper.addMenu(menuVoEx);
		result++;
		
		for(int i=0;i<menuVoEx.getMenuOptCl().size();i++) {
			menuVoEx.getMenuOptCl().get(i).setMocMenuCode(menuVoEx.getMCode());
			mapper.addMenuOptionCl(menuVoEx.getMenuOptCl().get(i));
			result++;
			
			for(int y=0;y<menuOptClVoEx.getMenuOptEx().size();y++) {
				menuOptClVoEx.getMenuOptEx().get(y).setMoOptClNo(menuVoEx.getMenuOptCl().get(i).getMocNo());
				mapper.addMenuOption(menuOptClVoEx.getMenuOptEx().get(y));
				result++;
			}
		}
		
		return result;
	}

	@Override
	public int deleteMenu(int menuIdx) {
		return mapper.deleteMenu(menuIdx);
	}

	@Override
	public int deleteMenuOpt(int menuOptIdx) {
		return mapper.deleteMenuOpt(menuOptIdx);
	}

	@Override
	public int addOnlyMenu(MenuCatVOExtend menuCatVoEx, MenuVOExtend menuVoEx) {
		int result = 0;
		mapper.addMenuCat(menuCatVoEx);
		result++;
		
		menuVoEx.setMenuCatCode(menuCatVoEx.getMcNo());
		mapper.addMenu(menuVoEx);
		result++;
		return result;
	}

	@Override
	public int addOnlyOpt(int menuIdx, MenuVOExtend menuVoEx, MenuOptionClVOExtend menuOptClVoEx) {
		int result = 0;
		result++;
		
		for(int i=0;i<menuVoEx.getMenuOptCl().size();i++) {
			menuVoEx.getMenuOptCl().get(i).setMocMenuCode(menuIdx);
			mapper.addMenuOptionCl(menuVoEx.getMenuOptCl().get(i));
			result++;
			
			for(int y=0;y<menuOptClVoEx.getMenuOptEx().size();y++) {
				menuOptClVoEx.getMenuOptEx().get(y).setMoOptClNo(menuVoEx.getMenuOptCl().get(i).getMocNo());
				mapper.addMenuOption(menuOptClVoEx.getMenuOptEx().get(y));
				result++;
			}
		}
		return result;
	}

	@Override
	public int updateMenuInfo(MenuVOExtend menuVoEx) {
		return mapper.updateMenuInfo(menuVoEx);
	}

	@Override
	public int updateMenuOptInfo(MenuOptionVOExtend menuOptVoEx) {
		return mapper.updateMenuOptInfo(menuOptVoEx);
	}

	@Override
	public int updateMenu(List<?> updateMenuInfo) {
		return 0;
	}

}

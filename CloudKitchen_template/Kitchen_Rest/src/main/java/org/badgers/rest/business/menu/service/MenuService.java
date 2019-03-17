package org.badgers.rest.business.menu.service;

import java.util.List;

import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface MenuService {
	public int addMenuCat(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx,
			MenuOptionClVOExtend menuOptClVoEx,MenuOptionVOExtend menuOptVoEx);
	public int deleteMenu(int menuIdx);
	public int deleteMenuOpt(int menuOptIdx);
	public int addOnlyMenu(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx);
	public int addOnlyOpt(int menuIdx, MenuVOExtend menuVoEx,MenuOptionClVOExtend menuOptClVoEx);
	public int updateMenuInfo(MenuVOExtend menuVoEx);
	public int updateMenuOptInfo(MenuOptionVOExtend menuOptVoEx);
}

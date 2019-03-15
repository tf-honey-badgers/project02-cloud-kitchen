package org.badgers.rest.business.menu.service;

import java.util.List;

import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface MenuService {
	public int addMenuCat(MenuCatVOExtend menuCatVoEx,MenuVOExtend menuVoEx,
			List<MenuOptionClVOExtend> menuOptClVoEx,List<MenuOptionVOExtend> menuOptVoEx);
/*	public int addMenu(MenuVOExtend menuVoEx);
	public int addMenuOptionCl(MenuOptionClVOExtend menuOptClVoEx);
	public int addMenuOption(MenuOptionVOExtend menuOptVoEx);*/
}

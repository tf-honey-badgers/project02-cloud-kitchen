package org.badgers.rest.business.menu.persistence;

import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface MenuMapper {
	
	public int addMenuCat(MenuCatVOExtend menuCatVoEx);
	public int addMenu(MenuVOExtend menuVoEx);
	public int addMenuOptionCl(MenuOptionClVOExtend menuOptClVoEx);
	public int addMenuOption(MenuOptionVOExtend menuOptVoEx);
}

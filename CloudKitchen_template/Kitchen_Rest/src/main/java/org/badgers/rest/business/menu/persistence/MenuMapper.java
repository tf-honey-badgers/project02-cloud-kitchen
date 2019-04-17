package org.badgers.rest.business.menu.persistence;

import java.util.List;

import org.badgers.rest.model.CommonCodeVOExtend;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;

public interface MenuMapper {
	
	public int addMenuCat(MenuCatVOExtend menuCatVoEx);
	public int addMenu(MenuVOExtend menuVoEx);
	public int addMenuOptionCl(MenuOptionClVOExtend menuOptClVoEx);
	public int addMenuOption(MenuOptionVOExtend menuOptVoEx);
	public int deleteMenu(int menuId);
	public int deleteMenuOpt(int menuOptIdx);
	public int updateMenuInfo(MenuVOExtend menuVoEx);
	public int updateMenuOptInfo(MenuOptionVOExtend menuOptVoEx);
	public List<MenuCatVOExtend> getMenuCat(String bizId);
	public List<CommonCodeVOExtend> getCommonCode();
	public int insertMenuCat(MenuCatVOExtend menuCatVo);
}

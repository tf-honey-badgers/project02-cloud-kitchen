package org.badgers.rest.business.menu.service;

import java.util.List;

import org.badgers.rest.business.menu.persistence.MenuMapper;
import org.badgers.rest.model.CommonCodeVOExtend;
import org.badgers.rest.model.MenuCatVOExtend;
import org.badgers.rest.model.MenuOptionClVOExtend;
import org.badgers.rest.model.MenuOptionVOExtend;
import org.badgers.rest.model.MenuVOExtend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	public int updateMenuInfo(String updateMenuInfo){
		JsonParser parser = new JsonParser();
		JsonObject menuOptClelement = (JsonObject) parser.parse(updateMenuInfo);
		int resultCnt = 0;
		MenuVOExtend menuVoEx = new MenuVOExtend();
		menuVoEx.setMCode(menuOptClelement.get("mCode").getAsInt());
		menuVoEx.setMName(menuOptClelement.get("mName").getAsString());
		menuVoEx.setMBasicPrice(menuOptClelement.get("mBasicPrice").getAsInt());
		if(menuOptClelement.get("mPhoto").getAsString()!=null) {
			menuVoEx.setMPhoto(menuOptClelement.get("mPhoto").getAsString());
			
		} else {
			menuVoEx.setMPhoto("사진없음");
		}
		System.out.println(menuOptClelement);
		mapper.updateMenuInfo(menuVoEx);
		resultCnt++;
		
		JsonArray menuOptClArray = menuOptClelement.get("menuOptCl").getAsJsonArray();
		// menuOptCl의 사이즈 = 3
		for(int i=0;i<menuOptClArray.size();i++) {
			JsonObject menuOptCl = (JsonObject) menuOptClArray.get(i);
			JsonObject menuOptelement = (JsonObject) parser.parse(menuOptClArray.get(i).toString());
			JsonArray menuOptArray = menuOptelement.get("menuOptEx").getAsJsonArray();
			
			for(int j=0;j<menuOptArray.size();j++) {
				JsonObject menuOpt = (JsonObject) menuOptArray.get(j);
				MenuOptionVOExtend menuOptVoEx = new MenuOptionVOExtend();
				menuOptVoEx.setMoCode(menuOpt.get("moCode").getAsInt());
				menuOptVoEx.setMoName(menuOpt.get("moName").getAsString());
				menuOptVoEx.setMoAddPrice(menuOpt.get("moAddPrice").getAsString());
				menuOptVoEx.setMoOptClNo(menuOpt.get("moOptClNo").getAsInt());
				mapper.updateMenuOptInfo(menuOptVoEx);
				resultCnt++;
			}
		}
		return resultCnt;
	}

	@Override
	public List<MenuCatVOExtend> getMenuCat(String bizId) {
		return mapper.getMenuCat(bizId);
	}

	@Override
	public List<CommonCodeVOExtend> getCommonCode() {
		return mapper.getCommonCode();
	}

	@Override
	public int insertMenu(String updateMenuInfo) {
		System.out.println(updateMenuInfo);
		JsonParser parser = new JsonParser();
		JsonObject menuOptClelement = (JsonObject) parser.parse(updateMenuInfo);
		
		MenuVOExtend menuVoEx = new MenuVOExtend();
		menuVoEx.setMName(menuOptClelement.get("mName").getAsString());
		menuVoEx.setMBasicPrice(menuOptClelement.get("mBasicPrice").getAsInt());
		menuVoEx.setMenuCatCode(menuOptClelement.get("menuCatCode").getAsInt());

		
		if(menuOptClelement.get("mPhoto").getAsString()==null || menuOptClelement.get("mPhoto").getAsString()=="" ) {
			menuVoEx.setMPhoto("사진없음");
		} else {
			menuVoEx.setMPhoto(menuOptClelement.get("mPhoto").getAsString());
		}
		
		mapper.addMenu(menuVoEx);
		
		JsonArray menuOptClArray = menuOptClelement.get("menuOptCl").getAsJsonArray();
		
		for(int i=0;i<menuOptClArray.size();i++) {
			JsonObject menuOptCl = (JsonObject) menuOptClArray.get(i);
			JsonObject menuOptelement = (JsonObject) parser.parse(menuOptClArray.get(i).toString());
			JsonArray menuOptArray = menuOptelement.get("menuOpt").getAsJsonArray();
			
			MenuOptionClVOExtend menuOptClVo = new MenuOptionClVOExtend();
			menuOptClVo.setMocName(menuOptCl.get("mocName").getAsString());
			menuOptClVo.setMocMenuOptType(menuOptCl.get("mocMenuOptType").getAsString());
			menuOptClVo.setMocMenuCode(menuVoEx.getMCode());
			mapper.addMenuOptionCl(menuOptClVo);

			for(int j=0;j<menuOptArray.size();j++) {
				JsonObject menuOpt = (JsonObject) menuOptArray.get(j);
				MenuOptionVOExtend menuOptVoEx = new MenuOptionVOExtend();
				
				menuOptVoEx.setMoName(menuOpt.get("moName").getAsString());
				menuOptVoEx.setMoAddPrice(menuOpt.get("moAddPrice").getAsString());
				menuOptVoEx.setMoOptClNo(menuOptClVo.getMocNo());
				mapper.addMenuOption(menuOptVoEx);

			}

		}
		return menuVoEx.getMCode();
	}

	@Override
	public int insertMenuCat(String insertMenuCat) {
		int result = 0;
		JsonParser parser = new JsonParser();
		JsonObject menuCatelement = (JsonObject) parser.parse(insertMenuCat);
		JsonArray menuCatArray = menuCatelement.get("menuCat").getAsJsonArray();
		System.out.println(menuCatelement.get("bizId").getAsString());
		
		for(int i=0; i<menuCatArray.size(); i++) {
			MenuCatVOExtend menuCatVo = new MenuCatVOExtend();
			menuCatVo.setMcBizId(menuCatelement.get("bizId").getAsString());
			menuCatVo.setMcName(menuCatArray.get(i).getAsString());
			mapper.insertMenuCat(menuCatVo);
			result++;
			System.out.println(menuCatArray.get(i).getAsString());
		}
		
		return result;
	}

	@Override
	public int deleteMenu(int menuId) {
		return mapper.deleteMenu(menuId);
	}

}

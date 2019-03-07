package com.badgers.common.domain;

import lombok.Data;

@Data
public class BizVo {
	// Table : biz
	private String bizId;
	private String info;
	private String name;
	private int likeCnt;
	private int minAmt;
	private String bizCatId;
	// Table : biz_member
	private BizMemberVo memberVo;
	// Table : kitchen_branch
	private KitchenBranchVo branchVo;
	// Table : favorite
	private FavoriteVo favoriteVo;
}

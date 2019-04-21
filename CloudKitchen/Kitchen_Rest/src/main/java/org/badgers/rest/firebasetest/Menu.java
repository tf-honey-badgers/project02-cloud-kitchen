package org.badgers.rest.firebasetest;

import lombok.Data;

@Data
public class Menu {
	private String name;
	private String price;
	private MenuBasicOption[] menuBasicOption;
	private MenuAdditionalOption[] menuAdditionalOptions;
	
}

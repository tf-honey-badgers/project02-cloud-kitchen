package org.badgers.business.util;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PushObject {
	
	@Bean(value="push")
	public Push push() throws IOException {
		
		return new Push();
	}

}

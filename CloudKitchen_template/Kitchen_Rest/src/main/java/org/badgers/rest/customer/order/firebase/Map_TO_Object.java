package org.badgers.rest.customer.order.firebase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class Map_TO_Object {
	
	public Object setData(Object object, HashMap<String, Object> fields) throws IllegalAccessException, InvocationTargetException {
		   for(Entry<String, Object> entry : fields.entrySet()) {
			   entry.getKey();
		      BeanUtils.setProperty(object, entry.getKey(), entry.getValue());
		   }
		   return object;
		}

}

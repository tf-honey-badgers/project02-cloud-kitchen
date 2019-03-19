package org.badgers.rest.common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Map_TO_Object {
	public static  Map<String, Object> voToMap(Object order)
			throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Map<String, Object> map = new HashMap<>();

		Field[] fields = order.getClass().getDeclaredFields();

		for (Field field : fields) {
			String filedName = field.getName();
			String methodName = filedName.replaceFirst(filedName.substring(0, 1),
					filedName.substring(0, 1).toUpperCase());

			map.put(filedName, order.getClass().getDeclaredMethod("get" + methodName).invoke(order));
		}

		return map;
	}
}

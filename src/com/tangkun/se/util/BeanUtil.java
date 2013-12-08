package com.tangkun.se.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import sun.security.jca.GetInstance;

public class BeanUtil {

	private static final Object instance = null;

	/**
	 * 将源对象中的属性复制到目标对象中
	 * 
	 * @param sourceBean
	 *            源对象
	 * @param targetClass
	 *            目标对象class
	 * @return 复制后的class对象obj
	 * @throws Exception
	 */
	public static <T> T copyBean(Object sourceBean, Class<T> targetClass) throws Exception {

		Constructor<?> constructor = targetClass.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object newInstance = constructor.newInstance();
		

		Method[] declaredMethods = sourceBean.getClass().getDeclaredMethods();

		for (Method method : declaredMethods) {
			method.setAccessible(true);

			if (method.getName().startsWith("get")) {
				Method method2 = null;
				try {
					method2 = targetClass.getDeclaredMethod(method.getName().replace("get", "set"),
							method.getReturnType());
				} catch (Exception e) {}
				if (method2 != null) {
					method2.setAccessible(true);
					method2.invoke(newInstance, method.invoke(sourceBean));
				}
			}
		}

		return (T) newInstance;
	}

}

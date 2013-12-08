package com.tangkun.se;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Bean2Bean {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		A a = new A();
		a.setId(0L);
		a.setName("tangkun");

		try {
//			B b = BeanUtil.copyBean(a, B.class);
//			System.out.println(b.getId());
//			System.out.println(System.setProperty("java.runtime.name", "===="));
//			System.out.println(System.getProperties());
			
			Integer string = 123;
//			System.out.println(Integer.MAX_VALUE);
//			System.out.println(Integer.MIN_VALUE);
			
			System.out.println( 3 << 3);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class A {

	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class B implements Cloneable {

	private Long id;

	private String name;

	public B() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Object clone() {

		Object object = null;
		try {
			object = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return object;
	}

}

class BeanUtil1 {

	public static <T> T copyBean(Object sourceBean, Class<T> clazz) throws Exception {
		Constructor<?> constructor = clazz.getDeclaredConstructor();
		constructor.setAccessible(true);
		Object newInstance = constructor.newInstance();
		// Object newInstance = clazz.newInstance();
		Method[] declaredMethods = sourceBean.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			method.setAccessible(true);
			if (method.getName().startsWith("get")) {
				Method method2 = null;
				try {
					method2 = clazz.getDeclaredMethod(method.getName().replace("get", "set"), method.getReturnType());
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
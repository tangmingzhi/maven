package com.tangkun.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <h2>文件名称：DynamicProxy.java</h2></br>
 * <h3>文件描述：</h3>动态代理对象</br>
 * <h3>详细说明：</h3></br>
 * @author tangkun
 * @date 2013-12-1 下午6:50:35
 * @version 1.0
 */
public class DynamicProxy implements InvocationHandler {

	private Object realSubject;
	public DynamicProxy(Object realSubject){
		this.realSubject = realSubject;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		method.invoke(realSubject, args);
		
		return null;
	}

}

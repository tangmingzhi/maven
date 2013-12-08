package com.tangkun.lazyInitialization;
/**
 * 线程不安全的对象初始化
 * @author tangkun
 *
 */
public class UnsafeLazyInitialization {

	public static Instance instance;


	
	public static Instance getInstance() {

		if (instance == null)// 线程B执行到此处,当线程A还未初始化完成
			instance = new Instance(LazyInitializationUtil.FLAG++);// 线程A执行到此处

		return instance;
	}
}

package com.tangkun.lazyInitialization;

public class DoubleCheckedLocking {

	public static Instance instance ;

	/**
	 * 双重检查
	 * @param index
	 * @return
	 */
	public static  Instance getInstance(int index) {

		if (instance == null)// 线程B执行到此处,当线程A还未初始化完成
			
			synchronized (DoubleCheckedLocking.class) {
				
				if(instance == null ){
					instance = new Instance(index);// 线程A执行到此处
				}
			}

		return instance;
	}
}

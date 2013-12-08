package com.tangkun.lazyInitialization;
/**
 * 线程安全的对象初始化
 * @author tangkun
 *
 */
public class SafeLazyInitialization {

	public static Instance instance;

	/**
	 * 锁加在方法上，即对SafeLazyInitialization class对象上锁
	 * 多线程调用会导致性能下降
	 * @return
	 */
	public static synchronized Instance getInstance(int index) {

		if (instance == null)// 线程B执行到此处,当线程A还未初始化完成
			instance = new Instance(index);// 线程A执行到此处

		return instance;
	}
	

	
	
}

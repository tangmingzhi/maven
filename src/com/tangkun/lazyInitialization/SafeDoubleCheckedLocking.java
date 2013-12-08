package com.tangkun.lazyInitialization;

import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * <h2>文件名称：SafeDoubleCheckedLocking.java</h2></br> <h3>文件描述：</h3>volatile型多线程安全延迟加载</br> <h3>详细说明：</h3></br>
 * 
 * @author tangkun
 * @date 2013-11-5 下午2:51:32
 * @version 1.0
 */
public class SafeDoubleCheckedLocking {

	private volatile static Instance instance;

	public static Instance getInstance(long id) {

		if (instance == null) {
			synchronized (SafeDoubleCheckedLocking.class) {
			if (instance == null){
				try {
					Thread.sleep(new Random().nextInt(100));
					instance = new Instance((int)id);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
			}
		}

		return instance;
	}
	
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		t1.start();
		Thread1 t2 = new Thread1();
		t2.start();
		Thread1 t3 = new Thread1();
		t3.start();
		Thread1 t4 = new Thread1();
		t4.start();
		Thread1 t5 = new Thread1();
		t5.start();
		
		
	}
}

class Thread1 extends Thread{
	
		public void run() {
			try {
//				Thread.sleep(new Random().nextInt(1000));
				for (int i = 0; i < 200; i++) {
					Thread.sleep(new Random().nextInt(100));
					int id = InstanceFactory.getInstance(this.getId()).getId();
					System.out.println(this.getId()+"=="+id);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

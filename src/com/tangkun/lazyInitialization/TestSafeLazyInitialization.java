package com.tangkun.lazyInitialization;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;


public class TestSafeLazyInitialization {

	static List<Long> times = new ArrayList<Long>();
	
	public static void main(String[] args) {

		for (int i = 0; i < 20; i++) {
			runThreed();
		}

		System.out.println(times);
	}

	private static void runThreed() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			InstanceThreed instanceThreed = new InstanceThreed(i);
			instanceThreed.start();
		}
		times.add(System.currentTimeMillis()-startTime);
	}
}

class InstanceThreed extends Thread {

	private int index;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public InstanceThreed(int index) {
		this.index = index;
	}

	public void run() {

		try {
//			System.out.println("index="+this.index);
//			Thread.sleep(100);
			this.getInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getInstance() throws Exception {
		DoubleCheckedLocking.getInstance(this.index);
//		System.out.println("初始化对象id="+SafeLazyInitialization.getInstance(this.index).getId());
	}

}
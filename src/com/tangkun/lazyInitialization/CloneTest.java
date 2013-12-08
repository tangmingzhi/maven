package com.tangkun.lazyInitialization;

public class CloneTest {

	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			Instance instance = DoubleCheckedLocking.getInstance(i);
			Instance instance2 = (Instance)instance.clone();
			System.out.println(instance2.getId());
			
		}
	}
}

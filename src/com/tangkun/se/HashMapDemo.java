package com.tangkun.se;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

/**
 * <h2>文件名称：HashMapDemo.java</h2></br> <h3>文件描述：</h3></br> <h3>详细说明：</h3></br>
 * 
 * @author tangkun
 * @date 2013-11-6 上午9:10:04
 * @version 1.0
 */
public class HashMapDemo {

	public static void main(String[] args) {
		runMethod();
	}

	public static void runMethod() {
		final Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
		Thread t = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 10000; i++) {
					new Thread(new Runnable() {
						public void run() {
							//System.out.println(map.size());
							map.put(String.valueOf(map.size()+1), UUID.randomUUID().toString());
						}
					}, "ftf" + i).start();
				}
				
				Iterator iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
					Map.Entry<String,String> entry = (Entry<String, String>) iterator.next();
					System.out.println(entry.getKey() +"=="+entry.getValue());
				}
				
			}
		}, "ftf");
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

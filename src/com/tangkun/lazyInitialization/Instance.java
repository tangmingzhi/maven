package com.tangkun.lazyInitialization;

import java.util.Random;

public class Instance implements Cloneable{

	private Integer id;

	private String name;

	public Instance(int index) {
		try {
			Thread.sleep(new Random().nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.id = index;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Object clone(){
		
		return this.clone();
	}
}

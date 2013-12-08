package com.tangkun.se;

public class ObjectClone implements Cloneable {

	String name;
	int age;

	public ObjectClone(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public static void main(String[] args) {

		ObjectClone obj1 = new ObjectClone("tangkun", 18);

		ObjectClone obj2 = (ObjectClone) obj1.clone();

		obj2.setName("tangmingzhi");
		obj2.setAge(16);
		
		System.out.println("obj1:"+obj1.toString());
		System.out.println("obj2:"+obj2.toString());

	}

	@Override
	public Object clone() {

		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return obj;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {

		return this.name + "\t" + this.age;
	}

}

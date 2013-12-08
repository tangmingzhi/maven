//package com.tangkun.se;
//
///**
// * <h2>文件名称：EqualsDemo.java</h2></br> <h3>文件描述：</h3></br> <h3>详细说明：</h3></br>
// * 
// * @author tangkun
// * @date 2013-11-4 上午10:49:10
// * @version 1.0
// */
//public class EqualsDemo {
//
//	public static void main(String[] args) {
//		// String a = "111";
//		// String b = "111";
//		//
//		// System.out.print(a == b);
//
//		// Integer A = new Integer(123);
//		// Integer B = new Integer(123);
//		//
//		// System.out.println(A == B);
//
//		// A a = new A(new Long(123));
//		// B b = new B(new Long(123));
//		// A a = new A(Long.parseLong("123"));
//		// a.setId(Long.parseLong("112"));
//		// A a2 = new A(Long.parseLong("123"));
//		A a = new B(Long.parseLong("123"));
//		a.setId(Long.parseLong("112"));
//		a.show();
//		a.say();
//		// System.out.println(a.getId().equals(b.getId()));
//	}
//
//}
//
//class A {
//
//	// public A(Long id) {
//	// this.id = id;
//	// }
//
//	Long id;
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void show() {
//		System.out.println("A show");
//	}
//
//	public void say() {
//		System.out.println("only A say");
//	}
//}
//
//class B extends A {
//
//	Long id;
//
//	public B(Long id) {
//		super();
//		this.id = id;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public void show() {
//		System.out.println("B show");
//	}
//
//}

package com.tangkun.se;

import com.sun.media.sound.HsbParser;

/**
 * <h2>文件名称：HashCodeDemo.java</h2></br>
 * <h3>文件描述：</h3></br>
 * <h3>详细说明：</h3></br>
 * @author tangkun
 * @date 2013-11-5 下午4:56:24
 * @version 1.0
 */
public class HashCodeDemo {

	public static void main(String[] args) {
		
		HashCodeInstance demo1 = new HashCodeInstance(1L);
		HashCodeInstance demo2 = new HashCodeInstance(1L);
		
		//System.out.println(demo1.equals(demo2));
		
		//System.out.println(demo1.hashCode());
		
		String str1 = "aaa";
		String str2 = "aaa";
		
		//System.out.println(str1.hashCode() == str2.hashCode());
		
		boolean b1 =  Integer.valueOf(127)==Integer.valueOf(127); // true
//		System.out.println("Integer.valueOf(127)=="+b1);
        boolean b2 = Integer.valueOf(128)==Integer.valueOf(128) ; // false
//        System.out.println("Integer.valueOf(128)=="+b2);
        
        Integer a = Integer.parseInt("126");
        Integer b = Integer.parseInt("126");
        
        Double l1 = Double.parseDouble("127");
        Double l2 = Double.parseDouble("127");
        
//        System.out.println("long l1 == l2 "+(l1 == l2));
        System.out.println("a == b " +( a == b));
        boolean b3 =  Integer.valueOf(-128)==Integer.valueOf(-128); // true
        boolean b4 = Integer.valueOf(-129)==Integer.valueOf(-129) ; // false
	}
}
class HashCodeInstance{
	
	Long id;
	
	String name;

	public HashCodeInstance(Long id){
		this.id = id;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return this.getId().equals(((HashCodeInstance)obj).getId());
	}
}

package com.tangkun.proxy;

/**
 * <h2>文件名称：RealSubject.java</h2></br>
 * <h3>文件描述：</h3></br>
 * <h3>详细说明：</h3></br>
 * @author tangkun
 * @date 2013-12-1 下午6:48:02
 * @version 1.0
 */
public class RealSubject implements SubjectA,SubjectB {

	public void request() throws Exception {
		
		System.out.println("request from   SubjectA!");

	}

	public void response() throws Exception {
		System.out.println("response from   SubjectB!");
	}

}

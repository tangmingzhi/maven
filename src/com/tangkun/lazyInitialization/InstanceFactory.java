package com.tangkun.lazyInitialization;

/**
 * <h2>文件名称：InstanceFactory.java</h2></br> <h3>文件描述：</h3></br> <h3>详细说明：</h3></br>
 * 
 * @author tangkun
 * @date 2013-11-5 下午4:02:10
 * @version 1.0
 */
public class InstanceFactory {

	private static class InstanceHolder {
		static long id ;
		public static Instance instance = new Instance((int)id);

	}

	public static Instance getInstance(long id) {
		InstanceHolder.id = id;
		return InstanceHolder.instance;
	}
}

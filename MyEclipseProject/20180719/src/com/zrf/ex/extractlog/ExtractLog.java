
/**
* @Title: ExtractLog.java
* @Package com.zrf.ex.extractlog
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.extractlog;

/**
 * @ClassName: ExtractLog
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��19��
 */

public class ExtractLog {
	public static class Mapper {
		public void map() {
			System.out.println("map");
		}
	}

	public static class Reducer {
		public void reduce() {
			System.out.println("reduce");
		}
	}

	public static void main(String[] args) {
		Mapper mapper = new Mapper();
		mapper.map();
		Reducer reducer = new Reducer();
		reducer.reduce();
	}

}

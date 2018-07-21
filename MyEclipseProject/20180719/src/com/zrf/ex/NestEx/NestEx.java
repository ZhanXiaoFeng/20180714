
/**
* @Title: NestEx.java
* @Package com.zrf.ex.NestEx
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.NestEx;

/**
 * @ClassName: NestEx
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��19��
 */

public class NestEx {

	public static class StaticNest {
		public void play() {
			System.out.println("play");
		}
	}

	public class Nest {
		public void say(String str) {
			System.out.println(str);
		}
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public NestEx() {
		super();
	}

	public NestEx(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "NestEx [name=" + name + "]";
	}

}

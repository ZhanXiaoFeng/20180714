
/**
* @Title: OptionalEx.java
* @Package com.zrf.ex
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��23��
* @version V1.0  
*/

package com.zrf.ex;

import java.util.*;

public class OptionalEx {
	public static void main(String aa[]) {
		String s = null;

		Optional<String> op = Optional.ofNullable(s);

		if (op.isPresent()) {
			String s2 = op.get();
			System.out.println(s2);
		} else {
			System.out.println("��ֵ");
		}
	}
}
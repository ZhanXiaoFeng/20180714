
/**
* @Title: TestMapperReducer.java
* @Package com.zrf.ex.extractlog.test
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.extractlog.test;

import org.junit.Test;
import com.zrf.ex.extractlog.ExtractLog.Mapper;
import com.zrf.ex.extractlog.ExtractLog.Reducer;

/**
 * @ClassName: TestMapperReducer
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��7��19��
 */

public class TestMapperReducer {
	@Test
	public void test() {
		Mapper mapper = new Mapper();
		mapper.map();
		Reducer reducer = new Reducer();
		reducer.reduce();
	}
}

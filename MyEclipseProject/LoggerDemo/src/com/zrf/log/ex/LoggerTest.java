package com.zrf.log.ex;

import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Arrays;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LoggerTest {
	private Logger logger;

	public static void main(String[] args) {

		System.out.println("Hello!");
		Properties pro = System.getProperties();
		/**************** ʵ�ַ����� ******************/
		/*
		 * //pro.forEach((Object key, Object value) -> System.out.println("Key="
		 * +key + "\tvalue=" + value)); pro.forEach((key, value) ->
		 * System.out.println("Key=" + key + "\tvalue=" + value));
		 */

		/**************** ʵ�ַ����� ******************/
		// Arrays.asList(1, 2, 3, 4, 5).forEach((v) -> System.out.println(v));

		/*
		 * 1.Arrays.asList()��ʹ�ÿɱ�������list 2.List,Set,Map,array���������ʽ��Stream()������
		 * .parallelStream()������ 3.min((i,j)->{return i-j;})ʹ����Java8��ʼ��lamb���ʽ
		 * 4.Arrays.asList(1, 2, 3, 4,5).parallelStream().min((i, j) -> {return
		 * i - j;}); ������Optional<T>NullPointerException
		 */

		Optional<Integer> opt = Arrays.asList(1, 2, 3, 4, 5).parallelStream().min((i, j) -> {
			return i - j;
		});
		if (opt.isPresent()) {
			Integer res = opt.get();
			System.out.println(res);
		} else {
			System.out.println("ֵΪ�գ�");
		}
		/**************** ʵ�ַ����� ******************/
		/*
		 * new BiConsumer<Object, Object>() { public void accept(Object key,
		 * Object value) { System.out.println("Key=" + key + "\t value=" +
		 * value); } }; BiConsumer<Object, Object> bc = new MyBiConsumer();
		 * pro.forEach(bc);
		 */

		/**************** ʵ�ַ���һ ******************/
		/*
		 * Set<Object> set = pro.keySet(); for (Object o : set) { String key =
		 * (String) o; String value = pro.getProperty(key);
		 * System.out.println("Key=" + key + "\t value=" + value); }
		 */
	}

	@Before
	public void init() {
		logger = Logger.getLogger("Logger");
	}

	@After
	public void destory() {
		logger = null;
	}

	@Test
	public void testReflect() throws Exception {
		String str = "java.util.logging.ConsoleHandler";
		Class clas = Class.forName(str);
		ConsoleHandler newInstance = (ConsoleHandler) clas.newInstance();
	}

	@Test
	public void testHello() {
		for (int i = 0; i < 100; i++) {
			logger.finest("finest����log");
			logger.info("info����log");
		}
	}
}

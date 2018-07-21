
/**
* @Title: Dog.java
* @Package com.zrf.ex.bean
* @Description: ����Dog��
* @author ZRF
* @date 2018��7��20��
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.Serializable;

/**
 * @ClassName: Dog
 * @Description: ����Dog��
 * @author ZRF
 * @date 2018��7��20��
 */

/*
 * ��װ�ࣺ
 * 1,�����������͵İ�װ��
 *    int -->Integer  char-->Character long--> Long .....
 * 2���������е�ԭ�Ӱ�װ��CAS��:AtomicLong,AtomoicInteger....
 * 3��hadoop��,��ҪĿ���������л���Ҫ����ʹ��jdk�����л�
 *    int-->IntStream  String-->TextStream 
 */

//˼��
/*һ��Dog d=new Dog("aa",3);
 * ��java�ڴ���,ջ����heap ����Ĵ��������ٶ��ڶ��� 
 * new Dog("aa",3)
 * �ȸ�������Է���ռ䣺
 *     1������Ƕ��󣬷���һ����ַ�Ŀռ�
 *     2�������������ͣ������������͵�λ������ռ�
 *     3�����������ռ䣬�ȸ������ף�Ȼ����үү��Ȼ�������׵�үү��Ȼ����үү��үү
 *     4����ͬ���Ĳ��踳��ʼֵ��������0��������0.0��char '\0',boolean false,����null
 *     5���������������Ĭ��ֵ���͸�Ĭ��ֵ
 *     6�����ø���Ĺ��캯�����Դ�����
 *     7��ִ�й��캯���Ĵ���
 */

// ע��ʹ��ioʱҪ�����л��ӿ�
public class Dog implements Serializable {
	/**
	 * @Fields :serialVersionUID
	 */

	private static final long serialVersionUID = 3478964482596748945L;
	private String name;
	private transient int age;//����Ҫ���л��Ķ�������transient�ؼ��֣�������д������
	//������еĴ���ִ�У����ڵ��ù��캯��֮ǰ
		{
			
		}

		//��̬����飬������ڴ��ִ�еģ�����ִֻ��һ��
		static{
			
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

	public Dog() {
		super();
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

}


/**  
* @Title: Person.java
* @Package demo11.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo11.bean;

import java.io.Serializable;

/**
 * @ClassName: Person
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class Person implements Serializable {
	
	/**
	 * @Fields field:field:{TODO}(��һ�仰�������������ʾʲô)
	*/
	    
	private static final long serialVersionUID = 1L;
	private String name;
	/* name ���Ե� getter/setter ���� */

	/**
	* @return the name
	*/
	
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	
	public void setName(String name) {
		this.name = name;
	}

}

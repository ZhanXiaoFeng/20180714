/** 

* <p>Title: Demo03.java</p>  

* <p>Description: ��Ԫ���������������һ��</p>  

* <p>Copyright: Copyright (c) 2018</p>  

* @author Administrator 

* @date 2018��6��20��  

* @version 1.0  

*/  

package demo03;

/**  

* <p>Title: Demo03</p>  

* <p>Description:��Ԫ���������������һ�� </p>  

* @author Administrator 

* @date 2018��6��20��  

*/
public class Demo03 {
	
	public static void main(String[] args) {
		int i = 80;
		String s = String.valueOf(i<100?90:100);
		String s1 = String.valueOf(i<100?90:100.0);
		System.out.println(" �����Ƿ���� :"+s.equals(s1));
		}

}

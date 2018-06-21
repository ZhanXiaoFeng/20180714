
/**  
* @Title: SerializationUtils.java
* @Package demo11.utils
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��6��21��
* @version V1.0  
*/

package demo11.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName: SerializationUtils
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��6��21��
 */

public class SerializationUtils {
	private static String FILE_NAME = "c:/obj.bin";

	// ���л�
	public static void writeObject(Serializable s) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			oos.writeObject(s);
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object readObject() {
		Object obj = null;
		// �����л�
		try {
			ObjectInput input = new ObjectInputStream(new FileInputStream(FILE_NAME));
			obj = input.readObject();
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

}


/**
* @Title: PersonClone.java
* @Package com.zrf.ex.bean
* @Description: ���¡
* @author ZRF
* @date 2018��7��19��
* @version V1.0  
*/

package com.zrf.ex.bean;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName: PersonClone
 * @Description: ���¡
 * @author ZRF
 * @date 2018��7��19��
 */

public class PersonClone {
	public static Person deepClone(Person p) {
		Person pClone = null;
		// �����д���ļ�
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/person.txt"));
			oos.writeObject(p);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// ��������ļ�����
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:/person.txt"));
			pClone = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pClone;
	}

	public static Person deepCloneMemory(Person p) {
		Person pClone = null;
		// ���ڴ�д���ļ�
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] arr = out.toByteArray();// ת��Ϊ����

		// �����ڴ��ļ�����
		ByteArrayInputStream in = new ByteArrayInputStream(arr);
		try {
			ObjectInputStream ois = new ObjectInputStream(in);
			pClone = (Person) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pClone;
	}
}

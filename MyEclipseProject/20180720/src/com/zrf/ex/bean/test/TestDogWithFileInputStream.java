
/**
* @Title: TestDogWithFileInputStream.java
* @Package com.zrf.ex.bean.test
* @Description: �ļ�д������
* @author ZRF
* @date 2018��7��20��
* @version V1.0  
*/

package com.zrf.ex.bean.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import org.junit.Test;
import com.zrf.ex.bean.Dog;

/**
 * @ClassName: TestDogWithFileInputStream
 * @Description: �ļ�д������
 * @author ZRF
 * @date 2018��7��20��
 */
//���ڴ���Ϊ�����inputStream �����ڴ�
//try...withֻ�ܷ����Զ��رյĶ���Ĵ���
public class TestDogWithFileInputStream {
	/*
	 * java.io.AutoCloseable
	 * Connection,Statement,ResultSet
	 * InputStream,OutputStream,Reader,Writer,FileChannel
	 * Sockect,ServerSocket
	 * 
	 */
	public static void main(String[] args) {
		try (FileInputStream fis = new FileInputStream("D:\\person.txt");
				BufferedInputStream bis = new BufferedInputStream(fis);) {
			byte[] arr = new byte[3];
			int len = 0;
			while ((len = bis.read(arr)) > 0) {
				String str = new String(arr, 0, len);
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	/*
	 * д�ļ�������
	 */
	@Test
	public void testObjectOutputStream() {
		try (FileOutputStream fos = new FileOutputStream("D:\\dog.txt");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
				ObjectOutputStream oos = new ObjectOutputStream(bos);) {
			Dog dog1 = new Dog("001", 1);
			Dog dog2 = new Dog("002", 2);
			oos.writeObject(dog1);
			oos.writeInt(10);
			oos.writeObject(dog2);
			oos.writeUTF("СС����");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * �Ӵ��̶����ļ�
	 * EJB,�����ݺͷֲ�ʽ����У����ݵ��Ƕ���
	 */
	@Test
	public void testObjectInputStream() {
		// try()�����еĴ������ʵ���Զ��ر���
		try (ObjectInputStream ois = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream("D:/dog.txt")));) {
			System.out.println(ois.readObject());
			System.out.println(ois.readInt());
			System.out.println(ois.readObject());
			System.out.println(ois.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * NIO��д�ļ�
	 */
	@Test
	public void testNIORead() {
		try (FileChannel fc = new FileInputStream("D://dog.txt").getChannel();
				) {
			//�����ڴ�ռ�
			ByteBuffer bb = ByteBuffer.allocate(3);
			byte[] arr = new byte[3];
			while (fc.read(bb) > 0) {
				bb.flip();
				/**************�汾һ*************/
				/*for (int i = 0; i < bb.limit(); i++) {
					arr[i] = bb.get();
				}
				System.out.print(new String(arr, 0, bb.limit()));
				*/
				/**************�汾��*************/
				bb.get(arr, 0, bb.limit());
				System.out.print(new String(arr, 0, bb.limit()));
				bb.position(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

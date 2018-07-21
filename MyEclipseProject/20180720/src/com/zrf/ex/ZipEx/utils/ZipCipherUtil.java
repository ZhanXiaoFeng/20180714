
/**
* @Title: ZipCipherUtil.java
* @Package com.zrf.ex.ZipEx
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��21��
* @version V1.0  
*/

package com.zrf.ex.ZipEx.utils;

/**
* @ClassName: ZipCipherUtil
* @Description: TODO(������һ�仰��������������)
* @author ZRF
* @date 2018��7��21��
*/

import java.io.File;
import java.util.UUID;

public class ZipCipherUtil {
	/**
	 * ��Ŀ¼srcFile�µ������ļ�Ŀ¼������ѹ�������,Ȼ�󱣴�Ϊdestfile
	 * 
	 * @param srcFile
	 *            Ҫ�������ļ����ļ���
	 * @param destfile
	 *            ѹ�����ܺ��ŵ��ļ�
	 * @param keyfile
	 *            ��Կ
	 */
	public void encryptZip(String srcFile, String destfile, String keyStr) throws Exception {
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		temp.deleteOnExit();
		// ��ѹ���ļ�
		new ZipUtil().zip(srcFile, temp.getAbsolutePath());
		// ���ļ�����
		new CipherUtil().encrypt(temp.getAbsolutePath(), destfile, keyStr);
		temp.delete();
	}

	/**
	 * ���ļ�srcfile�����Ƚ��ܺ��ѹ��,Ȼ���ѹ����Ŀ¼destfile��
	 * 
	 * @param srcfile
	 *            Ҫ���ܺͽ�ѹ�����ļ���
	 * @param destfile
	 *            ��ѹ�����Ŀ¼
	 * @param publicKey
	 *            ��Կ
	 */
	public void decryptUnzip(String srcfile, String destfile, String keyStr) throws Exception {
		File temp = new File(UUID.randomUUID().toString() + ".zip");
		temp.deleteOnExit();
		// �ȶ��ļ�����
		new CipherUtil().decrypt(srcfile, temp.getAbsolutePath(), keyStr);
		// ��ѹ��
		new ZipUtil().unZip(temp.getAbsolutePath(), destfile);
		temp.delete();
	}

	public static void main(String[] args) throws Exception {
		long l1 = System.currentTimeMillis();

		// ����
		// new ZipCipherUtil().encryptZip("d:\\test\\111.jpg",
		// "d:\\test\\photo.zip", "12345");
		// ����
		new ZipCipherUtil().decryptUnzip("d:\\test\\photo.zip", "d:\\test\\111_1.jpg", "12345");

		long l2 = System.currentTimeMillis();
		System.out.println((l2 - l1) + "����.");
		System.out.println(((l2 - l1) / 1000) + "��.");
	}
}

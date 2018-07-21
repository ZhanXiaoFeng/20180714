
/**
* @Title: ZipUtil.java
* @Package com.zrf.ex.ZipEx.utils
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��7��21��
* @version V1.0  
*/

package com.zrf.ex.ZipEx.utils;

/**
* @ClassName: ZipUtil
* @Description: TODO(������һ�仰��������������)
* @author ZRF
* @date 2018��7��21��
*/

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * ���ļ����ļ��н���ѹ���ͽ�ѹ
 *
 */
public class ZipUtil {
	/** �õ���ǰϵͳ�ķָ��� */
	// private static String separator = System.getProperty("file.separator");

	/**
	 * ��ӵ�ѹ���ļ���
	 * 
	 * @param out
	 * @param f
	 * @param base
	 * @throws Exception
	 */
	private void directoryZip(ZipOutputStream out, File f, String base) throws Exception {
		// ����������Ŀ¼
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			// ����ѹ������Ŀ¼
			out.putNextEntry(new ZipEntry(base + "/"));
			if (base.length() == 0) {
				base = "";
			} else {
				base = base + "/";
			}
			for (int i = 0; i < fl.length; i++) {
				directoryZip(out, fl[i], base + fl[i].getName());
			}
		} else {
			// ��ѹ���ļ�����rar��
			out.putNextEntry(new ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			byte[] bb = new byte[10240];
			int aa = 0;
			while ((aa = in.read(bb)) != -1) {
				out.write(bb, 0, aa);
			}
			in.close();
		}
	}

	/**
	 * ѹ���ļ�
	 * 
	 * @param zos
	 * @param file
	 * @throws Exception
	 */
	private void fileZip(ZipOutputStream zos, File file) throws Exception {
		if (file.isFile()) {
			zos.putNextEntry(new ZipEntry(file.getName()));
			FileInputStream fis = new FileInputStream(file);
			byte[] bb = new byte[10240];
			int aa = 0;
			while ((aa = fis.read(bb)) != -1) {
				zos.write(bb, 0, aa);
			}
			fis.close();
			System.out.println(file.getName());
		} else {
			directoryZip(zos, file, "");
		}
	}

	/**
	 * ��ѹ���ļ�
	 * 
	 * @param zis
	 * @param file
	 * @throws Exception
	 */
	private void fileUnZip(ZipInputStream zis, File file) throws Exception {
		ZipEntry zip = zis.getNextEntry();
		if (zip == null)
			return;
		String name = zip.getName();
		File f = new File(file.getAbsolutePath() + "/" + name);
		if (zip.isDirectory()) {
			f.mkdirs();
			fileUnZip(zis, file);
		} else {
			f.createNewFile();
			FileOutputStream fos = new FileOutputStream(f);
			byte b[] = new byte[10240];
			int aa = 0;
			while ((aa = zis.read(b)) != -1) {
				fos.write(b, 0, aa);
			}
			fos.close();
			fileUnZip(zis, file);
		}
	}

	/**
	 * ����filePath������Ӧ��Ŀ¼
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private File mkdirFiles(String filePath) throws IOException {
		File file = new File(filePath);
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdirs();
		}
		file.createNewFile();

		return file;
	}

	/**
	 * ��zipBeforeFileĿ¼�µ��ļ�ѹ��������Ϊָ�����ļ�zipAfterFile
	 * 
	 * @param zipBeforeFile
	 *            ѹ��֮ǰ���ļ�
	 * @param zipAfterFile
	 *            ѹ��֮����ļ�
	 */
	public void zip(String zipBeforeFile, String zipAfterFile) {
		try {

			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(mkdirFiles(zipAfterFile)));
			fileZip(zos, new File(zipBeforeFile));
			zos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��ѹ���ļ�unZipBeforeFile������unZipAfterFileĿ¼��
	 * 
	 * @param unZipBeforeFile
	 *            ��ѹ֮ǰ���ļ�
	 * @param unZipAfterFile
	 *            ��ѹ֮����ļ�
	 */
	public void unZip(String unZipBeforeFile, String unZipAfterFile) {
		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(unZipBeforeFile));
			File f = new File(unZipAfterFile);
			f.mkdirs();
			fileUnZip(zis, f);
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

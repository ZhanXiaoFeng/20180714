
/**
* @Title: ZipExTest.java
* @Package com.zrf.ex.ZipEx
* @Description: �ļ�ѹ��
* @author ZRF
* @date 2018��7��20��
* @version V1.0  
*/

package com.zrf.ex.ZipEx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.junit.Test;

/**
 * @ClassName: ZipExTest
 * @Description: �ļ�ѹ��
 * @author ZRF
 * @date 2018��7��20��
 */

public class ZipExTest {

	@Test
	public void testOneFileZip() {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// ����ѹ����
		) {
			String str = "dog.txt";// ����ѹ������ļ�����
			ZipEntry entry = new ZipEntry(str);
			zos.putNextEntry(entry);
			byte[] arr = Files.readAllBytes(Paths.get("D:", "dog.txt"));// ��ȡ��ѹ�����ļ�����
			zos.write(arr);// ������д��ѹ����
			zos.closeEntry();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testManyFileZip() {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// ����ѹ����
		) {
			String str = "D:\\C ����\\test";
			File file = new File(str);
			File[] fileArr = file.listFiles(f -> f.isFile());// ��ȡ�����ļ�
			String entryName[] = new String[fileArr.length];// ��ʼ����ѹ���ļ������鳤��
			String strRex = ".*/(test/.*.txt)";
			Pattern pattern = Pattern.compile(strRex);
			int i = 0;
			for (File temp : fileArr) {
				String sShort = temp.toString();
				sShort = sShort.replace('\\', '/');
				Matcher matcher = pattern.matcher(sShort);
				if (matcher.find()) {
					String sGroup1 = matcher.group(1);
					System.out.println(sGroup1);
					entryName[i] = sGroup1;// ƥ�䱻ѹ���ļ���Ӧ���ļ�����
				}
				i++;
			}

			Adler32 adler32 = new Adler32();// Adler32У���㷨
			for (i = 0; i < entryName.length; i++) {
				if (entryName[i] == null) {
					i++;
				} else {
					ZipEntry entry = new ZipEntry(entryName[i]);
					zos.putNextEntry(entry);
					// ��ȡ�ļ�
					byte[] arr = Files.readAllBytes(fileArr[i].toPath());
					adler32.update(arr);
					long value = adler32.getValue();// ��ȡУ��ֵ
					entry.setCrc(value);// ����У��ֵ
					// д������
					zos.write(arr);
					adler32.reset();
					zos.closeEntry();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// �ϵ����
	public static void main(String[] args) {
		try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/dog.zip"));// ����ѹ����
		) {
			String str = "D:\\C ����\\test";
			File file = new File(str);
			File[] fileArr = file.listFiles(f -> f.isFile());// ��ȡ�����ļ�
			String entryName[] = new String[fileArr.length];// ��ʼ����ѹ���ļ������鳤��
			String strRex = ".*/(test/.*.txt)";
			Pattern pattern = Pattern.compile(strRex);
			int i = 0;
			for (File temp : fileArr) {
				String sShort = temp.toString();
				sShort = sShort.replace('\\', '/');
				Matcher matcher = pattern.matcher(sShort);
				if (matcher.find()) {
					String sGroup1 = matcher.group(1);
					System.out.println(sGroup1);
					entryName[i] = sGroup1;// ƥ�䱻ѹ���ļ���Ӧ���ļ�����
				}

				i++;
			}
			for (i = 0; i < entryName.length; i++) {
				if (entryName[i] == null) {
					i++;
				} else {
					ZipEntry entry = new ZipEntry(entryName[i]);
					zos.putNextEntry(entry);
					byte[] arr = Files.readAllBytes(fileArr[i].toPath());
					zos.write(arr);
					zos.closeEntry();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ��һ��
	@Test
	public void testManyFileUnZip1() {
		try {
			int BUFFER = 2048;
			BufferedOutputStream dest = null;
			FileInputStream fis = new FileInputStream("D:/dog.zip");
			ZipInputStream zis = new ZipInputStream(new BufferedInputStream(fis));
			ZipEntry entry;
			while ((entry = zis.getNextEntry()) != null) {
				System.out.println("Extracting: " + entry);
				int count;
				byte data[] = new byte[BUFFER];
				// write the files to the disk
				FileOutputStream fos = new FileOutputStream("D:/" + entry.getName());
				dest = new BufferedOutputStream(fos, BUFFER);
				while ((count = zis.read(data, 0, BUFFER)) != -1) {
					dest.write(data, 0, count);
				}
				dest.flush();
				dest.close();
			}
			zis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	// ��ѹ,zipFileName��ʾ����ѹ��zip�ļ���unzipDir��ʾ��ѹ���ļ����Ŀ¼
	public void testManyFileUnZip2() throws Exception {
		String str = "D:/dog.zip";
		File file = new File(str);
		ZipFile zipFile = new ZipFile(file);
		ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
		ZipEntry entry;
		str = str.substring(0, str.lastIndexOf('.'));// �õ���Ŀ¼
		System.out.println(str);
		while ((entry = zis.getNextEntry()) != null) {
			String fileName = entry.getName();

			File outFile = new File(entry.getName());

			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdir();
			}

			// if the file not exits ,than create the file
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			// create an input stream
			BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
			// create an output stream
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(outFile));
			byte[] b = new byte[100];
			while (true) {
				int len = bis.read(b);
				if (len == -1)
					break;
				bos.write(b, 0, len);
			}
			// close stream
			bis.close();
			bos.close();
		}
		zis.close();
	}
}


/**
* @Title: FileSystemAceess.java
* @Package com.zrf.ex.skydrive
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��5��
* @version V1.0  
*/

package com.zrf.ex.skydrive;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileSystemAceess {

	/**
	 * @param args
	 * @throws Exception
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws URISyntaxException, Exception {
		// ����URI���ʵ�ַ��ȡFileSystem����
		FileSystem fs = getFileSystem(new URI(args[0]));

		// �ϴ�����
		uploadFile(args, fs);
		// ���غ���
		ReadFile(args, fs);
		// ɾ������
		delete(args, fs);
		// ��ȡ�б���
		listStatus(args, fs);
	}

	private static void listStatus(String[] args, FileSystem fs) throws IOException {
		// ��ȡ�б���Ϣ
		String pth = args[2].substring(0, 1);
		FileStatus[] listStatus = fs.listStatus(new Path(pth));
		System.out.println("����\tȨ��\t\t������\t���С\t\t\t�ļ���С\t\t�ļ�·��");
		// �����б���Ϣ
		for (FileStatus fileStatus : listStatus) {
			String fileDir = fileStatus.isDir() ? "�ļ���" : "�ļ�";
			String permission = fileStatus.getPermission().toString();
			short replication = fileStatus.getReplication();
			long len = fileStatus.getLen();
			long blockSize = fileStatus.getBlockSize();
			String path = fileStatus.getPath().toString();
			System.out.println(fileDir + "\t" + permission + "\t" + replication + "\t"
					+ (blockSize / 1024 == 0 ? "�ļ���" : blockSize / 1024 / 1024 + "Mb") + "\t\t"
					+ (len / 1024 == 0 ? "�ļ���" : len + "Byte") + "\t" + path);

		}
	}

	/**
	 * FileSystem.delete ɾ���ļ����ļ���
	 * 
	 * @param args
	 *            �ⲿ����Ĳ���
	 * @param fs
	 *            FileSystem�ļ�ϵͳ
	 * @throws IOException
	 */
	private static void delete(String[] args, FileSystem fs) throws IOException {
		// �ϴ�ǰ�ж��Ƿ���ڣ��������ɾ��
		if (fs.exists(new Path(args[2]))) {
			boolean result = fs.delete(new Path(args[2]), true);
			if (result) {
				System.out.println("ɾ���ɹ�����");
			} else {
				System.out.println("ɾ��ʧ�ܣ�");
			}
		}

		/**
		 * ��һ��������ɾ���ļ���·�������磬/a.txt �ڶ���������ɾ�����Զ��ر���
		 */
		boolean result = fs.delete(new Path(args[2]), true);
		if (result) {
			System.out.println("ɾ���ɹ�������");
		} else {

			System.out.println("ɾ��ʧ�ܣ�����");
		}
	}

	/**
	 * FileSystem.open ��ȡ������
	 * 
	 * @param args
	 *            �ⲿ����Ĳ���
	 * @param fs
	 *            FileSystem����
	 * @throws IOException
	 */
	private static void ReadFile(String[] args, FileSystem fs) throws IOException {
		// ��ȡhdfs�ļ�ϵͳ��������
		FSDataInputStream in = fs.open(new Path(args[2]));
		// ͨ��hadoop�ṩ��ioutils���߰��ڿ���̨�������
		IOUtils.copyBytes(in, System.out, 1024, true);
	}

	/**
	 * FileSystem.create �ϴ��ļ�
	 * 
	 * @param args
	 * @param fs
	 *            FileSystem����
	 * @throws Exception
	 * 
	 */
	@SuppressWarnings("unused")
	private static void uploadFile(String[] args, FileSystem fs) throws Exception {
		// �����ļ���������ָ��Ҫ�ϴ����ļ���ַ
		FileInputStream in = new FileInputStream(args[1]);
		// ʹ��create�����ϴ�,�����ϴ���·�����ļ���
		FSDataOutputStream out = fs.create(new Path(args[2]));
		// ʹ��hadoop�ṩ��IOUtils�ϴ�
		/**
		 * ��һ��������������Ҳ����ָ����Ҫ�ϴ����ļ�·�� �ڶ����������������hadoop�Ĵ洢λ�� ��������������������С ���ĸ��������Ƿ��ϴ�
		 */
		IOUtils.copyBytes(in, out, 1024, true);
	}

	// ��ȡFileSystem����
	static FileSystem getFileSystem(URI uri) throws Exception {
		return FileSystem.get(uri, new Configuration());
	}

}
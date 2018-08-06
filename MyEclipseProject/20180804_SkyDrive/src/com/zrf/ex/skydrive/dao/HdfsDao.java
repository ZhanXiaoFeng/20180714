
/**
* @Title: HdfsDao.java
* @Package com.zrf.ex.skydrive.dao
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��5��
* @version V1.0  
*/

package com.zrf.ex.skydrive.dao;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;
import org.junit.Test;

/**
 * @ClassName: HdfsDao
 * @Description: TODO(������һ�仰��������������)
 * @author ZRF
 * @date 2018��8��5��
 */

public class HdfsDao {

	// HDFS ���ʵ�ַ
	private static final String HDFS = "hdfs://192.168.1.128:8020";

	public HdfsDao(Configuration conf) {
		this(HDFS, conf);
	}

	public HdfsDao(String hdfs, Configuration conf) {
		this.hdfsPath = hdfs;
		this.conf = conf;
	}

	// hdfs ·��
	private String hdfsPath;
	// Hadoop ϵͳ����
	private Configuration conf;

	// ��������
	public static void main(String[] args) throws Exception {
		JobConf conf = config();
		HdfsDao hdfs = new HdfsDao(conf);
		hdfs.mkdirs("/20180804_SkyDrive/test");
		// hdfs.copyFile("C:\\files", "/wgc/");
		// hdfs.ls("hdfs://localhost:9000/input");
		// hdfs.rmr("/wgc/files");
		// hdfs.download("/wgc/��3��windows �� hadoop+eclipse �����. docx", "c:\\");
		System.out.println("success!");
	}

	// ���� Hadoop �����ļ�
	public static JobConf config() throws Exception {
		FileSystem fs = null;
		JobConf conf = new JobConf(HdfsDao.class);
		conf.setJobName("HdfsDao");
		// conf.addResource("classpath:/hadoop/core-site.xml");
		// conf.addResource("classpath:/hadoop/hdfs-site.xml");
		// conf.addResource("classpath:/hadoop/mapred-site.xml");
		// һ��ʹ��ip��ַ����Լ����ӳ���ַ���ܻ����
		conf.set("fs.defaultFS", HDFS);
		/**
		 * �������ȼ��� 1���ͻ��˴��������õ�ֵ 2��classpath�µ��û��Զ��������ļ� 3��Ȼ���Ƿ�������Ĭ������
		 */
		conf.set("dfs.replication", "3");

		// ��ȡһ��hdfs�ķ��ʿͻ��ˣ����ݲ��������ʵ��Ӧ����DistributedFileSystem��ʵ��
		// fs = FileSystem.get(conf);

		// �������ȥ��ȡ����conf����Ϳ��Բ�Ҫ��"fs.defaultFS"���������ң�����ͻ��˵���ݱ�ʶ�Ѿ���root�û�
		fs = FileSystem.get(new URI(HDFS), conf, "root");
		return conf;
	}

	// �ڸ�Ŀ¼�´����ļ���
	public void mkdirs(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		if (!fs.exists(path)) {
			fs.mkdirs(path);
			System.out.println("Create:" + folder);
		}
		fs.close();
	}

	// ĳ���ļ��е��ļ��б�
	public FileStatus[] ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FileStatus[] list = fs.listStatus(path);
		System.out.println("ls:" + folder);
		System.out.println("==========================================================");
		if (list != null)
			for (FileStatus f : list) {
				// System.out.printf("name: %s, folder: %s, size: %d\n",
				// f.getPath(), f.isDir(), f.getLen());
				System.out.printf("%s, folder: %s, ��С: %dK\n", f.getPath().getName(), (f.isDir() ? "Ŀ¼" : "�ļ�"),
						f.getLen() / 1024);
			}
		System.out.println("==========================================================");
		fs.close();
		return list;
	}

	public void copyFile(String local, String remote) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		// remote---/ �û� / �û��µ��ļ����ļ���
		fs.copyFromLocalFile(new Path(local), new Path(remote));
		System.out.println("copy from:" + local + "to" + remote);
		fs.close();
	}

	// ɾ���ļ����ļ���
	public void rmr(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.deleteOnExit(path);
		System.out.println("Delete:" + folder);
		fs.close();
	}

	// �����ļ�������ϵͳ
	@Test
	public void download(String remote, String local) throws IOException {
		Path path = new Path(remote);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyToLocalFile(path, new Path(local));
		System.out.println("download: from" + remote + "to" + local);
		fs.close();
	}
}

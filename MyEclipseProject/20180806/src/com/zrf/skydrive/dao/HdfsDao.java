
/**
* @Title: HdfsDao.java
* @Package com.zrf.skydrive.dao
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��6��
* @version V1.0  
*/

package com.zrf.skydrive.dao;

import java.io.IOException;
import java.net.URI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapred.JobConf;

public class HdfsDao {

	private final Log log = LogFactory.getLog(HdfsDao.class);
	// HDFS���ʵ�ַ
	private static final String HDFS_PATH = "hdfs://192.168.1.128:8020";

	public HdfsDao(Configuration conf) {
		this(HDFS_PATH, conf);
	}

	public HdfsDao(String hdfs, Configuration conf) {
		this.hdfsPath = hdfs;
		this.conf = conf;
	}

	// hdfs·��
	private String hdfsPath;
	// Hadoopϵͳ����
	private Configuration conf;

	// ��������
	public static void main(String[] args) throws IOException {
		JobConf conf = getConfig();
		HdfsDao hdfs = new HdfsDao(conf);
		hdfs.ls("hdfs://192.168.1.128:8020/myDir");
	}

	// ����Hadoop�����ļ�
	public static JobConf getConfig() {
		JobConf conf = new JobConf(HdfsDao.class);
		conf.setJobName("HdfsDao");
		// һ��ʹ��ip��ַ����Լ����ӳ���ַ���ܻ����
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * �������ȼ��� 1���ͻ��˴��������õ�ֵ 2��classpath�µ��û��Զ��������ļ� 3��Ȼ���Ƿ�������Ĭ������
		 */
		conf.set("dfs.replication", "3");
		return conf;
	}

	// �ڸ�Ŀ¼�´����ļ���
	public void mkdirs(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		if (!fs.exists(path)) {
			fs.mkdirs(path);
			log.debug("Create: " + folder);
		}
		fs.close();
	}

	// ĳ���ļ��е��ļ��б�
	public FileStatus[] ls(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		FileStatus[] list = fs.listStatus(path);
		log.debug("ls: " + folder);
		log.debug("==========================================================");
		if (list != null)
			for (FileStatus f : list) {
				log.debug(f.getPath().getName() + ", folder: " + (f.isDirectory() ? "Ŀ¼" : "�ļ�") + ", ��С: "
						+ f.getLen() / 1024 + "\n");
			}
		log.debug("==========================================================");
		fs.close();

		return list;
	}

	public void copyFile(String local, String remote) throws IOException {
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		// remote---/�û�/�û��µ��ļ����ļ���
		fs.copyFromLocalFile(new Path(local), new Path(remote));
		log.debug("copy from: " + local + " to " + remote);
		fs.close();
	}

	// ɾ���ļ����ļ���
	public void rmr(String folder) throws IOException {
		Path path = new Path(folder);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.deleteOnExit(path);
		log.debug("Delete: " + folder);
		fs.close();
	}

	// �����ļ�������ϵͳ
	public void download(String remote, String local) throws IOException {
		Path path = new Path(remote);
		FileSystem fs = FileSystem.get(URI.create(hdfsPath), conf);
		fs.copyToLocalFile(path, new Path(local));
		log.debug("download: from" + remote + " to " + local);
		fs.close();
	}

}

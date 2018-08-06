
/**
* @Title: HdfsClient.java
* @Package com.zrf.ex
* @Description: Hdfsʹ��
* @author ZRF
* @date 2018��8��1��
* @version V1.0  
*/

package com.zrf.ex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.BlockLocation;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HdfsClient {

	FileSystem fs = null;

	@Before
	public void init() throws Exception {

		// ����һ�����ò�����������һ������������Ҫ���ʵ�hdfs��URI
		// �Ӷ�FileSystem.get()������֪��Ӧ����ȥ����һ������hdfs�ļ�ϵͳ�Ŀͻ��ˣ��Լ�hdfs�ķ��ʵ�ַ
		// new Configuration();��ʱ�����ͻ�ȥ����jar���е�hdfs-default.xml
		// Ȼ���ټ���classpath�µ�hdfs-site.xml
		Configuration conf = new Configuration();
		//һ��ʹ��ip��ַ����Լ����ӳ���ַ���ܻ����
		conf.set("fs.defaultFS", "hdfs://192.168.1.128:8020");
		/**
		 * �������ȼ��� 1���ͻ��˴��������õ�ֵ 2��classpath�µ��û��Զ��������ļ� 3��Ȼ���Ƿ�������Ĭ������
		 */
		conf.set("dfs.replication", "3");

		// ��ȡһ��hdfs�ķ��ʿͻ��ˣ����ݲ��������ʵ��Ӧ����DistributedFileSystem��ʵ��
		// fs = FileSystem.get(conf);

		// �������ȥ��ȡ����conf����Ϳ��Բ�Ҫ��"fs.defaultFS"���������ң�����ͻ��˵���ݱ�ʶ�Ѿ���root�û�
		fs = FileSystem.get(new URI("hdfs://192.168.1.128:8020"), conf, "root");

	}

	/**
	 * ��hdfs�ϴ��ļ�
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddFileToHdfs() throws Exception {

		// Ҫ�ϴ����ļ����ڵı���·��
		Path src = new Path("d:/autotest.txt");
		// Ҫ�ϴ���hdfs��Ŀ��·��
		Path dst = new Path("hdfs://192.168.1.128:8020/myDir");
		fs.copyFromLocalFile(src, dst);
		fs.close();
	}

	@After
	public void close() {
		try {
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��hdfs�и����ļ��������ļ�ϵͳ
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 */
	@Test
	public void testDownloadFileToLocal() {
		try {
			fs.copyToLocalFile(new Path("/myDir/hello.txt"), new Path("D:/"));
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMkdirAndDeleteAndRename() throws IllegalArgumentException, IOException {

		// ����Ŀ¼
		fs.mkdirs(new Path("/a1/b1/c1"));

		// ɾ���ļ��� ������Ƿǿ��ļ��У�����2�����ֵtrue
		fs.delete(new Path("/a2"), true);

		// �������ļ����ļ���
		fs.rename(new Path("/a1"), new Path("/aaa"));

	}

	/**
	 * �鿴Ŀ¼��Ϣ��ֻ��ʾ�ļ�
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testListFiles() throws FileNotFoundException, IllegalArgumentException, IOException {

		// ˼����Ϊʲô���ص�������������List֮�������
		RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

		while (listFiles.hasNext()) {
			LocatedFileStatus fileStatus = listFiles.next();
			System.out.println(fileStatus.getPath().getName());
			System.out.println(fileStatus.getBlockSize());
			System.out.println(fileStatus.getPermission());
			System.out.println(fileStatus.getLen());
			BlockLocation[] blockLocations = fileStatus.getBlockLocations();
			for (BlockLocation bl : blockLocations) {
				System.out.println("block-length:" + bl.getLength() + "--" + "block-offset:" + bl.getOffset());
				String[] hosts = bl.getHosts();
				for (String host : hosts) {
					System.out.println(host);
				}
			}
			System.out.println("--------------Ϊangelababy��ӡ�ķָ���--------------");
		}
	}

	/**
	 * �鿴�ļ����ļ�����Ϣ
	 * 
	 * @throws IOException
	 * @throws IllegalArgumentException
	 * @throws FileNotFoundException
	 */
	@Test
	public void testListAll() throws FileNotFoundException, IllegalArgumentException, IOException {

		FileStatus[] listStatus = fs.listStatus(new Path("/"));

		String flag = "d--             ";
		for (FileStatus fstatus : listStatus) {
			if (fstatus.isFile())
				flag = "f--         ";
			System.out.println(flag + fstatus.getPath().getName());
		}
	}
}

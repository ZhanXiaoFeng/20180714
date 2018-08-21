
/**
* @Title: TestDistributedCache.java
* @Package com.zrf.ex.distributedCache
* @Description: Hadoop�����ʹ��
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.distributedCache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class TestDistributedCache {
	static class TestDistributedCacheMapper extends Mapper<LongWritable, Text, Text, Text> {
		FileReader in = null;
		BufferedReader reader = null;
		HashMap<String, String> b_tab = new HashMap<String, String>();
		String localpath = null;
		String uirpath = null;

		// ����map�����ʼ����ʱ�����һ��
		@Override
		protected void setup(Context context) throws IOException, InterruptedException {
			// ͨ���⼸�������Ի�ȡ��cache file�ı��ؾ���·����������֤��
			Path[] files = context.getLocalCacheFiles();
			localpath = files[0].toString();
			URI[] cacheFiles = context.getCacheFiles();

			// �����ļ����÷�����ֱ���ñ���IO����ȡ
			// �������������map task���ڻ������ع���Ŀ¼�е�һ��С�ļ�
			in = new FileReader("b.txt");
			reader = new BufferedReader(in);
			String line = null;
			while (null != (line = reader.readLine())) {

				String[] fields = line.split(",");
				b_tab.put(fields[0], fields[1]);

			}
			IOUtils.closeStream(reader);
			IOUtils.closeStream(in);

		}

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

			// ������������map task���������һ����Ƭ���ݣ���hdfs�ϣ�
			String[] fields = value.toString().split("\t");

			String a_itemid = fields[0];
			String a_amount = fields[1];

			String b_name = b_tab.get(a_itemid);

			// ������ 1001 98.9 banan
			context.write(new Text(a_itemid), new Text(a_amount + "\t" + ":" + localpath + "\t" + b_name));

		}
	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(TestDistributedCache.class);

		job.setMapperClass(TestDistributedCacheMapper.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);

		// ������������������Ҫ�������������·��
		FileInputFormat.setInputPaths(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		// ����Ҫreducer
		job.setNumReduceTasks(0);
		// �ַ�һ���ļ���task���̵Ĺ���Ŀ¼
		job.addCacheFile(new URI("hdfs://hadoop-server01:9000/cachefile/b.txt"));

		// �ַ�һ���鵵�ļ���task���̵Ĺ���Ŀ¼
		// job.addArchiveToClassPath(archive);

		// �ַ�jar����task�ڵ��classpath��
		// job.addFileToClassPath(jarfile);

		job.waitForCompletion(true);
	}
}

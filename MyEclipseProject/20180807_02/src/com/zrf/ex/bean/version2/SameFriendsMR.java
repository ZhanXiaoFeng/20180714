
/**
* @Title: SameFriendsMR.java
* @Package com.zrf.ex.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.bean.version2;

import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.jobcontrol.ControlledJob;
import org.apache.hadoop.mapreduce.lib.jobcontrol.JobControl;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 *
 */
public class SameFriendsMR {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		// conf.addResource("hdfs-site.xml");//ʹ�������ļ�
		// System.setProperty("HADOOP_USER_NAME", "hadoop");//ʹ�ü�Ⱥ
		/////////////////// ��һ��////////////////////////
		FileSystem fs = FileSystem.get(conf);// Ĭ��ʹ�ñ���

		Job job = Job.getInstance(conf);
		job.setJarByClass(SameFriendsMR.class);
		job.setMapperClass(SameFriendsMR_Mapper.class);
		job.setReducerClass(SameFriendsMR_Reducer.class);

		//job.setMapOutputKeyClass(Text.class);
		//job.setMapOutputValueClass(Text.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		Path inputPath = new Path("D:/other/friend.txt");
		Path outputPath = new Path("D:/other/friend");
		if (fs.exists(inputPath)) {
			fs.delete(outputPath, true);
		}

		FileInputFormat.setInputPaths(job, inputPath);
		FileOutputFormat.setOutputPath(job, outputPath);
		//////////////////// �ڶ���//////////////////////////////////
		FileSystem fs2 = FileSystem.get(conf);// Ĭ��ʹ�ñ���

		Job job2 = Job.getInstance(conf);
		job2.setJarByClass(SameFriendsMR.class);
		job2.setMapperClass(SameFriends2MR_Mapper.class);
		job2.setReducerClass(SameFriends2MR_Reducer.class);

		//job2.setMapOutputKeyClass(Text.class);
		//job2.setMapOutputValueClass(Text.class);
		job2.setOutputKeyClass(Text.class);
		job2.setOutputValueClass(Text.class);

		Path inputPath2 = new Path("D:/other/friend");
		Path outputPath2 = new Path("D:/other/friend_1");
		if (fs2.exists(inputPath2)) {
			fs2.delete(outputPath2, true);
		}

		FileInputFormat.setInputPaths(job2, inputPath2);
		FileOutputFormat.setOutputPath(job2, outputPath2);

		// ����jobcontrol����2��MapReduce����
		ControlledJob aJob = new ControlledJob(job.getConfiguration());
		ControlledJob bJob = new ControlledJob(job2.getConfiguration());

		aJob.setJob(job);
		bJob.setJob(job2);
		bJob.addDependingJob(aJob);// ָ��������ϵ

		JobControl jc = new JobControl("jcF");
		jc.addJob(aJob);
		jc.addJob(bJob);

		Thread thread = new Thread(jc);
		thread.start();
		while (!jc.allFinished()) {
			thread.sleep(1000);
		}
		jc.stop();
	}

	/////////////////////////////// ��һ��/////////////////////////////////////////
	public static class SameFriendsMR_Mapper extends Mapper<LongWritable, Text, Text, Text> {
		Text kout = new Text();
		Text valueout = new Text();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// A:B,C,D,F,E,O
			String[] reads = value.toString().trim().split(":");
			// ���û�Ϊvalueֵ������Ϊkeyֵ����ȡ��ĳ�û�Ϊ��ͬ���ѵ���
			String vv = reads[0];
			valueout.set(vv);
			String[] friends = reads[1].split(",");
			for (int i = 0; i < friends.length; i++) {
				String kk = friends[i];
				kout.set(kk);
				context.write(kout, valueout);
			}
		}
	}

	public static class SameFriendsMR_Reducer extends Reducer<Text, Text, Text, Text> {
		Text kout = new Text();
		Text valueout = new Text();

		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {
			// ���û���ͬ���ѵ����������
			StringBuilder sb = new StringBuilder();
			for (Text text : values) {
				sb.append(text.toString()).append(",");
			}
			String vv = sb.substring(0, sb.length() - 1);
			valueout.set(vv);
			context.write(key, valueout);
		}

	}

	////////////////////////////////////// �ڶ���///////////////////////////////////////////////////////////
	public static class SameFriends2MR_Mapper extends Mapper<LongWritable, Text, Text, Text> {
		Text kout = new Text();
		Text valueout = new Text();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			// A F,I,O,K,G,D,C,H,B
			// ����˼��F,I,O,K,G,D,C,H,B�Ĺ�ͬ����ΪA,�ڶ���ִ����ȡ��������,AΪvalue��������Ϊkey
			String[] reads = value.toString().trim().split("\t");
			// AΪvalue
			String vv = reads[0];
			valueout.set(vv);
			// ���������Ѷԣ�Ϊ�˷�ֹ�ظ�����Ҫ�Ժ��ѽ�������
			String[] friends = reads[1].split(",");
			Arrays.sort(friends);
			// ʹ������ѭ����Ѱ��A-B�Ⱥ��Ѷ����
			for (int i = 0; i < friends.length - 1; i++) {
				for (int j = i + 1; j < friends.length; j++) {
					String kk = friends[i] + "-" + friends[j];
					kout.set(kk);
					context.write(kout, valueout);
				}
			}
		}
	}

	public static class SameFriends2MR_Reducer extends Reducer<Text, Text, Text, Text> {
		Text kout = new Text();
		Text valueout = new Text();

		@Override
		protected void reduce(Text key, Iterable<Text> values, Context context)
				throws IOException, InterruptedException {
			// ���Ѷ��������
			StringBuilder sb = new StringBuilder();
			for (Text text : values) {
				sb.append(text.toString()).append(",");
			}
			String vv = sb.substring(0, sb.length() - 1);
			valueout.set(vv);
			context.write(key, valueout);
		}

	}
}

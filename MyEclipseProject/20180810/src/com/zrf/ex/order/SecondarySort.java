
/**
* @Title: SecondarySort.java
* @Package com.zrf.ex.order
* @Description: ����secondarysort�������ÿ��item����������ļ�¼
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.order;

import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import com.zrf.ex.order.bean.OrderBean;

/**
 * Order_0000001,Pdt_01,222.8 Order_0000001,Pdt_05,25.8
 * Order_0000002,Pdt_05,325.8 Order_0000002,Pdt_03,522.8
 * Order_0000002,Pdt_04,122.4 Order_0000003,Pdt_01,222.8
 */
public class SecondarySort {

	static class SecondarySortMapper extends Mapper<LongWritable, Text, OrderBean, NullWritable> {

		OrderBean bean = new OrderBean();

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
			String line = value.toString();
			String[] fields = StringUtils.split(line, ",");
			//��ʽ��̷�
			bean.setItemId(new Text(fields[0])).setAmount(new DoubleWritable(Double.parseDouble(fields[2])));
			//bean.set(new Text(fields[0]), new DoubleWritable(Double.parseDouble(fields[2])));
			context.write(bean, NullWritable.get());
		}
	}

	static class SecondarySortReducer extends Reducer<OrderBean, NullWritable, OrderBean, NullWritable> {

		// ����reduceʱ����ͬid������bean�Ѿ�������һ�飬�ҽ�������Ǹ����ڵ�һλ
		// ��������groupingcomparator�Ժ������յ���kv���ݾ��ǣ� <1001 87.6>,null <1001
		// 76.5>,null ....
		// ��ʱ��reduce�����еĲ���key��������kv���еĵ�һ��kv��key��<1001 87.6>
		// Ҫ���ͬһ��item�����ж�������������һ������ֻҪ������key
		@Override
		protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context)
				throws IOException, InterruptedException {
			context.write(key, NullWritable.get());
		}
	}

	public static void main(String[] args) throws Exception {

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);

		job.setJarByClass(SecondarySort.class);

		job.setMapperClass(SecondarySortMapper.class);
		//job.setMapOutputKeyClass(OrderBean.class);
		//job.setMapOutputValueClass(NullWritable.class);
		
		job.setReducerClass(SecondarySortReducer.class);
		job.setOutputKeyClass(OrderBean.class);
		job.setOutputValueClass(NullWritable.class);

		FileInputFormat.setInputPaths(job, new Path("d:/other/orders.txt"));
		FileOutputFormat.setOutputPath(job, new Path("d:/other/order2"));

		// �ڴ������Զ����Groupingcomparator��
		job.setGroupingComparatorClass(ItemidGroupingComparator.class);
		// �ڴ������Զ����partitioner��
		job.setPartitionerClass(ItemIdPartitioner.class);
		// ����Reduce������,���÷��������ձ�����ɵ��ļ�����
		job.setNumReduceTasks(3);
		job.waitForCompletion(true);
	}
}

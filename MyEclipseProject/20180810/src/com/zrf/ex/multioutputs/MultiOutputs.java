
/**
* @Title: MultiOutputs.java
* @Package com.zrf.ex.multioutputs
* @Description: ��������ʹ��
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.multioutputs;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MultiOutputs {
	// ͨ��ö����ʽ�����Զ��������
	enum MyCounter {
		MALFORORMED, NORMAL
	}

	static class CommaMapper extends Mapper<LongWritable, Text, Text, LongWritable> {

		@Override
		protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

			String[] words = value.toString().split(",");

			for (String word : words) {
				context.write(new Text(word), new LongWritable(1));
			}
			// ��ö�ٶ�����Զ����������1
			context.getCounter(MyCounter.MALFORORMED).increment(1);
			// ͨ����̬�����Զ����������1
			context.getCounter("counterGroupa", "countera").increment(1);
		}

	}
}

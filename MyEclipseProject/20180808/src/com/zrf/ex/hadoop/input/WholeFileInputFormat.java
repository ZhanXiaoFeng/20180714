
    /**
    * @Title: WholeFileInputFormat.java
    * @Package com.zrf.ex.hadoop.input
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author ZRF
    * @date 2018��8��8��
    * @version V1.0  
    */
    
package com.zrf.ex.hadoop.input;

import java.io.IOException;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.JobContext;
import org.apache.hadoop.mapreduce.RecordReader;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class WholeFileInputFormat extends FileInputFormat<NullWritable, BytesWritable> {
	// ����ÿ��С�ļ����ɷ�Ƭ,��֤һ��С�ļ�����һ��key-value��ֵ��
	@Override
	protected boolean isSplitable(JobContext context, Path file) {
		return false;
	}

	@Override
	public RecordReader<NullWritable, BytesWritable> createRecordReader(InputSplit split, TaskAttemptContext context)
			throws IOException, InterruptedException {
		WholeFileRecordReader reader = new WholeFileRecordReader();
		reader.initialize(split, context);
		return reader;
	}
}

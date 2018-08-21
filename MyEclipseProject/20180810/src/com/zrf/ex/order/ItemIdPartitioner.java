
/**
* @Title: ItemIdPartitioner.java
* @Package com.zrf.ex.order
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.order;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;
import com.zrf.ex.order.bean.OrderBean;

public class ItemIdPartitioner extends Partitioner<OrderBean, NullWritable> {
	@Override
	public int getPartition(OrderBean bean, NullWritable value, int numReduceTasks) {
		// ��ͬid�Ķ���bean���ᷢ����ͬ��partition
		// ���ң������ķ��������ǻ���û����õ�reduce task������һ��
		// (bean.getItemid().hashCode() & Integer.MAX_VALUE)ת��Ϊ����
		return (bean.getItemid().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
	}
}

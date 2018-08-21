
/**
* @Title: ItemidGroupingComparator.java
* @Package com.zrf.ex.order
* @Description: ���ڿ���shuffle������reduce�˶�kv�Եľۺ��߼�
* @author ZRF
* @date 2018��8��10��
* @version V1.0  
*/

package com.zrf.ex.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;
import com.zrf.ex.order.bean.OrderBean;

public class ItemidGroupingComparator extends WritableComparator {

	protected ItemidGroupingComparator() {
		super(OrderBean.class, true);
	}

	@Override
	public int compare(WritableComparable a, WritableComparable b) {
		OrderBean abean = (OrderBean) a;
		OrderBean bbean = (OrderBean) b;
		// ��item_id��ͬ��bean����Ϊ��ͬ���Ӷ��ۺ�Ϊһ��
		return abean.getItemid().compareTo(bbean.getItemid());
	}
}

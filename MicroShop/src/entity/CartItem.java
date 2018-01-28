package entity;

import java.math.BigDecimal;



/**
 * ���ﳵģ�鹺����Ŀ��
 * @author tiger
 *
 */
public class CartItem {
	
	private Goods goods;	//��Ʒ
	private int count;			//����
	private double subtotal;	//С��
	
	/*
	 * ����С��
	 *   >����*����
	 */
	public double getSubtotal() {
		/*
		 * Ϊ�˲���ʧ����--ʹ��BigDecimals
		 *   ע�⣺����������String����
		 */
		BigDecimal bd1 = new BigDecimal(count + "");
		BigDecimal bd2 = new BigDecimal(goods.getPrice2() + "");
		BigDecimal bd3 = bd1.multiply(bd2);
		return bd3.doubleValue();
	}
	
	
	public Goods getGoods() {
		return goods;
	}


	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}

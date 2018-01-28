package entity;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * ���ﳵģ�鹺�ﳵ��
 * @author tiger
 *
 */
public class Cart {
	
	// ��Ŀ���ϣ�map���ϣ������Ƴ���key��pid��value��CartItem
	private Map<Integer,CartItem> map = new LinkedHashMap<Integer,CartItem>();
		
	// �õ�CartItem���ϣ�������ʾ
	/*public Collection<CartItem> getCartItems() {
		return map.values();
	}
	*/
	
	
	
	//�ܼ�
	private double total;
	
	public double getTotal() {
		return total;
	}
	
	//���ﳵ����
	//1. ��������Ŀ��ӵ����ﳵ
	public void addCart(CartItem cartItem) {
		// �жϸ�����Ʒ�Ƿ��Ѵ���
		// ���ڣ���������С���ۼ�(С���Զ��ۼ�),�ۼ��ܼ�
		// �����ڣ��������Ŀ���ۼ��ܼ�
		Integer gid = cartItem.getGoods().getId();
		
	if (map.containsKey(gid)) {
			CartItem _cartItem = map.get(gid);							// �õ��Ѵ�����Ŀ
			int count = cartItem.getCount() + _cartItem.getCount();  			// �ۼ�����
			_cartItem.setCount(count);
		} else {
			map.put(gid, cartItem);
		}
		
		/* if(map.containsKey(gid)) {//�ж�ԭ�������Ƿ���ڸ���Ŀ
	            CartItem _cartItem = map.get(gid);//����ԭ��Ŀ
	            _cartItem.setCount(_cartItem.getCount() + cartItem.getCount());//��������Ŀ������Ϊ�����Լ�����+����Ŀ������
	            map.put(cartItem.getGoods().getId(), _cartItem);
	        } else {
	            map.put(cartItem.getGoods().getId(),cartItem);
	        }*/
		total += cartItem.getSubtotal();
	}
	
	
	//2. ɾ��������Ŀ
	public void removeCartItem(Integer gid) {
		CartItem cartItem = map.remove(gid);	// ɾ����Ŀ
		total -= cartItem.getSubtotal();			// ��ȥɾ����Ŀ��С��
	}
	
	//3. ������ﳵ
	public void clearCart() {
		map.clear();							// ������ﳵ
		total = 0;									//�ܼ�����Ϊ0
	}
	
	public Collection<CartItem> getCartItems() {
        return map.values();
    }
}

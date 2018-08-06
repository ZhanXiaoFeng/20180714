
/**
* @Title: MyClient.java
* @Package com.zrf.ex.zookeeper
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��6��
* @version V1.0  
*/

package com.zrf.ex.zookeeper;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.Before;
import org.junit.Test;

/**
 * @ClassName: MyClient
 * @Description: zookeeper��ʹ�ò���
 * @author ZRF
 * @date 2018��8��6��
 */

public class MyClient {

	private ZooKeeper zk;

	// ��ʼ�����Ӳ���
	@Before
	public void init() throws IOException {
		String con = "hadoop1:2181";
		int timeout = 300000;
		Watcher watcher = System.out::println;
		zk=new ZooKeeper(con, timeout, watcher);
	}

	@Test
	public void testCreate() {
		try {
			String str = zk.create("/com", "package com".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
			System.out.println(str);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGet(){
		byte[] arr = null;
		try {
			arr = zk.getData("/com", true, null);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(new String(arr));
	}
	@Test
	public void testSet(){
		Stat stat =null;
		try {
			stat = zk.setData("/com", "hello".getBytes(), 0);
		} catch (KeeperException | InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(stat);
	}
}

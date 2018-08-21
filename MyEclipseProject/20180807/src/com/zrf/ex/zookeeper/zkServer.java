
/**
* @Title: zkServer.java
* @Package com.zrf.ex.zookeeper
* @Description: zookeeper��������
* @author ZRF
* @date 2018��8��7��
* @version V1.0  
*/

package com.zrf.ex.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * @ClassName: zkServer
 * @Description: zookeeper��������
 * @author ZRF
 * @date 2018��8��7��
 */

public class zkServer {
//hadoop jar zk.jar com.zrf.ex.zookeeper.zkServer 192.168.1.128
	private String groupNode = "sgroup";
	private String subNode = "sub";

	/**
	 * ����zookeeper
	 * 
	 * @param address
	 *            server�ĵ�ַ
	 */
	public void connectZookeeper(String address) throws Exception {
		ZooKeeper zk = new ZooKeeper("hadoop1:2181,hadoop2:2181,hadoop3:2181", 5000, new Watcher() {
			public void process(WatchedEvent event) {
				// ��������
			}
		});
		// ��"/sgroup"�´����ӽڵ�
		// �ӽڵ����������ΪEPHEMERAL_SEQUENTIAL, ��������һ����ʱ�ڵ�, �����ӽڵ�����ƺ������һ�����ֺ�׺
		// ��server�ĵ�ַ���ݹ������´������ӽڵ���
		String createdPath = zk.create("/" + groupNode + "/" + subNode, address.getBytes("utf-8"), Ids.OPEN_ACL_UNSAFE,
				CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println("create: " + createdPath);
	}

	/**
	 * server�Ĺ����߼�д����������� �˴������κδ���, ֻ��server sleep
	 */
	public void handle() throws InterruptedException {
		Thread.sleep(Long.MAX_VALUE);
	}

	public static void main(String[] args) throws Exception {
		// �ڲ�����ָ��server�ĵ�ַ
		if (args.length == 0) {
			System.err.println("The first argument must be server address");
			System.exit(1);
		}

		zkServer as = new zkServer();
		as.connectZookeeper(args[0]);
		as.handle();
	}
}
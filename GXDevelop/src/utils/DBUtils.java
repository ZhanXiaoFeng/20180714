package utils;

import java.io.IOException;
import java.io.Reader;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * DBUtils�����࣬���ڶ�ȡ�����ļ��ͻ�ȡ Session����
 * 
 * @author ZRF
 */
public class DBUtils {

	private static SqlSessionFactory factory;
	private static SqlSession session;

	static {
		try {
			// ��ȡ�����ļ�
			Reader reader = Resources.getResourceAsReader("Mybatis-config.xml");
			// ����sessionFactory����
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���session
	 * 
	 * @return
	 */
	public static SqlSession getSession(boolean flag) {
		return factory.openSession(flag);
	}

	/**
	 * �����ύ
	 * 
	 * @param session
	 */
	public void commit() {
		if (session != null) {
			session.commit();
		}
	}

	/**
	 * ����ع�
	 * 
	 * @param session
	 */
	public void rollback() {
		if (session != null) {
			session.rollback();
		}
	}

	/**
	 * �ر�session
	 * 
	 * @param session
	 */
	public static void close() {
		if (session != null) {
			session.close();
		}
	}

	public static void main(String[] args) {
		DBUtils db = new DBUtils();
		System.out.println(db);
	}
}

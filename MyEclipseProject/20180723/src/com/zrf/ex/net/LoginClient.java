package com.zrf.ex.net;

import java.net.*;
import java.io.*;

public class LoginClient {
	public static void main(String[] args) {
		try {
			// �����ͻ���Socket���ӣ�ָ����������λ���Լ��˿�
			Socket socket = new Socket("localhost", 8800);
			// �����������
			OutputStream os = socket.getOutputStream();
			String info = null;
			/*
			 * System.in-->InputStream new InputStreamReader(...)���ֽ���ת��Ϊ�ַ���
			 */

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while ((info = br.readLine()) != null) {
				os.write((info + "\n").getBytes());
			}
			// �ر���Դ
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

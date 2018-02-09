/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.bankCard.action;

import java.net.URLEncoder;

import com.bankCard.utils.Base64Util;
import com.bankCard.utils.FileUtil;
import com.bankCard.utils.HttpUtil;

/**
 * ���п�ʶ��
 */
public class bankQueryAtion {

	public static String getIDInfo(String filePath) {
		// ���п�ʶ��url
		String result = null;
		String bankcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard";
		// ����ͼƬ·��
		// String filePath = "c:\\images\\zhaoshang.png";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AccessTokenAction.getAuth();
			result = HttpUtil.post(bankcardIdentificate, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * ��Ҫ��ʾ���������蹤���� FileUtil,Base64Util,HttpUtil,GsonUtils���
	 * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
	 * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
	 * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
	 * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 ����
	 */
	public static void main(String[] args) {
		// ���п�ʶ��url
		String bankcardIdentificate = "https://aip.baidubce.com/rest/2.0/ocr/v1/bankcard";
		// ����ͼƬ·��
		String filePath = "c:\\images\\zhaoshang.png";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AccessTokenAction.getAuth();
			String result = HttpUtil.post(bankcardIdentificate, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

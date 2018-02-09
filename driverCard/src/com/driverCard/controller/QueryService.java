package com.driverCard.controller;
/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */

import java.net.URLEncoder;

import com.driverCard.utils.Base64Util;
import com.driverCard.utils.FileUtil;
import com.driverCard.utils.HttpUtil;

/**
 * OCR ͨ��ʶ��
 */
public class QueryService {

	public static String getIDInfo(String filePath) {
		// ͨ��ʶ��url
		String result = null;
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/driving_license";
		// ����ͼƬ·��
		// String filePath = "#####�����ļ�·��#####";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AuthService.getAuth();
			result = HttpUtil.post(otherHost, accessToken, params);
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
		// ͨ��ʶ��url
		String otherHost = "https://aip.baidubce.com/rest/2.0/ocr/v1/driving_license";
		// ����ͼƬ·��
		String filePath = "#####�����ļ�·��#####";
		try {
			byte[] imgData = FileUtil.readFileByBytes(filePath);
			String imgStr = Base64Util.encode(imgData);
			String params = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(imgStr, "UTF-8");
			/**
			 * ���ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
			 */
			String accessToken = AuthService.getAuth();
			String result = HttpUtil.post(otherHost, accessToken, params);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

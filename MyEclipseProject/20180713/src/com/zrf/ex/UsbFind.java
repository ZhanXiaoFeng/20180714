package com.zrf.ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

public class UsbFind {
	private Logger logger;
	// ��ʼ������飬ֻҪʹ�ù��캯��������ִ�иô����
	{
		logger = Logger.getLogger(this.getClass().getSimpleName());
	}

	public List<String> getAllLines(Path path) {
		List<String> allLines = null;
		try {
			allLines = Files.readAllLines(path);
		} catch (IOException e) {
			this.logger.log(Level.SEVERE, e.getMessage(), e);
		}
		return allLines;
	}

	public List<String> fillter(List<String> list) {
		List<String> newList = new ArrayList<>(list.size());
		list.forEach((line) -> {
			String[] arr = line.split("|");// ���и�Ϊ����
			// ���Դ�Сд���ұ���
			if (StringUtils.containsIgnoreCase(line, "usb")) {
				newList.add(line);
			}
		});
		return newList;
	}

	/******
	 * ����������ۺϰ汾
	 * 
	 * @throws IOException
	 ******/
	public Object[] oneRow(Path path) throws IOException {
		//return Files.lines(path).filter((s) -> StringUtils.containsIgnoreCase(s.split("\\|")[2], "usb")).toArray();
		return Files.lines(path).filter(s->StringUtils.containsIgnoreCase(s.split("\\|")[2], "usb")).toArray(String[]::new);
	}

}

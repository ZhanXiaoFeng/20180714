
/**
* @Title: ExcelHead.java
* @Package com.zrf.ex.excel.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��4��
* @version V1.0  
*/

package com.zrf.ex.excel.bean;

import java.util.List;
import java.util.Map;

/**
 * @ClassName: ExcelHead
 * @Description: excelͷ��Ϣ
 * @author ZRF
 * @date 2018��8��4��
 */

public class ExcelHead {
	/**
	 * ����Ϣ
	 */
	private List<ExcelColumn> columns;

	/**
	 * ��Ҫת������
	 */
	private Map<String, Map> columnsConvertMap;

	/**
	 * ͷ����ռ�õ�����
	 */
	private int rowCount;

	/**
	 * ͷ����ռ�õ�����
	 */
	private int columnCount;

	public List<ExcelColumn> getColumns() {
		return columns;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public void setColumns(List<ExcelColumn> columns) {
		this.columns = columns;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public void setColumnCount(int columnCount) {
		this.columnCount = columnCount;
	}

	public Map<String, Map> getColumnsConvertMap() {
		return columnsConvertMap;
	}

	public void setColumnsConvertMap(Map<String, Map> columnsConvertMap) {
		this.columnsConvertMap = columnsConvertMap;
	}

	@Override
	public String toString() {
		return "ExcelHead [columnCount=" + columnCount + ", columns=" + columns + ", columnsConvertMap="
				+ columnsConvertMap + ", rowCount=" + rowCount + "]";
	}

}

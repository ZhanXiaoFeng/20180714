
/**
* @Title: ExcelColumn.java
* @Package com.zrf.ex.excel.bean
* @Description: TODO(��һ�仰�������ļ���ʲô)
* @author ZRF
* @date 2018��8��4��
* @version V1.0  
*/

package com.zrf.ex.excel.bean;

/**
 * @ClassName: ExcelColumn
 * @Description: excel����Ϣ
 * @author ZRF
 * @date 2018��8��4��
 */

public class ExcelColumn {
	/**
	 * ����
	 */
	private int index;

	/**
	 * �ֶ�����
	 */
	private String fieldName;

	/**
	 * �ֶ���ʾ����
	 */
	private String fieldDispName;

	/**
	 * �ֶ�����
	 */
	private int type;

	public ExcelColumn() {

	}

	public ExcelColumn(int index, String fieldName, String fieldDispName) {
		super();
		this.index = index;
		this.fieldName = fieldName;
		this.fieldDispName = fieldDispName;
	}

	public ExcelColumn(int index, String fieldName, String fieldDispName, int type) {
		super();
		this.index = index;
		this.fieldName = fieldName;
		this.fieldDispName = fieldDispName;
		this.type = type;
	}

	public int getIndex() {
		return index;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDispName() {
		return fieldDispName;
	}

	public void setFieldDispName(String fieldDispName) {
		this.fieldDispName = fieldDispName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ExcelColumn [fieldDispName=" + fieldDispName + ", fieldName=" + fieldName + ", index=" + index
				+ ", type=" + type + "]";
	}
}

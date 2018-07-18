
/**
* @Title: Month.java
* @Package com.zrf.ex.meiju
* @Description: �·�ö��
* @author ZRF
* @date 2018��7��18��
* @version V1.0  
*/

package com.zrf.ex.meiju;

/**
 * @ClassName: Month
 * @Description: �·�ö��
 * @author ZRF
 * @date 2018��7��18��
 */

public enum Month {
	// January��February��March��April��May��June��July��August��September��October��November��December
	// һ�¡����¡����¡����¡����¡����¡����¡����¡����¡�ʮ�¡�ʮһ�¡�ʮ����
	// Jan��Feb��Mar��Apr��May��Jun��Jul��Aug��Sep��Oct��Nov��Dec
	January("January", "һ��", "Jan"), February("February", "����", "Feb"), March("March", "����", "Mar"), April("April",
			"����", "Apr"), May("May", "����", "May"), June("June", "����", "Jun"), July("July", "����",
					"Jul"), August("August", "����", "Aug"), September("September", "����", "Sep"), October("October", "ʮ��",
							"Oct"), November("November", "ʮһ��", "Nov"), December("December", "ʮ����", "Dec");

	private String english;
	private String chinese;
	private String simple;

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}

	private Month() {
	}

	private Month(String english, String chinese, String simple) {
		this.english = english;
		this.chinese = chinese;
		this.simple = simple;
	}
}

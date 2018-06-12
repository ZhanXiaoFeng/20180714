package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * ����tb_Category��
 * 
 * @author CETC
 *
 */
public class Category {
	// ���
	private int id;
	// �������
	private String name;
	// �Ƿ��ϼ�
	private boolean display;
	// ������Ϣ
	private String intro;
	// ��Ʒ����
	private List<Pic> Pic = new ArrayList<Pic>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public List<Pic> getPic() {
		return Pic;
	}

	public void setPic(List<Pic> pic) {
		Pic = pic;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String name, boolean display, String intro, List<entity.Pic> pic) {
		super();
		this.name = name;
		this.display = display;
		this.intro = intro;
		Pic = pic;
	}

	public Category(int id, String name, boolean display, String intro, List<entity.Pic> pic) {
		super();
		this.id = id;
		this.name = name;
		this.display = display;
		this.intro = intro;
		Pic = pic;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", display=" + display + ", intro=" + intro + ", Pic=" + Pic
				+ "]";
	}

}
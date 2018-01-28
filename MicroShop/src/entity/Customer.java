package entity;

/**
 * �˿ͱ�tb_customer��
 * 
 * @author CETC
 *
 */
public class Customer {
	// ���
	private int id;
	// ����
	private String username;
	// ����
	private String password;
	// �ǳ�
	private String nickname;
	// ͷ��
	private String imgurl;
	// �绰
	private String phone;
	// ��������
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Customer(int id, String username, String password, String nickname, String imgurl, String phone,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.imgurl = imgurl;
		this.phone = phone;
		this.email = email;
	}
	public Customer(String username, String password, String nickname, String imgurl, String phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nickname = nickname;
		this.imgurl = imgurl;
		this.phone = phone;
		this.email = email;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname
				+ ", imgurl=" + imgurl + ", phone=" + phone + ", email=" + email + "]";
	}
	
	
	

}
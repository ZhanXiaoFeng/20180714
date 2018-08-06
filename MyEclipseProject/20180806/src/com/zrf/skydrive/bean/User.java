
/**
* @Title: User.java
* @Package com.zrf.skydrive.bean
* @Description: Userʵ����
* @author ZRF
* @date 2018��8��6��
* @version V1.0  
*/

package com.zrf.skydrive.bean;

/**
 * @ClassName: User
 * @Description: Userʵ����
 * @author ZRF
 * @date 2018��8��6��
 */

public class User {
	private String id;
	private String username;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public User() {
		super();
	}

	public User(String id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

}

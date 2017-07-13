/**
 * 
 */
package com.model;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年3月7日
 */
public class User extends BaseEntiy{
	private static final long serialVersionUID = 1081633798091381626L;
	
	private int id ;
	private String userName;
	private String password;
	/**
	 * 
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}

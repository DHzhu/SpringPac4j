/**
 * 
 */
package com.dao;

import com.model.User;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年3月7日
 */
public interface UserDao extends SqlMapper{
	public User getUser(User user);
	public User addUser(User user);
}

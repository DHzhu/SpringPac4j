/**
 * 
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.model.User;
import com.service.UserService;

/**
 * @desc  : TODO
 * @author: Zhu
 * @date  : 2017年3月7日
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * @desc : TODO
	 * @date : 2017年3月7日
	 */
	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

	/**
	 * @desc : TODO
	 * @date : 2017年3月7日
	 */
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.getUser(user);
	}

}

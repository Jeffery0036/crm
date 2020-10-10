package com.briup.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.briup.bean.User;

/** 
* @author 作者 lk: 
* @version 创建时间：2020年3月26日 下午4:47:43 
* 类说明 
*/
public interface IUserService {
	
	public User findByName(String name);
	
	/**
	 * 查询User信息
	 * @param roleId
	 * @return
	 */
	Page<User> findUsersByRole(Integer roleId);
	/**
	 * 根据分页查询User的相关信息
	 * @param roleId
	 * @param pageIndex
	 * @return
	 */
	Page<User> findUsersByRole(Integer roleId,Integer pageIndex);
	
	/**
	 * 新增和修改
	 */
	void saveUser(User user);
	
	/**
	 * 通过id找到对应的user
	 */
	User findUserById(Integer id);
	
	/**
	 * 根据id删除用户信息
	 */
	void deleteUserById(Integer id);

	
	//查询所有角色为经理的用户
	List<User> findByJingli(Integer id);
	
}





















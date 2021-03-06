package com.briup.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.briup.bean.Chance;
import com.briup.bean.User;
import com.briup.dao.SalesDao;
import com.briup.dao.UserDao;
import com.briup.service.ISalesService;

/** 
* @author 作者 zcg: 
* @version 创建时间：2020年4月2日 下午2:13:36 
* 类说明 
*/
@Service
public class SalesServiceImpl implements ISalesService{

	@Autowired
	private SalesDao dao;
	@Autowired
	private UserDao userDao;
	
	
	@Override
	public void insertChance(Chance chance, Integer creatorId, Integer handlerId) {
		User creatorUser = userDao.findById(creatorId).get();
		User handlerUser = userDao.findById(handlerId).orElse(null);
		chance.setCreator(creatorUser);
		chance.setHandler(handlerUser);
		
		dao.save(chance);
		
	}


	@Override
	public Page<Chance> getChances(String customer, String address) {
		
		return getChances(0, customer, address);
	}


	@Override
	public Page<Chance> getChances(Integer pageIndex, String customer, String address) {
		if((customer!=null && customer.trim()!="") && (address!=null && address.trim()!="")) {
			//根据客户名字以及区域进行查询
			
			return null;
		}else if(customer!=null && customer.trim()!="") {
			//根据客户名字查询
			
			return null;
		}else if(address!=null && address.trim()!="") {
			//根据区域查询
			
			return null;
		}else {
			//无条件查询，将所有信息查询出来
			
			return null;
		}
	}


	@Override
	public void deleteChance(Integer id) {
		dao.deleteById(id);
	}


	@Override
	public Chance findChanceById(Integer id) {
		return null;
	}

}

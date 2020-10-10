package com.briup.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.briup.bean.Chance;
import com.briup.bean.User;

/** 
* @author 作者 zcg: 
* @version 创建时间：2020年4月2日 下午2:14:12 
* 类说明 
* 		销售商机管理的dao层
*/
public interface SalesDao<T> extends JpaRepository<Chance, Integer>{

	//根据潜在客户名，查询对应的销售商机，并分页
	Page<Chance> findByCustomerLike(String customer,Pageable pageable);
	
	//根据区域名，查询对应的销售商机，并分页
	Page<Chance> findByAddressLike(String address,Pageable pageable);
	
	//根据客户经理，查询对应的销售商机，并分页
	Page<Chance> findByHandler(User handler,Pageable pageable);
	
	//根据客户经理和区域，查询对应的销售商机，并分页
	Page<Chance> findByHandlerAndAddress(User handler,String address,Pageable pageable);
	

}

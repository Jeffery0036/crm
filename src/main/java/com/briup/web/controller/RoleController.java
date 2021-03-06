package com.briup.web.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.briup.bean.Role;
import com.briup.service.IRoleService;

/** 
* @author 作者 zcg: 
* @version 创建时间：2020年3月27日 上午11:50:59 
* 类说明 
* 	角色管理模块
*/
@Controller
public class RoleController {

	//Service层
	@Autowired
	private IRoleService service;
	
	//显示登录进来的第一页数据
	@RequestMapping("toRole")
	public String toRole(HttpSession session) {
		//将数据库中所有角色信息查询出来，保存到session中
		Page<Role> roles = service.findAllRoles();
		session.setAttribute("roles",roles);
//		System.out.println(roles.getTotalPages()+"------");
		return "pages/role";
	}
	
	//新增角色功能
	@RequestMapping("saveRole")
	@ResponseBody
	public String saveRole(Role role) {
		service.saveRole(role);
		if(role.getId()!=null) {
			return "修改成功";
		}else {
			return "添加成功";			
		}
	}
	
	//根据指定页码，查询数据
	@RequestMapping("pageRole")
	public String updatePageRole(Integer pageIndex,HttpSession session) {
		Page<Role> roles = service.findAllRoles(pageIndex);
		session.setAttribute("roles",roles);
		return "pages/role";
	}
	
	//根据id,查询指定的角色
	@RequestMapping("findRoleById")
	@ResponseBody
	public Role findRoleById(Integer id) {
		return service.findRoleById(id);
	}
	
	//根据id,删除指定的角色
	@RequestMapping("deleteRoleById")
	@ResponseBody
	public String deleteRoleById(Integer id) {
		 service.deleteRole(id);
		 return "删除成功";
	}
	
	
	
}























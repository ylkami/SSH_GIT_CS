package com.edu.seiryo.service.imp;

import java.util.List;

import com.edu.seiryo.dao.TypeDao;
import com.edu.seiryo.dao.imp.TypeDaoImp;
import com.edu.seiryo.entity.Type;
import com.edu.seiryo.service.TypeService;
/**
 * TypeService实现类
 * @author GuoYuanZhao
 * @date 2024年6月13日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name TypeServiceImp.java
 * @classname TypeServiceImp
 * @version 1.0
 */
public class TypeServiceImp implements TypeService {
	TypeDao dao = new TypeDaoImp();
	public List<Type> queryAll(){
		return dao.queryAll();
	}
	public List<Type> queryTypeById(int typeId){
		return dao.queryTypeById(typeId);
	}
	public boolean addType(String type,int typeOn){
		return dao.addType(type, typeOn);
	}
	public boolean updateType(String type,int typeOn,int typeId){
		return dao.updateType(type, typeOn, typeId);
	}
	public boolean deleteType(int typeId){
		return dao.deleteType(typeId);
	}
	public List<Type> queryAllOn(){
		return dao.queryAllOn();
	}
}

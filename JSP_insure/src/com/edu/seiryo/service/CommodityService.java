package com.edu.seiryo.service;

import java.util.List;

import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.entity.UserInfo;
/**
 * Commodity业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name CommodityService.java
 * @classname CommodityService
 * @version 1.0
 */
public interface CommodityService {
	public String getAllCommodityJSONString();
	public String getAllCommodityJSONString(String type);
	public String getAllCommoditySortJSONString(UserInfo userInfo);
	public String getAllCommoditySortJSONString(UserInfo userInfo, String type);
	public Commodity getCommodityById(int id);
	public List<Commodity> queryAll();
	public boolean deleteCommodityById(int id);
	public boolean updateCommodityById(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on,int id);
	public List<Commodity> queryCommodityById(int id);
	public boolean addCommodity(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on);
}

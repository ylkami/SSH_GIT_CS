package com.edu.seiryo.dao;

import java.util.List;

import com.edu.seiryo.entity.Commodity;
/**
 * Commodity数据处理类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name CommodityDao.java
 * @classname CommodityDao
 * @version 1.0
 */
public interface CommodityDao {
	public List<Commodity> queryAll();
	public List<Commodity> queryAllSort(int age, String gender);
	public Commodity queryById(int id);
	public boolean deleteCommodityById(int id);
	public boolean updateCommodityById(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on,int id);
	public List<Commodity> queryCommodityById(int id);
	public boolean addCommodity(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on);
}

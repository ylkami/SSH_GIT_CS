package com.edu.seiryo.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONException;

import com.edu.seiryo.dao.CommodityDao;
import com.edu.seiryo.dao.imp.CommodityDaoImp;
import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.entity.UserInfo;
import com.edu.seiryo.service.CommodityService;
import com.edu.seiryo.util.JSONUtil;
/**
 * CommodityService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name CommodityServiceImp.java
 * @classname CommodityServiceImp
 * @version 1.0
 */
public class CommodityServiceImp implements CommodityService {
	private CommodityDao dao = new CommodityDaoImp();
	/**
	 * 获取所有商品数据的json字符串
	 * 
	 * @return
	 */
	public String getAllCommodityJSONString() {
		List<Commodity> list = dao.queryAll();
		String json = "";
		try {
			json = JSONUtil.toJSONString(list);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 获取所有指定类型商品数据的json
	 * 
	 * @return
	 */
	public String getAllCommodityJSONString(String type) {
		List<Commodity> list = dao.queryAll();
		List<Commodity> resulList = new ArrayList<Commodity>();
		for (Commodity commodity : list) {
			if (type.equals(commodity.getType())) {
				resulList.add(commodity);
			}
		}
		String json = "";
		try {
			json = JSONUtil.toJSONString(resulList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 获取所有根据用户信息推荐排序后的商品数据的json
	 * 
	 * @param userInfo
	 * @return
	 */
	public String getAllCommoditySortJSONString(UserInfo userInfo) {
		int age = getAge(userInfo);
		String sex = "";
		String sexStr = userInfo.getSex();
		switch (sexStr) {
		case "先生":
			sex = "0";
			break;
		case "女士":
			sex = "1";
			break;
		}

		List<Commodity> list = dao.queryAllSort(age, sex);
		String json = "";
		try {
			json = JSONUtil.toJSONString(list);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 获取所有根据用户信息推荐排序后的指定种类商品数据的json
	 * @param userInfo
	 * @return
	 */
	public String getAllCommoditySortJSONString(UserInfo userInfo, String type) {
		int age = getAge(userInfo);
		String sex = "";
		String sexStr = userInfo.getSex();
		switch (sexStr) {
		case "先生":
			sex = "0";
			break;
		case "女士":
			sex = "1";
			break;
		}
		List<Commodity> list = dao.queryAllSort(age, sex);
		List<Commodity> resulList = new ArrayList<Commodity>();
		for (Commodity commodity : list) {
			if (type.equals(commodity.getType())) {
				resulList.add(commodity);
			}
		}
		String json = "";
		try {
			json = JSONUtil.toJSONString(resulList);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * 获取用户年龄
	 * @param userInfo
	 * @return
	 */
	private int getAge(UserInfo userInfo) {
		String birthday = userInfo.getBirthday();
		int year = Integer.parseInt(birthday.substring(0, 4));
		int currentYear = new Date().getYear() + 1900;
		return currentYear - year;
	}

	/**
	 * 查询指定id的商品
	 * 
	 * @param id
	 * @return
	 */
	public Commodity getCommodityById(int id) {
		return dao.queryById(id);
	}
	public List<Commodity> queryAll(){
		return dao.queryAll();
	}
	public boolean deleteCommodityById(int id){
		return dao.deleteCommodityById(id);
	}
	public boolean updateCommodityById(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on,int id){
		return dao.updateCommodityById(name, price, introduce, img, ageStart, ageEnd, timeLength, applicableGender, applicableLocation, signingForm, liabilityZjs, detail1, detail2, detail3, typeDetail,on, id);
	}
	public List<Commodity> queryCommodityById(int id){
		return dao.queryCommodityById(id);
	}
	public boolean addCommodity(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on){
		return dao.addCommodity(name, price, introduce, img, ageStart, ageEnd, timeLength, applicableGender, applicableLocation, signingForm, liabilityZjs, detail1, detail2, detail3, typeDetail, on);
	}
}
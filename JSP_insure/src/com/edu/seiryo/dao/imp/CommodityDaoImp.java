package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.edu.seiryo.dao.CommodityDao;
import com.edu.seiryo.entity.Commodity;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * CommodityDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name CommodityDaoImp.java
 * @classname CommodityDaoImp
 * @version 1.0
 */
public class CommodityDaoImp implements CommodityDao {
	private ResultSet rs;
	/**
	 * 获取所有商品
	 * @return
	 */
	@Override
	public List<Commodity> queryAll() {
		String sql = "select commodity_id,commodity_name,commodity_price,commodity_introduce,commodity_img,"
				   + "commodity_age_start,commodity_age_end,commodity_time_length,commodity_applicable_gender,"
				   + "commodity_applicable_location,commodity_signing_form,commodity_liability_zjs,"
				   + "commodity_detailed_information1,commodity_detailed_information2,commodity_detailed_information3,commodity_type,commodity_type_detail,commodity_on"
				   + " from commodity";
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql);
			while(rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(rs.getInt("commodity_id"));
				commodity.setName(rs.getString("commodity_name"));
				commodity.setPrice(rs.getString("commodity_price"));
				commodity.setIntroduce(rs.getString("commodity_introduce"));
				commodity.setImg(rs.getString("commodity_img"));
				commodity.setAgeStart(rs.getInt("commodity_age_start"));
				commodity.setAgeEnd(rs.getInt("commodity_age_end"));
				commodity.setTimeLength(rs.getString("commodity_time_length"));
				commodity.setApplicableGender(rs.getString("commodity_applicable_gender"));
				commodity.setApplicableLocation(rs.getString("commodity_applicable_location"));
				commodity.setSigningForm(rs.getString("commodity_signing_form"));
				commodity.setLiabilityZjs(rs.getString("commodity_liability_zjs"));
				commodity.setDetail1(rs.getString("commodity_detailed_information1"));
				commodity.setDetail2(rs.getString("commodity_detailed_information2"));
				commodity.setDetail3(rs.getString("commodity_detailed_information3"));
				commodity.setType(rs.getString("commodity_type"));
				commodity.setTypeDetail(rs.getString("commodity_type_detail"));
				commodity.setOn(rs.getInt("commodity_on"));
				list.add(commodity);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 获取所有商品,根据条件筛选
	 * @return
	 */
	@Override
	public List<Commodity> queryAllSort(int age, String gender) {
		String sql = "select commodity_id,commodity_name,commodity_price,commodity_introduce,commodity_img,"
				   + "commodity_age_start,commodity_age_end,commodity_time_length,commodity_applicable_gender,"
				   + "commodity_applicable_location,commodity_signing_form,commodity_liability_zjs,"
				   + "commodity_detailed_information1,commodity_detailed_information2,commodity_detailed_information3,commodity_type"
				   + " from commodity order by case when commodity_age_start <= ? and commodity_age_end >= ? and "
				   + "(commodity_applicable_gender = 2 or commodity_applicable_gender = ?) then 0 else 1 end";
		List<Commodity> list = new ArrayList<Commodity>();
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, age, age, gender);
			while(rs.next()) {
				Commodity commodity = new Commodity();
				commodity.setId(rs.getInt("commodity_id"));
				commodity.setName(rs.getString("commodity_name"));
				commodity.setPrice(rs.getString("commodity_price"));
				commodity.setIntroduce(rs.getString("commodity_introduce"));
				commodity.setImg(rs.getString("commodity_img"));
				commodity.setAgeStart(rs.getInt("commodity_age_start"));
				commodity.setAgeEnd(rs.getInt("commodity_age_end"));
				commodity.setTimeLength(rs.getString("commodity_time_length"));
				commodity.setApplicableGender(rs.getString("commodity_applicable_gender"));
				commodity.setApplicableLocation(rs.getString("commodity_applicable_location"));
				commodity.setSigningForm(rs.getString("commodity_signing_form"));
				commodity.setLiabilityZjs(rs.getString("commodity_liability_zjs"));
				commodity.setDetail1(rs.getString("commodity_detailed_information1"));
				commodity.setDetail2(rs.getString("commodity_detailed_information2"));
				commodity.setDetail3(rs.getString("commodity_detailed_information3"));
				commodity.setType(rs.getString("commodity_type"));
				list.add(commodity);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 查找指定id的商品
	 * @param id
	 * @return
	 */
	@Override
	public Commodity queryById(int id) {
		String sql = "select commodity_id,commodity_name,commodity_price,commodity_introduce,commodity_img,"
				   + "commodity_age_start,commodity_age_end,commodity_time_length,commodity_applicable_gender,"
				   + "commodity_applicable_location,commodity_signing_form,commodity_liability_zjs,"
				   + "commodity_detailed_information1,commodity_detailed_information2,commodity_detailed_information3,commodity_type,commodity_type_detail"
				   + " from commodity where commodity_id=?";
		Commodity commodity = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, id);
			if(rs.next()) {
				commodity = new Commodity();
				commodity.setId(rs.getInt("commodity_id"));
				commodity.setName(rs.getString("commodity_name"));
				commodity.setPrice(rs.getString("commodity_price"));
				commodity.setIntroduce(rs.getString("commodity_introduce"));
				commodity.setImg(rs.getString("commodity_img"));
				commodity.setAgeStart(rs.getInt("commodity_age_start"));
				commodity.setAgeEnd(rs.getInt("commodity_age_end"));
				commodity.setTimeLength(rs.getString("commodity_time_length"));
				commodity.setApplicableGender(rs.getString("commodity_applicable_gender"));
				commodity.setApplicableLocation(rs.getString("commodity_applicable_location"));
				commodity.setSigningForm(rs.getString("commodity_signing_form"));
				commodity.setLiabilityZjs(rs.getString("commodity_liability_zjs"));
				commodity.setDetail1(rs.getString("commodity_detailed_information1"));
				commodity.setDetail2(rs.getString("commodity_detailed_information2"));
				commodity.setDetail3(rs.getString("commodity_detailed_information3"));
				commodity.setType(rs.getString("commodity_type"));
				commodity.setTypeDetail(rs.getString("commodity_type_detail"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return commodity;
	}
	/**
	 * 获取当前商品信息
	 */
	public List<Commodity> queryCommodityById(int id) {
		List<Commodity> list = new ArrayList<Commodity>();
		String sql = "select commodity_id,commodity_name,commodity_price,commodity_introduce,commodity_img,"
				   + "commodity_age_start,commodity_age_end,commodity_time_length,commodity_applicable_gender,"
				   + "commodity_applicable_location,commodity_signing_form,commodity_liability_zjs,"
				   + "commodity_detailed_information1,commodity_detailed_information2,commodity_detailed_information3,commodity_type,commodity_type_detail,commodity_on"
				   + " from commodity where commodity_id=?";
		Commodity commodity = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, id);
			if(rs.next()) {
				commodity = new Commodity();
				commodity.setId(rs.getInt("commodity_id"));
				commodity.setName(rs.getString("commodity_name"));
				commodity.setPrice(rs.getString("commodity_price"));
				commodity.setIntroduce(rs.getString("commodity_introduce"));
				commodity.setImg(rs.getString("commodity_img"));
				commodity.setAgeStart(rs.getInt("commodity_age_start"));
				commodity.setAgeEnd(rs.getInt("commodity_age_end"));
				commodity.setTimeLength(rs.getString("commodity_time_length"));
				commodity.setApplicableGender(rs.getString("commodity_applicable_gender"));
				commodity.setApplicableLocation(rs.getString("commodity_applicable_location"));
				commodity.setSigningForm(rs.getString("commodity_signing_form"));
				commodity.setLiabilityZjs(rs.getString("commodity_liability_zjs"));
				commodity.setDetail1(rs.getString("commodity_detailed_information1"));
				commodity.setDetail2(rs.getString("commodity_detailed_information2"));
				commodity.setDetail3(rs.getString("commodity_detailed_information3"));
				commodity.setType(rs.getString("commodity_type"));
				commodity.setTypeDetail(rs.getString("commodity_type_detail"));
				commodity.setOn(rs.getInt("commodity_on"));
				list.add(commodity);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	/**
	 * 删除该商品
	 */
	public boolean deleteCommodityById(int id){
		boolean bo = false;
		String sql = "delete from commodity where commodity_id=?";
		try{
			bo = JDBCUTILE.upDataBaseTable(sql, id);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bo;
	}
	/**
	 * 更新该商品信息
	 */
	public boolean updateCommodityById(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on,int id){
		boolean bo = false;
		String sql = "update commodity set commodity_name=?,commodity_price=?,commodity_introduce=?,commodity_img=?,commodity_age_start=?,commodity_age_end=?,commodity_time_length=?,commodity_applicable_gender=?,commodity_applicable_location=?,commodity_signing_form=?,commodity_liability_zjs=?,commodity_detailed_information1=?,commodity_detailed_information2=?,commodity_detailed_information3=?,commodity_type_detail=?,commodity_on=? where commodity_id=?";
		try{
			bo = JDBCUTILE.upDataBaseTable(sql, name,price,introduce,img,ageStart,ageEnd,timeLength,applicableGender,applicableLocation,signingForm,liabilityZjs,detail1,detail2,detail3,typeDetail,on,id);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bo;
	}
	/**
	 * 新增商品
	 */
	public boolean addCommodity(String name,String price,String introduce,String img,int ageStart,int ageEnd,String timeLength,String applicableGender,String applicableLocation,String signingForm,String liabilityZjs,String detail1,String detail2,String detail3,String typeDetail,int on){
		boolean bo  = false;
		String sql = "insert into commodity(commodity_name,commodity_price,commodity_introduce,commodity_img,commodity_age_start,commodity_age_end,commodity_time_length,commodity_applicable_gender,commodity_applicable_location,commodity_signing_form,commodity_liability_zjs,commodity_detailed_information1,commodity_detailed_information2,commodity_detailed_information3,commodity_type_detail,commodity_on) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try{
			bo = JDBCUTILE.upDataBaseTable(sql, name,price,introduce,img,ageStart,ageEnd,timeLength,applicableGender,applicableLocation,signingForm,liabilityZjs,detail1,detail2,detail3,typeDetail,on);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				JDBCUTILE.dbClose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bo;
	}
}

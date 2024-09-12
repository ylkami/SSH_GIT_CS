package com.edu.seiryo.dao.imp;

import java.sql.ResultSet;

import com.edu.seiryo.dao.CommodityInfoDao;
import com.edu.seiryo.entity.CommodityInfo;
import com.edu.seiryo.util.JDBCUTILE;
/**
 * CommodityInfoDao的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao.imp
 * @file_name CommodityInfoDaoImp.java
 * @classname CommodityInfoDaoImp
 * @version 1.0
 */
public class CommodityInfoDaoImp implements CommodityInfoDao {
	private ResultSet rs;
	
	/**
	 * 查找指定商品id的商品详情
	 * @param commodityId
	 * @return
	 */
	@Override
	public CommodityInfo queryByCommodityId(int commodityId) {
		String sql = "select commodity_liability_info_id,commodity_id,commodity_liability_info1,commodity_liability_info2,"
				+ "commodity_liability_info3,commodity_liability_info4,commodity_liability_info5,commodity_liability_info6,"
				+ "commodity_liability_info7 from commodity_liability_info where commodity_id = ?";
		CommodityInfo commodityInfo = null;
		try {
			rs = JDBCUTILE.selectDataBaseTable(sql, commodityId);
			if(rs.next()) {
				commodityInfo = new CommodityInfo();
				commodityInfo.setId(rs.getInt("commodity_liability_info_id"));
				commodityInfo.setLiabilityInfo1(rs.getString("commodity_liability_info1"));
				commodityInfo.setLiabilityInfo2(rs.getString("commodity_liability_info2"));
				commodityInfo.setLiabilityInfo3(rs.getString("commodity_liability_info3"));
				commodityInfo.setLiabilityInfo4(rs.getString("commodity_liability_info4"));
				commodityInfo.setLiabilityInfo5(rs.getString("commodity_liability_info5"));
				commodityInfo.setLiabilityInfo6(rs.getString("commodity_liability_info6"));
				commodityInfo.setLiabilityInfo7(rs.getString("commodity_liability_info7"));
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
		return commodityInfo;
	}
}

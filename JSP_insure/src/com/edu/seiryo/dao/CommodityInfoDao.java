package com.edu.seiryo.dao;

import com.edu.seiryo.entity.CommodityInfo;
/**
 * CommodityInfo数据处理类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name CommodityInfoDao.java
 * @classname CommodityInfoDao
 * @version 1.0
 */
public interface CommodityInfoDao {
	public CommodityInfo queryByCommodityId(int commodityId);
}

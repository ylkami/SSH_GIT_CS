package com.edu.seiryo.dao;

import com.edu.seiryo.entity.CommodityInfo;
/**
 * CommodityInfo���ݴ�����
 * @author GuoYuanZhao
 * @date 2024��6��6��
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.dao
 * @file_name CommodityInfoDao.java
 * @classname CommodityInfoDao
 * @version 1.0
 */
public interface CommodityInfoDao {
	public CommodityInfo queryByCommodityId(int commodityId);
}

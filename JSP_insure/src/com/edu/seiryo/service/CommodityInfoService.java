package com.edu.seiryo.service;

import com.edu.seiryo.entity.CommodityInfo;
/**
 * CommodityInfo业务逻辑控制类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service
 * @file_name CommodityInfoService.java
 * @classname CommodityInfoService
 * @version 1.0
 */
public interface CommodityInfoService {
	public CommodityInfo getCommodityInfoByCommodityId(int CommodityId);
}

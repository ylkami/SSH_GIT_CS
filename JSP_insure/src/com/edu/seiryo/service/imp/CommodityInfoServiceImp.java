package com.edu.seiryo.service.imp;

import com.edu.seiryo.dao.CommodityInfoDao;
import com.edu.seiryo.dao.imp.CommodityInfoDaoImp;
import com.edu.seiryo.entity.CommodityInfo;
import com.edu.seiryo.service.CommodityInfoService;
/**
 * CommodityInfoService的实现类
 * @author GuoYuanZhao
 * @date 2024年6月6日
 * @project_name JSP_insure
 * @package_name com.edu.seiryo.service.imp
 * @file_name CommodityInfoServiceImp.java
 * @classname CommodityInfoServiceImp
 * @version 1.0
 */
public class CommodityInfoServiceImp implements CommodityInfoService {
	private CommodityInfoDao dao = new CommodityInfoDaoImp();
	public CommodityInfo getCommodityInfoByCommodityId(int CommodityId) {
		return dao.queryByCommodityId(CommodityId);
	}
}


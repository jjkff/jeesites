package com.thinkgem.jeesite.sierac.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.sierac.entity.Demo;
import com.thinkgem.jeesite.sierac.entity.Distributor;

/**
 * Created by jkf on 2017/6/1.
 */
@MyBatisDao
public interface DemoDao extends CrudDao<Demo> {
}

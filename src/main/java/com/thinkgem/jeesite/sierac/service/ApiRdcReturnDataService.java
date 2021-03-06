/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.ApiRdcReturnDataDao;
import com.thinkgem.jeesite.sierac.entity.ApiRdcOutData;
import com.thinkgem.jeesite.sierac.entity.ApiRdcReturnHeader;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * CRUD操作Service
 * 
 * @author mjj
 * @version 2017-02-13
 */
@Service
@Transactional(readOnly = true)
public class ApiRdcReturnDataService extends CrudService<ApiRdcReturnDataDao, ApiRdcOutData> {

    public ApiRdcOutData get(String id) {
        return super.get(id);
    }

    public List<ApiRdcOutData> findList(ApiRdcOutData apiRdcOutData) {
        return super.findList(apiRdcOutData);
    }

    public Page<ApiRdcOutData> findPage(Page<ApiRdcOutData> page, ApiRdcOutData apiRdcOutData) {
        return super.findPage(page, apiRdcOutData);
    }

    @Transactional(readOnly = false)
    public void save(ApiRdcOutData apiRdcOutData) {
        super.save(apiRdcOutData);
    }

    @Transactional(readOnly = false)
    public void delete(ApiRdcOutData apiRdcOutData) {
        super.delete(apiRdcOutData);
    }

    @Transactional(readOnly = false)
    public List<ApiRdcOutData> findAll(ApiRdcOutData apiRdcOutData) {
        return super.findAll(apiRdcOutData);
    }

    @Transactional(readOnly = false)
    public void updateAll(ApiRdcOutData apiRdcOutData) {
        super.updateAll(apiRdcOutData);
    }


}
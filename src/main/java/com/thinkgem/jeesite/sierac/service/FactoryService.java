package com.thinkgem.jeesite.sierac.service;

import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.FactoryDao;
import com.thinkgem.jeesite.sierac.entity.Factory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 工厂业务层：
 * Created by jkf on 2017/6/1.
 */
@Service
@Transactional(readOnly = true)
public class FactoryService extends CrudService<FactoryDao, Factory> {

    public Factory get(String id){
         return super.get(id);
    }
    @Transactional(readOnly = false)
    public void save(Factory factory){
         super.save(factory);
    }

    public List<Factory> findList(Factory factory){
         return super.findList(factory);
    }

}

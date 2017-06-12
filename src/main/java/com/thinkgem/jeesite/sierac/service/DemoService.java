package com.thinkgem.jeesite.sierac.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.DemoDao;
import com.thinkgem.jeesite.sierac.dao.DemoDao;
import com.thinkgem.jeesite.sierac.entity.Demo;
import com.thinkgem.jeesite.sierac.entity.Demo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jkf on 2017/6/5.
 */
@Service
@Transactional(readOnly = true)
public class DemoService extends CrudService<DemoDao,Demo>{

    public Demo get(String id){return super.get(id);}

    public List<Demo> findList(Demo Demo){
        return super.findList(Demo);
    }

    public List<Demo> findAll(Demo Demo){
        return super.findAll(Demo);
    }

    public Page<Demo> findPage(Page<Demo> page,Demo Demo){
        return super.findPage(page,Demo);
    }

    @Transactional(readOnly = false)
    public void save(Demo Demo){
        super.save(Demo);
    }

}

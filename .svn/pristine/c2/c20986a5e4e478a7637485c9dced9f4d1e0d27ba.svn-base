package com.thinkgem.jeesite.sierac.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.DistributorDao;
import com.thinkgem.jeesite.sierac.entity.Distributor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jkf on 2017/6/5.
 */
@Service
@Transactional(readOnly = true)
public class DistributorService extends CrudService<DistributorDao,Distributor>{

    public Distributor get(String id){return super.get(id);}

    public List<Distributor> findList(Distributor distributor){
        return super.findList(distributor);
    }

    public List<Distributor> findAll(Distributor distributor){
        return super.findAll(distributor);
    }

    public Page<Distributor> findPage(Page<Distributor> page,Distributor distributor){
        return super.findPage(page,distributor);
    }

    @Transactional(readOnly = false)
    public void save(Distributor distributor){
        super.save(distributor);
    }

}

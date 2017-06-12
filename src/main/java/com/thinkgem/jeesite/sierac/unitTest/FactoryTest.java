package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.dao.FactoryDao;
import com.thinkgem.jeesite.sierac.entity.Factory;
import com.thinkgem.jeesite.sierac.service.FactoryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Sierac on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class FactoryTest {

    @Autowired
    private FactoryDao factoryDao;

    @Test
    public void insert(){
        Factory factory = new Factory();
        factory.setId("1");
        factory.setName("A工厂");
        factory.setCode("001");
        factory.setAddress("上海");
        factory.setContacts("小蒋");
        factory.setTel("15189777686");
        factoryDao.insert(factory);
    }

    @Test
    public void get(){
       Factory factory =  factoryDao.get("1");
    }

//    @Test
//    public void update(){
//      Factory factory = factoryDao.get("1");
//      factory.setName("老蒋");
//      factoryDao.update(factory);
//    }

    @Test
    public void  findList(){
       List<Factory> factories =  factoryDao.findList(new Factory());
    }


    @Autowired
    private FactoryService factoryService;
    @Test
    public void testfindList(){
        List<Factory> list = factoryService.findList(new Factory());
    }

    @Test
    public void testsave(){
        Factory factory = new Factory();
        factory.setName("jfk");
        factory.setTel("15189777686");
        factory.setAddress("常州");
        factory.setCode("002");
        factory.setContacts("小蒋");
        factoryService.save(factory);
    }

    @Test
    public void testget(){
        Factory factory =  factoryService.get("0d9483fff5a642f39895e04234d53e97");
    }
}

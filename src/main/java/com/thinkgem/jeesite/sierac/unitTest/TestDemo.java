package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.dao.DemoDao;
import com.thinkgem.jeesite.sierac.entity.Demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jkf on 2017/6/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class TestDemo {

    @Autowired
    private DemoDao demoDao;

    @Test
    public void testfindAll(){
        List<Demo> list = demoDao.findAll(new Demo());
    }

    @Test
    public void testAdd(){
        Demo demo = new Demo();
        demo.setName("jkf");
        demo.setNum("123123");
        demo.setId("123123");
        demoDao.insert(demo);
    }

    @Test
    public void testfindList(){
        List<Demo> list =  demoDao.findList(new Demo());
    }

    @Test
    public void testget(){
        Demo demo =  demoDao.get("123123");
    }

}

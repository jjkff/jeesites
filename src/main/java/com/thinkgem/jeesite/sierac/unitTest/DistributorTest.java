package com.thinkgem.jeesite.sierac.unitTest;

import com.thinkgem.jeesite.sierac.dao.DistributorDao;
import com.thinkgem.jeesite.sierac.entity.Distributor;
import com.thinkgem.jeesite.sierac.service.DistributorService;
import org.apache.poi.common.usermodel.LineStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by jkf on 2017/6/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class DistributorTest {

    @Autowired
    private DistributorDao distributorDao;

    //根据客户号查询数据
    @Test
    public void testget(){
    Distributor distributor = distributorDao.get("1");
    }

    //查询
    @Test
    public void  testfindList(){
        List<Distributor> list =  distributorDao.findList(new Distributor());
    }

    @Test
    public void testfindAll(){
        List<Distributor> list = distributorDao.findAll(new Distributor());
    }

    @Test
    public void testfindAllList(){
        List<Distributor> list =  distributorDao.findAllList(new Distributor());
    }



    @Test
    public void insert(){
        Distributor distributor = new Distributor();
        distributor.setId("123"); //客户号
        distributor.setName("小沈阳");//名称
        distributor.setAssessmentCity("沈阳");//考核城市
        distributor.setFullName("沈阳");//全称
        distributor.setContacts("小沈阳");//联系人
        distributor.setTel("121212121212");//联系电话
        distributor.setProvince("辽宁省");
        distributor.setCity("沈阳");
        distributor.setCity("沈阳区");
        distributor.setAddress("沈阳");//收货地址
        distributor.setIsEnable("1");//是否启用
        distributor.setRemarks("备注");
        distributorDao.insert(distributor);
    }


    @Test
    public void update(){
        Distributor distributor = new Distributor();
        distributor.setId("123");
        distributor.setName("小沈阳");
        distributor.setTel("1819999999999");
        distributor.setAssessmentCity("shenyang");
        distributorDao.update(distributor);
    }

    @Autowired
    private DistributorService distributorService;
    @Test
    public void testGet(){
         Distributor distributors =  distributorService.get("123");
    }

    @Test
    public void TestFindList(){
        List<Distributor> list = distributorService.findList(new Distributor());
    }

    @Test
    public void testfindAll2(){
        List<Distributor> list =  distributorDao.findAll(new Distributor());
    }

    @Test
    public void testSave(){
        Distributor distributor = new Distributor();
        distributor.setId("345"); //客户号
        distributor.setName("object");//名称
        distributor.setAssessmentCity("changzhou");//考核城市
        distributor.setFullName("常州");//全称
        distributor.setContacts("恩");//联系人
        distributor.setTel("101012121212");//联系电话
        distributor.setProvince("江苏省");
        distributor.setCity("常州市");
        distributor.setCity("武进区");
        distributor.setAddress("鸣凰");//收货地址
        distributor.setIsEnable("1");//是否启用
        distributor.setRemarks("备注");
        distributorDao.insert(distributor);
//        distributorService.save(distributor);
    }
}

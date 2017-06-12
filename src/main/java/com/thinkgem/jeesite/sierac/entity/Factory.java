package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 工厂：
 * Created by jkf on 2017/6/1.
 */
public class Factory extends DataEntity<Factory> {

    public Factory(){}

    private static final long serialVersionUID = 1L;

    private String code; //代码

    private String name;//名称

    private String contacts;//联系人

    private String tel;//联系电话

    private String address;//详细地址

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", contacts='" + contacts + '\'' +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    //详情显示的时候，需要将时间转换为字符串显示

    private String mycreateDate; //增加时间

    public String getMycreateDate() {
        return mycreateDate;
    }

    public void setMycreateDate(String mycreateDate) {
        this.mycreateDate = mycreateDate;
    }
    private String myupdateDate;//更新时间

    public String getMyupdateDate() {
        return myupdateDate;
    }

    public void setMyupdateDate(String myupdateDate) {
        this.myupdateDate = myupdateDate;
    }

    //详情现实中增加人和修改人
    private String myCreateBy;

    public String getMyCreateBy() {
        return myCreateBy;
    }

    public void setMyCreateBy(String myCreateBy) {
        this.myCreateBy = myCreateBy;
    }

    private String myUpdateBy;

    public String getMyUpdateBy() {
        return myUpdateBy;
    }

    public void setMyUpdateBy(String myUpdateBy) {
        this.myUpdateBy = myUpdateBy;
    }
}

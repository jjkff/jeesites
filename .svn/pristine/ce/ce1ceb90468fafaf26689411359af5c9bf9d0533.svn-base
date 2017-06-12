package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Created by jkf on 2017/5/23.
 */
public class Student extends DataEntity<Student> {
    private static final  long serialVersionUID = 1L;

    private String name ;
    private int age ;
    private String address;
    private String gradeId;
    private String teacherName;

    public Student(String name) {
        this.name = name;
    }

    public Student(String id, String name) {
        super(id);
        this.name = name;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId = gradeId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gradeId='" + gradeId + '\'' +
                ", teacheName='" + teacherName + '\'' +
                '}';
    }
}

package com.thinkgem.jeesite.sierac.service;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.sierac.dao.StudentDao;
import com.thinkgem.jeesite.sierac.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jkf on 2017/5/23.
 */
@Service
@Transactional(readOnly = true)
public class StudentService extends CrudService<StudentDao,Student>{

    public Student get(String id){return super.get(id);}

    public List<Student> findList(Student student){
        return super.findList(student);
    }

    public List<Student> findByName(){return super.findByname();}

    public Page<Student> findPage(Page<Student> page,Student student){
        return super.findPage(page,student);
    }
    @Transactional(readOnly =  false)
    public void save(Student student){super.save(student);}

    @Transactional(readOnly =  false)
    public void delete(Student student){
        super.delete(student);
    }

    public Student findName(String name){
        return super.findName(name);
    }


}

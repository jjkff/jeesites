package com.thinkgem.jeesite.sierac.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.Student;
import com.thinkgem.jeesite.sierac.service.StudentService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jkf on 2017/5/23.
 */
@Controller
@RequestMapping(value="${adminPath}/sierac/student")
public class StudentController extends BaseController{

    @Autowired
    private StudentService studentService;

    @ModelAttribute
    public Student get(@RequestParam(required =  false) String id){
        Student student = null;
        if(StringUtils.isNoneBlank(id)){
            student = studentService.get(id);
        }
        if(student == null){
            student = new Student();
        }
        return student;
    }

    @RequestMapping(value = "/getStudent", method = RequestMethod.GET,headers = {"Accept=application/json"})
    public Map<String,List<Student>> getStudentList(Student student , HttpServletRequest request, HttpServletResponse response){
        Page<Student> page = studentService.findPage(new Page<Student>(request,response),student);
        List<Student> students = page.getList();
        Map<String , List<Student>> returnMap  = new HashMap<String, List<Student>>();
        returnMap.put("data",students);
        return returnMap;
    }

    //这个方法是列表和条件查询
    @RequiresPermissions("sierac:student:view")
    @RequestMapping({"list",""})
    public String list(Student student, HttpServletRequest request , HttpServletResponse response , Model model){
        Page<Student> page = studentService.findPage(new Page<Student>(request,response),student);
        model.addAttribute("page",page);
        return "sierac/studentList";
    }


    @RequiresPermissions("sierac:student:view")
    @RequestMapping(value = "form")
    public String form(Student student , Model model){
        model.addAttribute("student",student);
        return "sierac/studentForm";
    }

    /**更新页面*/
    @RequiresPermissions("sierac:product:view")
    @RequestMapping(value = "formUp")
    public String formUp(Student student , Model model){
        model.addAttribute("student",student);
        return "sierac/studentUpdateForm";
    }

    //写到这里，页面上有了数据显示和查询。 但是没有操作。
    //在前端操作是这么写的：<shiro:hasPermission name="sierac:student:edit"><th>操作</th></shiro:hasPermission>
    //所以在控制层把这几个方法写出来才会在页面上显示这些操作
    //上面的推测错误
    //1.保存
    @RequiresPermissions("sierac:student:edit")
    public String save(Student student , Model model , RedirectAttributes redirectAttributes , HttpServletRequest request , HttpServletResponse response)
            throws UnsupportedEncodingException {
          request.setCharacterEncoding("UTF-8");

          if(!beanValidator(model,student)){
              return form(student,model);
          }
          studentService.save(student);
          addMessage(redirectAttributes,"保存成功");
          return "redirect:" + Global.getAdminPath()+"/sierac/student/?repage";
    }



    @RequiresPermissions("sierac:student:edit")
    @RequestMapping(value="delete")
    public String delete(Student student , RedirectAttributes redirectAttributes){
         studentService.delete(student);
         addMessage(redirectAttributes,"删除成功");
         return "redirect:"+ Global.getAdminPath() + "/sierac/student/?repage";
    }
}

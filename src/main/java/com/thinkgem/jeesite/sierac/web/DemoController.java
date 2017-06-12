package com.thinkgem.jeesite.sierac.web;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.Demo;
import com.thinkgem.jeesite.sierac.service.DemoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 经销商控制层：
 * Created by jkf on 2017/6/8.
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/demo")
public class DemoController extends BaseController{

    @Autowired
    private DemoService DemoService;

    @ModelAttribute
    public Demo get(@RequestParam(required = false) String id){

        Demo entity = null;
        if(StringUtils.isNoneBlank(id)){
           entity  = DemoService.get(id);
        }
        if(entity == null){
           entity = new Demo();
        }
        return entity;
    }

    @RequiresPermissions("sierac:demo:view")
    @RequestMapping(value={"list",""})
    public String list(Demo Demo, HttpServletRequest request, HttpServletResponse response, Model model){
        Page<Demo> page = DemoService.findPage(new Page<Demo>(request,response),Demo);
        model.addAttribute("page",page);
        return "sierac/demoList";
    }


    /**
     * 跳转到页面详情
     * @param model
     * @param request
     * @return
     */
    @RequiresPermissions("sierac:demo:view")
    @RequestMapping(value = "form")
    public String form(Demo demo , Model model, HttpServletRequest request ){
        model.addAttribute("demo",demo);
        return "sierac/demoFormDetail";
    }

    /**
     * 跳转到新增页面
     * @param model
     * @return
     */
    @RequiresPermissions("sierac:demo:view")
    @RequestMapping("formAdd")
    public String formAdd(Demo demo, Model model){
        model.addAttribute("demo",demo);
        return "sierac/demoFormAdd";
    }

    /**
     * 保存经销商信息
     * @param model
     * @param redirectAttributes
     * @param request
     * @param response
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequiresPermissions("sierac:demo:edit")
    @RequestMapping("save")
    public String save(Demo demo , Model model , RedirectAttributes redirectAttributes , HttpServletRequest request, HttpServletResponse response)
    throws UnsupportedEncodingException
    {
         request.setCharacterEncoding("UTF-8");
         if(!beanValidator(model,demo)){
             return form(demo,model,request);
         }
        demo.setCreateDate(new Date());
         String strcDate = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(demo.getCreateDate());
        demo.setMyCreateDate(strcDate);
         DemoService.save(demo);
         addMessage(redirectAttributes,"保存成功");
         model.addAttribute("demo",demo);
         return "redirect:"+ Global.getAdminPath()+"/sierac/demo/?repage";
    }

    /**
     * 经销商更新
     * @param model
     * @return
     */
        @RequiresPermissions("sierac:demo:view")
        @RequestMapping(value="formUp")
        public String formUp(Demo demo ,Model model){
            model.addAttribute("demo",demo);
            return "sierac/demoUpdateForm";
    }





}

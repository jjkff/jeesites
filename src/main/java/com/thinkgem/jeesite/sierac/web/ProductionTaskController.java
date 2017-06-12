/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.sierac.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.service.ProductService;
import com.thinkgem.jeesite.sierac.service.ProductionTaskService;

/**
 * 生产任务查询Controller
 * @author wgc
 * @version 2017-03-01
 */
@Controller
@RequestMapping(value = "${adminPath}/sierac/productiontask")
public class ProductionTaskController extends BaseController {

	@Autowired
	private ProductionTaskService productiontaskService;
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("productiontask")
	public ProductionTask get(@RequestParam(required=false) String id) {
		ProductionTask entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = productiontaskService.get(id);
		}
		if (entity == null){
			entity = new ProductionTask();
		}
		return entity;
	}
	
	@RequiresPermissions("sierac:productiontask:view")
	@RequestMapping(value = {"list", ""})
	public String list(ProductionTask productiontask, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ProductionTask> page = productiontaskService.findPage(new Page<ProductionTask>(request, response), productiontask); 
		model.addAttribute("page", page);
		
		return "sierac/taskList";
	}
	@RequiresPermissions("sierac:productiontask:view")
    @ResponseBody
    @RequestMapping(value = "ajax")
	public String ajax(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // String newnameString = new String(name.getBytes("ISO-8859-1"),
        // "UTF-8");
		
        List<Product> list = productService.findByname();
        for (Product product : list) {
			System.out.println(product.getId());
		}
        return new Gson().toJson(list.get(0));
    }
	
	@RequiresPermissions("sierac:productiontask:view")
	@RequestMapping(value = "form")
	public String form(ProductionTask productiontask, Model model, HttpServletRequest request, HttpServletResponse response) {

		model.addAttribute("productiontask", productiontask);
		List<Product> list = productService.findByname();
		//获取所有产品的名称
		List<String> names  = new ArrayList<String>();
		for(Product product : list){
               names.add(product.getName());
		}
		model.addAttribute("productNames",names); //产品下拉数据
		model.addAttribute("list", list);
		return "sierac/taskForm";
	}
	
	/**
	 * 查看
	 * @param productiontask
	 * @param model
	 * @param redirectAttributes
	 * @param request
	 * @param response
	 * @return
	 */
	@RequiresPermissions("sierac:productiontask:view")
	@RequestMapping(value = "update")
	public String update(ProductionTask productiontask, Model model, HttpServletRequest request, HttpServletResponse response) {
		String id=request.getParameter("id");
		productiontask=productiontaskService.get(id);

        //获得当前的产品名称
		String productname = productiontask.getName();
		List<Product> productionTasks = productService.findList(new Product());//获取所有
        List<String> productNames = new ArrayList<String>();
        productNames.add(productname);
        for(Product product : productionTasks){
        	productNames.add(product.getName());
		}


		
		model.addAttribute("productNames", productNames);
		model.addAttribute("productiontask", productiontask);
		
		return "sierac/taskForm";
	}
	
	
	
	@RequiresPermissions("sierac:productiontask:edit")
	@RequestMapping(value = "save")
	
	public String save(ProductionTask productiontask, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request, HttpServletResponse response) throws CloneNotSupportedException {
		//先获得传入productid , 再根据name得到产品id
		if (!beanValidator(model, productiontask)){
			return form(productiontask, model,request,response);
		}
		String productid=request.getParameter("productid");
		productiontask.setProductid(productService.findName(request.getParameter("name")).getId());
		productiontaskService.save(productiontask);
		addMessage(redirectAttributes, "保存生产任务成功");
		return "redirect:"+Global.getAdminPath()+"/sierac/productiontask/?repage";
	}
	
	@RequiresPermissions("sierac:productiontask:edit")
	@RequestMapping(value = "delete")
	public String delete(ProductionTask productiontask, RedirectAttributes redirectAttributes) {
		productiontaskService.delete(productiontask);
		addMessage(redirectAttributes, "删除生产任务成功");
		return "redirect:"+Global.getAdminPath()+"/sierac/productiontask/?repage";
	}
	
	@RequiresPermissions("productiontask")
	@ResponseBody
	@RequestMapping(value = "treeData")
	public List<Map<String, Object>> treeData(@RequestParam(required=false) String productId, HttpServletResponse response) {
		List<Map<String, Object>> mapList = Lists.newArrayList();
		List<ProductionTask> list = productiontaskService.findProductionTaskByProductId(productId);
		for (int i=0; i<list.size(); i++){
			ProductionTask e = list.get(i);
			Map<String, Object> map = Maps.newHashMap();
			map.put("id", "u_"+e.getId());
			map.put("code", e.getCode());
			
			mapList.add(map);
		}
		return mapList;
	}

	@ResponseBody
	@RequiresPermissions("sierac:product:edit")
	@RequestMapping(value = "check")
	public String check(HttpServletRequest request ,String oldcode, String code) throws UnsupportedEncodingException {
		String s = new String(request.getParameter("code").getBytes("ISO8859-1"), "UTF-8");//encodeURIComponent编码转换
		if (s !=null && s.equals(oldcode)) {
			return "true";//不重复
		} else if (s !=null && productiontaskService.findByCode(s)==null) {
			return "true"; //不重复
		}
		return "false"; //重复
	}


}
package com.thinkgem.jeesite.sierac.web;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.service.ProductService;
/**
 * 产品管理ApiController
 * 
 * @author wgc
 * @version 2017-02-13
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiProductController extends BaseController {
	@Autowired
	private ProductService productService;

	private static ObjectMapper objectMapper = new ObjectMapper();

	private JsonMapper jsonMapper;


	@SuppressWarnings("static-access")
	@RequestMapping(value = "/pack/product/list", method = RequestMethod.POST, headers = { "Accept=application/json" })
	@ResponseBody
	public String list(Product product, HttpServletRequest request,
			HttpServletResponse response) {
		if (ValidateToken.isToken(request, response)) {
			List<Product> products = productService.findAll(product);
			String json = JsonMapper.getInstance().toJson(products);
			return json;
		}
		else{
			response.setStatus(403);
			return "403";
		}
	}

//	@SuppressWarnings("static-access")
//	@RequestMapping(value = "/pack/product/list", method = RequestMethod.POST,
//			headers = { "Accept=application/json" })
//	@ResponseBody
//	public String list(Product product , HttpServletRequest request,
//			@RequestBody String Jsonparam,  HttpServletResponse response)
//	throws JsonParseException,JsonMappingException , IOException{
//		if (ValidateToken.isToken(request, response)) {
//             JavaType javaType = getCollectionType(ArrayList.class,Product.class);
//             List<Product> listDemo = (List<Product>) objectMapper.readValue(Jsonparam,javaType);
//             @SuppressWarnings("unchecked")
//			 List<List<Product>> list =	 new ArrayList<List<Product>>();
//             for(int i = 0 ; i<listDemo.size();i++){
//                List<Product> productList =  productService.findAll(product);
//				 list.add(productList);
//			 }
//			 return jsonMapper.getInstance().toJson(list);
//		} else {
//			response.setStatus(403);
//			return "403";
//		}
//	}


	public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

}

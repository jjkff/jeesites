package com.thinkgem.jeesite.sierac.web;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.service.ProductionTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jkf on 2017/6/6.
 * 生产任务接口
 */
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiWarehouseReturnscancheck extends BaseController{

    @Autowired
    private ProductionTaskService productionTaskService;

    private JsonMapper jsonMapper;

    private static ObjectMapper objectMapper =
            new ObjectMapper();


    @SuppressWarnings("static-access")
    @RequestMapping(value = "/warehouse/return/scan_check", method = RequestMethod.POST, headers = { "Accept=application/json" })
    @ResponseBody
    public String list(ProductionTask productionTask, HttpServletRequest request, HttpServletResponse response, @RequestBody String JsonParam)
    throws JsonParseException, JsonMappingException, IOException
    {
        if(ValidateToken.isToken(request,response)){
            JavaType javaType = getCollectionType(ArrayList.class,ProductionTask.class);

            List<ProductionTask> listDemo =(List<ProductionTask>)objectMapper.readValue(JsonParam,javaType);

            List<List<ProductionTask>> list =  new ArrayList<List<ProductionTask>>();

            for(int i = 0 ; i < listDemo.size(); i++){

                productionTask = listDemo.get(i);

                List<ProductionTask> productionTaskList = productionTaskService.findAll(productionTask);

                list.add(productionTaskList);

            }

            return JsonMapper.getInstance().toJson(list);

        }
        else{

            response.setStatus(403);

            return  "error/403";
        }

    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}

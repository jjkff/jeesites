package com.thinkgem.jeesite.sierac.web;

import com.alibaba.fastjson.annotation.JSONType;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinkgem.jeesite.common.mapper.JsonMapper;
import com.thinkgem.jeesite.common.utils.ValidateToken;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.sierac.entity.ApiRdcOutHeader;
import com.thinkgem.jeesite.sierac.entity.ApiRdcReturnHeader;
import com.thinkgem.jeesite.sierac.entity.RdcReturnHeader;
import com.thinkgem.jeesite.sierac.service.ApiRdcReturnDataService;
import org.apache.poi.ss.formula.functions.T;
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
 * Created by jkf on 2017/5/2.
 * 退货单据下载：
 * url: http://{domain_name}/api/v1/warehouse/return/list
 * post 请求参数
 |参数名称 |类型 |参数描述 |
 |-------|:---:|:------:|
 |send_id |String |退货id |
 |scan_by |String |扫描者 |
 |track_flag |Boolean |追溯标志 |

 * 响应参数
 *|参数名称 |类型 |参数描述 |
 |-------|:---:|:------:|
 |id |String |主键 |
 |code |String | 单据号码 |
 |bill_type |Integer |单据类型 |
 |bill_status |Integer |单据状态 |
 |send_id |String |退货方id |
 |send_name |String |退货方名称 |
 |receive_id |String |收货方id |
 |upload_id |String |收货方名称 |
 |upload_time |DateTime |上传时间 |
 |submit_by |String |提交者 |
 |scan_by |String |扫描者 |
 |detail_list |List ||

 **/
@Controller
@RequestMapping(value = "${adminPath}/api/v1")
public class ApiWareHouseReturnListController extends BaseController{

    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonMapper jsonMapper;

    @Autowired
    private ApiRdcReturnDataService apiRdcReturnDataService;

    @SuppressWarnings("static-access")
    @RequestMapping(value="/warehouse/return/list",method = RequestMethod.POST)
    @ResponseBody
    public String list(ApiRdcReturnHeader apiRdcReturnHeader, HttpServletRequest request,
                     HttpServletResponse response , @RequestBody String JsonParam)
    throws JsonParseException ,JsonMappingException ,IOException{

         if(ValidateToken.isToken(request,response)){
         JavaType javaType = getCollectionType(ArrayList.class,ApiRdcReturnHeader.class);
         @SuppressWarnings("unchecked")
         List<ApiRdcReturnHeader> list =  objectMapper.readValue(JsonParam, javaType);
         List<List<ApiRdcReturnHeader>> lists = new ArrayList<List<ApiRdcReturnHeader>>();
         for(int i = 0 ; i < list.size() ; i++){
//             List<ApiRdcReturnHeader> apiRdcReturnHeaders =
////                     apiRdcReturnDataService.findAll(apiRdcReturnHeader);
//             lists.add(apiRdcReturnHeaders);
         }
         return JsonMapper.getInstance().toJson(lists);
         }
         else{
             response.setStatus(403);
             return "error/403";
         }
    }

    public static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

}

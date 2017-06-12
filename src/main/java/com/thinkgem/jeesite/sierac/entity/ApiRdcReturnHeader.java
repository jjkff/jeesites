package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by jkf on 2017/5/2.
 *
 * * 响应参数对象:

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

 *    *
 */
public class ApiRdcReturnHeader extends DataEntity<ApiRdcReturnHeader> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String id ;

    private String code ;

    private String bill_type;

    private Integer bill_status;

    private String send_id;

    private String send_name;

    private String receive_id;

    private String upload_id;

    private DateTime upload_time;

    private String submit_by;

    private String scan_by;

    private List<ApiRdcReturnDetail> detailList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public Integer getBill_status() {
        return bill_status;
    }

    public void setBill_status(Integer bill_status) {
        this.bill_status = bill_status;
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(String receive_id) {
        this.receive_id = receive_id;
    }

    public String getUpload_id() {
        return upload_id;
    }

    public void setUpload_id(String upload_id) {
        this.upload_id = upload_id;
    }

    public DateTime getUpload_time() {
        return upload_time;
    }

    public void setUpload_time(DateTime upload_time) {
        this.upload_time = upload_time;
    }

    public String getSubmit_by() {
        return submit_by;
    }

    public void setSubmit_by(String submit_by) {
        this.submit_by = submit_by;
    }

    public String getScan_by() {
        return scan_by;
    }

    public void setScan_by(String scan_by) {
        this.scan_by = scan_by;
    }

    public List<ApiRdcReturnDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<ApiRdcReturnDetail> detailList) {
        this.detailList = detailList;
    }
}

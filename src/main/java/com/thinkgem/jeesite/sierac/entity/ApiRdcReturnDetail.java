package com.thinkgem.jeesite.sierac.entity;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * Created by jkf on 2017/5/2.
 *
 *  *  响应参数对象：

 |参数名称 |类型 |参数描述 |
 |-------|:---:|:------:|
 |header_id |String |Header id |
 |product_id |String |产品id |
 |product_code |String |产品代码 |
 |product_sku |String |产品SKU |
 |product_name |String |产品名称 |
 |send_id |String |发货方id |
 |receive_id |String |收货方id |
 |batch_code |String |批号 |
 |expect_qty_pcs |Integer |计划出库单品数 |
 |actual_qty_pcs |Integer |实际出库单品数 |

 *   *
 **/
public class ApiRdcReturnDetail extends DataEntity<ApiRdcReturnDetail> {

    private String header_id;

    private String product_id;

    private String product_code;

    private String product_sku;

    private String product_name;

    private String send_id;

    private String receive_id;

    private String batch_code;

    private Integer expect_qty_pcs;

    private Integer actual_qty_pcs;



    public String getHeader_id() {
        return header_id;
    }

    public void setHeader_id(String header_id) {
        this.header_id = header_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getProduct_sku() {
        return product_sku;
    }

    public void setProduct_sku(String product_sku) {
        this.product_sku = product_sku;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSend_id() {
        return send_id;
    }

    public void setSend_id(String send_id) {
        this.send_id = send_id;
    }

    public String getReceive_id() {
        return receive_id;
    }

    public void setReceive_id(String receive_id) {
        this.receive_id = receive_id;
    }

    public String getBatch_code() {
        return batch_code;
    }

    public void setBatch_code(String batch_code) {
        this.batch_code = batch_code;
    }

    public Integer getExpect_qty_pcs() {
        return expect_qty_pcs;
    }

    public void setExpect_qty_pcs(Integer expect_qty_pcs) {
        this.expect_qty_pcs = expect_qty_pcs;
    }

    public Integer getActual_qty_pcs() {
        return actual_qty_pcs;
    }

    public void setActual_qty_pcs(Integer actual_qty_pcs) {
        this.actual_qty_pcs = actual_qty_pcs;
    }
}

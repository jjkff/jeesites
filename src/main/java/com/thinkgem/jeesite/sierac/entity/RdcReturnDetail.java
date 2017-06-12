package com.thinkgem.jeesite.sierac.entity;

import java.util.Date;

import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * CRUD操作Entity
 * 
 * @author mjj
 * @version 2017-02-13
 */
public class RdcReturnDetail extends DataEntity<RdcReturnDetail> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String orderCode;// 退货单号

    private Date submitDate;// 退货日期

    private String returnCode;// 退货仓代码

    private String returnName;// 退货仓名称

    private String receiveId;// 收货仓id

    private String receivePhone;// 收货仓手机号

    private String receiveAddress;// 收货仓地址

    private String pCode;// 产品代码

    private String pName;// 产品名称

    private Integer expectPcsQty;// 计划发货数量

    private Integer actualPcsQty;// 实际发货数量

    private Integer diffQty;// 差异数量

    private Date beginSubmitDate; // 开始 出库单日期

    private Date endSubmitDate; // 结束 出库单日期

    private String productId; //

    private String headerId; //

    @ExcelField(title = "退货单号", align = 2, sort = 1)
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @ExcelField(title = "退货日期", align = 2, sort = 2)
    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    @ExcelField(title = "退货仓代码", align = 2, sort = 3)
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    @ExcelField(title = "退货仓名称", align = 2, sort = 4)
    public String getReturnName() {
        return returnName;
    }

    public void setReturnName(String returnName) {
        this.returnName = returnName;
    }

    @ExcelField(title = "收货仓代码", align = 2, sort = 5)
    public String getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(String receiveId) {
        this.receiveId = receiveId;
    }

    @ExcelField(title = "收货仓电话", align = 2, sort = 6)
    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    @ExcelField(title = "收货仓地址", align = 2, sort = 7)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @ExcelField(title = "产品代码", align = 2, sort = 8)
    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    @ExcelField(title = "产品名称", align = 2, sort = 9)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Date getBeginSubmitDate() {
        return beginSubmitDate;
    }

    public void setBeginSubmitDate(Date beginSubmitDate) {
        this.beginSubmitDate = beginSubmitDate;
    }

    public Date getEndSubmitDate() {
        return endSubmitDate;
    }

    public void setEndSubmitDate(Date endSubmitDate) {
        this.endSubmitDate = endSubmitDate;
    }

    @ExcelField(title = "计划退货数量", align = 2, sort = 10)
    public Integer getExpectPcsQty() {
        return expectPcsQty;
    }

    public void setExpectPcsQty(Integer expectPcsQty) {
        this.expectPcsQty = expectPcsQty;
    }

    @ExcelField(title = "成功退货数量", align = 2, sort = 11)
    public Integer getActualPcsQty() {
        return actualPcsQty;
    }

    public void setActualPcsQty(Integer actualPcsQty) {
        this.actualPcsQty = actualPcsQty;
    }

    @ExcelField(title = "差异数量", align = 2, sort = 12)
    public Integer getDiffQty() {
        return this.expectPcsQty - this.actualPcsQty;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

}
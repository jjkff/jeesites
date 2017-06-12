/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
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
public class RdcOutDetail extends DataEntity<RdcOutDetail> {

    /**
     * serialVersionUID:(用一句话描述这个变量表示什么).
     */
    private static final long serialVersionUID = 1L;

    private String orderCode;// 出库单号

    private Date sumitDate;// 出库单日期

    private String sendCode;// 发货仓代码

    private String sendName;// 发货仓名称

    private String receiveName;// 客户姓名

    private String receivePhone;// 客户电话

    private String receiveAddress;// 客户地址

    private String pName;// 产品名称

    private String pCode;// 产品代码

    private Integer expectPcsQty;// 计划发货数量

    private Integer actualPcsQty;// 实际发货数量

    private Integer diffQty;// 差异数量

    private Date scanBeginTime; // 开始 扫描时间

    private Date uploadTime; // 上传日期

    private Date beginSubmitDate; // 开始 出库单日期

    private Date endSubmitDate; // 结束 出库单日期

    private String headerId; //

    private String productId; //

    public RdcOutDetail() {

        super();
        // Auto-generated constructor stub

    }

    public RdcOutDetail(String id) {

        super(id);
        // Auto-generated constructor stub

    }

    @ExcelField(title = "出库单号", align = 2, sort = 1)
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @ExcelField(title = "出库日期", align = 2, sort = 2)
    public Date getSumitDate() {
        return sumitDate;
    }

    public void setSumitDate(Date sumitDate) {
        this.sumitDate = sumitDate;
    }

    @ExcelField(title = "发货仓代码", align = 2, sort = 3)
    public String getSendCode() {
        return sendCode;
    }

    public void setSendCode(String sendCode) {
        this.sendCode = sendCode;
    }

    @ExcelField(title = "发货仓名称", align = 2, sort = 4)
    public String getSendName() {
        return sendName;
    }

    public void setSendName(String sendName) {
        this.sendName = sendName;
    }

    @ExcelField(title = "客户姓名", align = 2, sort = 5)
    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    @ExcelField(title = "客户电话", align = 2, sort = 6)
    public String getReceivePhone() {
        return receivePhone;
    }

    public void setReceivePhone(String receivePhone) {
        this.receivePhone = receivePhone;
    }

    @ExcelField(title = "客户地址", align = 2, sort = 7)
    public String getReceiveAddress() {
        return receiveAddress;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @ExcelField(title = "产品名称", align = 2, sort = 9)
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @ExcelField(title = "产品代码", align = 2, sort = 8)
    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public Integer getExpectPcsQty() {
        return expectPcsQty;
    }

    public void setExpectPcsQty(Integer expectPcsQty) {
        this.expectPcsQty = expectPcsQty;
    }

    @ExcelField(title = "成功发货数", align = 2, sort = 10)
    public Integer getActualPcsQty() {
        return actualPcsQty;
    }

    public void setActualPcsQty(Integer actualPcsQty) {
        this.actualPcsQty = actualPcsQty;
    }

    public Integer getDiffQty() {
        return this.expectPcsQty - this.actualPcsQty;
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

    @ExcelField(title = "扫描开始时间", align = 2, sort = 11)
    public Date getScanBeginTime() {
        return scanBeginTime;
    }

    public void setScanBeginTime(Date scanBeginTime) {
        this.scanBeginTime = scanBeginTime;
    }

    @ExcelField(title = "上传日期", align = 2, sort = 12)
    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getHeaderId() {
        return headerId;
    }

    public void setHeaderId(String headerId) {
        this.headerId = headerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "RdcOutDetail [orderCode=" + orderCode + ", sumitDate=" + sumitDate + ", sendCode=" + sendCode
                + ", sendName=" + sendName + ", receiveName=" + receiveName + ", receivePhone=" + receivePhone
                + ", receiveAddress=" + receiveAddress + ", pName=" + pName + ", pCode=" + pCode + ", expectPcsQty="
                + expectPcsQty + ", actualPcsQty=" + actualPcsQty + ", diffQty=" + diffQty + ", scanBeginTime="
                + scanBeginTime + ", uploadTime=" + uploadTime + ", beginSubmitDate=" + beginSubmitDate
                + ", endSubmitDate=" + endSubmitDate + "]";
    }

}
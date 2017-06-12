
package com.thinkgem.jeesite.sierac.entity;

import javax.validation.constraints.NotNull;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thinkgem.jeesite.common.persistence.DataEntity;
import com.thinkgem.jeesite.common.utils.excel.annotation.ExcelField;

/**
 * 产品管理Entity
 * 
 * @author wgc
 * @version 2017-02-13
 */

public class Product extends DataEntity<Product> {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "产品代码不能为空")
    @Length(min = 3, max = 10, message = "退货单号请输入3到10个字节")
    private String code; // 产品代码

    private String sku; // 产品SKU

    @NotNull(message = "产品名称不能为空")
    private String name; // 产品名称

    private String fullName; // 产品全称

    @NotNull(message = "产品简介不能为空")
    private String shortName; // 产品简称

    private String englishName; // 英文名

    @NotNull(message = "规格不能为空")
    private String spec; // 规格

    @NotNull(message = "保质期不能为空")
    private Integer shelfLife; // 保质期

    private String ctnGtin; // 箱GTIN

    private String pcsGtin; // 单品GTIN

    private Integer typeId; // 产品类型

    private Integer active; // 可用

    @NotNull(message = "每箱单品数不能为空")
    private Integer pcsPerCtn; // 每箱单品数

    private Integer ctnPerPlt; // 每托箱数

    @NotNull(message = "条码不能为空")
    private String barcode; // 条码

    private String jdeCode; // JDE编码

    private String type;// 产品类型

    public Product(String id) {
        super(id);
    }

    public Product() {
        super();
    }

    public String getId() {
        return id;
    }

    @ExcelField(title = "产品代码", align = 2, sort = 20, type = 0)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    @ExcelField(title = "产品名称", align = 2, sort = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonIgnore
    @ExcelField(title = "产品简称", align = 2, sort = 30)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @JsonIgnore
    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    @ExcelField(title = "规格", align = 2, sort = 60)
    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

   
   @ExcelField(title = "保质期", align = 1, sort = 50)
    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getCtnGtin() {
        return ctnGtin;
    }

    public void setCtnGtin(String ctnGtin) {
        this.ctnGtin = ctnGtin;
    }

    public String getPcsGtin() {
        return pcsGtin;
    }

    public void setPcsGtin(String pcsGtin) {
        this.pcsGtin = pcsGtin;
    }

    @JsonIgnore
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @JsonIgnore
    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }
   @ExcelField(title = "每箱单品数", align = 2, sort = 40)
    public Integer getPcsPerCtn() {
        return pcsPerCtn;
    }

    public void setPcsPerCtn(Integer pcsPerCtn) {
        this.pcsPerCtn = pcsPerCtn;
    }

    public Integer getCtnPerPlt() {
        return ctnPerPlt;
    }

    public void setCtnPerPlt(Integer ctnPerPlt) {
        this.ctnPerPlt = ctnPerPlt;
    }

    @JsonIgnore
   @ExcelField(title = "条码", align = 2, sort = 45)
    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    @JsonIgnore
    public String getJdeCode() {
        return jdeCode;
    }

    public void setJdeCode(String jdeCode) {
        this.jdeCode = jdeCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product [code=" + code + ", sku=" + sku + ", name=" + name + ", fullName=" + fullName + ", shortName="
                + shortName + ", englishName=" + englishName + ", spec=" + spec + ", shelfLife=" + shelfLife
                + ", ctnGtin=" + ctnGtin + ", pcsGtin=" + pcsGtin + ", typeId=" + typeId + ", active=" + active
                + ", pcsPerCtn=" + pcsPerCtn + ", ctnPerPlt=" + ctnPerPlt + ", barcode=" + barcode + ", jdeCode="
                + jdeCode + ", type=" + type + ",delFlag=" + delFlag + "]";
    }

}

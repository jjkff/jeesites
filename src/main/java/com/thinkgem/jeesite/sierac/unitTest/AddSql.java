/**
 * Project Name:JeeSite
 * File Name:AddSql.java
 * Package Name:com.thinkgem.jeesite.sierac.unitTest
 * Date:2017年4月20日上午10:06:06
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.thinkgem.jeesite.sierac.unitTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.thinkgem.jeesite.sierac.entity.CodeData;
import com.thinkgem.jeesite.sierac.entity.Product;
import com.thinkgem.jeesite.sierac.entity.ProductionTask;
import com.thinkgem.jeesite.sierac.entity.QueryReport;
import com.thinkgem.jeesite.sierac.entity.RdcOutDetail;
import com.thinkgem.jeesite.sierac.entity.RdcOutHeader;
import com.thinkgem.jeesite.sierac.entity.RdcReturnDetail;
import com.thinkgem.jeesite.sierac.entity.RdcReturnHeader;
import com.thinkgem.jeesite.sierac.entity.RdcWarehouse;
import com.thinkgem.jeesite.sierac.service.CodeDataService;
import com.thinkgem.jeesite.sierac.service.ProductService;
import com.thinkgem.jeesite.sierac.service.ProductionTaskService;
import com.thinkgem.jeesite.sierac.service.QueryReportService;
import com.thinkgem.jeesite.sierac.service.RdcOutDetailService;
import com.thinkgem.jeesite.sierac.service.RdcOutHeaderService;
import com.thinkgem.jeesite.sierac.service.RdcReturnDetailService;
import com.thinkgem.jeesite.sierac.service.RdcReturnHeaderService;
import com.thinkgem.jeesite.sierac.service.RdcWarehouseService;

/**
 * Description: 添加sql脚本<br/>
 * Date: 2017年4月20日 上午10:06:06 <br/>
 * 
 * @author mjj
 * @version
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-context.xml" })
public class AddSql {
    @Autowired
    private CodeDataService codeDataService;

    @Autowired
    private QueryReportService queryReportService;

    @Autowired
    private RdcOutHeaderService rdcOutHeaderService;

    @Autowired
    private RdcOutDetailService rdcOutDetailService;

    @Autowired
    private RdcReturnHeaderService rdcReturnHeaderService;

    @Autowired
    private RdcReturnDetailService rdcReturnDetailService;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductionTaskService productionTaskService;

    @Autowired
    private RdcWarehouseService rdcWarehouseService;

    @Test
    public void test() throws ParseException {
        String test = "D:\\code.txt";
        String rdcWarehouseId[] = { "FDSF", "CDSG", "VBER", "HRTED", "HBER", "NMU6,", "CVERH", "N6MM", "VERV", "MFTR5" };
        String rdcWarehouseCode[] = { "MFHDM", " HDGNGF", "MNBBE", "NEYTM", "GTWNS", "MSRHNG,", "ME5DN", "MFHDG",
                "NTRRV", "MFTR5" };
        String rdcWarehouseName[] = { "常州仓库", "苏州仓库", "无锡仓库", "南京仓库", "镇江仓库", "扬州仓库", "徐州仓库", "宿迁仓库", "连云港仓库", "南通仓库" };
        String rdcOutHeaderId[] = { "aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh", "iii", "jjj" };
        String productId[] = { "000", "111", "222", "333", "444", "555", "666", "777", "888", "999" };// 产品id
        String productCode[] = { "HVKER", "VAEER", "BGSAFG", "TGRAEG", "BVRW", "GQWFGE", "BSAGBRES", "BGSBD", "NRTF",
                "BSERBG" };// 产品代码
        String productName[] = { "护肤", "爽肤水", "隔离霜", "眼膜", "口红护膜", "沐浴露", "润肤露", "磨砂膏", "露", "美白" };// 产品名称
        String productShortName[] = { "护肤", "爽肤水", "隔离霜", "眼膜", "口红护膜", "沐浴露", "润肤露", "磨砂膏", "露", "美白" };// 产品简称
        String productSpec[] = { "6164克/瓶", "2165克/台", "5235克/个", "675克/台", "465克/台", "1735克/支", "1644克/只", "5235克/台",
                "235克/个", "175克/个" };// 产品规格
        Integer productPcsPerCtn[] = { 414, 7536, 343, 1754, 853, 537, 62461, 6526, 651, 154 };// 每箱单品数
        String productBarcode[] = { "GFSVV", "HTSBS", "BDGFH", "TRWEHG", "BZFDGH", "GVAFVRES", "BNSDFB", "VAEH",
                "MYFNFGN", "NERSERBF" };// 条码
        String codeBatchCode[] = { "BSERV", "GBSZB", "VFAD", "GRABDB", "BFZB", "TRAEG", "HTSHTSR", "TGRAE", "GARE",
                "BVAFD" };
        String codepackDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
        String rhscanBeginTimeDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
        String rhsumbitDate[] = { "2018-04-14 13:25:54", "2019-04-14 09:25:54", "2016-04-14 12:35:50",
                "2017-04-24 09:20:14", "2017-01-14 11:25:54", "2017-04-14 09:27:33", "2017-12-14 20:25:54",
                "2027-03-14 19:25:54", "2017-04-14 10:34:54", "2017-04-44 19:25:54" };
        String rhorderCode[] = { "HTRSH", "GGFSDF", "NTTEDRE", "MNDT", "NHGSAR", "NSRTN", "GRAGFG", "BAEFGB", "T4GVFD",
                "NRTSN" };
        String rhsendName[] = { "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓", "总仓" };// 发货仓名称
        String rhsendCode[] = { "NGFNNBS", "NGFNNBS", "NGFNNBS", "NGFNNBS", "NGFNNBS", "NGFNNBS", "NGFNNBS", "NGFNNBS",
                "NGFNNBS", "NGFNNBS" };// 发货仓代码
        String rhreceiveName[] = { "张经理", "孔经理", "王经理", "李经理", "杨经理", "朱经理", "刘经理", "白经理", "关经理", "欧经理" };
        String rhreceivePhone[] = { "13486424617", "18086424617", "19086424637", "18082424617", "15286424617",
                "19686425317", "18043224617", "18086424663", "18386423617", "15286424625" };
        String rhreceiveAddress[] = { "江苏省常州市", "广东省广州市", "湖北省武汉市", "安徽省合肥市", "北京市", "广州市", "广西壮族自治区", "安徽省合肥市", "桂林",
                "青岛市" };
        List<String> list = readTxtFileIntoStringArrList(test);
        System.out.println("大小为:" + list.size());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 400; i++) {
            CodeData codeData = new CodeData();
            QueryReport queryReport = new QueryReport();
            if (i < 1) {
                for (int j = 0; j < 10; j++) {
                    RdcWarehouse rdcWarehouse = new RdcWarehouse();
                    RdcOutHeader rdcOutHeader = new RdcOutHeader();
                    RdcOutDetail rdcOutDetail = new RdcOutDetail();
                    RdcReturnHeader rdcReturnHeader = new RdcReturnHeader();
                    RdcReturnDetail rdcReturnDetail = new RdcReturnDetail();
                    Product product = new Product();
                    ProductionTask productionTask = new ProductionTask();
                    rdcWarehouse.setId(rdcWarehouseId[j]);
                    rdcWarehouse.setCode(rdcWarehouseCode[j]);
                    rdcWarehouse.setName(rdcWarehouseName[j]);
                    rdcWarehouse.setType(0);
                    rdcWarehouse.setIsScanUse("Y");
                    rdcWarehouse.setIsNewRecord(true);
                    product.setId(productId[j]);// 产品id
                    productionTask.setIsNewRecord(true);
                    productionTask.setProductid(productId[j]);
                    productionTask.setId(UUID.randomUUID().toString().substring(0, 6));
                    productionTask.setCode(UUID.randomUUID().toString().substring(0, 6));
                    productionTask.setBeginTime(sdf.parse(rhsumbitDate[j]));
                    productionTask.setBatchCode(UUID.randomUUID().toString().substring(0, 6));
                    productionTask.setLinecode(UUID.randomUUID().toString().substring(0, 6));
                    productionTask.setEndTime(sdf.parse(rhsumbitDate[j]));
                    productionTask.setPackDate(sdf.parse(rhsumbitDate[j]));
                    productionTask.setExpectctnqty("10000");
                    productionTask.setWarranty("完成");
                    productionTask.setTaskType("1");
                    productionTask.setStatus("0");
                    productionTask.setValidperiod(sdf.parse(rhsumbitDate[j]));
                    productionTask.setExpectqty("2000");
                    product.setCode(productCode[j]);// 产品代码
                    product.setName(productName[j]);// 产品名称
                    product.setShortName(productShortName[j]);// 产品简称
                    product.setSpec(productSpec[j]);// 产品规格
                    product.setShelfLife(12);// 保质期
                    product.setPcsPerCtn(productPcsPerCtn[j]);// 每箱单品数
                    product.setBarcode(productBarcode[j]);// 条码
                    product.setIsNewRecord(true);
                    rdcOutDetail.setId(rdcOutHeaderId[j]);
                    rdcOutDetail.setHeaderId(rdcOutHeaderId[j]);// 出库单据明细id
                    rdcOutDetail.setProductId(productId[j]);// 出库产品id
                    rdcOutDetail.setExpectPcsQty(200);
                    rdcOutDetail.setActualPcsQty(120);
                    rdcOutDetail.setIsNewRecord(true);
                    rdcOutDetailService.save(rdcOutDetail);
                    rdcOutHeader.setId(rdcOutHeaderId[j]);// 出库id
                    rdcOutHeader.setScanBeginTime(sdf.parse(rhscanBeginTimeDate[j]));// 扫描开始时间
                    rdcOutHeader.setSubmitDate(sdf.parse(rhsumbitDate[j]));// 出库单日期
                    rdcOutHeader.setUploadTime(sdf.parse(rhsumbitDate[j]));// 上传日期
                    rdcOutHeader.setOrderCode(rhorderCode[j]);// 出库单号
                    rdcOutHeader.setSendName(rhsendName[j]);// 发货仓名称
                    rdcOutHeader.setSendCode(rhsendCode[j]);// 发货仓代码
                    rdcOutHeader.setSendId("abcd");// 发货id
                    rdcOutHeader.setBillStatus("1");// 单据状态（未扫描）
                    rdcOutHeader.setReceiveName(rhreceiveName[j]);// 客户姓名
                    rdcOutHeader.setReceivePhone(rhreceivePhone[j]);// 客户手机号
                    rdcOutHeader.setReceiveAddress(rhreceiveAddress[j]);// 客户地址
                    rdcOutHeader.setScanBy("admin");
                    rdcOutHeader.setIsNewRecord(true);
                    rdcOutHeaderService.save(rdcOutHeader);
                    if (j % 2 == 0) {
                        rdcReturnHeader.setId(rdcOutHeaderId[j]);// 退货id
                        rdcReturnHeader.setOrderCode(rhorderCode[j]);// 退货单号
                        rdcReturnHeader.setSubmitDate(sdf.parse(rhsumbitDate[j]));// 退货日期
                        rdcReturnHeader.setReturnCode(rhsendCode[j]);// 退货仓代码
                        rdcReturnHeader.setReturnName(rhsendName[j]);// 退货仓名称
                        rdcReturnHeader.setReceiveId(rdcWarehouseId[j]);// 客户姓名
                        rdcReturnHeader.setReceivePhone(rhreceivePhone[j]);// 收货仓手机号
                        rdcReturnHeader.setReceiveAddress(rhreceiveAddress[j]);// 收货仓地址
                        rdcReturnHeader.setScanTime(sdf.parse(rhscanBeginTimeDate[j]));// 扫描开始时间
                        rdcReturnHeader.setUpdateTime(sdf.parse(rhsumbitDate[j]));// 上传日期
                        rdcReturnHeader.setBillStatus("0");// 单据状态（已扫描）
                        rdcReturnHeader.setIsNewRecord(true);
                        rdcReturnDetail.setIsNewRecord(true);
                        rdcReturnDetail.setId(rdcOutHeaderId[j]);
                        rdcReturnDetail.setProductId(productId[j]);// 退货产品id
                        rdcReturnDetail.setExpectPcsQty(120);
                        rdcReturnDetail.setActualPcsQty(80);
                        rdcReturnDetail.setHeaderId(rdcOutHeaderId[j]);// 退货单据明细id
                        rdcReturnHeaderService.save(rdcReturnHeader);
                        rdcReturnDetailService.save(rdcReturnDetail);
                    }
                    rdcWarehouseService.save(rdcWarehouse);
                    productService.save(product);
                    productionTaskService.save(productionTask);
                }
            }
            codeData.setBatchCode(codeBatchCode[i % 10]);
            Date date = sdf.parse(codepackDate[i % 10]);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, +24);
            codeData.setValidPeriod(cal.getTime());
            codeData.setPackDate(sdf.parse(codepackDate[i % 10]));
            if (i % 2 == 0) {
                codeData.setOutHeaderId(rdcOutHeaderId[i % 10]);
            }
            codeData.setProductId(productId[i % 10]);
            codeData.setCode(list.get(i));
            codeData.setCtnCode(UUID.randomUUID().toString().substring(0, 6));
            codeData.setLineCode(UUID.randomUUID().toString().substring(0, 6));
            queryReport.setIsNewRecord(true);
            queryReport.setId(UUID.randomUUID().toString().substring(0, 6));
            queryReport.setqCode(list.get(i));
            codeDataService.save(codeData);
            queryReportService.save(queryReport);
        }
    }

    /**
     * 写文件方法
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    if (!"".equals(lineTxt)) {
                        list.add(lineTxt);
                        System.out.println("每行的内容是这样的:" + lineTxt);
                    }
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        System.out.println("大小为" + list.size());
        return list;
    }
}

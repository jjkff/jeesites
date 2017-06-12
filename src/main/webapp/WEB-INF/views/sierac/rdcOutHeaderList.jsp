<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>出库信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
        $(document).ready(function() {
            $("#btnExport").click(function(){
                top.$.jBox.confirm("确认要导出出库单据信息吗？","系统提示",function(v,h,f){
                    if(v=="ok"){
                        $("#searchForm").attr("action","${ctx}/sierac/rdcOutHeader/export");
                        $("#searchForm").submit();
                    }
                },{buttonsFocus:1});
                top.$('.jbox-body .jbox-icon').css('top','55px');
            });
            $("#btnImport").click(function(){
                $.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true},
                    bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});
            });
        });
        function page(n,s){
            $("#pageNo").val(n);
            $("#pageSize").val(s);
            $("#searchForm").submit();
            return false;
        }
	</script>
</head>
<body>
<div id="importBox" class="hide">
	<form id="importForm" action="${ctx}/sierac/rdcOutHeader/import" method="post" enctype="multipart/form-data"
		  class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
		<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
		<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
		<a href="${ctx}/sierac/rdcOutHeader/import/template">下载模板</a>
	</form>
</div>
<ul class="nav nav-tabs">
	<li class="active"><a href="${ctx}/sierac/rdcOutHeader/list">出库信息列表</a></li>
	<shiro:hasPermission name="sierac:rdcOutHeader:edit"><li><a href="${ctx}/sierac/rdcOutHeader/form">出库信息添加</a></li></shiro:hasPermission>
</ul>
<form:form id="searchForm" modelAttribute="rdcOutHeader" action="${ctx}/sierac/rdcOutHeader/" method="post" class="breadcrumb form-search">
	<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
	<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
	<ul class="ul-form">
		<li><label>出库单号：</label>
			<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-medium"/>
		</li>
		<li><label>单据状态：</label>
                        <form:select path="billStatus" id="billStatus" class="input-xlarge">
                                        <form:option value="" label="请选择"/>
                                         <form:options items="${fns:getDictList('billStatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
                                 </form:select>    
         </li>

		<li><label>出库单日期：</label>
			<input name="beginSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				   value="<fmt:formatDate value="${rdcOutHeader.beginSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> -
			<input name="endSubmitDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
				   value="<fmt:formatDate value="${rdcOutHeader.endSubmitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
				   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
		</li>
		<li><label>发货仓名称：</label>
			<form:input path="sendName" htmlEscape="false" maxlength="255" class="input-medium"/>
		</li>
		<li><label>客户手机号：</label>
			<form:input path="receivePhone" htmlEscape="false" maxlength="64" class="input-medium"/>
		</li>
		<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>
			<input id="btnImport" class="btn btn-primary" type="button" value="导入"/>
		</li>
		<li class="clearfix"></li>
	</ul>
</form:form>
<sys:message content="${message}"/>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
	<thead>
	<tr>
		<th>出库单号</th>
		<th>发货仓代码</th>
		<th>发货仓名称</th>
		<th>客户姓名</th>
		<th>客户手机号</th>
		<th>客户地址</th>
		<th>单据状态</th>
		<th>出库日期</th>
		<th>扫描开始时间</th>
		<th>上传日期</th>
		<shiro:hasPermission name="sierac:rdcOutHeader:edit"><th>操作</th></shiro:hasPermission>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${page.list}" var="rdcOutHeader">
		<tr>
			<td>
					${rdcOutHeader.orderCode}
			</td>
			<td>
					${rdcOutHeader.sendCode}
			</td>
			<td>
					${rdcOutHeader.sendName}
			</td>
			<td>
					${rdcOutHeader.receiveName}
			</td>
			<td>
					${rdcOutHeader.receivePhone}
			</td>
			<td>
					${rdcOutHeader.receiveAddress}
			</td>
			<td>
				<c:choose>
					<c:when test="${rdcOutHeader.billStatus==0}">已扫描</c:when>
					<c:when test="${rdcOutHeader.billStatus==1}">未扫描</c:when>

				</c:choose>
			</td>
			<td>
				<fmt:formatDate value="${rdcOutHeader.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>
				<fmt:formatDate value="${rdcOutHeader.scanBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>
				<fmt:formatDate value="${rdcOutHeader.uploadTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<shiro:hasPermission name="sierac:rdcOutHeader:edit"><td>
				<a href="${ctx}/sierac/rdcOutDetail/form?id=${rdcOutHeader.id}">查看</a>
				<a href="${ctx}/sierac/rdcOutHeader/form?id=${rdcOutHeader.id}">修改</a>
				<a href="${ctx}/sierac/rdcOutHeader/delete?id=${rdcOutHeader.id}" onclick="return confirmx('确认要删除该出库信息吗？', this.href)">删除</a>
			</td></shiro:hasPermission>
		</tr>
	</c:forEach>
	</tbody>
</table>
<div class="pagination">${page}</div>
</body>
</html>
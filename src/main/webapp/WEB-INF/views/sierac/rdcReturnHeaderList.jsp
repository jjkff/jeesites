<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>退货单据信息管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#btnExport").click(function(){
				top.$.jBox.confirm("确认要导出退货单据信息吗？","系统提示",function(v,h,f){
					if(v=="ok"){
						$("#searchForm").attr("action","${ctx}/sierac/rdcReturnHeader/export");
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
		<form id="importForm" action="${ctx}/sierac/rdcReturnHeader/import" method="post" enctype="multipart/form-data"
			class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>
			<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　
			<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>
			<a href="${ctx}/sierac/rdcReturnHeader/import/template">下载模板</a>
		</form>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/rdcReturnHeader/">退货信息列表</a></li>
		<shiro:hasPermission name="sierac:rdcReturnHeader:edit"><li><a href="${ctx}/sierac/rdcReturnHeader/form">退货信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="rdcReturnHeader" action="${ctx}/sierac/rdcReturnHeader/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>退货单号：</label>
				<form:input path="orderCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>退货日期：</label>
				<input name="beginUpdateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcReturnHeader.beginUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/> - 
				<input name="endUpdateTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${rdcReturnHeader.endUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li><label>退货仓代码：</label>
				<form:input path="returnCode" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>退货仓名称：</label>
				<form:input path="returnName" htmlEscape="false" maxlength="64" class="input-medium"/>
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
				<th>退货单号</th>
				<th>退货日期</th>
				<th>退货仓代码</th>
				<th>退货仓名称</th>
				<th>收货仓id</th>
				<th>收货仓手机号</th>
				<th>收货仓地址</th>
				<th>开始扫描时间</th>
				<th>上传日期</th>
				<th>单据状态</th>
				<shiro:hasPermission name="sierac:rdcReturnHeader:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="rdcReturnHeader">
			<tr>
				<td>
					${rdcReturnHeader.orderCode}
				</td>
				<td>
					<fmt:formatDate value="${rdcReturnHeader.submitDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>


				<td>
					${rdcReturnHeader.returnCode}
				</td>
				<td>
					${rdcReturnHeader.returnName}
				</td>
				<td>
					${rdcReturnHeader.receiveId}
				</td>
				<td>
					${rdcReturnHeader.receivePhone}
				</td>
				<td>
					${rdcReturnHeader.receiveAddress}
				</td>
				<td>
					<fmt:formatDate value="${rdcReturnHeader.scanTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<td>
					<fmt:formatDate value="${rdcReturnHeader.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>

				<td>
					<c:choose>
						<c:when test="${rdcReturnHeader.billStatus==0}">已扫描</c:when>
						<c:when test="${rdcReturnHeader.billStatus==1}">未扫描</c:when>
					</c:choose>
				</td>
				</td>
				<shiro:hasPermission name="sierac:rdcReturnHeader:edit"><td>
					<a href="${ctx}/sierac/rdcReturnDetail/form?id=${rdcReturnHeader.id}">查看</a>
    				<a href="${ctx}/sierac/rdcReturnHeader/form?id=${rdcReturnHeader.id}">修改</a>
					<a href="${ctx}/sierac/rdcReturnHeader/delete?id=${rdcReturnHeader.id}" onclick="return confirmx('确认要删除该退货单据信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
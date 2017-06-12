<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学员信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		<%--$(document).ready(function() {--%>
			<%--$("#btnExport").click(function(){--%>
				<%--top.$.jBox.confirm("确认要导出产品数据吗？","系统提示",function(v,h,f){--%>
					<%--if(v=="ok"){--%>
						<%--$("#searchForm").attr("action","${ctx}/sierac/product/export");--%>
						<%--$("#searchForm").submit();--%>
					<%--}--%>
				<%--},{buttonsFocus:1});--%>
				<%--top.$('.jbox-body .jbox-icon').css('top','55px');--%>
			<%--});--%>
			<%--$("#btnImport").click(function(){--%>
				<%--$.jBox($("#importBox").html(), {title:"导入数据", buttons:{"关闭":true}, --%>
					<%--bottomText:"导入文件不能超过5M，仅允许导入“xls”或“xlsx”格式文件！"});--%>
			<%--});--%>
		<%--});--%>
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
		<%--<form id="importForm" action="${ctx}/sierac/product/import" method="post" enctype="multipart/form-data"--%>
			<%--class="form-search" style="padding-left:20px;text-align:center;" onsubmit="loading('正在导入，请稍等...');"><br/>--%>
			<%--<input id="uploadFile" name="file" type="file" style="width:330px"/><br/><br/>　　--%>
			<%--<input id="btnImportSubmit" class="btn btn-primary" type="submit" value="   导    入   "/>--%>
			<%--<a href="${ctx}/sierac/product/import/template">下载模板</a>--%>
		<%--</form>--%>
	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/student/">学员信息</a></li>
		<shiro:hasPermission name="sierac:student:edit"><li><a href="${ctx}/sierac/student/form">学生</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="student" action="${ctx}/sierac/student/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">

			<li><label>学生姓名：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
			   <%--<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>--%>
				<%--<input id="btnImport" class="btn btn-primary" type="button" value="导入"/></li>--%>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>

				<th>姓名</th>
				<th>年龄</th>
				<th>班级</th>
				<th>住址</th>
				<th>班主任</th>
				<shiro:hasPermission name="sierac:student:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="student">
			<tr>

				<td>
					<a href="${ctx}/sierac/student/form?id=${student.id}">
					    ${student.name}
				    </a>
				</td>
				<td>
						${student.age}
				</td>
				<td>
						${student.gradeId}
				</td>
				<td>
						${student.address}
				</td>
				<td>
						${student.teacherName}
				</td>


				<shiro:hasPermission name="sierac:student:edit"><td>
    				<a href="${ctx}/sierac/student/formUp?id=${student.id}">修改</a>
					<a href="${ctx}/sierac/student/delete?id=${student.id}" onclick="return confirmx('确认要删除该信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
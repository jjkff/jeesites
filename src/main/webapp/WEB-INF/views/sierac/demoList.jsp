<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经销商信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">


		//分页
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
            $("#searchForm").submit();
        	return false;
        }

		//重置
        $(function(){
            $('#resets').click(function(){
                $('#num').val("");
                $('#name').val("");
//				alert( document.getElementById("isEnable").value);
//                document.getElementById("isEnable").options[''].selected = true;
//                alert(document.getElementById("isEnable").options[1].value);

            });
        })
       
		
	</script>
</head>
<body>
<div id="importBox" class="hide">

	</div>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sierac/demo/">经销商列表</a></li>
		<shiro:hasPermission name="sierac:demo:edit">
			<li><a href="${ctx}/sierac/demo/formAdd">经销商添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="demo" action="${ctx}/sierac/demo/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>客户号：</label>
				<form:input path="num" htmlEscape="false" maxlength="64" class="input-medium" id="num"/>
			</li>
			<li><label>客户名称：</label>
				<form:input path="name" htmlEscape="false" maxlength="255" class="input-medium" id="name"/>
			</li>
			<li><label>是否启用：</label>
				<form:select path="isEnable"  class="input-xlarge" id="isEnable">
					<form:option value="" label="所有"/>
					<form:options id="isEnableValue" items="${fns:getDictList('isEnable')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				</form:select>
			</li>

			<%--<div class="control-group">--%>
				<%--<label class="control-label">扫描可用：</label>--%>
				<%--<div class="controls">--%>
						<%--&lt;%&ndash;<form:input path="isScanUse" htmlEscape="false" maxlength="255"&ndash;%&gt;--%>
						<%--&lt;%&ndash;class="input-xlarge" />&ndash;%&gt;--%>

					<%--<form:select path="isScanUse" id="isScanUse" class="input-xlarge">--%>
						<%--<form:option value="" label="请选择"/>--%>
						<%--<form:options items="${fns:getDictList('isScanUse')}" itemLabel="label" itemValue="value" htmlEscape="false"/>--%>
					<%--</form:select>--%>
					<%--<span class="help-inline"><font color="red">*</font> </span>--%>
				<%--</div>--%>
			<%--</div>--%>
			<%----%>

			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>
				<%--<input id="btnExport" class="btn btn-primary" type="button" value="导出"/>--%>
				<%--<input id="btnImport" class="btn btn-primary" type="button" value="导入"/></li>--%>
				<input id="resets" class="btn btn-primary" type="button" value="重置" />
			<li class="clearfix"></li>

		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>客户号</th>
				<th>CUDE号</th>
				<th>客户名称</th>
				<th>收货地址</th>
				<th>是否启用</th>
				<th>增加时间</th>
				<shiro:hasPermission name="sierac:demo:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="demo">
			<tr>
				<td>
					<%--<a href="${ctx}/sierac/demo/form?id=${demo.id}">--%>
					${demo.num}
				</a></td>

				<td>
					${demo.cude}
				</td>

				<td>
					${demo.name}
				</td>
				<td>
					${demo.address}
				</td>
				<td>
					${demo.isEnable == '1' ? '启用': '不启用'}
				</td>
				<td>
					${demo.myCreateDate}
				</td>
				<shiro:hasPermission name="sierac:demo:edit"><td>
					<a href="${ctx}/sierac/demo/form?id=${demo.id}">查看详情</a>
    				<%--<a href="${ctx}/sierac/demo/formUp?id=${demo.id}">修改</a>--%>
					<%--<a href="${ctx}/sierac/demo/delete?id=${demo.id}" onclick="return confirmx('确认要删除该经销商吗？', this.href)">删除</a>--%>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>
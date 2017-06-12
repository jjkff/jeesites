<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>工厂信息详细</title>
	<meta name="decorator" content="default"/>

</head>
<body>
<ul class="nav nav-tabs">
	<li><a href="${ctx}/sierac/factory/">工厂列表</a></li>
	<li class="active"><a href="${ctx}/sierac/factory/form?id=${factory.id}">工厂<shiro:hasPermission name="sierac:factory:edit">${not empty factory.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:factory:edit"></shiro:lacksPermission></a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="factory" action="${ctx}/sierac/factory/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">
		<label class="control-label" id="code">工厂代码：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="code" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="code" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" id="name">工厂名称：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="name" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="name" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="name">联系人：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="contacts" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="contacts" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="name">联系电话：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="tel" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="tel" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="name">详细地址：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="address" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="address" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="name">增加人：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="myCreateBy" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="myCreateBy" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="name">增加时间：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="mycreateDate" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="mycreateDate" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="name">更新人：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="myUpdateBy" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="myUpdateBy" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="name">更新时间：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty factory.id}">
					<form:input path="myupdateDate" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="myupdateDate" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="form-actions">
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>
</html>
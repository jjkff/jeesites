<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经销商信息添加</title>
	<meta name="decorator" content="default"/>

</head>
<body>
<ul class="nav nav-tabs">
	<li><a href="${ctx}/sierac/distributor/">经销商列表</a></li>
	<li class="active"><a href="${ctx}/sierac/distributor/form?id=${distributor.id}">经销商<shiro:hasPermission name="sierac:distributor:edit">${not empty distributor.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:distributor:edit"></shiro:lacksPermission></a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="distributor" action="${ctx}/sierac/distributor/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">
		<label class="control-label" id="num">客户号：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="num" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="num" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="name">经销商名称：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
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
		<label class="control-label" id="assessmentCity">考核城市：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="assessmentCity" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="assessmentCity" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>



	<div class="control-group">
		<label class="control-label" id="fullName">全称：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="fullName" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="fullName" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="contacts">联系人：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
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
		<label class="control-label" id="tel">联系电话：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
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
		<label class="control-label" id="province">省份：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="province" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="province" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="city">城市：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="city" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="city" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="area">区县：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
					<form:input path="area" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="area" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="address">收货地址：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty distributor.id}">
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
		<label class="control-label">是否启用：</label>
		<div class="controls">
			<form:select path="isEnable" id="isEnable" class="input-xlarge">
				<form:option value="" label="请选择"/>
				<form:options items="${fns:getDictList('isEnable')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
			</form:select>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label">备注信息：</label>
		<div class="controls">
				<%--<form:input path="remarks" htmlEscape="false" maxlength="255"--%>
				<%--class="input-xlarge" />--%>
			<form:textarea id="name" htmlEscape="true" path="remarks" rows="4" maxlength="200" class="input-xxlarge"/>
			<tags:ckeditor replace="name" uploadPath="/test " />
		</div>
	</div>


	<div class="form-actions">
		<shiro:hasPermission name="sierac:distributor:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
		<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
	</div>
</form:form>
</body>
</html>
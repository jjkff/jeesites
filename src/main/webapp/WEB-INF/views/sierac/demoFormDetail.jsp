<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>经销商信息详细</title>
	<meta name="decorator" content="default"/>

</head>
<body>
<ul class="nav nav-tabs">
	<li><a href="${ctx}/sierac/demo/">经销商列表</a></li>
	<li class="active"><a href="${ctx}/sierac/demo/form?id=${demo.id}">经销商<shiro:hasPermission name="sierac:demo:edit">${not empty demo.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:demo:edit"></shiro:lacksPermission></a></li>
</ul><br/>
<form:form id="inputForm" modelAttribute="demo" action="${ctx}/sierac/demo/save" method="post" class="form-horizontal">
	<form:hidden path="id"/>
	<sys:message content="${message}"/>
	<div class="control-group">
		<label class="control-label" id="code">客户号：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
				<c:when test="${empty demo.id}">
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
		<label class="control-label" id="alternate_1">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_1" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_1" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>




	<div class="control-group">
		<label class="control-label" id="alternate_2">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_2" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_2" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="alternate_3">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_3" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_3" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="alternate_4">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_4" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_4" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="alternate_5">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_5" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_5" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>

	<div class="control-group">
		<label class="control-label" id="alternate_6">备用字段1：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="alternate_6" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="alternate_6" htmlEscape="false" maxlength="255"
								class="input-xlarge" readonly="true" />
				</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
		</div>
	</div>


	<div class="control-group">
		<label class="control-label" id="remarks">备注：</label>
		<div class="controls">
			<c:choose>
				<c:when test="${empty demo.id}">
					<form:input path="remarks" htmlEscape="false" maxlength="255"
								class="input-xlarge" />
				</c:when>
				<c:otherwise>
					<form:input path="remarks" htmlEscape="false" maxlength="255"
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
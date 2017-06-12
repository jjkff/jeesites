<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<script src="../../../../static/jquery-validation/1.11.0/jquery.validate.js" type="text/javascript"></script>
<script src="../../../../static/jquery-validation/1.11.0/additional-methods.js" type="text/javascript"></script>
<head>
<title>出库信息管理</title>
<meta name="decorator" content="default" />
<script type="text/javascript">
	$(document).ready(
			function() {
				//$("#name").focus();
				changeCode();
				$("#inputForm").validate({
					rules:{
						orderCode:{
							required: true,
							rangelength:[3,10],
							remote:"${ctx}/sierac/rdcOutHeader/checkOrderCode?oldcode=" + encodeURIComponent('${rdcOutHeader.orderCode}')
						},
						code:{
							required: true,
							rangelength:[3,10]
						},
						receiveName:{
							required: true,
							userName:true
						},
						receivePhone:{
							required: true,
							mobile:true
						},
						receiveAddress:{
							required: true
						},
						billStatus:{
							required: true,
							number:true
						},
						submitDate:{
							required: true
						},
						scanBeginTime:{
							required: true
						},
						uploadTime:{
							required: true
						},
					},
					messages: {
						orderCode: {
							required: "出库单号不能为空",
							rangelength:"长度介于3到10之间"	,
							remote:"该出库单号已存在,请重新输入"
						},
						code: {
							required: "发货仓代码不能为空",
							rangelength:"长度介于3到10之间"	
						},
						receiveName: {
							required: "客户姓名不能为空",
							userName:"客户姓名只能包括中文字、英文字母、数字和下划线"
						},
						receivePhone: {
							required: "客户手机号不能为空",
						},
						receiveAddress: {
							required: "客户不能为空",
						},
						billStatus: {
							required: "单据状态不能为空",
						},
						submitDate:{
							required:"出库日期不能为空",
						},
						scanBeginTime:{
							required: "扫描开始时间不能为空",
						},
						uploadTime:{
							required: "上传日期不能为空",
						},
					},
					submitHandler : function(form) {
						loading('正在提交，请稍等...');
						form.submit();
					},
					errorContainer : "#messageBox",
					errorPlacement : function(error, element) {
						$("#messageBox").text("输入有误，请先更正。");
						if (element.is(":checkbox")
							|| element.is(":radio")
							|| element.parent().is(
								".input-append")) {
							error.appendTo(element.parent()
							.parent());
						} else {
						error.insertAfter(element);
						}
					}
				});
			});
	$(function() {
		$("#name").change(function() {
			changeCode();
		});
	});
	function changeCode() {
		$("#msg").html("");
		if ($("#name").val() == "") {
			return;
		}
		$.ajax({
			async : false,
			url : "${ctx}/sierac/rdcOutHeader/ajax",
			type : "post",
			data : {
				name : $("#name").val()
			},
			dataType : "json",
			success : function(data) {
				$("#code").val(data.code);
				$("#code").attr("value",data.code);
			}
		});
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sierac/rdcOutHeader/list">出库信息列表</a></li>
		<li class="active"><a
			href="${ctx}/sierac/rdcOutHeader/form?id=${rdcOutHeader.id}">出库信息<shiro:hasPermission
					name="sierac:rdcOutHeader:edit">${not empty rdcOutHeader.id?'修改':'添加'}</shiro:hasPermission>
				<shiro:lacksPermission name="sierac:rdcOutHeader:edit">查看</shiro:lacksPermission></a></li>
	</ul>
	<br />
	<form:form id="inputForm" modelAttribute="rdcOutHeader"
		action="${ctx}/sierac/rdcOutHeader/save" method="post"
		class="form-horizontal">
		<form:hidden path="id" />
		<sys:message content="${message}" />
		<div class="control-group">
			<label class="control-label">出库单号：</label>
			<div class="controls">
			<c:choose>
					<c:when test="${empty rdcOutHeader.id}">
						<form:input id="orderCode" path="orderCode" htmlEscape="false" maxlength="64" class="input-xlarge" />
					</c:when>
					<c:otherwise>
						<form:input id="orderCode" path="orderCode" htmlEscape="false" maxlength="64" class="input-xlarge" readonly="true"/>
					</c:otherwise>
				</c:choose>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发货仓代码：</label>
			<div class="controls">
				<!-- <input id="code" path="sendCode" class="input-xlarge" type="text" value="" disabled /> -->
			   <form:input id="code" path="sendCode"  htmlEscape="false"  class="input-xlarge" readonly="true" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">发货仓名称：</label>
			<div class="controls">
				<form:select class="input-xlarge" id="name" path="sendName">
					<c:forEach items="${warehouse }" var="warehouse">
						<option class="controls" value="${warehouse}">${warehouse }</option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户姓名：</label>
			<div class="controls">
				<form:input id="receiveName" path="receiveName" htmlEscape="false"
					 class="input-xlarge " />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户手机号：</label>
			<div class="controls">
				<form:input id="receivePhone" path="receivePhone" htmlEscape="false" 
					class="input-xlarge " />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">客户地址：</label>
			<div class="controls">
				<form:input id="receiveAddress" path="receiveAddress" htmlEscape="false" maxlength="64"
					class="input-xlarge " />
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">单据状态：</label>
			<div class="controls">
		<%-- 		<form:input id="billStatus" path="billStatus" htmlEscape="false" maxlength="64"
					class="input-xlarge " /> --%>
				<form:select path="billStatus" id="billStatus" class="input-xlarge">
					<form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('billStatus')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				 </form:select> 
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">出库日期：</label>
			<div class="controls">
				<input name="submitDate" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcOutHeader.scanBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
					<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">扫描开始时间：</label>
			<div class="controls">
				<input name="scanBeginTime" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcOutHeader.scanBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
					<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">上传日期：</label>
			<div class="controls">
				<input name="uploadTime" type="text" readonly="readonly"
					maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${rdcOutHeader.scanBeginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});" />
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
			<shiro:hasPermission name="sierac:rdcOutHeader:edit">
				<input id="btnSubmit" class="btn btn-primary" type="submit"
					value="保 存" />&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回"
				onclick="history.go(-1)" />
		</div>
	</form:form>
</body>
</html>
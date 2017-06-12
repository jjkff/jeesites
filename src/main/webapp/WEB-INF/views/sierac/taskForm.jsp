<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>生产任务管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
			   rules:{
			       code:{required:true,rangelength:[5,10],
                       remote:"${ctx}/sierac/productiontask/check?oldcode=" + encodeURIComponent('${productiontask.code}')

			       },
			   packDate:{required:true},
			     beginTime:{required:true},
			     endTime:{required:true},
			     validperiod:{required:true},
			     expectqty:{required:true},
			     linecode:{required:true,rangelength:[3,10]},
			     batchCode:{required:true,rangelength:[3,10]}
			    
			   },
			   messages:{
			    code:{required:"任务编码不能为空",rangelength:"编码长度介于5-10之间",remote:"该产品编码已经存在，请重新输入"},
			    packDate:{required:"包装日期不能为空"},
			    beginTime:{required:"任务开始时间不能为空"},
			    endTime:{required:"任务结束时间不能为空"},
			    validperiod:{required:"有效期不能为空"},
			    expectqty:{required:"计划产量不能为空"},
			    lineCode:{required:"生产线号不能为空",rangelength:"生产线号长度介于3-10之间"},
			    batchCode:{required:"任务代码不能为空",rangelength:"任务代码长度介于3-10之间"}
                },
			 
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sierac/productiontask/">生产任务列表</a></li>
		<li class="active"><a href="${ctx}/sierac/productiontask/form?id=${productiontask.id}">生产任务<shiro:hasPermission name="sierac:productiontask:edit">${not empty productiontask.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:productiontask:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="productiontask" action="${ctx}/sierac/productiontask/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>	
		<div class="control-group">
			<label class="control-label">任务代码：</label>
			<div class="controls">
			<c:choose>
			<c:when test="${empty productiontask.id}">
			<form:input path="code" htmlEscape="false" maxlength="64" class="input-xlarge"/>
			</c:when>
			<c:otherwise>
			<form:input path="code" htmlEscape="false" maxlength="64" class="input-xlarge" readonly="true"/>
			</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务批号：</label>
			<div class="controls">
			<c:choose>
			<c:when test="${empty productiontask.id}">
				<form:input path="batchCode" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</c:when>
			<c:otherwise>
			<form:input path="batchCode" htmlEscape="false" maxlength="64" class="input-xlarge " readonly="true"/>
			</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">生产线号：</label>
			<div class="controls">
			<c:choose>
			<c:when test="${empty productiontask.id }">
			<form:input path="linecode" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</c:when>
			<c:otherwise>
			<form:input path="linecode" htmlEscape="false" maxlength="64" class="input-xlarge " readonly="true"/>
			</c:otherwise>
			</c:choose>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">包装日期：</label>
			<div class="controls">
				<input name="packDate" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${productiontask.packDate}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计划产量：</label>
			<div class="controls">
				<form:input path="expectqty" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">开始时间：</label>
			<div class="controls">
				<input name="beginTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${productiontask.beginTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">结束时间：</label>
			<div class="controls">
				<input name="endTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${productiontask.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">有效期：</label>
			<div class="controls">
				<input name="validperiod" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate "
					value="<fmt:formatDate value="${productiontask.validperiod}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">状态：</label>
			<div class="controls">
		
				<form:select path="status" id="status" class="input-xlarge">
					<form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('status')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				 </form:select> 
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">任务类型：</label>
			
			<div class="controls">
				<form:select path="taskType" id="taskType" class="input-xlarge">
			     <form:option value="" label="请选择"/>
					 <form:options items="${fns:getDictList('taskType')}" itemLabel="label" itemValue="value" htmlEscape="false"/>
				 </form:select> 
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">保证：</label>
			<div class="controls">
				<form:input path="warranty" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">计划箱产量：</label>
			<div class="controls">
				<form:input path="expectctnqty" htmlEscape="false" maxlength="64" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">产品名称:</label>

		<div class="controls">
			<form:select class="input-xlarge" id="name" path="name">
				<c:forEach items="${productNames }" var="productNames">
					<option class="controls" value="${productNames}">${productNames }</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sierac:productiontask:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
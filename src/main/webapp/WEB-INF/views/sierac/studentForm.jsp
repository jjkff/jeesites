<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>学生信息</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#name").focus();
			$("#inputForm").validate({
			   rules:{

			     name:{
			       required:true,
			      rangelength:[1,10]
			     }
			   },
			   messages:{

			   
			    name:{
			       required:"姓名不能为空",
			       rangelength:"名称长度介于1-10之间"
			    }


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
		<li><a href="${ctx}/sierac/student/">信息列表</a></li>
		<li class="active"><a href="${ctx}/sierac/student/form?id=${student.id}">学生<shiro:hasPermission name="sierac:student:edit">${not empty student.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sierac:student:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="student" action="${ctx}/sierac/student/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		

		<div class="control-group">
			<label class="control-label" id="name">学生姓名：</label>
			<div class="controls">
				 <c:choose>
                                        <c:when test="${empty student.id}">
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
			<label class="control-label" id="remarks">备注信息：</label>
			<div class="controls">
				 <form:textarea path="remarks" htmlEscape="false" rows="4" maxlength="255" class="input-xxlarge "/> 
			</div>
		</div>
		<div class="form-actions">
			<shiro:hasPermission name="sierac:student:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>
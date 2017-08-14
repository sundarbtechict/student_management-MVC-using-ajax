<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${statusVO.statusCode != null}">
	<c:if test="${statusVO.statusCode=='SUCCESS'}">
		<div class="alert alert-success alert-dismissable"
			style="text-align: center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${statusVO.statusCode}" /></strong>
			<c:out value="${statusVO.statusMsg}" />
		</div>
	</c:if>
	<c:if test="${statusVO.statusCode == 'FAILURE'}">
		<div class="alert alert-warning alert-dismissable"
			style="text-align: center;">
			<a href="#" class="close" data-dismiss="alert">×</a> <strong><c:out
					value="${statusVO.statusCode}" /></strong>
			<c:out value="${statusVO.statusMsg}" />
		</div>
	</c:if>
</c:if>

<br>
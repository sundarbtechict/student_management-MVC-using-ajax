<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<c:choose>

	<%-- If Multiple (List of) statusVO available --%>
	<c:when test="${statusVOs != null}">

		<c:forEach items="${statusVOs}" var="statusVO">


			<c:if test="${statusVO.statusCode != null}">
				<c:if test="${statusVO.statusCode=='SUCCESS'}">
					<div class="alert alert-success alert-dismissable text-center">
						<a href="#" class="close" data-dismiss="alert">×</a> <strong>Success:
						</strong>
						<c:out value="${statusVO.statusMsg}" />
					</div>
				</c:if>
				<c:if test="${statusVO.statusCode == 'FAILURE'}">
					<div class="alert alert-danger alert-dismissable text-center">
						<a href="#" class="close" data-dismiss="alert">×</a> <strong>Error:
						</strong>
						<c:out value="${statusVO.statusMsg}" />
					</div>
				</c:if>

				<c:if test="${statusVO.statusCode == 'WARNING'}">
					<div class="alert alert-warning alert-dismissable text-center">
						<a href="#" class="close" data-dismiss="alert">×</a> <strong>Error:
						</strong>
						<c:out value="${statusVO.statusMsg}" />
					</div>
				</c:if>

			</c:if>

		</c:forEach>
	</c:when>

	<%-- else (expected is only one statusVO) --%>

	<c:otherwise>
		<c:if test="${statusVO.statusCode != null}">
			<c:if test="${statusVO.statusCode=='SUCCESS'}">
				<div class="alert alert-success alert-dismissable text-center">
					<a href="#" class="close" data-dismiss="alert">×</a> <strong>Success:
					</strong>
					<c:out value="${statusVO.statusMsg}" />
				</div>
			</c:if>
			<c:if test="${statusVO.statusCode == 'FAILURE'}">
				<div class="alert alert-danger alert-dismissable text-center">
					<a href="#" class="close" data-dismiss="alert">×</a> <strong>Error:
					</strong>
					<c:out value="${statusVO.statusMsg}" />
				</div>
			</c:if>

			<c:if test="${statusVO.statusCode == 'WARNING'}">
				<div class="alert alert-warning alert-dismissable text-center">
					<a href="#" class="close" data-dismiss="alert">×</a> <strong>Error:
					</strong>
					<c:out value="${statusVO.statusMsg}" />
				</div>
			</c:if>
		</c:if>
	</c:otherwise>
</c:choose>




<br>
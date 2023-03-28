<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
	<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>

	<img src="${pageContext.request.contextPath}/img/spring-jeans.png" style="width: 300px; height: 300px;">	

	<h1>글 목록</h1>
	<div>
	 <table>
            <thead>
                <tr>
                    <th>글 번호</th>
                    <th>글 제목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                	<c:when test="${not empty boardList}">
                		<c:forEach items="${boardList}" var="board">
                			<tr>
		                        <td>${board.id}</td>
		                        <td>
		                        	<a href="${pageContext.request.contextPath}/board/${board.id}">
		                        		${board.subject}(${board.replyList.size()})
	                        		</a>
		                        </td>
		                        <td>${board.memberVO.name}</td>
		                        <td>${board.crtDt}</td>
                    		</tr>
                		</c:forEach>
                	</c:when>
                	<c:otherwise>
                		<tr>
                			<td colspan="4">
                			등록된 토픽이 없습니다.
                			첫 번째 토픽의 주인공이 되어보세요!
                			</td>
                		</tr>
                	</c:otherwise>
                </c:choose>
            </tbody>
        </table>
	</div>
	<a href="${pageContext.request.contextPath}/board/write">글 작성</a>
</body>
</html>
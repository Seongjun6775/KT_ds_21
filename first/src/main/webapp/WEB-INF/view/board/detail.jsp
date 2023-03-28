<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

	<h1>${board.subject}</h1>
	<div>${board.memberVO.name}(${board.memberVO.email})</div>
	<div>작성일: ${board.crtDt} / 수정일: ${board.mdfyDt}</div>
	<div>첨부파일:
		<c:forEach items="${board.attachFileList}" var="attach">
			${attach.originFileName}(${attach.fileSize}) ${attach.fileExt}
		</c:forEach>
	</div>
	<div>${board.content}</div>
	<hr />
	<form action="${pageContext.request.contextPath}/board/reply/create" method="post">
		<input type="hidden" name="boardId" value="${board.id}" /> 
		<input type="hidden" name="prntReplyId" value="0"/>

<!-- 		<div>
			<label for="email">작성자 이메일</label> <input type="email" name="email"
				id="email" />
		</div> -->
		<div>
			<label for="reply">댓글 내용</label>
			<textarea name="reply" id="reply"></textarea>
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
	<hr />
	<ul>
		<c:forEach items="${board.replyList}" var="reply">
			<li style="margin-left:${reply.depth * 30}px;">${reply.reply}</li>
		</c:forEach>
	</ul>
	<a href="${pageContext.request.contextPath}/boards">목록</a>
	<a href="${pageContext.request.contextPath}/board/update/${board.id}">수정</a>
	<a href="${pageContext.request.contextPath}/board/delete/${board.id}">삭제</a>
	
</body>
</html>
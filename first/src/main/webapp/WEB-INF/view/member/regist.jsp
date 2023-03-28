<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
		$("#submit_btn").click(function(event){
			event.preventDefault();
			if($.trim($("#email").val()) == ""){
				alert("이메일을 입력하세요")
				$("#email").focus();
				return;
			}
			if($.trim($("#name").val()) == ""){
				alert("이메일을 입력하세요")
				$("#name").focus();
				return;
			}
			if($.trim($("#password").val()) == ""){
				alert("이메일을 입력하세요")
				$("#password").focus();
				return;
			}
			if($.trim($("#passwordConfirm").val()) == ""){
				alert("이메일을 입력하세요")
				$("#passwordConfirm").focus();
				return;
			}
			if($.trim($("#password").val()) != $.trim($("#passwordConfirm").val())){
				alert("비밀번호가 일치하지 않습니다.")
				return;
			}
			
			$("#regist_form").attr({
				"action": "${pageContext.request.contextPath}/member/regist",
				"method": "post"
			}).submit();
		})
	})
</script>
</head>
<body>
<%-- action="${pageContext.request.contextPath}/member/regist" method="post" --%>
   <h1>가입페이</h1>
   <form id="regist_form">
       <div>
           <label for="">이메일</label>
           <input type="email" name="email" id="email" placeholder="이메일입력" maxlength="100"/>
       </div>
       <div>
           <label for="">이름</label>
           <input type="text" name="name" id="name" placeholder="이름입력" maxlength="10"/>
       </div>
       <div>
           <label for="">비밀번호</label>
           <input type="password" name="password" id="password" placeholder="비밀번호입력" maxlength="10"/>
       </div>
       <div>
           <label for="">비밀번호 확인</label>
           <input type="password" name="passwordConfirm" id="passwordConfirm" placeholder="비밀번호확인" maxlength="10"/>
       </div>
       <div>
        	<button id="submit_btn">가입</button>
       </div>
   </form>

</body>
</html>
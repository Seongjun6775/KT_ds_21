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
		
		$("#email").keyup(function(){
			var emailValue = $(this).val();
			emailValue = $.trim(emailValue);
			console.log(emailValue);
			
			if(emailValue == ""){
				$("#dup_email").hide();
				return
			}
			var url = "${pageContext.request.contextPath}/api/member/check/"+emailValue+"/";
			$.get(url, function(response){
				console.log(response);
				if(response.email_count > 0){
					$("#dup_email").show();
				}
				else{
					$("#dup_email").hide();
				}
			})
			
		})
		
		
		
		$("#submit_btn").click(function(event){
			event.preventDefault();
			
			var dupEmail = $("#dup_email");
			var dupStatus = dupEmail.css("display");
			
			if(dupStatus == "inline"){
				alert("이미 사용중인 이메일 입니다.");
			}
			else if(dupStatus == "none"){
				 var url ="${pageContext.request.contextPath}/api/member/regist";
				 $.post(url, $("#regist_form").serialize(), function(response){
					 console.log(response);
					 if(response.registResult){
						 location.href="${pageContext.request.contextPath}/member/login"
					 }else if(response.status == "fail"){
						 alert(response.message);
					 }else{
						 alert("시스템 오류입니다. 관리자에게 문의");
					 }
				 })
			}
			/* if($.trim($("#email").val()) == ""){
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
			}).submit(); */
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
           <span id="dup_email" style="display: none;">이미 사용중인 이메일</span>
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
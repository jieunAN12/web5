let xhr ;
$(document).ready(function(){
	$("#login").click(function(){ 
	xhr = new XMLHttpRequest();
	let uid = $("#userid").val();  
	let upwd = $("#userpwd").val();
		$.ajax({ url : "login",
				data : {'userid' : uid, 'userpwd' : upwd},
				success : function(data){
					let result = $(data).find("result").text();
		  			let name = $(data).find("id").text();
			   if (result == 1){
				   let str="<table><tr><td align='center'><b>"+name+"</b> 반갑다..</td></tr>"
				   str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃'/></td></tr></table>";
				   document.getElementById("confirmed").innerHTML = str;
			  }else if(result==0){
				  alert("비밀번호 다시 입력하세요");
	     		$("userid").val(name);
	     		$("userpwd").val("");
	     		$("userpwd").focus();
			  }else{
				alert("아이디를 다시 입력하세요");
	      		$("userid").val(name);
	     		$("userpwd").val("");
	     		$("userid").focus();
			  }  
			}
		});
	});
});

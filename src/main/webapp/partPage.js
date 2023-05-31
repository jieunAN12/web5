let xhr ;
window.onload= function(){ 
	document.getElementById("login").onclick = function(){  
	xhr = new XMLHttpRequest();
	let uid = document.getElementById("userid").value;  
	let upwd = document.getElementById("userpwd").value;
	let url = "login";
	xhr.onreadystatechange = resultProcess;
	xhr.open("POST", url, "true");
	xhr.setRequestHeader("Content-type", 
    		"application/x-www-form-urlencoded"); 
    xhr.send("userid="+uid+"&userpwd="+upwd);
	
	}
}
function resultProcess(){
   if(xhr.readyState == 4 && xhr.status == 200){
	  let result = xhr.responseXML.getElementsByTagName("result")[0].firstChild.data;
	  let name = xhr.responseXML.getElementsByTagName("id")[0].firstChild.data;
		   if (result == 1){
			   let str="<table><tr><td align='center'><b>"+name+"</b> 반갑다..</td></tr>"
			   str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃'/></td></tr></table>";
			   document.getElementById("confirmed").innerHTML = str;
		  }else if(result==0){
			  alert("비밀번호 다시 입력하세요");
     		 document.getElementById("userid").value=name;
     		 document.getElementById("userpwd").value=""; 
     		 document.getElementById("userpwd").focus();
		  }else{
			alert("아이디를 다시 입력하세요");
      		document.getElementById("userid").value="";
      		document.getElementById("userpwd").value="";
     		document.getElementById("userid").focus();
		  }  
	  }
  }//resultProcess() end
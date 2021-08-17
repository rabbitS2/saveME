let index={
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
	},
	
	save:function(){
		//alert('user의 save함수 호출');
		let data={
			userId:$("#userId").val(),
			userPw:$("#userPw").val(),
			userNick:$("#userNick").val(),
			userName:$("#userName").val(),
			userTel:$("#userTel").val(),
			userAddr:$("#userAddr").val()
		};
		
		
		$.ajax({
			type:"POST",
			url:"/saveME/auth/joinProc",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType:"json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)-->javascript 오브젝트로 변경
		}).done(function(resp){
			if(resp.status === 500){
				alert("회원가입이 실패하였습니다.");
			}else{
				alert("회원가입이 완료되었습니다.");
				//console.log(resp);
				location.href="/saveME";
			}
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	
	
	
	
}

index.init();
let index={
	
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-save-co").on("click",()=>{
			this.save_co();
		});
		$("#execPostCode").on("click",()=>{
			this.execPostCode();
		});
	},
	
	save:function(){
		//alert('user의 save함수 호출');
		var userAddr = $("#addr1").val()+ "/" + $("#addr2").val() + "/" + $("#addr3").val();
		
		let data={
			userDiv:$("#userDiv").val(),
			userId:$("#userId").val(),
			userPw:$("#userPw").val(),
			userNick:$("#userNick").val(),
			userName:$("#userName").val(),
			userTel:$("#userTel").val(),
			userAddr:"userAddr",
			userX:$("#userX").val(),
			userY:$("#userY").val()
		};
		
		
		$.ajax({
			type:"POST",
			url:"/saveME/auth/joinProc",
			data:JSON.stringify(data), //http body데이터
			contentType:"application/json;charset=utf-8", //body데이터가 어떤 타입인지(MIME)
			dataType:"json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)-->javascript 오브젝트로 변경
		}).done(function(resp){
			$('.valid').html('');
			if(resp.status === 200){  // 정상적으로 통신하면 200이 리턴되기 때문
				alert("회원가입이 완료되었습니다.");
				//console.log(resp);
				location.href="/saveME/auth/loginForm";
			}else{
				console.log(resp);
				$.each(resp.data, function (i, item) { //each(매개변수, 함수) 
				$('#'+i).html(item);
				});

			}
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	save_co:function(){
		//alert('user의 save함수 호출');
		var form = new FormData(document.getElementById('JoinForm_co'));
		
		$.ajax({
			type: "POST",
			url: "/saveME/auth/joinProc_co",
			data: form,
			contentType: false, //body데이터가 어떤 타입인지(MIME)
			processData: false,
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열(생긴게 json이라면)-->javascript 오브젝트로 변경
		}).done(function(resp){
			$('.valid').html('');
			if(resp.status === 200){  // 정상적으로 통신하면 200이 리턴되기 때문
				alert("회원가입이 완료되었습니다.");
				//console.log(resp);
				location.href="/saveME/auth/loginForm";
			}else{
				console.log(resp);
				$.each(resp.data, function (i, item) { //each(매개변수, 함수) 
				$('#'+i).html(item);
				});

			}
		}).fail(function(error){
			alert(JSON.stringify(error));
		});
		
	},
	
	
	
	
	execPostCode:function(){
		//alert('user의 save함수 호출');
		 new daum.Postcode({
             oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                /*console.log(data.zonecode);
                console.log(fullRoadAddr);*/
                
                
                $("#addr1").val(data.zonecode);
                $("#addr2").val(fullRoadAddr);
				$("#addr3").focus();
				
	           Promise.resolve(data).then(o => {
	                   const { address } = data;
	
	                   return new Promise((resolve, reject) => {
	                       const geocoder = new daum.maps.services.Geocoder();
	
	                       geocoder.addressSearch(address, (result, status) =>{
	                           if(status === daum.maps.services.Status.OK){
	                               const { x, y } = result[0];
	
	                               resolve({ lat: y, lon: x })
	                           }else{
	                               reject();
	                           }
	                       });
	                   })
	               }).then(result => {
	            	   // console.log(result);
	//            	   alert(JSON.stringify(result));
	            	   //{"lat":"37.5132284781619","lon":"127.033437226842"}
	            	   var sp = JSON.stringify(result).split(',');
	            	   var x=sp[0].substring(8).replace('"','');
	            	   var y=sp[1].substring(7).replace('"','').replace('}','');
	            	   
	            	 /* console.log(x);
               		  console.log(y);*/
	            	   
					 $("#userX").val(x);
               		 $("#userY").val(y);
			
	               });
	           },
	       }).open();
			
	}
	
	
}


index.init();
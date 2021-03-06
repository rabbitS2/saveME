<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap Elegant Account Login Form with Avatar Icon</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
    body {
        color: #999;
		background: #f5f5f5;
		font-family: 'Varela Round', sans-serif;
	}
	.form-control {
		box-shadow: none;
		border-color: #ddd;
	}
	.form-control:focus {
		border-color: #4aba70; 
	}
	.login-form {
        width: 350px;
		margin: 0 auto;
		padding: 30px 0;
	}
    .login-form form {
        color: #434343;
		border-radius: 1px;
    	margin-bottom: 15px;
        background: #fff;
		border: 1px solid #f3f3f3;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
	}
	.login-form h4 {
		text-align: center;
		font-size: 22px;
        margin-bottom: 20px;
	}
    .login-form .avatar {
        color: #fff;
		margin: 0 auto 30px;
        text-align: center;
		width: 100px;
		height: 100px;
		border-radius: 50%;
		z-index: 9;
		background: #4aba70;
		padding: 15px;
		box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
	}
    .login-form .avatar i {
        font-size: 62px;
    }
    .login-form .form-group {
        margin-bottom: 20px;
    }
	.login-form .form-control, .login-form .btn {
		min-height: 40px;
		border-radius: 2px; 
        transition: all 0.5s;
	}
	.login-form .close {
        position: absolute;
		top: 15px;
		right: 15px;
	}
	.login-form .btn {
		background: #4aba70;
		border: none;
		line-height: normal;
	}
	.login-form .btn:hover, .login-form .btn:focus {
		background: #42ae68;
	}
    .login-form .checkbox-inline {
        float: left;
    }
    .login-form input[type="checkbox"] {
        margin-top: 2px;
    }
    .login-form .forgot-link {
        float: right;
    }
    .login-form .small {
        font-size: 13px;
    }
    .login-form a {
        color: #4aba70;
    }
</style>
</head>
<body>
<div class="login-form">    

     <form id="JoinForm_co" enctype="multipart/form-data" method="post">
		<div class="avatar"><i class="material-icons">&#xE7FF;</i></div>
    	<h4 class="modal-title">Login to Your Account</h4>
    	
    	<input type="hidden" value="USER" id="userDiv">
        <div class="form-group">
        	<label for="name">ID</label> 
            <input type="text" class="form-control" placeholder="ID" required="required" id="userId">
        	<label id="valid_userId" class="valid"></label>
        </div>
        <div class="form-group">
        	<label for="name">Password</label> 
            <input type="password" class="form-control" placeholder="Password" required="required" id="userPw">
        	<label id="valid_userPw" class="valid"></label>
        </div>
        <div class="form-group">
        	<label for="name">NickName</label> 
            <input type="text" class="form-control" placeholder="NickName" required="required" id="userNick">
        	<label id="valid_userNick" class="valid"></label>
        </div>
        <div class="form-group">
        	<label for="name">Name</label> 
            <input type="text" class="form-control" placeholder="Name" required="required" id="userName">
        	<label id="valid_userName" class="valid"></label>
        </div>
        <div class="form-group">
        	<label for="name">Phone</label> 
            <input type="text" class="form-control" placeholder="Phone" required="required" id="userTel">
        	<label id="valid_userTel" class="valid"></label>
        </div>
        <div class="form-group">
        	<label for="name">Address</label> <br>
        	<input class="form-control" style="width: 40%; display: inline;" placeholder="????????????" id="addr1" type="text" readonly="readonly" >
            <button type="button" class="btn btn-primary" id="execPostCode">???????????? ??????</button>
            <input type="text" class="form-control" placeholder="??????" required="required" id="addr2" readonly="readonly" >
            <input type="text" class="form-control" placeholder="????????????" required="required" id="addr3" >
        </div>
         <input type="file" name="file" multiple="true">
        <input type="hidden" id="userX"><br>
   		<input type="hidden" id="userY"><br>
    </form>			
        <input type="button" id="btn-save-co" class="btn btn-primary btn-block btn-lg" value="Sign up" name="userFile">  
        
        <div id="result"></div>      

<script src="/saveME/js/user.js"></script>
</div>
</body>
</html>                                		     		
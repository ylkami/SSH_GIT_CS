/**
 * 登陆
 */
$(function(){	
	$('#user_login').click(function(){
		var email = $('#email').val();
		var password = $('#password').val();
		
		//邮箱或密码未填写
		if(email.length == 0 || password.length == 0){
			$('#msg').html('<font color="red">メールアドレスとパスワードを入力してください！</font>');
			return;
		}
		
		//检查邮箱密码格式
		if(!emailCheck(email)){
			$('#msg').html('<font color="red">メールボックスを正しく入力してください！</font>');
			return;
		}
		if(!passwordCheck(password)){
			$('#msg').html('<font color="red">パスワード正しく入力してください！</font>');
			return;
		}
		
		//提交邮箱与密码进行验证
		$.ajax({
			type: "post",
			url: "UserServlet?flag=_login",
			data: {"email":email,"password":password},
			success: function(data){
				$('#msg').html(data);
				if($('#msg font').attr('color') == 'green'){
					//验证通过，延迟跳转界面
					setTimeout(function(){
						window.location.href = "index.jsp";
					},500);
				}
			},
			error: function(){
			
			}
		});
	});
});


//检查邮箱格式
function emailCheck(email){
	var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)$/;
	return reg.test(email);
}

//检查密码格式
function passwordCheck(password){
	reg = /^\d{6,9}$/;
	return reg.test(password);
}
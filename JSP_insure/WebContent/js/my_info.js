/**
 * 信息提交修改
 */
$(function(){
	//检查密码格式
	$('#password').blur(function(){
		var password = $('#password').val();
		if(password.length == 0){
			$('#password_msg').html("<font color='red' size='2'>パスワードを入力してください</font>");
			return;
		}
		if(!passwordCheck(password)){
			$('#password_msg').html('<font color="red" size="2">パスワードを正しく入力してください</font>');
			return;
		}
		$('#password_msg').html('');
	});
	//检查号码格式
	$('#phone').blur(function(){
		var phone = $('#phone').val();
		if(phone.length == 0){
			$('#phone_msg').html("<font color='red' size='2'>電話番号を入力してください</font>");
			return;
		}
		if(!phoneCheck(phone)){
			$('#phone_msg').html('<font color="red" size="2">電話番号を正しく入力してください！</font>');
			return;
		}
		$('#phone_msg').html('');
	});
	
	//提交
	$('#updateuserinfo').click(function(){
		//检查密码格式
		var password = $('#password').val();
		if(password.length == 0){
			$('#password_msg').html("<font color='red' size='2'>パスワードを入力してください</font>");
			return;
		}
		if(!passwordCheck(password)){
			$('#password_msg').html('<font color="red" size="2">パスワードを正しく入力してください</font>');
			return;
		}
		$('#password_msg').html('');
		var phone = $('#phone').val();
		if(phone.length == 0){
			$('#phone_msg').html("<font color='red' size='2'>電話番号を入力してください</font>");
			return;
		}
		if(!phoneCheck(phone)){
			$('#phone_msg').html('<font color="red" size="2">電話番号を正しく入力してください！</font>');
			return;
		}
		$('#phone_msg').html('');
		var charge = $('#charge').val();
		if(charge == ''){
			charge = '0';
		}
		//提交密码，号码，充值金额
		$.ajax({
			type: "post",
			url: "UserServlet?flag=_update",
			data: {"password":password,"phone":phone,"charge":charge},
			success: function(data){
				alert(data);
				window.location.href="my_info.jsp";
			},
			error: function(){
			
			}
		});
	});
});

function passwordCheck(password){
	var reg =  /^\d{6,9}$/;
	return reg.test(password);
}

function phoneCheck(phone){
	var reg =  /^1[3-9]\d{9}$/;
	return reg.test(phone);
}
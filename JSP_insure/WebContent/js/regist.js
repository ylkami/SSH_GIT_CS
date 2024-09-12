/**
 * 注册JS模块
 */
$(function(){
	$('#userRegister').click(function(){
		var msg = "";
		//获取所有值并完成非空判断：
		//姓名
		var firstName = $('#userX').val();
		var lastName = $('#userM').val();
		if(firstName.length == 0 || lastName.length == 0){
			msg = "<font color='red'>名前を入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		var name = firstName + lastName;
		if(!isFullWidth(name)){
			msg = "<font color='red'>全角文字を入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		//假名
		var firstNameq = $('#userXq').val();
		var lastNameq = $('#userMq').val();
		if(firstNameq.length == 0 || lastNameq.length == 0){
			msg = "<font color='red'>フリガナを入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		var nameq = firstNameq + lastNameq;
		if(!isFullWidthQ(nameq)){
			msg = "<font color='red'>全角カナを入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		//生日
		var year = $('#year').val();
		var month = $('#month').val();
		var day = $('#day').val();
		reg = /^(19|20)\d{2}$/;
		var date = new Date();
		var currentYear =  date.getFullYear();
		if(!isHalfWidth(year)){
			msg = "<font color='red'>誕生日年分を半角数字で入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		if(!(reg.test(year)&&currentYear>year)){
			msg = "<font color='red'>誕生日を正しく入力してください</font>";
			$('#msg').html(msg);
			return;
		}
		var birthday = year + month + day;
		//性别
		var sex = $('#userSex').val();
		switch(sex){
			case "0" :
				sex = "女士";
				break;
			case "1" :
				sex = "先生";
				break;
		}
		//电话
		var phone = $('#userPhone5').val() + $('#userPhone4').val() + $('#userPhone42').val();
		var reg = /^1[3-9]\d{9}$/;
		if(!isHalfWidth(phone)){
			msg = "<font color='red'>電話番号を半角数字で入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		if(!reg.test(phone)){
			msg = "<font color='red'>電話番号を正しく入力してください</font>";
			$('#msg').html(msg);
			return;
		}
		//邮箱
		var email = $('#userEmail1').val() + "@" + $('#userEmail2').val();
		if(!isHalfWidth(email)){
			msg = "<font color='red'>メールボックスを半角英数字で入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		if(!emailCheck(email)){
			msg = "<font color='red'>メールボックスを正しく入力してください！</font>";
			$('#msg').html(msg);
			return;
		}
		//密码
		var password = $('#userPass').val();
		reg = /^\d{6,9}$/;
		if(!isHalfWidth(password)){
			msg = "<font color='red'>パスワードを半角数字で入力してください。</font>";
			$('#msg').html(msg);
			return;
		}
		if(!reg.test(password)){
			msg = "<font color='red'>パスワードを正しく入力してください！</font>";
			$('#msg').html(msg);
			return;
		}
		$.ajax({
			type: "post",
			url: "UserServlet?flag=_regist",
			data: {"email":email,"password":password,"phone":phone,"birthday":birthday,"name":name,"nameq":nameq,"sex":sex},
			success: function(data){
				$('#msg').html(data);
				if($('#msg font').attr('color') == 'green'){
					window.location.href = "login.jsp";
				}
			},
			error: function(){
				msg = "<font color='red'>エーラ発生！</font>";
				$('#msg').html(msg);
			}
		});
	});
	
});

//检查邮箱格式
function emailCheck(email){
	var reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)$/;
	return reg.test(email);
}
//检测全角假名
function isFullWidthQ(str) {
	  var reg =/^[\u3040-\u309f\u30a0-\u30ff]+$/;
	  return reg.test(str);
}	
//检测全角(汉字，假名)
function isFullWidth(str) {
	  var reg = /^[\u3040-\u309f\u30a0-\u30ff\u31f0-\u31ff\u32d0-\u32ff\u3300-\u33ff\uff66-\uff9f\u4e00-\u9faf\u3400-\u4dbf\u20000-]+$/;
	  return reg.test(str);
}
//检测半角英数
function isHalfWidth(str) {  
	var reg = /^[\x00-\x7F]+$/;
	  return reg.test(str);
}

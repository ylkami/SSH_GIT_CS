/**
 * shop.js文件
 */

$(function(){
	total();
	//实时计算价格
	$('#money1 select, #money2 select, #money3 select, #money4 select, #money5 select, #money6 select, #money7 select, #endDataTime').change(function(){
		total();
	});
	//判断受益人是否注册
	$('#userName2').blur(function(){
		beneficiaryCheck();
	});
	
	//点击提交
	$('#buyCommodity').click(function(){
		//投保人是否可用
		var applicantName = $('#userName').val();
		$.ajax({
			type: "post",
			url: "OrderServlet?opt=name",
			data: {"name":applicantName},
			success: function(data){
				$('#applicant_name_msg').html(data);
			},
			error: function(){
		
			}
		});
		//受益人是否可用
		var beneficiaryName = $('#userName2').val();
		if(beneficiaryName.length == 0){
			$('#beneficiary_name_msg').html('<font color="red">被保険者の名前を入力してください！</font>');
			return;
		}
		$.ajax({
			type: "post",
			url: "OrderServlet?opt=name",
			data: {"name":beneficiaryName},
			success: function(data){
				$('#beneficiary_name_msg').html(data);
			},
			error: function(){
			
			}
		});
		if($('#beneficiary_name_msg font').attr('color') != 'green'){
			return;
		}		
		//投保人电话
		var phone = $('#userPhone').val();
		//投保人邮箱
		var email = $('#userEmail').val();
		//受益人地区
		var location = $('#userCity2').val();
		if(location.length == 0){
			$('#userCity2_msg').html('<font color="red">被保険者の都市を入力してください！</font>');
			return;
		}else {
			$('#userCity2_msg').html('');
		}
		//受益人电话
		var phone2 = $('#userPhone2').val();
		if(phone2.length == 0){
			$('#userPhone2_msg').html('<font color="red">被保険者の携帯番号を入力してください！</font>');
			return;
		}else {
			$('#userPhone2_msg').html('');
		}
		
		//开始正式后台验证
		$.ajax({
			type: "post",
			url: "OrderServlet?opt=orderCheck",
			data: {"applicantName":applicantName,"liability1":$('#money1 select').val(),"liability2":$('#money2 select').val(),"liability3":$('#money3 select').val(),"liability4":$('#money4 select').val(),"liability5":$('#money5 select').val(),"liability6":$('#money6 select').val(),"liability7":$('#money7 select').val(),"beneficiaryName":beneficiaryName,"location":location,"phone":phone2,"timeLength":$('#endDataTime').val()},
			success: function(data){
				$('#bottom_msg').html(data);
				if($('#bottom_msg font').attr('color') == 'yellow'){
					setTimeout(function(){
						window.location.href = "my_info.jsp";
					},500);
					return;
				}
				if($('#bottom_msg font').attr('color') == 'green'){
					setTimeout(function(){
						window.location.href = "OrderServlet?opt=showMyOrder";
					},500);
					return;
				}
			},
			error: function(){
			
			}
		});
	})
});

function total(){
	var initPrice = parseFloat($('#initPrice').val());
	var money1 = parseFloat($('#money1 select').val());
	var money2 = parseFloat($('#money2 select').val());
	var money3 = parseFloat($('#money3 select').val());
	var money4 = parseFloat($('#money4 select').val());
	var money5 = parseFloat($('#money5 select').val());
	var money6 = parseFloat($('#money6 select').val());
	var money7 = parseFloat($('#money7 select').val());
	var year = $('#endDataTime').val();
	var total = (initPrice + money1 + money2 + money3 + money4 + money5 + money6 + money7)*year;
	$('#price_view').html(total+'万');
}

function applicantCheck(){
	var applicantName = $('#userName').val();
	if(applicantName.length == 0){
		$('#applicant_name_msg').html('<font color="red">保険加入者の名前を入力してください！</font>');
		return;
	}
	$.ajax({
		type: "post",
		url: "OrderServlet?opt=name",
		data: {"name":applicantName},
		success: function(data){
			$('#applicant_name_msg').html(data);
		},
		error: function(){
		
		}
	});
}

function beneficiaryCheck(){
	var beneficiaryName = $('#userName2').val();
	if(beneficiaryName.length == 0){
		$('#beneficiary_name_msg').html('<font color="red">被保険者の名前を入力してください！</font>');
		return;
	}
	$.ajax({
		type: "post",
		url: "OrderServlet?opt=name",
		data: {"name":beneficiaryName},
		success: function(data){
			$('#beneficiary_name_msg').html(data);
		},
		error: function(){
		
		}
	});
}
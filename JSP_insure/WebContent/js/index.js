/**
 * 主界面商品遍历
 */
$(function(){
	var _url = "/JSP_insure/CommodityServlet?opt=selectAllCommodityList";
	var ifLogin = $('#ifLogin').val();
	if(ifLogin == '1'){
		_url += "&status=login";
	}
	
	$.ajax({
		url:_url,
		type:"post",
		dataType:"json",
		success:function(data){
			//var commodityList = eval(JSON.parse(data));
			var info = "";
			var sum = 0;
			for(var i = 0; i < data.length; i++){
				info = info + "<div class='div_context'>";
				info = info + "<div class='div_context_l'>";
				info = info + "<img src=" + data[i].img + " width='350px' height='260px'/>";
				info = info + "</div>";
				info = info + "<div class='div_context_r'>";
				info = info + "<div class='div_context_r_1'>";
				info = info + "<h2>" + data[i].name + "</h2>";
				info = info + "<p class='p1'>️" + data[i].introduce + "</p>";
				info = info + "</div>";
				info = info + "<div class='div_context_r_2'>";
				info = info + "<div class='price'>";
				info = info + "<span class='fh'><b>¥</b></span>";
				info = info + "<span class='price_a'><b>" + data[i].price + "</b></span>";
				info = info + "<span class='fh'><b>/起</b></span>";
				info = info + "</div>";
				info = info + "<a href='CommodityServlet?opt=commodityQueryById&commodity_id=" + data[i].id + "'>";
				info = info + "<div class='img_a'>";
				info = info + "<b>詳細はこちら</b>";
				info = info + "</div>";
				info = info + "</a>";
				info = info + "</div>";
				info = info + "</div>";
				info = info + "</div>";
				sum ++;
			}
			sum = Math.ceil(sum/2) * 350;
			$("#context").css("height",sum + "px");
			$("#context_text").append(info);
		},
		error:function(){
			alert("ネットワークにエラーがありました。後で再試行してください！");
		}
	});
	
	//更换种类展示
	$('#li2, #li3, #li4, #li5, #li6').click(function(){
		var id = $(this).attr('id');
		var type = id.substr(2,1);
		type = parseInt(type) - 1;
		var _url = "/JSP_insure/CommodityServlet?opt=selectAllCommodityList";
	var ifLogin = $('#ifLogin').val();
	if(ifLogin == '1'){
		_url += "&status=login";
	}
	_url += "&type=" + type;
	
	$.ajax({
		url:_url,
		type:"post",
		dataType:"json",
		success:function(data){
			var info = "";
			var sum = 0;
			for(var i = 0; i < data.length; i++){
				info = info + "<div class='div_context'>";
				info = info + "<div class='div_context_l'>";
				info = info + "<img src=" + data[i].img + " width='350px' height='260px'/>";
				info = info + "</div>";
				info = info + "<div class='div_context_r'>";
				info = info + "<div class='div_context_r_1'>";
				info = info + "<h2>" + data[i].name + "</h2>";
				info = info + "<p class='p1'>️" + data[i].introduce + "</p>";
				info = info + "</div>";
				info = info + "<div class='div_context_r_2'>";
				info = info + "<div class='price'>";
				info = info + "<span class='fh'><b>¥</b></span>";
				info = info + "<span class='price_a'><b>" + data[i].price + "</b></span>";
				info = info + "<span class='fh'><b>/起</b></span>";
				info = info + "</div>";
				info = info + "<a href='CommodityServlet?opt=commodityQueryById&commodity_id=" + data[i].id + "'>";
				info = info + "<div class='img_a'>";
				info = info + "<b>詳細はこちら</b>";
				info = info + "</div>";
				info = info + "</a>";
				info = info + "</div>";
				info = info + "</div>";
				info = info + "</div>";
				sum ++;
			}
			sum = Math.ceil(sum/2) * 350;
			$("#context").css("height",sum + "px");
			$("#context_text").html('');
			$("#context_text").append(info);
		},
		error:function(){
			alert("ネットワークにエラーがありました。後で再試行してください！");
		}
	});
	});
});
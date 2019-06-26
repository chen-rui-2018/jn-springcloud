//服务请求url
var service_url="http://112.94.22.222:8000/springcloud-park/";
//var service_url="http://localhost/springcloud-park/";
//获取token的Url
var token_Url="http://112.94.22.222:8000/springcloud-app-system";
//设置token作用域的url
var scope_url="";

//定义token
var token="";
$(function () {
	//获取token
	token = $.cookie('Admin-Token');
	if(token==undefined || token==''){
		getServiceToken();
		token = $.cookie('Admin-Token');
	}
	//获取来电用户信息
	getCalledHistory($("#searchPhone").val());
});


//获取token
function getServiceToken(){
	$.ajax({
		url: token_Url+'/authLogin',
		type: 'POST',
		async: false,
		data: {
		},
		dataType: 'json',
		beforeSend: function(xhr) {
		},
		success: function(data, textStatus, jqXHR) {
			// console.log('================>authLogin请求返回data：' + data)
			if (data.code === '0000') {
				if (data.data !== null) {
					console.log('================>authLogin请求返回：' + data.data)
					$.cookie('Admin-Token',data.data,{domain:scope_url,path: '/' });
				}
			}
		},
		error: function(xhr, textStatus) {
		},
		complete: function() {
		}
	})
}

//查询用户历史信息
function searchHistory(){
	getCalledHistory($("#searchPhone").val());
}


//获取来电用户历史信息
function getCalledHistory(obj){
	$("#detailLoad").show();
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/getUserCalledHistory',
		dataType: "json",
		data: {
			searchPhone: obj,
			page:1,
			rows:20
		},
		headers: {
			"token":token
		},
		success: function (data) {
			$("#detailLoad").hide();
			var table=""
			if(data==undefined ||data==null ||data.data==null ||data.data.rows.length==0){
				table=table+"<tr><td colspan='7'>暂无数据</td></tr>";
			}else if(data.code='0000'){
				var customerList=data.data.rows;
				$("#historyNum").html(customerList.length);
				for(var i=0;i<customerList.length;i++){
					var info=customerList[i];
					var showStatus="";
					if(info.status=='0'){showStatus="待处理"}
					else if(info.status=='1'){showStatus="处理中"}
					else if(info.status=='2'){showStatus="已处理"}
					else if(info.status=='3'){showStatus="无法处理"}
					table=table+"<tr><td>"+(i+1)+"</td><td>"+info.userAccount+"</td><td>"+info.quesCode+"</td><td >"+info.serviceModuleName+"</td>" +
						"<td>"+showStatus+"</td><td>"+info.quesTitle+"</td>" +
						"<td>"+info.createdTime+"</td>" +
						"<td><a href='javascript:void(0)' class='btn mini' onclick='getHistoryDetails(this)' value='"+info.processInsId+"'>详情</a></td></tr>";
				}
			}
			$("#history").html(table);
		},
		error:function () {
			alert("网络异常，请稍后重试");
			$("#detailLoad").hide();
		}
	});
}

//根据流程实例id查看客服问题详情
function getHistoryDetails(obj){
	//根据流程实例id,用户账号查看问题详情
	var processInsId = $(obj).attr("value");
	$("#detailLoad").show();
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/customerQuesDetail',
		dataType: "json",
		data: {
			processInsId: processInsId
		},
		headers: {
			"token":token
		},
		success: function (data) {
			$("#detailLoad").hide();
			//详情描述图片隐藏
			$("#quesUrlShow").hide();
			if(data!=undefined && data!=null && data.data!=null && data.code=='0000'){
				$(".quesLayer").show();
				$(".quesBox").show();

				//取出查询到的信息
				var detailInfo=data.data;
				var quesTitle=detailInfo.quesTitle;
				var quesDetails=detailInfo.quesDetails;
				var quesUrl=detailInfo.quesUrl;
				var custName=detailInfo.custName;
				var contactWay=detailInfo.contactWay;
				var serviceModuleName=detailInfo.serviceModuleName;
				var createdTime=detailInfo.createdTime;
				var status=detailInfo.status;
				var executeHistoryShowList=detailInfo.executeHistoryShowList;

				//给弹出框控件赋值
				$("#quesTitleShow").html(quesTitle);
				if(status=='0'){$("#status").html("待处理")}
				else if(status=='1'){$("#status").html("处理中")}
				else if(status=='2'){$("#status").html("已处理")}
				else if(status=='3'){$("#status").html("无法处理")}
				$("#quesDetailsShow").html(quesDetails);
				if(quesUrl!=null && quesUrl.length>0){
					for(var i=0;i<quesUrl.length;i++){
						if(quesUrl[i]==''){
							continue;
						}else{
							if(i==0){
								$("#quesUrlShow").show();
								$("#quesUrlShow").attr("src",quesUrl[i]);
							}else{
								$("#quesUrlShow").after("<img class='img quesUrlShowAdd' src='"+quesUrl[i]+"'/>");
							}
						}
					}
				}
				$("#custNameShow").html(custName);
				$("#contactWayShow").html(contactWay);
				$("#serviceModuleName").html(serviceModuleName);
				$("#createdTime").html(createdTime);

				//问题处理记录
				if(executeHistoryShowList!=null && executeHistoryShowList.length>0){
					var html="<div class='process-title'>问题处理记录</div><div class='box-item'>";
					for(var i=0;i<executeHistoryShowList.length;i++){
						var historyShow=executeHistoryShowList[i];
						html=html+"<div class='item'>"
							+"<div class='tle'>"+historyShow.optionDeptName+"</div>"
							+"<div class='info'Style='padding-left: 10px'>"+historyShow.opinion+"("+historyShow.statusName+")</div>";
						if(historyShow.executePictureUrl!=null && historyShow.executePictureUrl.length>0 ){
							for(var j=0;j<historyShow.executePictureUrl.length;j++){
								if(j==0){
									html=html+"<div class='img-box'>";
									html=html+"<img src='"+historyShow.executePictureUrl[j]+"' id='pictureUrl' class='executeShow' alt='' style='padding-left: 10px'>";
								}else{
									$("#pictureUrl").after("<img src='"+historyShow.executePictureUrl[j]+"' id='pictureUrl"+j+"' class='executeShow' alt='' style='padding-left: 5px'>");
								}
							}
							html=html+"</div>";
						}
						html=html+"</div>"
					}
					html=html+"</div>";
					$("#historyDetails").html(html);
				}
			}else{
				alert("网络异常，请稍后重试");
			}

		},
		error:function () {
			alert("网络异常，请稍后重试");
		}
	});
}

//问题详情弹出框关闭
function closeQuesBox(){
	//清空数据
	$("#quesTitleShow").val("");
	$("#status").html("")
	$("#quesDetailsShow").val("");
	$("#quesUrlShow").attr("src","");
	$("#custNameShow").val("");
	$("#contactWayShow").val("");
	$("#serviceModuleName").val("");
	$("#createdTime").val("");
	$("#historyDetails").html("");
	//隐藏问题图片
	$("#pictureUrl").hide();
	$(".quesUrlShow").hide();
	$(".quesUrlShowAdd").remove();
	//隐藏弹出框
	$(".quesBox").hide();
	$(".quesLayer").hide();

}



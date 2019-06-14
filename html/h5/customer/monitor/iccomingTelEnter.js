//服务请求url
var service_url="http://112.94.22.222:8000/springcloud-park/";
//var service_url="http://localhost/springcloud-park/";
//获取token的Url
var token_Url="http://112.94.22.222:8000/springcloud-app-system";
//客服连接服务器ip
var serviceIp="112.94.22.222";
//客服连接服务器端口号
var servicePort="13000";

//初始化来电插件
var toolbar = new ghToolbar( "mySoftphone" );



//登录坐席默认信息
//分机号码
var initExtension="1001";
//登陆工号
var initAgentId="200";
//坐席名称
var initAgentName="张三";
//登陆组号
var initGroupId="1";
//坐席级别
var initLevelId="1";



//定义token
var token="";
$(function () {
	//获取token
	token = $.cookie('Admin-Token');
	if(token==undefined || token==''){
		getServiceToken();
		token = $.cookie('Admin-Token');
	}
	//设置服务器连接ip和端口号
	$("#serverIp").val(serviceIp);
	$("#serverPort").val(servicePort);
	initLoginAccountInfo();
	//获取登录用户信息
	getUserInfo();
	//获取服务模块信息
	getServiceModule();
});

//初始化登录用户信息
function initLoginAccountInfo(){
	//登陆组号
	$("#groupId").val(initGroupId);
	//坐席级别
	$("#levelId").val(initLevelId);
}

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
					$.cookie('Admin-Token',data.data,{path: '/' });
				}
			}
		},
		error: function(xhr, textStatus) {
		},
		complete: function() {
		}
	})
}

//获取服务模块信息
function getServiceModule(){
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/serviceModules',
		dataType: "json",
		data: {},
		headers: {
			"token":token
		},
		success: function (data) {
			if(data==undefined ||data==null ||data.data==null){
				console.log("获取服务模块信息失败，网络异常");
			}else if(data.code='0000'){
				var modules=data.data;
				var options="";
				for(var i=0;i<modules.length;i++){
					options=options+"<option value="+modules[i].serviceModule+">"+modules[i].serviceModuleName+"</option>";
				}
				if(options.length>0)
					$("#serviceModule").html("");
				$("#serviceModule").html(options);
			}
		}
	});
}

//获取登录用户账号信息和姓名
function getUserInfo(){
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/getBaseUserInfo',
		dataType: "json",
		data: {},
		headers: {
			"token":token
		},
		success: function (data) {
			if(data==undefined ||data==null ||data.data==null){
				console.log("获取登录用户账号信息和姓名失败，网络异常");
				alert("网络异常，请稍后重试...");
			}else if(data.code='0000'){
				var user=data.data;
				$("#agentId").val(user.account);
				$("#agentName").val(user.name);
			}
		}
	});
}

//设置分机号码
function setExtension(){
	var extension=$("#extension").val();
	if(extension!=null && extension.replace(/\s/g,"")!=''){
		//ignore
	}else{
		//展示下拉框
		$("#extensionSelect").show();
	}
}
//设置分机号码，选中下拉框中的值
function selectExtension(obj){
	var extensionValue=$(obj).attr("value");
	$("#extension").val(extensionValue);
	//下拉框隐藏
	$("#extensionSelect").hide();
}

//手动输入分机号码
function inputExtension(){
	//下拉框隐藏
	$("#extensionSelect").hide();
}

//失去焦点隐藏下拉框
function hideExtension(){
	//下拉框隐藏
	$("#extensionSelect").hide();
}
//连接ACD服务器
function connectACD(){
	var ip = document.getElementById("serverIp").value;
	var port = document.getElementById("serverPort").value;
	var r = toolbar.ConnectToACD( ip, port );
	addLog( "调用ConnectToACD方法, 返回值=" + r );
}

//断开ACD服务器
function disconnectACD(){
	var r = toolbar.DisConnectToACD();
	addLog( "调用DisConnectToACD方法, 返回值=" + r );
	return r;
}
//连接ACD服务器并登录
function connectACDAndLogin(){
	//连接服务器ACD
	connectACD();
	//利用连接服务器的回调方法（OnAgentConnectToACD()）调用登录
	//通过登录回调方法（OnAgentLogin()）判断是否登录成功
}

//断开ACD服务器并登出
function disconnectACDAndLogout(){
	//断开服务器ACD
	disconnectACD();
	//利用断开服务器的回调方法（OnAgentDisConnectToACD()）调用登出
	//通过登出回调方法（OnAgentLogout()）判断是否登出成功
}

//坐席登陆
function login(){
	var agentId = document.getElementById("agentId").value;
	var agentName = document.getElementById("agentName").value;
	var ext = document.getElementById("extension").value;
	if(ext==null || ext==''){
		alert("请输入分机号码");
	}
	var groupId = document.getElementById("groupId").value;
	var levelId = document.getElementById("levelId").value;
	var rightId = 0;
	if( document.getElementById("rightId").checked ) {
		rightId = 1;
	}
	var r = toolbar.LoginEx( agentId, agentName, ext, groupId, levelId, rightId, 2 );
	addLog( "调用LoginEx方法, 返回值=" + r );
}

function logout(){
	var r = toolbar.Logout();
	addLog( "调用Logout方法, 返回值=" + r );
}

//来电振铃事件
toolbar.OnTelephoneRing(function( szCaller, szCallid ) {
	addLog( "坐席来电振铃事件，szCaller=" + szCaller + ",szCallid=" + szCallid );
	//弹出对话框
	$(".popBox").show();
	$(".popLayer").show();
	//清空当前来电号码，当前被叫号码，来电归属
	$("#currentCall").val("");
	$("#calledNumber").val("");
	$("#callerOwen").val("");
	//给当前来电电话,被叫电话，来电归属赋值
	$("#currentCall").val(szCaller);
	$("#calledNumber").val(getCalled());
	//获取来电归属地
	getCallerOwen(szCaller);
	//根据手机号获取来电用户信息
	getUserIno(szCaller);
	//获取来电用户历史信息
	getCalledHistory(szCaller);

});


//连接服务器回调方法
toolbar.OnAgentConnectToACD(function( bResult ) {
	addLog( "连接服务器返回事件，bResult=" + bResult );
	if(bResult==1){
		$("#optionOKDesc").show();
		$("#optionOKDesc").html("连接服务器成功，开始登陆...");
		$("#optionNGDesc").html("");
		setTimeout(function(){document.getElementById("optionOKDesc").style.display="none";},1000);
		login();
	}else if(bResult==2) {
		//ignore
	}else{
		$("#optionNGDesc").show();
		$("#optionNGDesc").html("服务器连接失败，登陆失败");
		$("#optionOKDesc").html("");
		setTimeout(function(){document.getElementById("optionNGDesc").style.display="none";},3000);
	}
});
//断开服务器回调方法
toolbar.OnAgentDisConnectToACD(function( bResult, iReason ) {
	addLog( "断开服务器返回事件，bResult=" + bResult + ",iReason=" + iReason );
	if(bResult){
		$("#optionOKDesc").show();
		$("#optionOKDesc").html("断开服务器成功，开始登出...");
		$("#optionNGDesc").html("");
		setTimeout(function(){document.getElementById("optionOKDesc").style.display="none";},1000);
		logout();
	}
});
//登录回调事件
toolbar.OnAgentLogin(function( bResult, iReason ) {
	addLog( "坐席登陆返回事件，bResult=" + bResult + ",iReason=" + iReason );
	if(bResult){
		$("#login").hide();
		$("#logout").show();
		$("#optionOKDesc").show();
		$("#optionOKDesc").html("登陆成功");
		$("#optionNGDesc").html("");
		setTimeout(function(){document.getElementById("optionOKDesc").style.display="none";},3000);
	}else{
		$("#optionNGDesc").show();
		$("#optionNGDesc").html("登录失败");
		$("#optionOKDesc").html("");
		setTimeout(function(){document.getElementById("optionNGDesc").style.display="none";},3000);
	}
});
//登出回调事件
toolbar.OnAgentLogout(function( bResult, iReason ) {
	addLog( "坐席登出返回事件，bResult=" + bResult );
	if(bResult){
		$("#logout").hide();
		$("#login").show();
		$("#optionNGDesc").html("......请登录.....");
	}else{
		$("#optionNGDesc").show();
		$("#optionNGDesc").html("网络异常，登出失败");
		$("#optionOKDesc").html("");
		setTimeout(function(){document.getElementById("optionNGDesc").style.display="none";},1000);
	}
});

//获取来电归属
function getCallerOwen(obj){
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/getPhoneCalledOwen',
		dataType: "json",
		data: {
			phone: obj
		},
		headers: {
			"token":token
		},
		success: function (data) {
			if(data!=null && data.data!=null && data.code=='0000'){
				$("#callerOwen").val(data.data);
			}
		}
	});
}

//根据手机号获取来电用户信息
function getUserIno(obj){
	//清空数据
	$("#userData").html("");
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/getUserInfo',
		dataType: "json",
		data: {
			phone: obj
		},
		headers: {
			"token":token
		},
		success: function (data) {
			var table=""
			if(data==undefined ||data==null ||data.data==null){
				table=table+"<tr><td colspan='6'>暂无数据</td></tr>";
			}else if(data.code='0000'){
				$("#noUserData").hide();
				$("#haveUserData").show();
				var user=data.data;
				table=table+"<tr><td>1</td><td>"+user.name+"</td><td>"+user.sex+"</td>" +
					"<td>"+user.account+"</td><td>"+user.email+"</td>" +"<td>"+user.phone+"</td></tr>";
			}
			$("#userData").html(table);
		}
	});
}

//获取来电用户历史信息
function getCalledHistory(obj){
	$.ajax({
		type: 'get',
		url: service_url + '/customer/customerCalledInfoEnterController/getCalledHistory',
		dataType: "json",
		data: {
			phone: obj
		},
		headers: {
			"token":token
		},
		success: function (data) {
			var table=""
			if(data==undefined ||data==null ||data.data==null ||data.data.rows.length==0){
				table=table+"<tr><td colspan='6'>暂无数据</td></tr>";
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
					table=table+"<tr><td>"+info.quesCode+"</td><td >"+info.serviceModuleName+"</td>" +
						"<td>"+showStatus+"</td><td>"+info.quesTitle+"</td>" +
						"<td>"+info.createdTime+"</td>" +
						"<td><a href='javascript:void(0)' class='btn mini' onclick='getHistoryDetails(this)' value='"+info.processInsId+"'>详情</a></td></tr>";
				}
			}
			$("#history").html(table);
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


//来电弹出框关闭方法
function closeBox() {
	if(confirm("确认是否放弃本次编辑")){
		$(".popBox").hide();
		$(".popLayer").hide();
	}
}

//点击弹窗确定按钮
function okSubmit(){
	//判断当前来电号码和来电归属地是否为空
	if($("#currentCall").val()==''){
		alert("当前来电号码不能为空");
		return false;
	}
	//清空来电信息
	$("#currentCallShow").html("");
	$("#calledNumberShow").html("");
	$("#callerOwenShow").html("");
	$("#phoneShow").html("");
	//给来电信息赋值
	$("#currentCallShow").html($("#currentCall").val());
	$("#calledNumberShow").html($("#calledNumber").val());
	$("#callerOwenShow").html($("#callerOwen").val());
	$("#phoneShow").html($("#currentCall").val());
	//展示历史记录
	$("#history").show();
	//关闭弹窗
	$(".popBox").hide();
	$(".popLayer").hide();
}

//提交数据
function submit(){
	//获取来电录入数据
	var quesTitle=$("#quesTitle").val().replace(/\s/g,"");
	var serviceModule=$("#serviceModule").val().replace(/\s/g,"");
	var quesDetails=$("#quesDetails").val().replace(/\s/g,"");
	var clientType=$("#clientType").val().replace(/\s/g,"");
	var custName=$("#custName").val().replace(/\s/g,"");
	var contactWay=$("#contactWay").val().replace(/\s/g,"");
	var calledPhone=$("#currentCallShow").html();

	//判断数据是否为空
	if(quesTitle==''){
		alert("问题标题不能为空");
		return false;
	}
	if(serviceModule==''){
		alert("业务模块不能为空");
		return false;
	}
	if(quesDetails==''){
		alert("问题描述不能为空");
		return false;
	}
	if(clientType==''){
		alert("用户类型不能为空");
		return false;
	}
	if(custName==''){
		alert("客户姓名不能为空");
		return false;
	}
	if(contactWay==''){
		alert("联系方式不能为空");
		return false;
	}
	//校验联系方式

	//把数据转为json
	var json={
		"quesTitle":quesTitle,
		"serviceModule":serviceModule,
		"quesDetails":quesDetails,
		"clientType":clientType,
		"custName":custName,
		"contactWay":contactWay,
		"calledPhone":calledPhone
	}
	//显示加载中...
	$("#submitDesc").show();
	//提交按钮禁用
	$("#buttons").attr({"disabled":"disabled"});
	//提交数据
	$.ajax({
		type: 'post',
		url: service_url + '/customer/customerCalledInfoEnterController/saveCalledInfo',
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(json),
		headers: {
			"token":token
		},
		success: function (data) {
			$("#submitDesc").hide();
			$("#buttons").removeAttr("disabled");
			if(data!=undefined &&data!=null && data.data!=null
				&& data.code=='0000'){
				clearCustomerInfo();
				alert("提交成功");
			}else{
				alert(data.result);
			}
		},
		error:function () {
			$("#submitDesc").hide();
			$("#buttons").removeAttr("disabled");
			alert("网络异常，请稍后重试");
		}
	});
}
//清除用户信息
function clearCustomerInfo(){
	//清空来电录入信息
	$("#quesTitle").val("");
	$("#serviceModule").val("");
	$("#quesDetails").val("");
	$("#clientType").val("");
	$("#custName").val("");
	$("#contactWay").val("");

	//清空来电信息
	$("#currentCallShow").html("");
	$("#calledNumberShow").html("");
	$("#callerOwenShow").html("");
	$("#phoneShow").html("");
	//历史记录 0条
	$("#historyNum").html(0);
	//清空历史记录
	$("#history").html("");
	$("#history").hide("");
}

function dial(){
	var r = toolbar.Dial( document.getElementById("dialphone").value );
	addLog( "调用Dial方法, 返回值=" + r );
}

function getIVR(){
	var v = toolbar.DoGetAssociatedData("IvrPath");
	addLog( v );
}

function drop(){
	var r = toolbar.Onhook();
	addLog( "调用Onhook方法, 返回值=" + r );
}

function answer(){
	var r = toolbar.Offhook();
	addLog( "调用Offhook方法, 返回值=" + r );
}

function hold(){
	var r = toolbar.Hold();
	addLog( "调用Hold方法, 返回值=" + r );
}

function unhold(){
	var r = toolbar.UnHold();
	addLog( "调用UnHold方法, 返回值=" + r );
}

function blindtransfer(){
	var r = toolbar.BlindTransfer( document.getElementById("transferphone").value );
	addLog( "调用BlindTransfer方法, 返回值=" + r );
}

function consult(){
	var r = toolbar.Consult( document.getElementById("consultphone").value );
	addLog( "调用Consult方法, 返回值=" + r );
}

function cancelconsult(){
	var r = toolbar.CancelConsult();
	addLog( "调用CancelConsult方法, 返回值=" + r );
}

function transferconsult(){
	var r = toolbar.Onhook();
	addLog( "调用Onhook方法, 返回值=" + r );
}

function conferenceconsult(){
	var r = toolbar.ThirdParty();
	addLog( "调用ThirdParty方法, 返回值=" + r );
}
//班长坐席  强拆、强插、拦截坐席
function ForceRelease(){
	var r = toolbar.ForceRelease(document.getElementById("ForceReleaseNumber").value);	//
	addLog("调用ForceRelease方法,返回值=" + r );
}
function ForceJoin(){
	var r = toolbar.ForceJoin(document.getElementById("ForceJoinNumber").value);
	addLog("调用ForceJoin方法,返回值=" + r );
}
function HiJack(){
	var r = toolbar.HiJack(document.getElementById("HiJackNumber").value);
	addLog("调用HiJack方法,返回值=" + r );
}
function SetAgentState(nstate){
	var r = toolbar.SetAgentState(nstate);
	if(nstate == 2)
		addLog("置闲" + r );
	else if(nstate ==4 )
		addLog("置忙" + r );
}
//开始监听
function StartListenChannel(){
	var r = toolbar.GetAgentState();
	switch(r){
		case 2:
		case 8:
			alert("请先置忙再监听")
			return;
		case -1:
		case 1:
		case 3:
		case 6:
			alert("此状态下不能监听")
			return;
		default:
			break;
	}
	var id =document.getElementById("listenChannelId").value;
	r = toolbar.StartListenChannel(id);
	addLog("调用StartListenChannel()" + r);
}

function StopListenChannel(){
	var r = toolbar.StopListenChannel();
	addLog("停止监听");
}

function GetLineState(){
	var r = toolbar.GetLineState();
	switch(r)
	{
		case -1  : document.getElementById("spanLineState").innerText = "未知状态(-1)";
			break;
		case 0  : document.getElementById("spanLineState").innerText = "空闲(0)";
			break;
		case 1  : document.getElementById("spanLineState").innerText = "振铃(1)";
			break;
		case 2  : document.getElementById("spanLineState").innerText = "拨号(2)";
			break;
		case 3  : document.getElementById("spanLineState").innerText = "通话(3)";
			break;
		case 4  : document.getElementById("spanLineState").innerText = "保持(4)";
			break;
		case 5  : document.getElementById("spanLineState").innerText = "保持下拨号(5)";
			break;
		case 6  : document.getElementById("spanLineState").innerText = "保持下通话(6)";
			break;
		case 7  : document.getElementById("spanLineState").innerText = "挂机(7)";
			break;
		case 8  : document.getElementById("spanLineState").innerText = "摘机(8)";
			break;
		case 9  : document.getElementById("spanLineState").innerText = "咨询(9)";
			break;
		case 10 : document.getElementById("spanLineState").innerText = "转移(10)";
			break;
		case 11 : document.getElementById("spanLineState").innerText = "取保持(11)";
			break;
		case 12 : document.getElementById("spanLineState").innerText = "三方(12)";
			break;
		case 13 : document.getElementById("spanLineState").innerText = "会议(13)";
			break;
		case 14 : document.getElementById("spanLineState").innerText = "监听(14)";
			break;
		case 15 : document.getElementById("spanLineState").innerText = "强插(15)";
			break;
		case 16 : document.getElementById("spanLineState").innerText = "拦截(16)";
			break;
		default:
			addLog("LineStateChanged", "no normal linestate ="+r);
			break;
	}
}

function getAllGroup(){
	var r = toolbar.GetGroupList();
	addLog( "调用GetGroupList方法, 返回值=" + r );
}

function getIdleAgentList(){
	var group = document.getElementById("idleAgentGroupId").value;
	var r = toolbar.GetIdleAgentList( group );
	addLog( "调用GetIdleAgentList方法, 返回值=" + r );
}

function getTalkAgentList(){
	var group = document.getElementById("idleAgentGroupId").value;
	var r = toolbar.GetTalkAgentList( group );
	addLog( "调用GetTalkAgentList方法, 返回值=" + r );
}

function getAllAgentList(){
	var group = document.getElementById("idleAgentGroupId").value;
	var r = toolbar.GetAgentListFromGroup( group );
	addLog( "调用GetAgentListFromGroup方法, 返回值=" + r );
}

function getCaller(){
	var r = toolbar.GetCaller();
	addLog( "调用GetCaller方法, 返回值=" + r );
}

function getCalled(){
	var r = toolbar.GetCalled();
	addLog( "调用GetCalled方法, 返回值=" + r );
	return r;
}

function getAppId(){
	var r = toolbar.GetRecordAppID();
	addLog( "调用GetRecordAppID方法, 返回值=" + r );
}

function getReturnIVR(){
	var r = toolbar.GetReturnToIVRInfo();
	addLog( "调用GetReturnToIVRInfo方法, 返回值=" + r );
}

function AgentRequestIVR(){
	var id = document.getElementById("ivrID").value;
	var AssociateDataToIvr = document.getElementById("AssociateDataToIvr").value;

	var r = toolbar.AgentRequestToIVR(id,AssociateDataToIvr);
	addLog( "调用AgentRequestToIVR方法，返回值" + r );
}

function addLog( msg ){
	var org_msg = document.getElementById("logArea").value;
	document.getElementById("logArea").value = org_msg + "\r\n" + msg;
}

function clearLog(){
	document.getElementById("logArea").value = "";
}

function SetRecServerAddr(){
	var RECIP = document.getElementById("szRECSerevrIP").value;
	var RECport = document.getElementById("iRECServerPort").value;
	var r = toolbar.SetRecServerAddr(RECIP,RECport);
	addLog("设置RECIP：" + RECIP + "RECport:" + RECport + "返回值" + r );
}
toolbar.OnAgentStateChanged(function( iAgentState ) {
	addLog( "坐席状态改变事件，iAgentState=" + iAgentState );
});

toolbar.OnLineStateChanged(function( iLineState ) {
	addLog( "线路状态改变事件，iLineState=" + iLineState );
});

toolbar.OnAgentDial(function( bResult ) {
	addLog( "坐席外呼结果事件，bResult=" + bResult );
});

toolbar.OnDialConnected(function() {
	addLog( "坐席外呼接通事件" );
});

toolbar.OnAnswerConnected(function() {
	addLog( "坐席来电接通事件" );
});

toolbar.OnTelephoneHangupInHold(function() {
	addLog( "电话保持中挂断事件" );
});

toolbar.OnTelephoneHangup(function( szRemoteNum ) {
	addLog( "电话挂断事件:szRemoteNum=" + szRemoteNum );
});

toolbar.OnQueuingNumberChanged(function( bResult, iQueuingNumber, szQueuingList ) {
	addLog( "组内排队数变化事件:bResult=" + bResult + ",iQueuingNumber=" + iQueuingNumber + ",szQueuingList=" + szQueuingList );
});

toolbar.OnGetGroupList(function( bResult, szGroupList ) {
	addLog( "获得坐席组ID返回事件:bResult=" + bResult + ",szGroupList=" + szGroupList );
});

toolbar.OnGetIdleAgentList(function( bResult, szIdleAgentList, szIdleAgentNameList, szIdleAgentExtList ) {
	addLog( "获得空闲坐席列表返回事件:bResult=" + bResult + ",szIdleAgentList=" + szIdleAgentList + ",szIdleAgentNameList=" + szIdleAgentNameList + ",szIdleAgentExtList=" + szIdleAgentExtList );
});

toolbar.OnGetTalkAgentList(function( bResult, szTalkAgentIdList, szTalkAgentExtList ) {
	addLog( "获得通话坐席列表返回事件:bResult=" + bResult + ",szTalkAgentIdList=" + szTalkAgentIdList + ",szTalkAgentExtList=" + szTalkAgentExtList );
});

toolbar.OnGetAgentListFromGroup(function( bResult, szGroupID, szAgentIdList, szNameList, szAgentExtList, szAgentStateList ) {
	addLog( "获得组内所有坐席列表返回事件:bResult=" + bResult + ",szGroupID=" + szGroupID + ",szAgentIdList=" + szAgentIdList + ",szNameList=" + szNameList + ",szAgentExtList=" + szAgentExtList + ",szAgentStateList=" + szAgentStateList );
});

toolbar.OnReturnToIVRInfo(function( bResult, iID, szReturnNodeDes, szFlowFileName, szNodeID ) {
	addLog( "得到返回IVR节点信息返回事件:bResult=" + bResult + ",iID=" + iID + ",szReturnNodeDes=" + szReturnNodeDes + ",szFlowFileName=" + szFlowFileName + ",szNodeID=" + szNodeID );
});

toolbar.OnRecvAssociateData(function( iSourceType, szSource, szContent ) {
	addLog( "收到随路数据返回事件:iSourceType=" + iSourceType + ",szSource=" + szSource + ",szContent=" + szContent );
});

toolbar.OnTelephoneRegister(function( szAgentID, szAgentExt ) {
	addLog( "收到分机注册返回事件:szAgentID=" + szAgentID + ",szAgentExt=" + szAgentExt );
});

toolbar.OnTelephoneUnRegister(function( szAgentID, szAgentExt ) {
	addLog( "收到分机注销返回事件:szAgentID=" + szAgentID + ",szAgentExt=" + szAgentExt );
});

toolbar.OnForceRelease(function( iResult ){
	if( iResult == 1 )
		addLog("强拆成功");
	else
		addLog("强拆失败");
});


toolbar.OnForceState(function( szMonitorAgentID, szAgentID, iResult ){
	addLog("收到强置返回事件：班长：" + szMonitorAgentID + "强置坐席:" + szAgentID + "iResult"+iResult);

});

toolbar.OnStartListenChannel(function(QueryAgentExt,bResult){
	if(parseInt(bResult))
		addLog("On listening : "+QueryAgentExt);
	else addLog("Listen error");
});

toolbar.OnStopListenChannel(function(bResult){
	if(bResult)
		addLog("Stop ListenChannel");
});

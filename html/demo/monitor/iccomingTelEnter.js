var curl="http://localhost/springcloud-park/";
var toolbar = new ghToolbar( "mySoftphone" );
//获取token
var token=sessionStorage.token;
$(function () {
	//获取服务模块信息
	getServiceModule();
});



//获取服务模块信息
function getServiceModule(){
	$.ajax({
		type: 'get',
		url: curl + '/guest/customer/customerCalledInfoEnterController/serviceModules',
		dataType: "json",
		data: {},
		headers: {
			"X-Authorization-access_token":token
		},
		success: function (data) {
			if(data==undefined ||data==null ||data.data==null){
				alert("网络异常，请稍后重试...");
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

//连接ACD服务器
function connectACD(){
	var ip = document.getElementById("serverip").value;
	var port = document.getElementById("serverport").value;
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
	var agentId = document.getElementById("agentid").value;
	var agentName = document.getElementById("agentname").value;
	var ext = document.getElementById("extension").value;
	var groupId = document.getElementById("groupid").value;
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

toolbar.OnAgentLogout(function( bResult, iReason ) {
	addLog( "坐席登出返回事件，bResult=" + bResult );
	if(bResult){
		$("#logout").hide();
		$("#login").show();
		$("#optionNGDesc").html("......请登录.....");
	}else{
		$("#optionNGDesc").show();
		$("#optionNGDesc").html("登出失败");
		$("#optionOKDesc").html("");
		setTimeout(function(){document.getElementById("optionNGDesc").style.display="none";},3000);
	}
});

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

toolbar.OnTelephoneRing(function( szCaller, szCallid ) {
	addLog( "坐席来电振铃事件，szCaller=" + szCaller + ",szCallid=" + szCallid );

	//调试使用，篡改来电
	szCaller=18073856620;

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

//获取来电归属
function getCallerOwen(obj){
	$.ajax({
		type: 'get',
		url: curl + '/guest/customer/customerCalledInfoEnterController/getPhoneCalledOwen',
		dataType: "json",
		data: {
			phone: obj,
		},
		headers: {
			"X-Authorization-access_token":token
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
	$.ajax({
		type: 'get',
		url: curl + '/guest/customer/customerCalledInfoEnterController/getUserInfo',
		dataType: "json",
		data: {
			phone: obj,
		},
		headers: {
			"X-Authorization-access_token":token
		},
		success: function (data) {
			var table="<table border='1'>";
			table=table+"<tr><td style='width:80px'>行号</td><td style='width:80px'>性别</td>" +
				"<td style='width: 120px'>用户账号</td><td style='width: 80px'>邮箱</td><td style='width: 100px'>手机号</td></tr>";
			if(data==undefined ||data==null ||data.data==null){
				table=table+"<tr><td colspan='5' style='text-align: center'>当前来电非系统用户，暂无用户信息</td></tr>";
			}else if(data.code='0000'){
				var user=data.data;
				table=table+"<tr><td style='width:80px'>1</td><td style='width:80px'>"+user.sex+"</td>" +
					"<td style='width: 120px'>"+user.account+"</td><td style='width: 80px'>"+user.email+"</td><td style='width: 100px'>"+user.phone+"</td></tr>";
			}
			table=table+"</table>";
			$("#userInfo").html(table);
		}
	});
}

//获取来电用户历史信息
function getCalledHistory(obj){
	$.ajax({
		type: 'get',
		url: curl + '/guest/customer/customerCalledInfoEnterController/getCalledHistory',
		dataType: "json",
		data: {
			phone: obj,
		},
		headers: {
			"X-Authorization-access_token":token
		},
		success: function (data) {
			var table="<table>";
			table=table+"<tr><td style='width:200px'>问题编号</td><td style='width:100px'>业务模块</td>" +
				"<td style='width: 100px'>处理状态</td><td style='width: 250px'>问题标题</td>" +
				"<td style='width: 160px'>时间</td><td style='width: 100px'>详情</td></tr>";
			if(data==undefined ||data==null ||data.data==null ||data.data.rows.length==0){
				table=table+"<tr><td colspan='6' style='text-align: center'>当前来电用户暂无历史信息</td></tr>";
			}else if(data.code='0000'){
				var customerList=data.data.rows;
				$("#historyNum").html(customerList.length);
				for(var i=0;i<customerList.length;i++){
					var info=customerList[i];
					var showStatus="";
					if(info.status=='0'){showStatus="待处理"}
					if(info.status=='1'){showStatus="处理中"}
					if(info.status=='2'){showStatus="已处理"}
					if(info.status=='3'){showStatus="无法处理"}
					table=table+"<tr><td style='width:200px'>"+info.quesCode+"</td><td style='width:100px'>"+info.serviceModuleName+"</td>" +
						"<td style='width: 100px'>"+showStatus+"</td><td style='width: 250px'>"+info.quesTitle+"</td>" +
						"<td style='width: 160px'>"+info.createdTime+"</td>" +
						"<td style='width: 100px'><a href='javascript:void(0);' onclick='getHistoryDetails(this)' value='"+info.processInsId+"'>详情></a></td></tr>";
				}
			}
			table=table+"</table>";
			$("#history").html(table);
		}
	});
}

//根据流程实例id查看客服问题详情
function getHistoryDetails(obj){
	//根据流程实例id,用户账号查看问题详情
	var processInsId = $(obj).attr("value");
	$.ajax({
		type: 'get',
		url: curl + '/guest/customer/customerCalledInfoEnterController/customerQuesDetail',
		dataType: "json",
		data: {
			processInsId: processInsId,
		},
		headers: {
			"X-Authorization-access_token":token
		},
		success: function (data) {
			if(data!=undefined && data!=null && data.data!=null && data.code=='0000'){
				console.log(data.data);
			}
			$(".quesLayer").show();
			$(".quesBox").show();
		}
	});
}
//问题详情弹出框关闭
function closeQuesBox(){
	$(".quesLayer").hide();
	$(".popquesBoxLayer").hide();

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
	$("#currentCallShow").val("");
	$("#calledNumberShow").val("");
	$("#callerOwenShow").val("");
	$("#phoneShow").val("");
	//给来电信息赋值
	$("#currentCallShow").val($("#currentCall").val());
	$("#calledNumberShow").val($("#calledNumber").val());
	$("#callerOwenShow").val($("#callerOwen").val());
	$("#phoneShow").val($("#currentCall").val());
	//关闭弹窗
	$(".popBox").hide();
	$(".popLayer").hide();
	//来电信息显示
	$("#calledInfo").show();
	//历史信息显示
	$("#historyDesc").show();
	$("#history").show();
	//来电录入显示
	$("#calledEnter").show();
	//提交按钮显示
	$("#submitButton").show();
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
		 "contactWay":contactWay
	 }
	//显示加载中...
	$("#submitDesc").show();
	//提交按钮禁用
	$("#buttons").attr({"disabled":"disabled"});
	//提交数据
	$.ajax({
		type: 'post',
		url: curl + '/guest/customer/customerCalledInfoEnterController/saveCalledInfo',
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		data: JSON.stringify(json),
		headers: {
			"X-Authorization-access_token":token
		},
		success: function (data) {
			$("#submitDesc").hide();
			$("#buttons").removeAttr("disabled");
			if(data!=undefined &&data!=null && data.data!=null
				&& data.code=='0000'){
				//清空来电录入信息
				$("#quesTitle").val("");
				$("#serviceModule").val("");
				$("#quesDetails").val("");
				$("#clientType").val("");
				$("#custName").val("");
				$("#contactWay").val("");

				//清空来电信息
				$("#currentCallShow").val("");
				$("#calledNumberShow").val("");
				$("#callerOwenShow").val("");
				$("#phoneShow").val("");
				//历史记录 0条
				$("#historyNum").html(0);
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
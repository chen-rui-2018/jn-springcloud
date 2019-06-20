window.ghToolbar = (function(){
	if (typeof(String.prototype.trim) === "undefined") {
		String.prototype.trim = function() {
			return String(this).replace(/^\s+|\s+$/g, '');
		}
	}
	
	function pad( src, totalbit ) {    
		var len = src.toString().length;   
		while(len < totalbit) {        
			src += " ";        
			len++;    
		}    
		return src;
	}
	
	function setCookie( name, value ) {
		var Days = 30;
		var exp = new Date();
		exp.setTime(exp.getTime() + Days*24*60*60*1000);
		document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();
	}
	
	function getCookie(name) {
		var arr,reg=new RegExp("(^| )"+name+"=([^;]*)(;|$)");
		if(arr=document.cookie.match(reg))
		return unescape(arr[2]);
		else
		return null;
	}

	
	//构造函数
	function ghToolbar( parentId ){
		var self = this;
		this.agent = new ghAgent();
		
		this.parentId = parentId;
		this.DeviceName = "1001";
		this.CTIServer = "127.0.0.1";
		this.CTIServerPort = 3000;
		this.IdleTimeout = 5;
		this.agentId = "";
		this.agentGroupId = "1";
		this.agentPwd = "";
		this.loginFlag = false;
		this.agentState = 0;
		this.lineState = 7;
		this.returnIvrId = 0;
		this.currentPhoneNum = "";
		this.currentCallId = "";
		
		this.onLoginSuccFunc = null;									//onLoginSucc event callback handle
		this.onLoginFailFunc = null;									//onLoginFail event callback handle
		this.onEvtRecordFunc = null;									//onEvtRecord event callback handle
		this.onMakeCallSuccFunc = null;								//onMakeCallSucc event callback handle
		this.onMakeCallFailedFunc = null;							//onMakeCallFailed event callback handle
		this.onEvtCallArriveFunc = null;							//OnEvtCallArrive event callback handle
		this.onLineStateChangeFunc = null;						//onLineStateChange event callback handle
		
		this.toolBarDivId = "toolBarDiv";
		this.configDivId = "configDiv";
		this.stateInputId = "stateInput";
		this.dropButtonId = "dropButton";
		this.holdButtonId = "holdButton";
		this.consultButtonId = "consultButton";
		this.transferButtonId = "transferButton";
		this.conferenceButtonId = "conferenceButton";
		this.dialButtonId = "dialButton";
		this.phoneInputId = "phoneInput";
		this.evalButtonId = "evalButton";
		this.stateButtonId = "stateButton";
		this.ipInputId = "ipInput";
		this.extInputId = "extInput";
		this.timeInputId = "timeInput";
		this.idInputId = "idInput";
		this.groupInputId = "groupInput";
		this.loginButtonId = "loginButton";
		this.logoutButtonId = "logoutButton";
		this.busyDivId = "busyDiv";
		
		this.createToolbar();
		
		var v = getCookie( "ctiip" );
		if( v != null ){
			this.CTIServer = v;
		}
		v = getCookie( "ctiext" );
		if( v != null ){
			this.DeviceName = v;
		}
		v = getCookie( "ctitime" );
		if( v != null ){
			this.IdleTimeout = v;
		}
		v = getCookie( "ctiid" );
		if( v != null ){
			this.agentId = v;
		}
		v = getCookie( "ctigroup" );
		if( v != null ){
			this.agentGroupId = v;
		}
		
		this.agent.onAgentConnectToACDCallback(function( state ) {
			switch( parseInt(state) ){
			case 0:
				if( self.onLoginFailFunc != null ){
					self.onLoginFailFunc( "参数错误" );
				}
				break;
			case 1:
				self.agent.Login( self.agentId, self.agentId, self.DeviceName, self.agentGroupId, 1, 0 );
				break;
			case 2:
				if( self.onLoginFailFunc != null ){
					self.onLoginFailFunc( "重复登陆" );
				}
				break;
			}
			self.updateDisplay();
		});
		
		this.agent.onAgentLoginCallback(function( bResult, iReason ) {
			switch( parseInt(iReason) ){
			case -1:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "未知原因" );
				break;
			case 0:
				self.loginFlag = true;
				if( self.onLoginSuccFunc != null )	self.onLoginSuccFunc();
				self.agent.GetReturnToIVRInfo();
				break;
			case 1:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "分机不存在" );
				break;
			case 2:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "分机重复" );
				break;
			case 3:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "分机未注册" );
				break;
			case 4:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "帐号已在别处登录" );
				break;
			case 5:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "License不足" );
				break;
			case 6:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "登录超时" );
				break;
			case 7:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "连接失败" );
				break;
			case 8:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "已经登录" );
				break;
			case 9:
				if( self.onLoginFailFunc != null )	self.onLoginFailFunc( "License过期" );
				break;
			}
			self.updateDisplay();
			if( self.loginFlag == false ){
				self.DoLogOut();
			}
		});
		
		this.agent.onAgentLogoutCallback(function( bResult ) {
			self.loginFlag = false;
			self.updateDisplay();
		});
		
		this.agent.onAgentDisConnectToACDCallback(function() {
			self.loginFlag = false;
			self.updateDisplay();
		});
		
		this.agent.onAgentStateChangedCallback(function( iState ) {
			self.agentState = iState;
			self.updateDisplay();
			if( parseInt(iState) == 5 ){
				setTimeout( function() {
        	if( self.agent.GetAgentState() == 5 ){
						self.agent.SetAgentState( 2 );
					}
      	}, 1000*parseInt(self.IdleTimeout) );
			}
		});
		
		this.agent.onLineStateChangedCallback(function( iState ) {
			self.lineState = iState;
			self.updateDisplay();
			if( self.onLineStateChangeFunc != null )		self.onLineStateChangeFunc( iState );
		});
		
		this.agent.onAgentDialConfCallback(function( iResult ) {
			if( iResult == true ){
				if( self.onMakeCallSuccFunc != null )		self.onMakeCallSuccFunc();
			}
			else{
				if( self.onMakeCallFailedFunc != null )		self.onMakeCallFailedFunc( "外拨失败" );
			}
		});
		
		this.agent.onTelephoneRingCallback(function( callerr, callid, called ) {
			self.currentPhoneNum = callerr;
			self.currentCallId = callid;
			if( self.onEvtCallArriveFunc != null )		self.onEvtCallArriveFunc( callerr, called );
		});
		
		this.agent.onReturnToIVRInfoCallback(function( bResult, iID, szReturnNodeDes, szFlowFileName, szNodeID ) {
			self.returnIvrId = iID;
		});
		
		this.agent.onYARecPathCallback(function( filename ) {
			if( self.onEvtRecordFunc != null )		self.onEvtRecordFunc( filename );
		});		
	}

	//绘制工具条	
	ghToolbar.prototype.createToolbar = function(){
		var self = this;
		var parentDiv = document.getElementById( this.parentId );
		//整体DIV
		var toolBarDiv = document.createElement('div');
		toolBarDiv.id = this.toolBarDivId;
		parentDiv.appendChild( toolBarDiv );
		//状态显示INPUT
		var stateInput = document.createElement('input');
		stateInput.id = this.stateInputId;
		stateInput.setAttribute( "readOnly", 'true' );
		stateInput.setAttribute( "value", "未连接服务器" );
		toolBarDiv.appendChild( stateInput );
		//签入按钮
		var loginButton = document.createElement("input");
		loginButton.id = this.loginButtonId;
		loginButton.type = "button";
		loginButton.setAttribute( "class", "btn" );
		loginButton.value = "签入";
		loginButton.disabled = false;
		loginButton.onclick = function () {
			self.DoLogin( self.agentId, "" );
    }
		toolBarDiv.appendChild( loginButton );
		//签出按钮
		var logoutButton = document.createElement("input");
		logoutButton.id = this.logoutButtonId;
		logoutButton.type = "button";
		logoutButton.setAttribute( "class", "btn" );
		logoutButton.value = "签出";
		logoutButton.disabled = true;
		logoutButton.onclick = function () {
			self.DoLogOut();
    }
		toolBarDiv.appendChild( logoutButton );
		//坐席状态按钮
		var stateButton = document.createElement("input");
		stateButton.id = this.stateButtonId;
		stateButton.type = "button";
		stateButton.setAttribute( "class", "btn" );
		stateButton.value = "置闲";
		stateButton.disabled = true;
		stateButton.onclick = function () {
			if( stateButton.value == "置闲" ){
				self.agent.SetAgentState( 2 );
			}
			else{
				document.getElementById("busyerrspan").innerHTML = "";
    		document.getElementById( self.busyDivId ).style.display = "";
    		document.getElementById( self.toolBarDivId ).style.display = "none";
			}
    }
		toolBarDiv.appendChild( stateButton );
		//挂机按钮
		var dropButton = document.createElement("input");
		dropButton.id = this.dropButtonId;
		dropButton.type = "button";
		dropButton.setAttribute( "class", "btn" );
		dropButton.value = "挂机";
		dropButton.disabled = true;
		dropButton.onclick = function () {
			self.agent.Onhook();
    }
		toolBarDiv.appendChild( dropButton );
		//外呼按钮
		var dialButton = document.createElement("input");
		dialButton.id = this.dialButtonId;
		dialButton.type = "button";
		dialButton.setAttribute( "class", "btn" );
		dialButton.value = "外拨";
    dialButton.disabled = true;
    dialButton.onclick = function () {
			self.agent.Dial( document.getElementById(self.phoneInputId).value );
    }
		toolBarDiv.appendChild( dialButton );
		//保持按钮
		var holdButton = document.createElement("input");
		holdButton.id = this.holdButtonId;
		holdButton.type = "button";
		holdButton.setAttribute( "class", "btn" );
		holdButton.value = "保持";
    holdButton.disabled = true;
    holdButton.onclick = function () {
    	if( holdButton.value == "保持" ){
				self.agent.Hold();
			}
			else{
				self.agent.UnHold();
			}
    }
		toolBarDiv.appendChild( holdButton );
		//咨询按钮
		var consultButton = document.createElement("input");
		consultButton.id = this.consultButtonId;
		consultButton.type = "button";
		consultButton.setAttribute( "class", "btn" );
		consultButton.value = "咨询";
    consultButton.disabled = true;
    consultButton.onclick = function () {
			self.agent.Consult( document.getElementById(self.phoneInputId).value );
    }
		toolBarDiv.appendChild( consultButton );
		//转移按钮
		var transferButton = document.createElement("input");
		transferButton.id = this.transferButtonId;
		transferButton.type = "button";
		transferButton.setAttribute( "class", "btn" );
		transferButton.value = "转移";
    transferButton.disabled = true;
    transferButton.onclick = function () {
			self.agent.Onhook();
    }
		toolBarDiv.appendChild( transferButton );
		//三方按钮
		var conferenceButton = document.createElement("input");
		conferenceButton.id = this.conferenceButtonId;
		conferenceButton.type = "button";
		conferenceButton.setAttribute( "class", "btn" );
		conferenceButton.value = "三方";
    conferenceButton.disabled = true;
    conferenceButton.onclick = function () {
			self.agent.ThirdParty();
    }
		toolBarDiv.appendChild( conferenceButton );
		//评价按钮
		var evalButton = document.createElement("input");
		evalButton.id = this.evalButtonId;
		evalButton.type = "button";
		evalButton.setAttribute( "class", "btn" );
		evalButton.value = "评价";
    evalButton.disabled = true;
    evalButton.onclick = function () {
    	var AssociateDataToIvr = "";
			AssociateDataToIvr += pad( self.agentId, 20 );
			AssociateDataToIvr += pad( self.agentGroupId, 10 );
			AssociateDataToIvr += pad( self.currentPhoneNum, 20 );
			AssociateDataToIvr += pad( self.currentCallId, 30 );
			self.agent.AgentRequestToIVR( "1", AssociateDataToIvr );
    }
		toolBarDiv.appendChild( evalButton );
		//外拨号码
		var dialSpan = document.createElement("span");
		dialSpan.id = "tempspan";
		dialSpan.innerHTML = "外拨/咨询号码:";
		toolBarDiv.appendChild( dialSpan );
		var phoneInput = document.createElement('input');
		phoneInput.id = this.phoneInputId;
		toolBarDiv.appendChild( phoneInput );
		
		//配置
		var configButton = document.createElement("input");
		configButton.type = "button";
		configButton.setAttribute( "class", "btn" );
		configButton.value = "配置";
    configButton.onclick = function () {
    	document.getElementById( self.ipInputId ).value = self.CTIServer;
    	document.getElementById( self.extInputId ).value = self.DeviceName;
    	document.getElementById( self.timeInputId ).value = self.IdleTimeout;
    	document.getElementById( self.idInputId ).value = self.agentId;
    	document.getElementById( self.groupInputId ).value = self.agentGroupId;
    	document.getElementById( self.toolBarDivId ).style.display = "none";
    	document.getElementById( self.configDivId ).style.display = "";
    }
		toolBarDiv.appendChild( configButton );
		
		//置忙DIV
		var busyDiv = document.createElement('div');
		busyDiv.id = this.busyDivId;
		busyDiv.style.display = "none";
		parentDiv.appendChild( busyDiv );
		//常规忙
		var busy1Button = document.createElement("input");
		busy1Button.id = "busy1";
		busy1Button.type = "button";
		busy1Button.setAttribute( "class", "btn" );
		busy1Button.value = "常规置忙";
		busy1Button.onclick = function () {
				if( self.agent.SetAgentState( 101 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy1Button );
		//回访忙
		var busy2Button = document.createElement("input");
		busy2Button.id = "busy2";
		busy2Button.type = "button";
		busy2Button.setAttribute( "class", "btn" );
		busy2Button.value = "回访";
		busy2Button.onclick = function () {
				if( self.agent.SetAgentState( 102 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy2Button );
		//磋商事宜忙
		var busy3Button = document.createElement("input");
		busy3Button.id = "busy3";
		busy3Button.type = "button";
		busy3Button.setAttribute( "class", "btn" );
		busy3Button.value = "磋商事宜";
		busy3Button.onclick = function () {
				if( self.agent.SetAgentState( 103 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy3Button );
		//培训事宜忙
		var busy4Button = document.createElement("input");
		busy4Button.id = "busy4";
		busy4Button.type = "button";
		busy4Button.setAttribute( "class", "btn" );
		busy4Button.value = "培训事宜";
		busy4Button.onclick = function () {
				if( self.agent.SetAgentState( 104 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy4Button );
		//电气维修事宜忙
		var busy5Button = document.createElement("input");
		busy5Button.id = "busy5";
		busy5Button.type = "button";
		busy5Button.setAttribute( "class", "btn" );
		busy5Button.value = "电气维修事宜";
		busy5Button.onclick = function () {
				if( self.agent.SetAgentState( 105 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy5Button );
		//就餐忙
		var busy6Button = document.createElement("input");
		busy6Button.id = "busy6";
		busy6Button.type = "button";
		busy6Button.setAttribute( "class", "btn" );
		busy6Button.value = "就餐";
		busy6Button.onclick = function () {
				if( self.agent.SetAgentState( 106 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy6Button );
		//开会忙
		var busy7Button = document.createElement("input");
		busy7Button.id = "busy7";
		busy7Button.type = "button";
		busy7Button.setAttribute( "class", "btn" );
		busy7Button.value = "开会";
		busy7Button.onclick = function () {
				if( self.agent.SetAgentState( 107 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy7Button );
		//其他问题处理忙
		var busy8Button = document.createElement("input");
		busy8Button.id = "busy8";
		busy8Button.type = "button";
		busy8Button.setAttribute( "class", "btn" );
		busy8Button.value = "其他问题处理";
		busy8Button.onclick = function () {
				if( self.agent.SetAgentState( 108 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy8Button );
		//项目和管理忙
		var busy9Button = document.createElement("input");
		busy9Button.id = "busy9";
		busy9Button.type = "button";
		busy9Button.setAttribute( "class", "btn" );
		busy9Button.value = "项目和管理";
		busy9Button.onclick = function () {
				if( self.agent.SetAgentState( 109 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy9Button );
		//玩游戏忙
		var busy10Button = document.createElement("input");
		busy10Button.id = "busy10";
		busy10Button.type = "button";
		busy10Button.setAttribute( "class", "btn" );
		busy10Button.value = "玩游戏";
		busy10Button.onclick = function () {
				if( self.agent.SetAgentState( 110 ) ){
					document.getElementById( self.busyDivId ).style.display = "none";
					document.getElementById( self.toolBarDivId ).style.display = "";
				}
				else{
					document.getElementById("busyerrspan").innerHTML = "当前状态无法置忙";
				}
    }
		busyDiv.appendChild( busy10Button );
		//返回主页面按钮
		var busyReturnButton = document.createElement("input");
		busyReturnButton.type = "button";
		busyReturnButton.setAttribute( "class", "btn" );
		busyReturnButton.value = "取消置忙";
    busyReturnButton.onclick = function () {
    	document.getElementById("busyerrspan").innerHTML = "";
    	document.getElementById( self.busyDivId ).style.display = "none";
    	document.getElementById( self.toolBarDivId ).style.display = "";
    }
		busyDiv.appendChild( busyReturnButton );
		//错误提示
		var busyerrspan = document.createElement("span");
		busyerrspan.id = "busyerrspan";
		busyerrspan.innerHTML = "";
		busyDiv.appendChild( busyerrspan );
		
		
		//配置DIV
		var configDiv = document.createElement('div');
		configDiv.id = this.configDivId;
		configDiv.style.display = "none";
		parentDiv.appendChild( configDiv );
		
		//CTI地址
		var ipSpan = document.createElement("span");
		ipSpan.id = "ipspan";
		ipSpan.innerHTML = "CTI地址:";
		configDiv.appendChild( ipSpan );
		var ipInput = document.createElement('input');
		ipInput.id = this.ipInputId;
		configDiv.appendChild( ipInput );
		
		//分机号码
		var extSpan = document.createElement("span");
		extSpan.id = "extspan";
		extSpan.innerHTML = "分机号码:";
		configDiv.appendChild( extSpan );
		var extInput = document.createElement('input');
		extInput.id = this.extInputId;
		configDiv.appendChild( extInput );
		
		//自动置闲时长
		var timeSpan = document.createElement("span");
		timeSpan.id = "timespan";
		timeSpan.innerHTML = "自动置闲时长:";
		configDiv.appendChild( timeSpan );
		var timeInput = document.createElement('input');
		timeInput.id = this.timeInputId;
		configDiv.appendChild( timeInput );
		
		//坐席工号
		var idSpan = document.createElement("span");
		idSpan.id = "idspan";
		idSpan.innerHTML = "坐席工号:";
		configDiv.appendChild( idSpan );
		var idInput = document.createElement('input');
		idInput.id = this.idInputId;
		configDiv.appendChild( idInput );
		
		//坐席组号
		var groupSpan = document.createElement("span");
		groupSpan.id = "groupspan";
		groupSpan.innerHTML = "业务组号:";
		configDiv.appendChild( groupSpan );
		var groupInput = document.createElement('input');
		groupInput.id = this.groupInputId;
		configDiv.appendChild( groupInput );
		
		//错误提示
		var errSpan = document.createElement("span");
		errSpan.id = "errspan";
		errSpan.innerHTML = "";
		configDiv.appendChild( errSpan );
		
		//保存按钮
		var saveButton = document.createElement("input");
		saveButton.type = "button";
		saveButton.setAttribute( "class", "btn" );
		saveButton.value = "保存设置";
    saveButton.onclick = function () {
    	var ctiip = document.getElementById(self.ipInputId).value.trim();
    	var ctiext = document.getElementById(self.extInputId).value.trim();
    	var ctitime = document.getElementById(self.timeInputId).value.trim();
    	var ctiid = document.getElementById(self.idInputId).value.trim();
    	var ctigroup = document.getElementById(self.groupInputId).value.trim();
    	if( ctiip == "" || ctiext == "" || ctitime == "" || ctiid == "" || ctigroup == "" ){
    		document.getElementById("errspan").innerHTML = "请输入完整的参数!";
    		return;
    	}
    	setCookie( "ctiip", ctiip );
    	setCookie( "ctiext", ctiext );
    	setCookie( "ctitime", ctitime );
			setCookie( "ctiid", ctiid );
			setCookie( "ctigroup", ctigroup );
			self.CTIServer = ctiip;
			self.DeviceName = ctiext;
			self.IdleTimeout = ctitime;
			self.agentId = ctiid;
			self.agentGroupId = ctigroup;
			document.getElementById("errspan").innerHTML = "";
    	document.getElementById( self.configDivId ).style.display = "none";
    	document.getElementById( self.toolBarDivId ).style.display = "";
    }
		configDiv.appendChild( saveButton );
		
		//返回主页面按钮
		var unSaveButton = document.createElement("input");
		unSaveButton.type = "button";
		unSaveButton.setAttribute( "class", "btn" );
		unSaveButton.value = "不保存返回";
    unSaveButton.onclick = function () {
    	document.getElementById("errspan").innerHTML = "";
    	document.getElementById( self.configDivId ).style.display = "none";
    	document.getElementById( self.toolBarDivId ).style.display = "";
    }
		configDiv.appendChild( unSaveButton );
	};
	
	//签入坐席
	ghToolbar.prototype.DoLogin = function( szAgentId, szAgentPwd ){
		this.agentId = szAgentId;
		this.agentPwd = szAgentPwd;
		this.agent.ConnectToACD( this.CTIServer, this.CTIServerPort );
	};
	
	//签出坐席
	ghToolbar.prototype.DoLogOut = function(){
		this.agent.DisConnectToACD();
	};
	
	//外呼
	ghToolbar.prototype.DoMakeCall = function( called ){
		this.agent.Dial( called );
	};
	
	//挂机
	ghToolbar.prototype.DropCall = function(){
		this.agent.Onhook();
	};
	
	//获取随路数据
	ghToolbar.prototype.DoGetAssociatedData = function( ivrPath){
		return "咨询";
	}; 
	
	//控制界面按钮
	ghToolbar.prototype.updateDisplay = function(){
		document.getElementById(this.loginButtonId).disabled = true;
		document.getElementById(this.logoutButtonId).disabled = true;
		document.getElementById(this.dropButtonId).disabled = true;
		document.getElementById(this.holdButtonId).disabled = true;
		document.getElementById(this.consultButtonId).disabled = true;
		document.getElementById(this.transferButtonId).disabled = true;
		document.getElementById(this.conferenceButtonId).disabled = true;
		document.getElementById(this.dialButtonId).disabled = true;
		document.getElementById(this.evalButtonId).disabled = true;
		document.getElementById(this.stateButtonId).disabled = true;
		
		if( this.loginFlag == false ){
			document.getElementById(this.stateInputId).value = "未连接服务器";
			document.getElementById(this.loginButtonId).disabled = false;
		}
		else{
			switch( this.agentState ){
			case -1:
				document.getElementById(this.stateInputId).value = "未知状态";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 0:
				document.getElementById(this.stateInputId).value = "离席";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 1:
				document.getElementById(this.stateInputId).value = "登录";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 2:
				document.getElementById(this.stateInputId).value = "空闲";
				document.getElementById(this.stateButtonId).value = "置忙";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 3:
				document.getElementById(this.stateInputId).value = "话务忙";
				document.getElementById(this.stateButtonId).value = "置闲";
				break;
			case 4:
				document.getElementById(this.stateInputId).value = "人工忙";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 5:
				document.getElementById(this.stateInputId).value = "话后忙";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 6:
				document.getElementById(this.stateInputId).value = "被锁定分配";
				document.getElementById(this.stateButtonId).value = "置闲";
				break;
			case 7:
				document.getElementById(this.stateInputId).value = "强置忙";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 8:
				document.getElementById(this.stateInputId).value = "强置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				document.getElementById(this.stateButtonId).value = "置忙";
				break;
			case 101:
				document.getElementById(this.stateInputId).value = "常规忙";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 102:
				document.getElementById(this.stateInputId).value = "回访";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 103:
				document.getElementById(this.stateInputId).value = "磋商事宜";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 104:
				document.getElementById(this.stateInputId).value = "培训事宜";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 105:
				document.getElementById(this.stateInputId).value = "电气维修事宜";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 106:
				document.getElementById(this.stateInputId).value = "就餐";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 107:
				document.getElementById(this.stateInputId).value = "开会";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 108:
				document.getElementById(this.stateInputId).value = "其他问题处理";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 109:
				document.getElementById(this.stateInputId).value = "项目和管理";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			case 110:
				document.getElementById(this.stateInputId).value = "玩游戏";
				document.getElementById(this.stateButtonId).value = "置闲";
				document.getElementById(this.logoutButtonId).disabled = false;
				break;
			default:
				document.getElementById(this.stateInputId).value = "已连接服务器";
				break;
			}
			switch( this.lineState ){
			case -1:	//未知状态
				break;
			case 0:		//空闲
			case 7:		//挂机
				if( this.agentState == 4 || this.agentState == 5 || this.agentState == 7 || this.agentState > 100 ){
					document.getElementById(this.dialButtonId).disabled = false;
				}
				document.getElementById(this.holdButtonId).value = "保持";
				document.getElementById(this.stateButtonId).disabled = false;
				break;
			case 1:		//振铃
			case 2:		//拨号
				document.getElementById(this.dropButtonId).disabled = false;
				document.getElementById(this.holdButtonId).value = "保持";
				break;
			case 3:		//通话
			case 11:	//取保持
				document.getElementById(this.dropButtonId).disabled = false;
				document.getElementById(this.holdButtonId).value = "保持";
				document.getElementById(this.holdButtonId).disabled = false;
				document.getElementById(this.consultButtonId).disabled = false;
				document.getElementById(this.evalButtonId).disabled = false;
				break;
			case 4:		//保持
				document.getElementById(this.holdButtonId).value = "取保持";
				document.getElementById(this.holdButtonId).disabled = false;
				break;
			case 5:		//保持下拨号
				break;
			case 6:		//保持下通话
				break;
			case 8:		//摘机
				break;
			case 9:		//咨询
				document.getElementById(this.holdButtonId).value = "取保持";
				document.getElementById(this.holdButtonId).disabled = false;
				document.getElementById(this.transferButtonId).disabled = false;
				document.getElementById(this.conferenceButtonId).disabled = false;
				break;
			case 10:	//转移
				break;
			case 12:	//三方
				document.getElementById(this.dropButtonId).disabled = false;
				document.getElementById(this.holdButtonId).value = "保持";
				break;
			case 13:	//会议
				break;
			case 14:	//监听
				break;
			case 15:	//强插
				break;
			case 16:	//拦截
				break;
			}
		}
	}
	
	//坐席登陆成功回调函数
  ghToolbar.prototype.onLoginSucc = function(callback){
  	this.onLoginSuccFunc = callback;
  }
	
	//坐席登陆失败回调函数
  ghToolbar.prototype.onLoginFail = function(callback){
  	this.onLoginFailFunc = callback;
  }
  
  //外呼成功回调函数
  ghToolbar.prototype.onMakeCallSucc = function(callback){
  	this.onMakeCallSuccFunc = callback;
  }
  
  //外呼失败回调函数
  ghToolbar.prototype.onMakeCallFailed = function(callback){
  	this.onMakeCallFailedFunc = callback;
  }
  
  //外呼失败回调函数
  ghToolbar.prototype.onEvtCallArrive = function(callback){
  	this.onEvtCallArriveFunc = callback;
  }
  
  //录音文件名生成回调函数
  ghToolbar.prototype.onEvtRecord = function(callback){
  	this.onEvtRecordFunc = callback;
  }
	
	//线路状态变化回调函数
  ghToolbar.prototype.onLineStateChange = function(callback){
  	this.onLineStateChangeFunc = callback;
  }	
	
	return ghToolbar;
})();

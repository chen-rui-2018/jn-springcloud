var ghAgentUrl=document.scripts;
ghAgentUrl=ghAgentUrl[ghAgentUrl.length-1].src.substring(0,ghAgentUrl[ghAgentUrl.length-1].src.lastIndexOf("/")+1);
 
window.ghToolbar = (function(){
	if (typeof(String.prototype.trim) === "undefined") {
		String.prototype.trim = function() {
			return String(this).replace(/^\s+|\s+$/g, '');
		}
	}

	//构造函数
	function ghToolbar( parentId ){
		var self = this;
		this.agent = new ghAgent( window.ghAgentUrl );
		
		this.parentId = parentId;
		this.extension = "";
		this.ctiServer = "";
		this.ctiServerPort = 3000;
		this.connectFlag = false;
		this.loginFlag = false;
		this.calledId = "";
		this.callerId = "";
		this.lineState = 7;
		this.agentID = "";
		this.agentName = "";
		this.agentExt = "";
		this.groupID = "";
		this.agentLevel = 0;
		this.agentState = 0;
		this.agentRight = false;
		
		this.toolBarDivId = "toolBarDiv";
		this.infoDivId = "infoDiv";
		this.queueSpanId = "queueSpan";
		this.callerSpanId = "callerSpan";
		this.lineDivId = "lineDiv";
		this.lineImgId = "lineImg";
		this.buttonDivId = "buttonDiv";
		this.buttonTableId = "buttonTable";
		this.idleButtonId = "idleButton";
		this.idleButtonLableId = "idleButtonLabel";
		this.dialButtonId = "dialButton";
		this.dialButtonLableId = "dialButtonLabel";
		this.answerButtonId = "answerButton";
		this.answerButtonLableId = "answerButtonLabel";
		this.holdButtonId = "holdButton";
		this.holdButtonLableId = "holdButtonLabel";
		this.consultButtonId = "consultButton";
		this.consultButtonLableId = "consultButtonLabel";
		this.transferButtonId = "transferButton";
		this.transferButtonLableId = "transferButtonLabel";
		this.conferenceButtonId = "conferenceButton";
		this.conferenceButtonLableId = "conferenceButtonLabel";
		this.evalButtonId = "evalButton";
		this.evalButtonLableId = "evalButtonLabel";
		this.ForceReleaseButtonId = "ForceReleaseButton";
		this.ForceReleaseButtonLableId = "ForceReleaseButtonLabel";
		this.ForceJoinButtonId = "ForceJoinButton";
		this.ForceJoinButtonLableId = "ForceJoinButtonLabel";
		this.HiJackButtonId = "HiJackButton";
		this.HiJackButtonLableId = "HiJackButtonLabel";
		this.listenChannelButtonId = "listenChannelButton";
		this.listenChannelButtonLabelId = "listenChannelButtonLabel";
		
		this.forceStateButtonId = "forceStateButton";
		this.forceStateButtonLabelId = "forceStateButtonLabel";
		this.buttonSubmitId = "SubmitButton";


		this.monitorDivId = "monitorDiv";
		this.stateBottomDivId = "stateBottomDiv";
		this.stateTopDivId = "stateTopDiv";
		this.stateTopImgId = "stateTopImg";
		this.inputPhoneId = "inputPhone";
		this.inputPhoneStateId = "inputPhoneStateId";
		this.buttonDialConfirmId = "buttonDialConfirm";
		this.labelId = "label";
		this.forceStatelabelId = "forceStatelabel";
		
		
		this.OnAgentConnectToACDFunc = null;									//OnAgentConnectToACD event callback handle
		this.OnAgentDisConnectToACDFunc = null;								//OnAgentDisConnectToACD event callback handle
		this.OnAgentStateChangedFunc = null;									//OnAgentStateChanged event callback handle
		this.OnLineStateChangedFunc = null;										//OnLineStateChanged event callback handle
		this.OnAgentLoginFunc = null;													//OnAgentLogin event callback handle
		this.OnLoginByCompanyUIDFunc = null;									//OnLoginByCompanyUID event callback handle
		this.OnAgentLogoutFunc = null;												//OnAgentLogout event callback handle
		this.OnAgentDialFunc = null;													//OnAgentDial event callback handle
		this.OnDialConnectedFunc = null;											//OnDialConnected event callback handle
		this.OnTelephoneRingFunc = null;											//OnTelephoneRing event callback handle
		this.OnAnswerConnectedFunc = null;										//OnAnswerConnected event callback handle
		this.OnTelephoneHangupInHoldFunc = null;							//OnTelephoneHangupInHold event callback handle
		this.OnTelephoneHangupFunc = null;										//OnTelephoneHangup event callback handle
		this.OnQueuingNumberChangedFunc = null;								//OnQueuingNumberChanged event callback handle
		this.OnGetGroupListFunc = null;												//OnGetGroupList event callback handle
		this.OnGetIdleAgentListFunc = null;										//OnGetIdleAgentList event callback handle
		this.OnGetTalkAgentListFunc = null;										//OnGetTalkAgentList event callback handle
		this.OnGetAgentListFromGroupFunc = null;							//OnGetAgentListFromGroup event callback handle
		this.OnGetAgentStateCountFromGroupFunc = null;				//OnGetAgentStateCountFromGroup event callback handle
		this.OnGetCallIDFunc = null;													//OnGetCallID event callback handle
		this.OnReturnToIVRInfoFunc = null;										//OnReturnToIVRInfo event callback handle
		this.OnRequestToIVRFunc = null;												//OnRequestToIVR event callback handle
		this.OnConsultConnectedFunc = null;										//OnConsultConnected event callback handle
		this.OnCancelConsultFunc = null;											//OnCancelConsult event callback handle
		this.OnAgentThirdPartyFunc = null;										//OnAgentThirdParty event callback handle
		this.OnAgentRemoveMemberFromThirdPartyFunc = null;		//OnAgentRemoveMemberFromThirdParty event callback handle
		this.OnRecvAssociateDataFunc = null;									//OnRecvAssociateData event callback handle
		this.OnTelephoneRegisterFunc = null;									//OnTelephoneRegister event callback handle
		this.OnTelephoneUnRegisterFunc = null;								//OnTelephoneUnRegister event callback handle
		this.OnEvaluationButtonFunc = null;
		
		this.OnForceReleaseFunc = null;
		this.OnNotifyAgentForcedReleaseFunc = null;
		this.OnForceJoinFunc = null;
		this.OnNotifyAgentForceJoinFunc = null;
		this.OnHiJackFunc = null;
		this.OnNotifyAgentHiJackFunc = null;
		this.OnForceStateFunc = null;
		this.OnNotifyAgentForcedStateFunc = null;
		this.OnStartListenChannelFunc = null;
		this.OnStopListenChannelFunc = null;
		this.loadImage();
		this.createToolbar();
		
		this.agent.onAgentConnectToACDCallback(function( state ) {
			switch( parseInt(state) ){
			case 1:
			case 2:
				self.connectFlag = true;
				break;
			default:
				self.connectFlag = false;
			}
			if( self.OnAgentConnectToACDFunc != null ) self.OnAgentConnectToACDFunc( state );
			self.updateDisplay();
		});	
		
		this.agent.onAgentDisConnectToACDCallback(function( bResult, iReason) {
			self.connectFlag = false;
			self.loginFlag = false;
			self.lineState = 7;
			self.updateDisplay();
			if( self.OnAgentDisConnectToACDFunc != null ) self.OnAgentDisConnectToACDFunc( bResult, iReason );
		});
		
		this.agent.onAgentLoginCallback(function( bResult, iReason ) {
			if( parseInt(iReason) == 0 ){
				self.loginFlag = true;
				self.lineState = 7;
			}
			self.updateDisplay();
			if( self.OnAgentLoginFunc != null ) self.OnAgentLoginFunc( bResult, iReason );
		});
		
		this.agent.onLoginByCompanyUIDCallback(function( bResult, iReason ) {
			if( parseInt(iReason) == 0 ){
				self.loginFlag = true;
				self.lineState = 7;
			}
			self.updateDisplay();
			if( self.OnLoginByCompanyUIDFunc != null ) self.OnLoginByCompanyUIDFunc( bResult, iReason );
		});
		
		this.agent.onAgentLogoutCallback(function( bResult ) {
			if( bResult == true ){
				self.loginFlag = false;
				self.agentRight = false;
				self.lineState = 7;
			}
			self.updateDisplay();
			if( self.OnAgentLogoutFunc != null ) self.OnAgentLogoutFunc( bResult );
		});	
		
		this.agent.onAgentStateChangedCallback(function( iState ) {
			self.agentState = iState;
			self.updateDisplay();
			if( self.OnAgentStateChangedFunc != null )		self.OnAgentStateChangedFunc( iState );
		});
		
		this.agent.onLineStateChangedCallback(function( iState ) {
			self.lineState = iState;
			self.updateDisplay();
			if( self.OnLineStateChangedFunc != null )		self.OnLineStateChangedFunc( iState );
		});
		
		this.agent.onAgentDialConfCallback(function( bResult ) {
			if( self.parentId != null ){
				document.getElementById(self.callerSpanId).innerText = "通话号码:" + self.calledId;
			}
			if( self.OnAgentDialFunc != null )		self.OnAgentDialFunc( bResult );
		});
		
		this.agent.onDialConnectedCallback(function() {
			if( self.OnDialConnectedFunc != null )		self.OnDialConnectedFunc();
		});
		
		this.agent.onTelephoneRingCallback(function( szCaller, szCallid, szAgentExt ) {
			self.callerId = szCaller;
			if( self.parentId != null ){
				document.getElementById(self.callerSpanId).innerText = "通话号码:" + self.callerId;
			}
			if( self.OnTelephoneRingFunc != null )		self.OnTelephoneRingFunc( szCaller, szCallid );
		});
		
		this.agent.onAnswerConnectedCallback(function() {
			if( self.OnAnswerConnectedFunc != null )		self.OnAnswerConnectedFunc();
		});
		
		this.agent.onTelephoneHangupInHoldCallback(function() {
			if( self.OnTelephoneHangupInHoldFunc != null )		self.OnTelephoneHangupInHoldFunc();
		});
		
		this.agent.onTelephoneHangupCallback(function( szRemoteNum ) {
			if( self.OnTelephoneHangupFunc != null )		self.OnTelephoneHangupFunc( szRemoteNum );
		});
		
		this.agent.onQueuingNumberChangedCallback( function( bResult, iQueuingNumber, szQueuingList ) {
			if( self.parentId != null ){
				var str = "当前排队数: ";
				str += iQueuingNumber;
				document.getElementById(self.queueSpanId).innerText = str;
			}
			if( self.OnQueuingNumberChangedFunc != null )		self.OnQueuingNumberChangedFunc( bResult, iQueuingNumber, szQueuingList );
		});
		
		this.agent.onGetGroupListCallback( function( bResult, szGroupList ) {
			if( self.OnGetGroupListFunc != null )		self.OnGetGroupListFunc( bResult, szGroupList );
		});
		
		this.agent.onGetIdleAgentListCallback( function( bResult, szIdleAgentList, szIdleAgentNameList, szIdleAgentExtList ) {
			if( self.OnGetIdleAgentListFunc != null )		self.OnGetIdleAgentListFunc( bResult, szIdleAgentList, szIdleAgentNameList, szIdleAgentExtList );
		});
		
		this.agent.onGetTalkAgentListCallback( function( bResult, szTalkAgentIdList, szTalkAgentExtList ) {
			if( self.OnGetTalkAgentListFunc != null )		self.OnGetTalkAgentListFunc( bResult, szTalkAgentIdList, szTalkAgentExtList );
		});
		
		this.agent.onGetAgentListFromGroupCallback( function( bResult, szGroupID, szAgentIdList, szNameList, szAgentExtList, szAgentStateList ) {
			if( self.OnGetAgentListFromGroupFunc != null )		self.OnGetAgentListFromGroupFunc( bResult, szGroupID, szAgentIdList, szNameList, szAgentExtList, szAgentStateList );
		});
		
		this.agent.onGetAgentStateCountFromGroupCallback( function( bResult, szGroupID, iAgentState, iCount ) {
			if( self.OnGetAgentStateCountFromGroupFunc != null )		self.OnGetAgentStateCountFromGroupFunc( bResult, szGroupID, iAgentState, iCount );
		});
		
		this.agent.onGetCallIDCallback( function( bResult, szCallID ) {
			if( self.OnGetCallIDFunc != null )		self.OnGetCallIDFunc( bResult, szCallID );
		});
		
		this.agent.onReturnToIVRInfoCallback( function( bResult, iID, szReturnNodeDes, szFlowFileName, szNodeID ) {
			if( self.OnReturnToIVRInfoFunc != null )		self.OnReturnToIVRInfoFunc( bResult, iID, szReturnNodeDes, szFlowFileName, szNodeID );
		});
		
		this.agent.onRequestToIVRCallback( function( bResult, szIVRSoftphone, iType ) {
			if( self.OnReturnToIVRInfoFunc != null )		self.OnReturnToIVRInfoFunc( bResult, szIVRSoftphone, iType );
		});
		
		this.agent.onConsultConnectedCallback( function( bResult, szConsultNumber ) {
			if( self.OnReturnToIVRInfoFunc != null )		self.OnReturnToIVRInfoFunc( bResult, szConsultNumber );
		});
		
		this.agent.onCancelConsultCallback( function( bResult ) {
			if( self.OnCancelConsultFunc != null )		self.OnCancelConsultFunc( bResult );
		});
		
		this.agent.onAgentThirdPartyCallback( function( bResult, szConfID ) {
			if( self.OnAgentThirdPartyFunc != null )		self.OnAgentThirdPartyFunc( bResult, szConfID );
		});
		
		this.agent.onAgentRemoveMemberFromThirdPartyCallback( function( bResult, iRemovedParty ) {
			if( self.OnAgentRemoveMemberFromThirdPartyFunc != null )		self.OnAgentRemoveMemberFromThirdPartyFunc( bResult, iRemovedParty );
		});
		
		this.agent.onRecvAssociateDataCallback( function( iSourceType, szSource, szContent ) {
			if( self.OnRecvAssociateDataFunc != null )		self.OnRecvAssociateDataFunc( iSourceType, szSource, szContent );
		});
		
		this.agent.onTelephoneRegisterCallback( function( szAgentID, szAgentExt ) {
			if( self.OnTelephoneRegisterFunc != null )		self.OnTelephoneRegisterFunc( szAgentID, szAgentExt );
		});
		
		this.agent.onTelephoneUnRegisterCallback( function( szAgentID, szAgentExt ) {
			if( self.OnTelephoneUnRegisterFunc != null )		self.OnTelephoneUnRegisterFunc( szAgentID, szAgentExt );
		});
		
		this.agent.onForceHangupCallback(function(iResult){
			if(self.OnForceReleaseFunc != null)     	self.OnForceReleaseFunc( iResult );
		});
		
		this.agent.onForceJoinCallback(function(iResult){
			if(self.OnForceJoinFunc != null)   self.OnForceJoinFunc( iResult );
		});
		
		this.agent.onHijackCallback(function(iResult){
			if(self.OnHiJackFunc != null)  self.OnHiJackFunc( iResult );
		});
		
		this.agent.onForceStateCallback( function(szMonitorAgentID,szAgentID,iResult){
			if( self.OnForceStateFunc != null) 		self.OnForceStateFunc( szMonitorAgentID, szAgentID, iResult );
		});
		
		this.agent.onStartListenChannelCallback( function(QueryAgentExt,bResult){
			if(self.OnStartListenChannelFunc != null) 	self.OnStartListenChannelFunc( QueryAgentExt,bResult );
			if( bResult == 1 ){
				self.lineState = 14;
			}
			else alert("监听" + QueryAgentExt + " 失败代码：" + bResult );
			self.updateDisplay();
		});
		
		this.agent.onStopListenChannelCallback(function(bResult){
			if(self.OnStopListenChannelFunc != null) 	self.OnStopListenChannelFunc( bResult );
			if(bResult == 1)
			{
				self.lineState = 7;	
			}
			self.updateDisplay();
			});
	}
		
	ghToolbar.prototype.showMask = function( type ){
		var self = this;
		var odiv = document.getElementById( this.toolBarDivId );
		document.getElementById("mask").style.left = odiv.getBoundingClientRect().left;
		document.getElementById("mask").style.top = odiv.getBoundingClientRect().top;
		document.getElementById("mask").style.width = odiv.getBoundingClientRect().width;
		document.getElementById("mask").style.height = odiv.getBoundingClientRect().height;
		if( type == "dial" ){
			//document.getElementById(this.inputPhoneId).className = "dialinput";
			document.getElementById(this.labelId).className = "dialinput";
			document.getElementById(this.labelId).innerHTML = "分机号码：";
			document.getElementById(this.buttonDialConfirmId).value = "外拨";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.Dial( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}
		}
		else if( type == "consult" ){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "分机号码：";
			document.getElementById(this.buttonDialConfirmId).value = "咨询";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.Consult( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}
		}
		else if( type == "transfer"){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "分机号码：";
			document.getElementById(this.buttonDialConfirmId).value = "转移";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.BlindTransfer( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}	
		}
		else if(type =="ForceRelease"){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "工号：";
			document.getElementById(this.buttonDialConfirmId).value = "强拆";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.ForceRelease( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}	
		}
		else if(type =="ForceJoin"){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "工号：";
			document.getElementById(this.buttonDialConfirmId).value = "强插";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.ForceJoin( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}	
		}
		else if(type =="HiJack"){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "工号：";
			document.getElementById(this.buttonDialConfirmId).value = "拦截";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.HiJack( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}	
		}
		else if(type =="listen"){
			document.getElementById(this.labelId).className = "consultinput";
			document.getElementById(this.labelId).innerHTML = "工号：";
			document.getElementById(this.buttonDialConfirmId).value = "监听";
			document.getElementById(this.buttonDialConfirmId).onclick = function () {
				self.StartListenChannel( document.getElementById(self.inputPhoneId).value );
				self.hideMask();
    	}	
		}
		
		document.getElementById("mask").style.display = "";
		document.getElementById(this.inputPhoneId).focus();     
	};  

	ghToolbar.prototype.hideMask = function(){ 
		document.getElementById("mask").style.display = "none";
	};
	
	ghToolbar.prototype.showforceState= function( type ){
		var self = this;
		var odiv = document.getElementById( this.toolBarDivId );
		document.getElementById("forceStateDiv").style.left = odiv.getBoundingClientRect().left;
		document.getElementById("forceStateDiv").style.top = odiv.getBoundingClientRect().top;
		document.getElementById("forceStateDiv").style.width = odiv.getBoundingClientRect().width;
		document.getElementById("forceStateDiv").style.height = odiv.getBoundingClientRect().height;
		document.getElementById(this.forceStatelabelId).className = "dialinput";
		document.getElementById(this.forceStatelabelId).innerHTML = "工号：";	
		document.getElementById(this.buttonSubmitId).onclick = function () {
				var StateSelect = document.getElementById("StateId");
				var index = StateSelect.selectedIndex;
				self.ForceState( document.getElementById(self.inputPhoneStateId).value,StateSelect.options[index].value );
				self.hideforceState();
    }
		document.getElementById("forceStateDiv").style.display = "";
		document.getElementById(this.inputPhoneStateId).focus();     
	};  

	
	
	
	ghToolbar.prototype.hideforceState = function(){ 
		document.getElementById("forceStateDiv").style.display = "none";
	};
	
	//加载按钮图片
	ghToolbar.prototype.loadImage = function(){
		if( this.parentId == null )		return;
	};
	
	//绘制工具条	
	ghToolbar.prototype.createToolbar = function(){
		if( this.parentId == null )		return;
		
		var self = this;
		var parentDiv = document.getElementById( this.parentId );
		//整体DIV
		var toolBarDiv = document.createElement('div');
		toolBarDiv.id = this.toolBarDivId;
		parentDiv.appendChild( toolBarDiv );
		//信息栏DIV
		var infoDiv = document.createElement('div');
		infoDiv.id = this.infoDivId;
		toolBarDiv.appendChild( infoDiv );
		//排队数SPAN
		var queueSpan = document.createElement('span');
		queueSpan.id = this.queueSpanId;
		queueSpan.innerText = "当前排队数: 0";
		infoDiv.appendChild( queueSpan );
		//通话号码SPAN
		var callerSpan = document.createElement('span');
		callerSpan.id = this.callerSpanId;
		callerSpan.innerText = "通话号码: ";
		infoDiv.appendChild( callerSpan );
		//普通坐席按钮栏DIV
		var buttonDiv = document.createElement('div');
		buttonDiv.id = this.buttonDivId;
		toolBarDiv.appendChild( buttonDiv );
		//按钮栏TABLE
		var buttonTable = document.createElement('table');
		buttonTable.id = this.buttonTableId;
		buttonDiv.appendChild( buttonTable );
		//按钮行
		var buttonTr = document.createElement('tr');
		buttonTable.appendChild( buttonTr );
		//坐席状态按钮
		var buttonTd = document.createElement('td');
		buttonTd.className = "relativeTd";
		buttonTr.appendChild( buttonTd );
		var stateBottomDiv = document.createElement('div');
		stateBottomDiv.id = this.stateBottomDivId;
		stateBottomDiv.className = "bottomDiv";
		buttonTd.appendChild( stateBottomDiv );
		var stateTopDiv = document.createElement('div');
		stateTopDiv.id = this.stateTopDivId;
		stateTopDiv.className = "topDiv";
		buttonTd.appendChild( stateTopDiv );
		var stateTopImg = document.createElement('img');
		stateTopImg.id = this.stateTopImgId;
		stateTopImg.src = "";		
		stateTopDiv.appendChild( stateTopImg );
		var idleButton = document.createElement('a');
		idleButton.id = this.idleButtonId;
		idleButton.className = "leaveButton_d";
		stateBottomDiv.appendChild( idleButton );
		//外拨按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var dialButton = document.createElement('a');
		dialButton.id = this.dialButtonId;
		dialButton.className = "dialButton_d";
		buttonTd.appendChild( dialButton );
		//摘机按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var answerButton = document.createElement('a');
		answerButton.id = this.answerButtonId;
		answerButton.className = "answerButton_d";
		buttonTd.appendChild( answerButton );
		//保持按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var holdButton = document.createElement('a');
		holdButton.id = this.holdButtonId;
		holdButton.className = "holdButton_d";
		buttonTd.appendChild( holdButton );
		//咨询按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var consultButton = document.createElement('a');
		consultButton.id = this.consultButtonId;
		consultButton.className = "consultButton_d";
		buttonTd.appendChild( consultButton );
		//转移按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var transferButton = document.createElement('a');
		transferButton.id = this.transferButtonId;
		transferButton.className = "transferButton_d";
		buttonTd.appendChild( transferButton );
		//三方按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var conferenceButton = document.createElement('a');
		conferenceButton.id = this.conferenceButtonId;
		conferenceButton.className = "conferenceButton_d";
		buttonTd.appendChild( conferenceButton );
		//评价按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var evalButton = document.createElement('a');
		evalButton.id = this.evalButtonId;
		evalButton.className = "evalButton_d";
		buttonTd.appendChild( evalButton );
		
		
		
		
		//描述行
		buttonTr = document.createElement('tr');
		buttonTable.appendChild( buttonTr );
		//置闲描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.idleButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "未连接";
		buttonTr.appendChild( buttonTd );
		//外拨描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.dialButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "外拨"; 
		buttonTr.appendChild( buttonTd );
		//摘机描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.answerButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "接听"; 
		buttonTr.appendChild( buttonTd );
		//保持描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.holdButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "保持"; 
		buttonTr.appendChild( buttonTd );
		//咨询描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.consultButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "咨询"; 
		buttonTr.appendChild( buttonTd );
		//转移描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.transferButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "转移"; 
		buttonTr.appendChild( buttonTd );
		//三方描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.conferenceButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "三方"; 
		buttonTr.appendChild( buttonTd );
		//评价描述
		buttonTd = document.createElement('td');
		buttonTd.id = this.evalButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "评价"; 
		buttonTr.appendChild( buttonTd );
		//分隔条
		var lineDiv = document.createElement('div');
		lineDiv.id = this.lineDivId;
		lineDiv.style.display = "none";
		toolBarDiv.appendChild( lineDiv );
		var lineImg = document.createElement('img');
		lineImg.id = this.lineImgId;
		lineImg.src = window.ghAgentUrl + "img/line.png";
		lineDiv.appendChild( lineImg );

		//班长坐席层
		var monitorDiv = document.createElement('div');
		monitorDiv.id = this.monitorDivId;
		monitorDiv.style.display = "none";
		toolBarDiv.appendChild( monitorDiv );
		//按钮栏table
		var buttonTable = document.createElement('table');
		buttonTable.id = this.buttonTableId;
		monitorDiv.appendChild( buttonTable );
		//按钮行
		var buttonTr = document.createElement('tr');
		buttonTable.appendChild( buttonTr );
		//强拆按钮
		var buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var ForceReleaseButton = document.createElement('a');
		ForceReleaseButton.id = this.ForceReleaseButtonId;
		ForceReleaseButton.className = "ForceReleaseButton_d";
		buttonTd.appendChild( ForceReleaseButton );
		//强插按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var ForceJoinButton = document.createElement('a');
		ForceJoinButton.id = this.ForceJoinButtonId;
		ForceJoinButton.className = "ForceJoinButton_d";
		buttonTd.appendChild( ForceJoinButton );
		//拦截按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var HiJackButton = document.createElement('a');
		HiJackButton.id = this.HiJackButtonId;
		HiJackButton.className = "HiJackButton_d";
		buttonTd.appendChild( HiJackButton );
		//监听按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild(buttonTd);
		var listenChannelButton = document.createElement('a');
		listenChannelButton.id = this.listenChannelButtonId;
		listenChannelButton.className = "StartlistenChannelButton_d";
		buttonTd.appendChild( listenChannelButton );		
		//强置按钮
		buttonTd = document.createElement('td');
		buttonTd.className = "buttonTd";
		buttonTr.appendChild( buttonTd );
		var forceStateButton = document.createElement('a');
		forceStateButton.id = this.forceStateButtonId;
		forceStateButton.className = "forceStateButton_d";
		buttonTd.appendChild( forceStateButton );
		
		//描述行
		buttonTr = document.createElement('tr');
		buttonTable.appendChild( buttonTr );
		//强拆
		buttonTd = document.createElement('td');
		buttonTd.id = this.ForceReleaseButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "强拆"; 
		buttonTr.appendChild( buttonTd );
		//强插
		buttonTd = document.createElement('td');
		buttonTd.id = this.ForceJoinButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "强插"; 
		buttonTr.appendChild( buttonTd );
		//拦截
		buttonTd = document.createElement('td');
		buttonTd.id = this.HiJackButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "拦截"; 
		buttonTr.appendChild( buttonTd );
		//监听
		buttonTd = document.createElement('td');
		buttonTd.id = this.listenChannelButtonLabelId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "监听";
		buttonTr.appendChild( buttonTd );
		
		//强置
		buttonTd = document.createElement('td');
		buttonTd.id = this.forceStateButtonLableId;
		buttonTd.className = "buttonTd";
		buttonTd.innerText = "强置"; 
		buttonTr.appendChild( buttonTd );
		
		//号码输入层
		//整体DIV
		var maskDiv = document.createElement('div');
		maskDiv.id = "mask";
		maskDiv.className = "mask";
		maskDiv.style.display = "none";
		parentDiv.appendChild( maskDiv );
		
				
		var inputText = document.createElement('label');
		inputText.id = this.labelId;
		maskDiv.appendChild( inputText);
		
		var inputPhone = document.createElement('input');
		inputPhone.type = "text";
		inputPhone.id = this.inputPhoneId;
		maskDiv.appendChild( inputPhone );
		
		buttonDialConfirm = document.createElement('input');
		buttonDialConfirm.type = "button";
		buttonDialConfirm.id = this.buttonDialConfirmId;
		buttonDialConfirm.value = "呼叫";
    maskDiv.appendChild( buttonDialConfirm );
		
		buttonCancel = document.createElement('input');
		buttonCancel.type = "button";
		buttonCancel.value = "返回";
		buttonCancel.onclick = function () {
			self.hideMask();
    }
		maskDiv.appendChild( buttonCancel );	
		//强置DIV
		var forceStateDiv = document.createElement('div');
		forceStateDiv.id = "forceStateDiv";
		forceStateDiv.className = "mask";
		forceStateDiv.style.display = "none";
		parentDiv.appendChild( forceStateDiv );
		
		
		var inputText = document.createElement('label');
		inputText.id = this.forceStatelabelId;
		forceStateDiv.appendChild( inputText);
		
		var inputPhone = document.createElement('input');
		inputPhone.type = "text";
		inputPhone.id = this.inputPhoneStateId;
		forceStateDiv.appendChild( inputPhone );
		
    var State = document.createElement("select");
    State.options[0] = new Option("离席", "0");
    State.options[1] = new Option("强制忙", "7");
    State.options[2] = new Option("强制闲", "8");
		State.id = "StateId";
    State.size = "3";
    forceStateDiv.appendChild(State);
			
		buttonSubmit = document.createElement('input');
		buttonSubmit.type = "button";
		buttonSubmit.id = this.buttonSubmitId;
		buttonSubmit.value = "提交";
    forceStateDiv.appendChild( buttonSubmit );
		
		buttonCancel = document.createElement('input');
		buttonCancel.type = "button";
		buttonCancel.value = "返回";
		buttonCancel.onclick = function () {
			self.hideforceState();
    }	
    forceStateDiv.appendChild( buttonCancel );	

	};
	
	//更新屏幕按钮状态
	ghToolbar.prototype.updateDisplay = function(){
		if( this.parentId == null )		return;
		var self = this;
		if( this.connectFlag == false ){		//断开连接时样式
			document.getElementById(this.queueSpanId).innerText = "当前排队数: 0";
			document.getElementById(this.callerSpanId).innerText = "通话号码: ";
			document.getElementById(this.stateTopDivId).style.display = "none";
			document.getElementById(this.idleButtonId).className = "leaveButton_d";
			document.getElementById(this.idleButtonId).onclick=function(){return false;} 
			document.getElementById(this.idleButtonLableId).innerText = "未连接";
			document.getElementById(this.dialButtonId).className = "dialButton_d";
			document.getElementById(this.dialButtonId).removeAttribute('href');
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			document.getElementById(this.dialButtonLableId).innerText = "外拨";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).removeAttribute('href');
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).removeAttribute('href');
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).removeAttribute('href');
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).removeAttribute('href');
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).removeAttribute('href');
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			return;
		}
		if( this.loginFlag == false ){	//已连接，未登陆
			document.getElementById(this.queueSpanId).innerText = "当前排队数: 0";
			document.getElementById(this.callerSpanId).innerText = "通话号码: ";
			document.getElementById(this.stateTopDivId).style.display = "none";
			document.getElementById(this.idleButtonId).className = "leaveButton";
			document.getElementById(this.idleButtonId).onclick=function(){return false;} 
			document.getElementById(this.idleButtonLableId).innerText = "已连接";
			document.getElementById(this.dialButtonId).className = "dialButton_d";
			document.getElementById(this.dialButtonId).removeAttribute('href');
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			document.getElementById(this.dialButtonLableId).innerText = "外拨";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).removeAttribute('href');
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).removeAttribute('href');
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).removeAttribute('href');
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).removeAttribute('href');
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).removeAttribute('href');
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			return;
		}
		if(this.agentRight){
			document.getElementById(this.lineDivId).style.display = "";
			document.getElementById(this.monitorDivId).style.display = "";
		}
		else{
			document.getElementById(this.lineDivId).style.display = "none";
			document.getElementById(this.monitorDivId).style.display = "none";
		}
		switch( parseInt(this.agentState) ){
		case 0:	
			document.getElementById(this.idleButtonId).className = "leaveButton";
			document.getElementById(this.idleButtonId).onclick = function(){
				alert(this.agentID+this.agentName+this.agentExt+this.groupID+this.agentLevel+this.agentRight);
				self.agent.LoginEx( this.agentID, this.agentName, this.agentExt, this.groupID, this.agentLevel, this.agentRight, 2 );	
			return false;
			}
			document.getElementById(this.idleButtonLableId).innerText = "离席";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/checkout.png";
			document.getElementById(this.dialButtonId).className = "dialButton_d";
			document.getElementById(this.dialButtonId).removeAttribute('href');
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			document.getElementById(this.dialButtonLableId).innerText = "外拨";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).removeAttribute('href');
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).removeAttribute('href');
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).removeAttribute('href');
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).removeAttribute('href');
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).removeAttribute('href');
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 2:		//空闲
			document.getElementById(this.idleButtonId).className = "idleButton";
			document.getElementById(this.idleButtonId).onclick=function(){
 				self.agent.SetAgentState( 4 );
 				return false;
 			} 
			document.getElementById(this.idleButtonLableId).innerText = "空闲";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/idleicon.png";
			break;
		case 3:		//话务忙
			document.getElementById(this.idleButtonId).className = "talkButton";
			document.getElementById(this.idleButtonId).onclick=function(){return false;} 
			document.getElementById(this.idleButtonLableId).innerText = "话务忙";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/talkicon.png";
			break;
		case 4:		//人工忙
			document.getElementById(this.idleButtonId).className = "busyButton";
			document.getElementById(this.idleButtonId).onclick=function(){
 				self.agent.SetAgentState( 2 );
 				return false;
 			} 
			document.getElementById(this.idleButtonLableId).innerText = "人工忙";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/busyicon.png";
			break;
		case 5:	//话后忙
			document.getElementById(this.idleButtonId).className = "busyButton";
			document.getElementById(this.idleButtonId).onclick=function(){
 				self.agent.SetAgentState( 2 );
 				return false;
 			} 
			document.getElementById(this.idleButtonLableId).innerText = "话后忙";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/busyicon.png";
			break;
		case 6:		//分配锁定
			document.getElementById(this.idleButtonId).className = "talkButton";
			document.getElementById(this.idleButtonId).onclick=function(){return false;} 
			document.getElementById(this.idleButtonLableId).innerText = "来电锁定";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/talkicon.png";
			break;
		case 7:		//强制忙
			document.getElementById(this.idleButtonId).className = "busyButton";
			document.getElementById(this.idleButtonId).onclick=function(){
 				self.agent.SetAgentState( 2 );
 				return false;
 			} 
 			
			document.getElementById(this.idleButtonLableId).innerText = "强制忙";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/busyicon.png";
			break;
		case 8:		//强制闲
			document.getElementById(this.idleButtonId).className = "idleButton";
			document.getElementById(this.idleButtonId).onclick=function(){
 				self.agent.SetAgentState( 4 );
 				return false;
 			} 
			document.getElementById(this.idleButtonLableId).innerText = "强制闲";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/idleicon.png";
			break;
		}
		
		switch( parseInt(this.lineState) ){
		case 0:		//空闲
		case 7:		//挂机
			if( this.agentState == 4 || this.agentState == 5 || this.agentState == 7 || this.agentState > 100 ){
				document.getElementById(this.dialButtonId).className = "dialButton";
				document.getElementById(this.dialButtonId).onclick=function(){
					self.showMask( "dial" );
					return false;
				}
				document.getElementById(this.dialButtonLableId).innerText = "外拨";

				document.getElementById(this.ForceReleaseButtonId).className = "ForceReleaseButton";
				document.getElementById(this.ForceReleaseButtonId).onclick = function(){
					self.showMask( "ForceRelease" );
					return false;	
				}
				document.getElementById(this.ForceJoinButtonId).className = "ForceJoinButton";
				document.getElementById(this.ForceJoinButtonId).onclick = function(){
					self.showMask( "ForceJoin" );
					return false;	
				}
				document.getElementById(this.HiJackButtonId).className = "HiJackButton";
				document.getElementById(this.HiJackButtonId).onclick = function(){
					self.showMask( "HiJack" );
					return false;	
				}
				document.getElementById(this.listenChannelButtonId).className = "StartlistenChannelButton";
				document.getElementById(this.listenChannelButtonLabelId).innerText = "监听";
				document.getElementById(this.listenChannelButtonId).onclick = function(){
					self.showMask( "listen" );
					return false;	
				}
				
				document.getElementById(this.forceStateButtonId).className = "forceStateButton";
				document.getElementById(this.forceStateButtonId).onclick = function(){
					self.showforceState();
					return false;	
				}
			}
			else{
				document.getElementById(this.dialButtonId).className = "dialButton_d";
				document.getElementById(this.dialButtonId).onclick=function(){return false;}
				document.getElementById(this.dialButtonLableId).innerText = "外拨";
				
				document.getElementById(this.ForceReleaseButtonId).className = "ForceReleaseButton_d";
				document.getElementById(this.ForceReleaseButtonId).onclick = function(){return false;}
				
				document.getElementById(this.ForceJoinButtonId).className = "ForceJoinButton_d";
				document.getElementById(this.ForceJoinButtonId).onclick = function(){return false;}
				
				document.getElementById(this.HiJackButtonId).className = "HiJackButton_d";
				document.getElementById(this.HiJackButtonId).onclick = function(){return false;}				
				
				document.getElementById(this.listenChannelButtonId).className = "StartlistenChannelButton_d";
				document.getElementById(this.listenChannelButtonId).onclick = function(){return false;}
				
				document.getElementById(this.forceStateButtonId).className = "forceStateButton_d";
				document.getElementById(this.forceStateButtonId).onclick = function(){return false;}				
			}
			document.getElementById(this.callerSpanId).innerText = "通话号码: ";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).removeAttribute('href');
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).removeAttribute('href');
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).removeAttribute('href');
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).removeAttribute('href');
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).removeAttribute('href');
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 1:		//振铃
			document.getElementById(this.dialButtonId).className = "onhookButton";
			document.getElementById(this.dialButtonId).onclick=function(){
					self.Onhook();
					return false;
			}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton";
			document.getElementById(this.answerButtonId).onclick=function(){
					self.Offhook();
					return false;
			}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 2:		//拨号
			document.getElementById(this.dialButtonId).className = "onhookButton";
			document.getElementById(this.dialButtonId).onclick=function(){
					self.Onhook();
					return false;
			}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 3:		//通话
			document.getElementById(this.dialButtonId).className = "onhookButton";
			document.getElementById(this.dialButtonId).onclick=function(){
					self.Onhook();
					return false;
			}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).removeAttribute('href');
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			
			document.getElementById(this.holdButtonId).className = "holdButton";
			document.getElementById(this.holdButtonId).onclick=function(){
				self.Hold();
				return false;
			}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			
			document.getElementById(this.consultButtonId).className = "consultButton";
			document.getElementById(this.consultButtonId).onclick=function(){
				self.showMask( "consult" );
				return false;
			}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			
			document.getElementById(this.transferButtonId).className = "transferButton";
			document.getElementById(this.transferButtonId).onclick=function(){
				self.showMask("transfer");
				return false;
			}
			document.getElementById(this.transferButtonLableId).innerText = "转移";
			
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton";
			document.getElementById(this.evalButtonId).onclick=function(){
				if( self.OnEvaluationButtonFunc != null )		self.OnEvaluationButtonFunc();

			}
			break;
		case 4:		//保持
			document.getElementById(this.dialButtonId).className = "onhookButton_d";
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "unholdButton";
			document.getElementById(this.holdButtonId).onclick=function(){
				self.UnHold();
				return false;
			}
			document.getElementById(this.holdButtonLableId).innerText = "取消保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 9:		//咨询
			document.getElementById(this.dialButtonId).className = "onhookButton_d";
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "unconsultButton";
			document.getElementById(this.consultButtonId).onclick=function(){
				self.CancelConsult();
				return false;
			}
			document.getElementById(this.consultButtonLableId).innerText = "取消咨询";
			document.getElementById(this.transferButtonId).className = "transferButton";
			document.getElementById(this.transferButtonId).onclick=function(){
				self.Onhook();
				return false;
			}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton";
			document.getElementById(this.conferenceButtonId).onclick=function(){
				self.ThirdParty();
				return false;
			}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 12:   //三方？
			document.getElementById(this.dialButtonId).className = "onhookButton";
			document.getElementById(this.dialButtonId).onclick=function(){
				self.Onhook();
				return false;
			}
			document.getElementById(this.dialButtonLableId).innerText = "挂机";
			document.getElementById(this.answerButtonId).className = "answerButton_d";
			document.getElementById(this.answerButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonId).className = "holdButton_d";
			document.getElementById(this.holdButtonId).onclick=function(){return false;}
			document.getElementById(this.holdButtonLableId).innerText = "保持";
			document.getElementById(this.consultButtonId).className = "consultButton_d";
			document.getElementById(this.consultButtonId).onclick=function(){return false;}
			document.getElementById(this.consultButtonLableId).innerText = "咨询";
			document.getElementById(this.transferButtonId).className = "transferButton_d";
			document.getElementById(this.transferButtonId).onclick=function(){return false;}
			document.getElementById(this.conferenceButtonId).className = "conferenceButton_d";
			document.getElementById(this.conferenceButtonId).onclick=function(){return false;}
			document.getElementById(this.evalButtonId).className = "evalButton_d";
			document.getElementById(this.evalButtonId).onclick=function(){return false;}
			break;
		case 14:   //监听
			document.getElementById(this.listenChannelButtonId).className = "StoplistenChannelButton";
			document.getElementById(this.listenChannelButtonId).onclick=function(){
				self.StopListenChannel();	
			}
			document.getElementById(this.listenChannelButtonLabelId).innerText = "停止监听";
			
			document.getElementById(this.dialButtonId).className = "dialButton_d";
			document.getElementById(this.dialButtonId).onclick=function(){return false;}
			
			document.getElementById(this.ForceReleaseButtonId).className = "ForceReleaseButton_d";
			document.getElementById(this.ForceReleaseButtonId).onclick = function(){return false;}
			
			document.getElementById(this.ForceJoinButtonId).className = "ForceJoinButton_d";
			document.getElementById(this.ForceJoinButtonId).onclick = function(){return false;}
			
			document.getElementById(this.HiJackButtonId).className = "HiJackButton_d";
			document.getElementById(this.HiJackButtonId).onclick = function(){return false;}				
			
			document.getElementById(this.forceStateButtonId).className = "forceStateButton_d";
			document.getElementById(this.forceStateButtonId).onclick = function(){return false;}				
			
			
			document.getElementById(this.idleButtonId).className = "talkButton";
			document.getElementById(this.idleButtonId).onclick=function(){return false;} 
			document.getElementById(this.idleButtonLableId).innerText = "话务忙";
			document.getElementById(this.stateTopDivId).style.display = "";
			document.getElementById(this.stateTopImgId).src = window.ghAgentUrl + "img/talkicon.png";
		}
	};
	
	//连接ACDServer
	ghToolbar.prototype.ConnectToACD = function( szACDSerevrIP, iACDServerPort ){
		this.ctiServer = szACDSerevrIP;
		this.ctiServerPort = iACDServerPort;
		return this.agent.ConnectToACD( this.ctiServer, this.ctiServerPort );
	};
	
	//断开ACDServer
	ghToolbar.prototype.DisConnectToACD = function(){
		this.ctiServer = "";
		this.ctiServerPort = 3000;
		return this.agent.DisConnectToACD();
	};
	
	//坐席登陆
	ghToolbar.prototype.LoginEx = function( szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight, iState ){
		this.agentID = szAgentID;
		this.agentName = szAgentName;
		this.agentExt = szAgentExt;
		this.groupID = szGroupID;
		this.agentLevel = iAgentLevel;
		this.agentRight = iAgentRight;
		this.agentState = iState;
		return this.agent.LoginEx( szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight, iState );
	};
	
	//企业坐席登陆
	ghToolbar.prototype.LoginByCompanyUID = function( szCompanyUID, szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight ){
		return this.agent.LoginByCompanyUID( szCompanyUID, szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight );
	};
	
	//坐席登出
	ghToolbar.prototype.Logout = function(){
		this.agentRight = 0;
		return this.agent.Logout();
	};
	
	//设置坐席状态
	ghToolbar.prototype.SetAgentState = function( iState ){
		return this.agent.SetAgentState( iState );
	};
	
	//坐席外呼
	ghToolbar.prototype.Dial = function( szPhoneNum ){
		this.calledId = szPhoneNum;
		return this.agent.Dial( szPhoneNum );
	};
	
	//挂机
	ghToolbar.prototype.Onhook = function(){
		return this.agent.Onhook();
	};
	
	//摘机
	ghToolbar.prototype.Offhook = function(){
		return this.agent.Offhook();
	};
	
	//保持
	ghToolbar.prototype.Hold = function(){
		return this.agent.Hold();
	};
	
	//取消保持
	ghToolbar.prototype.UnHold = function(){
		return this.agent.UnHold();
	};
	
	//盲转
	ghToolbar.prototype.BlindTransfer = function( szTransfer ){
		return this.agent.BlindTransfer( szTransfer );
	};
	
	//按工号盲转
	ghToolbar.prototype.BlindTransferByAgentID = function( szTransfer ){
		return this.agent.BlindTransferByAgentID( szTransfer );
	};
	
	//咨询
	ghToolbar.prototype.Consult = function( szConsult ){
		return this.agent.Consult( szConsult );
	};
	
	//按工号咨询
	ghToolbar.prototype.ConsultByAgentID = function( szConsult ){
		return this.agent.ConsultByAgentID( szConsult );
	};
	
	//取消咨询
	ghToolbar.prototype.CancelConsult = function(){
		return this.agent.CancelConsult();
	};
	
	//咨询变三方
	ghToolbar.prototype.ThirdParty = function(){
		return this.agent.ThirdParty();
	};
	
	//从三方中移除
	ghToolbar.prototype.RemoveMemberFromThirdParty = function( szRemoveParty ){
		return this.agent.RemoveMemberFromThirdParty( szRemoveParty );
	};
	
	//获取排队数
	ghToolbar.prototype.GetQueuingNumber = function(){
		return this.agent.GetQueuingNumber();
	};
	
	//获取坐席状态
	ghToolbar.prototype.GetAgentState = function(){
		return this.agent.GetAgentState();
	};
	
	//获取线路状态
	ghToolbar.prototype.GetLineState = function(){
		return this.agent.GetLineState();
	};
	
	//获取坐席组ID列表
	ghToolbar.prototype.GetGroupList = function(){
		return this.agent.GetGroupList();
	};
	
	//获取组内空闲坐席ID列表
	ghToolbar.prototype.GetIdleAgentList = function( szGroupID ){
		return this.agent.GetIdleAgentList(szGroupID);
	};
	
	//获取组内通话坐席ID列表
	ghToolbar.prototype.GetTalkAgentList = function( szGroupID ){
		return this.agent.GetTalkAgentList(szGroupID);
	};
	
	//获取组内所有坐席ID列表
	ghToolbar.prototype.GetAgentListFromGroup = function( szGroupID ){
		return this.agent.GetAgentListFromGroup(szGroupID);
	};
	
	//获取组内指定坐席状态的坐席个数
	ghToolbar.prototype.GetAgentStateCountFromGroup = function( szGroupID, iAgentState ){
		return this.agent.GetAgentStateCountFromGroup( szGroupID, iAgentState );
	};
	
	//获取获取主叫号码
	ghToolbar.prototype.GetCaller = function(){
		return this.agent.GetCaller();
	};
	
	//获取获取被叫号码
	ghToolbar.prototype.GetCalled = function(){
		return this.agent.GetCalled();
	};
	
	//获取CallID
	ghToolbar.prototype.GetCallID = function(){
		return this.agent.GetCallID();
	};
	
	//设置APPID
	ghToolbar.prototype.SetRecordAppID = function( szReocrdAppID ){
		return this.agent.SetRecordAppID(szReocrdAppID);
	};
	
	//得到APPID
	ghToolbar.prototype.GetRecordAppID = function(){
		return this.agent.GetRecordAppID();
	};
	
	//得到返回IVR节点信息
	ghToolbar.prototype.GetReturnToIVRInfo = function(){
		return this.agent.GetReturnToIVRInfo();
	};	
	
	//请求转回IVR
	ghToolbar.prototype.AgentRequestToIVR = function( iToIVRInfoID, szContent ){
		return this.agent.AgentRequestToIVR( iToIVRInfoID, szContent );
	};
	//强拆
	ghToolbar.prototype.ForceRelease = function( szAgentID ){
		return this.agent.ForceRelease(szAgentID );
	};
	//强插
	ghToolbar.prototype.ForceJoin = function( szAgentID ){
		return this.agent.ForceJoin(szAgentID );
	};
	//拦截
	ghToolbar.prototype.HiJack = function( szAgentID ){
		return this.agent.HiJack(szAgentID );
	};
	//开始监听
	ghToolbar.prototype.StartListenChannel = function( szAgentID ){
		return this.agent.StartListenChannel( szAgentID );	
	};
	//停止监听
	ghToolbar.prototype.StopListenChannel = function(){
		return this.agent.StopListenChannel();	
	};
	
	//强制改变状态
	ghToolbar.prototype.ForceState = function( szAgentID, iForceState ){
		return this.agent.ForceState( szAgentID, iForceState );
	};
	
	//获取线路状态
	ghToolbar.prototype.GetLineState = function(){
		return this.agent.GetLineState();	
	}
	
	ghToolbar.prototype.SetRecServerAddr = function(szRECSerevrIP,iRECServerPort){
		return this.agent.SetRecServerAddr(szRECSerevrIP,iRECServerPort);	
	} 
	
		
	//-----------------------------------------------------------------------------------------------------------------------------------------------------------
	//坐席连接回调函数
  ghToolbar.prototype.OnAgentConnectToACD = function(callback){
  	this.OnAgentConnectToACDFunc = callback;
  }
  
  //坐席断开回调函数
  ghToolbar.prototype.OnAgentDisConnectToACD = function(callback){
  	this.OnAgentDisConnectToACDFunc = callback;
  }
  
  //坐席登陆回调函数
  ghToolbar.prototype.OnAgentLogin = function(callback){
  	this.OnAgentLoginFunc = callback;
  }
  
  //企业坐席登陆回调函数
  ghToolbar.prototype.OnLoginByCompanyUID = function(callback){
  	this.OnLoginByCompanyUIDFunc = callback;
  }
  
  //坐席登出回调函数
  ghToolbar.prototype.OnAgentLogout = function(callback){
  	this.OnAgentLogoutFunc = callback;
  }
  
  //坐席状态改变回调函数
  ghToolbar.prototype.OnAgentStateChanged = function(callback){
  	this.OnAgentStateChangedFunc = callback;
  }
  
  //线路状态改变回调函数
  ghToolbar.prototype.OnLineStateChanged = function(callback){
  	this.OnLineStateChangedFunc = callback;
  }
  
  //坐席外呼结果回调函数
  ghToolbar.prototype.OnAgentDial = function(callback){
  	this.OnAgentDialFunc = callback;
  }
  
  //外呼接通事件回调函数
  ghToolbar.prototype.OnDialConnected = function(callback){
  	this.OnDialConnectedFunc = callback;
  }
  
  //来电振铃事件回调函数
  ghToolbar.prototype.OnTelephoneRing = function(callback){
  	this.OnTelephoneRingFunc = callback;
  }
  
	//来电接通事件回调函数
  ghToolbar.prototype.OnAnswerConnected = function(callback){
  	this.OnAnswerConnectedFunc = callback;
  }
  
  //电话在保持中挂断事件回调函数
  ghToolbar.prototype.OnTelephoneHangupInHold = function(callback){
  	this.OnTelephoneHangupInHoldFunc = callback;
  }
  
  //电话挂断事件回调函数
  ghToolbar.prototype.OnTelephoneHangup = function(callback){
  	this.OnTelephoneHangupFunc = callback;
  }
  
  //组内排队数变化回调函数
  ghToolbar.prototype.OnQueuingNumberChanged = function(callback){
  	this.OnQueuingNumberChangedFunc = callback;
  }
  
  //坐席组ID列表回调函数
  ghToolbar.prototype.OnGetGroupList = function(callback){
  	this.OnGetGroupListFunc = callback;
  }
  
  //得到组内空闲坐席ID列表回调函数
  ghToolbar.prototype.OnGetIdleAgentList = function(callback){
  	this.OnGetIdleAgentListFunc = callback;
  }
  
  //得到组内通话坐席ID列表回调函数
  ghToolbar.prototype.OnGetTalkAgentList = function(callback){
  	this.OnGetTalkAgentListFunc = callback;
  }
  
  //得到组内通话坐席ID列表回调函数
  ghToolbar.prototype.OnGetAgentListFromGroup = function(callback){
  	this.OnGetAgentListFromGroupFunc = callback;
  }
  
  //得到组内指定坐席状态的坐席个数回调函数
  ghToolbar.prototype.OnGetAgentStateCountFromGroup = function(callback){
  	this.OnGetAgentStateCountFromGroupFunc = callback;
  }
  
  //得到callid回调函数
  ghToolbar.prototype.OnGetCallID = function(callback){
  	this.OnGetCallIDFunc = callback;
  }
  
  //转回IVR信息回调函数
  ghToolbar.prototype.OnReturnToIVRInfo = function(callback){
  	this.OnReturnToIVRInfoFunc = callback;
  }
  
  //请求转回到IVR确认回调函数
  ghToolbar.prototype.OnRequestToIVR = function(callback){
  	this.OnRequestToIVRFunc = callback;
  }
  
  //咨询接通事件回调函数
  ghToolbar.prototype.OnConsultConnected = function(callback){
  	this.OnConsultConnectedFunc = callback;
  }
  
  //取消咨询结果回调函数
  ghToolbar.prototype.OnCancelConsult = function(callback){
  	this.OnCancelConsultFunc = callback;
  }
  
  //咨询转三方结果回调函数
  ghToolbar.prototype.OnAgentThirdParty = function(callback){
  	this.OnAgentThirdPartyFunc = callback;
  }
  
  //从三方中移除结果回调函数
  ghToolbar.prototype.OnAgentRemoveMemberFromThirdParty = function(callback){
  	this.OnAgentRemoveMemberFromThirdPartyFunc = callback;
  }
  
  //随路数据
  ghToolbar.prototype.OnRecvAssociateData = function(callback){
  	this.OnRecvAssociateDataFunc = callback;
  }
  
 	//分机注册消息
  ghToolbar.prototype.OnTelephoneRegister = function(callback){
  	this.OnTelephoneRegisterFunc = callback;
  }
  
  //分机注销消息
  ghToolbar.prototype.OnTelephoneUnRegister = function(callback){
  	this.OnTelephoneUnRegisterFunc = callback;
  }
  
 	//评价消息
  ghToolbar.prototype.OnEvaluationButton = function(callback){
  	this.OnEvaluationButtonFunc = callback;
  }
  
  //-----------------班长功能回调-----------------------------------
  //强拆消息
  ghToolbar.prototype.OnForceRelease = function(callback){
  	this.OnForceReleaseFunc = callback;	
  }
  //通知坐席被强拆
  ghToolbar.prototype.OnNotifyAgentForcedRelease = function(callback){
  	this.OnNotifyAgentForcedReleaseFunc = callback;	
  }
  
  //强插消息
  ghToolbar.prototype.OnForceJoin = function(callback){
  	this.OnForceJoinFunc = callback;	
  }
  //通知坐席被强插
	ghToolbar.prototype.OnNotifyAgentForcedJoin = function(callback){
		this.OnNotifyAgentForceJoinFunc = callback;
	}
	
  //拦截消息
  ghToolbar.prototype.OnHiJack = function(callback){
  	this.OnHiJackFunc = callback;	
  }
  //通知坐席被拦截
	ghToolbar.prototype.OnNotifyAgentHiJack = function(callback){
		this.OnNotifyAgentHiJackFunc = callback;
	}
  
  //强置状态
  ghToolbar.prototype.OnForceState = function(callback){
  	this.OnForceStateFunc = callback;
  }
  //通知坐席被强置
  ghToolbar.prototype.OnNotifyAgentForcedState = function(callback){
  	this.OnNotifyAgentForcedStateFunc = callback;	
  }
  
  //监听回调
	ghToolbar.prototype.OnStartListenChannel = function(callback){
		this.OnStartListenChannelFunc = callback;
	}
	//停止监听回调
	ghToolbar.prototype.OnStopListenChannel = function(callback){
		this.OnStopListenChannelFunc = callback;	
	}
	  
  return ghToolbar;
})();
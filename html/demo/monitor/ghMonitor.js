window.ghMonitor = (function(){
	if (typeof(String.prototype.trim) === "undefined") {
		String.prototype.trim = function() {
			return String(this).replace(/^\s+|\s+$/g, '');
		}
	}
	
	//构造函数
	function ghMonitor(){
		var self = this;
		this.sock = new ghWS();
		this.socketConnected = false;
		this.the_send_heartbeat_timeout = null;
		this.clientIp = "127.0.0.1";
		this.heartbeat_timestamp = 0;
		
		this.onAgentStateFunc = null;									//onAgentState event callback handle
		this.onTalkStateFunc = null;									//onTalkState event callback handle
		this.onConnectToMonitorServerFunc = null;			//onConnectToMonitorServer event callback handle
		this.onRegToMonitorServerFunc = null;					//onRegToMonitorServer event callback handle
		this.onDisConnectToMonitorServerFunc = null;	//onDisConnectToMonitorServer event callback handle
		this.onGetAllAgentIDFunc = null;							//onGetAllAgentID event callback handle
		this.onGroupQueueChangedFunc = null;					//onGroupQueueChanged event callback handle
		
		//socket已连接
		this.sock.openCallback(function() {
			self.socketConnected = true;
			self.heartbeat_timestamp = new Date().getTime();
			self.the_send_heartbeat_timeout = setInterval( function() {
      	//alert( "heartbeat" );
      	self.sendHeartBeat();
      }, 5000 ); 
			if( self.onConnectToMonitorServerFunc != null ){
				self.onConnectToMonitorServerFunc();
			}
    });
    //socket已关闭
		this.sock.closeCallback(function() {
				clearInterval( self.the_send_heartbeat_timeout );
				self.socketConnected = false;
				if( self.onDisConnectToMonitorServerFunc != null ){
					self.onDisConnectToMonitorServerFunc();
				}
    });
    //socket错误
		this.sock.errorCallback(function( ) {
    });
    //socket接收消息
		this.sock.recvCallback(function( msg ) {
			if( msg == null || msg.length <= 0 )		return;
			var arr = msg.split( "\r\n" );
			var data = new Array();
			var eventName = "";
			for( var i=0; i<arr.length; i++ ){
				if( arr[i].trim() != "" ){
					var arr_item = arr[i].split(":");
					if( arr_item.length > 1 ){
						var name = arr_item[0].trim();
						var value = arr_item[1].trim();
						if( name == "Event" ){
							eventName = value;
						}
						else{
							data[name] = value;
						}
					}
				}
			}
			switch( eventName ){
			case "ClientRegToMonitorConf":		//注册返回事件
				if( self.onRegToMonitorServerFunc != null ){
					if( data["ClientIP"] && data["ClientIP"] != "" ){
						self.onRegToMonitorServerFunc( true, 0 );
					}
					else{
						self.onRegToMonitorServerFunc( false, 1 );
					}
				}
				break;
			case "AgentRealTimeState":				//坐席状态事件
				if( self.onAgentStateFunc != null ){
					self.onAgentStateFunc( data["AgentID"], data["AgentExt"], data["AgentName"], data["AgentState"], data["StateTime"], data["GroupID"] );
				}
				break;
			case "AllAgentID":		//在线坐席信息
				if( self.onGetAllAgentIDFunc != null ){
					self.onGetAllAgentIDFunc( data["NumOfAgents"], data["AgentList"] );
				}
				break;
			case "TalkRealTimeState":		//通话状态事件
				if( self.onTalkStateFunc != null ){
					self.onTalkStateFunc( data["AgentID"], data["AgentExt"], data["TalkState"], data["RemoteNum"], data["ThirdParty"] );
				}
				break;
			case "GroupQueueChanged":		//组排队信息变化事件
				if( self.onGroupQueueChangedFunc != null ){
					self.onGroupQueueChangedFunc( data["QueueCount"], data["GroupID"], data["CallerList"] );
				}
				break;
			case "ClientHeartBeatToMonitorConf": 	//心跳
				self.heartbeat_timestamp = new Date().getTime();
				break;
			}
    });		
  }
  
  ghMonitor.prototype.sendHeartBeat = function(){
  	if( this.socketConnected ){
  		var sendMsg = "Event:ClientHeartBeatToMonitor\r\n" + "ClientIP:" + this.clientIp  + "\r\n";
  		this.sock.sendMsg( sendMsg );
  		
  		if( ( new Date().getTime() - this.heartbeat_timestamp ) / 1000 > 10 ){
  			this.DisConnectToMonitorServer();
  		}
  	}
  }
  
  //连接服务器
  ghMonitor.prototype.ConnectToMonitorServer = function( serverIp, serverPort ){
  	if( ! this.socketConnected )	this.sock.initSock( serverIp, serverPort );
  };
  
  //断开服务器连接
  ghMonitor.prototype.DisConnectToMonitorServer = function(){
  	if( this.socketConnected )	this.sock.closeSock();
  };
  
  //注册到服务器
  ghMonitor.prototype.RegToMonitorServer = function(){
  	if( this.socketConnected ){
  		var sendMsg = "Event:ClientRegToMonitor\r\n" + "ClientIP:" + this.clientIp  +"\r\n";
  		this.sock.sendMsg( sendMsg );
  		return true;
  	}
  	else{
  		return false;
  	}
  };
  
  //得到所有坐席信息
  ghMonitor.prototype.GetAllAgentID = function( serverIp ){
  	if( this.socketConnected ){
  		var sendMsg = "Event:GetAllAgentID\r\nACDIP:" + serverIp + "\r\n";
  		this.sock.sendMsg( sendMsg );
  		return true;
  	}
  	else{
  		return false;
  	}
  };
  
  //得到指定坐席的坐席状态
  ghMonitor.prototype.ChkAgentState = function( serverIp, AgentId ){
  	if( this.socketConnected ){
  		var sendMsg = "Event:SubscribeAgentState\r\nACDIP:" + serverIp + "\r\nAgentID:" + AgentId + "\r\n";
  		this.sock.sendMsg( sendMsg );
  		return true;
  	}
  	else{
  		return false;
  	}
  };
  
  //得到指定坐席的通话状态
  ghMonitor.prototype.ChkAgentTalkState = function( serverIp, AgentId ){
  	if( this.socketConnected ){
  		var sendMsg = "Event:SubscribeTalkState\r\nACDIP:" + serverIp + "\r\nAgentExt:" + AgentId + "\r\n";
  		this.sock.sendMsg( sendMsg );
  		return true;
  	}
  	else{
  		return false;
  	}
  };
  
  //获取坐席状态回调函数
  ghMonitor.prototype.agentStateCallback = function(callback){
  	this.onAgentStateFunc = callback;
  }
  
  //获取通话状态回调函数
  ghMonitor.prototype.talkStateCallback = function(callback){
  	this.onTalkStateFunc = callback;
  }
  
  //连接服务器回调函数
  ghMonitor.prototype.connectServerCallback = function(callback){
  	this.onConnectToMonitorServerFunc = callback;
  }
  
  //注册服务器回调函数
  ghMonitor.prototype.regServerCallback = function(callback){
  	this.onRegToMonitorServerFunc = callback;
  }
  
  //断开服务器回调函数
  ghMonitor.prototype.disconnectServerCallback = function(callback){
  	this.onDisConnectToMonitorServerFunc = callback;
  }
  
  //获取在线坐席信息回调函数
  ghMonitor.prototype.getAllAgentInfoCallback = function(callback){
  	this.onGetAllAgentIDFunc = callback;
  }
  
  //组排队信息变化回调函数
  ghMonitor.prototype.groupQueueChangedCallback = function(callback){
  	this.onGroupQueueChangedFunc = callback;
  }

	return ghMonitor;
})();
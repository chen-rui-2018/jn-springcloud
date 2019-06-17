(function() {
	var websocket = null;					//socket handle
	var heartbeat_timestamp = null;
	var lastSendHeartBeatTime = 0;
	var the_send_heartbeat_timeout = null;
	
  var initSock = function( serverIp, serverPort ){
    var self = this;
		var wsUri = "ws://" + serverIp + ":" + serverPort + "/";
    this.websocket = new WebSocket(wsUri); 

    //连接事件
    this.websocket.onopen = function(evt) { 
			postMessage({
      	type: 'open',
      	msg: ''
   	 	});
    };
    //关闭事件
    this.websocket.onclose = function(evt) {
			postMessage({
      	type: 'close',
      	msg: ''
   	 	});
   	 	stopHeartBeat();
   	 	self.websocket = null;
    };
    //接收消息事件
    this.websocket.onmessage = function(evt) { 
    	self.heartbeat_timestamp = new Date().getTime();
			postMessage({
      	type: 'recv',
      	msg: evt.data
   	 	});
    };
    //错误消息事件
    this.websocket.onerror = function(evt) { 
			postMessage({
      	type: 'error',
      	msg: 'connecterror2'
   	 	});
    };
  };
  
  var startHeartBeat = function( agentId ){
  	this.heartbeat_timestamp = new Date().getTime();
		this.lastSendHeartBeatTime = 0;
		this.the_send_heartbeat_timeout = setInterval( function() {
			var nowDate = new Date().getTime();						
			if( ( nowDate - this.heartbeat_timestamp ) / 1000 > 20 ){
  			this.websocket.close(); 
  		}				
			if( this.lastSendHeartBeatTime > 0 ){
				if( (nowDate - this.lastSendHeartBeatTime ) / 1000 < 4 ){
					return;
				}
			}
			if( this.websocket != null ){
				var sendMsg = "Event:AgentHeartBeat\r\n" + "AgentID:" + agentId  + "\r\n";
				this.websocket.send( sendMsg ); 
			}
			this.lastSendHeartBeatTime = nowDate;
  	}, 1000 );
  };
  
  var stopHeartBeat = function(){
  	if( the_send_heartbeat_timeout != null ){
  		clearInterval( this.the_send_heartbeat_timeout );
  		this.the_send_heartbeat_timeout = null;
  	}
  }
	//子线程用来接收主线程的message
  onmessage = function(event) {
  	switch( event.data.type ){
  	case "init":
  		initSock( event.data.param1, event.data.param2 );
  		break;
  	case "send":
  		if( this.websocket != null ){
  			this.websocket.send( event.data.param1 ); 
  		}
  		break;
  	case "close":
  		if( this.websocket != null ){
  			this.websocket.close(); 
  		}
  		break;
  	case "start_beat":
  		startHeartBeat( event.data.param1 );
  		break;
  	case "stop_beat":
  		stopHeartBeat();
  		break;
  	}
  };

})();

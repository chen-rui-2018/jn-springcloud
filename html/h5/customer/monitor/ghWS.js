window.ghWS = (function(){
	//构造函数
	function ghWS(){
		this.websocket = null;					//socket handle
		this.socketOpenFunc = null;			//socket open callback handle;
		this.socketCloseFunc = null;		//socket close callback handle;
		this.socketRecvFunc = null;			//socket message callback handle;
		this.socketErrorFunc = null;		//socket error callback handle;
  }
  
  //初始化websocket
	ghWS.prototype.initSock = function( serverIp, serverPort ){
		var self = this;
		var wsUri = "wss://" + serverIp + ":" + serverPort + "/";
    this.websocket = new WebSocket(wsUri); 
    //连接事件
    this.websocket.onopen = function(evt) { 
			if( self.socketOpenFunc ){
				self.socketOpenFunc();
			}
    };
    //关闭事件
    this.websocket.onclose = function(evt) { 
      if( self.socketCloseFunc ){
				self.socketCloseFunc();
			}
    };
    //接收消息事件
    this.websocket.onmessage = function(evt) { 
      if( self.socketRecvFunc ){
				self.socketRecvFunc( evt.data );
			}
    };
    //错误消息事件
    this.websocket.onerror = function(evt) { 
      if( self.socketErrorFunc ){
				self.socketErrorFunc();
			} 
    }; 
  };
  
  ghWS.prototype.sendMsg = function( msg ){
			this.websocket.send( msg ); 
  };
  
  ghWS.prototype.closeSock = function(){
			this.websocket.close(); 
  };
  
  ghWS.prototype.openCallback = function(callback){
  	this.socketOpenFunc = callback;
  }
  
  ghWS.prototype.closeCallback = function(callback){
  	this.socketCloseFunc = callback;
  }

  ghWS.prototype.errorCallback = function(callback){
  	this.socketErrorFunc = callback;
  }

  ghWS.prototype.recvCallback = function(callback){
  	this.socketRecvFunc = callback;
  }
  
  return ghWS;
})();
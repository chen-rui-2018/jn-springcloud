window.ghAgent = (function(){
	if (typeof(String.prototype.trim) === "undefined") {
		String.prototype.trim = function() {
			return String(this).replace(/^\s+|\s+$/g, '');
		}
	}	
	
	function uuid(len, radix) {
    var chars = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz'.split('');
    var uuid = [], i;
    radix = radix || chars.length;
    if (len) {
      for (i = 0; i < len; i++) uuid[i] = chars[0 | Math.random()*radix];
    } else {
      var r;
      uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
      uuid[14] = '4';
      for (i = 0; i < 36; i++) {
        if (!uuid[i]) {
          r = 0 | Math.random()*16;
          uuid[i] = chars[(i == 19) ? (r & 0x3) | 0x8 : r];
        }
      }
    }
    return uuid.join('');
	}
	
	function createappid(){
		var b = new Date(); 
		var year = b.getFullYear();
   	var month = b.getMonth() + 1;
   	if (month < 10){
   		month = '0' + month;
   	} 
   	var day = b.getDate();
   	if (day < 10){
   		day = '0' + day;
   	}
   	var hour = b.getHours(); 
   	if( hour < 10 ){
   		hour = "0" + hour;
   	}
   	var mins = b.getMinutes();
   	if( mins < 10 ){
   		mins = "0" + mins;
   	}
   	var sec = b.getSeconds();
   	if( sec < 10 ){
   		sec = "0" + sec;
   	}

   	return "" + year + month + day + hour + mins + sec + uuid( 8, 10 );  	
	}
	
	//���캯��
	function ghAgent( home_url){
		var self = this;
		if(typeof(Worker)!="undefined"){
		}
		else{
			alert( "浏览器不支持此模式！" );
		}
		this.worker = new Worker( home_url + 'ghWS.js' );
		this.RECworker = new Worker( home_url + 'ghWS.js');
		this.socketConnected = false;
		this.RECsocketConnected = false;
		this.connectError = false;
		
		this.agentId = "";
		this.agentName = "";
		this.agentExt = "";
		this.agentGroupId = "";
		this.agentLevel = 0;
		this.agentRight = 0;
		this.agentLoginFlag = false;
		this.agentState = 0;
		this.lineState = 7;
		this.caller = "";
		this.called = "";
		this.callid = "";
		this.appid = "";
		this.trunkFlag = 0;
		this.iRECIP = "";
		this.iRECPort = 3333;
		this.QueryAgentID = "";
		this.QueryAgentExt = "";
		this.finalc =[];

		this.agentLoginTimer = null;
		this.agentDialTimer = null;
		this.agentStateTimer = null;
		
		//�ص���������
		this.onAgentConnectToACDFunc = null;									//onAgentConnectToACD event callback handle
		this.onAgentDisConnectToACDFunc = null;								//onAgentDisConnectToACD event callback handle
		this.onAgentLoginFunc = null;													//onAgentLogin event callback handle
		this.onLoginByCompanyUIDFunc = null;									//onLoginByCompanyUID event callback handle
		this.onAgentLogoutFunc = null;												//onAgentLogout event callback handle
		this.onAgentStateChangedFunc = null;									//onAgentStateChanged event callback handle
		this.onAgentDialConfFunc = null;											//onAgentDialConf event callback handle
		this.onTelephoneRingFunc = null;											//onTelephoneRing event callback handle
		this.onAnswerConnectedFunc = null;										//onAnswerConnected event callback handle
		this.onDialConnectedFunc = null;											//onDialConnected event callback handle
		this.onReturnToIVRInfoFunc = null;										//onReturnToIVRInfo event callback handle
		this.onYARecPathFunc = null;													//onYARecPath event callback handle
		this.onTelephoneHangupInHoldFunc = null;							//onTelephoneHangupInHold event callback handle
		this.onTelephoneHangupFunc = null;										//onTelephoneHangup event callback handle
		this.onQueuingNumberChangedFunc = null;								//onQueuingNumberChange event callback handle
		this.onGetGroupListFunc = null;												//onGetGroupList event callback handle
		this.onGetIdleAgentListFunc = null;										//onGetIdleAgentList event callback handle
		this.onGetTalkAgentListFunc = null;										//onGetTalkAgentList event callback handle
		this.onGetAgentListFromGroupFunc = null;							//onGetAgentListFromGroup event callback handle
		this.onGetAgentStateCountFromGroupFunc = null;				//onGetAgentStateCountFromGroup event callback handle
		this.onGetCallIDFunc = null;													//onGetCallID event callback handle
		this.onRequestToIVRFunc = null;												//onRequestToIVR event callback handle
		this.onConsultConnectedFunc = null;										//onConsultConnected event callback handle
		this.onCancelConsultFunc = null;											//onCancelConsult event callback handle
		this.onAgentThirdPartyFunc = null;										//onAgentThirdParty event callback handle
		this.onAgentRemoveMemberFromThirdPartyFunc = null;		//onAgentRemoveMemberFromThirdParty event callback handle
		this.onRecvAssociateDataFunc = null;									//onRecvAssociateData event callback handle
		this.onTelephoneRegisterFunc = null;									//onTelephoneRegister event callback handle
		this.onTelephoneUnRegisterFunc = null;								//onTelephoneUnRegister event callback handle
		this.onForceHangupFunc = null;
		this.onForceJoinFunc = null;
		this.onHijackFunc = null;
		this.onForceStateFunc = null;
		
		this.onStartListenChannelFunc = null;
		this.onStopListenChannelFunc = null;
		this.onAgentConnectToRECFunc = null;
		this.wavbuffer = new Array();


		this.worker.onmessage = function(event) {
			switch( event.data.type ){
			case 'open':		//socket������
				self.socketConnected = true;
				self.connectError = false;
				self.caller = "";
				self.called = "";
				self.callid = "";
				self.appid = "";
				if( self.onAgentConnectToACDFunc != null )	self.onAgentConnectToACDFunc( 1 );
				break;
			case 'close':		//socket�ѹر�
				if( self.socketConnected == true ){
					if( self.onAgentDisConnectToACDFunc != null ){
						self.onAgentDisConnectToACDFunc( true, 1 );
					}
				}
				//self.socketConnected = false;
				self.agentId = "";
				self.agentName = "";
				self.agentExt = "";
				self.agentGroupId = "";
				self.agentLevel = 0;
				self.agentRight = 0;
				break;
			case 'error':		//socket����
				self.connectError = true;
				if( self.onAgentConnectToACDFunc != null )	self.onAgentConnectToACDFunc( -1 );
				break;
			case 'recv':		//socket������Ϣ
				var msg = event.data.msg;
				if( msg == null || msg.length <= 0 )		break;
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
				case "AgentLoginConf":		//��ϯ��½����
					clearTimeout( self.agentLoginTimer );
					if( data["LoginResult"] && parseInt(data["LoginResult"]) ){
						self.postMessage( "start_beat", self.agentId, null );
		      	self.agentLoginFlag = true;
						if( self.onAgentLoginFunc != null )		self.onAgentLoginFunc( true, parseInt(data["FailedReason"]) );
					}
					else{
						if( self.onAgentLoginFunc != null )		self.onAgentLoginFunc( false, parseInt(data["FailedReason"]) );
						self.DisConnectToACD();
					}
					break;
				case "AgentLoginByCompanyUIDConf":	//��ҵ��ϯ��½����
					clearTimeout( self.agentLoginTimer );
					if( data["LoginResult"] && parseInt(data["LoginResult"]) ){
						self.postMessage( "start_beat", self.agentId, null );
		      	self.agentLoginFlag = true;
						if( self.onLoginByCompanyUIDFunc != null )		self.onLoginByCompanyUIDFunc( true, parseInt(data["FailedReason"]) );
					}
					else{
						if( self.onLoginByCompanyUIDFunc != null )		self.onLoginByCompanyUIDFunc( false, parseInt(data["FailedReason"]) );
						self.DisConnectToACD();
					}
					break;
				case "AgentLogoutConf":		//��ϯ�ǳ�
					self.agentId = "";
					self.agentName = "";
					self.agentExt = "";
					self.agentGroupId = "";
					self.agentLevel = 0;
					self.agentRight = 0;
					break;
				case "AgentHeartBeatConf": 	//����
					break;
				case "AgentStateChanged":		//��ϯ״̬�ı�
					self.agentState = parseInt(data["AgentState"]);
					if( self.onAgentStateChangedFunc != null )		self.onAgentStateChangedFunc( parseInt(data["AgentState"]) );
					break;
				case "AgentLineStateChanged":	//��ϯ��·״̬�ı�
					self.lineState = parseInt(data["LineState"]);
					if( self.onLineStateChangedFunc != null )		self.onLineStateChangedFunc( parseInt(data["LineState"]) );
					break;
				case "AgentDialConf":		//�Ⲧ��Ӧ
					clearTimeout( self.agentDialTimer );
					if( parseInt(data["Result"]) ){
						self.callid = data["CallID"];
						self.trunkFlag = data["DialType"];
						if( self.onAgentDialConfFunc != null )		self.onAgentDialConfFunc( true );
					}
					else{
						if( self.onAgentDialConfFunc != null )		self.onAgentDialConfFunc( false );
					}
					break;
				case "AgentIncomingCall":		//��������
					if( data["RemoteNumber"].trim() == self.agentExt.trim() || self.lineState == 16 ){
					}
					else{
						if( self.agentState==2 || self.agentState==3 || self.agentState==6 || self.agentState==8 ){
							self.callid = data["CallID"].trim();
							self.caller = data["RemoteNumber"].trim();
							self.called = self.agentExt.trim();
						}
						if( self.onTelephoneRingFunc!= null )		self.onTelephoneRingFunc( data["RemoteNumber"].trim(), data["CallID"].trim(), self.agentExt.trim() );
					}
					break;
				case "AgentIncomingConnected":		//�����ͨ
					self.callid = data["CallID"].trim();
					self.caller = data["RemoteNumber"].trim();
					self.called = self.agentExt.trim();				
					self.SetRecordAppID( createappid() );
					if( self.onAnswerConnectedFunc != null )		self.onAnswerConnectedFunc();
					break;
				case "AgentOutgoingConnected":		//�Ⲧ��ͨ
					self.callid = data["CallID"].trim();
					self.called = data["RemoteNumber"].trim();
					self.caller = self.agentExt.trim();				
					self.SetRecordAppID( createappid() );				
					if( self.onDialConnectedFunc != null )		self.onDialConnectedFunc();
					break;
				case "AgentCallDisconnected":		//�绰�Ҷ�				
					if( self.lineState == 4 ){
						if( self.onTelephoneHangupInHoldFunc != null )		self.onTelephoneHangupInHoldFunc();
					}
					if( self.onTelephoneHangupFunc != null )		self.onTelephoneHangupFunc( data["RemoteNumber"].trim() );
					self.caller = "";
					self.called = "";
					self.callid = "";
					self.appid = "";
					break;
				case "AgentGetReturnIVRInfoConf":		//ת��IVR��Ϣ
					if( self.onReturnToIVRInfoFunc != null ){
						self.onReturnToIVRInfoFunc( true, data["ID"].trim(), data["ReturnNodeDes"].trim(), data["FlowFileName"].trim(), data["NodeID"].trim() );
					}
					break;
				case "YARecPath":			//¼���ļ������
					var recpath = "D:\\RecordWav\\" + data["RecPath"].trim().replace(/\//g, "\\");
					if( self.onYARecPathFunc != null )		self.onYARecPathFunc( recpath );
					break;
				case "AgentGetNumberOfQueueingInGroupConf":
					if( self.onQueuingNumberChangedFunc != null )		self.onQueuingNumberChangedFunc( true, data["Count"].trim(), data["CallerList"].trim() );
					break;
				case "AgentGetGroupListConf":	//��ϯ��ID�б�
					if( self.onGetGroupListFunc != null )		self.onGetGroupListFunc( true, data["GroupList"].trim() );
					break;
				case "AgentGetIdleAgentListOfGroupConf":	//������ϯ�б�
					if( self.onGetIdleAgentListFunc != null ) 	self.onGetIdleAgentListFunc( true, data["AgentList"].trim(), data["AgentNameList"].trim(), data["AgentExtList"].trim() );
					break;
				case "AgentGetTalkAgentListOfGroupConf":	//ͨ����ϯ�б�
					if( self.onGetTalkAgentListFunc != null ) 	self.onGetTalkAgentListFunc( true, data["TalkAgentList"].trim(), data["TalkAgentExtList"].trim() );
					break;
				case "AgentGetAgentListFromGroupConf":		//������ϯ�б�
					if( self.onGetAgentListFromGroupFunc != null ) 	self.onGetAgentListFromGroupFunc( true, data["GroupID"].trim(), data["AgentList"].trim(), data["AgentNameList"].trim(), data["AgentExtList"].trim(), data["AgentStateList"].trim() );
					break;
				case "AgentGetAgentStateCountFromGroupConf":		//������ϯ״̬����
					if( self.onGetAgentStateCountFromGroupFunc != null )	self.onGetAgentStateCountFromGroupFunc( true, data["GroupID"].trim(), data["AgentState"].trim(), data["Count"].trim() );
					break;
				case "AgentGetCallIDConf":		//CALLID
					if( self.onGetCallIDFunc != null )					self.onGetCallIDFunc( true, data["CallID"].trim() );
					break;
				case "AgentReturnIVRConf":	//���󷵻�IVRȷ��		
					if( self.onRequestToIVRFunc != null )				self.onRequestToIVRFunc( data["Result"].trim(), data["IVRSoftphone"].trim(), data["Type"].trim() );
					break;
				case "AgentConsultConenctedConf":		//��ѯ��ͨ�¼�
					if( self.onConsultConnectedFunc != null )		self.onConsultConnectedFunc( true, data["Called"].trim() );
					break;
				case "AgentConsultConenctedConf":		//ȡ����ѯ���	
					if( self.onCancelConsultFunc != null )			self.onCancelConsultFunc( data["Result"].trim() );
					break;
				case "AgentThreePartyConf":		//��ѯת����
					if( self.onAgentThirdPartyFunc != null )			self.onAgentThirdPartyFunc( data["Result"].trim(), data["ConfID"].trim() );
					break;
				case "AgentRemoveFromThirdPartyConf":		//�������Ƴ���
					if( self.onAgentRemoveMemberFromThirdPartyFunc != null )			self.onAgentRemoveMemberFromThirdPartyFunc( true, data["RemovePraty"].trim() );
					break;	
				case "AgentAssociateData":		//��·���	
					if( self.onRecvAssociateDataFunc != null )			self.onRecvAssociateDataFunc( data["SourceType"].trim(), data["Source"].trim(), data["Content"].trim() );
					break;
				case "AgentTelehoneRegisted":		//�ֻ�ע���¼�
					if( self.onTelephoneRegisterFunc != null )			self.onTelephoneRegisterFunc( data["AgentID"].trim(), data["AgentExt"].trim() );
					break;
				case "AgentTelehoneUnRegisted":		//�ֻ�ע���¼�	
					if( self.onTelephoneUnRegisterFunc != null )			self.onTelephoneUnRegisterFunc( data["AgentID"].trim(), data["AgentExt"].trim() );
					break;
				case "MonitorAgentForceHangupConf"://强拆坐席
					if(	self.onForceHangupFunc != null) 				self.onForceHangupFunc(data["Result"].trim());
					break;
				case "MonitorAgentForceJoinConf"://强插坐席
					if(	self.onForceJoinFunc != null) 				self.onForceJoinFunc(data["Result"].trim());
					break;
				case "MonitorAgentHijackConf"://拦截坐席
					if(	self.onHijackFunc != null) 				self.onHijackFunc(data["Result"].trim());
					break;	
				case "MonitorAgentForceStateConf"://强置状态
					if(self.onForceStateFunc != null) self.onForceStateFunc(data["MonitorAgentID"].trim(),data["AgentID"].trim(),data["Result"].trim());
					break;
				case "AgentQueryAgentInfoConf":  //监听状态
			  	self.QueryAgentID = data["QueryAgentID"].trim();
			  	self.QueryAgentExt = data["AgentExt"].trim();
			  	if(self.iRECIP == null || self.iRECIP.trim() == "")
			  	{
			  		if(data["RECIP"] == null ||data["RECIP"].trim() == "")
			  		{
			  			alert("请手动设置RECIP地址");  //由于坐席首次登陆，ACD中没法返回RECIP，解决：1.修改ACD，提前获取RECIP 2.手动设置IP 3.被监听坐席拨打过电话就能获取到IP
			  			break;
			  		}
			  		else 
			  		self.iRECIP = data["RECIP"].trim();
			  	}		  
			  //	self.iRECPort = parseInt(data["RECPort"]);
			  	self.RecServerConnection(self.iRECIP,self.iRECPort);
			  //	if(self.onStartListenChannelFunc != null) self.onStartListenChannelFunc(data["AgentExt"].trim(),data["Result"].trim()); 
				}
				break;
			}
  	};		
  	this.RECworker.onmessage = function(event) {
	  	switch( event.data.type ){
			case 'open':
				self.RECsocketConnected = true;
				self.RecMonitorCallStart();
				if(self.onStartListenChannelFunc != null) self.onStartListenChannelFunc(self.QueryAgentExt,1); 
				break;
			case 'close':		
				self.iRECIP = "";
				self.iRECPort = 3333;
				self.QueryAgentID = "";
				self.QueryAgentExt = "";

				break;
			case 'error':		
				break;
			case 'recv':		
				var msg = event.data.msg;
				if( msg == null || msg.length <= 0 )		break;
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
				case "WaitCallConf":
					self.addlog("您监听的号码："+data["strExtNum"].trim()+"没有通话，继续等待或者结束监听");
					break;
				case "MonitoredCallAudio":
					if(self.wavbuffer.length > 100 )
					break;
				  var audiosrc = self.str2Byte(data["AudioMixed"]);
					self.wavbuffer.unshift(audiosrc);
				//	self.addlog("recv:"+self.wavbuffer.length);
					if(self.wavbuffer.length < 60){
						break;
					}	
					else	{
							var finalc = [];
							while(self.wavbuffer.length > 0 )
  						{
  								finalc = finalc.concat(self.wavbuffer.pop())
  						}
							var wave = new RIFFWAVE(finalc);
							var audio = document.getElementById("mySound");
							self.releaseUrl(audio.src);
							audio.src = wave.dataURI;
							audio.play();
							finalc = [];
						}
					break;
				case "MonitoredCallEnd":
					//self.StopListenChannel();
					alert("监听的坐席已经断开通话");		
				}
				break;
			}
	  };//end of RECworker
	
	 	var FastBase64 = {
    chars: "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",
    encLookup: [],

    Init: function() {
        for (var i=0; i<4096; i++) {
            this.encLookup[i] = this.chars[i >> 6] + this.chars[i & 0x3F];
        }
    },

    Encode: function(src) {
        var len = src.length;
        var dst = '';
        var i = 0;
        while (len > 2) {
            n = (src[i] << 16) | (src[i+1]<<8) | src[i+2];
            dst+= this.encLookup[n >> 12] + this.encLookup[n & 0xFFF];
            len-= 3;
            i+= 3;
        }
        if (len > 0) {
            var n1= (src[i] & 0xFC) >> 2;
            var n2= (src[i] & 0x03) << 4;
            if (len > 1) n2 |= (src[++i] & 0xF0) >> 4;
            dst+= this.chars[n1];
            dst+= this.chars[n2];
            if (len == 2) {
                var n3= (src[i++] & 0x0F) << 2;
                n3 |= (src[i] & 0xC0) >> 6;
                dst+= this.chars[n3];
            }
            if (len == 1) dst+= '=';
            dst+= '=';
        }
        return dst;
    } // end Encode
		};
		FastBase64.Init();
		var RIFFWAVE = function(data){
		this.data = [];
		this.wav = [];
		this.dataURI = '';	
			
	  this.header = {                         // OFFS SIZE NOTES
			  chunkId      : [0x52,0x49,0x46,0x46], // 0    4    "RIFF" = 0x52494646
			  chunkSize    : 0,                     // 4    4    36+SubChunk2Size = 4+(8+SubChunk1Size)+(8+SubChunk2Size)
			  format       : [0x57,0x41,0x56,0x45], // 8    4    "WAVE" = 0x57415645
			  subChunk1Id  : [0x66,0x6d,0x74,0x20], // 12   4    "fmt " = 0x666d7420
			  subChunk1Size: 16,                    // 16   4    16 for PCM
			  audioFormat  : 1,                     // 20   2    PCM = 1
			  numChannels  : 1,                     // 22   2    Mono = 1, Stereo = 2...
			  sampleRate   : 8000,                  // 24   4    8000, 44100...
			  byteRate     : 16000,                 // 28   4    SampleRate*NumChannels*BitsPerSample/8
			  blockAlign   : 2,                     // 32   2    NumChannels*BitsPerSample/8
			  bitsPerSample: 16,                     // 34   2    8 bits = 8, 16 bits = 16
			  subChunk2Id  : [0x64,0x61,0x74,0x61], // 36   4    "data" = 0x64617461
			  subChunk2Size: 0                      // 40   4    data size = NumSamples*NumChannels*BitsPerSample/8
		};
		function u32ToArray(i){
			return [i&0xFF,(i>>8)&0xFF,(i>>16)&0xFF,(i>>24)&0xFF];	
		}
		
		function u16ToArray(i){
			return [i&0xFF,(i>>8)&0xFF];	
		}
		
		function split16bitArray(data) {
			var r = [];
			var j = 0;
			var len = data.length;
			for(var i=0;i<len;i++){
				r[j++] = data[i] &0xFF;
				r[j++] =(data[i]>>8) &0xFF;	
			}	
			return r;
		}

	  this.Make = function(data) {
  			if (data instanceof Array)  this.data = data;
  			
  			this.header.blockAlign = (this.header.numChannels * this.header.bitsPerSample) >> 3;
  			this.header.byteRate = this.header.blockAlign * this.sampleRate;
  			this.header.subChunk2Size = this.data.length * (this.header.bitsPerSample >> 3);
  			this.header.chunkSize = 36 + this.header.subChunk2Size;	
  			this.wav = this.header.chunkId.concat(
  			    u32ToArray(this.header.chunkSize),
  			    this.header.format,
  			    this.header.subChunk1Id,
  			    u32ToArray(this.header.subChunk1Size),
  			    u16ToArray(this.header.audioFormat),
  			    u16ToArray(this.header.numChannels),
  			    u32ToArray(this.header.sampleRate),
  			    u32ToArray(this.header.byteRate),
  			    u16ToArray(this.header.blockAlign),
  			    u16ToArray(this.header.bitsPerSample),    
  			    this.header.subChunk2Id,
  			    u32ToArray(this.header.subChunk2Size),
  			    this.data
  			    //split16bitArray(this.data)
  			  //  (this.header.bitsPerSample == 16) ? split16bitArray(this.data) : this.data
   	 );
   //	 self.addlog(this.wav);
    this.dataURI = 'data:audio/wav;base64,'+FastBase64.Encode(this.wav);
		};
	
			if (data instanceof Array) this.Make(data);
		};//end of RIFFWAVE

}   //end of ghAgent

	
		
	 ghAgent.prototype.str2Byte = function(str)
	 {
 		 var pos = 0;
 		 var len = str.length;
		  if (len % 2 != 0)
		  {
 			   return null;
		  }
 		 len /= 2;
		 // var buffer = new ArrayBuffer(320);
		 // var hexA = new Uint16Array(buffer);
 			var hexA = new Array();
		  for (var i = 0; i < len; i++)
		  {
 		   var s = str.substr(pos, 2);
	     var v = parseInt(s, 16);
  		 // hexA.push(v);
  	   hexA[i] = v ;
  	   pos += 2;
		  }
		 return hexA;
	 }
		
	 ghAgent.prototype.releaseUrl = function(urll){
	 	urll && window.URL && window.URL.revokeObjectURL && window.URL.revokeObjectURL(urll)	
	 };
	 ghAgent.prototype.RECpostMessage = function(type,param1,param2){
	 	var msg = {
  		'type' : type,
  		'param1' : param1,
  		'param2' : param2
  	};
  	this.RECworker.postMessage( msg );
	 };
	//������Ϣ
  ghAgent.prototype.postMessage = function( type, param1, param2 ){
  	var msg = {
  		'type' : type,
  		'param1' : param1,
  		'param2' : param2
  	};
  	this.worker.postMessage( msg );
  };
  ghAgent.prototype.addlog = function(msg){
  	var org_msg = document.getElementById("logArea").value;
		document.getElementById("logArea").value = org_msg + "\r\n" + msg;
  	}
  //���ӷ�����
  ghAgent.prototype.ConnectToACD = function( szACDSerevrIP, iACDServerPort ){
  	if( this.socketConnected ){
  		if( this.onAgentConnectToACDFunc != null )	this.onAgentConnectToACDFunc( 2 );
  		return 2;				//������
  	}
  	if( szACDSerevrIP == null || szACDSerevrIP.trim() == "" ){
  		if( this.onAgentConnectToACDFunc != null )	this.onAgentConnectToACDFunc( 0 );
  		return 0;				//�������
  	}
  	if( iACDServerPort == null ){
  		if( this.onAgentConnectToACDFunc != null )	this.onAgentConnectToACDFunc( 0 );
  		return 0;				//�������
  	}
  	this.postMessage( 'init', szACDSerevrIP, iACDServerPort );
		return 1;
  };

  
  //�Ͽ�����������
  ghAgent.prototype.DisConnectToACD = function(){
  	if( ! this.socketConnected ){
  		if( this.onAgentDisConnectToACDFunc != null )			this.onAgentDisConnectToACDFunc( false, -1 );
  		return -1;				//
  	}
  	if( this.onAgentDisConnectToACDFunc != null )				this.onAgentDisConnectToACDFunc( true, 1 );
  	this.socketConnected = false;
  	if(this.agentLoginFlag)
  	{
  	this.postMessage( "stop_beat", null, null );
		var sendMsg = "Event:AgentLogout\r\n" + "AgentID:" + this.agentId  +"\r\n";
  	this.postMessage( "send",  sendMsg, null );
  	this.agentLoginFlag	= false;
  	this.agentState = 0;
		this.lineState = 7;	
  	}
  	
  	this.postMessage( 'close', null, null );
  	return 1;
  };
  
  //��ϯ��½
  ghAgent.prototype.Login = function( szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight ){
  	if( ! this.socketConnected ){		//
  		if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, -2 );
  		return false;				
  	}
		if( szAgentID==null || szAgentID.trim()=="" || szAgentName==null || szAgentName.trim()=="" || szAgentExt==null || szAgentExt.trim()=="" || szGroupID==null || szGroupID.trim()=="" ){
			if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, -1 );
  		return false;			
		}
		if( this.agentLoginFlag==true && szAgentID==this.agentId && szAgentName==this.agentName && szAgentExt==this.agentExt && szGroupID==this.agentGroupId ){
			alert( "aaa" );
			if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, 0 );
  		return false;			
		}
		
		if( this.agentLoginFlag	== true ){
			this.Logout();
		}
		var sendMsg = "Event:AgentLogin\r\n" + "AgentID:" + szAgentID  +"\r\n" + "AgentExt:" + szAgentExt  + "\r\n" + "AgentName:" + szAgentName  + "\r\n";
		sendMsg += "GroupID:" + szGroupID  + "\r\n" + "AgentLevel:" + iAgentLevel  + "\r\n" + "AgentRight:" + iAgentRight  + "\r\n";
  	this.postMessage( "send",  sendMsg, null );
		
		this.agentId = szAgentID;
		this.agentName = szAgentName;
		this.agentExt = szAgentExt;
		this.agentGroupId = szGroupID;
		this.agentLevel = iAgentLevel;
		this.agentRight = iAgentRight;
		
		this.agentLoginTimer = setTimeout( "agentLoginTimeout()", 1000*5 );
		return true;
  };
  
  //��ϯ��½
  ghAgent.prototype.LoginEx = function( szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight, iState ){
  	if( ! this.socketConnected ){		//
  		if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, -2 );
  		return false;				
  	}
		if( szAgentID==null || szAgentID.trim()=="" || szAgentName==null || szAgentName.trim()=="" || szAgentExt==null || szAgentExt.trim()=="" || szGroupID==null || szGroupID.trim()=="" ){
			if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, -1 );
  		return false;			
		}
		if( this.agentLoginFlag==true && szAgentID==this.agentId && szAgentName==this.agentName && szAgentExt==this.agentExt && szGroupID==this.agentGroupId ){
			if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, 0 );
  		return false;			
		}
		
		if( this.agentLoginFlag	== true ){
			this.Logout();
		}
		var sendMsg = "Event:AgentLoginEx\r\nAgentID:" + szAgentID  +"\r\nAgentExt:" + szAgentExt  + "\r\nAgentName:" + szAgentName  + "\r\n";
		sendMsg += "GroupID:" + szGroupID  + "\r\nAgentLevel:" + iAgentLevel  + "\r\nAgentRight:" + iAgentRight  + "\r\nState:" + iState;
  	this.postMessage( "send",  sendMsg, null );
		
		this.agentId = szAgentID;
		this.agentName = szAgentName;
		this.agentExt = szAgentExt;
		this.agentGroupId = szGroupID;
		this.agentLevel = iAgentLevel;
		this.agentRight = iAgentRight;
		
		this.agentLoginTimer = setTimeout( "agentLoginTimeout()", 1000*5 );
		return true;
  };
  
  //��ҵ��ϯ��½
  ghAgent.prototype.LoginByCompanyUID = function( szCompanyUID, szAgentID, szAgentName, szAgentExt, szGroupID, iAgentLevel, iAgentRight ){
  	if( ! this.socketConnected ){		//
  		if( this.onLoginByCompanyUIDFunc != null )		this.onLoginByCompanyUIDFunc( false, -1 );
  		return false;				
  	}
		if( szAgentID==null || szAgentID.trim()=="" || szAgentName==null || szAgentName.trim()=="" || szAgentExt==null || szAgentExt.trim()=="" || szGroupID==null || szGroupID.trim()=="" ){
			if( this.onLoginByCompanyUIDFunc != null )		this.onLoginByCompanyUIDFunc( false, -1 );
  		return false;			
		}
		if( this.agentLoginFlag==true && szAgentID==this.agentId && szAgentName==this.agentName && szAgentExt==this.agentExt && szGroupID==this.agentGroupId ){
			if( this.onLoginByCompanyUIDFunc != null )		this.onLoginByCompanyUIDFunc( false, 0 );
  		return false;			
		}
		
		if( this.agentLoginFlag	== true ){
			this.Logout();
		}
		var sendMsg = "Event:AgentLoginByCompanyUID\r\nCompanyUID:" + szCompanyUID + "\r\nAgentID:" + szAgentID  +"\r\nAgentExt:" + szAgentExt  + "\r\nAgentName:" + szAgentName  + "\r\n";
		sendMsg += "GroupID:" + szGroupID  + "\r\nAgentLevel:" + iAgentLevel  + "\r\nAgentRight:" + iAgentRight;
  	this.postMessage( "send",  sendMsg, null );
		
		this.agentId = szAgentID;
		this.agentName = szAgentName;
		this.agentExt = szAgentExt;
		this.agentGroupId = szGroupID;
		this.agentLevel = iAgentLevel;
		this.agentRight = iAgentRight;
		
		this.agentLoginTimer = setTimeout( "agentLoginTimeout()", 1000*5 );
		return true;
  };  
  
  ghAgent.prototype.agentLoginTimeout = function(){
  	if( this.onAgentLoginFunc != null )		this.onAgentLoginFunc( false, 6 );
  	this.agentLoginTimer = null;
  }
  
  //��ϯע��
  ghAgent.prototype.Logout = function(){
  	if( ! this.socketConnected ){		//
  		if( this.onAgentLogoutFunc != null )		this.onAgentLogoutFunc( false );
  		return false;				
  	}
		if( this.agentLoginFlag	== false ){
			if( this.onAgentLogoutFunc != null )		this.onAgentLogoutFunc( false );
  		return false;
		}
		this.postMessage( "stop_beat", null, null );
		var sendMsg = "Event:AgentLogout\r\n" + "AgentID:" + this.agentId  +"\r\n";
  	this.postMessage( "send",  sendMsg, null );
  	this.agentLoginFlag	= false;
  	this.agentState = 0;
		this.lineState = 7;
  	if( this.onAgentLogoutFunc != null )		this.onAgentLogoutFunc( true );
		return true;
  };
  
  //������ϯ״̬
  ghAgent.prototype.SetAgentState = function( iState ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( iState == 2 ){
			if (!((this.agentState==4)|| (this.agentState==5)|| (this.agentState==7) || (this.agentState>100) )){
				return false;
			}
		}
		if( iState == 4 ){
			if (!((this.agentState==2) || (this.agentState==8))) {
				return false;
			}
		}
		var sendMsg = "Event:AgentState\r\nAgentID:" + this.agentId  +"\r\nAgentState:" + iState;
  	this.postMessage( "send",  sendMsg, null );
  	return true;
  };
  
  //�һ�
  ghAgent.prototype.Onhook = function(){
  	if( ! this.socketConnected ){		//
  		return false;	
  	}
  	if( this.lineState == 7 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentOnHook\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid;
  	this.postMessage( "send",  sendMsg, null );
  	return true;	
  };
  
  //ժ��
  ghAgent.prototype.Offhook = function(){
  	if( ! this.socketConnected ){		//
  		return false;	
  	}
  	if( this.lineState != 1 && this.lineState != 2 && this.lineState != 13 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentOffHook\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid + "\r\nExt:" + this.agentExt;
  	this.postMessage( "send", sendMsg, null );
  	return true;	
  };
  
  //�Ⲧ
  ghAgent.prototype.Dial = function( szPhoneNumber ){
  	if( ! this.socketConnected ){		//
  		if( this.onAgentDialConfFunc != null )		this.onAgentDialConfFunc( false );
  		return false;				
  	}
  	if( szPhoneNumber == null || szPhoneNumber.trim() == "" ){
  		if( this.onAgentDialConfFunc != null )		this.onAgentDialConfFunc( false );
  		return false;
  	}
  	if( this.agentState == 4 || this.agentState == 5 || this.agentState == 7 || this.lineState == 4 ){
  		var sendMsg = "Event:AgentDialByNumber\r\nAgentID:" + this.agentId  +"\r\nPhoneNumber:" + szPhoneNumber;
  		this.postMessage( "send", sendMsg, null );
  		this.caller = this.agentExt;
  		this.called = szPhoneNumber;
  		this.agentDialTimer = setTimeout( "agentDialTimeout()", 1000*5 );
  		return true;  		
  	}
  	else{
  		if( this.onAgentDialConfFunc != null )		this.onAgentDialConfFunc( false );
  		return false;
  	}
  };	

	ghAgent.prototype.agentDialTimeout = function(){
  	if( this.onAgentDialConfFunc != null )		this.onAgentDialConfFunc( false );
  	this.agentDialTimer = null;
  };
  
  //����
  ghAgent.prototype.Hold = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.lineState != 3 && this.lineState != 16 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentHold\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //ȡ����
  ghAgent.prototype.UnHold = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.lineState == 9 ){
  		return this.CancelConsult();
  	}
  	if( this.lineState != 4 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentUnHold\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //盲转
  ghAgent.prototype.BlindTransfer = function( szTransfer ){
		if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szTransfer == null || szTransfer.trim() == "" ){
  		return false;
  	}
  	if (!(this.lineState == 3 || this.lineState == 6 || this.lineState == 16 ) ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentBlindTransfer\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid + "\r\nTransfer:" + szTransfer;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	
	//������äת
	ghAgent.prototype.BlindTransferByAgentID = function( szTransfer ){
		if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szTransfer == null || szTransfer.trim() == "" ){
  		return false;
  	}
  	if (!(this.lineState == 3 || this.lineState == 6 || this.lineState == 16 ) ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentBlindTransferByAgentID\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid + "\r\nTransfer:" + szTransfer;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
  
  //��ѯ
  ghAgent.prototype.Consult = function( szConsult ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szConsult == null || szConsult.trim() == "" ){
  		return false;
  	}
  	if( this.lineState != 3 && this.lineState != 16 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentConsult\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid + "\r\nConsult:" + szConsult;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //��������ѯ
  ghAgent.prototype.ConsultByAgentID = function( szConsult ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szConsult == null || szConsult.trim() == "" ){
  		return false;
  	}
  	if( this.lineState != 3 && this.lineState != 16 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentConsultByAgentID\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid + "\r\nConsult:" + szConsult;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //ȡ����ѯ
  ghAgent.prototype.CancelConsult = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.lineState != 9 ){
  		return false;
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentCancelConsult\r\nAgentID:" + this.agentId  +"\r\nCallID:" + this.callid;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //�����
  ghAgent.prototype.ThirdParty = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.callid == "" ){
  		return false;
  	}
  	var sendMsg = "Event:AgentThreeParty\r\nAgentID:" + this.agentId + "\r\nCallID:" + this.callid;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //�������Ƴ�
  ghAgent.prototype.RemoveMemberFromThirdParty = function( szRemoveParty ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szRemoveParty == null || szRemoveParty.trim() == "" ){
  		return false;
  	}
  	if( this.lineState != 12 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentRemoveFromThirdParty\r\nAgentID:" + this.agentId + "\r\nRemoveParty:" + szRemoveParty;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  //��ȡ��ϯת��IVR��Ϣ
  ghAgent.prototype.GetReturnToIVRInfo = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	var sendMsg = "Event:AgentGetReturnIVRInfo\r\nAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
	/*
	名称：
	BOOL AgentRequestToIVR(long iToIVRInfoID, LPCTSTR szContent);
	功能:
	座席请求转回IVR。
	参数：	
	无？
	返回值:	
	TRUE=成功、FALSE=失败
	说明:	
	调用该方法后会触发事件OnRequestToIVR，具体参见后面的OnRequestToIVR事件说明。
	*/

  //坐席转回IVR
  ghAgent.prototype.AgentRequestToIVR = function( iToIVRInfoID, szContent ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	var sendMsg = "Event:AgentRequestToIVR\r\nAgentID:" + this.agentId + "\r\nGroupID:" + this.agentGroupId + "\r\nCallID:" + this.callid;
  	sendMsg += "\r\nToIVRInfoID:" + iToIVRInfoID + "\r\nContent:" + szContent + "\r\nReturnType:2"
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.SetRecordAppID = function( appId ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( appId == null || appId.trim() == "" ){
  		return false;
  	}
  	this.appid = appId;
  	var sendMsg = "Event:AgentRECAppID\r\nAgentID:" + this.agentId + "\r\nRECAppID:" + appId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetRecordAppID = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	return this.appid;
  };
  
  ghAgent.prototype.GetQueuingNumber = function(){
  	if( ! this.socketConnected ){		//
  		return -1;				
  	}
  	if( this.agentState <= 0 ){
  		return -1;
  	}
  	var sendMsg = "Event:AgentGetNumberOfQueueingInGroup\r\nAgentID:" + this.agentId + "\r\nGroupID:" + this.agentGroupId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetAgentState = function(){
  	if( ! this.socketConnected ){		//
  		return -1;				
  	}
  	return this.agentState;
  };
  
  ghAgent.prototype.GetLineState = function(){
  	if( ! this.socketConnected ){		//
  		return -1;				
  	}
  	return this.lineState;
  };
  
  ghAgent.prototype.GetGroupList = function(){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentGetGroupList\r\nAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetIdleAgentList = function( szGroupID ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szGroupID == null || szGroupID.trim() == "" ){
  		return false;
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentGetIdleAgentListOfGroup\r\nAgentID:" + this.agentId + "\r\nGroupID:" + szGroupID;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetTalkAgentList = function( szGroupID ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szGroupID == null || szGroupID.trim() == "" ){
  		return false;
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentGetTalkAgentListOfGroup\r\nAgentID:" + this.agentId + "\r\nGroupID:" + szGroupID;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetAgentListFromGroup = function( szGroupID ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szGroupID == null || szGroupID.trim() == "" ){
  		return false;
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentGetAgentListFromGroup\r\nAgentID:" + this.agentId + "\r\nGroupID:" + szGroupID;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
  ghAgent.prototype.GetAgentStateCountFromGroup = function( szGroupID, iAgentState ){
  	if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( szGroupID == null || szGroupID.trim() == "" ){
  		return false;
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	var sendMsg = "Event:AgentGetAgentStateCountFromGroup\r\nAgentID:" + this.agentId + "\r\nGroupID:" + szGroupID + "\r\nAgentState:" + iAgentState;
  	this.postMessage( "send", sendMsg, null );
  	return true;
  };
  
	ghAgent.prototype.GetCaller = function(){
		if( ! this.socketConnected ){		//
  		return false;				
  	}
		return this.caller;
	};
  
	ghAgent.prototype.GetCalled = function(){
		if( ! this.socketConnected ){		//
  		return false;				
  	}
		return this.called;
	};
	
	ghAgent.prototype.GetCallID = function(){
		if( ! this.socketConnected ){		//
  		return false;				
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
		var sendMsg = "Event:AgentGetCallID\r\nAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	
	ghAgent.prototype.SetRecordAppID = function( szReocrdAppID ){
		if( ! this.socketConnected ){		
  		return false;				
  	}
  	if( szReocrdAppID == null || szReocrdAppID.trim() == "" ){
  		return false;
  	}
  	if( this.agentState <= 0 ){
  		return false;
  	}
  	this.appid = szReocrdAppID;
		var sendMsg = "Event:AgentRECAppID\r\nAgentID:" + this.agentId + "\r\nRECAppID:" + szReocrdAppID;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};

	
	//班长坐席功能
	//强拆
	ghAgent.prototype.ForceRelease = function( szAgentID ){
		if( ! this.socketConnected ){		//判断是否连接
  		return false;				
  	}
  	if( szAgentID == null || szAgentID.trim() == "" ){
  		return false;
  	}
  	if( this.agentRight != 1 ){     //判断班长坐席权限
  		return false;
  	}
  	var sendMsg = "Event:MonitorAgentForceHangup\r\nAgentID:" + szAgentID +"\r\nMonitorAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	//强插
		ghAgent.prototype.ForceJoin = function( szAgentID ){
		if( ! this.socketConnected ){		//判断是否连接
  		return false;				
  	}
  	if( szAgentID == null || szAgentID.trim() == "" ){
  		return false;
  	}
  	if( this.agentRight != 1 ){     //判断班长坐席权限
  		return false;
  	}
  	this.lineState = 15;
  	var sendMsg = "Event:MonitorAgentForceJoin\r\nAgentID:" + szAgentID +"\r\nMonitorAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	//拦截
		ghAgent.prototype.HiJack = function( szAgentID ){
		if( ! this.socketConnected ){		//判断是否连接
  		return false;				
  	}
  	if( szAgentID == null || szAgentID.trim() == "" ){
  		return false;
  	}
  	if( this.agentRight != 1 ){     //判断班长坐席权限
  		return false;
  	}
  	this.lineState = 16;
  	var sendMsg = "Event:MonitorAgentHijack\r\nAgentID:" + szAgentID +"\r\nMonitorAgentID:" + this.agentId;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	//强置
	
	ghAgent.prototype.ForceState = function( szAgentID, iForceState ){
		if( ! this.socketConnected ){		//��ǰû������
  		return false;				
  	}
  	if( szAgentID == null || szAgentID.trim() == "" ){
  		return false;
  	}
  	if( iForceState == null ){
  		return false;
  	}
  	if (!((iForceState == 0) || (iForceState == 7)	|| (iForceState == 4)	|| (iForceState == 8))) {
			return false;
  	}
  	if( this.agentRight != 1 ){
  		return false;
  	}
		var sendMsg = "Event:MonitorAgentForceState\r\nAgentID:" + szAgentID + "\r\nMonitorAgentID:" + this.agentId + "\r\nAgentState:" + iForceState;
  	this.postMessage( "send", sendMsg, null );
  	return true;
	};
	//开始监听
	ghAgent.prototype.StartListenChannel = function( szAgentID ){
		if( ! this.socketConnected )
		{
			this.addlog("No link to ACD in StartListenChannel()");
			return false;
		}
		if(szAgentID == null ||szAgentID.trim() == ""){
			this.addlog("AgentID  is null in StartListenChannel()");
			return false;
		}
		if(this.agentRight != 1){
			this.addlog("the Agent has no right");
			return false;	
		}
	//	this.lineState = 14;
		var sendMsg = "Event:AgentQueryAgentInfo\r\nAgentID:" + this.agentId + "\r\nQueryAgentID:" + szAgentID;
		this.postMessage( "send", sendMsg, null );
		return true;
	}
	//结束监听
	ghAgent.prototype.StopListenChannel = function(){
		if( ! this.socketConnected )
		{
			this.addlog("No link to ACD in StartListenChannel()");
			return false;
		}
		if(this.agentRight != 1){
			this.addlog("the Agent has no right");
			return false;	
		}
		var sendMsg = "Event:MonitorCallStop\r\nExtNum:"+this.QueryAgentExt +"\r\nRecIP:" + this.iRECIP;
		this.RECpostMessage( "send", sendMsg, null);
		this.RECpostMessage('close',null,null);               
		if(this.onStopListenChannelFunc != null) this.onStopListenChannelFunc(1);
		return 1;
	}
	
	ghAgent.prototype.RecServerConnection = function(szRECIP,szRECPort){
	//	alert("connecting...");
		this.RECpostMessage( 'init', szRECIP, szRECPort );

		return 1;
	}
	ghAgent.prototype.RecMonitorCallStart = function(){
		var sendMsg = "Event:MonitorCallStart\r\nExtNum:"+this.QueryAgentExt +"\r\nRecIP:" + this.iRECIP;
		this.RECpostMessage( "send", sendMsg, null );
		return 1;
	}
	
	
	
	ghAgent.prototype.SetRecServerAddr = function(szRECSerevrIP,iRECServerPort){
		this.iRECIP = szRECSerevrIP;
		this.iRECPort = iRECServerPort;
		return true;
	}
	
	
	
//-------------------------------�¼�����---------------------------------------------------------------------------------------------------------------------------    
  
  //坐席连接回调函数
  ghAgent.prototype.onAgentConnectToACDCallback = function(callback){
  	this.onAgentConnectToACDFunc = callback;
  }
  
  //坐席断开回调函数
  ghAgent.prototype.onAgentDisConnectToACDCallback = function(callback){
  	this.onAgentDisConnectToACDFunc = callback;
  }
  
  
  //坐席登陆回调函数
  ghAgent.prototype.onAgentLoginCallback = function(callback){
  	this.onAgentLoginFunc = callback;
  }
  
  //企业坐席登陆回调函数
  ghAgent.prototype.onLoginByCompanyUIDCallback = function(callback){
  	this.onLoginByCompanyUIDFunc = callback;
  }
  
  //坐席登出回调函数
  ghAgent.prototype.onAgentLogoutCallback = function(callback){
  	this.onAgentLogoutFunc = callback;
  }
  
  //坐席状态改变回调函数
  ghAgent.prototype.onAgentStateChangedCallback = function(callback){
  	this.onAgentStateChangedFunc = callback;
  }
  
  //线路状态改变回调函数
  ghAgent.prototype.onLineStateChangedCallback = function(callback){
  	this.onLineStateChangedFunc = callback;
  }
  
  //坐席外呼结果回调函数
  ghAgent.prototype.onAgentDialConfCallback = function(callback){
  	this.onAgentDialConfFunc = callback;
  }
  
  //来电响铃事件回调函数
  ghAgent.prototype.onTelephoneRingCallback = function(callback){
  	this.onTelephoneRingFunc = callback;
  }
  
  //来电接通事件回调函数
  ghAgent.prototype.onAnswerConnectedCallback = function(callback){
  	this.onAnswerConnectedFunc = callback;
  }
  
  //外呼接通事件回调函数
  ghAgent.prototype.onDialConnectedCallback = function(callback){
  	this.onDialConnectedFunc = callback;
  }
  
  //电话在保持中挂断事件回调函数
  ghAgent.prototype.onTelephoneHangupInHoldCallback = function(callback){
  	this.onTelephoneHangupInHoldFunc = callback;
  }
  
  //电话挂断事件回调函数
  ghAgent.prototype.onTelephoneHangupCallback = function(callback){
  	this.onTelephoneHangupFunc = callback;
  }
  
  //转回IVR信息回调函数
  ghAgent.prototype.onReturnToIVRInfoCallback = function(callback){
  	this.onReturnToIVRInfoFunc = callback;
  }
  
  //¼���ļ�����ɻص�����
  ghAgent.prototype.onYARecPathCallback = function(callback){
  	this.onYARecPathFunc = callback;
  }
  
  //�����Ŷ���仯�ص�����
  ghAgent.prototype.onQueuingNumberChangedCallback = function(callback){
  	this.onQueuingNumberChangedFunc = callback;
  }
  
  //�õ���ϯ��ID�б�ص�����
  ghAgent.prototype.onGetGroupListCallback = function(callback){
  	this.onGetGroupListFunc = callback;
  }
  
  //�õ����ڿ�����ϯID�б�ص�����
  ghAgent.prototype.onGetIdleAgentListCallback = function(callback){
  	this.onGetIdleAgentListFunc = callback;
  }
  
  //�õ�����ͨ����ϯID�б�ص�����
  ghAgent.prototype.onGetTalkAgentListCallback = function(callback){
  	this.onGetTalkAgentListFunc = callback;
  }
  
  //�õ�����������ϯID�б�ص�����
  ghAgent.prototype.onGetAgentListFromGroupCallback = function(callback){
  	this.onGetAgentListFromGroupFunc = callback;
  }
  
  //�õ�����������ϯID�б�ص�����
  ghAgent.prototype.onGetAgentStateCountFromGroupCallback = function(callback){
  	this.onGetAgentStateCountFromGroupFunc = callback;
  }
  
  //�õ�callid�ص�����
  ghAgent.prototype.onGetCallIDCallback = function(callback){
  	this.onGetCallIDFunc = callback;
  }
  
  //����ת�ص�IVRȷ�ϻص�����
  ghAgent.prototype.onRequestToIVRCallback = function(callback){
  	this.onRequestToIVRFunc = callback;
  }
  
  //��ѯ��ͨ�ص�����
  ghAgent.prototype.onConsultConnectedCallback = function(callback){
  	this.onConsultConnectedFunc = callback;
  }
  
  //ȡ����ѯ���ص�����
  ghAgent.prototype.onCancelConsultCallback = function(callback){
  	this.onCancelConsultFunc = callback;
  }
  
  //��ѯת����ص�����
  ghAgent.prototype.onAgentThirdPartyCallback = function(callback){
  	this.onAgentThirdPartyFunc = callback;
  }
  
  //�������Ƴ���ص�����
  ghAgent.prototype.onAgentRemoveMemberFromThirdPartyCallback = function(callback){
  	this.onAgentRemoveMemberFromThirdPartyFunc = callback;
  }
  
  //��·��ݻص�����
  ghAgent.prototype.onRecvAssociateDataCallback = function(callback){
  	this.onRecvAssociateDataFunc = callback;
  }
  
  //�ֻ�ע���¼��ص�����
  ghAgent.prototype.onTelephoneRegisterCallback = function(callback){
  	this.onTelephoneRegisterFunc = callback;
  }
  
  //�ֻ�ע���¼��ص�����
  ghAgent.prototype.onTelephoneUnRegisterCallback = function(callback){
  	this.onTelephoneUnRegisterFunc = callback;
  }
  //强拆
	ghAgent.prototype.onForceHangupCallback = function(callback){
  	this.onForceHangupFunc = callback;
  }
  //强插
	ghAgent.prototype.onForceJoinCallback = function(callback){
  	this.onForceJoinFunc = callback;
  }
  //拦截
	ghAgent.prototype.onHijackCallback = function(callback){
  	this.onHijackFunc = callback;
  }
  //强置
  ghAgent.prototype.onForceStateCallback = function(callback){
  	this.onForceStateFunc = callback;	
  }
  //监听回调函数
  ghAgent.prototype.onStartListenChannelCallback = function(callback){
  	this.onStartListenChannelFunc = callback;	
  }
  
  ghAgent.prototype.onStopListenChannelCallback = function(callback){
  	this.onStopListenChannelFunc = callback;	
  }
  
	return ghAgent;
})();
		
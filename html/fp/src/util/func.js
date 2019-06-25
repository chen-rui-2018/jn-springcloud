'use strict';

// export function ClosestFun (el, selector) {
//   const matchesSelector = el.matches || el.webkitMatchesSelector || el.mozMatchesSelector || el.msMatchesSelector;

//   while (el) {
//     if (matchesSelector.call(el, selector)) {
//       return el;
//     } else {
//       el = el.parentElement;
//     }
//   }
//   return null;
// }

// 控制 scroll 不触发原生应用交互(垂直方向)
function setIsScroller (evt) {
  if (this.offsetHeight < this.scrollHeight || this.offsetWidth < this.scrollWidth) {
    evt._isScroller = true;
  }
}
// 控制 scroll 不触发原生应用交互(垂直方向)
function scrollControl () {
  document.body.addEventListener('touchstart', function(e) {
    var objList = document.querySelectorAll('.bscroll');
    var noStop = document.querySelectorAll('.scrollfix');
    var scrollObj = null;

    for (let i = 0; i < objList.length; i++) {
      if (objList[i].contains(e.target) || objList[i] == e.target) {
        scrollObj = objList[i];
      }
    }
    for (let i = 0; i < noStop.length; i++) {
      if (noStop[i].contains(e.target) || noStop[i] == e.target) {
        scrollObj = noStop[i];
      }
    }

    if (scrollObj) {
      // var top = scrollObj.scrollTop
      //   , totalScroll = scrollObj.scrollHeight
      //   , currentScroll = top + scrollObj.offsetHeight

      // if(top === 0) {
      //   scrollObj.scrollTop = 1;
      // } else if(currentScroll === totalScroll) {
      //   scrollObj.scrollTop = top - 1;
      // }

      scrollObj.removeEventListener('touchmove', setIsScroller);
      scrollObj.addEventListener('touchmove', setIsScroller);
    }

  });

  document.body.addEventListener('touchmove', function(evt) {
    if(!evt._isScroller) {
      evt.preventDefault()
    }
  })
}

// 切换class
function ToggleClass (obj, className) {
  if (obj.classList) {
    obj.classList.toggle(className);
  } else {
    var n = [];
    if (obj.className.indexOf(className) > -1) {
      for (var i = 0; i < obj.className.length; i++) {
        if (obj.className[i] != className) {
          n.push(obj.className[i]);
        }
      }
    } else {
      n = obj.className;
      n.push(className);
    }
    obj.setAttribute('class', n.join(' '));
  }
}

// 移除class
function RemoveClass (obj, className) {
  if (obj.classList) {
    obj.classList.remove(className);
  } else {
    if (obj.className.indexOf(className) > -1) {
      var n = [];
      for (var i = 0; i < obj.className.length; i++) {
        if (obj.className[i] != className) {
          n.push(obj.className[i]);
        }
      }
      obj.setAttribute('class', n.join(' '));
    }
  }
}

// 增加class
function AddClass (obj, className) {
  console.dir(obj)
  // if (obj.classList) {
  //
  //   obj.classList.add(className);
  // } else {
  //   if (obj.className.indexOf(className) == -1) {
  //     var n = obj.className;
  //     n.push(className);
  //     obj.setAttribute('class', n.join(' '));
  //   }
  // }
}

// 判断是否有某个class
function HasClass (obj, className) {
  if (obj.classList) {
    return !!obj.classList.contains(className);
  } else if (obj.className) {
    return !!(obj.className.indexOf(className) > -1);
  } else {
    return false;
  }
}

// 改变 title
function ChangeMainTitle (title) {
  var $body = document.body;
  if (document.title == title) return;
  document.title = title;
  // hack在微信等webview中无法修改document.title的情况
  var $iframe = createDom('<iframe style="display: none;" src="/favicon.png"></iframe>');
  $iframe.addEventListener('load', load);
  $body.appendChild($iframe);

  function load(){
    setTimeout(function() {
      $iframe.removeEventListener('load', load);
      $body.removeChild($iframe);
    }, 0);
  }

  function createDom(htmlStr){
    var tmp = document.createElement('div');
    tmp.innerHTML = htmlStr;
    var children = tmp.childNodes;
    for (var i = 0; i < children.length; i++) {
      if (children[i].nodeType ===1 ) {
        return children[i];
      }
    }
    return;
  }
}

function GetDateAfter (AddDayCount, joinIcon) {
  var dd = new Date();
  dd.setDate(dd.getDate()+AddDayCount); // 获取AddDayCount天后的日期
  var y = dd.getFullYear();
  var m = (dd.getMonth() + 1 < 10 ? '0'+(dd.getMonth() + 1) : dd.getMonth() + 1); // 获取当前月份的日期
  var d = dd.getDate() < 10 ? '0' + dd.getDate() : dd.getDate();
  return y+joinIcon+m+joinIcon+d;
}

function SetTimePreview (oDate) {
  if (oDate === GetDateAfter(0, '-')) {
    return '(今天)' + oDate;
  } else if (oDate === GetDateAfter(1, '-')) {
    return '(明天)' + oDate;
  } else if (oDate === GetDateAfter(2, '-')) {
    return '(后天)' + oDate;
  } else {
    return oDate;
  }
}

// 获取日期显示 传入时间戳
// function timeago(dateTimeStamp){   //dateTimeStamp是一个时间毫秒，注意时间戳是秒的形式，在这个毫秒的基础上除以1000，就是十位数的时间戳。13位数的都是时间毫秒。
//   var minute = 1000 * 60;      //把分，时，天，周，半个月，一个月用毫秒表示
//   var hour = minute * 60;
//   var day = hour * 24;
//   var week = day * 7;
//   var halfamonth = day * 15;
//   var month = day * 30;
//   var now = new Date().getTime();   //获取当前时间毫秒
//   // console.log(now)
//   var diffValue = now - dateTimeStamp;//时间差

//   var result = '';
//   // if(diffValue < 0){
//   //     return;
//   // }
//   var minC = diffValue/minute;  //计算时间差的分，时，天，周，月
//   var hourC = diffValue/hour;
//   var dayC = diffValue/day;
//   var weekC = diffValue/week;
//   var monthC = diffValue/month;
//   // if(monthC >= 1 && monthC <= 3){
//   //     result = " " + parseInt(monthC) + "月前"
//   // }else if(weekC >= 1 && weekC <= 3){
//   //     result = " " + parseInt(weekC) + "周前"
//   // }else
//   if(dayC >= 1 && dayC <= 6){
//       result = " " + parseInt(dayC) + "天前"
//   }else if(hourC >= 1 && hourC <= 23){
//       result = " " + parseInt(hourC) + "小时前"
//   }else if(minC >= 1 && minC <= 59){
//       result =" " + parseInt(minC) + "分钟前"
//   }else if(diffValue >= 0 && diffValue <= minute){
//       result = "刚刚"
//   }else {
//       var datetime = new Date();
//       datetime.setTime(dateTimeStamp);
//       var Nyear = datetime.getFullYear();
//       var Nmonth = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
//       var Ndate = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
//       var Nhour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
//       var Nminute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
//       var Nsecond = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
//       result = Nyear + "-" + Nmonth + "-" + Ndate
//   }
//   return result;
// }

function androidInputBugFix(){
  // .container 设置了 overflow 属性, 导致 Android 手机下输入框获取焦点时, 输入法挡住输入框的 bug
  // 解决方法:
  // 0. .container 去掉 overflow 属性, 但此 demo 下会引发别的问题
  // 1. 参考 http://stackoverflow.com/questions/23757345/android-does-not-correctly-scroll-on-input-focus-if-not-body-element
  //    Android 手机下, input 或 textarea 元素聚焦时, 主动滚一把
  if (/Android/gi.test(navigator.userAgent)) {
    window.addEventListener('resize', function () {
      if (document.activeElement.tagName == 'INPUT' || document.activeElement.tagName == 'TEXTAREA') {
        window.setTimeout(function () {
          document.activeElement.scrollIntoViewIfNeeded();
        }, 0);
      }
    })
  }
}

function format (fmt) {
  // Date.prototype.format = function(fmt) {  
    var o = {   
      "M+" : this.getMonth()+1,                 //月份   
      "d+" : this.getDate(),                    //日   
      "h+" : this.getHours(),                   //小时   
      "m+" : this.getMinutes(),                 //分   
      "s+" : this.getSeconds(),                 //秒   
      "q+" : Math.floor((this.getMonth()+3)/3), //季度   
      "S"  : this.getMilliseconds()             //毫秒   
    };   
    if(/(y+)/.test(fmt))   
      fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
    for(var k in o)   
      if(new RegExp("("+ k +")").test(fmt))   
    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
    return fmt;   
  // }
}


function timeago (time) {
  // 日期格式
  var date = new Date(time),
  now = new Date(),
  day = 1000 * 60 * 60 *24,
  // 从08:00 起的，所以只能做这样的处理
  todayLine = now.setHours(0) && now.setMinutes(0) && now.setSeconds(0) && now.getTime(),
  lastDayLine = todayLine - day;

  // console.log(date);

return time <= lastDayLine ? format.call(date, 'yyyy-MM-dd') :
  time < todayLine ? format.call(date, '昨天 hh:mm') : format.call(date, 'hh:mm');
}

//判断是否微信登陆
function IsWeiXin() {
  var ua = window.navigator.userAgent.toLowerCase();
  console.log(ua);
  // console.log(ua);//mozilla/5.0 (iphone; cpu iphone os 9_1 like mac os x) applewebkit/601.1.46 (khtml, like gecko)version/9.0 mobile/13b143 safari/601.1
  if (ua.match(/MicroMessenger/i) == 'micromessenger') {
    return true;
  } else {
    return false;
  }
}

// 判断是否iOS
function IsIOS () {
  var pda_user_agent_list = new Array("iPhone", "iPod", "iPad");
  var user_agent = navigator.userAgent.toString();
  for (var i=0; i < pda_user_agent_list.length; i++) {
    if (user_agent.indexOf(pda_user_agent_list[i]) >= 0) {
      return true;
    }
  }
  return false;
}

function Toast (tips, times, callback) {
  if (!times) times = 3000;
  if (tips.indexOf('script') > -1) return;
  var prevDiv = document.getElementById('my-toast-box');
  if (prevDiv) {
    prevDiv.parentNode.removeChild(prevDiv);
    window.myToastTimeout ? clearTimeout(window.myToastTimeout) : '';
  }

  var oDiv = document.createElement('div');
  oDiv.setAttribute('class', 'my-toast-box br fade-in');
  oDiv.setAttribute('id', 'my-toast-box');
  oDiv.innerHTML = tips;

  var t = 0;
  if (document.hasFocus()) {
    var a = document.activeElement;
    if (a.tagName.toLowerCase() === 'input' || a.tagName.toLowerCase() === 'textarea') {
      var top = a.offsetTop;
      var cur = a.offsetParent;
      while(cur != null){
        top += cur.offsetTop;
        cur = cur.offsetParent;
      }
      if (top < 100) {
        t = top + 50
      } else {
        t = top
      }
      oDiv.style.top = t + 'px';
      // oDiv.style.marginTop = '50%';
    }
  }

  document.body.appendChild(oDiv);
  window.myToastTimeout = setTimeout(function () {
    oDiv.classList.remove('fade-in');
    oDiv.classList.add('fade-out');
    setTimeout(function () {
      oDiv.parentNode.removeChild(oDiv);
      if (callback) callback();
    }, 200);
  }, times)
}

function Loading (tips, flag) {
  if (tips.indexOf('script') > -1) return;
  var o = document.getElementById('my-loading-modal');
  if (o) {
    var num = parseInt(o.getAttribute('data-num'));
    if (flag) {
      num++;
      o.setAttribute('data-num', num);
    } else {
      num--;
      if (num > 0) {
        o.setAttribute('data-num', num);
      } else {
        o.parentNode.removeChild(o);
      }
    }
  } else {
    if (flag) {
      var oDiv = document.createElement('div');
      oDiv.setAttribute('class', 'my-loading-modal fbox');
      oDiv.setAttribute('id', 'my-loading-modal');
      oDiv.setAttribute('data-num', 1);
      oDiv.innerHTML = '<div class="content-box"><div class="weui-loading"></div><p class="tips">'+tips+'</p></div>';
      document.body.appendChild(oDiv);
    }
  }

}

// 校验手机号
function TestPhoneNumber (phone) {
  return phone.match(/^1(3[0-9]|4[579]|5[0-35-9]|6[67]|8[0-9]|7[0-9]|9[189])\d{8}$/);
}

// 判断图片是否加载完成
function OnLoadElement (e, func) {
  var img = e.getElementsByTagName("img");
  var num = 0;
  console.log(img);
  if(img.length<=0){
    return 1;
  }
  for(var i = 0; i < img.length; i++){
    (function (j) {
      if (!img[j].complete) {
        img[j].onload = function () {
          num++;
          console.log("已经加载图片:"+num+"/"+img.length);
          if (num==img.length) {
            func();
            console.log("内容加载完成");
          }
        }
      } else {
        num++;
        console.log("已经加载图片:"+num+"/"+img.length);
        if (num == img.length) {
          func();
          console.log("内容加载完成");
        }
      }
    })(i);
  }
}

export default {
  setIsScroller,
  scrollControl,
  ToggleClass,
  RemoveClass,
  AddClass,
  HasClass,
  SetTimePreview,
  IsWeiXin,
  IsIOS,
  Loading,
  Toast,
  androidInputBugFix,
  format,
  TestPhoneNumber,
  OnLoadElement,
  ChangeMainTitle,
  timeago,
}


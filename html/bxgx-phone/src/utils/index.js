import router from '../router'
function UrlSearch () {
  var name, value
  var str = location.href // 取得整个地址栏
  var num = str.indexOf('?')
  str = str.substr(num + 1) // 取得所有参数   stringvar.substr(start [, length ]

  var arr = str.split('&') // 各个参数放到数组里
  for (var i = 0; i < arr.length; i++) {
    num = arr[i].indexOf('=')
    if (num > 0) {
      name = arr[i].substring(0, num)
      value = arr[i].substr(num + 1)
      this[name] = value
    }
  }
}
const urlSearch = new UrlSearch()

function isMobile () {
  const userAgentInfo = navigator.userAgent
  const Agents = ['Android', 'iPhone', 'SymbianOS', 'Windows Phone', 'iPad', 'iPod']
  return Agents.some(str =>{
    return userAgentInfo.indexOf(str) > 0
  })
}

function initJsBridge (readyCallback) {
  const u = navigator.userAgent
  const isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1 // android终端
  const isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/) // ios终端

  // 注册jsbridge
  function connectWebViewJavascriptBridge (callback) {
    if (isAndroid) {
      const WebViewJavascriptBridge = window.WebViewJavascriptBridge
      if (WebViewJavascriptBridge) {
        callback(WebViewJavascriptBridge)
      } else {
        document.addEventListener(
          'WebViewJavascriptBridgeReady'
          , function () {
            callback(WebViewJavascriptBridge)
          },
          false
        )
      }
      return
    }

    if (isiOS) {
      const WebViewJavascriptBridge = window.WebViewJavascriptBridge
      if (WebViewJavascriptBridge) {
        return callback(WebViewJavascriptBridge)
      }
      if (window.WVJBCallbacks) {
        return window.WVJBCallbacks.push(callback)
      }
      window.WVJBCallbacks = [callback]
      const WVJBIframe = document.createElement('iframe')
      WVJBIframe.style.display = 'none'
      WVJBIframe.src = 'https://__bridge_loaded__'
      document.documentElement.appendChild(WVJBIframe)
      setTimeout(function () {
        document.documentElement.removeChild(WVJBIframe)
      }, 0)
    }
  }

  // 调用注册方法
  connectWebViewJavascriptBridge(function (bridge) {
    if (isAndroid) {
      bridge.init(function (message, responseCallback) {
        console.log('JS got a message', message)
        responseCallback(message)
      })
    }
    readyCallback()
  })
}
function linkTo (data) {
  const { appPath, callBack } = data
  if (isMobile()) {
    initJsBridge(() => {
      window.WebViewJavascriptBridge.callHandler('goNative', {
        'url': appPath
      }, function (response) {
        if (callBack) {
          callBack(response)
        }
      })
    })
  } else {
    router.push(data)
  }
}

export {
  urlSearch,
  initJsBridge,
  linkTo
}

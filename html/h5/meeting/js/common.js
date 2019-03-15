
 /**
  * 获取 domain
  * @returns {string} http://www.test.com
  */
 function getBaseUrl() {
    var ishttps = 'https:' == document.location.protocol ? true : false;
    var url = window.location.host;
    if (ishttps) {
        url = 'https://' + url;
    } else {
        url = 'http://' + url;
    }
    //url = "http://192.168.10.31:1101"
    return url;
}

 /**
  * 获取链接参数  ?id= &ab=
  * @param paraName  参数名称
  * @returns {string} 参数值
  * @constructor
  */
 function GetUrlParam(paraName) {
    var url = document.location.toString();
    var arrObj = url.split("?");
    if (arrObj.length > 1) {
        var arrPara = arrObj[1].split("&");
        var arr;
        for (var i = 0; i < arrPara.length; i++) {
            arr = arrPara[i].split("=");
            if (arr != null && arr[0] == paraName) {
                return arr[1];
            }
        }
        return "";
    } else {
        return "";
    }
}


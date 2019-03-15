 //获取domain
 function getBaseUrl() {
    var ishttps = 'https:' == document.location.protocol ? true : false;
    var url = window.location.host;
    if (ishttps) {
        url = 'https://' + url;
    } else {
        url = 'http://' + url;
    }
    return url;
}

//获取参数 ?id= &ab=
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
$(document).on('click','.hrefPage',function(){
location.href="./list.html"
})
// 数字时钟
var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October",
    "November", "December"
];
var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]

// Create a newDate() object
var newDate = new Date();
// Extract the current date from Date object
newDate.setDate(newDate.getDate());
// Output the day, date, month and year    
$('#Date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' +
    newDate.getFullYear());

setInterval(function () {
    // Create a newDate() object and extract the seconds of the current time on the visitor's
    var seconds = new Date().getSeconds();
    // Add a leading zero to seconds value
    $(".sec").html((seconds < 10 ? "0" : "") + seconds);
}, 1000);

setInterval(function () {
    // Create a newDate() object and extract the minutes of the current time on the visitor's
    var minutes = new Date().getMinutes();
    // Add a leading zero to the minutes value
    $(".min").html((minutes < 10 ? "0" : "") + minutes);
}, 1000);

setInterval(function () {
    // Create a newDate() object and extract the hours of the current time on the visitor's
    var hours = new Date().getHours();
    // Add a leading zero to the hours value
    $(".hours").html((hours < 10 ? "0" : "") + hours);
}, 1000);
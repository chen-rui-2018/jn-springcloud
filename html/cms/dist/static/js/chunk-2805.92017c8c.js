(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2805"],{"4SJy":function(t,e,a){"use strict";var r=a("7Qib");e.a={mounted:function(){var t=this;this.__resizeHandler=Object(r.a)(function(){t.chart&&t.chart.resize()},100),window.addEventListener("resize",this.__resizeHandler),document.getElementsByClassName("sidebar-container")[0].addEventListener("transitionend",this.sidebarResizeHandler)},beforeDestroy:function(){window.removeEventListener("resize",this.__resizeHandler),document.getElementsByClassName("sidebar-container")[0].removeEventListener("transitionend",this.sidebarResizeHandler)},methods:{sidebarResizeHandler:function(t){"width"===t.propertyName&&this.__resizeHandler()}}}},Brvk:function(t,e,a){},Gmrj:function(t,e,a){"use strict";var r=a("Brvk");a.n(r).a},UW4i:function(t,e,a){},lyHe:function(t,e,a){"use strict";var r=a("UW4i");a.n(r).a},z7zn:function(t,e,a){"use strict";a.r(e);var r=a("MT78"),s=a.n(r),n=a("4SJy"),i={mixins:[n.a],props:{className:{type:String,default:"chart"},id:{type:String,default:"chart"},width:{type:String,default:"200px"},height:{type:String,default:"200px"},chartopts:{type:Object,default:null}},data:function(){return{chart:null}},mounted:function(){this.initChart()},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){var t=this.chartopts;this.chart=s.a.init(document.getElementById(this.id));var e={color:["#81ca3f","#2181da","#fdb409"],backgroundColor:["#fff"],tooltip:{trigger:"item",formatter:"{b}"},legend:{orient:"vertical",x:"left",y:"center",icon:"circle",data:["项目一","项目二","项目三"]},grid:{left:10},series:[{label:{normal:{position:"inner",textStyle:{fontSize:16}}},type:"pie",radius:"60%",center:["60%","center"],selectedMode:"single",data:t.series[0].data,itemStyle:{emphasis:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]};this.chart.setOption(e)}}},l=a("KHd+"),o=Object(l.a)(i,function(){var t=this.$createElement;return(this._self._c||t)("div",{class:this.className,style:{height:this.height,width:this.width},attrs:{id:this.id}})},[],!1,null,null,null);o.options.__file="PieChart.vue";var c=o.exports,d={mixins:[n.a],props:{className:{type:String,default:"chart"},id:{type:String,default:"chart"},width:{type:String,default:"200px"},height:{type:String,default:"200px"},chartopts:{type:Object,default:null}},data:function(){return{chart:null}},mounted:function(){this.initChart()},beforeDestroy:function(){this.chart&&(this.chart.dispose(),this.chart=null)},methods:{initChart:function(){var t=this.chartopts;this.chart=s.a.init(document.getElementById(this.id));var e={color:["#81ca3f","#2181da","#fdb409"],backgroundColor:["#fff"],tooltip:{trigger:"item",formatter:"{b}"},legend:{orient:"vertical",x:"left",y:"center",icon:"circle",data:["项目一","项目二","项目三"]},grid:{left:10},series:[{label:{normal:{position:"inner",textStyle:{fontSize:16}}},type:"pie",radius:"60%",center:["60%","center"],selectedMode:"single",data:t.series[0].data,itemStyle:{emphasis:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]};this.chart.setOption(e)}}},h=Object(l.a)(d,function(){var t=this.$createElement;return(this._self._c||t)("div",{class:this.className,style:{height:this.height,width:this.width},attrs:{id:this.id}})},[],!1,null,null,null);h.options.__file="BarChart.vue";var u={components:{PieChart:c,BarChart:h.exports},data:function(){return{currentDate:30,currentMonthDays:31,detailData:[{task:"工作事项01",progress:"100%",statusTime:"+2",statusComment:"差",dateStart:"2018/7/1",dateEnd:"2018/7/5"},{task:"工作事项02",progress:"100%",statusTime:"-2",statusComment:"好",dateStart:"2018/7/3",dateEnd:"2018/7/20"},{task:"工作事项03",progress:"100%",statusTime:"0",statusComment:"差",dateStart:"2018/7/10",dateEnd:"2018/8/5"},{task:"工作事项04",progress:"40%",statusTime:"+2",statusComment:"差",dateStart:"2018/7/10",dateEnd:"2018/7/28"},{task:"工作事项05",progress:"0%",statusTime:"",statusComment:"差",dateStart:"2018/7/10",dateEnd:"2018/8/5"}],pieData:{series:[{data:[{value:400,name:"项目一"},{value:400,name:"项目二"},{value:410,name:"项目三"}]}]},barData:{label:["2017年\n5月","6\n月","7\n月","8\n月","9\n月","10\n月","11\n月","12\n月","2018年\n1月","2\n月","3\n月","4\n月"]}}},computed:{},methods:{handlerHeaderRowClass:function(t){t.row,t.column,t.rowIndex;if(t.columnIndex===this.currentDate+3)return"current"},handlerRowClass:function(t){t.row,t.column;var e=t.rowIndex,a=t.columnIndex,r=this.detailData[e],s=this.currentDate,n=this.currentMonthDays,i=r.progress,l=parseInt(r.statusTime),o=parseInt(r.dateStart.split("/")[2])+5,c=+r.dateEnd.split("/")[2]+5,d="";return c<o&&(c=n),a>=o&&a<=c&&(d+="planned-time"),"100%"===i&&a>=o&&a<=c+l&&(d+=" green"),"100%"!==i&&"0%"!==i&&a>=o&&a<=c+l&&(d+=" blue"),a===s+5&&(d+=" current"),1===a&&"100%"===i&&(d+="text-green"),d},arraySpanMethod:function(t){t.row,t.column,t.rowIndex,t.columnIndex}}},p=(a("lyHe"),a("Gmrj"),Object(l.a)(u,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticStyle:{width:"100%"}},[a("div",{staticClass:"c--bar"},[a("span",{staticClass:"title",staticStyle:{"font-size":"32px"}},[t._v("19号楼建设任务")]),t._v(" "),a("div",{staticClass:"flex-item"}),t._v(" "),a("span",{staticStyle:{"font-size":"18px","margin-right":"58px",color:"#797c82"}},[t._v("2018年7月17日")]),t._v(" "),a("router-link",{attrs:{to:"/planning/project/index"}},[t._v("返回\n    ")])],1),t._v(" "),a("el-table",{staticClass:"mb--gap",staticStyle:{width:"100%"},attrs:{data:t.detailData,"span-method":t.arraySpanMethod,"header-cell-class-name":t.handlerHeaderRowClass,"cell-class-name":t.handlerRowClass}},[a("el-table-column",{attrs:{fixed:"",prop:"task",label:"任务",width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"progress",label:"进度",width:"80",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:"状态",align:"center"}},[a("el-table-column",{attrs:{prop:"statusTime",label:"时间",width:"50",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"statusComment",label:"评价",width:"50",align:"center"}})],1),t._v(" "),a("el-table-column",{attrs:{label:"计划时间",align:"center"}},[a("el-table-column",{attrs:{prop:"dateStart",label:"开始",width:"90",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"dateEnd",label:"结束",width:"90",align:"center"}})],1),t._v(" "),a("el-table-column",{attrs:{label:"2018年7月",align:"center"}},t._l(31,function(e,r){return a("el-table-column",{key:r,class:[e==t.currentDate&&"currentabc"],attrs:{label:e,prop:" ",width:"22",align:"center"}})}))],1),t._v(" "),a("el-row",{attrs:{gutter:15}},[a("el-col",{attrs:{span:8}},[a("el-card",{staticClass:"box-card"},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[t._v("任务进展情况")])]),t._v(" "),a("div",{staticClass:"card-body"},[a("pie-chart",{staticStyle:{width:"100%",height:"300px"},attrs:{id:"pie-chart",chartopts:t.pieData}})],1)])],1),t._v(" "),a("el-col",{attrs:{span:16}},[a("el-card",{staticClass:"box-card"},[a("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[a("span",[t._v("进度及时率月统计")])]),t._v(" "),a("div",{staticClass:"card-body"},[a("bar-chart",{staticStyle:{width:"100%",height:"300px"},attrs:{id:"bar-chart",chartopts:t.pieData}})],1)])],1)],1)],1)},[],!1,null,"5dd75564",null));p.options.__file="detail.vue";e.default=p.exports}}]);
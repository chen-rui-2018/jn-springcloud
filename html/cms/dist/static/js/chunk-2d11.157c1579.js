(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-2d11"],{"3XEa":function(e,t,i){"use strict";var a=i("MpLX");i.n(a).a},"7V3v":function(e,t,i){"use strict";i.r(t);var a=i("t3Un");var s={data:function(){var e=this;return{oldName:void 0,isDisabled:!1,listQuery:{page:1,rows:10,fileGroupName:"",status:""},statusOptions:["未生效","生效"],fileGroupdialogFormVisible:!1,dialogStatus:"",temp:{id:void 0,fileGroupName:void 0,status:void 0,fileGroupDescribe:void 0},listLoading:!1,fileGroupList:[],total:0,rules:{fileGroupName:[{required:!0,message:"文件组名称不能为空",trigger:"blur"},{validator:function(t,i,s){/^[\u4e00-\u9fa5\w]{1,20}$/.test(i)?e.oldName!==e.temp.fileGroupName?function(e){var t=new URLSearchParams;return t.append("fileGroupName",e),Object(a.a)({url:"system/sysFileGroup/checkFileGroupName",method:"post",data:t})}(e.temp.fileGroupName).then(function(e){"0000"===e.data.code&&("success"===e.data.data?s():s(new Error("文件组名称已重复")))}):s():s(new Error("名称只允许数字、中文、字母及下划线"))},trigger:"blur"}],status:[{required:!0,message:"请选择状态",trigger:"change"}],fileGroupDescribe:[{validator:function(e,t,i){t&&t.length>150?i(new Error("描述的长度不能超过150个字符")):i()},trigger:"blur"}]}}},created:function(){this.initList()},methods:{handleFilter:function(){this.listQuery.page=1,this.initList()},selecteFileGroupStatus:function(e){this.listQuery.status=e},resetTemp:function(){this.temp={filegroupName:void 0,filegroupstatus:void 0,fileGroupDescribe:void 0}},handleCreate:function(){var e=this;this.resetTemp(),this.dialogStatus="新增文件组",this.fileGroupdialogFormVisible=!0,this.$nextTick(function(){e.$refs.temp.clearValidate()})},createFileGroupData:function(){var e=this;this.$refs.temp.validate(function(t){t&&(e.isDisabled=!0,function(e){return Object(a.a)({url:"system/sysFileGroup/add",method:"post",data:e})}(e.temp).then(function(t){"0000"===t.data.code?e.$message({message:"添加成功",type:"success"}):e.$message.error(t.data.result),e.isDisabled=!1,e.fileGroupdialogFormVisible=!1,e.$refs.temp.resetFields(),e.initList()}))})},handleUpdate:function(e){var t=this;this.temp.id=e.id,this.dialogStatus="编辑文件组",this.oldName=e.fileGroupName,this.temp.fileGroupDescribe=e.fileGroupDescribe,this.fileGroupdialogFormVisible=!0,this.temp.fileGroupName=e.fileGroupName,this.temp.status=parseInt(e.status),this.$nextTick(function(){t.$refs.temp.clearValidate()})},updateData:function(){var e=this;this.$refs.temp.validate(function(t){t&&(e.isDisabled=!0,function(e){return Object(a.a)({url:"system/sysFileGroup/update",method:"post",data:e})}(e.temp).then(function(t){"0000"===t.data.code?(console.log(t),e.$message({message:"编辑成功",type:"success"})):e.$message.error(t.data.result),e.isDisabled=!1,e.fileGroupdialogFormVisible=!1,e.initList()}))})},deleteFileGroup:function(e){var t=this;this.$confirm("此操作将永久删除这条数据, 是否继续?","删除提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){(function(e){var t=new URLSearchParams;return t.append("ids",e),Object(a.a)({url:"system/sysFileGroup/delete",method:"post",data:t})})(e).then(function(e){"0000"===e.data.code?(t.$message({message:"删除成功",type:"success"}),t.total%t.listQuery.rows==1&&(t.listQuery.page=t.listQuery.page-1),t.initList()):t.$message.error(e.data.result)})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},initList:function(){var e=this;this.listLoading=!0,function(e){return Object(a.a)({url:"system/sysFileGroup/list",method:"post",data:e})}(this.listQuery).then(function(t){"0000"===t.data.code?(e.fileGroupList=t.data.data.rows,e.total=t.data.data.total,0===e.fileGroupList.length&&e.total>0&&(e.listQuery.page=1,e.initList())):e.$message.error(t.data.result),e.listLoading=!1})},handleSizeChange:function(e){this.listQuery.rows=e,this.initList()},handleCurrentChange:function(e){this.listQuery.page=e,this.initList()}}},l=(i("3XEa"),i("KHd+")),r=Object(l.a)(s,function(){var e=this,t=e.$createElement,i=e._self._c||t;return i("div",{staticClass:"file-group-management"},[i("div",{staticClass:"filter-container"},[i("el-form",{attrs:{inline:!0,model:e.listQuery}},[i("el-form-item",{attrs:{label:"文件组名称:"}},[i("el-input",{staticClass:"filter-item",attrs:{placeholder:"请输入文件组名称",maxlenth:"20",clearable:""},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleFilter(t):null}},model:{value:e.listQuery.fileGroupName,callback:function(t){e.$set(e.listQuery,"fileGroupName",t)},expression:"listQuery.fileGroupName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"状态:"}},[i("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择",clearable:""},on:{change:e.selecteFileGroupStatus},model:{value:e.listQuery.status,callback:function(t){e.$set(e.listQuery,"status",t)},expression:"listQuery.status"}},e._l(e.statusOptions,function(e,t){return i("el-option",{key:t,attrs:{label:e,value:t}})}))],1),e._v(" "),i("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleFilter}},[e._v("搜索")]),e._v(" "),i("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.handleCreate}},[e._v("新增")])],1)],1),e._v(" "),i("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%"},attrs:{data:e.fileGroupList,border:"",fit:"","highlight-current-row":""}},[i("el-table-column",{attrs:{type:"index",align:"center",label:"序号",width:"60"}}),e._v(" "),i("el-table-column",{attrs:{label:"文件组名称",align:"center",prop:"fileGroupName"}}),e._v(" "),i("el-table-column",{attrs:{label:"创建时间",width:"150",align:"center",prop:"creationTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(e._f("parseTime")(t.row.createTime,"{y}-{m}-{d} {h}:{i}"))+"\n      ")]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"描述",prop:"fileGroupDescribe",align:"center"}}),e._v(" "),i("el-table-column",{attrs:{label:"状态",align:"center",prop:"status"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("span",{class:1==t.row.status?"text-green":"text-red"},[e._v(e._s(0==t.row.status?"未生效":"生效"))])]}}])}),e._v(" "),i("el-table-column",{attrs:{label:"操作",align:"center","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[i("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(i){e.handleUpdate(t.row)}}},[e._v("编辑")]),e._v(" "),i("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(i){e.deleteFileGroup(t.row.id)}}},[e._v("删除")])]}}])})],1),e._v(" "),i("el-pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],staticClass:"tablePagination",attrs:{"current-page":e.listQuery.page,"page-sizes":[10,20,30,40],"page-size":e.listQuery.rows,total:e.total,background:"",layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}}),e._v(" "),i("el-dialog",{attrs:{visible:e.fileGroupdialogFormVisible,title:e.dialogStatus,width:"400px"},on:{"update:visible":function(t){e.fileGroupdialogFormVisible=t}}},[i("el-form",{ref:"temp",attrs:{rules:e.rules,model:e.temp,"label-position":"right","label-width":"100px"}},[i("el-form-item",{attrs:{label:"文件组名称:",prop:"fileGroupName"}},[i("el-input",{attrs:{maxlength:"20",clearable:""},model:{value:e.temp.fileGroupName,callback:function(t){e.$set(e.temp,"fileGroupName","string"==typeof t?t.trim():t)},expression:"temp.fileGroupName"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"描述:",prop:"fileGroupDescribe"}},[i("el-input",{attrs:{type:"textarea",maxlength:"150",clearable:""},model:{value:e.temp.fileGroupDescribe,callback:function(t){e.$set(e.temp,"fileGroupDescribe","string"==typeof t?t.trim():t)},expression:"temp.fileGroupDescribe"}})],1),e._v(" "),i("el-form-item",{attrs:{label:"状态:",prop:"status"}},[i("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择"},model:{value:e.temp.status,callback:function(t){e.$set(e.temp,"status",t)},expression:"temp.status"}},e._l(e.statusOptions,function(e,t){return i("el-option",{key:t,attrs:{label:e,value:t}})}))],1)],1),e._v(" "),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer",align:"center"},slot:"footer"},[i("el-button",{attrs:{disabled:e.isDisabled,type:"primary"},on:{click:function(t){"新增文件组"===e.dialogStatus?e.createFileGroupData():e.updateData()}}},[e._v("提交")]),e._v(" "),i("el-button",{on:{click:function(t){e.fileGroupdialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1)},[],!1,null,null,null);r.options.__file="fileGroupManagement.vue";t.default=r.exports},MpLX:function(e,t,i){}}]);
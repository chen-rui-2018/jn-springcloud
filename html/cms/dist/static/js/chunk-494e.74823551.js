(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-494e"],{"4oo3":function(t,e,a){"use strict";var i=a("IwqE");a.n(i).a},IwqE:function(t,e,a){},TIBJ:function(t,e,a){"use strict";a.r(e);var i=a("FyfS"),l=a.n(i),s=a("P2sY"),n=a.n(s),o=a("t3Un");function r(t){return Object(o.a)({url:"system/sysUser/addSysUser",method:"post",data:t})}var u=a("ZySA"),c=a("7Qib"),d={name:"UserManagement",directives:{waves:u.a},filters:{statusFilter:function(t){return{0:"未生效",1:"生效"}[t]}},data:function(){return{tableKey:0,userList:null,total:null,listLoading:!0,listQuery:{page:1,rows:5,sort:"+id",status:void 0,position:void 0,departmentName:void 0,departmentId:void 0},userStatusOptions:["未生效","生效"],departmentOptions:[],positionOptions:["经理","美工","开发","推广","策划"],sortOptions:[{label:"ID Ascending",key:"+id"},{label:"ID Descending",key:"-id"}],temp:{name:void 0,account:void 0,status:void 0,email:void 0,phone:void 0,id:void 0},dialogFormVisible:!1,dialogStatus:"",dialogSectorVisible:!1,dialogRoleVisible:!1,addUserDialogRules:{name:[{required:!0,message:"用户名不能为空",trigger:"blur"},{validator:function(t,e,a){/[a-zA-Z]{1,20}|[\u4e00-\u9fa5]{1,10}/.test(e)?a():a(new Error("请输入正确的名字格式"))},trigger:"blur"}],account:[{required:!0,message:"账号不能为空",trigger:"blur"},{validator:function(t,e,a){/^[a-zA-Z0-9_-]{4,16}$/.test(e)?a():a(new Error("4到16位(字母，数字，下划线，减号)"))},trigger:"blur"}],status:[{required:!0,message:"状态不能为空",trigger:"change"}],email:[{required:!0,message:"邮箱不能为空",trigger:"blur"},{type:"email",message:"请输入正确格式的邮箱",trigger:"blur"}],phone:[{required:!0,message:"手机号不能为空",trigger:"blur"},{validator:function(t,e,a){/^1[34578]\d{9}$/.test(e)?a():a(new Error("请输入正确手机号码"))},trigger:"blur"}]},defaultProps:{children:"children",label:"label"},userPositionData:[{department:["test2","22","yizhi"],position:"美工",status:"default"},{department:"",position:"",status:void 0},{department:"",position:"",status:void 0}],departmentList:[{value:"zhinan",label:"指南",children:[{value:"shejiyuanze",label:"设计原则",children:[{value:"yizhi",label:"一致"},{value:"fankui",label:"反馈"},{value:"xiaolv",label:"效率"},{value:"kekong",label:"可控"}]}]},{value:"test2",label:"一级部门",children:[{value:"22",label:"二级部门",children:[{value:"yizhi",label:"三级部门"},{value:"fankui",label:"三级部门"}]}]}],data2:function(t){var e=[],a=["juese1","juese2","juese3","juese4","juese5","juese6","juese7"];return["角色一","角色二","角色三","角色四","角色五","角色六","角色七"].forEach(function(t,i){e.push({label:t,key:i,pinyin:a[i]})}),e}(),value2:[],filterMethod:function(t,e){return e.pinyin.indexOf(t)>-1}}},watch:{userPositionData:{handler:function(){var t=this.userPositionData.filter(function(t){return t.department&&t.position});this.userPositionData.length<t.length+2&&this.userPositionData.push({department:"",position:"",status:void 0})},deep:!0}},created:function(){this.getUserList(),this.getSysDepartmentAll()},methods:{selecteUserStatus:function(t){this.listQuery.userStatus=t},selecteDepartment:function(t){this.listQuery.department=t},getSysDepartmentAll:function(){var t=this;(function(t){return Object(o.a)({url:"system/sysDepartment/findSysDepartmentAll",method:"post",data:t})})().then(function(e){var a=e.data.data;t.departmentOptions=a})},getUserList:function(){var t=this;this.listLoading=!0,console.log(this.listQuery),function(t){return Object(o.a)({url:"system/sysUser/findSysUserByPage",method:"post",data:t})}(this.listQuery).then(function(e){var a=e.data.data;t.userList=a.rows,t.total=a.total,setTimeout(function(){t.listLoading=!1},500)})},handleSectorUpdate:function(t){this.dialogSectorVisible=!0},handleRoleUpdate:function(t){this.dialogRoleVisible=!0},handleFilter:function(){this.listQuery.page=1,this.getUserList()},handleSizeChange:function(t){this.listQuery.rows=t,this.getUserList()},handleCurrentChange:function(t){this.listQuery.page=t,this.getUserList()},handleModifyStatus:function(t,e){this.$message({message:"操作成功",type:"success"}),t.status=e},handleCreate:function(){var t=this;this.dialogStatus="create",this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs.dataForm.clearValidate()})},createUserData:function(){var t=this;this.$refs.dataForm.validate(function(e){e&&r(t.temp).then(function(){t.userList.unshift(t.temp),t.dialogFormVisible=!1,t.$notify({title:"成功",message:"新增用户成功",type:"success",duration:2e3})})})},handleUpdate:function(t){var e=this;this.temp=n()({},t),this.temp.timestamp=new Date(this.temp.timestamp),this.dialogStatus="update",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.dataForm.clearValidate()})},updateData:function(){var t=this;this.$refs.dataForm.validate(function(e){if(e){var a=n()({},t.temp);a.timestamp=+new Date(a.timestamp),r(a).then(function(){var e=!0,a=!1,i=void 0;try{for(var s,n=l()(t.userList);!(e=(s=n.next()).done);e=!0){var o=s.value;if(o.id===t.temp.id){var r=t.userList.indexOf(o);t.userList.splice(r,1,t.temp);break}}}catch(t){a=!0,i=t}finally{try{!e&&n.return&&n.return()}finally{if(a)throw i}}t.dialogFormVisible=!1,t.$notify({title:"成功",message:"更新成功",type:"success",duration:2e3})})}})},handleDelete:function(t){this.$notify({title:"成功",message:"删除成功",type:"success",duration:2e3});var e=this.userList.indexOf(t);this.userList.splice(e,1)},formatJson:function(t,e){return e.map(function(e){return t.map(function(t){return"timestamp"===t?Object(c.e)(e[t]):e[t]})})},setDefaultPosition:function(t,e){var a=t;this.userPositionData=this.userPositionData.map(function(t,e){return t.status=a===e?"default":void 0,t})}}},p=(a("4oo3"),a("KHd+")),m=Object(p.a)(d,function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"flex-box"},[a("div",{staticClass:"filter-container"},[a("el-form",{staticClass:"filter-bar",attrs:{inline:!0,model:t.listQuery}},[a("el-form-item",{attrs:{label:"姓名"}},[a("el-input",{staticClass:"filter-item",staticStyle:{width:"150px"},attrs:{placeholder:"请输入姓名",clearable:""},model:{value:t.listQuery.name,callback:function(e){t.$set(t.listQuery,"name",e)},expression:"listQuery.name"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"状态"}},[a("el-select",{staticClass:"filter-item",staticStyle:{width:"90px"},attrs:{placeholder:"请选择",clearable:""},on:{change:t.selecteUserStatus},model:{value:t.listQuery.status,callback:function(e){t.$set(t.listQuery,"status",e)},expression:"listQuery.status"}},t._l(t.userStatusOptions,function(t,e){return a("el-option",{key:t,attrs:{label:t,value:e}})}))],1),t._v(" "),a("el-form-item",{attrs:{label:"部门"}},[a("el-select",{staticClass:"filter-item",attrs:{multiple:"","collapse-tags":"",clearable:"",placeholder:"请选择"},on:{change:t.selecteDepartment},model:{value:t.listQuery.departmentId,callback:function(e){t.$set(t.listQuery,"departmentId",e)},expression:"listQuery.departmentId"}},t._l(t.departmentOptions,function(t){return a("el-option",{key:t,attrs:{label:t.departmentName,value:t.id}})}))],1),t._v(" "),a("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.handleFilter}},[t._v("搜索")]),t._v(" "),a("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-circle-plus-outline"},on:{click:t.handleCreate}},[t._v("新增用户")])],1)],1),t._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.listLoading,expression:"listLoading"}],key:t.tableKey,staticStyle:{width:"100%"},attrs:{data:t.userList,border:"",fit:"","highlight-current-row":""}},[a("el-table-column",{attrs:{label:"序列",type:"index",align:"center",width:"50"}}),t._v(" "),a("el-table-column",{attrs:{label:"姓名",prop:"name",align:"left",width:"100"}}),t._v(" "),a("el-table-column",{attrs:{label:"账号",prop:"account",align:"left",width:"130"}}),t._v(" "),a("el-table-column",{attrs:{label:"邮箱",prop:"email",align:"left",width:"200"}}),t._v(" "),a("el-table-column",{attrs:{label:"创建时间",prop:"createTime",align:"center",width:"150"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n        "+t._s(t._f("parseTime")(e.row.createTime,"{y}-{m}-{d} {h}:{i}"))+"\n      ")]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"部门",prop:"departmentName",align:"center",width:"65"}}),t._v(" "),a("el-table-column",{attrs:{label:"岗位",prop:"postName",align:"center",width:"65"}}),t._v(" "),a("el-table-column",{attrs:{label:"人员状态",prop:"status",align:"center",width:"65"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{class:1==e.row.status?"text-green":"text-red"},[t._v(t._s(t._f("statusFilter")(e.row.status)))])]}}])}),t._v(" "),a("el-table-column",{attrs:{fit:"",label:"操作",align:"center",width:"auto","min-width":"400"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){t.handleSectorUpdate(e.row)}}},[t._v("部门岗位")]),t._v(" "),a("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(a){t.handleRoleUpdate(e.row)}}},[t._v("角色")]),t._v(" "),a("el-button",{attrs:{type:"primary",size:"mini"}},[t._v("重置密码")]),t._v(" "),a("el-button",{attrs:{type:"primary",icon:"el-icon-edit",size:"mini"},on:{click:function(a){t.handleUpdate(e.row)}}}),t._v(" "),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete",size:"mini"},on:{click:function(a){t.handleDelete(e.row)}}})]}}])})],1),t._v(" "),a("div",{staticClass:"pagination-container"},[a("el-pagination",{directives:[{name:"show",rawName:"v-show",value:t.total>0,expression:"total>0"}],attrs:{"current-page":t.listQuery.page,"page-sizes":[5,10,20,30,50],"page-size":t.listQuery.rows,total:t.total,background:"",layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1),t._v(" "),a("el-dialog",{attrs:{visible:t.dialogFormVisible,title:"新增"},on:{"update:visible":function(e){t.dialogFormVisible=e}}},[a("el-form",{ref:"dataForm",staticStyle:{"max-width":"300px","margin-left":"20px"},attrs:{rules:t.addUserDialogRules,model:t.temp,"label-position":"left","label-width":"60px"}},[a("el-form-item",{attrs:{label:"账号",prop:"account"}},[a("el-input",{attrs:{maxLength:"20",clearable:""},model:{value:t.temp.account,callback:function(e){t.$set(t.temp,"account",e)},expression:"temp.account"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"姓名",prop:"name"}},[a("el-input",{attrs:{maxLength:"20",clearable:""},model:{value:t.temp.name,callback:function(e){t.$set(t.temp,"name",e)},expression:"temp.name"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"状态",prop:"status"}},[a("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择"},model:{value:t.temp.status,callback:function(e){t.$set(t.temp,"status",e)},expression:"temp.status"}},t._l(t.userStatusOptions,function(t,e){return a("el-option",{key:e,attrs:{label:t,value:e}})}))],1),t._v(" "),a("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[a("el-input",{attrs:{clearable:""},model:{value:t.temp.email,callback:function(e){t.$set(t.temp,"email",e)},expression:"temp.email"}})],1),t._v(" "),a("el-form-item",{attrs:{label:"手机",prop:"phone"}},[a("el-input",{attrs:{maxlength:"11",minlenght:"11",clearable:""},model:{value:t.temp.phone,callback:function(e){t.$set(t.temp,"phone",e)},expression:"temp.phone"}})],1)],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){"create"===t.dialogStatus?t.createUserData():t.updateData()}}},[t._v("确认")])],1)],1),t._v(" "),a("el-dialog",{staticClass:"sector-dialog",attrs:{visible:t.dialogSectorVisible,title:"部门岗位"},on:{"update:visible":function(e){t.dialogSectorVisible=e}}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.userPositionData,border:"",fit:""}},[a("el-table-column",{attrs:{label:"部门",align:"center",width:"280"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-cascader",{staticStyle:{width:"100%"},attrs:{options:t.departmentList,"change-on-select":""},model:{value:t.userPositionData[e.$index].department,callback:function(a){t.$set(t.userPositionData[e.$index],"department",a)},expression:"userPositionData[scope.$index].department"}})]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"岗位",align:"center",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-select",{attrs:{placeholder:"请选择"},model:{value:t.userPositionData[e.$index].position,callback:function(a){t.$set(t.userPositionData[e.$index],"position",a)},expression:"userPositionData[scope.$index].position"}},t._l(t.positionOptions,function(t,e){return a("el-option",{key:e,attrs:{label:t,value:t}})}))]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"默认",align:"center",width:"180"},scopedSlots:t._u([{key:"default",fn:function(e){return["default"===e.row.status?a("el-button",{attrs:{type:"success",size:"small"}},[t._v("默认岗位")]):"default"!==e.row.status&&e.row.department&&e.row.position?a("el-button",{attrs:{size:"small"},on:{click:function(a){t.setDefaultPosition(e.$index,e.row)}}},[t._v("设为默认岗位")]):t._e()]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.department&&e.row.position?a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){t.handleDelete(e.$index,e.row)}}},[t._v("删除")]):t._e()]}}])})],1),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogFormVisible=!1}}},[t._v("取消")]),t._v(" "),a("el-button",{attrs:{type:"primary"},on:{click:function(e){"create"===t.dialogStatus?t.createUserData():t.updateData()}}},[t._v("确认")])],1)],1),t._v(" "),a("el-dialog",{staticClass:"role-dialog",attrs:{visible:t.dialogRoleVisible,title:"角色"},on:{"update:visible":function(e){t.dialogRoleVisible=e}}},[a("el-transfer",{attrs:{"filter-method":t.filterMethod,titles:["角色列表","已选中角色"],data:t.data2,filterable:"","filter-placeholder":"请输入角色拼音"},model:{value:t.value2,callback:function(e){t.value2=e},expression:"value2"}}),t._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.dialogRoleVisible=!1}}},[t._v("取消")]),t._v(" "),a("el-button",{attrs:{type:"primary"}},[t._v("确认")])],1)],1)],1)},[],!1,null,null,null);m.options.__file="userManagement.vue";e.default=m.exports},ZySA:function(t,e,a){"use strict";var i=a("P2sY"),l=a.n(i),s=(a("jUE0"),{bind:function(t,e){t.addEventListener("click",function(a){var i=l()({},e.value),s=l()({ele:t,type:"hit",color:"rgba(0, 0, 0, 0.15)"},i),n=s.ele;if(n){n.style.position="relative",n.style.overflow="hidden";var o=n.getBoundingClientRect(),r=n.querySelector(".waves-ripple");switch(r?r.className="waves-ripple":((r=document.createElement("span")).className="waves-ripple",r.style.height=r.style.width=Math.max(o.width,o.height)+"px",n.appendChild(r)),s.type){case"center":r.style.top=o.height/2-r.offsetHeight/2+"px",r.style.left=o.width/2-r.offsetWidth/2+"px";break;default:r.style.top=(a.pageY-o.top-r.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",r.style.left=(a.pageX-o.left-r.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return r.style.backgroundColor=s.color,r.className="waves-ripple z-active",!1}},!1)}}),n=function(t){t.directive("waves",s)};window.Vue&&(window.waves=s,Vue.use(n)),s.install=n;e.a=s},jUE0:function(t,e,a){}}]);
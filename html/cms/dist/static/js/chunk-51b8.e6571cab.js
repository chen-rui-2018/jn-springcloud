(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-51b8"],{"+qEw":function(e,t,s){"use strict";var a=s("qTGP");s.n(a).a},YYlQ:function(e,t,s){"use strict";s.r(t);var a=s("t3Un");var r=s("P2sY"),i=s.n(r),o=(s("jUE0"),{bind:function(e,t){e.addEventListener("click",function(s){var a=i()({},t.value),r=i()({ele:e,type:"hit",color:"rgba(0, 0, 0, 0.15)"},a),o=r.ele;if(o){o.style.position="relative",o.style.overflow="hidden";var n=o.getBoundingClientRect(),l=o.querySelector(".waves-ripple");switch(l?l.className="waves-ripple":((l=document.createElement("span")).className="waves-ripple",l.style.height=l.style.width=Math.max(n.width,n.height)+"px",o.appendChild(l)),r.type){case"center":l.style.top=n.height/2-l.offsetHeight/2+"px",l.style.left=n.width/2-l.offsetWidth/2+"px";break;default:l.style.top=(s.pageY-n.top-l.offsetHeight/2-document.documentElement.scrollTop||document.body.scrollTop)+"px",l.style.left=(s.pageX-n.left-l.offsetWidth/2-document.documentElement.scrollLeft||document.body.scrollLeft)+"px"}return l.style.backgroundColor=r.color,l.className="waves-ripple z-active",!1}},!1)}}),n=function(e){e.directive("waves",o)};window.Vue&&(window.waves=o,Vue.use(n)),o.install=n;var l={name:"UserManagement",directives:{waves:o},filters:{statusFilter:function(e){return{0:"未生效",1:"生效"}[e]}},data:function(){var e=this;return{currentDepartmentIds:void 0,Visible:!0,isShow:!1,title:!0,departmentListLoading:!1,userPage:1,userRows:10,userTotal:null,userGroup:{userGroupdialogVisible:!1,userGroupLoading:!1,userGroupId:[],userGroupData:[]},roleIds:[],roleData:[],roleLoading:!1,roledialogVisible:!1,numberTotal:0,numberRows:10,numberPage:1,moveArr:0,isAbled:!1,passwordType:"password",isDisabled:!1,userId:void 0,checkedDepartment:void 0,addDialogTitle:"新增",tableKey:0,userList:null,total:null,listLoading:!0,sectorLoading:!0,listQuery:{page:1,rows:10,status:void 0,departmentId:void 0,position:void 0,departmentName:void 0,departmentIds:void 0},userStatusOptions:["未生效","生效"],positionOptions:[],temp:{name:void 0,account:void 0,status:"",email:void 0,phone:void 0,id:void 0,departmentId:void 0,postId:void 0},dialogFormVisible:!1,dialogStatus:"",dialogSectorVisible:!1,dialogResetPasswordVisible:!1,addUserDialogRules:{name:[{required:!0,message:"用户名不能为空",trigger:"blur"},{validator:function(e,t,s){/^[\u4e00-\u9fa5\w]{1,20}$/.test(t)?s():s(new Error("名称只允许数字、中文、字母及下划线"))},trigger:"blur"}],account:[{required:!0,message:"账号不能为空",trigger:"blur"},{validator:function(t,s,r){/[A-Za-z0-9]{6,16}$/.test(s)?"create"===e.dialogStatus?function(e){return Object(a.a)({url:"system/sysUser/checkUserName?account="+e,method:"post"})}(e.temp.account).then(function(e){"success"===e.data.data?r():r(new Error("账号已使用"))}):r():r(new Error("请输入6到16位长度字符的数字及字母"))},trigger:"blur"}],status:[{required:!0,message:"请选择状态",trigger:"change"}],email:[{required:!0,message:"邮箱不能为空",trigger:"blur"},{type:"email",message:"请输入正确格式的邮箱",trigger:"blur"}],phone:[{required:!0,message:"手机号不能为空",trigger:"blur"},{validator:function(e,t,s){/^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/.test(t)?s():s(new Error("请输入正确的手机号码"))},trigger:"blur"}],wechatAccount:[{required:!1,validator:function(e,t,s){""!==t?/^[a-zA-Z0-9][-_a-zA-Z0-9]{5,19}$/.test(t)?s():s(new Error("请输入6到20位字母或数字")):s()},trigger:"blur"}]},passwordRule:{password:[{required:!0,message:"密码不能为空",trigger:"blur"},{validator:function(e,t,s){/^[a-zA-Z0-9_!~&@]{6,16}$/.test(t)?s():s(new Error("请输入6到16位由字母或数字组成的密码"))},trigger:"blur"}]},defaultProps:{children:"children",label:"label"},userPositionData:[],departmentList:void 0,resetPassword:{id:"",password:""}}},computed:{userDepartmentPostList:function(){return{sysDepartmentPostList:this.userPositionData.map(function(e){var t=e.department;return e.departmentId=t[t.length-1],e.isDefault="default"===e.status?"1":"0",e.postId=e.position,e}),userId:this.userId}}},watch:{userPositionData:{handler:function(){console.log(this.userPositionData);var e=this.userPositionData.filter(function(e){return""!==e.department&&e.position});console.log(e),this.userPositionData.length<e.length+2&&this.userPositionData.push({department:[],position:"",status:void 0,postId:void 0})},deep:!0}},mounted:function(){this.getUserList(),this.getAllDepartment(),this.findSysPostAll()},methods:{handleChangeDepartment:function(e){this.temp.departmentId=this.currentDepartmentIds[this.currentDepartmentIds.length-1]},showDepartment:function(){this.title=!this.title,this.isShow=!this.isShow,this.isShow||(this.listQuery.page=1,this.listQuery.departmentId=void 0,this.getUserList())},handleNodeClick:function(e){this.listQuery.page=1,this.listQuery.departmentId=e.value,this.getUserList()},handleUserGroupChange:function(e,t,s){var r=this;console.log(e),this.userGroup.userGroupId=e,"left"===t?this.moveArr=-s.length:"right"===t&&(this.moveArr=s.length),function(e){return Object(a.a)({url:"system/sysUser/saveSysGroupToSysUser",method:"post",data:e})}({userId:this.userId,groupIds:e}).then(function(e){"0000"===e.data.code?r.$message({message:"授权成功",type:"success"}):r.$message.error(e.data.result)})},handleUserGroupCurrentChange:function(e){this.userTotal-this.moveArr>(e-1)*this.userRows?this.userPage=e:this.userPage=e-1,this.userGroup.userGroupLoading=!0,this.getUserGroup()},showUserGroupDialog:function(e){this.userPage=1,this.userGroup.userGroupLoading=!0,this.userId=e,this.userGroup.userGroupdialogVisible=!0,this.getUserGroup()},getUserGroup:function(){var e=this;(function(e){return Object(a.a)({url:"system/sysUser/findSysGroupByUserId",method:"post",data:e})})({userId:this.userId,page:this.userPage,rows:this.userRows}).then(function(t){var s=[],a=[];e.userTotal=t.data.data.total,t.data.data.rows.otherGroupList.forEach(function(e,t){s.push({label:e.groupName,key:e.groupId})}),t.data.data.rows.sysGroupOfUserList.forEach(function(e){a.push(e.groupId)}),e.userGroup.userGroupData=s,e.userGroup.userGroupId=a,e.userGroup.userGroupLoading=!1})},handleRoleCurrentChange:function(e){this.numberTotal-this.moveArr>(e-1)*this.numberRows?this.numberPage=e:this.numberPage=e-1,this.roledialogVisible=!0,this.getRole()},handleRoleChange:function(e,t,s){var r=this;this.roleIds=e,"left"===t?this.moveArr=-s.length:"right"===t&&(this.moveArr=s.length),function(e){return Object(a.a)({url:"system/sysUser/saveSysRoleToSysUser",method:"post",data:e})}({userId:this.userId,roleIds:e}).then(function(e){"0000"===e.data.code?r.$message({message:"授权成功",type:"success"}):r.$message.error(e.data.result)})},showRoleDialog:function(e){this.numberPage=1,this.roleLoading=!0,this.userId=e,this.roledialogVisible=!0,this.getRole()},getRole:function(){var e=this;(function(e){return Object(a.a)({url:"system/sysUser/findSysRoleByUserId",method:"post",data:e})})({userId:this.userId,page:this.numberPage,rows:this.numberRows}).then(function(t){if(console.log(t),"0000"===t.data.code){var s=[],a=[];e.numberTotal=t.data.data.total,t.data.data.rows.otherRoleList.forEach(function(e,t){s.push({label:e.roleName,key:e.id})}),t.data.data.rows.sysRoleOfUserList.forEach(function(e){a.push(e.id)}),e.roleData=s,e.roleIds=a,e.roleLoading=!1}else e.$message.error(t.data.result)})},showPwd:function(){"password"===this.passwordType?this.passwordType="":this.passwordType="password"},selecteUserStatus:function(e){this.listQuery.userStatus=e},getAllDepartment:function(){var e=this;this.departmentListLoading=!0,function(e){return Object(a.a)({url:"system/sysDepartment/findDepartmentAllByLevel",method:"post",data:e})}().then(function(t){"0000"===t.data.code?e.departmentList=t.data.data:e.$message.error(t.data.result),e.departmentListLoading=!1})},findSysPostAll:function(){var e=this;(function(e){return Object(a.a)({url:"system/sysPost/findSysPostAll",method:"post",data:e})})().then(function(t){if("0000"===t.data.code){var s=t.data.data;e.positionOptions=s.map(function(e){return{label:e.postName,value:e.id}})}else e.$message.error(t.data.result)})},getUserList:function(){var e=this;this.listLoading=!0,function(e){return Object(a.a)({url:"system/sysUser/findSysUserByPage",method:"post",data:e})}(this.listQuery).then(function(t){"0000"===t.data.code?(e.userList=t.data.data.rows,e.total=t.data.data.total,0===e.userList.length&&e.total>0&&(e.listQuery.page=1,e.getUserList())):e.$message.error(t.data.result),e.listLoading=!1})},handleSectorUpdata:function(e){var t=this;this.dialogSectorVisible=!0,this.userPositionData=[],this.sectorLoading=!0,this.userId=e.id,function(e){return Object(a.a)({url:"system/sysUser/findDepartmentandPostByUserId?userId="+e,method:"post"})}(e.id).then(function(e){if("0000"===e.data.code){t.sectorLoading=!1;var s=e.data.data;console.log(s);var a=[];s.map(function(e,t){var s=e.departmentId.split(",");a.push({department:s,position:e.postId,postId:e.postId,status:"1"===e.isDefault?"default":""})}),t.userPositionData=a}else t.$message.error(e.data.result)})},handleFilter:function(){this.listQuery.page=1,this.getUserList()},handleSizeChange:function(e){this.listQuery.rows=e,this.getUserList()},handleCurrentChange:function(e){this.listQuery.page=e,this.getUserList()},handleCreate:function(){var e=this;this.temp={account:"",name:"",phone:"",email:"",status:"",wechatAccount:void 0},this.Visible=!0,this.isAbled=!1,this.dialogStatus="create",this.addDialogTitle="新增",this.dialogFormVisible=!0,this.$nextTick(function(){e.$refs.dataForm.clearValidate()})},createUserData:function(){var e=this;this.$refs.dataForm.validate(function(t){t&&(e.isDisabled=!0,function(e){return Object(a.a)({url:"system/sysUser/addSysUser",method:"post",data:e})}(e.temp).then(function(t){"0000"===t.data.code?(e.$message({message:"新增用户成功",type:"success"}),e.dialogFormVisible=!1,e.$refs.dataForm.resetFields(),e.currentDepartmentIds=[],e.getUserList()):e.$message.error(t.data.result),e.isDisabled=!1}))})},handleUpdate:function(e){var t=this;this.Visible=!1,this.isAbled=!0,this.dialogStatus="update",this.addDialogTitle="编辑",this.temp.account=e.account,this.temp.id=e.id,this.temp.name=e.name,this.temp.email=e.email,this.temp.phone=e.phone,this.temp.wechatAccount=e.wechatAccount,this.temp.status=parseInt(e.status),this.dialogFormVisible=!0,this.$nextTick(function(){t.$refs.dataForm.clearValidate()})},updateData:function(){var e=this;this.$refs.dataForm.validate(function(t){t&&(e.isDisabled=!0,function(e){return Object(a.a)({url:"system/sysUser/updateSysUser",method:"post",data:e})}(e.temp).then(function(t){"0000"===t.data.code?(e.$message({message:"编辑成功",type:"success"}),e.getUserList(),e.dialogFormVisible=!1):e.$message.error(t.data.result),e.isDisabled=!1}))})},handleDelete:function(e){var t=this;this.$confirm("此操作将永久删除这条数据, 是否继续?","删除提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){(function(e){return Object(a.a)({url:"system/sysUser/deleteSysUser",method:"post",data:e})})({userIds:[e.id]}).then(function(e){"0000"===e.data.code?(t.$message({message:"删除成功",type:"success"}),t.total%t.listQuery.rows==1&&(t.listQuery.page=t.listQuery.page-1),t.getUserList()):t.$message.error(e.data.result)})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},setDefaultPosition:function(e,t){var s=e;this.userPositionData=this.userPositionData.map(function(e,t){return e.status=s===t?"default":void 0,e})},saveDepartmentandPostOfUser:function(){var e=this,t=this.userDepartmentPostList,s=t.sysDepartmentPostList.filter(function(e){return console.log(e),e.department&&e.position});if(console.log(s),t.sysDepartmentPostList=s,t.sysDepartmentPostList.length>0){var r=0;t.sysDepartmentPostList.forEach(function(e,t){"1"===e.isDefault&&(r+=1)}),1!==r&&(t.sysDepartmentPostList[0].isDefault="1")}(function(e){return Object(a.a)({url:"system/sysUser/saveDepartmentandPostOfUser",method:"post",data:e})})(t).then(function(t){"0000"===t.data.code?e.$message({message:"修改部门和岗位成功",type:"success"}):e.$message.error(t.data.result),e.dialogSectorVisible=!1,e.getUserList()})},handleUserSectorDelete:function(e,t){this.userPositionData.splice(e,1,{department:[],position:"",status:void 0,postId:void 0})},handleResetPasswordDialog:function(e){var t=this;this.dialogResetPasswordVisible=!0,this.resetPassword.id=e.id,this.resetPassword.password="",this.$nextTick(function(){t.$refs.resetPassword.clearValidate()})},handlerResetPassword:function(){var e=this;this.$refs.resetPassword.validate(function(t){t&&function(e){return Object(a.a)({url:"system/sysUser/updateSysUser",method:"post",data:e})}(e.resetPassword).then(function(t){"0000"===t.data.code?(e.dialogResetPasswordVisible=!1,e.$message({message:"重置密码成功",type:"success"})):e.$message.error(t.data.result)})})}}},u=(s("+qEw"),s("KHd+")),d=Object(u.a)(l,function(){var e=this,t=e.$createElement,s=e._self._c||t;return s("div",{staticClass:"flex-box-cloumn"},[s("el-row",[s("el-col",{attrs:{span:3}},[s("el-button",{staticClass:"filter-item",on:{click:function(t){e.showDepartment()}}},[e._v(e._s(e.title?"显示部门":"全部用户"))])],1),e._v(" "),s("el-col",{attrs:{span:21}},[s("div",{staticClass:"filter-container"},[s("el-form",{staticClass:"filter-bar",attrs:{inline:!0,model:e.listQuery}},[s("el-form-item",{attrs:{label:"姓名"}},[s("el-input",{staticClass:"filter-item",staticStyle:{width:"150px"},attrs:{maxlength:"20",placeholder:"请输入姓名",clearable:""},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleFilter(t):null}},model:{value:e.listQuery.name,callback:function(t){e.$set(e.listQuery,"name",t)},expression:"listQuery.name"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"状态"}},[s("el-select",{staticClass:"filter-item",staticStyle:{width:"150px"},attrs:{placeholder:"请选择",clearable:""},on:{change:e.selecteUserStatus},model:{value:e.listQuery.status,callback:function(t){e.$set(e.listQuery,"status",t)},expression:"listQuery.status"}},e._l(e.userStatusOptions,function(e,t){return s("el-option",{key:e,attrs:{label:e,value:t}})}))],1),e._v(" "),s("el-button",{directives:[{name:"waves",rawName:"v-waves"}],staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleFilter}},[e._v("搜索")]),e._v(" "),s("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary"},on:{click:e.handleCreate}},[e._v("新增用户")]),e._v(" "),s("el-button",{staticClass:"filter-item",attrs:{type:"primary"}},[e._v("导出")])],1)],1)])],1),e._v(" "),s("div",{staticClass:"userManagement-content"},[e.isShow?s("div",{staticClass:"userManagement-content-left"},[s("el-tree",{directives:[{name:"loading",rawName:"v-loading",value:e.departmentListLoading,expression:"departmentListLoading"}],attrs:{data:e.departmentList,"expand-on-click-node":!1,props:e.defaultProps},on:{"node-click":e.handleNodeClick}})],1):e._e(),e._v(" "),s("div",{staticClass:"userManagement-content-right"},[s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],key:e.tableKey,staticStyle:{width:"100%"},attrs:{data:e.userList,border:"",fit:"","highlight-current-row":""}},[s("el-table-column",{attrs:{label:"序列",type:"index",align:"center",width:"60"}}),e._v(" "),s("el-table-column",{attrs:{label:"账号",prop:"account",align:"center","min-width":"100"}}),e._v(" "),s("el-table-column",{attrs:{label:"姓名",prop:"name",align:"center","min-width":"100"}}),e._v(" "),s("el-table-column",{attrs:{label:"邮箱",prop:"email",align:"center","min-width":"150"}}),e._v(" "),s("el-table-column",{attrs:{label:"手机",prop:"phone",align:"center","min-width":"120"}}),e._v(" "),s("el-table-column",{attrs:{label:"微信",prop:"wechatAccount",align:"center","min-width":"120"}}),e._v(" "),s("el-table-column",{attrs:{label:"创建时间",prop:"createTime",align:"center","min-width":"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n            "+e._s(e._f("parseTime")(t.row.createTime,"{y}-{m}-{d} {h}:{i}"))+"\n          ")]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"部门",prop:"departmentName",align:"center","min-width":"100"}}),e._v(" "),s("el-table-column",{attrs:{label:"岗位",prop:"postName",align:"center","min-width":"85"}}),e._v(" "),s("el-table-column",{attrs:{label:"状态",prop:"status",align:"center","min-width":"70"},scopedSlots:e._u([{key:"default",fn:function(t){return[s("span",{class:1==t.row.status?"text-green":"text-red"},[e._v(e._s(e._f("statusFilter")(t.row.status)))])]}}])}),e._v(" "),s("el-table-column",{attrs:{fit:"",label:"操作",align:"center",width:"auto","min-width":"560"},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(s){e.handleSectorUpdata(t.row)}}},[e._v("部门岗位")]),e._v(" "),s("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(s){e.showRoleDialog(t.row.id)}}},[e._v("授权角色")]),e._v(" "),s("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(s){e.showUserGroupDialog(t.row.id)}}},[e._v("授权用户组")]),e._v(" "),s("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(s){e.handleResetPasswordDialog(t.row)}}},[e._v("重置密码")]),e._v(" "),s("el-button",{attrs:{type:"primary",icon:"el-icon-edit",size:"mini"},on:{click:function(s){e.handleUpdate(t.row)}}}),e._v(" "),s("el-button",{attrs:{type:"danger",icon:"el-icon-delete",size:"mini"},on:{click:function(s){e.handleDelete(t.row)}}})]}}])})],1),e._v(" "),s("div",{staticClass:"pagination-container"},[s("el-pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],attrs:{"current-page":e.listQuery.page,"page-sizes":[10,20,30,50],"page-size":e.listQuery.rows,total:e.total,background:"",layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}})],1)],1)]),e._v(" "),s("el-dialog",{staticClass:"addUser",attrs:{visible:e.dialogFormVisible,title:e.addDialogTitle,width:"450px"},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[s("el-form",{ref:"dataForm",staticStyle:{"max-width":"320px","margin-left":"20px"},attrs:{rules:e.addUserDialogRules,model:e.temp,"label-position":"right","label-width":"80px"}},[s("el-form-item",{attrs:{label:"账号",prop:"account"}},[s("el-input",{attrs:{disabled:e.isAbled,maxlength:"16",clearable:""},model:{value:e.temp.account,callback:function(t){e.$set(e.temp,"account",t)},expression:"temp.account"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"姓名",prop:"name"}},[s("el-input",{attrs:{maxlength:"20",clearable:""},model:{value:e.temp.name,callback:function(t){e.$set(e.temp,"name","string"==typeof t?t.trim():t)},expression:"temp.name"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"状态",prop:"status"}},[s("el-select",{staticClass:"filter-item",staticStyle:{"max-width":"280px"},attrs:{placeholder:"请选择"},model:{value:e.temp.status,callback:function(t){e.$set(e.temp,"status",t)},expression:"temp.status"}},e._l(e.userStatusOptions,function(e,t){return s("el-option",{key:t,attrs:{label:e,value:t}})}))],1),e._v(" "),s("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[s("el-input",{attrs:{clearable:""},model:{value:e.temp.email,callback:function(t){e.$set(e.temp,"email",t)},expression:"temp.email"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"手机",prop:"phone"}},[s("el-input",{attrs:{maxlength:"11",minlenght:"11",clearable:""},model:{value:e.temp.phone,callback:function(t){e.$set(e.temp,"phone",t)},expression:"temp.phone"}})],1),e._v(" "),s("el-form-item",{attrs:{label:"微信",prop:"wechatAccount"}},[s("el-input",{attrs:{maxlength:"20",clearable:""},model:{value:e.temp.wechatAccount,callback:function(t){e.$set(e.temp,"wechatAccount",t)},expression:"temp.wechatAccount"}})],1),e._v(" "),e.Visible?s("el-form-item",{attrs:{label:"部门"}},[s("el-cascader",{attrs:{options:e.departmentList,"change-on-select":"",placeholder:"请选择",clearable:""},on:{change:e.handleChangeDepartment},model:{value:e.currentDepartmentIds,callback:function(t){e.currentDepartmentIds=t},expression:"currentDepartmentIds"}})],1):e._e(),e._v(" "),e.Visible?s("el-form-item",{attrs:{label:"岗位"}},[s("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择",clearable:""},model:{value:e.temp.postId,callback:function(t){e.$set(e.temp,"postId",t)},expression:"temp.postId"}},e._l(e.positionOptions,function(e,t){return s("el-option",{key:t,attrs:{label:e.label,value:e.value}})}))],1):e._e()],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{disabled:e.isDisabled,type:"primary"},on:{click:function(t){"create"===e.dialogStatus?e.createUserData():e.updateData()}}},[e._v("确认")]),e._v(" "),s("el-button",{on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),s("el-dialog",{staticClass:"sector-dialog",attrs:{visible:e.dialogSectorVisible,title:"部门岗位"},on:{"update:visible":function(t){e.dialogSectorVisible=t}}},[s("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.sectorLoading,expression:"sectorLoading"}],staticStyle:{width:"100%"},attrs:{data:e.userPositionData,border:"",fit:""}},[s("el-table-column",{attrs:{label:"部门",align:"center",width:"280"},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-cascader",{staticStyle:{width:"100%"},attrs:{options:e.departmentList,placeholder:"请选择部门","change-on-select":""},model:{value:e.userPositionData[t.$index].department,callback:function(s){e.$set(e.userPositionData[t.$index],"department",s)},expression:"userPositionData[scope.$index].department"}})]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"岗位",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return[s("el-select",{attrs:{placeholder:"请选择"},model:{value:e.userPositionData[t.$index].position,callback:function(s){e.$set(e.userPositionData[t.$index],"position",s)},expression:"userPositionData[scope.$index].position"}},e._l(e.positionOptions,function(e,t){return s("el-option",{key:t,attrs:{label:e.label,value:e.value}})}))]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"默认",align:"center",width:"180"},scopedSlots:e._u([{key:"default",fn:function(t){return["default"===t.row.status?s("el-button",{attrs:{type:"success",size:"small"}},[e._v("默认岗位")]):"default"!==t.row.status&&t.row.department&&t.row.position?s("el-button",{attrs:{size:"small"},on:{click:function(s){e.setDefaultPosition(t.$index,t.row)}}},[e._v("设为默认岗位")]):e._e()]}}])}),e._v(" "),s("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:e._u([{key:"default",fn:function(t){return[t.row.department&&t.row.position?s("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(s){e.handleUserSectorDelete(t.$index,t.row)}}},[e._v("删除")]):e._e()]}}])})],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:function(t){e.saveDepartmentandPostOfUser()}}},[e._v("提交")]),e._v(" "),s("el-button",{on:{click:function(t){e.dialogSectorVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),s("el-dialog",{staticClass:"roleBox",attrs:{visible:e.roledialogVisible,title:"授权角色",width:"800px"},on:{"update:visible":function(t){e.roledialogVisible=t}}},[s("el-transfer",{directives:[{name:"loading",rawName:"v-loading",value:e.roleLoading,expression:"roleLoading"}],staticClass:"box",attrs:{data:e.roleData,titles:["其他角色","用户拥有角色"],filterable:"","filter-placeholder":"请输入角色名称"},on:{change:e.handleRoleChange},model:{value:e.roleIds,callback:function(t){e.roleIds=t},expression:"roleIds"}},[s("span",{attrs:{slot:"left-footer",size:"small"},slot:"left-footer"},[s("el-pagination",{attrs:{"current-page":e.numberPage,"pager-count":5,total:e.numberTotal,background:"",layout:"prev, pager, next"},on:{"current-change":e.handleRoleCurrentChange}})],1),e._v(" "),s("span",{attrs:{slot:"right-footer",size:"small"},slot:"right-footer"})])],1),e._v(" "),s("el-dialog",{attrs:{visible:e.dialogResetPasswordVisible,title:"重置密码",width:"400px"},on:{"update:visible":function(t){e.dialogResetPasswordVisible=t}}},[s("el-form",{ref:"resetPassword",attrs:{model:e.resetPassword,rules:e.passwordRule,"label-width":"50px"}},[s("el-form-item",{attrs:{label:"密码",prop:"password"}},[s("el-input",{attrs:{type:e.passwordType,maxlength:"16"},model:{value:e.resetPassword.password,callback:function(t){e.$set(e.resetPassword,"password",t)},expression:"resetPassword.password"}}),e._v(" "),s("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[s("svg-icon",{attrs:{"icon-class":"eye"}})],1)],1)],1),e._v(" "),s("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[s("el-button",{attrs:{type:"primary"},on:{click:e.handlerResetPassword}},[e._v("重置密码")]),e._v(" "),s("el-button",{on:{click:function(t){e.dialogResetPasswordVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),s("el-dialog",{staticClass:"groupBox",attrs:{visible:e.userGroup.userGroupdialogVisible,title:"授权用户组",width:"800px"},on:{"update:visible":function(t){e.$set(e.userGroup,"userGroupdialogVisible",t)}}},[s("el-transfer",{directives:[{name:"loading",rawName:"v-loading",value:e.userGroup.userGroupLoading,expression:"userGroup.userGroupLoading"}],staticClass:"box",attrs:{data:e.userGroup.userGroupData,titles:["其他用户组","用户拥有用户组"],filterable:"","filter-placeholder":"请输入用户组名称"},on:{change:e.handleUserGroupChange},model:{value:e.userGroup.userGroupId,callback:function(t){e.$set(e.userGroup,"userGroupId",t)},expression:"userGroup.userGroupId"}},[s("span",{attrs:{slot:"left-footer",size:"small"},slot:"left-footer"},[s("el-pagination",{attrs:{"current-page":e.userPage,"pager-count":5,total:e.userTotal,background:"",layout:"prev, pager, next"},on:{"current-change":e.handleUserGroupCurrentChange}})],1),e._v(" "),s("span",{attrs:{slot:"right-footer",size:"small"},slot:"right-footer"})])],1)],1)},[],!1,null,null,null);d.options.__file="userManagement.vue";t.default=d.exports},jUE0:function(e,t,s){},qTGP:function(e,t,s){}}]);
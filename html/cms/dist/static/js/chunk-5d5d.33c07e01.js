(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-5d5d"],{"1i+E":function(e,t,r){"use strict";r.r(t);var s=r("t3Un");var a={data:function(){var e=this;return{isDisabled:!1,authorityPage:1,authorityRows:10,authorityData:[],authorityIds:[],authorityLoading:!1,authorityTotal:void 0,authoritydialogVisible:!1,userGroup:{userGroupdialogVisible:!1,userGroupLoading:!1,userGroupId:[],userGroupData:[]},moveArr:0,oldOwnUser:[],roleId:void 0,userPage:1,userRows:10,userTotal:null,userLoading:!1,oldRoleName:void 0,dialogStatus:void 0,rolelistLoading:!1,listQuery:{roleName:void 0,status:void 0,rows:10,page:1},statusOptions:["未生效","生效"],total:0,userId:[],roleList:[],userData:[],roledialogFormVisible:!1,userdialogVisible:!1,roleform:{id:"",roleName:void 0,status:void 0},rules:{roleName:[{required:!0,message:"请输入用户组名称",trigger:"blur"},{validator:function(t,r,a){/^[\u4e00-\u9fa5\w]{1,20}$/.test(r)?e.oldRoleName!==e.roleform.roleName?function(e){var t=new URLSearchParams;return t.append("roleName",e),Object(s.a)({url:"system/sysRole/checkRoleName",method:"post",data:t})}(e.roleform.roleName).then(function(e){"success"===e.data.data?a():a(new Error("角色名称已重复"))}):a():a(new Error("名称只允许数字、中文、字母及下划线"))},trigger:"blur"}],status:[{required:!0,message:"请选择状态",trigger:"change"}]}}},created:function(){this.initList()},methods:{handleAuthorityCurrentChange:function(e){this.authorityTotal-this.moveArr>(e-1)*this.authorityRows?this.authorityPage=e:this.authorityPage=e-1,this.authoritydialogVisible=!0,this.getAuthority()},handleAuthorityChange:function(e,t,r){var a=this;this.authorityIds=e,"left"===t?this.moveArr=-r.length:"right"===t&&(this.moveArr=r.length),function(e){return Object(s.a)({url:"system/sysRole/rolePermissionAuthorization",method:"post",data:e})}({roleId:this.roleId,permissionId:e}).then(function(e){"0000"===e.data.code?a.$message({message:"授权成功",type:"success"}):a.$message.error(e.data.result),a.initList()})},showAuthorityDialog:function(e){this.authorityPage=1,this.authorityLoading=!0,this.roleId=e,this.authoritydialogVisible=!0,this.getAuthority()},getAuthority:function(){var e=this;(function(e){return Object(s.a)({url:"system/sysRole/findPermissionOrRoleAndOtherPermission",method:"post",data:e})})({roleId:this.roleId,page:this.authorityPage,rows:this.authorityRows}).then(function(t){if("0000"===t.data.code){var r=[],s=[];e.authorityTotal=t.data.data.total,t.data.data.rows.otherPermissionList.forEach(function(e,t){r.push({label:e.permissionName,key:e.id})}),t.data.data.rows.permissionOfRoleList.forEach(function(e){s.push(e.id)}),e.authorityData=r,e.authorityIds=s}else e.$message.error(t.data.result);e.authorityLoading=!1})},handleUserGroupChange:function(e,t,r){var a=this;this.userGroup.userGroupId=e,"left"===t?this.moveArr=-r.length:"right"===t&&(this.moveArr=r.length),function(e){return Object(s.a)({url:"/system/sysRole/userGroupRoleAuthorization",method:"post",data:e})}({roleId:this.roleId,userGroupId:e}).then(function(e){"0000"===e.data.code?a.$message({message:"授权成功",type:"success"}):a.$message.error(e.data.result)})},handleUserGroupCurrentChange:function(e){this.userTotal-this.moveArr>(e-1)*this.userRows?this.userPage=e:this.userPage=e-1,this.userGroup.userGroupLoading=!0,this.getUserGroup()},showUserGroupDialog:function(e){this.userPage=1,this.userGroup.userGroupLoading=!0,this.roleId=e,this.userGroup.userGroupdialogVisible=!0,this.getUserGroup()},getUserGroup:function(){var e=this;(function(e){return Object(s.a)({url:"system/sysRole/findUserGroupOfRoleAndOtherGroup",method:"post",data:e})})({roleId:this.roleId,page:this.userPage,rows:this.userRows}).then(function(t){if("0000"===t.data.code){var r=[],s=[];e.userTotal=t.data.data.total,t.data.data.rows.otherUserGroupList.forEach(function(e,t){r.push({label:e.groupName,key:e.groupId})}),t.data.data.rows.userGroupOfRoleList.forEach(function(e){s.push(e.groupId)}),e.userGroup.userGroupData=r,e.userGroup.userGroupId=s}else e.$message.error(t.data.result);e.userGroup.userGroupLoading=!1})},getUser:function(){var e=this;(function(e){return Object(s.a)({url:"system/sysRole/findUserOfRoleAndOtherUser",method:"post",data:e})})({roleId:this.roleId,page:this.userPage,rows:this.userRows}).then(function(t){if("0000"===t.data.code){t.data.data.rows.userOfRoleList.forEach(function(t){e.oldOwnUser.push(t.id)});var r=[],s=[];e.userTotal=t.data.data.total,t.data.data.rows.otherUserList.forEach(function(e,t){r.push({label:e.name,key:e.id})}),t.data.data.rows.userOfRoleList.forEach(function(e,t){s.push(e.id)}),e.userData=r,e.userId=s}else e.$message.error(t.data.result);e.userLoading=!1})},handleUserCurrentChange:function(e){this.userTotal-this.moveArr>(e-1)*this.userRows?this.userPage=e:this.userPage=e-1,this.userLoading=!0,this.getUser()},handleUserChange:function(e,t,r){var a=this;this.userId=e,"left"===t?this.moveArr=-r.length:"right"===t&&(this.moveArr=r.length),function(e){return Object(s.a)({url:"system/sysRole/userRoleAuthorization",method:"post",data:e})}({roleId:this.roleId,userId:e}).then(function(e){"0000"===e.data.code?a.$message({message:"授权成功",type:"success"}):a.$message.error(e.data.result),a.initList()})},showUserDialog:function(e){this.userPage=1,this.userLoading=!0,this.roleId=e,this.userdialogVisible=!0,this.getUser()},resetuserGroupform:function(){this.roleform={roleName:void 0,status:void 0}},handleUpdate:function(e){var t=this;this.roledialogFormVisible=!0,this.dialogStatus="编辑角色",this.oldRoleName=e.roleName,this.roleform.roleName=e.roleName,this.roleform.status=parseInt(e.status),this.roleform.id=e.roleId,this.$nextTick(function(){t.$refs.roleform.clearValidate()})},updateData:function(){var e=this;this.$refs.roleform.validate(function(t){t&&(e.isDisabled=!0,function(e){return Object(s.a)({url:"system/sysRole/update",method:"post",data:e})}(e.roleform).then(function(t){"0000"===t.data.code?e.$message({message:"编辑成功",type:"success"}):e.$message.error(t.data.result),e.isDisabled=!1,e.$refs.roleform.resetFields(),e.roledialogFormVisible=!1,e.initList()}))})},createUserData:function(){var e=this;this.$refs.roleform.validate(function(t){t&&(e.isDisabled=!0,console.log(e.roleform),function(e){return Object(s.a)({url:"system/sysRole/add",method:"post",data:e})}(e.roleform).then(function(t){console.log(t),"0000"===t.data.code?e.$message({message:"添加成功",type:"success"}):e.$message.error(t.data.result),e.isDisabled=!1,e.$refs.roleform.resetFields(),e.roledialogFormVisible=!1,e.initList()}))})},handleCreate:function(){var e=this;this.resetuserGroupform(),this.dialogStatus="新增角色",this.roledialogFormVisible=!0,this.$nextTick(function(){e.$refs.roleform.clearValidate()})},selecteUserStatus:function(e){this.listQuery.status=e},handleFilter:function(){this.listQuery.page=1,this.initList()},deleteRole:function(e){var t=this;this.$confirm("此操作将永久删除这条数据, 是否继续?","删除提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){(function(e){var t=new URLSearchParams;return t.append("ids",e),Object(s.a)({url:"system/sysRole/delete",method:"post",data:t})})(e).then(function(e){"0000"===e.data.code?(t.$message({message:"删除成功",type:"success"}),t.total%t.listQuery.rows==1&&(t.listQuery.page=t.listQuery.page-1),t.initList()):t.$message.error(e.data.result)})}).catch(function(){t.$message({type:"info",message:"已取消删除"})})},initList:function(){var e=this;this.rolelistLoading=!0,function(e){return Object(s.a)({url:"system/sysRole/list",method:"post",data:e})}(this.listQuery).then(function(t){"0000"===t.data.code?(e.roleList=t.data.data.rows,e.total=t.data.data.total,0===e.roleList.length&&e.total>0&&(e.listQuery.page=1,e.initList())):e.$message.error(t.data.result),e.rolelistLoading=!1})},handleSizeChange:function(e){this.listQuery.rows=e,this.initList()},handleCurrentChange:function(e){this.listQuery.page=e,this.initList()}}},o=(r("Qp9A"),r("KHd+")),i=Object(o.a)(a,function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"rolemanagement"},[r("div",{staticClass:"filter-container"},[r("el-form",{attrs:{inline:!0,model:e.listQuery}},[r("el-form-item",{attrs:{label:"角色名称:"}},[r("el-input",{staticClass:"filter-item",attrs:{placeholder:"请输入名称",maxlength:"20",clearable:""},nativeOn:{keyup:function(t){return"button"in t||!e._k(t.keyCode,"enter",13,t.key,"Enter")?e.handleFilter(t):null}},model:{value:e.listQuery.roleName,callback:function(t){e.$set(e.listQuery,"roleName",t)},expression:"listQuery.roleName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"状态:"}},[r("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择",clearable:""},on:{change:e.selecteUserStatus},model:{value:e.listQuery.status,callback:function(t){e.$set(e.listQuery,"status",t)},expression:"listQuery.status"}},e._l(e.statusOptions,function(e,t){return r("el-option",{key:e,attrs:{label:e,value:t}})}))],1),e._v(" "),r("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"},on:{click:e.handleFilter}},[e._v("搜索")]),e._v(" "),r("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-plus"},on:{click:e.handleCreate}},[e._v("新增")])],1)],1),e._v(" "),r("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.rolelistLoading,expression:"rolelistLoading"}],staticStyle:{width:"100%",height:"100%"},attrs:{data:e.roleList,border:"",fit:"","highlight-current-row":""}},[r("el-table-column",{attrs:{type:"index",align:"center",label:"序号",width:"60"}}),e._v(" "),r("el-table-column",{attrs:{label:"角色名称",align:"center",prop:"roleName"}}),e._v(" "),r("el-table-column",{attrs:{"show-overflow-tooltip":!0,label:"拥有用户",align:"center","min-width":"100",prop:"sysUserRoles"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.sysUserRoles.join("、"))+"\n    ")]}}])}),e._v(" "),r("el-table-column",{attrs:{"show-overflow-tooltip":!0,label:"权限",align:"center",prop:"sysRolePermissions","min-width":"100"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(t.row.sysRolePermissions.join("、"))+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{label:"创建时间",width:"150",align:"center",prop:"creationTime"},scopedSlots:e._u([{key:"default",fn:function(t){return[e._v("\n        "+e._s(e._f("parseTime")(t.row.createTime,"{y}-{m}-{d} {h}:{i}"))+"\n      ")]}}])}),e._v(" "),r("el-table-column",{attrs:{label:"状态",align:"center",prop:"status"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("span",{class:1==t.row.status?"text-green":"text-red"},[e._v(e._s(0==t.row.status?"未生效":"生效"))])]}}])}),e._v(" "),r("el-table-column",{attrs:{label:"操作",align:"center","min-width":"400","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(t){return[r("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(r){e.handleUpdate(t.row)}}},[e._v("编辑")]),e._v(" "),r("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(r){e.showUserDialog(t.row.roleId)}}},[e._v("授权用户")]),e._v(" "),r("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(r){e.showUserGroupDialog(t.row.roleId)}}},[e._v("授权用户组")]),e._v(" "),r("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(r){e.showAuthorityDialog(t.row.roleId)}}},[e._v("授权权限")]),e._v(" "),r("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(r){e.deleteRole(t.row.roleId)}}},[e._v("删除")])]}}])})],1),e._v(" "),r("el-pagination",{directives:[{name:"show",rawName:"v-show",value:e.total>0,expression:"total>0"}],staticClass:"tablePagination",attrs:{"current-page":e.listQuery.page,"page-sizes":[10,20,30,40],"page-size":e.listQuery.rows,total:e.total,background:"",layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}}),e._v(" "),r("el-dialog",{attrs:{visible:e.roledialogFormVisible,title:e.dialogStatus,width:"400px"},on:{"update:visible":function(t){e.roledialogFormVisible=t}}},[r("el-form",{ref:"roleform",staticStyle:{"max-width":"300px","margin-left":"20px"},attrs:{rules:e.rules,model:e.roleform,"label-position":"right","label-width":"80px"}},[r("el-form-item",{attrs:{label:"名称:",prop:"roleName"}},[r("el-input",{attrs:{maxlength:"20"},model:{value:e.roleform.roleName,callback:function(t){e.$set(e.roleform,"roleName",t)},expression:"roleform.roleName"}})],1),e._v(" "),r("el-form-item",{attrs:{label:"状态:",prop:"status"}},[r("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择"},model:{value:e.roleform.status,callback:function(t){e.$set(e.roleform,"status",t)},expression:"roleform.status"}},e._l(e.statusOptions,function(e,t){return r("el-option",{key:t,attrs:{label:e,value:t}})}))],1)],1),e._v(" "),r("div",{staticClass:"dialog-footer",attrs:{slot:"footer",align:"center"},slot:"footer"},[r("el-button",{attrs:{disabled:e.isDisabled,type:"primary"},on:{click:function(t){"新增角色"===e.dialogStatus?e.createUserData():e.updateData()}}},[e._v("提交")]),e._v(" "),r("el-button",{on:{click:function(t){e.roledialogFormVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),r("el-dialog",{attrs:{visible:e.userdialogVisible,title:"授权用户",width:"800px"},on:{"update:visible":function(t){e.userdialogVisible=t}}},[r("el-transfer",{directives:[{name:"loading",rawName:"v-loading",value:e.userLoading,expression:"userLoading"}],staticClass:"box",attrs:{data:e.userData,titles:["其他用户","角色拥有用户"],filterable:"","filter-placeholder":"请输入用户名称"},on:{change:e.handleUserChange},model:{value:e.userId,callback:function(t){e.userId=t},expression:"userId"}},[r("span",{attrs:{slot:"left-footer",size:"small"},slot:"left-footer"},[r("el-pagination",{attrs:{"current-page":e.userPage,"pager-count":5,total:e.userTotal,background:"",layout:"prev, pager, next"},on:{"current-change":e.handleUserCurrentChange}})],1),e._v(" "),r("span",{attrs:{slot:"right-footer",size:"small"},slot:"right-footer"})])],1),e._v(" "),r("el-dialog",{attrs:{visible:e.userGroup.userGroupdialogVisible,title:"授权用户组",width:"800px"},on:{"update:visible":function(t){e.$set(e.userGroup,"userGroupdialogVisible",t)}}},[r("el-transfer",{directives:[{name:"loading",rawName:"v-loading",value:e.userGroup.userGroupLoading,expression:"userGroup.userGroupLoading"}],staticClass:"box",attrs:{data:e.userGroup.userGroupData,titles:["其他用户组","角色拥有用户组"],filterable:"","filter-placeholder":"请输入用户组名称"},on:{change:e.handleUserGroupChange},model:{value:e.userGroup.userGroupId,callback:function(t){e.$set(e.userGroup,"userGroupId",t)},expression:"userGroup.userGroupId"}},[r("span",{attrs:{slot:"left-footer",size:"small"},slot:"left-footer"},[r("el-pagination",{attrs:{"current-page":e.userPage,"pager-count":5,total:e.userTotal,background:"",layout:"prev, pager, next"},on:{"current-change":e.handleUserGroupCurrentChange}})],1),e._v(" "),r("span",{attrs:{slot:"right-footer",size:"small"},slot:"right-footer"})])],1),e._v(" "),r("el-dialog",{attrs:{visible:e.authoritydialogVisible,title:"授权权限",width:"800px"},on:{"update:visible":function(t){e.authoritydialogVisible=t}}},[r("el-transfer",{directives:[{name:"loading",rawName:"v-loading",value:e.authorityLoading,expression:"authorityLoading"}],staticClass:"box",attrs:{data:e.authorityData,titles:["其他权限","角色拥有权限"],filterable:"","filter-placeholder":"请输入权限名称"},on:{change:e.handleAuthorityChange},model:{value:e.authorityIds,callback:function(t){e.authorityIds=t},expression:"authorityIds"}},[r("span",{attrs:{slot:"left-footer",size:"small"},slot:"left-footer"},[r("el-pagination",{attrs:{"current-page":e.authorityPage,"pager-count":5,total:e.authorityTotal,background:"",layout:"prev, pager, next"},on:{"current-change":e.handleAuthorityCurrentChange}})],1),e._v(" "),r("span",{attrs:{slot:"right-footer",size:"small"},slot:"right-footer"})])],1)],1)},[],!1,null,null,null);i.options.__file="roleManagement.vue";t.default=i.exports},Qp9A:function(e,t,r){"use strict";var s=r("r7iz");r.n(s).a},r7iz:function(e,t,r){}}]);
(window.webpackJsonp=window.webpackJsonp||[]).push([["chunk-f296"],{XDZt:function(e,l,t){},YYlQ:function(e,l,t){"use strict";t.r(l);var a=t("vDqi"),i=t.n(a);i.a.defaults.baseURL="http://192.168.2.112/springcloud-app-system/";var o={data:function(){var e=this;return{selectedOptions:[],ruleForm2:{pass:"",checkPass:""},roledata:[{key:0,label:"管理员"},{key:1,label:"经理"},{key:2,label:"报表角色"},{key:3,label:"超级管理员"}],value1:[0],pagesize:10,total:0,pagenum:1,userList:[],options:[{value:"zhinan",label:"指南",children:[{value:"shejiyuanze",label:"设计原则",children:[{value:"yizhi",label:"一致"},{value:"fankui",label:"反馈"},{value:"xiaolv",label:"效率"},{value:"kekong",label:"可控"}]},{value:"daohang",label:"导航",children:[{value:"cexiangdaohang",label:"侧向导航"},{value:"dingbudaohang",label:"顶部导航"}]}]},{value:"zujian",label:"组件",children:[{value:"basic",label:"Basic",children:[{value:"layout",label:"Layout 布局"},{value:"color",label:"Color 色彩"},{value:"typography",label:"Typography 字体"},{value:"icon",label:"Icon 图标"},{value:"button",label:"Button 按钮"}]},{value:"form",label:"Form",children:[{value:"radio",label:"Radio 单选框"},{value:"checkbox",label:"Checkbox 多选框"},{value:"input",label:"Input 输入框"},{value:"input-number",label:"InputNumber 计数器"},{value:"select",label:"Select 选择器"},{value:"cascader",label:"Cascader 级联选择器"},{value:"switch",label:"Switch 开关"},{value:"slider",label:"Slider 滑块"},{value:"time-picker",label:"TimePicker 时间选择器"},{value:"date-picker",label:"DatePicker 日期选择器"},{value:"datetime-picker",label:"DateTimePicker 日期时间选择器"},{value:"upload",label:"Upload 上传"},{value:"rate",label:"Rate 评分"},{value:"form",label:"Form 表单"}]},{value:"data",label:"Data",children:[{value:"table",label:"Table 表格"},{value:"tag",label:"Tag 标签"},{value:"progress",label:"Progress 进度条"},{value:"tree",label:"Tree 树形控件"},{value:"pagination",label:"Pagination 分页"},{value:"badge",label:"Badge 标记"}]},{value:"notice",label:"Notice",children:[{value:"alert",label:"Alert 警告"},{value:"loading",label:"Loading 加载"},{value:"message",label:"Message 消息提示"},{value:"message-box",label:"MessageBox 弹框"},{value:"notification",label:"Notification 通知"}]},{value:"navigation",label:"Navigation",children:[{value:"menu",label:"NavMenu 导航菜单"},{value:"tabs",label:"Tabs 标签页"},{value:"breadcrumb",label:"Breadcrumb 面包屑"},{value:"dropdown",label:"Dropdown 下拉菜单"},{value:"steps",label:"Steps 步骤条"}]},{value:"others",label:"Others",children:[{value:"dialog",label:"Dialog 对话框"},{value:"tooltip",label:"Tooltip 文字提示"},{value:"popover",label:"Popover 弹出框"},{value:"card",label:"Card 卡片"},{value:"carousel",label:"Carousel 走马灯"},{value:"collapse",label:"Collapse 折叠面板"}]}]},{value:"ziyuan",label:"资源",children:[{value:"axure",label:"Axure Components"},{value:"sketch",label:"Sketch Templates"},{value:"jiaohu",label:"组件交互文档"}]}],gangweioptions:[{value:"选项1",label:"经理"},{value:"选项2",label:"工程师"},{value:"选项3",label:"蚵仔煎"},{value:"选项4",label:"龙须面"},{value:"选项5",label:"北京烤鸭"}],tableData3:[{bumen:"",gangwei:""}],multipleSelection:[],title:"",status:"",department:"",adddialogFormVisible:!1,editdialogFormVisible:!1,bumendialogFormVisible:!1,roledialogVisible:!1,restdialogVisible:!1,statusOptions:["有效","失效"],departmentOptions:["研发部","工程部","维修部","人力部","财务部"],departmentdata:[{bumen:"研发部",gangwei:"经理"},{bumen:"工程部",gangwei:"工程师"}],addform:{id:"",username:"",name:"",email:"",mobile:"",status:"",role:"",bumen:"",gangwei:""},editform:{id:"",username:"",email:"",mobile:"",status:""},rules:{name:[{required:!0,message:"请输入姓名",trigger:"blur"}],username:[{required:!0,message:"请输入账户名",trigger:"blur"}],mobile:[{required:!0,message:"请输入正确手机号",trigger:"blur"},{required:!0,pattern:/^1\d{10}$/,message:"请输入正确手机号",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱地址",trigger:"blur"},{type:"email",message:"请输入正确的邮箱地址",trigger:"blur"}]},rules2:{pass:[{validator:function(l,t,a){""===t?a(new Error("请输入密码")):(""!==e.ruleForm2.checkPass&&e.$refs.ruleForm2.validateField("checkPass"),a())},trigger:"blur"}],checkPass:[{validator:function(l,t,a){""===t?a(new Error("请再次输入密码")):t!==e.ruleForm2.pass?a(new Error("两次输入密码不一致!")):a()},trigger:"blur"}]}}},mounted:function(){this.initList()},methods:{searchListdata:function(){},addUserSubmit:function(e){},showEditDialog:function(e){console.log(e),this.editdialogFormVisible=!0,this.editform.username=e.username,this.editform.mobile=e.mobile,this.editform.email=e.email,this.editform.status=e.status},editUserSubmit:function(e){},showBumenDialog:function(e){console.log(e),this.bumendialogFormVisible=!0,this.selectedOptions.push(e.bumen)},toggleSelection:function(e){var l=this;e?e.forEach(function(e){l.$refs.multipleTable.toggleRowSelection(e)}):this.$refs.multipleTable.clearSelection()},handleSelectionChange:function(e){this.multipleSelection=e},showrestDialog:function(e){this.restdialogVisible=!0},Restsubmit:function(e){var l=this;this.$refs[e].validate(function(e){if(!e)return console.log("error submit!!"),!1;l.$message({message:"恭喜你，重置密码成功",type:"success"})}),this.restdialogVisible=!1,this.$refs[e].resetFields()},showRoleDialog:function(e){var l=this;console.log(e),this.roledialogVisible=!0,console.log(this.roledata),this.roledata.forEach(function(t,a){l.roledata[a].label===e.role&&(console.log(a),l.value1.push(a))}),console.log(this.value1)},deleteUser:function(e){var l=this;this.$confirm("此操作将永久删除id号为"+e+"的数据, 是否继续?","删除提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){l.$message({message:"删除成功",type:"success"})}).catch(function(){l.$message({type:"info",message:"已取消删除"})})},initList:function(){(function(e){return i.a.post("system/sysUser/findSysUserByPage",e,{headers:{token:"6eab3e82-f94f-4e1c-bdb4-1a81c1fcb772"}}).then(function(e){return e.data})})({rows:this.pagesize,page:this.pagenum}).then(function(e){console.log(e)})},handleSizeChange:function(e){console.log("每页 "+e+" 条"),this.pagesize=e,this.initList()},handleCurrentChange:function(e){console.log("当前页: "+e),this.pagenum=e,this.initList()}}},s=(t("dH2O"),t("KHd+")),n=Object(s.a)(o,function(){var e=this,l=e.$createElement,t=e._self._c||l;return t("div",{staticClass:"management"},[t("div",{staticClass:"filter-container"},[e._v("\n    名称：\n    "),t("el-input",{staticClass:"filter-item",staticStyle:{width:"200px"},attrs:{placeholder:"请输入名称"},nativeOn:{keyup:function(l){return"button"in l||!e._k(l.keyCode,"enter",13,l.key,"Enter")?e.searchListdata(l):null}},model:{value:e.title,callback:function(l){e.title=l},expression:"title"}}),e._v(" "),e._v("\n    状态：\n    "),t("el-select",{staticClass:"filter-item",attrs:{placeholder:"请选择",clearable:""},model:{value:e.status,callback:function(l){e.status=l},expression:"status"}},e._l(e.statusOptions,function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})})),e._v(" "),e._v("\n    部门：\n    "),t("el-select",{staticClass:"filter-item",staticStyle:{width:"130px"},attrs:{placeholder:"请选择",clearable:""},model:{value:e.department,callback:function(l){e.department=l},expression:"department"}},e._l(e.departmentOptions,function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})})),e._v(" "),t("el-button",{staticClass:"filter-item",attrs:{type:"primary",icon:"el-icon-search"}},[e._v("搜索")]),e._v(" "),t("el-button",{staticClass:"filter-item",staticStyle:{"margin-left":"10px"},attrs:{type:"primary",icon:"el-icon-plus"},on:{click:function(l){e.adddialogFormVisible=!0}}},[e._v("添加用户")])],1),e._v(" "),t("el-table",{staticStyle:{width:"100%"},attrs:{data:e.userList,border:"",fit:"","highlight-current-row":""}},[t("el-table-column",{attrs:{type:"index",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{label:"姓名",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",{staticClass:"link-type"},[e._v(e._s(l.row.name))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"账号",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.username))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"邮箱",width:"170",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.email))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"创建时间",width:"120",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.timestamp))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"部门",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.bumen))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"岗位",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.gangwei))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"状态",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("span",[e._v(e._s(l.row.status))])]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"操作",align:"center",width:"360","class-name":"small-padding fixed-width"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){e.showBumenDialog(l.row)}}},[e._v("部门岗位")]),e._v(" "),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){e.showRoleDialog(l.row)}}},[e._v("角色")]),e._v(" "),t("el-button",{attrs:{type:"primary",size:"mini"},on:{click:function(t){e.showrestDialog(l.row)}}},[e._v("重置密码")]),e._v(" "),t("el-button",{attrs:{type:"primary",size:"mini",icon:"el-icon-edit"},on:{click:function(t){e.showEditDialog(l.row)}}}),e._v(" "),t("el-button",{attrs:{size:"mini",type:"danger",icon:"el-icon-delete"},on:{click:function(t){e.deleteUser(l.row.id)}}})]}}])})],1),e._v(" "),t("el-pagination",{attrs:{"current-page":e.pagenum,"page-sizes":[1,2,3,4],"page-size":e.pagesize,total:e.total,layout:"total, sizes, prev, pager, next, jumper"},on:{"size-change":e.handleSizeChange,"current-change":e.handleCurrentChange}}),e._v(" "),t("el-dialog",{attrs:{visible:e.adddialogFormVisible,title:"添加用户"},on:{"update:visible":function(l){e.adddialogFormVisible=l}}},[t("el-form",{ref:"addform",staticStyle:{width:"400px","margin-left":"50px"},attrs:{rules:e.rules,model:e.addform,"label-position":"right","label-width":"70px"}},[t("el-form-item",{attrs:{label:"账号",prop:"username"}},[t("el-input",{model:{value:e.addform.username,callback:function(l){e.$set(e.addform,"username","string"==typeof l?l.trim():l)},expression:"addform.username"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"姓名",prop:"name"}},[t("el-input",{model:{value:e.addform.name,callback:function(l){e.$set(e.addform,"name","string"==typeof l?l.trim():l)},expression:"addform.name"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[t("el-input",{model:{value:e.addform.email,callback:function(l){e.$set(e.addform,"email",l)},expression:"addform.email"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"手机",prop:"mobile"}},[t("el-input",{model:{value:e.addform.mobile,callback:function(l){e.$set(e.addform,"mobile","string"==typeof l?l.trim():l)},expression:"addform.mobile"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"状态",prop:"status"}},[t("el-select",{staticClass:"filter-item",model:{value:e.addform.status,callback:function(l){e.$set(e.addform,"status",l)},expression:"addform.status"}},e._l(e.statusOptions,function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})}))],1)],1),e._v(" "),t("div",{staticClass:"dialog-footer",attrs:{slot:"footer",align:"center"},slot:"footer"},[t("el-button",{attrs:{type:"primary"},on:{click:function(l){e.addUserSubmit("addform")}}},[e._v("提交")]),e._v(" "),t("el-button",{on:{click:function(l){e.adddialogFormVisible=!1}}},[e._v("取消")])],1)],1),e._v(" "),t("el-dialog",{attrs:{visible:e.editdialogFormVisible,title:"编辑用户"},on:{"update:visible":function(l){e.editdialogFormVisible=l}}},[t("el-form",{ref:"editform",staticStyle:{width:"400px","margin-left":"50px"},attrs:{rules:e.rules,model:e.editform,"label-position":"right","label-width":"100px"}},[t("el-form-item",{attrs:{label:"账号",prop:"username"}},[t("el-input",{model:{value:e.editform.username,callback:function(l){e.$set(e.editform,"username",l)},expression:"editform.username"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"邮箱",prop:"email"}},[t("el-input",{model:{value:e.editform.email,callback:function(l){e.$set(e.editform,"email",l)},expression:"editform.email"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"手机",prop:"mobile"}},[t("el-input",{model:{value:e.editform.mobile,callback:function(l){e.$set(e.editform,"mobile",l)},expression:"editform.mobile"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"状态",prop:"status"}},[t("el-select",{staticClass:"filter-item",model:{value:e.editform.status,callback:function(l){e.$set(e.editform,"status",l)},expression:"editform.status"}},e._l(e.statusOptions,function(e){return t("el-option",{key:e,attrs:{label:e,value:e}})}))],1),e._v(" "),t("el-form-item",[t("el-button",{attrs:{type:"primary"},on:{click:function(l){e.editUserSubmit("editform")}}},[e._v("提交")]),e._v(" "),t("el-button",{on:{click:function(l){e.editdialogFormVisible=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),t("el-dialog",{attrs:{visible:e.bumendialogFormVisible,title:"部门、岗位"},on:{"update:visible":function(l){e.bumendialogFormVisible=l}}},[t("el-button",{attrs:{type:"primary",size:"mini"}},[e._v("分配")]),e._v(" "),t("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(l){e.deleteUser(e.scope.row.id)}}},[e._v("删除\n    ")]),e._v(" "),t("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:e.tableData3,"tooltip-effect":"dark"},on:{"selection-change":e.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"55",align:"center"}}),e._v(" "),t("el-table-column",{attrs:{label:"部门",width:"210",align:"center",prop:"bumen"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("el-cascader",{attrs:{options:e.options,placeholder:"请选择部门",filterable:""},model:{value:e.selectedOptions,callback:function(l){e.selectedOptions=l},expression:"selectedOptions"}})]}}])}),e._v(" "),t("el-table-column",{attrs:{label:"岗位",width:"140",align:"center",prop:"gangwei"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("el-select",{attrs:{filterable:"",placeholder:"请选择岗位"},model:{value:l.row.name,callback:function(t){e.$set(l.row,"name",t)},expression:"scope.row.name"}},e._l(e.gangweioptions,function(e){return t("el-option",{key:e.value,attrs:{label:e.label,value:e.value}})}))]}}])}),e._v(" "),t("el-table-column",{attrs:{prop:"address",label:"默认",align:"center"},scopedSlots:e._u([{key:"default",fn:function(l){return[t("el-button",{attrs:{type:"primary",size:"mini",round:""}},[e._v("设置为默认")])]}}])})],1),e._v(" "),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(l){e.bumendialogFormVisible=!1}}},[e._v("取 消")]),e._v(" "),t("el-button",{attrs:{type:"primary"},on:{click:function(l){e.bumendialogFormVisible=!1}}},[e._v("确 定")])],1)],1),e._v(" "),t("el-dialog",{attrs:{visible:e.restdialogVisible,title:"重置密码",width:"30%"},on:{"update:visible":function(l){e.restdialogVisible=l}}},[t("el-form",{ref:"ruleForm2",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm2,rules:e.rules2,"status-icon":"","label-width":"100px"}},[t("el-form-item",{attrs:{label:"密码",prop:"pass"}},[t("el-input",{attrs:{type:"password","auto-complete":"off"},model:{value:e.ruleForm2.pass,callback:function(l){e.$set(e.ruleForm2,"pass","string"==typeof l?l.trim():l)},expression:"ruleForm2.pass"}})],1),e._v(" "),t("el-form-item",{attrs:{label:"确认密码",prop:"checkPass"}},[t("el-input",{attrs:{type:"password","auto-complete":"off"},model:{value:e.ruleForm2.checkPass,callback:function(l){e.$set(e.ruleForm2,"checkPass","string"==typeof l?l.trim():l)},expression:"ruleForm2.checkPass"}})],1),e._v(" "),t("el-form-item",[t("el-button",{attrs:{type:"primary"},on:{click:function(l){e.Restsubmit("ruleForm2")}}},[e._v("提交")]),e._v(" "),t("el-button",{on:{click:function(l){e.restdialogVisible=!1}}},[e._v("取消")])],1)],1)],1),e._v(" "),t("el-dialog",{attrs:{visible:e.roledialogVisible,title:"角色"},on:{"update:visible":function(l){e.roledialogVisible=l}}},[t("el-transfer",{attrs:{data:e.roledata,titles:["角色名称","角色名称"]},model:{value:e.value1,callback:function(l){e.value1=l},expression:"value1"}}),e._v(" "),t("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[t("el-button",{on:{click:function(l){e.roledialogVisible=!1}}},[e._v("取 消")]),e._v(" "),t("el-button",{attrs:{type:"primary"},on:{click:function(l){e.roledialogVisible=!1}}},[e._v("确 定")])],1)],1)],1)},[],!1,null,"7e7194bb",null);n.options.__file="userManagement.vue";l.default=n.exports},dH2O:function(e,l,t){"use strict";var a=t("XDZt");t.n(a).a}}]);
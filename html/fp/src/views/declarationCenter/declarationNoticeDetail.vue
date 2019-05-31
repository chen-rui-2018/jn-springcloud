<template>
  <div class="declarationNoticeDetail">
    <div class="declarationNoticeDetail_content"><!-- 版心 -->
      <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/declarationCenter"> 申报中心</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">申报公告详情</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p class="detail_maintitle">【{{detailList.rangeName}}】{{detailList.titleName}}
          <span @click="goappointment">预约申报</span>
          <span @click="telephone">联系电话</span>
        </p>
        <!-- 附件下载 -->
        <div class="accessory_dowload">
          <div class="accessory">
            <span>附件下载:</span>
            <div class="accessory_right">
              <a v-if="fileList.length===0" href="javascript:;">暂无</a>
              <a  :href="item.filePath" v-for="(item,index) in fileList " :key="index">附件{{index+1}}  {{item.fileName}}</a>
              <p>
                <span>反馈表递交截止日期{{detailList.deadline|time}}</span>
                <span>阅读量: {{detailList.browseTimes}}次 <span>发布时间: {{detailList.createdTime|time}}</span></span>
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- 公告详情 -->
      <div class="notice_content">
        <div class="notice_title">公告详情</div>
        <div class="notice_detail" v-html="detailList.announcementContent">
        </div>
      </div>
      <!-- 在线预约弹窗 -->
      <div class="online_appointment">
        <el-dialog title="在线预约" :visible.sync="appointmentVisible" width="616px" >
          <el-form :model="appointment" label-position="left" label-width="100px" :rules="rules">
            <el-form-item label="预约项："  prop="appointmentItemName"> 
              <el-input v-model="appointment.appointmentItemName" placeholder="请输入内容   默认填入当前企业名称"></el-input>
            </el-form-item>
            <el-form-item label="预约人：" prop="contactName">
              <el-input v-model="appointment.contactName" placeholder="请输入内容   默认填入企业联系人姓名"></el-input>
            </el-form-item>
            <el-form-item label="联系电话：" prop="contactPhone">
              <el-input v-model="appointment.contactPhone" placeholder="请输入内容   默认填入企业联系人电话"></el-input>
            </el-form-item>
            <el-form-item label="电子邮箱：" prop="email">
              <el-input v-model="appointment.email" placeholder="请输入内容   默认填入企业联系人电话"></el-input>
            </el-form-item>
            <el-form-item label="申报企业：" prop="declareEnterprise">
              <el-input v-model="appointment.declareEnterprise" placeholder="请输入内容   默认填入企业联系人电话"></el-input>
            </el-form-item>
            <el-form-item label="申报名称：" prop="declareItem">
              <el-input v-model="appointment.declareItem" placeholder="请输入内容   默认填入企业联系人电话"></el-input>
            </el-form-item>
            <!-- 附件 -->
            <el-form-item label="附件：" class="upload" >
              <el-upload
                action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <i class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>

            <el-form-item label="备注：">
              <div class="content_textarea">
                <textarea v-model="appointment.remark" :placeholder="contentPlaceholder" maxlength="500" onchange="this.value=this.value.substring(0, 500)" onkeydown="this.value=this.value.substring(0, 500)" onkeyup="this.value=this.value.substring(0, 500)" 
                @input="counselnum">
                </textarea>
              <span>还可以输入<span>{{residuenum}}</span>字</span>
              </div>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="submit">提  交</el-button>
            <el-button type="primary" @click="appointmentVisible = false">取  消</el-button>
          </div>
        </el-dialog>
      </div>
      <!-- 联系电话 -->
      <div class="telephone">
        <el-dialog title="联系电话" :visible.sync="telephoneVisible" width="30%" center>
          <span>电话号码</span>
        </el-dialog>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
// 上传附件待完成，等待后台
export default {
  data () {
    return {
      id:'',
      appointmentVisible:false,
      telephoneVisible:false,
      detailList:{},
      contentPlaceholder:'输入内容',
      residuenum:500,
      appointment:{
        appointmentItemId:'',//关联的公告ID
        appointmentItemName:'',//公告标题名称
        contactName:"",//联系人姓名
        contactPhone:"",//联系人电话
        email:"",//电子邮箱
        fileUrl:"",//附件地址
        remark:'',//备注
        declareEnterprise:"",//申报企业
        declareItem:""//申报项目名称
      },
      headers:{token: sessionStorage.token},
      fileList:[],
      rules:{
        appointmentItemName:[
          { required: true, message: '企业名称不能为空'}
        ],
        contactName:[
          { required: true, message: '联系人不能为空'}
        ],
        contactPhone:[
          { required: true, message: '联系电话不能为空'}
        ],
        email:[
          { required: true, message: '内容不能为空'}
        ],
        declareEnterprise:[
          { required: true, message: '内容不能为空'}
        ],
       declareItem:[
         { required: true, message: '内容不能为空'}
       ]
      },
    }
  },
  filters: {
    time(time){
      if(time){
        // return time.split("T")[0]
        let dateee = new Date(time).toJSON();
        return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
      }
    }
  },
  created () {
    this.id=this.$route.query.id
    this.appointment.appointmentItemId=this.$route.query.id
    this.getdeclaration()
    this. addPageviews()
  },
  methods: {
    //详情数据
    getdeclaration(){
      let _this = this;
      this.api.get({
        url: "getnoticeDetail",
        data: {
          id:this.id
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.detailList = res.data
            _this.appointment. appointmentItemName= res.data.titleName;
            if(res.data.fileUrl!==''){
              _this.fileList=JSON.parse(res.data.fileUrl)
            }
          }
        }
      });
    },
    //阅读量增加
    addPageviews(){
       let _this = this;
      this.api.get({
        url: "addpageviews",
        data: {
          id:this.id
        },
        callback: function(res) {
          
        }
      });
    },
    // 文本域字数显示
    counselnum(){
      this.residuenum=500-this.appointment.remark.length
    },
    //去预约
    goappointment(){
      this.appointmentVisible=true
      // this.headers=sessionStorage.getItem("token")
      if(sessionStorage.getItem("token")){
        let _this = this;
        this.api.get({
          url: "getUserExtension",
          data: { },
          callback: function(res) {
            if (res.code == "0000") {
            _this.appointment.contactName= res.data.nickName
            _this.appointment.contactPhone= res.data.phone
            _this.appointment.email= res.data.email
            _this.appointment.declareEnterprise= res.data.companyName
            }
          }
        });
      }else{
        //跳转到等录页面
        this.$router.push({
          name:'login'
        })
      }
    },
    uploadsuccess(file, fileList){
      // console.log(file)
      // console.log(fileList)
      this.appointment.fileUrl=file.data
    },
    //提交
    submit(){
      let _this = this;
        this.api.post({
          url: "appointment",
          data: this.appointment,
          callback: function(res) {
            if (res.code == "0000") {
              // console.log(res)
              _this.$message.success("预约成功")
              _this.appointmentVisible=false
            }
          }
        });
    },
    // 电话号码
    telephone(){
      this.telephoneVisible=true
    }
  }
}
</script>
<style lang="scss">
  .declarationNoticeDetail{
    padding-top: 67px;
    .declarationNoticeDetail_content{
      width: 1190px;
      margin: 0 auto;
      // 面包屑
      .approve_breadcrumb{
        padding: 15px 0;
        font-size: 12px;
        .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
          color:#00a041;  
        }
      }
      // 大标题
      .right_headline{
        box-shadow: 0px 1px 15px 0px 
          rgba(4, 0, 0, 0.05);
        border-radius: 8px;
        border: solid 1px #eeeeee;
        padding:30px 31px 18px 31px;
        .detail_maintitle{
          font-size: 21px;
          border-bottom: 1px solid #eeeeee;
          padding-bottom: 19px;
          span{
            float:right;
            font-size: 12px;
            padding:3px 5px;
            border-radius: 5px;
            &:hover{
              cursor:pointer;
            }
          }
          span:nth-child(2){
            background-color: #ecfcf2;
            border-radius: 5px;
            border: solid 1px #41d787;
            color:#00a041;
            border-radius: 5px;
            margin-right: 12px;
          }
          span:nth-child(1){
            background-color: #00a041;
            color:#FFF;
            border: solid 1px #00a041;
          }
        }
        .accessory_dowload{
          margin-top: 24px;
          font-size: 13px;
          .accessory{
            display: flex;
            .accessory_right{
              margin-left: 7px;
              flex:1;
              a{
                display: block;
                color:#00a041;
                padding-bottom: 10px;
              }
              p{
                display: flex;
                justify-content: space-between;
                span{
                  font-size: 12px;
                  color:#666666;
                  &:nth-child(2){
                    float: right;
                    span{
                      padding-left: 20px;
                    }
                  }
                }
              }
            }

          }
        }
      }
      // 公告详情
      .notice_content{
        margin-top: 30px;
        margin-bottom: 61px;
        .notice_title{
          font-size: 17px;
        }
        .notice_detail{
          margin-top: 17px;
          box-shadow: 0px 1px 15px 0px rgba(4, 0, 0, 0.05);
          border-radius: 8px;
          border: solid 1px #eeeeee;
          padding:46px 41px 62px 41px;
        }
      }
      // 在线预约弹窗
      .online_appointment{
        .el-dialog__header{
          .el-dialog__headerbtn .el-dialog__close:hover{
            color:#00a041;
          }
        }
        .el-dialog__body{
          padding: 26px 79px 12px 79px;
          border-bottom: 1px solid #ccc;
          .el-form-item__content{
            line-height: 1;
          }
          .el-form-item{
            margin-bottom: 22px;
          }
          input:focus { 
            border-color:#00a041; 
          }
        }
                                     
        .el-upload--picture-card{ 
          width: 100px;
          height: 100px;
          line-height: 100px;
        }
        .content_textarea{
              // border: 1px solid #DCDFE6;
              // border-radius: 5px;
              textarea{outline: none;}
          textarea{
            padding: 8px 15px;
            resize: none;
            width: 91%;
            height: 96px;
            border: 1px solid #DCDFE6;
            border-radius: 5px;
            color:#606266;
            margin-bottom: 5px;
          }
          textarea::-webkit-input-placeholder{
            font-size: 14px;
            color:#c0c4cc;
            // padding-left: 8px;
            // padding-top: 8px;
              line-height: 20px
            }    /* 使用webkit内核的浏览器 */
            textarea:-moz-placeholder{
              line-height: 20px;
              padding-left: 8px;
              color:black;
              font-size: 14px;
              padding-top: 8px;
            }                  /* Firefox版本4-18 */
            textarea::-moz-placeholder{
              line-height: 20px;
              padding-left: 8px;
              color:black;
              font-size: 14px;
              padding-top: 8px;
            }                  /* Firefox版本19+ */
          textarea:-ms-input-placeholder{
            line-height: 20px;
            padding-left: 8px;
            color:black;
            font-size: 14px;
            padding-top: 8px;
          }
          span{
            color:#999999;
            span{
              color:#ff0000;
            }
          }
        }
        .el-dialog__footer{
          text-align: center;
          .el-button{
            padding: 7px 20px;
            border-radius: 5px;
          }
          button:nth-child(1){
            border: solid 1px #41d787;
            background-color: #ecfcf2;
            &:hover{
              color:#41d787;
            }
          }
          button:nth-child(2){
            background-color: #00a041;
            border:1px solid #00a041;
          }
        }
        textarea:focus { 
            border-color:#00a041; 
          }
      }
      // 电话号码
      .telephone{
        .el-dialog--center .el-dialog__body{
          text-align: center;
          color:#00a041;
          font-size: 18px;
          padding: 8px 25px 50px;
        }
        .el-dialog__headerbtn{
          i:hover{
            color:#00a041;
          }
        }
        .el-dialog__title{
          font-size: 16px;
        }
      }
    }
  }
</style>

                                         
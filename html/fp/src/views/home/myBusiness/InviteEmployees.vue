<template>
  <div class="inviteProduct">
    <div class="ordinary_title">
      <div class="font16">邀请员工</div>
    </div>
    <div class="ordinary_content">
       <el-form label-width="120px" class="postJobInfo">
  <el-form-item label="注册手机/邮箱:" prop="post" class="staffAccount">
    <el-input placeholder="请输入手机号或账号、邮箱" v-model="searchFiled" clearable>
          <el-button slot="append" icon="el-icon-search" @click="getStaffInfo"></el-button>
        </el-input>
  </el-form-item>
  <el-form-item label="昵称:">
    <label slot="label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
    <span>{{nickName}}</span>
  </el-form-item>
  <el-form-item label="真实姓名:">
   <span>{{name}}</span>
  </el-form-item>
  <el-form-item label="性别:" >
     <label slot="label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
    <span v-show="sex=='1'">男</span>
    <span v-show="sex=='0'">女</span>
  </el-form-item>
  <el-form-item label="个性签名:" >
     <span>{{signature}}</span>
  </el-form-item>
  <el-form-item label="兴趣爱好:" class="hobbies">
      <span v-for="(item, index) in hobbys" :key="index" class="hobbys">{{item}}</span>
  </el-form-item>
  <el-form-item label="职业:" class="hobbies">
      <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
    <span v-for="(item, index) in jobs" :key="index" class="hobbys">{{item}}</span>
  </el-form-item>
 <div class="business_footer" @click="submitForm()">
        邀请该员工
  </div>
</el-form>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      hobbys:'',
        searchFiled:'',
        nickName:'',
        name:'',
        sex:'',
        account:'',
        jobs:'',
       signature :''
    }
  },
  methods: {
    // 获取邀请员工信息
      getStaffInfo(){
        this.api.get({
     url:'getInviteStaffList',
     data:{phone :this.searchFiled },
     callback:(res=>{
       console.log(res)
       if(res.code==='0000'){

          this.nickName=res.data.nickName
          this.name=res.data.name
          this.sex=res.data.sex
          this.account=res.data.account
          this.jobs=res.data.jobs
          this.signature=res.data.signature
          this.hobbys=res.data.hobbys
       }else{
          this.$message.error(res.result);
       }
     })
 })
      },
    goputaway(){
      this.$router.push({name:'productPutaway'})
    },
     submitForm() {
       if(!this.searchFiled){
         this.$message.error('请输入员工手机或姓名');
         return
       }
      this.api.post({
     url:'inviteStaff',
     data:{inviteAccount:this.searchFiled},
     dataFlag:true,
     callback:(res=>{
         console.log(res)
          if (res.code == "0000") {
             this.$message({
                message: '发送邀请成功',
                type: 'success'
              })
                this.$router.push({name:'staffManagement'})
          }else{
             this.$message.error(res.result)
          }

     })
 })
      },
  }
}
</script>

<style lang="scss">
  .inviteProduct{
    .staffAccount{
      .el-input__inner{
        height: 33px;
        line-height: 33px;
        width:220px;
      }
      .el-form-item__content{
         height: 33px;
        line-height: 33px;
      }
      .el-form-item__label{
        height: 33px;
        line-height: 33px;
      }
    }
     .hobbys{
    padding: 5px 15px;
    background: #f7f7f7;
    border: 1px solid #eee;
    border-radius: 3px;
    margin-right: 20px;
    color: #999;
    }
    width: 100%;
    .ordinary_title{
      background-color: #fff;

      padding:24px 28px;
      border-radius: 5px;
    }
    .ordinary_content{
        margin-top:14px;
        background: #fff;
        padding:36px 0px;
        .el-input-group__append{
          background-color: #00a041;
    color: #fff;
    border: none;
    font-size: 13px;
    border-left: 0;
        }
        .postJobInfo{
            // width: 50%;
            // margin: 0 auto;
            padding-left: 140px;

            .el-form-item__content,.el-select{
                width: 266px;
            }
            .hobbies{
               .el-form-item__content,.el-select{
                width:100%;
            }}
             .el-textarea__inner{
                 width: 348px;
                min-height: 100px !important;
                background: #fff;
            }
        }
         .business_footer {
    margin: 0 auto;
    margin-top: 58px;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    height: 29px;
    line-height: 29px;
    width: 90px;
    color: #41d787;
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    margin-bottom: 17px;
  }
    }
  }
</style>

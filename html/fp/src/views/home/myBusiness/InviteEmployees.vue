<template>
  <div class="inviteProduct" v-loading="loading">
    <div class="ordinary_title">
      <div class="font16">邀请员工</div>
      <div @click="goBack">返回</div>
    </div>
    <div class="ordinary_content">
      <el-form label-width="120px" class="postJobInfo">
        <el-form-item label="员工账号:" prop="post" class="staffAccount">
          <el-input placeholder="请输入员工账号" v-model="searchFiled" clearable @keyup.enter.native="getStaffInfo">
            <el-button slot="append" icon="el-icon-search" @click="getStaffInfo" ></el-button>
          </el-input>
        </el-form-item>
        <el-form-item label="昵称:">
          <label slot="label">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:</label>
          <span>{{nickName}}</span>
        </el-form-item>
        <el-form-item label="真实姓名:">
          <span>{{name}}</span>
        </el-form-item>
        <el-form-item label="性别:">
          <label slot="label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
          <span v-show="sex=='1'">男</span>
          <span v-show="sex=='0'">女</span>
        </el-form-item>
        <el-form-item label="个性签名:">
          <span>{{signature}}</span>
        </el-form-item>
        <el-form-item label="兴趣爱好:" class="hobbies clearfix">
          <span v-for="(item, index) in hobbys" :key="index" class="hobbys">{{item}}</span>
        </el-form-item>
        <el-form-item label="职业:" class="hobbies clearfix">
          <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业:</label>
          <span v-for="(item, index) in jobs" :key="index" class="hobbys">{{item}}</span>
        </el-form-item>

      </el-form>
      <div class="business_footer" @click="submitForm()">
        邀请该员工
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      loading:false,
      hobbys: "",
      searchFiled: "",
      nickName: "",
      name: "",
      sex: "",
      account: "",
      jobs: "",
      signature: ""
    };
  },
  methods: {
     goBack() {
      this.$router.push({ name: "staffManagement" });
    },
    // 获取邀请员工信息
    getStaffInfo() {
      this.api.get({
        url: "getInviteStaffList",
        data: { phone: this.searchFiled },
        callback: res => {
          console.log(res);
          if (res.code === "0000") {
            if(res.data){

              this.nickName = res.data.nickName;
              this.name = res.data.name;
              this.sex = res.data.sex;
              this.account = res.data.account;
              this.jobs = res.data.jobs;
              this.signature = res.data.signature;
              this.hobbys = res.data.hobbys;
            }
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    submitForm() {
      if (!this.searchFiled) {
        this.$message.error("请输入员工账号");
        return;
      }
      this.loading=true
      this.api.post({
        url: "inviteStaff",
        data: { inviteAccount: this.searchFiled },
        dataFlag: true,
        callback: res => {
          this.loading=false
          if (res.code == "0000") {
            this.$message({
              message: "操作成功",
              type: "success"
            });
            this.$router.push({ name: "staffManagement" });
          } else {
            this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>

<style lang="scss">
.inviteProduct {
  .staffAccount {
    .el-input__inner {
      height: 33px;
      line-height: 33px;
      width: 220px;
    }
    .el-form-item__content {
      height: 33px;
      line-height: 33px;
    }
    .el-form-item__label {
      height: 33px;
      line-height: 33px;
    }
    .el-form-item__content,
      .el-select {
        width: 266px;
      }
  }
  .hobbys {
    padding: 5px 15px;
    background: #f7f7f7;
    border: 1px solid #eee;
    display: inline-block;
    line-height: 20px;
    margin-bottom: 15px;
    border-radius: 3px;
    margin-right: 20px;
    color: #999;
  }
  
  .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    // font-size: 13px;
    border-radius: 5px;
    div:nth-child(2) {
      width: 50px;
      height: 26px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      text-align: center;
      line-height: 26px;
      font-size: 12px;
      color: #00a041;
      cursor: pointer;
    }
  }
  .ordinary_content {
    margin-top: 14px;
    background: #fff;
    padding: 36px 0px;
    .el-input-group__append {
      background-color: #00a041;
      color: #fff;
      border: none;
      font-size: 13px;
      border-left: 0;
    }
    .postJobInfo {
      width: 50%;
      margin: 0 auto;
      .el-textarea__inner {
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

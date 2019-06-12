<template>
  <div class="attendanceSign write">
    <!-- <header class="clearfix">
      <strong>考勤签到</strong>
      <div><i class="el-icon-edit-outline"/><span><router-link :to="{name:'attendanceManagementList'}">明细</router-link></span></div>
    </header> -->
    <el-row :gutter="20">
      <el-col :sm="12" :lg="12" :xs="12" :span="12">
        <el-card class="box-card">
          <div :class="upTime?'clearfix signcenter':'clearfix text-center'">
            <span class="sign signIn" @click="signIn">{{ signInText }}</span>
            <div v-if="upTime" class="signInfo">
              <span> 已签到</span>
              <div><i class="iconfont">&#xe610;</i> 上班签到时间 <span>{{ upTime }}</span></div>
            </div>
          </div>
      </el-card></el-col>
      <el-col :span="12" :sm="12" :xs="12" :lg="12"><el-card class="box-card">
        <div :class="downTime?'clearfix signcenter':'clearfix text-center'">
          <span :disabled="disabled" class="sign signOut" @click="signOut">{{ signOutText }}</span>
          <div v-if="downTime" class=" signInfo">
            <span> 已签退</span>
            <div><i class="iconfont">&#xe610;</i> 下班签退时间 <span>{{ downTime }}</span></div>
          </div>

        </div>
      </el-card></el-col>
    </el-row>
  </div>
</template>

<script >
import {
  api
} from '@/api/axios'
export default {
  data() {
    return {
      signInText: '签到',
      signOutText: '签退',
      disabled: false,
      downTime: '',
      upTime: '',
      userInfo: {
        attendanceUser: '',
        attendancePlatform: '1',
        type: ''
      }
    }
  },
  created() {
    this.getUserInfo()
  },
  mounted() {
    // setTimeout(() => {
    // this.initList()
    // }, 50)
  },
  methods: {
    // 点击签退
    signOut() {
      this.disabled = true
      if (!this.upTime) {
        alert('您未签到，请先签到')
        this.disabled = false
        return
      }
      this.userInfo.type = '2'
      api(`${this.GLOBAL.oaUrl}oa/attendance/attendance`, this.userInfo, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          alert('签退成功,签退时间 : ' + res.data.data.attendanceTime)
          this.signOutText = '已签退'
          this.downTime = res.data.data.attendanceTime.substr(11, 8)
        } else {
          this.signOutText = '已签退'
          this.$message.error(res.data.result)
        }
        this.disabled = false
        // this.listLoading = false
      })
    },
    // 点击签到
    signIn() {
      this.disabled = true
      if (this.upTime) {
        alert('已签到,不能进行多次签到')
        this.disabled = false
        return
      }
      this.userInfo.type = '1'
      api(`${this.GLOBAL.oaUrl}oa/attendance/attendance`, this.userInfo, 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          alert('签到成功,签到时间 : ' + res.data.data.attendanceTime)
          this.signInText = '已签到'
          this.upTime = res.data.data.attendanceTime.substr(11, 8)
        } else {
          this.$message.error(res.data.result)
          this.signInText = '签到'
        }
        this.disabled = false
      })
    },
    // 获取登陆用户信息
    getUserInfo() {
      api(`${this.GLOBAL.systemUrl}system/sysUser/getUserInfo`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.userInfo.attendanceUser = res.data.data.id
          api(`${this.GLOBAL.oaUrl}oa/attendance/selectByUserIdAndCurrentDate?userId=${this.userInfo.attendanceUser}`, '', 'get').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              if (res.data.data) {
                this.signInText = '已签到'
                this.upTime = res.data.data.signInAttendanceTime.substr(11, 8)
                if (res.data.data.signOutAttendanceTime !== null) {
                  this.signOutText = '已签退'
                  this.downTime = res.data.data.signOutAttendanceTime.substr(11, 8)
                }
              }
            } else {
              this.$message.error(res.data.result)
            }
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>

  .attendanceSign{
    .box-card{
      padding: 10px!important;
      margin-bottom: 20px;
    }
    padding: 20px;
    width: 100%;
    header{
      margin-bottom: 20px;
      strong{
        float: left;
        font-size: 20px;
      }
      >div{
        float:right;
        color:rgb(78, 173, 241);
        >i{
              margin-right: 6px;
    font-size: 16px;
    vertical-align: bottom;
        }
        >span{
         font-size: 14px;
        }
      }
    }
    .signcenter{
      display: flex;
      justify-content: space-around;
    }
    .sign{
      display: inline-block;
      height: 60px;
      width: 60px;
      line-height: 50px;
      text-align: center;
      // line-height: 100px;
      font-size: 12px;
      border-radius: 50%;
      border:5px solid rgb(179, 228, 240)
    }
    .signOut{
     color:rgb(78, 173, 241);
      background: rgb(221, 247, 255)
    }
    .signIn{
      color:#fff;
        background: rgb(56, 161, 235);
    }
    .signInfo{
         text-align: center;
    /* line-height: 46px; */
    // height: 60px;
    // padding-top: 15px;
    // margin-right: 70px;
    >span{
      font-size: 12px;
      color:rgb(78, 173, 241);
      cursor: pointer;
    }
    >div{
      margin-top:5px;
      font-size: 10px;
      font-weight: 600;
      >i{
    color: rgb(78, 173, 241);
    /* color: blue; */
    font-size: 14px;
    // margin-right: 6px;
    vertical-align: sub;
      }
    }
    }
  }
</style>
<style lang="scss">
.attendanceSign{

  .el-card__body{
    padding: 0px !important;
  }
}
</style>

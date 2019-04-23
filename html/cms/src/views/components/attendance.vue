<template>
  <el-row :gutter="20">
    <el-col :xs="24" :sm="12" :lg="12" >
      <div
        :class="upTime?'clearfix signcenter':'clearfix text-center'">
        <el-button :disabled="disabled" class="sign signIn" @click="signIn">{{ signInText }}</el-button>
        <div v-if="upTime" class="signInfo">
          <span> 已签到</span>
          <div><i class="iconfont">&#xe610;</i> 上班签到时间 <span>{{ upTime }}</span></div>
        </div>

      </div>
    </el-col>
    <el-col :xs="24" :sm="12" :lg="12" >
      <div :class="downTime?'clearfix signcenter':'clearfix text-center'">
        <el-button :disabled="disabled" class="sign signOut" @click="signOut">{{ signOutText }}</el-button>
        <div v-if="downTime" class=" signInfo">
          <span> 已签退</span>
          <div><i class="iconfont">&#xe610;</i> 下班签退时间 <span>{{ downTime }}</span></div>
        </div>

      </div>
    </el-col>
  </el-row>
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
              }
              if (res.data.data.signOutAttendanceTime !== null) {
                this.signOutText = '已签退'
                this.downTime = res.data.data.signOutAttendanceTime.substr(11, 8)
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

<style rel="stylesheet/scss" lang="scss" scoped>
.panel-group {
//   margin-top: 18px;
//   .card-panel-col{
//     margin-bottom: 32px;
//   }
//   .card-panel {
//     height: 108px;
//     cursor: pointer;
//     font-size: 12px;
//     position: relative;
//     overflow: hidden;
//     color: #666;
//     background: #fff;
//     box-shadow: 4px 4px 40px rgba(0, 0, 0, .05);
//     border-color: rgba(0, 0, 0, .05);
//     &:hover {
//       .card-panel-icon-wrapper {
//         color: #fff;
//       }
//       .icon-people {
//          background: #40c9c6;
//       }
//       .icon-message {
//         background: #36a3f7;
//       }
//       .icon-money {
//         background: #f4516c;
//       }
//       .icon-shopping {
//         background: #34bfa3
//       }
//     }
//     .icon-people {
//       color: #40c9c6;
//     }
//     .icon-message {
//       color: #36a3f7;
//     }
//     .icon-money {
//       color: #f4516c;
//     }
//     .icon-shopping {
//       color: #34bfa3
//     }
//     .card-panel-icon-wrapper {
//       float: left;
//       margin: 14px 0 0 14px;
//       padding: 16px;
//       transition: all 0.38s ease-out;
//       border-radius: 6px;
//     }
//     .card-panel-icon {
//       float: left;
//       font-size: 48px;
//     }
//     .card-panel-description {
//       float: right;
//       font-weight: bold;
//       margin: 26px;
//       margin-left: 0px;
//       .card-panel-text {
//         line-height: 18px;
//         color: rgba(0, 0, 0, 0.45);
//         font-size: 16px;
//         margin-bottom: 12px;
//       }
//       .card-panel-num {
//         font-size: 20px;
//       }
//     }
//   }
}
 .sign {
            display: inline-block;
            height: 100px;
            width: 100px;
            text-align: center;
            line-height: 100px;
            border-radius: 50%;
            border: 5px solid rgb(179, 228, 240)
        }

        .signOut {
            color: rgb(78, 173, 241);
            background: rgb(221, 247, 255)
        }

        .signIn {
            color: #fff;
            background: rgb(56, 161, 235);
        }
        .row{
            display: flex;
            justify-content: space-around;
        }

    .signcenter{
      display: flex;
      justify-content: space-around;
    }
    .sign{
      display: inline-block;
      height: 100px;
      width: 100px;
      text-align: center;
      // line-height: 100px;
      font-size: 17px;
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
    height: 100px;
    padding-top: 30px;
    // margin-right: 70px;
    >span{
      color:rgb(78, 173, 241);
    }
    >div{
      margin-top:15px;
      font-size: 13px;
      font-weight: 600;
      >i{
    color: rgb(78, 173, 241);
    /* color: blue; */
    font-size: 20px;
    margin-right: 6px;
    vertical-align: sub;
      }
    }
    }
</style>

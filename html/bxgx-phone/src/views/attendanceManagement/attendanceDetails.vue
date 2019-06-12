<template>
  <div class="attendanceDetails">
    <!-- <div class="title">考勤明细</div> -->
    <div v-show="isAdministrator" class="isAdministrator"><span :class="isPersonage===1?'selectedAcitive':''" @click="cutPersonage">个人</span><span
        :class="isPersonage===0?'selectedAcitive':''" @click="cutStatus">部门</span></div>
    <div class="dateTime">
      <div>
        <group>
          <datetime v-model="currentDate" format="YYYY-MM" @on-change="getData"></datetime>
        </group>
      </div>
      <div v-show="isPersonage===1" class="useInfo">
        <span>{{userName.charAt(userName.length - 1)}}</span>
        <div class="departmentInfo">
          <div>{{userName}}</div>
          <div>部门: <span>{{department}}</span></div>
        </div>
      </div>
      <div v-show="isPersonage===0" class="attendanceNum">考勤人数 <span>{{num}}人</span></div>
    </div>
    <!-- 个人考勤结构 -->
    <div v-for="(item, index) in attendanceArr" :key="index">
      <div class="clockDetails ">
        <div v-show="isPersonage===1">
          <div class="pd30">
            <span v-show="item.attendanceType==='0'">正常</span>
            <span v-show="item.attendanceType==='1'">迟到</span>
            <span v-show="item.attendanceType==='2'">早退</span>
            <span v-show="item.attendanceType==='3'">缺卡</span>
            <span v-show="item.attendanceType==='4'">加班</span>
            <span v-show="item.attendanceType==='5'">旷工</span>
            <span v-show="item.attendanceType==='6'">请假</span>
            <span v-show="item.attendanceType==='0'||item.attendanceType==='3'||item.attendanceType==='5'">{{item.frequency}}次
              <i v-show="item.isfold" class="iconfont" @click="item.isfold=!item.isfold">&#xe669;</i> <i v-show="!item.isfold"
                class="iconfont" @click="item.isfold=!item.isfold">&#xe638;</i></span>
            <span v-show="item.attendanceType==='1'||item.attendanceType==='2'||item.attendanceType==='4'||item.attendanceType==='6'">{{item.frequency}}次,共{{item.totalTime}}
              <i v-show="item.isfold" class="iconfont" @click="item.isfold=!item.isfold">&#xe669;</i> <i v-show="!item.isfold"
                class="iconfont" @click="item.isfold=!item.isfold">&#xe638;</i></span>
          </div>
          <div v-show="item.isfold">
            <ul class="recordInfo">
              <li v-for="(i, index1) in item.statusDetailedList" :key="index1">
                <div>{{i.timeKey}}</div><span>{{i.value}}</span>
              </li>
            </ul>
          </div>
        </div>

        <!-- <div class="pd30" v-show="isPersonage===0&&item.attendanceType==='0'">
          <span>正常</span>
          <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>
        </div>
        <div class="pd30" v-show="item.attendanceType=='1'&&isPersonage===0"> <span>迟到</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="item.attendanceType=='2'&&isPersonage===0"> <span>早退</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>
        </div>
        <div class="pd30" v-show="item.attendanceType=='3'&&isPersonage===0"> <span>缺卡</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="item.attendanceType=='4'&&isPersonage===0"> <span>加班</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="item.attendanceType=='5'&&isPersonage===0"> <span>旷工</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>
        </div>
        <div class="pd30" v-show="item.attendanceType=='6'&&isPersonage===0"> <span>请假</span> <span>{{item.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div> -->
        <!-- <div v-show="iconStatus0&&isPersonage===1">
          <ul class="recordInfo">
            <li v-for="(i, index1) in item.statusDetailedList" :key="index1">
              <div>{{i.timeKey}}</div><span>{{i.value}}</span>
            </li>
          </ul>
        </div> -->
        <!-- <div v-show="iconStatus&&isPersonage===0">
          <ul class="departmentRecord">
            <li v-for="(i, index1) in item.statusAttendanceObject" :key="index1">
              <div> <span>{{i.department}}</span> <span>{{i.name}}</span> <span v-show="i.attendanceType==='5'">旷工{{i.frequency}}次</span></div>

              <ul class="recordInfo">
                <li v-for="(v, idx) in i.statusDetailedList" :key="idx">
                  <div>{{v.timeKey}}</div><span>{{v.value}}</span>
                </li>
              </ul>

            </li>
          </ul>
        </div> -->
      </div>
    </div>
    <!-- 部门考勤结构 -->
    <div v-if="isPersonage===0">
      <div class="clockDetails" v-for="v in departmentList" :key="v.attendanceType">
        <div>
          <div class="pd30">
            <span v-show="v.attendanceType==='0'">正常</span>
            <span v-show="v.attendanceType==='1'">迟到</span>
            <span v-show="v.attendanceType==='2'">早退</span>
            <span v-show="v.attendanceType==='3'">缺卡</span>
            <span v-show="v.attendanceType==='4'">加班</span>
            <span v-show="v.attendanceType==='5'">旷工</span>
            <span v-show="v.attendanceType==='6'">请假</span>
            <span>{{v.number}}人
              <i v-show="v.isfold" class="iconfont" @click="v.isfold=!v.isfold">&#xe669;</i> <i v-show="!v.isfold"
                class="iconfont" @click="v.isfold=!v.isfold">&#xe638;</i></span>
            <!-- <span v-show="v.attendanceType==='1'||v.attendanceType==='2'||v.attendanceType==='4'||v.attendanceType==='6'">{{v.frequency}}次,共{{v.totalTime}}
              <i v-show="v.isfold" class="iconfont" @click="v.isfold=!v.isfold">&#xe669;</i> <i v-show="!v.isfold"
                class="iconfont" @click="v.isfold=!v.isfold">&#xe638;</i></span> -->
          </div>
          <div v-show="v.isfold">
            <ul class="departmentRecord">
              <li v-for="(i, index1) in v.statusAttendanceObject" :key="index1">
                <div> <span>{{i.department}}</span> <span class="text-green">{{i.name}}</span> <span class="mr" v-show="i.attendanceType==='5'||i.attendanceType==='0'||i.attendanceType==='3'">{{i.frequency}}次</span><span class="mr" v-show="i.attendanceType==='1'||i.attendanceType==='2'||i.attendanceType==='4'||i.attendanceType==='6'">{{i.frequency}}次,共{{i.totalTime}}</span>
                </div>

                <ul class="recordInfo">
                  <li v-for="(v, idx) in i.statusDetailedList" :key="idx">
                    <div>{{v.timeKey}}</div><span>{{v.value}}</span>
                  </li>
                </ul>
                <!-- <div>{{i.timeKey}}</div><span>{{i.value}}</span> -->
              </li>
            </ul>
          </div>
          <!-- <div class="pd30" v-if="v.attendanceType=='0'">
          <span>正常</span>
          <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>
        </div>
        <div class="pd30" v-if="v.attendanceType=='1'"> <span>迟到</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="v.attendanceType=='2 '"> <span>早退</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="v.attendanceType=='3'"> <span>缺卡</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="v.attendanceType=='4'"> <span>加班</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="v.attendanceType=='5'"> <span>旷工</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div class="pd30" v-show="v.attendanceType=='6'"> <span>请假</span> <span>{{v.number}}人
            <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i v-show="!iconStatus" class="iconfont"
              @click="cutIcon">&#xe638;</i></span>

        </div>
        <div v-show="iconStatus">
          <ul class="recordInfo">
            <li v-for="(i, index3) in v.statusDetailedList" :key="index3">
              <div>{{i.timeKey}}</div><span>{{i.value}}</span>
            </li>
          </ul>
        </div> -->
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      num: 0,
      department: '',
      userName: '',
      currentDate: '',
      isAdministrator: true,
      isPersonage: 1,
      attendanceArr: [],
      departmentList: []
    }
  },
  mounted () {
    this.init()
  },
  created () {
    // 获取完整的日期
    let date = new Date()
    let year = date.getFullYear()
    let month = date.getMonth() + 1
    month = month < 10 ? '0' + month : month
    this.currentDate = year + '-' + month
  },
  methods: {
    getData () {
      if (this.isPersonage === 1) {
        this.init()
      } else {
        this.getDepartmentInfo()
      }
    },
    // 查询用户个人考勤明细
    init () {
      // 获取完整的日期
      this.userName = sessionStorage.userName
      this.department = sessionStorage.departmentName
      this.api.post({
        url: 'selectAttendanceManagementByUserId',
        data: { attendanceMonth: this.currentDate },
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            if (res.data) {
              this.attendanceArr = res.data
              this.attendanceArr.forEach(ele => {
                this.$set(ele, 'isfold', true)
              })
            }
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // 查询用户部门考勤
    getDepartmentInfo () {
      this.api.post({
        url: 'selectAttendanceManagementByDepartmentId',
        data: {
          attendanceMonth: this.currentDate,
          departmentId: sessionStorage.departmentId
        },
        callback: res => {
          console.log(res)
          if (res.code === '0000') {
            if (res.data) {
              this.departmentList = res.data.attendanceList
              this.departmentList.forEach(ele => {
                this.$set(ele, 'isfold', true)
              })
              this.num = res.data.totalNumber
            }
          } else {
            this.$vux.toast.text(res.result)
          }
        }
      })
    },
    // cutIcon1 (v) {
    //   console.log(item)
    //   if (item.attendanceType === '0') {
    //     this.iconStatus0 = !this.iconStatus0
    //   }
    // },
    // cutIcon (item) {
    //   console.log(item)
    //   this.iconStatus = !this.iconStatus
    // },
    cutPersonage () {
      this.isPersonage = 1
      this.init()
    },
    cutStatus () {
      this.isPersonage = 0
      this.getDepartmentInfo()
    }
  }
}
</script>

<style lang="scss" scoped>
.attendanceDetails {
  padding-top: 1rem;
  font-size: 32px;
  .attendanceNum {
    display: flex;
    align-items: center;
    text-align: right !important;
  }
  .pd30 {
    padding: 30px;
  }
  .departmentRecord {
    width: 100%;
    padding: 20px;
    background: rgb(242, 242, 242);
    font-size: 34px;
  }
  .recordInfo {
    padding: 10px 30px;
    width: 100%;
    background: rgb(242, 242, 242);
    li {
      display: flex;
      width: 100%;
      margin: 10px 0px;
      justify-content: space-between;

      > div {
        font-size: 30px;
      }
      > span {
        color: #999;
        font-size: 0.2rem;
        display: flex;
        align-items: center;
      }
    }
  }
  .text-green{
    color:#00a041;
  }
  .mr{
    margin-left:40px;
  }
  .isAdministrator {
    // padding: 30px;
    border-bottom: 1px solid #ccc;
    > span {
      display: inline-block;
      padding: 30px;
      width: 160px;
      text-align: center;
      // border:1px solid #ccc;
    }
  }
  .selectedAcitive {
    border-bottom: 2px solid green;
    color: green;
  }
  .dateTime {
    display: flex;
    padding: 20px;
    justify-content: space-between;
    border-bottom: 1px solid #ccc;
    > div {
      //   width: 50%;
      text-align: center;
      //    border-bottom: 1px solid #ccc;
    }
    .weui-cell {
      display: inline-block;
      padding: 50px;
      font-size: 50px;
    }
    .weui-cells:after {
      border: none;
    }
  }
  .useInfo {
    display: flex;
    //   justify-content: space-around;
    // margin-left:50px;
    align-items: center;
    //   justify-content: center;
    > span {
      width: 100px;
      height: 100px;
      line-height: 100px;
      border-radius: 50%;
      background-color: #00a041;
      color: #fff;
    }
    .departmentInfo {
      > div {
        text-align: left;
        padding: 5px;
      }
      > div:nth-child(2) {
        font-size: 26px;
        color: #999;
      }
    }
  }
  .clockDetails {
    > div > div:nth-child(1) {
      display: flex;
      justify-content: space-between;
    }
  }
  .iconfont {
    font-size: 0.5rem;
  }
}
</style>
<style lang='scss'>
.attendanceDetails {
  .vux-cell-value {
    color: black;
  }
  .weui-cell_access .weui-cell__ft:after {
    height: 0.35rem;
    width: 0.35rem;
    border-color: black;
    top: 30%;
    right: -0.5rem;
  }
  .weui-cells:after,
  .weui-cells:before {
    border: none;
  }
  .vux-no-group-title {
    margin-top: unset;
  }
  .weui-cells {
    background: unset;
  }
}
</style>

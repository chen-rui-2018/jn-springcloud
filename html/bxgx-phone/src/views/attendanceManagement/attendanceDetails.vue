<template>
  <div class="attendanceDetails">
    <div class="title">考勤明细</div>
    <div v-show="isAdministrator" class="isAdministrator"><span :class="isPersonage===1?'selectedAcitive':''" @click="cutPersonage">个人</span><span
        :class="isPersonage===0?'selectedAcitive':''" @click="cutStatus">部门</span></div>
    <div class="dateTime">
      <div>
        <group>
          <datetime v-model="currentDate" format="YYYY-MM"></datetime>
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
    <div class="clockDetails ">
      <div class="pd30"> <span>迟到</span> <span>2次,共60分钟 <i v-show="iconStatus" class="iconfont" @click="cutIcon">&#xe669;</i> <i
            v-show="!iconStatus" class="iconfont" @click="cutIcon">&#xe638;</i></span>

      </div>
      <div v-show="iconStatus">
     <ul class="recordInfo">
              <li><div>sss</div><span>迟到</span></li>
          </ul>
      </div>

    </div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      num: 10,
      iconStatus: true,
      department: '打野部大',
      userName: '亚瑟',
      currentDate: '2019-05',
      isAdministrator: true,
      isPersonage: 1
    }
  },
  mounted () {
    // 获取完整的日期
    let date = new Date()
    let year = date.getFullYear()
    let month = date.getMonth() + 1
    month = month < 10 ? '0' + month : month
    this.currentDate = year.toString() + '-' + month.toString()
  },
  methods: {
    cutIcon () {
      this.iconStatus = !this.iconStatus
    },
    cutPersonage () {
      this.isPersonage = 1
    },
    cutStatus () {
      this.isPersonage = 0
    }
  }
}
</script>

<style lang="scss" scoped>
.attendanceDetails {
      font-size: 32px;
      .attendanceNum{
          display: flex;
          align-items: center;
          text-align: right !important;
      }
  .pd30 {
    padding: 30px;
  }
  .recordInfo{
      padding:10px 30px;
      width: 100%;
        background: rgb(242, 242, 242);
      li{
          display: flex;
          width: 100%;
          justify-content: space-between;

          >div{
  font-size: 34px;
          }
          >span{
              color:#999;
              font-size: 0.2rem;
              display: flex;
              align-items: center;
          }

      }
  }

  .title {
    font-size: 50px;
    padding: 30px;
    text-align: center;
    color: #333;
    font-weight: 800;
    border-bottom: 1px solid black;
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
    border-bottom: 1px solid green;
    color: green;
  }
  .dateTime {
    display: flex;
    padding: 0px  20px;
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
    > div {
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

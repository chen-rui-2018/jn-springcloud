<template>
  <el-col :span="12" :xs="24" :lg="8" >
    <router-link :to="{path: '/planning/details', query: {projectNo: iData.projectNo,title:iData.projectName,day:iData.nowTime }}" class="c-item-grid">
      <div class="flex-column-wrap">
        <h3 class="r1 f-18 ">
          <el-tooltip class="item" effect="dark" content="项目进度：  将子任务的进度相加/任务数 得到任务进度的平均值，就是项目的进度" placement="top">
            <!-- <span class="iconfont">&#xe838;</span> -->
            <svg class="icon" aria-hidden="true">
              <use xlink:href="#icon--dengpao"/>
            </svg>
        </el-tooltip><span class="text-blue"> {{ iData.projectName }} </span></h3>
        <div class="r2 f-25">
          <div class="chart-tips">
            <p>截止 {{ iData.planStopTime }} 剩余任务</p>
            <p><span class="value"><strong> {{ iData.projectSurplusTask }} </strong></span></p>
          </div>
          <table>
            <tbody>
              <tr class="text-nowrap">
                <td class="text-left">剩余任务量</td>
                <td class="text-right" colspan="2">进度：<b class="text-green"> {{ iData.progress }} </b>
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <chart :id="'chart_'+gIndex" :chartopts="iData" height="200px" width="100%" />
                </td>
                <!-- <td width="18" valign="bottom">工期</td> -->
              </tr>
            </tbody>
          </table>
        </div>
        <div class="r3">
          <p class="text-muted f-14">距离计划工期余剩</p>
          <p class="f-18"> {{ iData.surplusTime }} </p>
        </div>
      </div>
      <footer class="bg-blue f-18">
        <!-- {{ iData.projectStatus }} -->
        <span v-show="iData.projectState==='1'">进行中</span>
        <span v-show="iData.projectState==='0'">未开始</span>
        <span v-show="iData.projectState==='2'">已完成</span>
        <i class="iconfont icon-clock" />
      </footer>
    </router-link>
  </el-col>
</template>
<script>
import Chart from '../charts/BurnDownChart'
export default {
  name: 'ProjectGrid',
  components: { Chart },
  props: {
    iData: {
      type: Object,
      default: null
    },
    gIndex: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {}
  },
  mounted() {
    // console.log(this.iData.progress)
  }
}
</script>
<style lang="scss" scoped  >
.c-item-grid {
  display: block;
  margin-bottom: 15px;
  text-align: center;
  background: #fff;
  border-radius: 8px;
  transition: all 0.5s ease;
  .flex-column-wrap {
    height: 260px;
  }
  table {
    width: 100%;
  }
  h3 {
    margin: 0;
    color: #595959;
  }
  .r1 {
    padding: 15px 0px 5px 15px;
    font-size: 22px;
    color: #000;
  }
  .r2 {
    position: relative;
    padding: 0 15px;
    font-size: 14px;
    line-height: 125%;
    color: #999;
    span {
      display: inline-block;
      line-height: 100%;
      font-family: "lsLigth";
    }
  }
  .r3 {
    padding: 15px;
    font-size: 18px;
    color: #000;
    p {
      margin-bottom: 5px;
    }
    span {
      margin: 0 3px;
    }
  }
  b {
    font-weight: normal;
  }
  .c-logo {
    img {
      margin-bottom: 10px;
    }
  }
  footer {
    position: relative;
    padding: 20px 0;
    line-height: 100%;
    border-radius: 0 0 8px 8px;
    .iconfont {
      display: inline-block;
      font-size: 22px;
      position: absolute;
      top: 50%;
      right: 15px;
      line-height: 100%;
      margin-top: -11px;
    }
  }
  &:hover {
    text-decoration: none;
    box-shadow: 0 0 10px #2ca8e7;
    transform: translateY(-3px);
  }
}

.chart-tips {
  text-align: right;
  position: absolute;
  right: 15px;
  top:18px;
  color: #666;
}

.chart-tips .value {
  font-size: 30px;
  color: #333;
}

.c-item-grid .flex-column-wrap {
  height: auto;
}
</style>

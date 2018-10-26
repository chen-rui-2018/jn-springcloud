<template>
  <el-col :span="12" :xs="24" :lg="8" >
    <a class="c-item-grid" href="#/planning/project">
      <div class="flex-column-wrap">
        <h3 class="r1 f-18 "><span class="text-blue"> {{ iData.content.title }} </span></h3>
        <div class="r2 f-25">
          <div class="chart-tips">
            <p>截止 {{ iData.content.deadline }} 剩余任务</p>
            <p><span class="value"><strong> {{ iData.content.remainingPercentage }} </strong></span></p>
          </div>
          <table>
            <tbody>
              <tr class="text-nowrap">
                <td class="text-left">剩余任务量</td>
                <td class="text-right" colspan="2">进度：<b class="text-green"> {{ iData.content.scheduleStatus }} </b>
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <chart :id="'chart_'+gIndex" :chartopts="iData.chart" height="200px" width="100%" />
                </td>
                <td width="18" valign="bottom">工期</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div class="r3">
          <p class="text-muted f-14">距离计划工期余剩</p>
          <p class="f-18"> {{ iData.content.daysRemaining }} </p>
        </div>
      </div>
      <footer class="bg-blue f-18">
        {{ iData.content.projectStatus }}
        <i class="iconfont icon-clock" />
      </footer>
    </a>
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
    padding: 15px;
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
  top: 40px;
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

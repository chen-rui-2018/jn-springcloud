<template>
  <div>
    <!-- {{ opts[0][0] }} -->
    <div class="flex-box filter-bar">
      <ul class="flex-item flex-box">
        <li
          v-for="(item,index) in projectStatusList"
          :key="index" >
          <el-button :type="index===0 ? 'primary' : ' '" size="medium" itype="projectStatus" @click ="filterStatus">{{ item }}</el-button>
        </li>
      </ul>
      <ul class="flex-box">
        <li><el-button size="medium" plain>+ 新增任务</el-button></li>
        <li><a href="#">返回</a></li>
      </ul>
    </div>
    <div class="flex-box filter-bar">
      <ul class="flex-item flex-box">
        <li
          v-for="(item,index) in scheduleStatusList"
          :key="index">
          <el-button :type="index===0 ? 'primary' : ' '" size="medium" itype="scheduleStatus" @click ="filterStatus" >{{ item }}</el-button>
        </li>
      </ul>
      <ul class="flex-box flex-box">
        <li><el-button size="medium" plain>剩余时间排序</el-button></li>
        <li><el-button size="medium" plain>进度排序</el-button></li>
        <li>
          <el-input v-model="searchKeyword" class="input-with-select" placeholder="请输入内容" >
            <el-button slot="append" icon="el-icon-search" />
          </el-input>
        </li>
      </ul>
    </div>
    <el-row :gutter="15">
      <project-grid v-for="(item,index) in dataList" :i-data="item.data" :g-index="index" :key="index" />
    </el-row>
  </div>
</template>
<script>
import $ from 'jquery'
import projectGrid from '../components/projectGrid'
// import axios from 'axios'
export default {
  name: 'ProjectPage',
  components: { projectGrid },
  data() {
    return {
      opts: [
        {
          data: {
            content: {
              title: '19号楼建设任务',
              scheduleStatus: '正常',
              deadline: '8月6日',
              remainingPercentage: '20%',
              daysRemaining: '31天5小时',
              projectStatus: '进行中'
            },
            chart: {
              uncompletedArr: ['100%', '90%', '70%', '20%'],
              cycle: ['6月', '7月', '8月', '9月', '10月', '11月', '12月'],
              currentMonth: '9月'
            }
          }
        },
        {
          data: {
            content: {
              title: '园区路灯安装任务',
              scheduleStatus: '正常',
              deadline: '8月6日',
              remainingPercentage: '100%',
              daysRemaining: '31天5小时',
              projectStatus: '未完成'
            },
            chart: {
              uncompletedArr: ['100%', '100%', '100%', '100%'],
              cycle: ['5月', '7月', '8月', '9月'],
              currentMonth: '9月'
            }
          }
        },
        {
          data: {
            content: {
              title: '园区路灯安装任务22',
              scheduleStatus: '正常',
              deadline: '8月6日',
              remainingPercentage: '100%',
              daysRemaining: '31天5小时',
              projectStatus: '已完成'
            },
            chart: {
              uncompletedArr: ['100%', '100%', '100%', '100%'],
              cycle: ['5月', '7月', '8月', '9月'],
              currentMonth: '9月'
            }
          }
        },
        {
          data: {
            content: {
              title: '19号楼建设任务',
              scheduleStatus: '延迟',
              deadline: '8月6日',
              remainingPercentage: '20%',
              daysRemaining: '31天5小时',
              projectStatus: '进行中'
            },
            chart: {
              uncompletedArr: ['100%', '90%', '70%', '30%'],
              cycle: ['6月', '7月', '8月', '9月', '10月', '11月', '12月'],
              currentMonth: '9月'
            }
          }
        },
        {
          data: {
            content: {
              title: '园区路灯安装任务123',
              scheduleStatus: '提前',
              deadline: '8月6日',
              remainingPercentage: '20%',
              daysRemaining: '31天5小时',
              projectStatus: '未完成'
            },
            chart: {
              uncompletedArr: ['100%', '100%', '100%', '20%'],
              cycle: ['5月', '7月', '8月', '9月'],
              currentMonth: '9月'
            }
          }
        },
        {
          data: {
            content: {
              title: '园区路灯安装任务22',
              scheduleStatus: '正常',
              deadline: '8月6日',
              remainingPercentage: '100%',
              daysRemaining: '31天5小时',
              projectStatus: '已完成'
            },
            chart: {
              uncompletedArr: ['100%', '70%', '50%', '0%'],
              cycle: ['5月', '7月', '8月', '9月'],
              currentMonth: '9月',
              options: {}
            }
          }
        }
      ],
      searchKeyword: '',
      projectStatus: '',
      scheduleStatus: ''
      // opts: null
    }
  },
  computed: {
    scheduleStatusLabel() {
      return this.scheduleStatus.replace('进度', '')
    },
    dataList() {
      const projectStatusLabel = (this.projectStatus === '全部' ? '' : this.projectStatus)
      const scheduleStatusLabel = (this.scheduleStatusLabel === '全部' ? '' : this.scheduleStatusLabel)
      return this.opts.filter(
        d => d.data.content.projectStatus.includes(projectStatusLabel) && d.data.content.scheduleStatus.includes(scheduleStatusLabel)
      )
    },
    projectStatusList: function() {
      const projectStatusList = this.opts.map(function(item) {
        return item.data.content.projectStatus
      })
      projectStatusList.unshift('全部')
      return [...new Set(projectStatusList)]
    },
    scheduleStatusList: function() {
      const statusList = this.opts.map(function(item) {
        return '进度' + item.data.content.scheduleStatus
      })
      statusList.unshift('全部')
      return [...new Set(statusList)]
    }
  },
  mounted() {
    // axios.get('https://easy-mock.com/mock/5bd532347c1abe61ecb48935/test/planning').then(response => (this.$set(this, 'opts', response.data.testdata)))
  },
  methods: {
    filterStatus: function(event) {
      const obj = $(event.currentTarget)
      const objType = obj.attr('itype')
      obj.closest('ul').find('button').removeClass('el-button--primary')
      obj.addClass('el-button--primary')
      if (objType === 'projectStatus') {
        this.projectStatus = obj.text()
      }
      if (objType === 'scheduleStatus') {
        this.scheduleStatus = obj.text()
      }
    }
  }
}
</script>
<style lang='scss' scoped  >
@import "project.scss";
</style>

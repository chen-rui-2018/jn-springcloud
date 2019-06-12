<template>
  <div v-loading="listLoading" class="eneryStatistics">
    <el-form :inline="true" :model="listQuery" class="header">
      <el-form-item label="设备类型:">
        <el-select v-model="listQuery.type" placeholder="请选择" clearable>
          <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="设备名称:">
        <el-input
          v-model="listQuery.meterName"
          maxlength="20"
          placeholder="请输入设备名称"
          clearable
          @keyup.enter.native="handleFilter" />
      </el-form-item>

      <el-form-item label="楼宇位置:">
        <el-input v-model="listQuery.position" maxlength="20" placeholder="请输入设备位置" clearable @keyup.enter.native="handleFilter" />
      </el-form-item>
      <el-form-item label="采集时间:" >
        <el-date-picker v-model="listQuery.dealDate" value-format="yyyy-MM-dd" type="date" placeholder="选择采集时间" />
      </el-form-item>
      <!-- <div style="display:inline-block;float:right"> -->
      <el-button class="filter-item" type="primary" icon="el-icon-search" @click="init()">查询</el-button>
      <!-- </div> -->
    </el-form>
    <h3>日均能耗</h3>
    <div id="myCharts" style="width:100%;height:400px;" />
    <!-- 表格 -->
    <el-table ref="multipleTable" :data="energyList" border fit highlight-current-row style="width: 100%;height:100%;">
      <!-- <el-table-column
        type="selection"
        width="55"/> -->
      <el-table-column type="index" width="60" label="序号" align="center" />
      <!-- 表格第二列  姓名 -->
      <el-table-column label="设备类型" align="center" prop="type" />
      <el-table-column label="楼宇名称" align="center" prop="position"/>
      <el-table-column label="企业名称" align="center" prop="companyName" />
      <el-table-column label="设备名称" align="center" prop="meterName" />
      <el-table-column label="采集标识" align="center" prop="flag" />
      <el-table-column label="能耗（千瓦时）" align="center" prop="allEnergy">
        <template slot-scope="scope">
          <span v-show="scope.row.threshold=='高能耗'" class="text-red">{{ scope.row.allEnergy }}</span>
          <span v-show="scope.row.threshold==='低能耗'" class="text-green">{{ scope.row.allEnergy }}</span>
          <span v-show="scope.row.threshold==='正常'" >{{ scope.row.allEnergy }}</span>
        </template>
      </el-table-column>
      <el-table-column label="能耗状态" align="center" prop="threshold">
        <template slot-scope="scope">
          <span v-show="scope.row.threshold=='高能耗'" class="text-red">{{ scope.row.threshold }}</span>
          <span v-show="scope.row.threshold==='低能耗'" class="text-green">{{ scope.row.threshold }}</span>
          <span v-show="scope.row.threshold==='正常'" >{{ scope.row.threshold }}</span>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination
      v-show="total>0"
      :current-page="listQuery.page"
      :page-sizes="[5,10,20,30, 50]"
      :page-size="listQuery.rows"
      :total="total"
      class="tablePagination"
      background
      layout="total, sizes, prev, pager, next, jumper"
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange" />

  </div>
</template>

<script>
import {
  api
} from '@/api/axios'
export default {
  data() {
    return {
      typeOptions: [
        { value: 1, label: '公共照明' },
        { value: 2, label: '空调用电' },
        { value: 3, label: '楼层用电' }
      ],
      energyList: [],
      listLoading: false,
      listQuery: {
        type: '',
        page: 1,
        rows: 10,
        dealDate: '',
        meterName: '',
        position: ''
      },
      total: 0
    }
  },
  mounted() {
    this.init()
  },
  methods: {
    init() {
      // 页面初始化
      console.log(this.listQuery.dealDate)
      // this.listLoading = true
      api(`${this.GLOBAL.parkUrl}meter/trendChartDetail`, {
        type: this.listQuery.type === '' ? null : this.listQuery.type,
        dealDate: this.listQuery.dealDate === '' ? null : this.listQuery.dealDate,
        meterName: this.listQuery.meterName === '' ? null : this.listQuery.meterName,
        position: this.listQuery.position === '' ? null : this.listQuery.position,
        page: this.listQuery.page,
        rows: this.listQuery.rows

      }, 'post').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.energyList = res.data.data.rows
          this.total = res.data.data.total
          if (this.energyList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
      api(`${this.GLOBAL.parkUrl}meter/trendChart`, {
        type: this.listQuery.type === '' ? null : this.listQuery.type,
        dealDate: this.listQuery.dealDate === '' ? null : this.listQuery.dealDate,
        meterName: this.listQuery.meterName === '' ? null : this.listQuery.meterName,
        position: this.listQuery.position === '' ? null : this.listQuery.position

      }, 'post').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.$nextTick(() => { this.myCharts(res.data) })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 表格分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.init()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.init()
    },
    myCharts(data) {
      if (data.data) {
        const xData = []
        const energyArr = []
        data.data.forEach(val => {
          xData.push(val.dealDateValue)
          energyArr.push(val.allEnergy)
        })
        // 基于准备好的dom，初始化echarts实例
        var myChart = this.$echarts.init(document.getElementById('myCharts'))
        // 指定图表的配置项和数据
        var option = {
          tooltip: {
            trigger: 'axis'
          },
          xAxis: {
            // name: '时',
            boundaryGap: false,
            axisTick: {
              alignWithLabel: true
            },
            type: 'category',
            // data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
            data: xData
          },
          yAxis: {
            name: '每日用电趋势',
            type: 'value'
          },
          series: [
            {
              // data: [820, 932, 901, 634, 890, 1030, 720],
              data: energyArr,
              name: '当日能耗',
              type: 'line',
              itemStyle: {
                normal: {
                  color: 'rgb(255, 155, 121)', // 这点颜色
                  lineStyle: {
                    color: 'rgb(255, 155, 121)'// 折线颜色
                  }
                }
              }
            }
          ]
        }
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option)
        window.addEventListener('resize', () => {
          myChart.resize()
        })
      }
    }
  }
}
</script>

<style lang="scss">
.eneryStatistics {
  .header {
    .el-input--medium .el-input__inner {
      width: 160px;
    }
    .el-date-editor.el-input, .el-date-editor.el-input__inner{
      width: 160px;
    }
    .el-date-editor.el-input__inner:nth-child(1) {
      margin-right: 50px;
    }
  }
  h3{
      margin-left:20px;
  }
}
</style>

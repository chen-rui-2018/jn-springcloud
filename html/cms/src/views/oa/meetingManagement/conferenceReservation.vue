<template>
  <div class="conferenceReservation">
    <div class="date">

      <!-- 年份 月份 -->
      <div class="month">
        <i
          class="el-icon-arrow-left"
          @click="pickPre(currentYear,currentMonth)"
        />
        <i>{{ currentYear }} 年 {{ currentMonth }} 月</i>
        <i
          class="el-icon-arrow-right"
          @click="pickNext(currentYear,currentMonth)"
        />
      </div>
      <!-- 星期 -->
      <ul class="weekdays">
        <li>一</li>
        <li>二</li>
        <li>三</li>
        <li>四</li>
        <li>五</li>
        <li style="color:#0A0A0A">六</li>
        <li style="color:#0A0A0A">日</li>
      </ul>
      <!-- 日期 -->
      <div class="bodyDiv">
        <ul
          v-for="(value,index1) in daysUL"
          :key="index1"
          class="days"
        >
          <li
            v-for="(day, index) in value"
            :key="index"
            :class="[{'ban':isBan[index+index1*7]},{'xiu':isXiu[index+index1*7]}]"
            @click="pick(day,index+index1*7)"
          >
            <!--本月-->
            <span
              v-if="day.getMonth()+1 != currentMonth"
              :class="{'selected':isSelected[index+index1*7]}"
              class="other-month"
            >{{ day.getDate() }}</span>
            <span
              v-else
              :class="{'selected':isSelected[index+index1*7]}"
            >
              <!--今天-->
              <span
                v-if="day.getFullYear() == new Date().getFullYear() && day.getMonth() == new Date().getMonth() && day.getDate() == new Date().getDate()"
                class="todyActive"
              >{{ day.getDate() }}</span>
              <span v-else>{{ day.getDate() }}</span>
            </span>
          </li>

        </ul>
      </div>
    </div>
    <div
      v-if="errorTime"
      class="table"
    >
      <el-table
        :data="rowTableData"
        :span-method="arraySpanMethod"
      >
        <el-table-column
          label="会议室"
          align="center"
        >
          <el-table-column
            type="index"
            label="序号"
            align="center"
          />
          <el-table-column
            prop="[0].title"
            label="名称"
            align="center"
          />
          <el-table-column
            prop="[0].building"
            label="位置"
            align="center"
          />
        </el-table-column>
        <el-table-column
          label="上午"
          align="center"
        >
          <el-table-column
            label="9:00"
            prop="[0]"
            align="center"
            min-
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[0].status=='0'"
                :post-id="scope.row[0].id"
                :post-title="scope.row[0].title"
                :post-time="'9:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[0].status=='1'"
                :post-title="scope.row[0].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="9:30"
            prop="[1]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[1].status=='0'"
                :post-id="scope.row[1].id"
                :post-title="scope.row[1].title"
                :post-time="'9:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[1].status=='1'"
                :post-title="scope.row[1].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="10:00"
            prop="[2]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[2].status=='0'"
                :post-id="scope.row[2].id"
                :post-title="scope.row[2].title"
                :post-time="'10:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[2].status=='1'"
                :post-title="scope.row[2].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="10:30"
            prop="[3]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[3].status=='0'"
                :post-id="scope.row[3].id"
                :post-title="scope.row[3].title"
                :post-time="'10:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[3].status=='1'"
                :post-title="scope.row[3].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="11:00"
            prop="[4]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[4].status=='0'"
                :post-id="scope.row[4].id"
                :post-title="scope.row[4].title"
                :post-time="'11:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[4].status=='1'"
                :post-title="scope.row[4].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="11:30"
            prop="[5]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[5].status=='0'"
                :post-id="scope.row[5].id"
                :post-title="scope.row[5].title"
                :post-time="'11:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[5].status=='1'"
                :post-title="scope.row[5].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="12:00"
            prop="[6]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[6].status=='0'"
                :post-id="scope.row[6].id"
                :post-title="scope.row[6].title"
                :post-time="'12:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[6].status=='1'"
                :post-title="scope.row[6].name"
            /></template>
          </el-table-column>
        </el-table-column>
        <el-table-column
          label="下午"
          align="center"
        >
          <el-table-column
            label="13:30"
            prop="[7]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[7].status=='0'"
                :post-id="scope.row[7].id"
                :post-title="scope.row[7].title"
                :post-time="'13:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[7].status=='1'"
                :post-title="scope.row[7].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="14:00"
            prop="[8]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[8].status=='0'"
                :post-id="scope.row[8].id"
                :post-title="scope.row[8].title"
                :post-time="'14:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[8].status=='1'"
                :post-title="scope.row[8].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="14:30"
            prop="[9]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[9].status=='0'"
                :post-id="scope.row[9].id"
                :post-title="scope.row[9].title"
                :post-time="'14:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[9].status=='1'"
                :post-title="scope.row[9].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="15:00"
            prop="[10]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[10].status=='0'"
                :post-id="scope.row[10].id"
                :post-title="scope.row[10].title"
                :post-time="'15:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[10].status=='1'"
                :post-title="scope.row[10].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="15:30"
            prop="[11]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[11].status=='0'"
                :post-id="scope.row[11].id"
                :post-title="scope.row[11].title"
                :post-time="'15:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[11].status=='1'"
                :post-title="scope.row[11].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="16:00"
            prop="[12]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[12].status=='0'"
                :post-id="scope.row[12].id"
                :post-title="scope.row[12].title"
                :post-time="'16:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[12].status=='1'"
                :post-title="scope.row[12].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="16:30"
            prop="[13]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[13].status=='0'"
                :post-id="scope.row[13].id"
                :post-title="scope.row[13].title"
                :post-time="'16:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[13].status=='1'"
                :post-title="scope.row[13].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="17:00"
            prop="[14]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[14].status=='0'"
                :post-id="scope.row[14].id"
                :post-title="scope.row[14].title"
                :post-time="'17:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[14].status=='1'"
                :post-title="scope.row[14].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="17:30"
            prop="[15]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[15].status=='0'"
                :post-id="scope.row[15].id"
                :post-title="scope.row[15].title"
                :post-time="'17:30'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[15].status=='1'"
                :post-title="scope.row[15].name"
            /></template>
          </el-table-column>
          <el-table-column
            label="18:00"
            prop="[16]"
            align="center"
            min-width="50"
          >
            <template slot-scope="scope">
              <meeting-div1
                v-if="scope.row[16].status=='0'"
                :post-id="scope.row[16].id"
                :post-title="scope.row[16].title"
                :post-time="'18:00'"
                @meeting_order="meeting_order"
              />
              <meeting-div2
                v-if="scope.row[16].status=='1'"
                :post-title="scope.row[16].name"
            /></template>
          </el-table-column>
        </el-table-column>
      </el-table>
      <div class="pagination-container">
        <el-pagination
          v-show="total>0"
          :current-page="listQuery.page"
          :page-sizes="[10,20,30,50]"
          :page-size="listQuery.rows"
          :total="total"
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </div>
    </div>
    <div
      v-if="!errorTime"
      class="errorStyle"
    >{{ errorText }}</div>
  </div>
</template>

<script>
import { api } from '@/api/oa/meetingManagement'
export default {
  name: 'Date',
  components: {
    // 组件-新加
    'meeting-div1': {
      // 预约组件
      props: ['postId', 'postTitle', 'postTime'],
      template:
        '<button class="textStyle"  @click="meeting_order(postId,postTitle,postTime)">预约</button>',
      methods: {
        meeting_order(id, title, time) {
          // 会议预约
          this.$emit('meeting_order', id, title, time)
        }
      }
    },
    'meeting-div2': {
      // 会议组件
      props: ['postTitle'],
      template: '<div class="textBgc" >{{postTitle}}</div>',
      methods: {}
    }
  },

  data() {
    return {
      Isdisabled: '',
      errorTime: true,
      errorText: '',
      listQuery: {
        page: 1,
        rows: 10,
        meetingStartTime: ''
      },
      total: 0,
      tableData3: [],
      currentYear: 1970, // 年份
      currentMonth: 1, // 月份
      currentDay: 1, // 日期
      currentWeek: 1, // 星期
      firstWeek: 1,
      days: [],
      daysUL: [],
      params: {
        selectDay: '',
        type: ''
      },
      isSelected: [],
      isBan: [],
      isXiu: [],
      restDays: {
        year: '',
        month: '',
        day: '',
        resttype: '',
        restdate: ''
      },
      restDaysList: [],
      banList: [],
      xiuList: [],
      selectIndex: '',
      rowTableData: [
        // 列表横向数据
      ],
      leftCol: 3 // 数据左侧列数
    }
  },

  created() {
    this.initList()
    this.initData(null)
  },

  methods: {
    // 格式化日期
    formatDate(year, month, day) {
      const y = year
      let m = month
      if (m < 10) m = `0${m}`
      let d = day
      if (d < 10) d = `0${d}`
      return `${y}/${m}/${d}`
    },
    initData(cur) {
      let date = ''
      if (cur) {
        date = new Date(cur)
      } else {
        date = new Date()
      }
      this.currentDay = date.getDate()// 今日日期 几号
      this.currentYear = date.getFullYear() // 当前年份
      this.currentMonth = date.getMonth() + 1 // 当前月份
      this.currentWeek = date.getDay() // 1...6,0   // 今天是星期几
      if (this.currentMonth < 10) {
        this.currentMonth = '0' + this.currentMonth
      }
      if (this.currentDay < 10) {
        this.currentDay = '0' + this.currentDay
      }
      this.listQuery.meetingStartTime =
        this.currentYear + '/' + this.currentMonth + '/' + this.currentDay
      // 当前月的第一天是星期几
      date.setDate(1)
      this.firstWeek = date.getDay()

      if (this.firstWeek === 0) {
        this.firstWeek = 7
      }
      const str = this.formatDate(this.currentYear, this.currentMonth, 1) // 今日日期 年-月-日
      this.days.length = 0

      // 今天是周日，放在第一行第7个位置，前面6个 这里默认显示一周，如果需要显示一个月，则第二个循环为 i<= 42- this.firstWeek
      for (let i = this.firstWeek - 1; i >= 0; i -= 1) {
        const d = new Date(str)
        d.setDate(d.getDate() - i)
        this.days.push(d)
      }
      // 处理1号是星期天为 7 的情况， 为7天就直接放在daysUL里
      if (this.days.length % 7 === 0) {
        this.daysUL.push(this.days)
        this.days = []
      }

      for (let i = 1; i <= 42 - this.firstWeek; i += 1) {
        const d = new Date(str)
        d.setDate(d.getDate() + i)
        this.days.push(d) // 一个 days 就是一行7天  daysUL 就是个数组，里面有六个days  就是六行42天
        if (this.days.length % 7 === 0) {
          this.daysUL.push(this.days)
          this.days = [] // 清空重新存放天数
        }
      }
    },

    // 上一個月   传入当前年份和月份
    pickPre(year, month) {
      this.daysUL = []
      this.isSelected = []
      const d = new Date(this.formatDate(year, month, 1))
      d.setDate(0)
      this.initData(this.formatDate(d.getFullYear(), d.getMonth() + 1, 1))
    },

    // 下一個月   传入当前年份和月份
    pickNext(year, month) {
      this.daysUL = []
      this.isSelected = []
      const d = new Date(this.formatDate(year, month, 1))
      d.setDate(42)
      this.initData(this.formatDate(d.getFullYear(), d.getMonth() + 1, 1))
    },
    returnNow() {
      this.daysUL = []
      this.initData(null)
    },
    // 当前选择日期
    pick(date, index) {
      this.selectIndex = index
      this.isSelected = []
      // 当前选中的日期
      this.params.selectDay = this.formatDate(
        date.getFullYear(),
        date.getMonth() + 1,
        date.getDate()
      )
      for (let i = 0; i < 42; i++) {
        if (index === i) {
          this.isSelected.push(true)
          continue
        }
        this.isSelected.push(false)
      }
      var selectDay = new Date(this.params.selectDay)
      var today_time = new Date().getTime()
      var time = (today_time - selectDay) / 1000 / 60 / 60 / 24
      if (time > 1) {
        alert('对不起,您不能预约当前日期之前的会议,请重新选择')
        this.errorTime = false
        this.errorText = '对不起,您不能预约当前日期之前的会议,请重新选择'
        return
      } else if (time < -2) {
        alert('对不起,您只能预约3天之内的会议,请重新选择')
        this.errorTime = false
        this.errorText = '对不起,您只能预约3天之内的会议,请重新选择'
        return
      } else {
        this.errorTime = true
      }
      this.listQuery.meetingStartTime = this.params.selectDay
      this.initList()
    },

    // 页面初始化
    initList() {
      api('oa/oaMeetingRoom/orderList', this.listQuery).then(res => {
        if (res.data.code === '0000') {
          this.staticData = res.data.data.rows
          this.total = res.data.data.total
          this.calcDataA()
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 判断当前时间和按钮时间
    // befoTime(time) {
    //   // var time = '09:00'
    //   var buttonTime = this.listQuery.meetingStartTime + ' ' + '09:00' + ':00'
    //   var today_time = new Date().getTime()
    //   if (new Date(buttonTime) - today_time < 0) {
    //     this.Isdisabled = false
    //     return true
    //   } else {
    //     this.Isdisabled = true
    //     return false
    //   }
    // },
    // 点击预约按钮的时候
    meeting_order(id, title, time) {
      // 会议预约
      var timeArr = time.split(':')
      if (timeArr[0] < 10) {
        time = '0' + time
      }
      var clickTime = this.listQuery.meetingStartTime + ' ' + time + ':00'
      var today_time = new Date().getTime()
      if (new Date(clickTime) - today_time < 0) {
        alert('对不起,会议预约时间必须大于当前时间,请重新选择')
        return
      }
      this.$router.push({
        name: 'meetingApplication',
        query: {
          title: '会议申请',
          meetId: id,
          name: title,
          currentTime: time,
          currentDate: this.listQuery.meetingStartTime
        }
      })
    },
    calTdMerge(start, end) {
      var _start = start
        // .replace(/^.*T/, '')
        // .slice(0, 5)
        .split(':')
      var _end = end
        // .replace(/^.*T/, '')
        // .slice(0, 5)
        .split(':')
      function getColNum(num) {
        var _num_a = parseInt(num[0])
        var _num_b = parseInt(num[1])
        if (_num_a === 9) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 0
          } else {
            return 1
          }
        } else if (_num_a === 10) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 2
          } else {
            return 3
          }
        } else if (_num_a === 11) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 4
          } else {
            return 5
          }
        } else if (_num_a === 12) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 6
          } else {
            return 6
          }
        } else if (_num_a === 13) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 7
          } else {
            return 7
          }
        } else if (_num_a === 14) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 8
          } else {
            return 9
          }
        } else if (_num_a === 15) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 10
          } else {
            return 11
          }
        } else if (_num_a === 16) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 12
          } else {
            return 13
          }
        } else if (_num_a === 17) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 14
          } else {
            return 15
          }
        } else if (_num_a === 18) {
          if (_num_b >= 0 && _num_b <= 29) {
            return 16
          } else {
            return 16
          }
        }
      }
      var _start_col = getColNum(_start)
      var _end_col = getColNum(_end)
      var _arr = []
      for (var i = _start_col; i <= _end_col; i++) {
        _arr.push(i)
      }
      return _arr
    },
    calcDataA() {
      // 渲染横向数据与纵向数据
      var arr_row = []
      var arr_data = this.staticData
      for (var i = 0; i < arr_data.length; i++) {
        var _arr = []
        for (var j = 0; j < 17; j++) {
          var obj = {
            status: 0,
            id: arr_data[i].id,
            num: arr_data[i].roomNumber,
            building: arr_data[i].building,
            title: arr_data[i].name,
            name: ''
          }
          _arr.push(obj)
        }
        for (var k = 0; k < arr_data[i].meetingList.length; k++) {
          var startTime = (arr_data[i].meetingList[k].startTime).replace(/^.* /, '').slice(0, 5)
          var endTime = (arr_data[i].meetingList[k].endTime).replace(/^.* /, '').slice(0, 5)
          var get_arr = this.calTdMerge(startTime, endTime)
          for (var l = 0; l < get_arr.length; l++) {
            var _index = get_arr[l]
            if (l === 0) {
              _arr[_index].status = 1
              _arr[_index].size = get_arr.length
            } else {
              _arr[_index].status = 2
            }
            _arr[_index].id = arr_data[i].meetingList[k].id
            _arr[_index].name = arr_data[i].meetingList[k].title
          }
        }
        arr_row.push(_arr)
      }
      this.rowTableData = arr_row
    },
    arraySpanMethod({ row, column, rowIndex, columnIndex }) {
      // 合并单元格
      var _num = this.leftCol
      if (this.rowTableData.length === 0) {
        return [1, 1]
      }
      if (columnIndex >= _num) {
        if (this.rowTableData[rowIndex][columnIndex - _num].status === 0) {
          return [1, 1]
        } else if (
          this.rowTableData[rowIndex][columnIndex - _num].status === 1
        ) {
          return [1, this.rowTableData[rowIndex][columnIndex - _num].size]
        } else if (
          this.rowTableData[rowIndex][columnIndex - _num].status === 2
        ) {
          return [0, 0]
        }
      }
    },

    // 表格分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>

<style lang="scss">
.conferenceReservation {
  display: flex;
  display: -webkit-box;

  .el-table .cell,
  .el-table th div,
  .el-table--border td:first-child .cell,
  .el-table--border th:first-child .cell {
    padding: 0px;
  }

  .table {
    margin-left: 15px;
    flex: 8;
    .textStyle {
      color: #090;
      cursor: pointer;
      background: #fff;
      outline: none;
      border: none;
    }
    .disabledStyle{
      color:#666;
      background: #fff;
      outline: none;
      border: none;
      cursor: default;
    }
    .textBgc {
      color: rgb(0, 176, 240);
    }
    .el-pagination {
      margin-top: 15px;
    }
  }
  .month {
    font-size: 24px;
    text-align: center;
    margin-top: 20px;
  }

  .weekdays {
    background-color: #20a0ff;
    opacity: 0.6;
    display: flex;
    font-size: 16px;
    margin-top: 20px;
  }

  .days {
    display: flex;
  }

  li {
    flex: 1;
    font-size: 20px;
    /* width: 50px; */
    list-style-type: none;
    text-align: center;
    margin: 2px 0px;
    /* line-height: 60px; */
    cursor: pointer;
  }
  .selected {
    display: inline-block;
    width: 30px;
    /* height: 30px; */
    color: #fff;
    border-radius: 50%;
    background-color: #1e90ff;
  }
  .todyActive {
    display: inline-block;
    color: #fff;
    border-radius: 50%;
    background-color: #324057;
  }

  .other-month {
    color: #eec591;
  }
  .date {
    i {
      margin-right: 20px;
      cursor: pointer;
    }
    ul,
    menu,
    dir {
      padding-inline-start: 0px;
    }
  }
}
.errorStyle {
  line-height: 392px;
  margin: 0 auto;
}
</style>

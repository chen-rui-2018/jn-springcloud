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
    <el-table :data="tableData3">
      <el-table-column label="会议室" align="center">
        <el-table-column prop="name" label="编号" align="center" />
        <el-table-column prop="name" label="名称" align="center"/>
        <el-table-column prop="name" label="位置" align="center"/>
      </el-table-column>
      <el-table-column label="上午" align="center">
        <el-table-column prop="name" label="9:00" align="center" width="40"/>
        <el-table-column prop="name" label="9:30" align="center" width="40"/>
        <el-table-column prop="name" label="10:00" align="center" width="40"/>
        <el-table-column prop="name" label="10:30" align="center" width="40"/>
        <el-table-column prop="name" label="11:00" align="center" width="40"/>
        <el-table-column prop="name" label="11:30" align="center" width="40"/>
        <el-table-column prop="name" label="12:00" align="center" width="40"/>
      </el-table-column>
      <el-table-column label="下午" align="center">
        <el-table-column prop="name" label="13:30" align="center" width="40"/>
        <el-table-column prop="name" label="14:00" align="center" width="40"/>
        <el-table-column prop="name" label="14:30" align="center" width="40"/>
        <el-table-column prop="name" label="15:00" align="center" width="40"/>
        <el-table-column prop="name" label="15:30" align="center" width="40"/>
        <el-table-column prop="name" label="16:00" align="center" width="40"/>
        <el-table-column prop="name" label="16:30" align="center" width="40"/>
        <el-table-column prop="name" label="17:00" align="center" width="40"/>
        <el-table-column prop="name" label="17:30" align="center" width="40"/>
        <el-table-column prop="name" label="18:00" align="center" width="40"/>
      </el-table-column>
    </el-table>
    <el-button class="filter-item" style="margin-left: 10px" type="primary" @click="handle">新增</el-button>
  </div>
</template>

<script>
export default {
  name: 'Date',

  data() {
    return {
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
      selectIndex: ''
    }
  },

  created() {
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
      return `${y}-${m}-${d}`
    },

    initData(cur) {
      let date = ''
      if (cur) {
        date = new Date(cur)
      } else {
        date = new Date()
      }
      this.currentDay = date.getDate() // 今日日期 几号
      this.currentYear = date.getFullYear() // 当前年份
      this.currentMonth = date.getMonth() + 1 // 当前月份
      this.currentWeek = date.getDay() // 1...6,0   // 今天是星期几

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
      // console.log(this.params.selectDay)
      for (let i = 0; i < 42; i++) {
        if (index === i) {
          this.isSelected.push(true)
          continue
        }
        this.isSelected.push(false)
      }
    },
    handle() {
      this.$router.push({ name: 'meetingApplication' })
    }
  }
}
</script>

<style lang="scss">

.conferenceReservation{
    display: flex;
    .el-table .cell, .el-table th div, .el-table--border td:first-child .cell, .el-table--border th:first-child .cell {
  padding: 0px ;
}

.el-table{
    margin-left: 15px;
    flex:8;
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
  margin:2px  0px;
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
i {
  margin-right: 30px;
  cursor: pointer;
}

.other-month {
  color: #eec591;
}
}
</style>

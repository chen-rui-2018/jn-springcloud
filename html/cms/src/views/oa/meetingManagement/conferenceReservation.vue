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
    <div class="table">
      <el-table :data="tableData3">
        <el-table-column label="会议室" align="center">
          <el-table-column prop="roomNumber" label="编号" align="center" />
          <el-table-column prop="name" label="名称" align="center"/>
          <el-table-column prop="position" label="位置" align="center"/>
        </el-table-column>
        <el-table-column label="上午" align="center">
          <el-table-column label="9:00" prop="time0" align="center" width="40">
            <template slot-scope="scope">
              <span :class="scope.row.time0=='可预约' ? 'text-green' : 'text-red'" @click="handle(scope.row)" >{{ scope.row.time0 }}</span>
            </template>
          </el-table-column>
          <el-table-column label="9:30" prop="time0" align="center" width="40">
            <template slot-scope="scope">
              <span :class="scope.row.time1=='可预约' ? 'text-green' : 'text-red'" >{{ scope.row.time1 }}</span>
            </template>
          </el-table-column>
          <!-- <el-table-column label="9:30" prop="time1" align="center" width="40"/> -->
          <el-table-column label="10:00" prop="time2" align="center" width="40"/>
          <el-table-column label="10:30" prop="time3" align="center" width="40"/>
          <el-table-column label="11:00" prop="time4" align="center" width="40"/>
          <el-table-column label="11:30" prop="time5" align="center" width="40"/>
          <el-table-column label="12:00" prop="time6" align="center" width="40"/>
        </el-table-column>
        <el-table-column label="下午" align="center">
          <!-- <el-table-column v-for="(item,index) in downData" :key="index" :label="item" prop="bookable" align="center" width="40"/> -->

          <!-- <el-table-column prop="time" label="13:30" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="14:00" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="14:30" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="15:00" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="15:30" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="16:00" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="16:30" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="17:00" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="17:30" align="center" width="40">可预约 </el-table-column>
          <el-table-column prop="time" label="18:00" align="center" width="40">可预约 </el-table-column> -->
          <el-table-column label="13:30" prop="time7" align="center" width="40"/>
          <el-table-column label="14:00" prop="time8" align="center" width="40"/>
          <el-table-column label="14:30" prop="time9" align="center" width="40"/>
          <el-table-column label="15:00" prop="time10" align="center" width="40"/>
          <el-table-column label="15:30" prop="time11" align="center" width="40"/>
          <el-table-column label="16:00" prop="time12" align="center" width="40"/>
          <el-table-column label="16:30" prop="time13" align="center" width="40"/>
          <el-table-column label="17:00" prop="time14" align="center" width="40"/>
          <el-table-column label="17:30" prop="time15" align="center" width="40"/>
          <el-table-column label="18:00" prop="time16" align="center" width="40"/>
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

    <!-- <el-button class="filter-item" style="margin-left: 10px" type="primary" @click="handle">新增</el-button> -->
  </div>
</template>

<script>
import {
  api
} from '@/api/oa/meetingManagement'
export default {
  name: 'Date',

  data() {
    return {
      downData: ['13:30', '14:00', '14:30', '15:00', '15:30', '16:00', '16:30', '17:00', '17:30', '18:00'],
      upData: ['9:00', '9:30', '10:00', '10:30', '11:00', '11:30', '12:00'],
      compareData: [900, 930, 1000, 1030, 1100, 1130, 1200, 1330, 1400, 1430, 1500, 1530, 1600, 1630, 1700, 1730, 1800], // 用来比较后台传来的时间值，9:00这里设为900，下面会把后台值进行转换，也是转换成这些格式进行对比
      listQuery: {
        page: 1,
        rows: 10,
        currentDay: ''
      },
      // staticData: {
      //   'result': 'OK',
      //   'code': '0000',
      //   'data': {
      //     'rows': [
      //       {
      //         'id': '86580b0b-b1a2-4803-974a-877f0f41e6b1',
      //         'name': '测试会议室名称',
      //         'building': '102栋',
      //         'floor': '2层',
      //         'roomNumber': '1012',
      //         'position': null,
      //         'explains': '测试数据',
      //         'recordStatus': 1,
      //         'capacity': '10',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-19 17:55',
      //         'modifierAccount': 'wangsong',
      //         'modifiedTime': '2019-02-26 19:37',
      //         'meetingList': [
      //           {
      //             'id': '028491dd-fb28-4672-baca-b7f5c276bd54',
      //             'workOrderNum': null,
      //             'startTime': '2019-02-26T07:00:00.000+0000',
      //             'endTime': '2019-02-26T09:13:43.000+0000',
      //             'meetingRoomId': null,
      //             'approvalStatus': null,
      //             'recordStatus': null,
      //             'creatorAccount': null,
      //             'createdTime': null,
      //             'modifierAccount': null,
      //             'modifiedTime': null,
      //             'userIdStr': null,
      //             'applicant': null,
      //             'applicationTime': null,
      //             'signInQr': null,
      //             'wechatRemind': null,
      //             'messageRemind': null,
      //             'pcRemind': null,
      //             'appRemind': null,
      //             'isRemind': null,
      //             'title': '测试会议标题',
      //             'approvalRole': null,
      //             'approvalUser': null,
      //             'approvalOpinion': null,
      //             'meetingStatus': null
      //           },
      //           {
      //             'id': '028491dd-fb28-4672-baca-b7f5c276bd54',
      //             'workOrderNum': null,
      //             'startTime': '2019-02-26T09:00:00.000+0000',
      //             'endTime': '2019-02-26T09:13:43.000+0000',
      //             'meetingRoomId': null,
      //             'approvalStatus': null,
      //             'recordStatus': null,
      //             'creatorAccount': null,
      //             'createdTime': null,
      //             'modifierAccount': null,
      //             'modifiedTime': null,
      //             'userIdStr': null,
      //             'applicant': null,
      //             'applicationTime': null,
      //             'signInQr': null,
      //             'wechatRemind': null,
      //             'messageRemind': null,
      //             'pcRemind': null,
      //             'appRemind': null,
      //             'isRemind': null,
      //             'title': '王磊非我房价哦i额外附加哦问佛吉',
      //             'approvalRole': null,
      //             'approvalUser': null,
      //             'approvalOpinion': null,
      //             'meetingStatus': null
      //           }
      //         ]
      //       },
      //       {
      //         'id': '15c6af99-3bd5-46d1-b44b-467d8e753537',
      //         'name': '测试会议室',
      //         'building': '1',
      //         'floor': '2',
      //         'roomNumber': '22',
      //         'position': '1222',
      //         'explains': '测试专用',
      //         'recordStatus': 1,
      //         'capacity': '30',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-27 13:10',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '26797a07-acfb-4c1e-87aa-fb9bd9e353cb',
      //         'name': 'sss',
      //         'building': 'sss',
      //         'floor': 'ss',
      //         'roomNumber': 'ss',
      //         'position': 'sssssss',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '33',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-26 14:23',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '28501e4f-04f9-474f-95db-e890584474ab',
      //         'name': '测试',
      //         'building': '110',
      //         'floor': '2',
      //         'roomNumber': '208',
      //         'position': '1102208',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '50',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-22 15:47',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '3f3eff4b-eae6-417d-8123-1706cd09e8c0',
      //         'name': 'sss',
      //         'building': 'sss',
      //         'floor': 'ss',
      //         'roomNumber': 'ss',
      //         'position': 'sssssss',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '33',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-26 12:01',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '4990b82e-06c8-4fff-b90c-58a485536f83',
      //         'name': 'sssssssssss',
      //         'building': 'sss',
      //         'floor': 'ss',
      //         'roomNumber': 'ss',
      //         'position': 'sssssss',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '22',
      //         'remark': null,
      //         'creatorAccount': 'wangsong',
      //         'createdTime': '2019-02-26 19:26',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '51702fed-c8cc-40a1-b0c2-753ef42d297e',
      //         'name': 'ss',
      //         'building': 'ss',
      //         'floor': 'ss',
      //         'roomNumber': 'ss',
      //         'position': 'ssssss',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '23',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-26 14:42',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '51756571-b6ba-46ec-b540-6bdad727bb11',
      //         'name': '122',
      //         'building': '22',
      //         'floor': '22',
      //         'roomNumber': '22',
      //         'position': '222222',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '222',
      //         'remark': null,
      //         'creatorAccount': 'wangsong',
      //         'createdTime': '2019-02-26 19:20',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '64e62a82-6e9e-4982-8e20-be59eb37f65b',
      //         'name': '12331e2',
      //         'building': '222222',
      //         'floor': '222',
      //         'roomNumber': '22222222222',
      //         'position': '22222222222222222222',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '222',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-26 17:37',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [

      //         ]
      //       },
      //       {
      //         'id': '91e8ddbf-621f-49bd-ac8e-650b727ffd73',
      //         'name': 'sss',
      //         'building': 'sss',
      //         'floor': 'ss',
      //         'roomNumber': 'ss',
      //         'position': 'sssssss',
      //         'explains': '',
      //         'recordStatus': 1,
      //         'capacity': '33',
      //         'remark': null,
      //         'creatorAccount': '10000',
      //         'createdTime': '2019-02-26 11:50',
      //         'modifierAccount': null,
      //         'modifiedTime': null,
      //         'meetingList': [
      //           {
      //             'id': '028491dd-fb28-4672-baca-b7f5c276bd54',
      //             'workOrderNum': null,
      //             'startTime': '2019-02-26T07:00:00.000+0000',
      //             'endTime': '2019-02-26T07:13:43.000+0000',
      //             'meetingRoomId': null,
      //             'approvalStatus': null,
      //             'recordStatus': null,
      //             'creatorAccount': null,
      //             'createdTime': null,
      //             'modifierAccount': null,
      //             'modifiedTime': null,
      //             'userIdStr': null,
      //             'applicant': null,
      //             'applicationTime': null,
      //             'signInQr': null,
      //             'wechatRemind': null,
      //             'messageRemind': null,
      //             'pcRemind': null,
      //             'appRemind': null,
      //             'isRemind': null,
      //             'title': '测试会议标题',
      //             'approvalRole': null,
      //             'approvalUser': null,
      //             'approvalOpinion': null,
      //             'meetingStatus': null
      //           },
      //           {
      //             'id': '028491dd-fb28-4672-baca-b7f5c276bd54',
      //             'workOrderNum': null,
      //             'startTime': '2019-02-26T09:00:00.000+0000',
      //             'endTime': '2019-02-26T10:30:43.000+0000',
      //             'meetingRoomId': null,
      //             'approvalStatus': null,
      //             'recordStatus': null,
      //             'creatorAccount': null,
      //             'createdTime': null,
      //             'modifierAccount': null,
      //             'modifiedTime': null,
      //             'userIdStr': null,
      //             'applicant': null,
      //             'applicationTime': null,
      //             'signInQr': null,
      //             'wechatRemind': null,
      //             'messageRemind': null,
      //             'pcRemind': null,
      //             'appRemind': null,
      //             'isRemind': null,
      //             'title': '王磊非我房价哦i额外附加哦问佛吉',
      //             'approvalRole': null,
      //             'approvalUser': null,
      //             'approvalOpinion': null,
      //             'meetingStatus': null
      //           }
      //         ]
      //       }
      //     ],
      //     'total': 18
      //   }
      // },
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
      selectIndex: ''
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
      // this.tableData3 = this.staticData.data.rows
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
      console.log(this.params.selectDay)
      for (let i = 0; i < 42; i++) {
        if (index === i) {
          this.isSelected.push(true)
          continue
        }
        this.isSelected.push(false)
      }
      this.listQuery.currentDay = this.params.selectDay
      this.initList()
    },
    handle(row) {
      console.log(row)
      this.$router.push({ name: 'meetingApplication', query: { workOrder: 'HYGL', title: '会议申请', meetId: row.id, name: row.name }})
    },
    // 页面初始化
    initList() {
      const self = this
      api('oa/oaMeetingRoom/orderList', this.listQuery).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          self.tableData3 = res.data.data.rows
          // this.tableData3 = this.staticData.data.rows
          // console.log(this.tableData3)
          self.total = res.data.data.total
          self.calcData()
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    calcData() { // 抽开始时间和结束时间出来进行对比
      this.tableData3.forEach((item) => {
        const vals = []
        for (let i = 0; i < this.compareData.length; i++) { // 先设定初始值为“可预约”，如果有会议且在某个时间范围才填充进去
          vals.push('可预约')
        }
        if (item.meetingList.length > 1) {
          item.meetingList.forEach((timeItem) => {
            for (let i = 0; i < this.compareData.length; i++) { // 时间转换和对比
              let m = new Date(timeItem.startTime).getMinutes() < 10 ? ('0' + new Date(timeItem.startTime).getMinutes()) : new Date(timeItem.startTime).getMinutes()
              const sd = Number(new Date(timeItem.startTime).getHours() + '' + m)
              m = new Date(timeItem.endTime).getMinutes() < 10 ? ('0' + new Date(timeItem.endTime).getMinutes()) : new Date(timeItem.endTime).getMinutes()
              const ed = Number(new Date(timeItem.endTime).getHours() + '' + m)
              if (sd <= this.compareData[i] && ed >= this.compareData[i]) {
                vals[i] = timeItem.title
              }
            }
          })
        }
        for (let i = 0; i < vals.length; i++) { // 动态设置参数用来填充
          item['time' + i] = vals[i]
        }
      })
      // console.log(JSON.stringify(this.tableData3))
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

.conferenceReservation{
    display: flex;
    .el-table .cell, .el-table th div, .el-table--border td:first-child .cell, .el-table--border th:first-child .cell {
  padding: 0px ;
}

.table{
    margin-left: 15px;
    flex:8;
    .el-pagination{
      margin-top:15px;
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

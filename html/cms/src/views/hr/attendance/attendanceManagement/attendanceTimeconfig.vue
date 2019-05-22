<template>

  <div class="attend">
    <div class="hd">
      <h3>设置班次</h3>
    </div>
    <div class="bd">
      <el-table ref="multipleTable" :data="timeSetList" border fit highlight-current-row
                style="width: 100%;height:100%;" >
        <el-table-column label="班次"  align="center" prop="shift">
          <template slot-scope="scope">
            <el-select v-if="!scope.row.disabled" v-model="scope.row.shift" placeholder="请选择班次"  style="width: 100px"
                       class="filter-item" @change="setAttendanceType(scope.row,scope.row.shift)"
                       :disabled="scope.row.disabled">
              <el-option label="请选择" value="" />
              <el-option v-for="(item,index) in shiftList" :label="item.optionName" :value="item.optionId" :key="index"/>
            </el-select>
            <span v-else>{{scope.row.shift}}</span>
          </template>
        </el-table-column>
        <el-table-column label="考勤类型" align="center" prop="attendanceType" style="width: 120px">
          <template slot-scope="scope">
            <el-input v-if="!scope.row.disabled" v-model="scope.row.attendanceType"   :disabled="scope.row.disabled" placeholder="" clearable></el-input>
            <span v-else>{{scope.row.attendanceType}}</span>
          </template>
        </el-table-column>
        <el-table-column label="上班考勤时间设置" align="center" prop="workAttendanceTime">
          <template slot-scope="scope">

            <el-time-select v-if="!scope.row.disabled"
              v-model="scope.row.workAttendanceTime"
              :picker-options="{
                start: '00:00',
                step: '00:15',
                end: '24:00'
              }"
              placeholder="选择时间" :disabled="scope.row.disabled">
            </el-time-select>
            <span v-else>{{scope.row.workAttendanceTime}}</span>
          </template>
        </el-table-column>

        <el-table-column label="下班考勤时间设置" align="center" prop="dutyAttendanceTime">
          <template slot-scope="scope">
            <el-time-select v-if="!scope.row.disabled"
              v-model="scope.row.dutyAttendanceTime"
              :picker-options="{
                start: '00:00',
                step: '00:15',
                end: '24:00'
              }"
              placeholder="选择时间" :disabled="scope.row.disabled">
            </el-time-select>
            <span v-else>{{scope.row.dutyAttendanceTime}}</span>
          </template>
        </el-table-column>

        <el-table-column label="备注" align="center" prop="remark">
          <template slot-scope="scope">
            <el-input v-if="!scope.row.disabled" v-model="scope.row.remark" style="width: 200px"  :disabled="scope.row.disabled" placeholder="" clearable></el-input>
            <span v-else>{{scope.row.remark}}</span>
          </template>
        </el-table-column>

        <el-table-column label="操作" align="center" min-width="100" width="200" class-name="small-padding fixed-width">
          <template slot-scope="scope">
            <el-button type="text" v-if="!scope.row.disabled" @click="submitForm(scope.row)">保存</el-button>
            <el-button type="text" v-if="scope.row.disabled" @click="update(scope.row,scope.$index)">修改</el-button>
            <el-button type="text" @click="deleteRow(scope.row)">删除</el-button>
          </template>
        </el-table-column>

      </el-table>
      <div style="margin-top: 20px">
        <el-button @click="add">添加班次</el-button>
      </div>
    </div>
  </div>


</template>

<script>
  import {
    attendanceTimeSetList,addAttendanceTimeSet,updateAttendanceTimeSet,deleteAttendanceTimeSet
  } from '@/api/hr/attendance'

  export default {
    data() {
      return {
        shiftList: [{
          optionId:1,optionName:1,attendanceType:'日常考勤'
        },{
          optionId:2,optionName:2,attendanceType:'值班考勤'
        },{
          optionId:3,optionName:3,attendanceType:'会议考勤'
        }],
        timeSetList: [

        ]
      }
    },
    methods: {
      setAttendanceType(row,shift){
        const selectShift=this.shiftList.find(item=>{
          return item.optionId==shift
        })
        if(selectShift){
          row.attendanceType=selectShift.attendanceType
        }
      },
      add() {
        if(this.timeSetList.length==this.shiftList.length){
          this.shiftList.push({
            optionId:this.shiftList.length+1,optionName:this.shiftList.length+1,attendanceType:''
          })
        }
        this.timeSetList.push({
          id:'',
          shift:'',
          attendanceType:'',
          workAttendanceTime:'',
          dutyAttendanceTime:'',
          remark:'',
          disabled: false
        })
      },
      update(row,index) {
        row.disabled=false
        this.timeSetList.splice(index,1,row)
      },
      deleteRow(row) {
        console.log('删除',row)
        if(row.id==''){
          this.timeSetList.splice(this.timeSetList.indexOf(row),1)
          return
        }
        this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          deleteAttendanceTimeSet(row).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
      },
      submitForm(row){
        console.log('保存班次')
        if(!row.shift || row.shift==''){
          this.$message.error("请选择班次")
          return
        }
        if(!row.attendanceType || row.attendanceType==''){
          this.$message.error("请输入考勤类型")
          return
        }
        if(!row.workAttendanceTime || row.workAttendanceTime==''){
          this.$message.error("请输入上班考勤时间")
          return
        }
        if(!row.dutyAttendanceTime || row.dutyAttendanceTime==''){
          this.$message.error("请输入下班考勤时间")
          return
        }
        //判断班次是否重复
        let hash = {};
        const newArr = this.timeSetList.reduceRight((item, next) => {
          hash[next.shift] ? '' : hash[next.shift] = true && item.push(next);
          return item
        }, []);
        if(newArr.length!=this.timeSetList.length){
          this.$message.error("班次重复")
          return
        }
        if(row.id!=''){
          updateAttendanceTimeSet(row).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '修改成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        }else{
          addAttendanceTimeSet(row).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        }


      },
      initList(){
        console.log('查询班次')
        attendanceTimeSetList().then(res => {
          if (res.data.code === '0000') {
            this.timeSetList = res.data.data
            this.timeSetList.forEach(item => {
              debugger
              Object.assign(item, {disabled: true})
              const hasVal=this.shiftList.find(itemShift=>{
                return itemShift.optionId==item.shift
              })
              if(!hasVal){
                this.shiftList.push({
                  optionId:item.shift,optionName:item.shift,attendanceType:item.attendanceType
                })
              }
            })
            this.timeSetList.sort((a,b)=>{
              return a.shift-b.shift
            })
            this.shiftList.sort((a,b)=>{
              return a.optionId-b.optionId
            })
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    mounted() {
      this.initList()
    }
  }
</script>

<style scoped type="less">

  .attend {
    margin: 10px 20px;

  }

  .attend .hd h3 {
    line-height: 30px;
    font-size: 16px;
    color: #66B1FF;
    font-weight: bold;
    border-bottom: 1px solid #66B1FF;
  }


</style>

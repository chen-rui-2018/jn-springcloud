<template>
  <div class="meetingApplication">
    <div class="meetingApplication-top">
      <el-form ref="meetingForm" :model="meetingForm" :show-message="false" hide-required-asterisk class="demo-meetingForm">
        <div style="display:flex">
          <el-form-item label="工单编号" prop="name" class="inline">
            <span> sss </span>
          </el-form-item>
          <el-form-item label="工单名称" prop="region" class="inline">
            <span> sss</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="申请人" prop="name" class="inline" >
            <span> 张三 </span>
          </el-form-item>
          <el-form-item label="部门" prop="region" class="inline" >
            <span> 招商部</span>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="会议室" prop="name" class="inline">
            <el-input v-model="meetingForm.name" clearable placeholder="请选择" @click.native="abc()"/>
          </el-form-item>
          <el-form-item label="会议主题" prop="region" class="inline">
            <el-input v-model="meetingForm.name" maxlength="16" placeholder="请输入内容" clearable />
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="参与人员" prop="name" class="inline">
            <el-input v-model="meetingForm.name" clearable placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="会议日期" prop="region" class="inline">
            <el-date-picker type="date" placeholder="选择日期"/>
          </el-form-item>
        </div>
        <div style="display:flex">
          <el-form-item label="起始时间" prop="name" lass="inline">
            <el-time-select v-model="meetingForm.startTime" :picker-options="{ start: '09:00', step: '00:30', end: '18:00'}" placeholder="起始时间"/>
          </el-form-item>
          <el-form-item label="结束时间" prop="region" class="inline">
            <el-time-select v-model="meetingForm.endTime" :picker-options="{ start: '09:00', step: '00:30', end: '18:00', minTime: meetingForm.startTime }" placeholder="结束时间"/>
          </el-form-item>
        </div>
        <el-form-item label="审批进度" prop="name" class="inline">
          <el-steps :space="300" :active="0" finish-status="success">
            <el-step title="发起审批" />
            <el-step title="领导审批" />
            <el-step title="审批完成" />
          </el-steps>
        </el-form-item>
        <el-form-item label="审批状态">
          <el-radio-group v-model="meetingForm.resource">
            <el-radio label="通过"/>
            <el-radio label="不通过"/>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="审批意见">
          <el-input v-model="meetingForm.desc" type="textarea" placeholder="请输入内容"/>
        </el-form-item>
        <div class="primaryList">
          <el-button type="primary" @click="submitForm('meetingForm')">提交</el-button>
          <el-button @click="resetForm('meetingForm')">取消</el-button>
        </div>
      </el-form>
    </div>
    <!-- <div class="meetingApplication-bottom">
      <el-form :inline="true" :model="listQuery" class="filter-bar">
        <el-form-item label="位置">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-form-item label="会议时间:">
          <el-date-picker v-model="listQuery.actiStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" @change="getStarttime" />
          至
          <el-date-picker v-model="listQuery.actiEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" @change="getEndtime" />
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
      </el-form>
    </div> -->
    <template v-if="dialogFormVisible">
      <el-dialog :visible.sync="dialogFormVisible" :title="addDialogTitle" class="lookMeetingroom">
        <el-form :inline="true" :model="listQuery" class="filter-bar">
          <el-form-item label="位置">
            <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 150px" class="filter-item" @change="selecteUserStatus">
              <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
            </el-select>
          </el-form-item>
          <el-form-item label="会议时间:">
            <el-date-picker v-model="listQuery.actiStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始时间" @change="getStarttime" />
            至
            <el-date-picker v-model="listQuery.actiEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" @change="getEndtime" />
          </el-form-item>
          <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        </el-form>
        <div class="usableMeetingroom">可预约的会议室</div>
        <div class="meetingroomList">
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
          <div>
            <img src="" alt="">
            <h3>会议室名字</h3>
            <div>会议室说明<span>小会议室</span>,可参与人数<span>10</span>,{{ describe }} </div>
          </div>
        </div>
        <div slot="footer" class="dialog-footer">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='create'?createUserData():updateData()">确认</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>

<script>
export default {
  data() {
    return {
      describe: '有投影仪',
      dialogFormVisible: false,
      listQuery: {
        recordStatus: ''
      },
      meetingForm: {
        recordStatus: '',
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      },
      userStatusOptions: ['会议室1', '会议室2']
    }
  },
  methods: {
    abc() {
      this.dialogFormVisible = true
      console.log(123)
    },
    handleFilter() {},
    getStarttime() {},
    getEndtime() {},
    selecteUserStatus() {},
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>
<style lang="scss">
.meetingApplication-top {
  .inline {
    display: inline-block;
  }
  .el-form-item__label {
    width: 120px;
    padding: 15px 0;
    display: inline-block;
    background-color: #f0f0f0;
    border: 1px solid #ccc;
    display: flex;
    align-items: center;
    justify-content: center;
  }
  .el-form-item {
    margin-bottom: 0px;
    flex: 1;
    display: flex;
  }
  .el-form-item__content {
    flex: 1;
    display: inline-block;
    padding: 15px;
    border: 1px solid #ccc;
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-steps{
    margin-left: 100px;
  }
  .el-radio+.el-radio {
    margin-left: 280px;
}
.el-radio-group{
  margin-left: 100px;
}
.el-textarea__inner{
  min-height: 120px !important;
}

}
.lookMeetingroom{
  .el-form--inline .el-form-item{
    margin-right: 70px;
  }

  .el-dialog{
 width: 70vw;
  height: 82vh;
  margin-top:6vh !important;
  overflow: auto;
  }
  .usableMeetingroom{
    background-color: #ccc;
    padding: 15px;
    border:1px solid #666;
  }
  .meetingroomList{
   >div{
     width: 31.7%;
     display: inline-block;
     margin-right: 21px;
     margin-top: 20px;
   }
  }
  .meetingroomList div:nth-child(3n){
     margin-right: 0px;
   }
}
</style>

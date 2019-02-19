<template>
  <div class="addMeetingroom">
    <div class="header">新增会议室</div>
    <el-form ref="meetingForm" :model="meetingForm" :show-message="false" class="demo-meetingForm">
      <div style="display:flex">
        <el-form-item label="会议室名称" prop="name" class="inline">
          <el-input v-model="meetingForm.name" clearable placeholder="请输入" />
        </el-form-item>
        <el-form-item label="楼宇" prop="region" class="inline">
          <el-input v-model="meetingForm.name" clearable placeholder="请输入" />
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="楼层" prop="name" class="inline" >
          <el-input v-model="meetingForm.name" clearable placeholder="请输入" />
        </el-form-item>
        <el-form-item label="房间号" prop="region" class="inline" >
          <el-input v-model="meetingForm.name" clearable placeholder="请输入" />
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室容量" prop="name" class="inline">
          <el-input v-model="meetingForm.name" clearable placeholder="请输入" type="number" min="1" @keyup.native="proving($event)"/>
        </el-form-item>
        <el-form-item label="会议室状态" prop="region" class="inline">
          <el-select v-model="listQuery.recordStatus" placeholder="请选择" clearable style="width: 100%" class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in userStatusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室说明" prop="name" lass="inline">
          <el-input v-model="meetingForm.desc" placeholder="请输入内容"/>
        </el-form-item>
      </div>
      <div style="display:flex">
        <el-form-item label="会议室图片" prop="name" lass="inline">
          图片
        </el-form-item>
      </div>
      <div class="primaryList">
        <el-button type="primary" @click="submitForm('meetingForm')">提交</el-button>
        <el-button @click="resetForm('meetingForm')">取消</el-button>
      </div>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      meetingForm: {

      },
      listQuery: {

      }
    }
  },
  methods: {
    selecteUserStatus() {},
    proving(e) {
      var keynum = window.event ? e.keyCode : e.which // 获取键盘码
      if (keynum === 189 || keynum === 190 || keynum === 110 || keynum === 109) {
        alert('禁止输入小数以及负数')
        e.target.value = ''
      }
    }
  }
}
</script>

<style lang="scss">
.addMeetingroom {
  .header {
    color: cadetblue;
    background: #f0f0f0;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
    padding: 20px 0px;
    border:1px solid #ccc;
  }
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
}
</style>

<template>
  <div>
    <el-form ref="activityForm" :model="activityForm" :rules="rules" label-width="150px">
      <el-form-item label="排序" prop="actiOrder">
        <el-input v-model="activityForm.actiOrder"/>
      </el-form-item>
      <el-form-item label="首页展示" prop="isIndex">
        <el-radio-group v-model="activityForm.isIndex">
          <el-radio label="0">不展示</el-radio>
          <el-radio label="1">展示</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="活动类型" prop="actiType">
        <el-select v-model="activityForm.actiType" placeholder="请选择活动类型" @change="selecteType">
          <el-option v-for="item in typeOptions" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="活动名称" prop="actiName">
        <el-input v-model="activityForm.actiName"/>
      </el-form-item>
      <el-form-item label="活动时间" required>
        <el-col :span="11">
          <el-date-picker v-model="activityForm.actiStartTime" type="datetime" placeholder="选择开始日期" style="width: 100%;" @change="getStarttime"/>
        </el-col>
        <el-col :span="2" class="line" align="center">至</el-col>
        <el-col :span="11">
          <el-date-picker v-model="activityForm.actiEndTime" type="datetime" placeholder="选择结束时间" style="width: 100%;" @change="getEndtime"/>
        </el-col>
      </el-form-item>
      <el-form-item label="报名截止时间">
        <el-date-picker
          v-model="activityForm.applyEndTime"
          type="datetime"
          placeholder="选择日期时间"/>
      </el-form-item>
      <el-form-item label="通知推送时间">
        <el-date-picker
          v-model="activityForm.mesSendTime"
          type="datetime"
          placeholder="选择日期时间"/>
      </el-form-item>
      <el-form-item label="活动园区" prop="parkId">
        <el-select v-model="activityForm.parkId" placeholder="请选择活动类型" @change="selecteType">
          <el-option v-for="item in parkIdOptions" :key="item.value" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item label="活动地址" prop="actiAddress">
        <el-input v-model="activityForm.actiAddress"/>
      </el-form-item>
      <el-form-item label="活动费用" prop="actiCost">
        <el-input v-model="activityForm.actiCost"/>
      </el-form-item>
      <el-form-item label="主办方" prop="actiOrganizer">
        <el-input v-model="activityForm.actiOrganizer"/>
      </el-form-item>
      <el-form-item label="是否展示报名人数" prop="showApplyNum">
        <el-radio-group v-model="activityForm.showApplyNum">
          <el-radio label="0">不展示</el-radio>
          <el-radio label="1">展示</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="活动人数" prop="actiNumber">
        <el-input v-model="activityForm.actiNumber"/>
      </el-form-item>
      <el-form-item label="活动海报" prop="actiPosterUrl">
        <el-upload
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          action="https://jsonplaceholder.typicode.com/posts/"
          list-type="picture-card">
          <i class="el-icon-plus"/>
        </el-upload>
        <el-dialog :visible.sync="dialogVisible">
          <img :src="dialogImageUrl" width="100%" alt="">
        </el-dialog>
      </el-form-item>
      <el-form-item label="活动详情" prop="actiDetail">
        <el-input v-model="activityForm.actiDetail"/>
      </el-form-item>
      <el-form-item label="活动状态" prop="state">
        <el-steps :space="200" :active="1" finish-status="success">
          <el-step title="待发布"/>
          <el-step title="报名中"/>
          <el-step title="已结束"/>
        </el-steps>
      </el-form-item>
      <el-form-item>
        <el-button type="primary">保存草稿</el-button>
        <el-button type="primary">发布</el-button>
        <el-button type="primary">返回</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      typeOptions: [],
      parkIdOptions: [],
      activityForm: {
        actiOrder: undefined,
        isIndex: undefined,
        actiType: undefined,
        actiName: undefined,
        actiStartTime: undefined,
        actiEndTime: undefined,
        applyEndTime: undefined,
        mesSendTime: undefined,
        parkId: undefined,
        actiAddress: undefined,
        actiCost: undefined,
        actiOrganizer: undefined,
        showApplyNum: undefined,
        actiNumber: undefined,
        actiPosterUrl: undefined,
        actiDetail: undefined,
        state: undefined
      }
    }
  }

}
</script>

<style scoped>
  .el-input--medium{
      width: 200px;
  }
</style>

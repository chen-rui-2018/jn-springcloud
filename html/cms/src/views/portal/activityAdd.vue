<template>
  <div>
    <el-form ref="activityForm" :model="activityForm" label-width="200px">
      <el-form-item label="排序" prop="actiOrder">
        <el-input v-model="activityForm.actiOrder" style="width: 205px;"/>
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
        <el-input v-model="activityForm.actiName" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="activityForm.actiStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始日期" style="width: 100%;" @change="getStarttime" />
        </el-col>
        <el-col :span="2" class="line" align="center">至</el-col>
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="activityForm.actiEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" style="width: 100%;" @change="getEndtime" />
        </el-col>
      </el-form-item>
      <el-form-item label="报名截止时间">
        <el-date-picker v-model="activityForm.applyEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间" />
      </el-form-item>
      <el-form-item label="通知推送时间">
        <el-date-picker v-model="activityForm.mesSendTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间" />
      </el-form-item>
      <el-form-item label="活动园区" prop="parkId">
        <el-select v-model="activityForm.parkId" placeholder="请选择活动园区" @change="selecteParkId">
          <!-- <el-option v-for="item in parkIdOptions" :key="item.value" :label="item.label" :value="item.value" /> -->
          <el-option value="一号园区" />
          <el-option value="二号园区" />
          <el-option value="三号园区" />
        </el-select>
      </el-form-item>
      <el-form-item label="活动地址" prop="actiAddress">
        <el-input v-model="activityForm.actiAddress" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="活动费用" prop="actiCost">
        <el-input v-model="activityForm.actiCost" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="主办方" prop="actiOrganizer">
        <el-input v-model="activityForm.actiOrganizer" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="是否展示报名人数" prop="showApplyNum">
        <el-radio-group v-model="activityForm.showApplyNum">
          <el-radio label="0">不展示</el-radio>
          <el-radio label="1">展示</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="报名是否需要审批" prop="applyCheck">
        <el-radio-group v-model="activityForm.applyCheck">
          <el-radio label="0">否</el-radio>
          <el-radio label="1">是</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="活动人数" prop="actiNumber">
        <el-input v-model="activityForm.actiNumber" placeholder="活动限制人数" style="width: 205px;" />
        <span class="acPeople">人</span>
      </el-form-item>
      <el-form-item v-model="activityForm.actiPosterUrl" label="活动海报" prop="actiPosterUrl">
        <div class="poster" @click="handleClick">
          <i class="el-icon-plus" />
          <!-- <span>+</span> -->
          <img :src="activityForm.actiPosterUrl" alt="">
        </div>
      </el-form-item>
      <el-form-item label="活动详情" prop="actiDetail">
        <template>
          <el-row>
            <div class="editor-container">
              <UE ref="ue" :default-msg="defaultMsg" :config="config" />
            </div>
          </el-row>
        </template>
      </el-form-item>
      <el-form-item label="活动状态" prop="actiStatus">
        <el-steps :space="200" :active="activityForm.actiStatus*1" finish-status="success">
          <el-step title="待发布" />
          <el-step title="报名中" />
          <el-step title="已结束" />
        </el-steps>
      </el-form-item>
      <el-form-item>
        <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="saveDrafts">保存草稿</el-button>
        <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="release">发布</el-button>
        <el-button type="primary" @click="goBack">返回</el-button>
      </el-form-item>
    </el-form>
    <!-- 新增海报弹出框 -->
    <el-dialog :visible.sync="dialogPosterVisible">
      <!-- <el-upload :auto-upload="false" :limit="1" :on-preview="handlePictureCardPreview" :on-remove="handleRemove" action="https://jsonplaceholder.typicode.com/posts/" list-type="picture-card">
        <i class="el-icon-plus" />
      </el-upload> -->
      <!-- <p>已选择的图片</p> -->
      <el-upload :headers="headers" :show-file-list="false" :auto-upload="false" :multiple="false" :on-change="changeImg" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" class="avatar-uploader" action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload">
        <img v-if="imageUrl" :src="imageUrl" class="avatar">
        <i v-else class="el-icon-plus avatar-uploader-icon" />
      </el-upload>
      <!-- <div v-if="templateImgList!==null&&templateImgList.length>0"> -->
      <div v-if="templateImgList.length>0" style="color:#495461">从海报模板库选择</div>
      <div class="localImg">
        <div class="actype">{{ typeName }}</div>
        <div class="acimg">
          <ul class="acUl">
            <li v-if="templateImgList!==null&&templateImgList.length>0"><img alt="活动海报" @click="selectImg()"></li>
            <li v-for="item in templateImgList" :key="item"><img :src="item" alt="活动海报" @click="selectImg(item)"></li>
          </ul>
        </div>
      </div>
      <!-- </div> -->
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="confirm">确 定</el-button>
        <el-button @click="dialogPosterVisible = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import UE from '../../components/UE/ue.vue'
import { getToken } from '@/utils/auth'
import {
  getActivityType,
  getEventPoster,
  saveActivityDraft,
  publishActivity,
  getActivityDetailsForManage
} from '@/api/portalManagement/activity'
export default {
  components: { UE },
  data() {
    return {
      headers: {
        token: getToken()
      },
      content: '',
      editorOption: {},
      typeOptions: [],
      parkIdOptions: [],
      activityForm: {
        actiOrder: 0,
        isIndex: '',
        actiType: '',
        actiName: '',
        actiStartTime: '',
        actiEndTime: '',
        applyEndTime: '',
        mesSendTime: '',
        parkId: '',
        actiAddress: '',
        actiCost: 0,
        actiOrganizer: '',
        showApplyNum: '',
        actiNumber: 0,
        actiPosterUrl: '',
        actiDetail: '',
        actiStatus: 1,
        id: '',
        applyCheck: '0',
        page: 1,
        rows: 10
      },
      defaultMsg: '',
      config: {
        initialFrameWidth: 800,
        initialFrameHeight: 300
      },
      dialogPosterVisible: false,
      imageUrl: '',
      // posterUrl: '',
      typeName: '',
      templateImgList: [],
      row: {
        actiStatus: '1'
      }
    }
  },
  mounted() {
    console.log(this.$route.query.activityId)
    if (this.$route.query.activityId) {
      // this.row = JSON.parse(this.$route.query.row)
      this.init()
      // this.getEditContent()
    } else {
      this.getActivityType()
    }
  },
  methods: {
    init() {
      // const data = {
      //   activityId: this.$route.query.activityId
      // }
      getActivityDetailsForManage(this.$route.query.activityId).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.activityForm = res.data.data
          this.defaultMsg = this.activityForm.actiDetail
        } else {
          this.$message(res.data.result)
        }
      })
    },
    handleRemove() {},
    handlePictureCardPreview() {},
    getEndtime() {},
    getStarttime() {},
    selecteType(value) {
      console.log(value)
      this.activityForm.actiType = value
      // this.activityForm.typeId = value
    },
    selecteParkId(value) {
      this.activityForm.parkId = value
    },
    onEditorBlur(editor) {
      // 失去焦点事件
    },
    onEditorFocus(editor) {
      // 获得焦点事件
    },
    onEditorChange({ editor, html, text }) {
      // 编辑器文本发生变化
      // this.content可以实时获取到当前编辑器内的文本内容
      console.log(this.content)
    },
    handleClick() {
      if (!this.activityForm.actiType) {
        this.$message({
          message: '没有选择活动类型',
          type: 'error'
        })
        return
      }
      this.dialogPosterVisible = true
      getEventPoster(this.activityForm.actiType).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          if (res.data.data.templateImgList.length > 0) {
            this.templateImgList = res.data.data.templateImgList
          } else {
            this.$message('选择的活动类型没有模板图片')
          }
          this.typeName = res.data.data.typeName
          // this.dialogPosterVisible = true
        } else {
          this.$message(res.data.result)
        }
      })
    },
    selectImg(item) {
      this.imageUrl = item
    },
    changeImg(res, file) {
      // this.imageUrl = file[0].url
      if (file.length > 1) {
        file.shift()
      }
      // 赋值下这个imageUrl就能看到图片了
      this.imageUrl = URL.createObjectURL(file[0].raw)
    },
    confirm() {
      this.dialogPosterVisible = false
      this.activityForm.actiPosterUrl = this.imageUrl
    },
    handleAvatarSuccess(res, file) {
      // this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload(file) {
      // const isJPG = file.type === 'image/jpeg'
      // const isLt2M = file.size / 1024 / 1024 < 2
      // if (!isJPG) {
      //   this.$message.error('上传头像图片只能是 JPG 格式!')
      // }
      // if (!isLt2M) {
      //   this.$message.error('上传头像图片大小不能超过 2MB!')
      // }
      // return isJPG && isLt2M
      if (file.size > 4 * 1024 * 1024) {
        this.$message({
          type: 'warning',
          message: '文件大小必须小于4M'
        })
        return false
      }
    },
    getActivityType() {
      getActivityType().then(res => {
        if (res.data.code === '0000') {
          res.data.data.rows.forEach(val => {
            this.typeOptions.push({
              value: val.typeId,
              label: val.typeName
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    // 获取编辑行的内容
    getEditContent() {
      const row = this.row
      this.activityForm.actiName = row.actiName
      this.activityForm.actiType = row.actiType
      this.activityForm.actiStatus = row.actiStatus
      this.activityForm.isIndex = row.isIndex
      this.activityForm.actiAddress = row.actiAddress
      this.activityForm.actiCost = row.actiCost
      this.activityForm.actiDetail = row.actiDetail
      this.activityForm.actiEndTime = row.actiEndTime
      this.activityForm.actiNumber = row.actiNumber
      this.activityForm.actiOrder = row.actiOrder
      this.activityForm.actiOrganizer = row.actiOrganizer
      this.activityForm.actiPosterUrl = row.actiPosterUrl
      this.activityForm.actiStartTime = row.actiStartTime
      this.activityForm.applyCheck = row.applyCheck
      this.activityForm.applyEndTime = row.applyEndTime
      this.activityForm.id = row.id
      this.activityForm.mesSendTime = row.mesSendTime
      this.activityForm.parkId = row.parkId
      this.activityForm.showApplyNum = row.showApplyNum
    },
    saveDrafts() { // 保存草稿
      if (!this.activityForm.actiName) {
        this.$message({
          message: '活动名称不能为空',
          type: 'error'
        })
        return
      }
      const data = this.activityForm
      saveActivityDraft(data).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.$message({
            message: '保存草稿成功',
            type: 'success'
          })
          this.goBack()
        } else {
          this.$message(res.data.result)
        }
      })
    },
    release() { // 发布活动
      if (this.activityForm.actiOrder === 'undefined') {
        this.$message({
          message: '排序不能为空',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.isIndex) {
        this.$message({
          message: '首页展示没有选择',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiType) {
        this.$message({
          message: '请选择活动类型',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiName) {
        this.$message({
          message: '请选择活动名称',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiStartTime) {
        this.$message({
          message: '请选择活动开始时间',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiEndTime) {
        this.$message({
          message: '请选择活动结束时间',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.mesSendTime) {
        this.$message({
          message: '请选择活动推送时间',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.parkId) {
        this.$message({
          message: '请选择活动园区',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiAddress) {
        this.$message({
          message: '活动地址不能为空',
          type: 'error'
        })
        return
      }
      if (this.activityForm.actiCost === 'undefined') {
        this.$message({
          message: '活动费用不能为空',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiOrganizer) {
        this.$message({
          message: '主办方不能为空',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.showApplyNum) {
        this.$message({
          message: '报名人数没有选择',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.applyCheck) {
        this.$message({
          message: '报名审批没有选择',
          type: 'error'
        })
        return
      }
      if (this.activityForm.actiNumber === 'undefined') {
        this.$message({
          message: '请填写活动人数',
          type: 'error'
        })
        return
      }
      if (!this.activityForm.actiPosterUrl) {
        this.$message({
          message: '请选择活动海报',
          type: 'error'
        })
        return
      }
      this.activityForm.actiDetail = this.$refs.ue.getUEContent()
      console.log(this.activityForm.actiDetail)
      if (!this.activityForm.actiDetail) {
        this.$message({
          message: '活动详情不能为空',
          type: 'error'
        })
        return
      }
      this.activityForm.actiStatus = 2
      const data = this.activityForm
      publishActivity(data).then(res => {
        console.log(res)
        if (res.data.code === '0000') {
          this.$message({
            message: '发布成功',
            type: 'success'
          })
          this.goBack()
        } else {
          this.$message(res.data.result)
        }
      })
    },
    goBack() { // 返回
      this.$emit('goBack')
    }
  }
}
</script>

<style lang="scss" scoped>
ul {
  list-style: none;
}
.acPeople {
  position: relative;
  left: -50px;
}
.el-button {
  margin-right: 20px;
}
.poster {
  width: 120px;
  height: 120px;
  border: 1px dashed #ccc;
  cursor: pointer;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  .el-icon-plus {
    font-weight: bold;
    position:absolute;
    left:54px;
    top:54px;
  }
  img{
    width: 100%;
    height: 100%;
    z-index: 2
  }
}
.avatar-uploader .el-upload {
  border: 1px dashed red;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  background-color: green;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 38px;
  font-weight: bold;
  color: #0099e9;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 100px;
  display: block;
}
.localImg {
  .actype {
    border-left: 5px solid #0099e9;
    padding-left: 5px;
    color: #b8b8b8;
  }
  .acimg {
    height: 220px;
    overflow: auto;
    .acUl {
      display: flex;
      flex-wrap: wrap;
      padding-left: 0;
      li {
        flex: 1/3;
        margin-right: 20px;
        margin-bottom: 20px;
        width: 200px;
        height: 100px;
        img {
          width: 100%;
          height: 100%;
        }
      }
      li:nth-child(3n) {
        margin-right: 0;
      }
    }
  }
}
</style>

<template>
  <div id="queditor">
    <el-form ref="activityForm" :model="activityForm" :rules="rules" :disabled="disabledEditorFlag" label-width="200px">
      <el-form-item label="排序" prop="actiOrder">
        <el-input v-model="activityForm.actiOrder" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="首页展示" prop="isIndex" class="setHeight">
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
      <el-form-item label="活动时间" class="setHeight" prop="actiStartTime">
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="activityForm.actiStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始日期" style="width: 100%;" @change="getStarttime" />
        </el-col>
        <el-col :span="2" class="line" align="center">至</el-col>
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="activityForm.actiEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" style="width: 100%;" @change="getEndtime" />
        </el-col>
      </el-form-item>
      <el-form-item label="报名截止时间" prop="applyEndTime">
        <el-date-picker v-model="activityForm.applyEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择日期时间" />
      </el-form-item>
      <el-form-item label="通知推送时间" prop="mesSendTime">
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
      <el-form-item label="主办单位" prop="actiOrganizer">
        <el-input v-model="activityForm.actiOrganizer" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="指导单位" prop="actiGuideOrganizer">
        <el-input v-model="activityForm.actiGuideOrganizer" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="承办单位" prop="actiUndertakeOrganizer">
        <el-input v-model="activityForm.actiUndertakeOrganizer" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="协办单位" prop="actiCoOrganizer">
        <el-input v-model="activityForm.actiCoOrganizer" style="width: 205px;" />
      </el-form-item>
      <el-form-item label="是否展示报名人数" prop="showApplyNum" class="setHeight">
        <el-radio-group v-model="activityForm.showApplyNum">
          <el-radio label="0">不展示</el-radio>
          <el-radio label="1">展示</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="报名是否需要审批" prop="applyCheck" class="setHeight">
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
      <el-form-item label="活动详情" prop="actiDetail" class="queditor">
        <template>
          <el-row>
            <div class="editor-container">
              <UE ref="ue" :disabled-editor-flag="disabledEditorFlag" :default-msg="defaultMsg" :config="config" />
            </div>
          </el-row>
        </template>
        <!-- <template>
          <div class="edit_container" style="position:relative;">
            <div v-if="disabledEditorFlag" class="edit_box" />
            <quill-editor ref="myQuillEditor" v-model="activityForm.actiDetail" :options="editorOption" @blur="onEditorBlur1($event)" @focus="onEditorFocus1($event)" @change="onEditorChange1($event)" />
          </div>
        </template> -->
      </el-form-item>
      <el-form-item label="活动状态" prop="actiStatus">
        <el-steps :space="200" :active="activityForm.actiStatus*1" finish-status="success">
          <el-step title="待发布" />
          <el-step title="报名中" />
          <el-step title="已结束" />
        </el-steps>
      </el-form-item>
      <!-- <el-form-item>
        <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="saveDrafts">保存草稿</el-button>
        <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="release">发布</el-button>
        <el-button type="primary" @click="$router.push({path:'activityManagement'})">返回</el-button>
      </el-form-item> -->
    </el-form>
    <div class="btns">
      <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="saveDrafts">保存草稿</el-button>
      <el-button v-if="activityForm.actiStatus==='1'" type="primary" @click="release">发布</el-button>
      <el-button type="primary" @click="$router.push({path:'activityManagement'})">返回</el-button>
    </div>
    <!-- 新增海报弹出框 -->
    <el-dialog :visible.sync="dialogPosterVisible">
      <!-- <el-upload :auto-upload="false" :limit="1" :on-preview="handlePictureCardPreview" :on-remove="handleRemove" action="https://jsonplaceholder.typicode.com/posts/" list-type="picture-card">
        <i class="el-icon-plus" />
      </el-upload> -->
      <!-- <p>已选择的图片</p> -->
      <el-upload :headers="{token: $store.getters.token}" :show-file-list="false" :multiple="false" :on-change="changeImg" :on-success="handleAvatarSuccess" :before-upload="beforeAvatarUpload" :action="baseURL+'springcloud-app-fastdfs/upload/fastUpload'" class="avatar-uploader">
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
import UE from '../../components/ue.vue'
import { getToken } from '@/utils/auth'
// import {
//   getActivityType,
//   getEventPoster,
//   saveActivityDraft,
//   publishActivity,
//   getActivityDetailsForManage
// } from '@/api/portalManagement/activity'
import { api, paramApi } from '@/api/axios'
export default {
  components: { UE },
  data() {
    return {
      // content1: `<p>hello world</p>`,
      // editorOption1: {},
      baseURL: process.env.BASE_API,
      // disabled: false,
      headers: {
        token: getToken()
      },
      content: '',
      editorOption: {
        // modules: {
        //   toolbar: [
        //     ['bold', 'italic', 'underline', 'strike'], // 加粗，斜体，下划线，删除线
        //     ['blockquote', 'code-block'], // 引用，代码块

        //     [{ 'header': 1 }, { 'header': 2 }], // 标题，键值对的形式；1、2表示字体大小
        //     [{ 'list': 'ordered' }, { 'list': 'bullet' }], // 列表
        //     [{ 'script': 'sub' }, { 'script': 'super' }], // 上下标
        //     [{ 'indent': '-1' }, { 'indent': '+1' }], // 缩进
        //     [{ 'direction': 'rtl' }], // 文本方向

        //     [{ 'size': ['small', false, 'large', 'huge'] }], // 字体大小
        //     [{ 'header': [1, 2, 3, 4, 5, 6, false] }], // 几级标题

        //     [{ 'color': [] }, { 'background': [] }], // 字体颜色，字体背景颜色
        //     [{ 'font': [] }], // 字体
        //     [{ 'align': [] }], // 对齐方式

        //     ['clean'], // 清除字体样式
        //     ['image', 'video'] // 上传图片、上传视频

        //   ]
        // }
      },
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
        actiStatus: '1',
        id: '',
        applyCheck: '0',
        page: 1,
        rows: 10,
        actiGuideOrganizer: '',
        actiUndertakeOrganizer: '',
        actiCoOrganizer: ''
      },
      rules: {
        actiOrder: [{ required: true, message: '请输入排序', trigger: 'blur' }],
        isIndex: [
          { required: true, message: '请选择首页是否展示', trigger: 'change' }
        ],
        actiType: [
          { required: true, message: '请选择活动类型', trigger: 'change' }
        ],
        actiName: [
          { required: true, message: '请输入活动名称', trigger: 'blur' }
        ],
        actiStartTime: [
          { required: true, message: '请选择活动开始时间', trigger: 'change' }
        ],
        actiEndTime: [
          { required: true, message: '请选择活动结束时间', trigger: 'change' }
        ],
        applyEndTime: [
          { required: true, message: '请选择报名截止时间', trigger: 'change' }
        ],
        mesSendTime: [
          { required: true, message: '请选择通知推送时间', trigger: 'change' }
        ],
        parkId: [
          { required: true, message: '请选择活动园区', trigger: 'change' }
        ],
        actiAddress: [
          { required: true, message: '请输入活动地址', trigger: 'blur' }
        ],
        actiCost: [
          { required: true, message: '请输入活动费用', trigger: 'blur' }
        ],
        actiOrganizer: [
          { required: true, message: '请输入主办单位', trigger: 'blur' }
        ],
        showApplyNum: [
          {
            required: true,
            message: '请选择是否展示报名人数',
            trigger: 'change'
          }
        ],
        applyCheck: [
          {
            required: true,
            message: '请选择报名是否需要审批',
            trigger: 'change'
          }
        ],
        actiNumber: [
          { required: true, message: '请输入活动人数', trigger: 'blur' }
        ],
        actiPosterUrl: [
          { required: true, message: '请选择活动海报', trigger: 'change' }
        ],
        actiDetail: [
          { required: true, message: '请输入活动详情', trigger: 'blur' }
        ]
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
      },
      disabledEditorFlag: false
    }
  },
  computed: {
    editor() {
      return this.$refs.myQuillEditor.quill
    }
  },
  mounted() {
    // console.log(this.$route.query.disabled)
    if (this.$route.query.disabled) {
      this.disabledEditorFlag = true
    }
    if (this.$route.query.activityId) {
      // this.row = JSON.parse(this.$route.query.row)
      this.init()
      // this.getEditContent()
    }
    this.getActivityType()
  },
  methods: {
    // onEditorReady(editor) {
    //   // 准备编辑器
    // },
    // onEditorBlur1(val, editor) {
    //   console.log(val)
    // }, // 失去焦点事件
    // onEditorFocus1(val, editor) {
    //   // 获得焦点事件
    //   console.log(val) // 富文本获得焦点时的内容
    //   // editor.enable(false) // 在获取焦点的时候禁用
    // },
    // onEditorChange1(val, editor) {
    //   // 内容改变事件
    //   console.log(val)
    // },
    init() {
      // const data = {
      //   activityId: this.$route.query.activityId
      // }
      paramApi(
        `${this.GLOBAL.parkUrl}activity/getActivityDetailsForManage`,
        this.$route.query.activityId,
        'activityId'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
      // console.log(value)
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
      // console.log(this.content)
    },
    handleClick() {
      if (this.disabledEditorFlag) {
        this.$message.error('查看活动内容，不可编辑')
        return
      }
      if (!this.activityForm.actiType) {
        this.$message({
          message: '没有选择活动类型',
          type: 'error'
        })
        return
      }
      this.dialogPosterVisible = true
      paramApi(
        `${this.GLOBAL.parkUrl}activity/activityType/findActivityType`,
        this.activityForm.actiType,
        'typeId'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.templateList.length > 0) {
            this.templateImgList = res.data.data.templateList
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
      // if (file.length > 1) {
      //   file.shift()
      // }
      // 赋值下这个imageUrl就能看到图片了
      // this.imageUrl = URL.createObjectURL(file[0].raw)
    },
    confirm() {
      this.dialogPosterVisible = false
      this.activityForm.actiPosterUrl = this.imageUrl
      if (this.activityForm.actiPosterUrl) {
        this.$refs['activityForm'].clearValidate('actiPosterUrl')
      }
    },
    handleAvatarSuccess(res, file) {
      this.imageUrl = res.data
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
      api(
        `${this.GLOBAL.parkUrl}guest/activity/findActivityTypeList`,
        '',
        'post'
      ).then(res => {
        if (res.data.code === this.GLOBAL.code) {
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
    saveDrafts() {
      // 保存草稿
      // if (!this.activityForm.actiName) {
      //   this.$message({
      //     message: '活动名称不能为空',
      //     type: 'error'
      //   })
      //   return
      // }
      this.activityForm.actiDetail = this.$refs.ue.getUEContent()
      const data = this.activityForm
      // api(`${this.GLOBAL.parkUrl}activity/saveActivityDraft`, data, 'post').then(res => {
      //   console.log(res)
      //   if (res.data.code === this.GLOBAL.code) {
      //     this.$message({
      //       message: '保存草稿成功',
      //       type: 'success'
      //     })
      //     this.goBack()
      //     this.$router.push({ path: 'activityManagement' })
      //   } else {
      //     this.$message(res.data.result)
      //   }
      // })
      this.$refs['activityForm'].validate(valid => {
        if (valid) {
          api(
            `${this.GLOBAL.parkUrl}activity/saveActivityDraft`,
            data,
            'post'
          ).then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '保存草稿成功',
                type: 'success'
              })
              this.$refs['activityForm'].resetFields()
              this.goBack()
              this.$router.push({ path: 'activityManagement' })
            } else {
              this.$message(res.data.result)
            }
          })
        }
      })
    },
    release() {
      this.activityForm.actiDetail = this.$refs.ue.getUEContent()
      // console.log(this.activityForm.actiDetail)
      // if (!this.activityForm.actiDetail) {
      //   this.$message({
      //     message: '活动详情不能为空',
      //     type: 'error'
      //   })
      //   return
      // }
      // this.activityForm.actiStatus = 2
      const data = this.activityForm
      // api(`${this.GLOBAL.parkUrl}activity/publishActivity`, data, 'post').then(res => {
      //   console.log(res)
      //   if (res.data.code === this.GLOBAL.code) {
      //     this.$message({
      //       message: '发布成功',
      //       type: 'success'
      //     })
      //     this.goBack()
      //     this.$router.push({ path: 'activityManagement' })
      //   } else {
      //     this.$message(res.data.result)
      //   }
      // })
      this.$refs['activityForm'].validate(valid => {
        if (valid) {
          if (
            new Date(this.activityForm.applyEndTime) >
            new Date(this.activityForm.actiStartTime)
          ) {
            this.$message.error('活动报名时间不能大于活动开始时间')
            return false
          }
          this.activityForm.actiStatus = 2
          // this.activityForm.actiStatus = 2
          api(
            `${this.GLOBAL.parkUrl}activity/publishActivity`,
            data,
            'post'
          ).then(res => {
            // console.log(res)
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '发布成功',
                type: 'success'
              })

              this.goBack()
              this.$router.push({ path: 'activityManagement' })
            } else {
              this.$message(res.data.result)
            }
          })
        }
      })
    },
    goBack() {
      // 返回
      this.$emit('goBack')
    }
  }
}
</script>

<style lang="scss" scoped>
.btns {
  margin-left: 200px;
}
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
    position: absolute;
    left: 54px;
    top: 54px;
  }
  img {
    width: 100%;
    height: 100%;
    z-index: 2;
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
<style lang="scss" >
#queditor {
  .el-form-item--medium .el-form-item__content,
  .el-form-item--medium {
    line-height: 22px;
  }
}
.setHeight {
  > div {
    line-height: 36px !important;
  }
}
// .edit_box {
//   position: absolute;
//   top: 0;
//   left: 0;
//   right: 0;
//   bottom: 0;
//   z-index: 1;
//   width: 50%;
//   background-color: rgba(235, 238, 245, 0.5);
// }
// .quill-editor {
//   width: 50%;
// }
// .ql-container {
//   min-height: 200px;
// }
</style>

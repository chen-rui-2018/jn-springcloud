<template>
  <div>
    <!-- 试题名称新增状态 -->
    <div v-if="isAdd" class="examBlock bgcolor">
      <el-form>
        <el-form-item prop="researchProject">
          <el-input v-model="formData.researchProject" placeholder="请在这里输入试卷的名称"/>
        </el-form-item>
        <el-row type="flex" justify="space-between">
          <el-col :span="8">
            <el-form-item prop="trainer" label="培训讲师:" label-width="73px">
              <el-input v-model="formData.trainer" placeholder="请输入培训讲师"/>
              <el-checkbox v-model="formData.isShowTrainer" :true-label="1" :false-label="2" class="showBtn">显示</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item prop="trainDate" label="培训日期:" label-width="73px">
              <el-date-picker
                v-model="formData.trainDate"
                type="datetime"
                format="yyyy-MM-dd HH:mm:ss"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="请选择培训日期"/>
              <el-checkbox v-model="formData.isShowTrainDate" :true-label="1" :false-label="2">显示</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item prop="projectNote">
          <div class="editor-container">
            <UE ref="ue" :default-msg="formData.projectNote" :config="config"/>
          </div>
        </el-form-item>
      </el-form>
    </div>
    <!-- 试题名称编辑状态 -->
    <div v-if="!isAdd&&!isModifyTitle" class="examBlock" @mouseover="changeActive($event)" @mouseout="removeActive($event)">
      <div class="editIcon"><el-button size="samll" @click="modifyTitle"><i style="font-size:18px;" class="el-icon-edit-outline"/></el-button></div>
      <el-form :model="parentData">
        <el-form-item>
          <p style="text-align:center;">{{ parentData.researchProject }}</p>
        </el-form-item>
        <el-row type="flex" justify="space-between">
          <el-col :span="8">
            <el-form-item label="培训讲师:" label-width="73px">
              <span>{{ parentData.trainer }}</span>
              <span v-if="parentData.isShowTrainer===1">(显示)</span>
              <span v-else>(隐藏)</span>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item label="培训日期:" label-width="73px">
              <span>{{ parentData.trainDate }}</span>
              <span v-if="parentData.isShowTrainDate===1">(显示)</span>
              <span v-else>(隐藏)</span>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <div class="editContent">
            <p>{{ parentData.projectNote }}</p>
          </div>
        </el-form-item>
      </el-form>
    </div>
    <!-- 试题名称修改状态 -->
    <div v-click-outside="saveFirst" v-if="!isAdd&&isModifyTitle" class="examBlock">
      <el-form :model="parentData">
        <el-form-item prop="researchProject">
          <el-input v-model="parentData.researchProject" placeholder="请在这里输入试卷的名称"/>
        </el-form-item>
        <el-row type="flex" justify="space-between">
          <el-col :span="8">
            <el-form-item prop="trainer" label="培训讲师:" label-width="73px">
              <el-input v-model="parentData.trainer" placeholder="请输入培训讲师"/>
              <el-checkbox :checked="parentData.isShowTrainer===1?true:false" v-model="parentData.isShowTrainer" :true-label="1" :false-label="2" class="showBtn">显示</el-checkbox>
            </el-form-item>
          </el-col>
          <el-col :span="8">
            <el-form-item prop="trainDate" label="培训日期:" label-width="73px">
              <el-date-picker
                v-model="parentData.trainDate"
                type="datetime"
                format="yyyy-MM-dd HH:mm:ss"
                value-format="yyyy-MM-dd HH:mm:ss"
                placeholder="请选择培训日期"/>
              <el-checkbox :checked="parentData.isShowTrainDate===1?true:false" v-model="parentData.isShowTrainDate" :true-label="1" :false-label="2">显示</el-checkbox>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item prop="projectNote">
          <div class="editor-container">
            <UE ref="ue" :default-msg="parentData.projectNote" :config="config"/>
          </div>
        </el-form-item>
        <el-form-item><el-button type="primary" @click="saveItem">保存</el-button></el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import {
  api
} from '@/api/hr/train'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  // 自定义指令-鼠标点击外事件
  directives: {
    clickOutside: {
      // 初始化指令
      bind(el, binding, vnode) {
        function clickHandler(e) {
          // 这里判断点击的元素是否是本身，是本身，则返回
          if (el.contains(e.target)) {
            return false
          }
          // 判断指令中是否绑定了函数
          if (binding.expression) {
            // 如果绑定了函数 则调用那个函数，此处binding.value就是handleClose方法
            binding.value(e)
          }
        }
        // 给当前元素绑定个私有变量，方便在unbind中可以解除事件监听
        el.__vueClickOutside__ = clickHandler
        document.addEventListener('click', clickHandler)
      },
      update() {},
      unbind(el, binding) {
        // 解除事件监听
        document.removeEventListener('click', el.__vueClickOutside__)
        delete el.__vueClickOutside__
      }
    }
  },
  props: ['isAdd', 'parentData'],
  data() {
    return {
      isModifyTitle: false,
      // 新增的试题头对象
      formData: {
        researchProject: '',
        trainer: '',
        isShowTrainer: '',
        trainDate: '',
        isShowTrainDate: '',
        projectNote: ''
      },
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 150,
        autoFloatEnabled: false
      }
    }
  },
  created() {},
  methods: {
    // 新增时把试题头值传过去
    passData() {
      this.formData.projectNote = this.$refs.ue.getUEContent()
      return this.formData
    },
    // 鼠标移入加入class
    changeActive($event) {
      $event.currentTarget.className = 'examBlock bgColor'
    },
    removeActive($event) {
      $event.currentTarget.className = 'examBlock'
    },
    saveFirst() {
      this.$message.warning('请先保存此模块！')
    },
    // 试题头修改
    modifyTitle() {
      this.isModifyTitle = true
    },
    // 试题头保存修改
    saveItem() {
      this.parentData.projectNote = this.$refs.ue.getUEContent()
      api('hr/train/updateInvestiage', this.parentData).then(res => {
        if (res.data.code === '0000') {
          this.isModifyTitle = false
        } else {
          this.$message.error(res.data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.bgColor {
    background-color: #fafafa;
    cursor: pointer;
}
.examBlock {
    position: relative;
    padding: 20px;
    margin-bottom: 20px;
    .editIcon {
        text-align: right;
        margin-bottom: 20px;
    }
    .showBtn {
        position: absolute;
        right: -57px;
        top: 0;
    }
    .editContent {
        border-top:1px dashed #ccc;
        border-bottom:1px dashed #ccc;
        padding:20px;
    }
}
</style>

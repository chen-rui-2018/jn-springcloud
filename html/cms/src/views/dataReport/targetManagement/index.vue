<template>
  <div class="target-management">
    <div class="target-management-l" @contextmenu.prevent="rightClick">
      <div class="tree-filter-bg bg-gray">
        <el-input
          v-model="filterText"
          style="width: 100%;"
          placeholder="请输入指标名"/>
      </div>
      <div>
        <el-tree
          id="tree"
          ref="tree"
          :data="targetTreeData"
          :props="defaultProps"
          :filter-node-method="filterNode"
          class="filter-tree"
          default-expand-all
          highlight-current
          @node-click="nodeClick"
          @node-contextmenu="rightClick"
        />
      </div>
      <div v-show="menuVisible">
        <ul id="menu" :style="menuStyle" class="menu">
          <li class="menu__item" @click="isAddCardPing = true">新建指标</li>
        </ul>
      </div>
    </div>
    <div class="target-management-r">
      <el-form ref="formData" :model="formData" :rules="rules" label-width="0.1px">
        <target-row class="target-row" title="指标名称">
          <el-form-item :style="{margin: 0}" prop="targetName">
            <el-input v-model="formData.targetName" placeholder="请输入" style="width: 200px"/>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="指标填写格式">
          <el-row
            v-for="(inputFormatModel, index) in formData.inputFormatModels"
            :key="index"
            :gutter="10"
            type="flex"
            align="middle"
            class="form-models-row">
            类型
            <el-col :span="4">
              <el-form-item
                :style="{margin: 0}"
                :rules="{
                  required: true, message: '请选择类型', trigger: 'change'
                }"
                :prop="'inputFormatModels.' + index + '.formType'">
                <el-select v-model="inputFormatModel.formType" placeholder="请选择类型">
                  <el-option
                    v-for="item in targetFormatType"
                    :label="item.label"
                    :value="item.value"
                    :key="item.value"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item
                :style="{margin: 0}"
                :rules="{
                  required: formData.inputFormatModels.length > 1, message: '有多个填报格式的时候需要填写', trigger: 'blur'
                }"
                :prop="'inputFormatModels.' + index + '.formName'">
                <el-input v-model="inputFormatModel.formName" placeholder="指标名称"/>
              </el-form-item>
            </el-col>
            <el-col v-if="inputFormatModel.formType === 3 || inputFormatModel.formType === 4" :span="10">
              <el-form-item
                :style="{margin: 0}"
                :rules="{
                  required: inputFormatModel.formType === 3 || inputFormatModel.formType === 4, message: '请填写指标名称', trigger: 'blur'
                }"
                :prop="'inputFormatModels.' + index + '.choiceOption'">
                <el-input v-model="inputFormatModel.choiceOption" placeholder="候选值，中文逗号隔开，如：男,女"/>
              </el-form-item>
            </el-col>
            排序
            <el-col :span="4">
              <el-form-item
                :style="{margin: 0}"
                :rules="{ required: true, message: '请输入顺序', trigger: 'blur' }"
                :prop="'inputFormatModels.' + index + '.orderNumber'">
                <el-input-number v-model="inputFormatModel.orderNumber" :min="0" style="width: 100%" label="顺序"/>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item :style="{margin: 0}" prop="inputFormatModels.required">
                <el-checkbox v-model="inputFormatModel.required">设置必填</el-checkbox>
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-button type="primary" icon="el-icon-plus" size="mini" @click="addFormType(index)"/>
              <el-button v-if="index !== 0" type="warning " icon="el-icon-minus" size="mini" @click="deleteFormType(index)"/>
            </el-col>
          </el-row>
        </target-row>
        <target-row class="target-row" title="指标填写是否支持多行">
          <el-form-item :style="{margin: 0}" prop="isMuiltRow">
            <el-radio-group v-model="formData.isMuiltRow">
              <el-radio :label="0">是</el-radio>
              <el-radio :label="1">否</el-radio>
            </el-radio-group>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="指标排序">
          <el-form-item :style="{margin: 0}" prop="orderNumber">
            <el-input-number v-model="formData.orderNumber" :min="0" placeholder="请输入数字" label="描述文字"/>
            <span>是指在其父级下所有子指标的排列顺序</span>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="指标单位">
          <el-form-item :style="{margin: 0}" prop="unit">
            <el-input v-model="formData.unit" placeholder="例：万元" style="width: 200px"/>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="指标分类">
          <el-form-item :style="{margin: 0}" prop="targetType">
            <el-radio-group v-model="formData.targetType">
              <el-radio :disabled="!!currentTarget && addingSonTarget && formData.targetType !== '0'" label="0">企业指标</el-radio>
              <el-radio :disabled="!!currentTarget && addingSonTarget && formData.targetType !== '1'" label="1">园区指标</el-radio>
            </el-radio-group>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="所属部门">
          <el-form-item
            :style="{margin: 0}"
            :rules="{
              required: formData.targetType === '1', message: '请选择部门', trigger: 'change'
            }"
            prop="departmentId">
            <el-select
              v-model="formData.departmentId"
              :disabled="formData.targetType !== '1'"
              placeholder="请选择">
              <el-option
                v-for="(item, index) in departmentOptions"
                :key="index"
                :label="item.label"
                :value="item.value"
                @click.native="formData.departmentName = item.label"/>
            </el-select>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="指标父类">{{ parentName }}</target-row>
        <target-row class="target-row" title="指标说明">
          <el-form-item :style="{margin: 0}" prop="targetComment">
            <el-input v-model="formData.targetComment" type="textarea"/>
          </el-form-item>
        </target-row>
      </el-form>
      <div class="submit-row">
        <el-button :disabled="submitting" type="primary" @click="submitTarget">保存</el-button>
        <el-button :disabled="submitting || formData.targetId === ''" type="primary" @click="invalidTarget">失效</el-button>
        <el-button type="primary" @click="resetForm('formData')">重置</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { deepClone } from '@/utils'
import {
  getAllDepartment
} from '@/api/oa/meetingManagement'
import targetRow from '../common/target-row'
export default {
  name: 'TargetManagement',
  components: {
    targetRow
  },
  data() {
    const checkDepartmentId = (rule, value, callback) => {
      if (this.formData.targetType === 1 && !value) {
        return callback(new Error('请选择'))
      } else {
        callback()
      }
    }
    return {
      menuStyle: {},
      menuVisible: false,
      isAddCardPing: false,
      targetTreeData: [],
      currentTarget: '',
      addingSonTarget: '',
      originalInputFormatModels: {
        formId: '0',
        formType: '',
        formName: '',
        required: false,
        orderNumber: '',
        choiceOption: '',
        recordStatus: 1,
        targetId: '0001'
      },
      originFormData: null,
      formData: {
        targetId: '',
        targetName: '',
        isMuiltRow: '',
        unit: '',
        targetType: '',
        departmentId: '',
        departmentName: '',
        parentId: '0',
        inputFormatModels: [{
          formId: '0',
          formType: '',
          formName: '',
          required: false,
          orderNumber: '',
          choiceOption: '',
          recordStatus: 1,
          targetId: '0001'
        }],
        targetComment: '',
        recordStatus: '1',
        orderNumber: ''
      },
      departmentOptions: [],
      submitting: false,
      parentName: '',
      targetFormatType: [{
        label: '文本框',
        value: '0'
      }, {
        label: '多行文本框',
        value: '1'
      }, {
        label: '数字',
        value: '2'
      }, {
        label: '单选框',
        value: '3'
      }, {
        label: '多选框',
        value: '4'
      }, {
        label: '图片上传',
        value: '5'
      }],
      filterText: '',
      rules: {
        targetName: [
          { required: true, message: '请输入指标名称', trigger: 'blur' }
        ],
        inputFormatModels: {
          formType: [
            { required: true, message: '请输入表单类型', trigger: 'change' }
          ],
          formName: [
            { required: true, message: '请输入指标名称', trigger: 'blur' }
          ],
          orderNumber: [
            { required: true, type: 'number', message: '请输入顺序', trigger: 'blur' }
          ],
          required: [
            { required: false, message: '是否必填', trigger: 'blur' }
          ]
        },
        isMuiltRow: [
          { required: true, message: '请选择', trigger: 'change' }
        ],
        orderNumber: [
          { required: true, message: '请输入指标排序', trigger: 'blur' },
          { required: true, type: 'number', message: '请输入数字', trigger: 'blur' }
        ],
        unit: [
          { required: true, message: '请输入指标单位', trigger: 'blur' }
        ],
        targetType: [
          { required: true, message: '请输入指标分类', trigger: 'change' }
        ],
        departmentId: [
          { validator: checkDepartmentId, trigger: 'blur' }
        ],
        targetComment: [
          { required: true, message: '请输入指标说明', trigger: 'blur' }
        ]
      },
      defaultProps: {
        children: 'children',
        label: 'text'
      }
    }
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val)
    }
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      this.originFormData = deepClone(this.formData)
      this.getData()
      this.getAllDepartment()
    },
    getData() {
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/target/getTargetTree`).then(data => {
        this.targetTreeData = data.data
      })
    },
    addFormType(index) {
      this.formData.inputFormatModels.splice(index + 1, 0, deepClone(this.originalInputFormatModels))
    },
    deleteFormType(index) {
      this.$confirm('确定删除该表格?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.formData.inputFormatModels.splice(index, 1)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    submitTarget() {
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.submitting = true
          this.formData.inputFormatModels.forEach(item => { item.required = item.required * 1 })
          this.$_post(`${this.GLOBAL.enterpriseUrl}data/target/updateTarget`, this.formData).then(data => {
            if (data.code === '0000') {
              this.getData()
              this.submitting = false
              this.resetForm('formData')
              this.$message.success('保存成功')
            } else {
              this.$message.error('提交失败')
            }
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    invalidTarget() {
      this.$confirm('确定作废该指标?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.submitting = true
        this.$_get(`${this.GLOBAL.enterpriseUrl}data/target/invalidTarget?targetId=${this.formData.targetId}`)
          .then(data => {
            if (data.code === '0000') {
              this.submitting = false
              this.getData()
              this.resetForm('formData')
              this.formData = deepClone(this.originFormData)
              this.$message.success('保存成功')
            } else {
              this.$message.error('提交失败')
            }
          })
      }).catch(() => {
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
      this.addingSonTarget = false
    },
    // 获取组织部门列表
    getAllDepartment() {
      getAllDepartment().then(({ data }) => {
        if (data.code === '0000') {
          this.departmentOptions = data.data.map(item => ({ value: item.departmentId, label: item.departmentName }))
        } else {
          this.$message.error(data.result)
        }
      })
    },
    filterNode(value, data) {
      if (!value) return true
      return data.text.indexOf(value) !== -1
    },
    rightClick(MouseEvent, object, Node, element) {
      this.currentTarget = object
      // 鼠标右击触发事件
      // 先把模态框关死，目的是 第二次或者第n次右键鼠标的时候 它默认的是true
      this.menuVisible = false
      // 显示模态窗口，跳出自定义菜单栏
      this.menuVisible = true
      this.menuStyle = {
        left: MouseEvent.clientX + 'px',
        top: MouseEvent.clientY + 'px'
      }
      // 给整个document添加监听鼠标事件，点击任何位置执行foo方法
      document.addEventListener('click', this.selectTarget)
    },
    selectTarget() {
      // 取消鼠标监听事件 菜单栏
      this.menuVisible = false
      this.formData = deepClone(this.originFormData)
      if (this.currentTarget) {
        this.addingSonTarget = true
        this.formData.parentId = this.currentTarget.id
        this.formData.targetType = this.currentTarget.targetType
        this.parentName = this.currentTarget.text
      } else {
        this.currentTarget = ''
        this.parentName = ''
        this.addingSonTarget = false
      }
      // 要及时关掉监听，不关掉的是一个坑，虽然前台显示的时候没有啥毛病，加一个alert你就知道了
      document.removeEventListener('click', this.selectTarget)
    },
    nodeClick(node) {
      const id = node.id
      if (this.formData.targetId === id) {
        return
      }
      this.currentTarget = ''
      this.addingSonTarget = false
      this.parentName = node.text
      this.formData.parentId = id
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/target/getTargetInfo`, { targetId: id }).then(data => {
        if (data.code === '0000') {
          const formData = this.formData
          for (const key in formData) {
            if (formData.hasOwnProperty(key)) {
              formData[key] = data.data[key]
            }
          }
          formData.targetType = formData.targetType.toString()
        } else {
          this.$message.error(data.result)
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  @import "~@/styles/r-common";

  .target-management {
    $gray: #ebebeb;
    min-height: 100%;
    @include flex($v: flex-start);
    border: 1px solid $gray;
    background-color: #fff;
    .target-management-l {
      border-top: 1px solid $gray;
      .tree-filter-bg {
        padding: 4px;
      }
      .filter-tree {
        min-height: 100%;
      }
      min-height: 100%;
      width: 200px;
      flex: none;
      padding: 15px 15px 100px 15px;
    }
    .target-management-r {
      min-height: 100%;
      width: 100%;
      padding: 15px;
      flex: 1;
      border: 1px solid $gray;
      .target-row {
        margin: 5px auto;
      }
    }
    .submit-row {
      margin: 20px 10px;
    }
    .target-row {
      .form-models-row {
        margin-bottom: 20px;
        &:last-of-type {
          margin-bottom: 0;
        }
      }
    }
    .menu {
      position: fixed;
      z-index: 1;
      border-radius: 2px;
      border: 1px solid $gray;
      background-color: #f4f4f4;
      padding: 0;
      margin: 0;
      -webkit-box-shadow: 0 0.5em 1em 0 rgba(0, 0, 0, 0.1);
      box-shadow: 0 0.5em 1em 0 rgba(0, 0, 0, 0.1);
    }
    .menu__item {
      width: 90px;
      height: 32px;
      line-height: 32px;
      text-align: center;
      display: block;
      color: #1a1a1a;
      cursor: pointer;
      &:hover {
        background-color: #409EFF;
        color: white;
      }
    }
  }
</style>

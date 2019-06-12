<template>
  <div class="target-management">
    <div class="target-management-l">
      <div class="tree-filter-bg bg-gray">
        <el-input
          v-model="filterText"
          style="width: 100%;"
          placeholder="请输入模板名称"/>
      </div>
      <el-tree
        ref="tree"
        :data="templateTree"
        :props="defaultProps"
        :filter-node-method="filterNode"
        :highlight-current="true"
        class="filter-tree"
        default-expand-all
        @node-click="nodeClick"
        @node-contextmenu="rightClick"
      />
      <div v-show="menuVisible">
        <ul id="menu" :style="menuStyle" class="menu">
          <li class="menu__item" @click="addModel">新建模板</li>
        </ul>
      </div>
    </div>
    <div v-loading="loading" class="target-management-r">
      <el-form ref="formData" :model="formData" :rules="rules" label-width="0.1px">
        <target-row class="target-row" title="模板名称">
          <el-form-item :style="{margin: 0}" prop="modelName">
            <el-input v-model="formData.modelName" placeholder="请输入" style="width: 200px"/>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="填报类型">
          <el-form-item :style="{margin: 0}" prop="modelType">
            <el-radio-group v-model="formData.modelType" @change="modelTypeChange">
              <el-radio :disabled="formData.modelType !== '0'" label="0">企业</el-radio>
              <el-radio :disabled="formData.modelType !== '1'" label="1">园管委会</el-radio>
            </el-radio-group>
          </el-form-item>
        </target-row>
        <target-row v-if="formData.modelType === '0'" class="target-row" title="填报对象">
          <el-form-item :style="{margin: 0}" prop="groupId">
            <el-select v-model="formData.groupId" placeholder="请选择">
              <el-option
                v-for="item in groupOptions"
                :label="item.label"
                :value="item.value"
                :key="item.value"
              />
            </el-select>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="填报周期">
          <el-form-item :style="{margin: 0}" prop="modelCycle">
            <el-select v-model="formData.modelCycle" placeholder="请选择" @change="modelCycleChange">
              <el-option :value="0" label="月"/>
              <el-option :value="1" label="年"/>
            </el-select>
          </el-form-item>
        </target-row>
        <target-row v-if="formData.modelCycle === 0" class="target-row" title="填报任务生成和截止时间">
          <el-row>
            <el-col :span="10">
              <el-row :gutter="10" type="flex" align="middle">
                <el-col :span="4" class="tr">当月</el-col>
                <el-col :span="8">
                  <el-form-item prop="taskCreateTime" style="margin-bottom: 0;">
                    <el-input-number
                      v-model="formData.taskCreateTime"
                      :min="1"
                      :max="31"
                      controls-position="right"
                      style="width: 100%; min-width: 80px;"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="12">号生成前上月的填报模板</el-col>
              </el-row>
            </el-col>
            <el-col :span="14">
              <el-row :gutter="10" type="flex" align="middle">
                <el-col :span="6" class="tr">截止上报时间为</el-col>
                <el-col :span="6">
                  <el-form-item prop="filllInFormDeadlineMonth" style="margin-bottom: 0;">
                    <el-select
                      v-model="filllInFormDeadlineMonth"
                      placeholder="请选择"
                      style="width: 100%; min-width: 80px;">
                      <el-option label="当月" value="当月"/>
                      <el-option label="下月" value="下月"/>
                    </el-select>
                  </el-form-item>
                </el-col>
                <el-col :span="6">
                  <el-form-item prop="filllInFormDeadline" style="margin-bottom: 0;">
                    <el-input-number
                      v-model="formData.filllInFormDeadline"
                      :min="1"
                      :max="31"
                      controls-position="right"
                      style="width: 100%; min-width: 80px;"
                    />
                  </el-form-item>
                </el-col>
                <el-col :span="6">号否则作逾期处理</el-col>
              </el-row>
            </el-col>
          </el-row>
        </target-row>
        <target-row v-if="formData.modelCycle === 1" class="target-row" title="填报任务生成和截止时间">
          <el-row :gutter="10" type="flex" align="middle">
            <el-col :span="5">
              <el-date-picker
                v-model="formData.taskCreateTime"
                :picker-options="startTimePickerOptions"
                type="date"
                placeholder="选择日期"
                style="width: 100%; min-width: 80px;"
                @change="startTimeChange"/>
            </el-col>
            <el-col :span="6" class="tc">生成去年的模板数据，截止</el-col>
            <el-col :span="5">
              <el-date-picker
                v-model="formData.filllInFormDeadline"
                :picker-options="endTimePickerOptions"
                :disabled="!formData.taskCreateTime"
                type="date"
                placeholder="选择日期"
                style="width: 100%; min-width: 80px;"/>
            </el-col>
            <el-col :span="6">上报上一年数据，否则作逾期处理</el-col>
          </el-row>
        </target-row>
        <target-row class="target-row" title="提前多久预警">
          <el-form-item :style="{margin: 0}" prop="warningBeforeDays">
            <el-input-number v-model="formData.warningBeforeDays" :min="1" placeholder="请输入天数" style="width: 200px"/>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="预警方式">
          <el-form-item :style="{margin: 0}" prop="warningBy">
            <el-checkbox-group v-model="formData.warningBy">
              <el-checkbox label="0">短信</el-checkbox>
              <el-checkbox label="1">邮件</el-checkbox>
              <el-checkbox label="2">app</el-checkbox>
            </el-checkbox-group>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="数据指标">
          <div v-for="(form, index) in formData.tabs" :key="index" class="chart-list">
            <el-row align="middle" class="target-form-header">
              <el-col :span="2">表名：</el-col>
              <el-col :span="6">
                <el-form-item
                  :style="{margin: 0}"
                  :prop="'tabs.' + index + '.tabName'"
                  :rules="{ required: true, message: '请填写表名', trigger: 'blur' }">
                  <el-input v-model="form.tabName" style="width: 120px;" placeholder="请输入内容"/>
                </el-form-item>
              </el-col>
              <el-col :span="12">
                <el-form-item
                  :style="{margin: 0}"
                  :prop="'tabs.' + index + '.tabCreateType'"
                  :rules="{ required: true, message: '请填写表名', trigger: 'change' }">
                  <el-radio-group v-model="form.tabCreateType" @change="(value) => { targetTypeChange(value, index) }">
                    <el-radio label="0">普通模板</el-radio>
                    <el-radio :disabled="formData.modelType !== '1' || formData.tabs.length > 1" label="1">科技园模板
                    </el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
              <el-col :span="6" style="text-align: right;">
                <i class="el-icon-circle-plus green" @click="addTargetFormData(index, form)"/>
                <i class="el-icon-circle-close red" @click="deleteTargetFormData(index)"/>
              </el-col>
            </el-row>
            <target-frame>
              <div slot="left" class="target-data-l">
                <el-tree
                  ref="targetTree"
                  :data="form.treeData"
                  :props="defaultProps"
                  :filter-node-method="filterNode"
                  class="filter-tree"
                  default-expand-all
                  node-key="id"
                  show-checkbox
                  check-on-click-node
                  @check="(a, b, c) => setBroNode(index, a, b, c)"
                />
                <el-button class="add-more-target" icon="el-icon-plus" type="primary" @click="toTargetPage">去新增更多指标
                </el-button>
              </div>
              <div slot="right">
                <target-row v-if="form.tabCreateType !== '1'" class="target-row" title="填报数据列">
                  <el-form-item
                    :style="{margin: 0}"
                    :prop="'tabs.' + index + '.tabClumnType'"
                    :rules="{ required: true, message: '不能为空', trigger: 'change' }">
                    <el-radio-group v-model="form.tabClumnType">
                      <el-radio label="0">累计值</el-radio>
                      <el-radio label="1">本期值</el-radio>
                    </el-radio-group>
                  </el-form-item>
                </target-row>
                <target-row v-if="form.tabCreateType !== '1'" class="target-row" title="列表指标展示">
                  <el-form-item
                    :style="{margin: 0}"
                  >
                    <el-checkbox-group v-model="form.tabClumnTargetShow">
                      <el-checkbox label="0">上月填报值</el-checkbox>
                      <el-checkbox label="1">上年同期值</el-checkbox>
                      <el-checkbox label="2">上月上年同期值</el-checkbox>
                      <el-checkbox label="3">增幅</el-checkbox>
                    </el-checkbox-group>
                  </el-form-item>
                </target-row>
                <div class="target-form-title">指标</div>
                <div class="target-form-body">
                  <el-tag
                    v-for="(tag, tagIndex) in form.targetList"
                    :key="tag.id"
                    :closable="true"
                    class="target-tags"
                    @close="tagClose(index, tagIndex)"
                  >
                    {{ tag.text }}
                  </el-tag>
                </div>
              </div>
            </target-frame>
          </div>
          <div class="preview-form">
            <el-button type="primary" @click="previewForm">预览</el-button>
          </div>
          <el-tabs v-loading="previewing" v-if="!previewing" type="border-card">
            <el-tab-pane v-for="(tab, formIndex) in formData.tabs" :key="formIndex" :label="tab.tabName">
              <tree-table v-if="tab.treeTableData" :data="tab.treeTableData" :columns="tab.columns" border expand-all/>
            </el-tab-pane>
          </el-tabs>
        </target-row>
        <target-row class="target-row" title="数据上报页面广告（PC）">
          <el-upload
            :on-error="handleError"
            :headers="{token: $store.getters.token}"
            :on-remove="(file, fileList) => { return handleRemove(file, fileList, 'tempPcUrl', 'pcAd')}"
            :before-upload="(file) => { return beforeUpload(file, true)}"
            :on-success="(res, file, fileList) => { return uploadDone(res, file, fileList, 'tempPcUrl')}"
            :on-exceed="handleExceed"
            :limit="1"
            :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :file-list="pcFileList"
            list-type="picture-card"
            accept=".gif,.jpeg,.jpg">
            <i class="el-icon-plus"/>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible" size="tiny">
            <img :src="dialogImageUrl" width="100%" alt="">
          </el-dialog>
          <div style="margin-top: 20px;">请添加PC版数据上报页面广告图片</div>
        </target-row>
        <target-row class="target-row" title="数据上报页面广告（APP）">
          <el-upload
            :on-error="handleError"
            :headers="{token: $store.getters.token}"
            :on-remove="(file, fileList) => { return handleRemove(file, fileList, 'tempAppUrl', 'appAd')}"
            :before-upload="(file) => { return beforeUpload(file, true)}"
            :on-success="(res, file, fileList) => { return uploadDone(res, file, fileList, 'tempAppUrl')}"
            :on-exceed="handleExceed"
            :limit="1"
            :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
            :file-list="appFileList"
            list-type="picture-card"
            accept=".gif,.jpeg,.jpg">
            <i class="el-icon-plus"/>
          </el-upload>
          <el-dialog :visible.sync="dialogVisible" size="tiny">
            <img :src="dialogImageUrl" width="100%" alt="">
          </el-dialog>
          <div style="margin-top: 20px;">请添加APP版数据上报页面广告图片</div>
        </target-row>
        <target-row class="target-row" title="模板描述">
          <el-form-item :style="{margin: 0}" prop="comment">
            <el-input v-model="formData.comment" type="textarea"/>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="附件上传">
          <el-upload
            :on-error="handleError"
            :headers="{token: $store.getters.token}"
            :on-remove="(file, fileList) => { return handleRemove(file, fileList, 'otherDataUrl', 'otherData')}"
            :before-upload="beforeUpload"
            :on-success="(res, file, fileList) => { return uploadDone(res, file, fileList, 'otherDataUrl')}"
            :on-exceed="handleExceed"
            :limit="1"
            :file-list="otherFileList"
            :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'">
            <el-button size="small" type="primary">点击上传</el-button>
            <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过20M</div>
          </el-upload>
        </target-row>
        <target-row class="target-row" title="模板状态">
          <el-form-item :style="{margin: 0}" prop="recordStatus">
            <el-radio-group v-model="formData.recordStatus">
              <el-radio label="0">发布</el-radio>
              <el-radio label="1">暂停</el-radio>
              <el-radio label="2">失效</el-radio>
            </el-radio-group>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="预警提醒人（企业完成所有，填报后接受信息人）">
          <el-form-item :style="{margin: 0}" prop="reminder">
            <el-select v-model="formData.reminder" placeholder="请选择">
              <el-option v-for="item in warnerOptions" :label="item.label" :key="item.id" :value="item.id"/>
            </el-select>
          </el-form-item>
        </target-row>
        <target-row class="target-row" title="模板顺序">
          <el-form-item :style="{margin: 0}" prop="orderNumber">
            <el-input-number v-model="formData.orderNumber" :min="0" placeholder="请输入" style="width: 200px"/>
          </el-form-item>
        </target-row>
      </el-form>
      <div class="submit-row">
        <el-button type="primary" @click="submitTarget">保存</el-button>
        <el-button :disabled="submitting" type="primary">取消</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import targetRow from '../common/target-row'
import targetFrame from '../common/target-frame'
import targetForm from '../common/target-form'
import treeTable from '../common/tree-table/index'
import { deepClone } from '../../../utils'

export default {
  name: 'TargetManagement',
  components: {
    targetForm,
    targetRow,
    targetFrame,
    treeTable
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
      startTimePickerOptions: {
        disabledDate(time) {
          return time.getTime() < Date.now() - 8.64e7
        }
      },
      endTimePickerOptions: {},
      loading: false,
      menuStyle: {},
      currentModel: '',
      previewing: true,
      menuVisible: false,
      tempPcUrl: '',
      tempAppUrl: '',
      otherDataUrl: '',
      pcFileList: [],
      appFileList: [],
      otherFileList: [],
      baseUrl: process.env.BASE_API,
      dialogImageUrl: '',
      acceptType: ['jpg', 'png', 'gif'],
      dialogVisible: false,
      templateTree: [],
      modelFormTargetOptions: [], // 填报对象列表选项
      filllInFormDeadlineMonth: '当月', // 选择当月或下月
      originTab: { // tab表初始化数据
        tabName: '', // tab名称 表名
        tabClumnType: '', // 表填报列类型（0：累计值；1：本期值）
        tabCreateType: '', // 表生成模式（0:普通模板1：科技园模板）
        tabClumnTargetShow: [], // 表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅）
        orderNumber: '', // tab表的显示顺序（因为可能会存在一组tabtab1tab2）
        status: '1', // 状态（0：作废；1有效）
        targetList: [], // 指标数组
        inputList: [], // 填报格式数组
        treeTableData: [], // 选中的指标树结构
        columns: [],
        treeData: [] // 树数组
      },
      columns: [ // 表头
        {
          text: '指标名称',
          value: 'text',
          width: 200
        },
        {
          text: '单位',
          value: 'unit'
        }
      ],
      warnerOptions: [],
      originFormData: {},
      formData: {
        modelId: '', // 模板id
        modelName: '', // 模板名称
        modelType: '', // 填报类型（0：企业，1：园管委会）
        departmentId: '', // 填报对象，类型是园区时候
        departmentName: '', // 填报对象，类型是园区时候
        groupId: '', // 填报对象，类型是园区企业时候
        modelFormTargetId: '', // 填报对象 填报群组(企业群组)/园区填报部门
        modelCycle: 0, // 填报周期（1：年，0：月）
        taskCreateTime: '', // 年报表：任务生成日期（YYYYMMDD）月报表：是一个01-31之间的数字
        filllInFormDeadline: '', // 年报表：截止日期（YYYYMMDD）月报表：当月/下月+01-31之间的数字
        warningBeforeDays: '', // 提前预警天数
        warningBy: [], // 预警方式：（0:短信1:邮件2:app）多选，值以逗号隔开
        tabs: [],
        pcAd: '', // PC广告图
        appAd: '', // app广告图
        comment: '', // 模板描述
        otherData: '', // 附件
        recordStatus: '', // 模板名状态
        reminder: '', // 预警提醒人
        orderNumber: '' // 模板顺序
      },
      departmentOptions: [],
      groupOptions: [],
      submitting: false,
      filterText: '',
      rules: {
        value: [
          { required: true, message: '请输入', trigger: 'blur' }
        ],
        tabs: { // tab表初始化数据
          tabClumnType: [
            { required: true, message: '请输入', trigger: 'blur' }
          ],
          tabCreateType: [
            { required: true, message: '请输入', trigger: 'blur' }
          ],
          tabClumnTargetShow: [
            { required: true, message: '请输入', trigger: 'blur' }
          ],
          tabName: [
            { required: true, message: '请输入', trigger: 'blur' }
          ],
          targetList: [
            { required: true, message: '请输入', trigger: 'blur' }
          ]
        },
        modelName: [
          { required: true, message: '请输入模板名称', trigger: 'blur' }
        ],
        modelType: [
          { required: true, message: '请输入指标名称', trigger: 'change' }
        ],
        modelFormTargetId: [
          { required: true, message: '请输入指标名称', trigger: 'blur' }
        ],
        modelCycle: [
          { required: true, message: '请选择填报周期', trigger: 'change' }
        ],
        taskCreateTime: [
          { required: true, message: '请输入任务生成日期', trigger: 'blur' }
        ],
        filllInFormDeadline: [
          { required: true, message: '请输入截止日期', trigger: 'blur' },
          { required: true, type: 'number', message: '请输入数字', trigger: 'change' }
        ],
        filllInFormDeadlineMonth: [
          { required: false, message: '请选择', trigger: 'change' }
        ],
        warningBeforeDays: [
          { required: true, message: '请输入提前预警天数', trigger: 'blur' }
        ],
        warningBy: [
          { required: true, message: '请选择预警方式', trigger: 'blue' }
        ],
        pcAd: [
          { required: true, message: '请输入PC广告图', trigger: 'blur' }
        ],
        appAd: [
          { required: true, message: '请输入app广告图', trigger: 'blur' }
        ],
        comment: [
          { required: true, message: '请输入模板描述', trigger: 'blur' }
        ],
        otherData: [
          { required: true, message: '请输入附件', trigger: 'blur' }
        ],
        recordStatus: [
          { required: true, message: '请输入模板名状态', trigger: 'change' }
        ],
        reminder: [
          { required: true, message: '请输入预警提醒人', trigger: 'change' }
        ],
        orderNumber: [
          { required: true, message: '请输入模板顺序', trigger: 'blur' },
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
        desc: [
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
    startTimeChange() {
      this.endTimePickerOptions = {
        disabledDate: (time) => {
          return new Date(this.formData.taskCreateTime).getTime() >= time.getTime() + 8.64e7
        }
      }
    },
    init() {
      this.getModelTree()
      this.getData()
      this.getGroupOptions()
      this.originFormData = deepClone(this.formData)
    },
    getData() {
      // 获取树形指标
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/target/getTargetTree`).then(data => {
        const treeList = data.data
        this.sortTree(treeList, 'orderNumber')
        this.originTab.treeData = treeList
      })
      // 获取预警人
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/dataModel/getWarner`).then(data => {
        this.warnerOptions = data.data.map(item => ({ id: item.id, label: item.creatorAccount }))
      })
    },
    sortTree(tree, key) {
      for (let i = 0, length = tree.length; i < length; i++) {
        for (let j = i + 1; j < length; j++) {
          if (tree[i][key] > tree[j][key]) {
            const temp = tree[j]
            tree[j] = tree[i]
            tree[i] = temp
          }
        }
        if (tree[i].children && tree[i].children.length > 0) {
          this.sortTree(tree[i].children, key)
        }
      }
    },
    getModelTree() {
      // 获取树形模板
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/dataModel/getModelTree`).then(data => {
        this.templateTree = data.data
      })
    },
    modelTypeChange(modelType) {
      const treeData = this.originTab.treeData
      this.deepSetData(treeData, modelType)
      const tab = deepClone(this.originTab)
      tab.treeData = deepClone(treeData)
      this.formData.tabs = [tab]
      // console.dir(this.formData)
    },
    deepSetData(arr, modelType) {
      // 根据填报类型：企业/园区 禁用与填报类型不一样的指标树
      return new Promise(resolve => {
        for (const item of arr) {
          if (item.targetType === modelType) {
            this.$set(item, 'disabled', false)
          } else {
            this.$set(item, 'disabled', true)
          }
          if (item.hasOwnProperty('children') && item.children.length > 0) {
            this.deepSetData(item.children, modelType)
          }
        }
        resolve()
      })
    },
    partDeepClone(source, arr) {
      // 因为formData.tabs存在循getNode环引用的树节点，不能直接提交或者克隆，这里先跳过tabs属性克隆，后面再克隆tabs属性
      if (!source && typeof source !== 'object') {
        throw new Error('error arguments', 'shallowClone')
      }
      const targetObj = source.constructor === Array ? [] : {}
      Object.keys(source).forEach(keys => {
        if (arr.indexOf(keys) === -1) {
          if (source[keys] && typeof source[keys] === 'object') {
            targetObj[keys] = deepClone(source[keys], arr)
          } else {
            targetObj[keys] = source[keys]
          }
        }
      })
      return targetObj
    },
    submitTarget() {
      this.$refs['formData'].validate((valid) => {
        if (valid) {
          this.loading = true
          this.submitting = true
          // 保存的时候再预览一遍, 获取选中指标树的填报格式
          this.previewForm()
            .then(() => {
              let cache = []
              let formData = JSON.stringify(this.formData, function(key, value) {
                if (typeof value === 'object' && value !== null) {
                  if (cache.indexOf(value) !== -1) {
                    // Duplicate reference found
                    try {
                      // If this value does not reference a parent it can be deduped
                      return JSON.parse(JSON.stringify(value))
                    } catch (error) {
                      // discard key if value cannot be deduped
                      return
                    }
                  }
                  // Store value in our collection
                  cache.push(value)
                }
                return value
              })
              // Enable garbage collection
              cache = null
              formData = JSON.parse(formData)

              formData.tabs.forEach((item, index) => {
                delete item.treeData
                delete item.treeTableData
                delete item.columns
                // tab增加排序
                item.orderNumber = index.toString()
                // 多选值转字符串 1.表类型（0：上月填报值；1：上年同期值；2：上月上年同期值；3增幅)
                item.tabClumnTargetShow = item.tabClumnTargetShow.join(',')
                for (const list of item.inputList) {
                  if (list.formType === '4') {
                    list.value = ''
                  }
                }
              })

              if (formData.modelCycle === 0) {
                // 如果填报周期是月
                const filllInFormDeadline = this.formData.filllInFormDeadline < 10 ? '0' + this.formData.filllInFormDeadline : this.formData.filllInFormDeadline
                formData.filllInFormDeadline = this.filllInFormDeadlineMonth + filllInFormDeadline
                formData.taskCreateTime = this.formData.taskCreateTime
              } else {
                // 如果填报周期是年
                formData.filllInFormDeadline = this.getDate(this.formData.filllInFormDeadline)
                formData.taskCreateTime = this.getDate(this.formData.taskCreateTime)
              }
              // 预警方式数据格式由数组转字符串
              formData.warningBy = formData.warningBy.join(',')
              // 附件和图片url
              formData.pcAd = this.tempPcUrl ? this.tempPcUrl : formData.pcAd
              formData.appAd = this.tempAppUrl ? this.tempAppUrl : formData.appAd
              formData.otherData = this.otherDataUrl ? this.otherDataUrl : formData.otherData
              // 把填报格式是多选的value把数组转成字符串
              // console.dir(formData)
              // return
              formData.tabs.forEach((item, index) => {
                for (const list of item.inputList) {
                  if (list.formType === '4') {
                    list.value = ''
                  }
                }
              })
              this.$_post(`${this.GLOBAL.enterpriseUrl}data/dataModel/updateModel`, formData).then(data => {
                if (data.code === '0000') {
                  this.submitting = false
                  this.getModelTree()
                  this.loading = false
                  this.$message.success('保存成功')
                } else {
                  this.$message.error('提交失败')
                }
              })
            }, res => {
              // 预览函数reject状态回调
              this.loading = false
              this.$message.warning(res)
            })
        } else {
          this.$message.warning('请完善表格信息！')
          return false
        }
      })
    },
    setOrder(tree) {
      // 保存时给动态表单填报格式添加行号排序，以免回显时和填报时顺序不一样
      return new Promise(resolve => {
        for (const form of tree) {
          for (const arr of form.inputFormatModel) {
            arr.forEach((item, index) => {
              item.order = index
            })
          }
          if (form.hasOwnProperty('children') && form.children.length > 0) {
            this.setOrder(form.children)
          }
        }
        resolve()
      })
    },
    targetTypeChange(value, index) {
      // 把已选表单清空，对应的指标树根据普通模板或科技园模板设置禁用
      const tab = this.formData.tabs[index]
      this.$refs.targetTree[index].setCheckedKeys([])
      tab.tabClumnType = ''
      tab.tabClumnTargetShow = []
    },
    filterNode(value, data) {
      if (!value) return true
      return data.text.indexOf(value) !== -1
    },
    getModelData(id) {
      // 获取模板详情
      return new Promise(resolve => {
        this.$_get(`${this.GLOBAL.enterpriseUrl}data/dataModel/getModel`, { modelId: id }).then(data => resolve(data))
      })
    },
    nodeClick(node) {
      //  隐藏菜单栏
      this.menuVisible = false

      // 查看模板信息，右侧显示模板信息
      const id = node.id
      // 如果点击的是当前模板就return
      if (this.formData.modelId === id || node.id === '001' || node.id === '002') {
        return
      }
      // 回显模板信息
      this.loading = true
      this.getModelData(id)
        .then(data => {
          if (data.code === '0000') {
            this.formData = data.data
            const formData = this.formData
            formData.modelType = formData.modelType.toString()
            formData.recordStatus = formData.recordStatus.toString()
            // 图片和附件上传的回显
            this.pcFileList = formData.pcAd ? [{ name: formData.pcAd, url: formData.pcAd }] : []
            this.appFileList = formData.appAd ? [{ name: formData.appAd, url: formData.appAd }] : []
            this.otherFileList = formData.otherData ? [{ name: formData.otherData, url: formData.otherData }] : []
            this.deepSetData(this.originTab.treeData, formData.modelType)
              .then(() => {
                // 等上一步递归完成
                // tab表排序
                formData.tabs.sort((a, b) => {
                  return a['orderNumber'] - b['orderNumber']
                })
                formData.tabs.forEach((item, index) => {
                  this.$set(item, 'treeTableData', [])
                  item.tabClumnTargetShow = item.tabClumnTargetShow.length > 0 ? item.tabClumnTargetShow.split(',') : []

                  item.treeData = deepClone(this.originTab.treeData)
                  // 等上一步深拷贝完成
                  this.$nextTick(() => {
                    // 指标树同级不选中设置禁用
                    // 因为选择指标时，最高级的父指标只能选择一个，它的兄弟指标和其子指标都设置禁用
                    let parentNode
                    for (const list of item.targetList) {
                      if (list.pid === '0') {
                        parentNode = list
                        break
                      }
                    }
                    const treeData = item.treeData
                    // 如果指标树不是空状态
                    for (const tree of treeData) {
                      // 如果不属于选择节点的最高级父指标，即兄弟指标，那么设置禁用
                      if (tree.id !== parentNode.id) {
                        // this.setBroDisabled(tree)
                      }
                    }
                    for (const obj of item.targetList) {
                      for (const list of item.targetList) {
                        if (obj.id === list.pid) {
                          obj.hasChild = true
                          break
                        }
                      }
                    }
                    // 设置对应的指标树
                    const arr = item.targetList.filter(list => !list.hasChild)
                    this.$refs.targetTree[index].setCheckedNodes(arr)
                  })
                })
              })

              // 返回的字符串放回多选v-model数组 预警方式
            formData.warningBy = formData.warningBy.length > 0 ? formData.warningBy.split(',') : []
            if (formData.modelCycle === 0) {
              // 如果填报周期是月
              this.filllInFormDeadlineMonth = formData.filllInFormDeadline.substring(0, 2)
              formData.filllInFormDeadline = formData.filllInFormDeadline.substring(2)
            } else {
              // 如果填报周期是年
              formData.taskCreateTime = this.formatDate(formData.taskCreateTime)
              formData.filllInFormDeadline = this.formatDate(formData.filllInFormDeadline)
            }
          } else {
            this.$message.error(data.result)
          }
          this.loading = false
        })
    },
    formatDate(str) {
      return str.substring(0, 4) + '-' + str.substring(4, 6) + '-' + str.substring(6, 8)
    },
    getDate(str) {
      const date = new Date(str)
      const y = date.getFullYear()
      let m = date.getMonth() + 1
      m = m > 10 ? m : '0' + m
      let d = date.getDate()
      d = d > 10 ? d : '0' + d
      return y + m + d
    },
    rightClick(MouseEvent, object, node, element) {
      if (node.level !== 1) {
        return
      }
      // 鼠标右击触发事件，显示新建按钮，并把当前点击节点挂载到this实例
      this.currentModel = object
      // 先把模态框关死，目的是 第二次或者第n次右键鼠标的时候 它默认的是true
      this.menuVisible = false
      // 显示模态窗口，跳出自定义菜单栏
      this.menuVisible = true
      this.menuStyle = {
        left: MouseEvent.clientX + 'px',
        top: MouseEvent.clientY + 'px'
      }
      // 给整个document添加监听鼠标事件，点击任何位置执行cancelAddModel方法
      document.addEventListener('click', this.cancelAddModel)
    },
    addModel() {
      // 新建模板和取消鼠标监听事件 菜单栏
      this.menuVisible = false
      // 新建时清空表单，获取右击点击节点的信息
      this.$refs['formData'].resetFields()
      this.formData = deepClone(this.originFormData)
      this.formData.modelType = this.currentModel.id === '001' ? '0' : '1'
      this.modelTypeChange(this.formData.modelType)
      this.tempPcUrl = ''
      this.tempAppUrl = ''
      this.otherDataUrl = ''
      this.pcFileList = []
      this.appFileList = []
      this.otherFileList = []
      // 要及时关掉监听，不关掉的是一个坑，加一个alert就知道了
      document.removeEventListener('click', this.addModel)
      this.$message.success(this.formData.modelType === '0' ? '你新建了一个企业模板' : '你新建了一个园区模板')
    },
    cancelAddModel() {
      // 隐藏菜单栏
      this.menuVisible = false
    },
    setBroNode(index, target, nodes) {
      // 因为选择指标时，最高级的父指标只能选择一个，它的兄弟指标和其子指标都设置禁用
      const treeData = this.formData.tabs[index].treeData
      // 如果指标树不是空状态
      if (nodes.checkedNodes.length > 0) {
        // 获取当前选择节点的最高级父指标
        const parentNode = nodes.halfCheckedNodes.length > 0 ? nodes.halfCheckedNodes[0] : nodes.checkedNodes[0]
        for (const tree of treeData) {
          // 如果不属于选择节点的最高级父指标，即兄弟指标，那么设置禁用
          if (tree.id !== parentNode.id) {
            this.setBroDisabled(tree)
          }
        }
      } else {
        // 如果指标树是空状态，全部解除禁用
        this.formData.tabs[index].treeData = deepClone(this.originTab.treeData)
      }
      this.formData.tabs[index].targetList = this.$refs.targetTree[index].getCheckedNodes(false, true)
    },
    setBroDisabled(tree) {
      // 兄弟指标设置禁用函数
      tree.disabled = true
      if (tree.children && tree.children.length > 0) {
        for (const item of tree.children) {
          this.setBroDisabled(item)
        }
      }
    },
    modelCycleChange() {
      // 切换年月填报周期时，把上次输入的值清空
      this.formData.taskCreateTime = ''
      this.formData.filllInFormDeadline = ''
    },
    addTargetFormData(index, form) {
      if (form.tabCreateType === '1') {
        this.$message.warning('一个模板只能创建一个科技园模板表单')
        return
      }
      this.$message.success('添加表格成功')
      this.formData.tabs.push(deepClone(this.originTab))
    },
    deleteTargetFormData(index) {
      const tabs = this.formData.tabs
      if (tabs.length >= 2) {
        this.$confirm('确定删除该表格?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          tabs.splice(index, 1)
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
      } else {
        this.$message.warning('已经是最后一张表了')
      }
    },
    tagClose(index, tagIndex) {
      // 获取当前tab树形指标
      const targetList = this.formData.tabs[index].targetList
      // 当前关闭的指标
      const tag = targetList[tagIndex]
      // 判断该指标下是否有被选中的子指标，默认false
      let same
      for (const list of targetList) {
        if (tag.id === list.pid) {
          same = true
          break
        }
      }
      if (same) {
        // 如果要关闭的指标下面有被选中的子指标
        this.tagListSplice(tag.id, targetList)
      } else {
        // 如果没有
        targetList.splice(tagIndex, 1)
      }
      // 把选中的父指标节点过滤掉，el-tree组件会根据选中的子节点设置父指标，因为如果设置父指标节点进el-tree，那么在check-strictly关联状态下，父节点下面的子节点会全部选中
      const arr = targetList.filter(item => !item.hasOwnProperty('children') || (item.hasOwnProperty('children') && item.children.length === 0))
      this.$refs.targetTree[index].setCheckedNodes(arr)
    },
    tagListSplice(id, arr) {
      // 关闭右侧被选中指标tag的时候，如果关闭的是父指标，那么要把它下面的子指标全清空，当前节点不用删除，后面会有过滤父指标的操作
      for (let i = 0; i < arr.length; i++) {
        if (id === arr[i].pid) {
          if (arr[i].children && arr[i].children.length > 0) {
            this.tagListSplice(arr[i].id, arr)
          }
          arr.splice(i, 1)
          i--
        }
      }
    },
    // 获取群组列表
    getGroupOptions() {
      this.$_get(`${this.GLOBAL.enterpriseUrl}data/dataModel/getGroupList`).then(data => {
        if (data.code === '0000') {
          this.groupOptions = data.data.map(item => ({ value: item.groupId, label: item.groupName }))
        } else {
          this.$message.error(data.result)
        }
      })
    },
    previewForm() {
      // 预览表单的处理函数
      return new Promise((resolve, reject) => {
        // 预览处理中的状态
        this.previewing = true
        // 循环表格生成预览数据
        const promiseList = []
        this.formData.tabs.map((tab, tabIndex) => {
          const p = new Promise((listResolve, listReject) => {
            // 预览时清空一下表头和表格树数据
            tab.columns = []
            tab.treeTableData = []

            // 获取选中的指标树，包括半选节点
            const nodeList = this.$refs.targetTree[tabIndex].getCheckedNodes(false, true)
            if (nodeList.length === 0) {
              reject(`请选择第${tabIndex + 1}个表格的指标，指标至少要选择一个！`)
            }

            // 判断是普通模板或科技园模板，生成对应的报表
            const isCommonType = tab.tabCreateType === '0'
            if (isCommonType) {
              // 普通模板时
              // 填报数据列 表填报列类型（0：累计值；1：本期值）
              if (tab.tabClumnType === '') {
                this.$message.warning('请完善填报数据列！')
                return
              }
              if (tab.tabCreateType === '') {
                this.$message.warning('请填写模板生成方式！')
                return
              }

              // 整合表头
              const date = new Date()
              const year = date.getFullYear()
              const month = date.getMonth() + 1
              const tabClumnTypeOption = {
                0: `${year}年1-${month}月`,
                1: `${year}年${month}月`
              }

              // 模拟的数据
              const tabClumnTargetShow = tab.tabClumnTargetShow
              const tabClumnType = tab.tabClumnType // 填报数据列
              const tabClumnTargetShowOption = {
                0: {
                  text: `${year}年${month - 1}月`,
                  value: 'lastMonth'
                },
                1: {
                  text: tabClumnType === '0' ? `${year - 1}年1-${month}月` : `${year - 1}年${month}月`,
                  value: 'lastYear'
                },
                2: {
                  text: `${year - 1}年${month - 1}月`,
                  value: 'lastYearMonth'
                },
                3: {
                  text: '增幅%',
                  value: 'increase'
                }
              }
              const tabClumnTargetShowList = []
              tabClumnTargetShow && tabClumnTargetShow.sort((a, b) => {
                return Number(a) - Number(b)
              })
              for (const item of tabClumnTargetShow) {
                tabClumnTargetShowList.push(tabClumnTargetShowOption[item])
              }
              // 表头
              tab.columns = this.columns.concat([{
                text: tabClumnTypeOption[tabClumnType],
                value: 'inputFormatModel',
                width: 600
              }], tabClumnTargetShowList)

              // 把渲染表单规则挂载到已经勾选的各个结构指标
              const targetIdList = nodeList.map(list => list.id)
              this.getInputFormat(targetIdList)
                .then(data => {
                  // "66383ef743624c69b8f8f9e44b980119"
                  tab.inputList = deepClone(data.data)
                  const formModels = tab.inputList
                  formModels.sort((a, b) => {
                    return a['rowNum'] - b['rowNum']
                  })
                  nodeList.sort((a, b) => {
                    return a.orderNumber - b.orderNumber
                  })
                  this.treeMerge(formModels, nodeList)
                  // 一维的结构指标转成树结构
                  const list = this.toTree(nodeList)

                  // 勾选的树结构指标挂载到tree-table
                  this.sortTree(list, 'orderNumber')
                  this.$nextTick(() => {
                    this.$set(tab, 'treeTableData', list)
                    listResolve()
                  })
                })
            } else {
              //  科技园模板表头
              tab.columns = nodeList.map(node => ({ text: node.text, value: node.text }))
              listResolve()
            }
          })
          promiseList.push(p)
        })
        Promise.all(promiseList)
          .then(() => {
            this.previewing = false
            resolve()
          })
      })
    },
    toTree(arr) {
      const ids = arr.map(a => a.id)
      const arrNotParent = arr.filter(({ pid }) => pid && !ids.includes(pid))
      const _ = (arr, pID) =>
        arr.filter(({ pid }) => pid === pID)
          .map(a => ({
            ...a,
            children: _(arr.filter(({ pid }) => pid !== pID), a.id)
          }))
      return _(arr).concat(arrNotParent)
    },
    getInputFormat(list) {
      // 根据选中的指标，获取它们对应的填报格式
      return new Promise((resolve, reject) => {
        this.$_post(`${this.GLOBAL.enterpriseUrl}data/dataModel/getInputFormatByTargetIds`, { targetIds: list }).then(data => {
          if (data.code === '0000') {
            resolve(data)
          } else {
            reject()
            this.$message.error('获取指标填报格式失败，请重新操作')
          }
        })
      })
    },
    treeMerge(formModels, tree) {
      // 递归选中的指标树节点和获取到的填报格式数组比对，寻找对应的填报格式，并挂载到指标节点中
      for (const target of tree) {
        if (!target.hasOwnProperty('inputFormatModel')) {
          this.$set(target, 'inputFormatModel', [[]])
        } else {
          target.inputFormatModel = [[]]
        }
        for (const item of formModels) {
          if (target.id === item.targetId) {
            if (item.formType === '2') {
              item.value = null
            } else if (item.formType === '4') {
              item.value = []
            }
            target.inputFormatModel[0].push(item)
          }
        }
      }
    },
    uploadDone(res, file, fileList, name) {
      this[name] = res.data
    },
    beforeUpload(file, isRequireFileType) {
      // 判断上传文件类型
      if (isRequireFileType) {
        const isAccept = this.acceptType.indexOf(file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase())
        if (isAccept < 0) {
          this.$message.warning(`只支持${this.acceptType.join(',')}文件类型`)
          return false
        }
      }
      if (file.size / 1024 / 1024 > 20) {
        this.$message.warning('文件不能大于20M')
        return false
      }
    },
    handleRemove(file, fileList, name, dataName) {
      // 删除时把临时的tempUrl清空
      this[name] = ''
      // 回显时，如果删除了图片或者附近，把原来formData上对应的数据也删掉
      this.formData[dataName] = ''
    },
    handleError(e) {
      throw new Error(e)
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    },
    toTargetPage() {
      if (!this.formData.modelId) {
        this.$confirm('将要跳到指标管理页面，当前已填写表单信息会丢失，确定跳转?', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$router.push('/dataReport/targetManagement')
        }).catch(() => {

        })
      } else {
        this.$router.push('/dataReport/targetManagement')
      }
    }
  }
}
</script>

<style lang="scss" scoped>
  @import "~@/styles/r-common";

  .target-management {
    min-width: 1100px;
    $gray: #ebebeb;
    min-height: 100%;
    @include flex($v: flex-start);
    background-color: #fff;
    border: 1px solid $gray;

    .target-management-l {
      width: 200px;
      .tree-filter-bg {
        padding: 4px;
      }

      .filter-tree {
        min-height: 100%;
      }

      min-height: 100%;
      padding: 15px;
    }

    .target-management-r {
      min-height: 100%;
      width: calc(100% - 200px);
      padding: 15px;
      border-left: 1px solid $gray;

      .chart-list {
        margin: 20px auto;
      }

      .target-row {
        margin: 5px auto;
      }
    }

    .submit-row {
      margin: 20px auto;
      text-align: center;
    }

    .target-data-l {
      min-height: 100%;
      display: flex;
      flex-direction: column;
      overflow: auto;

      .filter-tree {
        min-height: calc(100%);
      }

      .add-more-target {
        margin-top: 20px;
      }
    }

    .preview-form {
      margin: 20px auto;
      text-align: center;
    }

    $gray: #ebebeb;

    .target-form-header {
      padding: 10px;
      background-color: $gray;
      @include flex($h: space-between);
    }

    .target-form-title {
      text-align: center;
      background-color: $gray;
      padding: 10px;
    }

    .target-form-body {
      padding: 10px;
      border: 1px solid $gray;

      .target-tags {
        margin: 10px;
      }
    }

    .green {
      color: limegreen;
      font-size: 18px;
      margin: 0 10px;
    }

    .red {
      color: orangered;
      font-size: 18px;
    }

    .green,
    .red {
      cursor: pointer;
      transition: .2s;

      &:hover {
        opacity: .8;
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
<style lang="scss">
  .target-management {
    .el-tree-node__content {
      height: auto;
      padding: 2px;
    }

    .el-tree-node {
      white-space: normal;
    }
  }
</style>

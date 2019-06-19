<template>
  <div class="data-report">
    <el-tabs
      type="border-card"
      @tab-click="changeDepartment">
      <el-tab-pane
        v-for="(form, index) in formDataListTitle"
        :key="index"
        v-loading="loadingFormData"
        :label="form.departmentName">
        <el-tabs type="border-card">
          <el-tab-pane
            v-for="(tab, tabIndex) in formData.tabs"
            :key="tabIndex"
            :label="tab.tabName"
            v-loading="loadingTab">
            <tree-table :isReported="formData.taskInfo.status" :modelType="formData.modelType" :data="tab.targetList" :columns="tab.columns" border expand-all/>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
  import treeTable from './common/tree-table/index'
  import { deepClone, isMobile } from '@/util'
  import Swiper from 'swiper'

  export default {
    name: "dataReportEntrance",
    components: {
      treeTable
    },
    mounted() {
      this.init()
    },
    data() {
      return {
        departmentStatus: '',
        submitting: false,
        isMobile: isMobile(),
        loadingFormData: true,
        loadingTab: true,
        formDataListTitle: [{
          departmentName: '全部',
          departmentId: null,
          status: 0
        }],
        formData: {},
        columns: [ // 表头
          {
            text: '指标名称',
            value: 'text',
            width: 240
          },
          {
            text: '单位',
            value: 'unit',
            width: 120
          },
        ],
        appColumns: [ // 表头
          {
            text: '指标名称',
            value: 'text',
            width: 80
          },
          {
            text: '单位',
            value: 'unit',
            width: 40
          },
        ]
      }
    },
    methods: {
      init() {
        // 获取表单原始数据
        this.getData()
          .then(() => {
            // 格式化树形指标、表头和otherColumns
            return this.formatFormData()
          })
          .then(() => {
            this.loadingTab = false
          })
      },
      formatFormData() {
        return new Promise(resolve => {
          for (const tab of this.formData.tabs) {
            // 填报格式根据指标id挂载到树形指标上面
            this.formatInputFormatModel(tab)
            // 格式化表头设置key对应指标上otherColumn的数据
            this.formatColumn(tab)
            // 把otherColumns的对象根据指标id挂载到树形指标上面
            this.formatTreeOtherColumnData(tab)
            this.sortTree(tab.targetList, 'orderNumber')
          }
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
      formatInputFormatModel(tab) {
        // 填报格式合并到树指标
        this.treeMerge(tab.inputList, tab.targetList)
      },
      formatColumn(tab) {
        // 整合表头
        tab.columns = !this.isMobile ? deepClone(this.columns) : deepClone(this.appColumns)
        // 如果是PC端才有上期填报值的表头
        const formTime = this.formData.taskInfo.formTime
        const date = new Date(formTime.substring(0, 4) + '-' + formTime.substring(4, 6))
        const tabColumnType = tab.tabColumnType
        let text = date.getFullYear() + '年'
        if (tabColumnType === '0') {
          text += '1-'
        }
        text += parseInt((date.getMonth() + 1)) + '月'
        tab.columns.push({
          text: text,
          value: 'inputFormatModel',
          width: !this.isMobile ? 600 : ''
        })
        if (!this.isMobile) {
          if (tab.otherColumn) {
            for (const key in tab.otherColumn) {
              let text
              if (key.length === 6) {
                text = key.substring(0, 4) + '年' + key.substring(4, 6) + '月'
              } else{
                text = key + '年'
              }
              tab.columns.push({
                text: text,
                value: key,
                width: 160
              })
            }
          }
        }
      },
      changeDepartment(el) {
        this.loadingTab = true
        // 表格中有来自不同部门的指标，tab查看指定部门时，不属于该部门的是没有权限填报的，所以根据填报格式的部门id和当前部门的id比对来设置权限
        const index = Number(el.index)
        const departmentId = this.formDataListTitle[index].departmentId
        this.formData.departmentId = departmentId
        this.getDepartmentJurisdiction(departmentId)
      },
      getDepartmentJurisdiction(departmentId) {
        //  如果是园区报表，等待填报格式合成完毕再给指标树加上权限控制
        const formData = this.formData
        for (const tab of  formData.tabs) {
          this.formatTreeJurisdiction(tab.targetList, departmentId)
        }
      },
      formatTreeJurisdiction(arr, departmentId) {
        // 填报格式设置权限字段
        for (const list of arr) {
          if (departmentId === list.departmentId) {
            this.$set(list, 'hasJurisdiction', true)
          } else {
            this.$set(list, 'hasJurisdiction', false)
          }
          if (list.hasOwnProperty('children') && list.children.length > 0) {
            this.formatTreeJurisdiction(list.children, departmentId)
          }
          this.$nextTick(() => {
            this.loadingTab = false
          })
        }
      },
      formatTreeOtherColumnData(tab) {
        // 递归选中的指标树节点和获取到的累计列对象数组比对，寻找对应的累计列数据，并挂载到指标节点中
        if (tab.otherColumn) {
          this.treeOtherColumnMerge(tab.targetList, tab.otherColumn)
        }
      },
      treeOtherColumnMerge(treeData, otherColumn) {
        // 其他表格列的值（上期值比对）挂载到树形指标，跟着指标循环的时候显示
        for (const target of treeData) {
          for (const key in otherColumn){
            this.$set(target, key, [])
            if (otherColumn[key]) {
              for(const column of otherColumn[key]) {
                if (target.id === column.targetId) {
                  target[key].push({
                    value: column.value || '-',
                    label: column.formName
                  })
                }
              }
            }
          }
          if (target.hasOwnProperty('children') && target.children.length > 0) {
            this.treeOtherColumnMerge(target.children, otherColumn)
          }
        }
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
                if (item.value) {
                  item.value = Number(item.value)
                } else {
                  item.value = null
                }
              } else if (item.formType === '4') {
                if (item.value) {
                  item.value = item.value.split(',')
                } else {
                  item.value = []
                }
              }else if (item.formType === '5') {
                item.fileList = item.value ? [{ name: item.value, url: item.value }] : []
              }
              target.inputFormatModel[0].push(item)
            }
          }
          // 指标按行号升序
          for (const list of target.inputFormatModel) {
            list.sort((a, b) => {
              return a['rowNum'] - b['rowNum']
            })
          }
          if (target.hasOwnProperty('children') && target.children.length > 0) {
            this.treeMerge(formModels, target.children)
          }
        }
      },
      submitForDone() {
        // 点击提交按钮
        const _this = this
        // 验证表格
        this.submit()
          .then(formData => {
            this.submitting = true
            this.api.post({
              url: 'enterpriseSaveCompanyFormData',
              data: formData,
              callback(res) {
                if (res.code === "0000") {
                  _this.$message.success('保存成功')
                } else {
                  _this.$message.error('保存失败')
                }
              }
            })
          }, err => {
            console.dir(err)
          })
      },
      submitForDraft() {
        // 提交草稿
        const _this = this
        // 验证表格
        this.submit()
          .then(formData => {
            this.api.post({
              url: 'enterpriseSaveCompanyFormDataIsDraft',
              data: formData,
              callback(res) {
                if (res.code === "0000") {
                  _this.$message.success('保存成功')
                } else {
                  _this.$message.error('保存失败')
                }
              }
            })
          })
      },
      checkInputFormatModel(tree, resolve, reject) {
        // 递归选中的指标树节点和获取到的填报格式数组比对，寻找对应的填报格式，并挂载到指标节点中
        for (const target of tree) {
          for (const list of target.inputFormatModel) {
            for (const input of list) {
              if ((target.hasJurisdiction && Number(input.required) && !input.value && input.formType !== '2') || (target.hasJurisdiction && Number(input.required) && input.value.length === 0)) {
                reject({ target, input })
              }
            }
          }
          if (target.hasOwnProperty('children') && target.children.length > 0) {
            this.checkInputFormatModel(target.children, resolve, reject)
          }
        }
        resolve()
      },
      validateInputFormatModel() {
        return new Promise((resolve, reject) => {
          this.formData.tabs.forEach(tab => {
            this.checkInputFormatModel(tab.targetList, resolve, reject)
          })
        })
      },
      submit() {
        return new Promise((resolve, reject) => {
          this.validateInputFormatModel()
            .then(() => {
              this.formData.tabs.forEach(item => {
                this.setOrder(item.targetList)
              })
              const formData = this.partDeepClone(this.formData, ['tabs'])
              // 先克隆提交表单对象
              formData.tabs = this.formData.tabs.map(item => this.partDeepClone(item, ['targetList', 'columns']))
              // 把填报格式是多选的value把数组转成字符串
              formData.tabs.forEach((item, index) => {
                for (const list of item.inputList) {
                  if (list.formType === '4') {
                    list.value = list.value.join(',')
                  }
                }
              })
              resolve(formData)
            },({ target, input }) => {
              if (input.formName) {
                this.$message.warning(`${target.text}指标里的${input.formName}要求必填，请填写后提交`)
              } else {
                this.$message.warning(`${target.text}指标要求必填，请填写后提交`)
              }
              reject()
            })
        })
      },
      setOrder(tree) {
        // 保存时给动态表单填报格式添加行号排序，以免回显时和填报时顺序不一样
        return new Promise(resolve => {
          for (const form of tree) {
            for (const arr of form.inputFormatModel) {
              arr.forEach((item, index) => {
                item.rowNum = index
              })
            }
            if (form.hasOwnProperty('children') && form.children.length > 0) {
              this.setOrder(form.children)
            }
          }
          resolve()
        })
      },
      getData() {
        return new Promise((resolve, reject) => {
          this.loadingFormData = true
          this.loadingTab = true
          const _this = this
          this.api.get({
            url: `enterpriseGetCompanyFormedStruct`,
            data: {
              fileId: _this.$route.query.fileId
            },
            callback(res) {
              if (res.code === "0000") {
                _this.formData = res.data
                _this.formData.tabs.sort((a, b) => {
                  return a['orderNumber'] - b['orderNumber']
                })
                if (_this.formData.modelType === 1) {
                  const gardenFiller = _this.formData.gardenFiller
                  const departmentId = _this.formDataListTitle[0].departmentId
                  const departmentStatus = _this.formDataListTitle[0].status
                  if (gardenFiller) {
                    _this.formDataListTitle = _this.formDataListTitle.concat(gardenFiller)
                  }
                  for (const tab of  _this.formData.tabs) {
                    _this.formatTreeJurisdiction(tab.targetList, departmentId)
                  }
                  _this.departmentStatus = departmentStatus
                  _this.formData.departmentId = departmentId
                }
                _this.formDataListTitle.forEach((item, index) => {
                  if (index !== 0) {
                    const status  = item.status
                    const gardenExamineStatus = item.gardenExamineStatus
                    if(status === 0){
                      if(gardenExamineStatus === 1){
                        item.departmentName += '(待审核)'
                      }else if(gardenExamineStatus === 0){
                        item.departmentName += '(审核通过)'
                      }else{
                        item.departmentName += '(审核不通过)'
                      }
                    }else{
                      item.departmentName += '(未填报)'
                    }
                  }
                })
                _this.formData.departmentId = _this.formDataListTitle[0].departmentId
                resolve()
              } else {
                _this.$message.error(res.result)
                reject()
              }
              _this.loadingFormData = false
              _this.loadingTab = false
            }
          })
        })
      },
      getFormData() {
        return this.formData
      },
      partDeepClone(source, arr) {
        // 因为formData.tabs存在循环引用的树节点，不能直接提交或者克隆，这里先跳过tabs属性克隆，后面再克隆tabs属性
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
      }
    }
  }
</script>

<style lang="scss" scoped>
  .data-report{
    width: 100%;
    .btn-row {
      margin: 20px auto;
      text-align: center;
    }
    .swiper-slide {
      width: 100%;
      img {
        width: 100%;
        max-height: 400px;
      }
    }
  }
</style>

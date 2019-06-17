<template>
  <div class="data-report">
    <!--    <div id="advertisement" class="swiper-container">-->
    <!--      <div class="swiper-wrapper">-->
    <!--        <div class="swiper-slide" v-for="(img, index) in adUrls" :key="index">-->
    <!--          <img :src="img" class="swiper-slide-img" alt="">-->
    <!--        </div>-->
    <!--      </div>-->
    <!--    </div>-->
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
            v-loading="loadingTab">
            <span slot="label" class="flex-center">
              {{ tab.tabName }}
            </span>
            <tree-table :isReported="formData.taskInfo.status" :modelType="formData.modelType" :data="tab.targetList"
                        :columns="tab.columns" border expand-all/>
          </el-tab-pane>
        </el-tabs>
      </el-tab-pane>
    </el-tabs>
    <div class="btn-row">
      <el-button size="small" type="primary" :disabled="canFill" @click="submitForDraft">保存为草稿</el-button>
      <el-button size="small" type="primary" :disabled="canFill" @click="submitForDone">提交</el-button>
      <el-button size="small" type="primary" v-if="formData.otherData">
        <a :href="formData.otherData" download="" target="_blank">点击下载附件</a>
      </el-button>
      <el-button @click="$router.back()" size="small" type="primary">返回</el-button>
    </div>
  </div>
</template>

<script>
  import treeTable from './common/tree-table/index'
  import {deepClone, isMobile} from '@/util'
  import Swiper from 'swiper'

  export default {
    name: "dataReportEntrance",
    components: {
      treeTable
    },
    mounted() {
      this.init()
    },
    computed: {
      canFill() {
        if (this.submitting) {
          return true
        }
        if (this.formData.taskInfo && this.formData.taskInfo.status === 0) {
          return true
        }
        if (this.formData.modelType === 1 && !this.formData.departmentId) {
          return true
        }
        if (this.departmentStatus === 0) {
          return true
        }
      }
    },
    data() {
      return {
        flatteningInputList: [],
        submitting: false,
        isMobile: isMobile(),
        loadingFormData: true,
        loadingTab: true,
        formDataListTitle: [{
          departmentName: '全部',
          departmentId: null,
          status: 0
        }],
        departmentStatus: '',
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
        ],
        adUrls: [], // 轮播图片
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
        this.getPcAd()
          .then(() => {
            // new Swiper('#advertisement', {
            //   autoplay:true,
            //   loop:true
            // })
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
              if (key) {
                let text
                if (key.length === 6) {
                  text = key.substring(0, 4) + '年' + key.substring(4, 6) + '月'
                } else {
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
        }
      },
      changeDepartment(el) {
        this.loadingTab = true
        // 表格中有来自不同部门的指标，tab查看指定部门时，不属于该部门的是没有权限填报的，所以根据填报格式的部门id和当前部门的id比对来设置权限
        const index = Number(el.index)
        const departmentId = this.formDataListTitle[index].departmentId
        this.departmentStatus = this.formDataListTitle[index].status
        this.formData.departmentId = departmentId
        this.getDepartmentJurisdiction(departmentId)
        this.$nextTick(() => {
          this.loadingTab = false
        })
      },
      getDepartmentJurisdiction(departmentId) {
        //  如果是园区报表，等待填报格式合成完毕再给指标树加上权限控制
        for (const tab of this.formData.tabs) {
          this.formatTreeJurisdiction(tab.targetList, departmentId)
        }
      },
      formatTreeJurisdiction(arr, departmentId) {
        // 填报格式设置权限字段
        for (const list of arr) {
          if (departmentId === list.departmentId && this.departmentStatus !== 0) {
            this.$set(list, 'hasJurisdiction', true)
          } else {
            this.$set(list, 'hasJurisdiction', false)
          }
          if (list.hasOwnProperty('children') && list.children.length > 0) {
            this.formatTreeJurisdiction(list.children, departmentId)
          }
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
          for (const key in otherColumn) {
            if (key) {
              this.$set(target, key, [])
              if (otherColumn[key]) {
                for (const column of otherColumn[key]) {
                  if (target.id === column.targetId) {
                    target[key].push({
                      value: column.value || '-',
                      label: column.formName
                    })
                  }
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
              } else if (item.formType === '5') {
                item.fileList = item.value ? [{name: item.value, url: item.value}] : []
              }
              if (!target.inputFormatModel[Number(item.rowNum)]) {
                target.inputFormatModel[Number(item.rowNum)] = []
              }
              target.inputFormatModel[Number(item.rowNum)].push(item)
            }
          }
          // 同一行的指标按按排序升序
          for (const list of target.inputFormatModel) {
            list.sort((a, b) => {
              return a['orderNumber'] - b['orderNumber']
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
            this.$confirm('确定提交吗?', '提交过后不能再次修改！', {
              confirmButtonText: '确定',
              cancelButtonText: '取消',
              type: 'warning'
            }).then(() => {
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
                  _this.submitting = false
                }
              })
            }).catch(() => {
              this.$message({
                type: 'info',
                message: '已取消提交'
              })
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
                _this.submitting = false
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
                reject({target, input})
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
                this.flatteningInputList = []
                this.setOrderAndFormatInputList(item.targetList)
                item.flatteningInputList = this.flatteningInputList
              })
              const formData = this.partDeepClone(this.formData, ['tabs'])
              // 先克隆提交表单对象
              formData.tabs = this.formData.tabs.map(item => this.partDeepClone(item, ['targetList', 'inputList', 'columns']))
              // 把填报格式是多选的value把数组转成字符串
              formData.tabs.forEach((item, index) => {
                for (const list of item.flatteningInputList) {
                  if (list.formType === '4') {
                    list.value = list.value.join(',')
                  }
                }
                item.inputList = item.flatteningInputList
                delete item.flatteningInputList
              })
              resolve(formData)
            }, ({target, input}) => {
              let text
              if (input.formName) {
                text = `${target.text}指标里的${input.formName}要求必填，请填写后提交`
              } else {
                text = `${target.text}指标要求必填，请填写后提交`
              }
              this.$confirm(text, {
                confirmButtonText: '确定',
                type: 'warning'
              }).then(res => {
              }).catch(err => {
                console.dir(err)
              })
              reject()
            })
        })
      },
      setOrderAndFormatInputList(tree) {
        /* 1 保存时给动态表单填报格式添加行号排序，以免回显时和填报时顺序不一样
        * 2 把指标树里的填报格式取出来放到一个属性数组里，再赋值给inputList提交
        * */
        return new Promise(resolve => {
          for (const form of tree) {
            form.inputFormatModel.forEach((arr, arrIndex) => {
              arr.forEach((item, index) => {
                item.rowNum = arrIndex
                item.orderNumber = index
                // 存到一个属性的数组
                this.flatteningInputList.push(item)
              })
            })
            if (form.hasOwnProperty('children') && form.children.length > 0) {
              this.setOrderAndFormatInputList(form.children)
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
          const type = this.$route.query.type
          let url
          if (type === 'form') {
            url = 'enterpriseGetFormStruct'
          } else if (type === 'formed') {
            url = 'enterpriseGetCompanyFormedStruct'
          }
          this.api.get({
            url: url,
            data: {
              fileId: _this.$route.query.fileId
            },
            callback(res) {
              if (res.code === "0000") {
                _this.formData = res.data
                _this.formData.tabs.sort((a, b) => {
                  return a['orderNumber'] - b['orderNumber']
                })
                const departmentId = _this.formDataListTitle[0].departmentId
                _this.departmentStatus = _this.formDataListTitle[0].status
                _this.formData.departmentId = departmentId
                if (_this.formData.modelType === 1) {
                  const gardenFiller = _this.formData.gardenFiller
                  if (gardenFiller) {
                    _this.formDataListTitle = _this.formDataListTitle.concat(gardenFiller)
                  }
                  for (const tab of  _this.formData.tabs) {
                    _this.formatTreeJurisdiction(tab.targetList, departmentId)
                  }
                }
                resolve()
              } else {
                _this.$message.error(res.result)
                reject(res.result)
              }
              _this.loadingTab = false
              _this.loadingFormData = false
            }
          })
        })
      },
      getPcAd() {
        return new Promise((resolve, reject) => {
          const _this = this
          this.api.get({
            url: 'enterpriseGetPcAd',
            callback(res) {
              if (res.code === "0000") {
                // _this.adUrls = res.data.adUrls.filter(src =>  !!src)
                resolve()
              } else {
                _this.$message.error(res.result)
                reject()
              }
            }
          })
        })
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
  .data-report {
    .wait-filled-dot {
      display: inline-block;
      width: 8px;
      height: 8px;
      border-radius: 50%;
      background-color: #f56c6c;
    }

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

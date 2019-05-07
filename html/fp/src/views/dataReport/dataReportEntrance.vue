<template>
  <div class="data-report">
    <div id="advertisement" class="swiper-container">
<!--      <div class="swiper-wrapper">-->
<!--        <div class="swiper-slide" v-for="(img, index) in adUrls" :key="index">-->
<!--          <img :src="img" class="swiper-slide-img" alt="">-->
<!--        </div>-->
<!--      </div>-->
    </div>
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
    <div class="btn-row">
      <el-button size="small" type="primary" @click="submitForDraft">保存为草稿</el-button>
      <el-button size="small" type="primary" @click="submitForDone">提交</el-button>
      <el-button size="small" type="primary" v-if="formData.otherData">
        <a :href="formData.otherData" download="" target="_blank">点击下载附件</a>
      </el-button>
      <el-button @click="$router.back()" size="small" type="primary">返回</el-button>
    </div>
  </div>
</template>

<script>
  import treeTable from './common/tree-table/index'
  import { deepClone } from '@/util'
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
        loadingFormData: true,
        loadingTab: true,
        formDataListTitle: [{
          name: '企业',
          id: ''
        }],
        formData: {},
        columns: [ // 表头
          {
            text: '指标名称',
            value: 'text',
            width: 160
          },
          {
            text: '单位',
            value: 'unit',
            width: 160
          }
        ],
        adUrls: [], // 轮播图片
      }
    },
    methods: {
      init() {
        this.getData()
          .then(() => {
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
            this.formatInputFormatModel(tab)
            this.formatColumn(tab)
            this.formatTreeOtherColumnData(tab)
          }
        })
      },
      formatInputFormatModel(tab) {
        this.treeMerge(tab.inputList, tab.targetList)
      },
      formatColumn(tab) {
        // 整合表头
        const formTime = this.formData.taskInfo.formTime
        const date = new Date(formTime.substring(0, 4) + '-' + formTime.substring(4, 6))
        const tabColumnType = tab.tabColumnType
        tab.columns = deepClone(this.columns)
        let text = date.getFullYear() + '年'
        if (tabColumnType === '0') {
          text += '1-'
        }
        text += parseInt((date.getMonth() + 1)) + '月'
        tab.columns.push({
          text: text,
          value: 'inputFormatModel',
          width: 600
        })
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
      },
      changeDepartment(el) {
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
        for (const list of arr) {
          if (departmentId === list.departmentId) {
            this.$set(list, 'hasJurisdiction', true)
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
        for (const target of treeData) {
          for (const key in otherColumn){
            if (otherColumn[key]) {
              for(const column of otherColumn[key]) {
                if (target.id === column.targetId) {
                  target.key = column.value
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
        const _this = this
        this.submit()
          .then(formData => {
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
          })
      },
      submitForDraft() {
        const _this = this
        this.submit()
          .then(formData => {
            console.dir(JSON.stringify(formData))
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
      submit() {
        return new Promise((resolve, reject) => {
          this.formData.tabs.forEach(item => {
            item.inputList.some(input => {
              if ((input.required && !value) || (input.required && value.length === 0)) {
                this.$message.warning(`${input.formName}要求必填，请填写后提交`)
                return true
              }
            })
          })
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
          // console.dir(JSON.stringify(formData))
          resolve(formData)
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
            url: `enterpriseGetFormStruct`,
            data: {
              fileId: _this.$route.query.id
            },
            callback(res) {
              if (res.code === "0000") {
                _this.formData = res.data
                _this.formData.tabs.sort((a, b) => {
                  return a['orderNumber'] - b['orderNumber']
                })
                if ( _this.formData.modelType === 1) {
                  _this.loadingFormData = false
                  _this.formDataListTitle = _this.formData.gardenFiller
                  for (const tab of  _this.formData.tabs) {
                    const departmentId = _this.formDataListTitle[0].departmentId
                    _this.formatTreeJurisdiction(tab.targetList, departmentId)
                  }
                }
                _this.formData.departmentId = _this.formDataListTitle[0].departmentId
                resolve()
              } else {
                _this.$message.error(res.result)
                reject()
              }
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
                _this.adUrls = res.data.adUrls
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
      }
    }
  }
</style>

<template>
  <div>
    <el-form ref="assessment" :model="assessment" :rules="rules" label-width="200px">
      <el-form-item label="考核名称" prop="assessmentName">
        <el-input v-model="assessment.assessmentName" style="width: 205px;"/>
      </el-form-item>
      <el-form-item label="考核开始时间" prop="assessmentTime">
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="assessment.assessmentStartTime" value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="选择开始日期" style="width: 210px;" @change="getStarttime" />
        </el-col>
        <el-col :span="2" class="line" align="center">至</el-col>
        <el-col :span="11" style="width:auto;">
          <el-date-picker v-model="assessment.assessmentEndTime" type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="选择结束时间" style="width: 210px;" @change="getEndtime" />
        </el-col>
      </el-form-item>
      <el-form-item label="考核模板" prop="templateId" class="inline">
        <el-select v-model="assessment.templateId" placeholder="请选择考核模板" filterable @change="templateIdSel">
          <el-option v-for="item in templates" :key="item.templateId" :label="item.templateName" :value="item.templateId" />
        </el-select>
      </el-form-item>
      <el-form-item label="考核对象" prop="assessmentObject" class="inline">
        <!--最后子节点支持多选  only-last="true" -->
        <el-cascader-multi ref="assessmentObjectRef" v-model="checkList" :data="deptEmployeeList" :only-last="true" :show-leaf-label="true" style="width: 620px" @change="assessmentObjectSel"/>
        <!--<el-input v-model="assessmentObjectData" type="textarea" style="width: 500px;" readonly="readonly"/>
        <el-button type="text" @click="openAssessmentObjPage">选择</el-button>-->
      </el-form-item>
      <el-form-item label="考核人" prop="assessmentPeople" class="inline">
        <el-cascader
          :options="deptEmployeeList"
          v-model="assessmentPeopleArr"
          change-on-select
          placeholder="请选择"
          clearable
          @change="assessmentPeopleSel"
        />
        <!--<el-cascader-multi v-model="checkList" :data="deptEmployeeList" style="width: 620px" @change="assessmentPeopleSel"/>-->
        <!--<el-input v-model="assessment.assessmentPeople" style="width: 205px;"/>-->
        <!--<el-input v-model="assessmentPeopleData" type="textarea" style="width: 500px;" readonly="readonly"/>
        <el-button type="text" @click="openAssessmentPeoplePage">选择</el-button>-->
      </el-form-item>
      <el-form-item>
        <el-button :disabled="isDisabled" type="primary" @click="submitForm()">发送</el-button>
        <el-button @click="goBack($route)" >取消</el-button>
      </el-form-item>
    </el-form>
    <!--获取考核对象/考核人树形信息模板-->
    <!--<template v-if="assessmentObjPageVisible">-->
    <!--<el-dialog :title="titleMap[dialogStatus]" :visible.sync="assessmentObjPageVisible" style="width: 950px;" >
      <div style="width: 100%;height: 320px;overflow: auto">
        <el-input
          v-model="filterText"
          placeholder="输入员工名字"/>
        <el-tree
          ref="rootTree"
          :data="rootData"
          :filter-node-method="filterNode"
          show-checkbox
          node-key="value"
        />
        <el-button type="primary" @click="getKeys(dialogStatus)">确定</el-button>
        <el-button @click="closeDialog" >取消</el-button>
      </div>
    </el-dialog>-->
    <!-- </template>-->
  </div>
</template>

<script>
import {
  api
} from '@/api/hr/common'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      // 新部门员工树
      deptEmployeeList: [],
      checkList: [],
      // 新部门员工树 end
      defaultMsg: '',
      filterText: '',
      // rootData: [],
      assessmentObjectData: '',
      assessmentPeopleData: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      defaultProps: {
        label: 'name',
        children: 'children'
      },
      count: 1,
      isShow: false,
      isDisabled: false,
      title: '',
      templateId: [],
      assessmentObject: '',
      assessment: {
        templateId: '',
        assessmentName: '',
        assessmentStartTime: '',
        assessmentEndTime: '',
        // assessmentObjectList: [],
        assessmentJobNumber: '',
        assessmentObjectJobNumber: '',
        assessmentObject: '',
        templateName: '',
        assessmentPeople: ''
      },
      titleMap: {
        obj: '考核对象',
        person: '考核人'
      },
      dialogStatus: '',
      templates: [],
      assessmentObjPageVisible: false,
      assessmentObjDatas: [],
      code: {
        groupCode: 'platform_type',
        moduleCode: 'springcloud-hr',
        parentGroupCode: 'assess'
      },
      assessmentPeopleArr: [],
      rules: {
        assessmentName: [{ required: true, message: '请输考核名称', trigger: 'blur' }],
        templateId: [{ required: true, message: '请选择考核模板', trigger: 'change' }],
        // assessmentTime: [{ required: true, message: '请选择考核时间', trigger: 'change' }],
        assessmentObject: [{ required: true, message: '请选择考核对象', trigger: 'change' }],
        assessmentPeople: [{ required: true, message: '请选择考核人', trigger: 'change' }]
      }
    }
  },
  watch: {
    filterText(val) {
      this.$refs.rootTree.filter(val)
    }
  },
  created() {
    this.getTemplates()
    this.getDeptEmployeeList()
  },
  methods: {
    assessmentObjectSel() {
      const selectedNodes = this.$refs['assessmentObjectRef'].selectedNodes
      this.assessment.assessmentObject = ''
      for (let i = 0; i < selectedNodes.length; i++) {
        if (!selectedNodes.flag) {
          this.assessment.assessmentObject = this.assessment.assessmentObject + selectedNodes[i].value + ','
        }
      }
      if (this.assessment.assessmentObject.length > 0) {
        this.assessment.assessmentObject = this.assessment.assessmentObject.substring(0, this.assessment.assessmentObject.length - 1)
      }
    },
    assessmentPeopleSel(val) {
      this.assessment.assessmentPeople = this.assessmentPeopleArr[this.assessmentPeopleArr.length - 1]
    },
    getDeptEmployeeList() {
      this.deptEmployeeList = [
        {
          value: 'dept1',
          label: '部门1',
          flag: true,
          children: [{
            value: 'dept2',
            label: '研发',
            flag: true,
            children: [{
              flag: false,
              value: 'NJ000001',
              label: '张三'
            }, {
              flag: false,
              value: 'NJ000007',
              label: '李四'
            }, {
              flag: false,
              value: 'NJ000006',
              label: '赵六'
            }]
          }, {
            value: 'daohang',
            label: '导航',
            flag: true,
            children: [{
              flag: false,
              value: 'cexiangdaohang',
              label: '侧向导航'
            }, {
              flag: false,
              value: 'dingbudaohang',
              label: '顶部导航'
            }]
          }]
        }, {
          value: 'ziyuan',
          label: '资源',
          flag: true,
          children: [{
            flag: true,
            value: 'axure',
            label: 'Axure Components'
          }, {
            flag: true,
            value: 'sketch',
            label: 'Sketch Templates'
          }, {
            flag: true,
            value: 'jiaohu',
            label: '组件交互文档'
          }]
        }]
      // api('hr/AssessmentManagement/ObtainDepartmentTree', {}).then(res => {
      //   if (res.data.code === '0000') {
      //     this.rootData = res.data.data
      //   } else {
      //     this.$message.error(res.data.result)
      //   }
      // })
    },
    templateIdSel(val) {
      this.assessment.templateId = val
      // locations是v-for里面的也是datas里面的值
      let obj = {}
      obj = this.templates.find((item) => {
        return item.templateId === val
      })
      this.assessment.templateName = obj.templateName
    },
    // 新增提交表单
    submitForm() {
      this.isDisabled = true
      if (this.assessment.templateId === '') {
        alert('请选择考核模板')
        this.isDisabled = false
        return false
      }
      if (new Date(this.assessment.assessmentEndTime.replace(/-/g, '\/')) < new Date()) {
        alert('失效时间必须大于当前时间,请重新选择')
        this.isDisabled = false
        return false
      }
      if (new Date(this.assessment.assessmentEndTime.replace(/-/g, '\/')) < new Date(this.assessment.assessmentStartTime.replace(/-/g, '\/'))) {
        alert('失效时间必须大于生效时间,请重新选择')
        this.isDisabled = false
        return false
      }
      this.assessment.assessmentObjectJobNumber = this.assessment.assessmentObject // 考核对象工号
      this.assessment.assessmentJobNumber = this.assessment.assessmentPeople // 考核人工号
      delete this.assessment.assessmentObject
      delete this.assessment.assessmentObjectList
      this.$refs['assessment'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          api('hr/AssessmentManagement/initiateAssess', this.assessment).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.goBack(this.$route)
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    filterNode(value, data) {
      if (!value) return true
      return data.label.indexOf(value) !== -1
    },
    isActive(route) {
      return route.path === this.$route.path
    },
    getEndtime() {},
    getStarttime() {},
    goBack(view) {
      this.$store.dispatch('delView', view).then(({ visitedViews }) => {
        if (this.isActive(view)) {
          this.$router.push('assessment-list')
        }
      })
    },
    // 获取考核模板
    getTemplates() {
      const listQuery = {
        page: 1,
        rows: 100000
      }
      api('hr/AssessmentManagement/assessmentTemplatePaginationDisplay', listQuery).then(res => {
        if (res.data.code === '0000') {
          this.templates = res.data.data.rows
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    openAssessmentPeoplePage() {
      this.dialogStatus = 'person'
      this.assessmentObjPageVisible = true
    },
    openAssessmentObjPage() {
      this.dialogStatus = 'obj'
      this.assessmentObjPageVisible = true
    },
    handleNodeClick(data) {
    },
    closeDialog() {
      this.assessmentObjPageVisible = false
    },
    getKeys(key) {
      const nodes = this.$refs.rootTree.getCheckedNodes()
      const arr = []
      let assessmentObjectArrStr = ''
      const assessmentPeopleArr = []
      for (let j = 0; j < nodes.length; j++) {
        if (nodes[j].parent !== '-1') {
          arr.push(nodes[j].value)
          if (key === 'obj') {
            assessmentObjectArrStr = assessmentObjectArrStr + nodes[j].label + ','
          } else {
            assessmentPeopleArr.push(nodes[j].label)
          }
        }
      }
      if (key === 'obj') {
        assessmentObjectArrStr = assessmentObjectArrStr.substring(0, assessmentObjectArrStr.length - 1)
        this.assessment.assessmentObject = arr.join(',')
        this.assessment.assessmentObjectList = arr
        this.assessmentObjectData = assessmentObjectArrStr
      } else {
        this.assessment.assessmentPeople = arr[0]
        this.assessmentPeopleData = assessmentPeopleArr[0]
      }
      this.assessmentObjPageVisible = false
      this.$refs.rootTree.setCheckedNodes([])
    }
  }
}
</script>

<style lang="scss">
.addassessment {
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
  .el-input--medium{
    width: 300px;
  }
  .el-form-item__content {
    flex: 1;
    // line-height: 36px;
    display: inline-block;
    padding:  15px;
    border: 1px solid #ccc;
  }
  #setheight{
    .el-form-item__content {
      line-height: 36px;
    }
  }
  .primaryList {
    margin-top: 30px;
    text-align: center;
  }
  .el-form-item__error{
    left:22px;
    top:unset;
    padding-top: unset;
  }
    .el-form-item--medium .el-form-item__content, .el-form-item--medium .el-form-item__label {
    line-height: 22px;
  }
}
</style>

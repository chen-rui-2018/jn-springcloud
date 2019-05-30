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

        <el-cascader-multi ref="assessmentObjectRef" v-model="assessment.assessmentObjectList" :data="deptEmployeeList" :show-leaf-label="true" only-last="true" style="width: 620px" @change="assessmentObjectSel"/>

      </el-form-item>
      <el-form-item label="考核人" prop="assessmentPeople" class="inline">
        <el-cascader-multi ref="assessmentPeopleRef" v-model="assessment.assessmentPeopleList" :data="deptEmployeeList" :show-leaf-label="true" only-last="true" style="width: 620px" @change="assessmentPeopleSel"/>
        <!--<el-cascader
          ref="assessmentPeopleRef"
          :options="deptEmployeeList"
          v-model="assessmentPeopleArr"
          change-on-select
          placeholder="请选择"
          clearable
          @change="assessmentPeopleSel"

        />-->

      </el-form-item>
      <el-form-item>
        <el-button :disabled="isDisabled" type="primary" @click="submitForm()">发送</el-button>
        <el-button @click="goBack($route)" >取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import {
  api, apiGet
} from '@/api/hr/common'
import UE from '@/components/ue.vue'
export default {
  components: { UE },
  data() {
    return {
      // 新部门员工树
      deptEmployeeList: [],
      // checkList: [],
      // 新部门员工树 end
      defaultMsg: '',
      filterText: '',
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
        assessmentTime: '',
        assessmentStartTime: '',
        assessmentEndTime: '',
        assessmentObjectList: [],
        assessmentJobNumber: '',
        assessmentObjectJobNumber: '',
        assessmentPeopleList: [],
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
        assessmentTime: [{ required: true, message: '请选择考核时间', trigger: 'change' }],
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
          this.assessment.assessmentObject = this.assessment.assessmentObject + selectedNodes[i].jobNumber + ','
        }
      }
      if (this.assessment.assessmentObject.length > 0) {
        this.assessment.assessmentObject = this.assessment.assessmentObject.substring(0, this.assessment.assessmentObject.length - 1)
      }
      console.log(this.assessment.assessmentObject)
    },
    assessmentPeopleSel() {
      const selectedNodes = this.$refs['assessmentPeopleRef'].selectedNodes
      this.assessment.assessmentPeople = ''
      for (let i = 0; i < selectedNodes.length; i++) {
        if (!selectedNodes.flag) {
          if (this.assessment.assessmentPeople === '') {
            this.assessment.assessmentPeople = selectedNodes[i].jobNumber
          }
        }
      }
    },
    getDeptEmployeeList() {
      // const obj = {
      //   'result': 'OK',
      //   'code': '0000',
      //   'data': '[{"children":[{"flag":true,"id":"114","jobNumber":"","label":"产业培育科","level":"2","mailbox":"","parentId":"100","value":"114"},{"flag":true,"id":"108","jobNumber":"","label":"行政审批科","level":"2","mailbox":"","parentId":"100","value":"108"},{"flag":true,"id":"101","jobNumber":"","label":"党工委","level":"2","mailbox":"","parentId":"100","value":"101"},{"flag":true,"id":"115","jobNumber":"","label":"科技合作科","level":"2","mailbox":"","parentId":"100","value":"115"},{"flag":true,"id":"109","jobNumber":"","label":"综合协调科","level":"2","mailbox":"","parentId":"100","value":"109"},{"flag":true,"id":"102","jobNumber":"","label":"管委会","level":"2","mailbox":"","parentId":"100","value":"102"},{"flag":true,"id":"116","jobNumber":"","label":"人才科","level":"2","mailbox":"","parentId":"100","value":"116"},{"flag":true,"id":"110","jobNumber":"","label":"环境管理科","level":"2","mailbox":"","parentId":"100","value":"110"},{"flag":true,"id":"103","jobNumber":"","label":"纪工委","level":"2","mailbox":"","parentId":"100","value":"103"},{"flag":true,"id":"117","jobNumber":"","label":"税源管理科","level":"2","mailbox":"","parentId":"100","value":"117"},{"flag":true,"id":"111","jobNumber":"","label":"安全生产科","level":"2","mailbox":"","parentId":"100","value":"111"},{"flag":true,"id":"104","jobNumber":"","label":"团工委","level":"2","mailbox":"","parentId":"100","value":"104"},{"flag":true,"id":"118","jobNumber":"","label":"计划财务科","level":"2","mailbox":"","parentId":"100","value":"118"},{"flag":true,"id":"112","jobNumber":"","label":"规划建设科","level":"2","mailbox":"","parentId":"100","value":"112"},{"flag":true,"id":"105","jobNumber":"","label":"工会","level":"2","mailbox":"","parentId":"100","value":"105"},{"flag":true,"id":"113","jobNumber":"","label":"产业招商科","level":"2","mailbox":"","parentId":"100","value":"113"},{"flag":true,"id":"107","jobNumber":"","label":"党政办","level":"2","mailbox":"","parentId":"100","value":"107"}],"flag":true,"id":"100","jobNumber":"","label":"开发区管委会","level":"1","mailbox":"","parentId":"1","value":"100"},{"children":[{"children":[{"flag":false,"id":"3","jobNumber":"NJ000001","label":"朱奕","level":"","mailbox":"11111@qq.com","parentId":"","value":"3"}],"flag":true,"id":"6b561892-5310-4ea8-877d-e791df462d0e","jobNumber":"","label":"集团领导","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"6b561892-5310-4ea8-877d-e791df462d0e"},{"flag":true,"id":"281f4005-0363-4528-92a3-60a730532e53","jobNumber":"","label":"行政综合部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"281f4005-0363-4528-92a3-60a730532e53"},{"children":[{"flag":false,"id":"1","jobNumber":"NJ000006","label":"超级管理员","level":"","mailbox":"232313@qq.com","parentId":"","value":"1"},{"flag":false,"id":"2","jobNumber":"NJ000007","label":"祁思远","level":"","mailbox":"12312@qq.com","parentId":"","value":"2"},{"flag":false,"id":"7b28822a-e3c5-40b4-95de-c4efb2993131","jobNumber":"NJ000079","label":"小白","level":"","mailbox":"333@qq.com","parentId":"","value":"7b28822a-e3c5-40b4-95de-c4efb2993131"},{"flag":false,"id":"c3f95a64-90fd-4b28-9e49-713ee6837b49","jobNumber":"NJ000028","label":"小白5","level":"","mailbox":"333@qq.com","parentId":"","value":"c3f95a64-90fd-4b28-9e49-713ee6837b49"}],"flag":true,"id":"a794452f-fad6-4697-afe1-e62542bd753a","jobNumber":"","label":"财务部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"a794452f-fad6-4697-afe1-e62542bd753a"},{"children":[{"flag":false,"id":"85f572c3-8774-463a-963e-1c5cdf140839","jobNumber":"NJ000027","label":"小白4","level":"","mailbox":"323@qq.com","parentId":"","value":"85f572c3-8774-463a-963e-1c5cdf140839"},{"flag":false,"id":"df5e8380-451e-4ccb-b7aa-9655720e1cdf","jobNumber":"NJ000025","label":"小白2","level":"","mailbox":"333@qq.com","parentId":"","value":"df5e8380-451e-4ccb-b7aa-9655720e1cdf"}],"flag":true,"id":"c2be95f8-50de-4357-8b47-cd0c4dc227a8","jobNumber":"","label":"成本控制部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"c2be95f8-50de-4357-8b47-cd0c4dc227a8"},{"flag":true,"id":"af3ddfed-3b2b-413e-8b1b-bfe4cce81412","jobNumber":"","label":"招商运营部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"af3ddfed-3b2b-413e-8b1b-bfe4cce81412"},{"flag":true,"id":"c1f0733c-cfc4-4282-a150-f5baa986acc9","jobNumber":"","label":"资产管理部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"c1f0733c-cfc4-4282-a150-f5baa986acc9"},{"flag":true,"id":"2e2ca5b1-9293-44bb-a061-12085a348d17","jobNumber":"","label":"投资管理部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"2e2ca5b1-9293-44bb-a061-12085a348d17"},{"flag":true,"id":"7f73787e-7cea-4b47-991d-a5a67465f272","jobNumber":"","label":"规划建设部","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"7f73787e-7cea-4b47-991d-a5a67465f272"},{"flag":true,"id":"43d131a5-c6c5-451a-bf8c-d7a94318d6e7","jobNumber":"","label":"紫云建设公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"43d131a5-c6c5-451a-bf8c-d7a94318d6e7"},{"flag":true,"id":"3cecf081-2b6c-4c41-951c-17ed297f54f8","jobNumber":"","label":"永智建设公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"3cecf081-2b6c-4c41-951c-17ed297f54f8"},{"flag":true,"id":"ffbf34ca-5912-4905-a92e-9dfb73787f41","jobNumber":"","label":"投发公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"ffbf34ca-5912-4905-a92e-9dfb73787f41"},{"flag":true,"id":"afe79842-f83c-4147-adf9-bc7496d2e829","jobNumber":"","label":"担保公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"afe79842-f83c-4147-adf9-bc7496d2e829"},{"flag":true,"id":"ffbf34ca-5912-4905-a92e-9dfb73787f40","jobNumber":"","label":"创益服务公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"ffbf34ca-5912-4905-a92e-9dfb73787f40"},{"flag":true,"id":"77b6ab56-8347-4fe2-a070-1016d55e3f29","jobNumber":"","label":"创业公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"77b6ab56-8347-4fe2-a070-1016d55e3f29"},{"flag":true,"id":"f87af79a-27de-489a-b1a4-570f66bf0deb","jobNumber":"","label":"物业公司","level":"2","mailbox":"","parentId":"01ce604c-64ac-48db-a278-59c0e3ae94ad","value":"f87af79a-27de-489a-b1a4-570f66bf0deb"}],"flag":true,"id":"01ce604c-64ac-48db-a278-59c0e3ae94ad","jobNumber":"","label":"科创集团","level":"1","mailbox":"","parentId":"1","value":"01ce604c-64ac-48db-a278-59c0e3ae94ad"}]'
      // }
      // const data = obj.data
      // this.deptEmployeeList = JSON.parse(data)
      apiGet('hr/employeeBasicInfo/selectDepartEmployee', {}).then(res => {
        if (res.data.code === '0000') {
          this.deptEmployeeList = JSON.parse(res.data.data)
        } else {
          this.$message.error(res.data.result)
        }
      })
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
    getEndtime() {
      this.assessment.assessmentTime = this.assessment.assessmentStartTime + '-' + this.assessment.assessmentEndTime
    },
    getStarttime() {
      this.assessment.assessmentTime = this.assessment.assessmentStartTime + '-' + this.assessment.assessmentEndTime
    },
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

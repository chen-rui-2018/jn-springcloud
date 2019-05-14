<template>
<!--  根据填报的是普通模板还是科技园模板渲染不同组件-->
  <component :modelId="modelId" :type="type" :formTime="formTime" v-bind:is="componentType"></component>
</template>

<script>
  import dataReportEntrance from './dataReportEntrance'
  import sciencePartDataReportEntrance from './sciencePartDataReportEntrance'
 export default {
   name: "dataReportCommonEntrance",
   components: {
     dataReportEntrance,
     sciencePartDataReportEntrance
   },
   data() {
     return {
       modelId: '',
       formTime: '',
       componentType: null,
       type: ''
     }
   },
   created() {
     this.init()
   },
   methods: {
     init () {
       this.type = this.$route.query.type
       this.getData()
         .catch(res => {
           console.dir(res)
         })
     },
     getData() {
       return new Promise((resolve, reject) => {
         const _this = this
         const type = this.$route.query.type
         let url
         if (type === 'form') {
           url = 'enterpriseGetFormStruct'
         } else if(type === 'formed'){
           url = 'enterpriseGetCompanyFormedStruct'
         }
         this.api.get({
           url: url,
           data: {
             fileId: _this.$route.query.fileId
           },
           callback(res) {
             if (res.code === "0000") {
               const data = res.data
                _this.modelId = data.modelId
               _this.formTime = data.taskInfo.formTime
               if (data.tabs && data.tabs.length > 0 && data.tabs[0]) {
                 const type = data.tabs[0].tabCreateType
                 // 0是普通模板，1是科技园模板
                 if (type === '0') {
                   _this.componentType = 'dataReportEntrance'
                 } else {
                   _this.componentType = 'sciencePartDataReportEntrance'
                 }
               }
               resolve()
             } else {
               _this.$message.error(res.result)
               reject()
             }
           }
         })
       })
     }
   }
 }
</script>

<style scoped>

</style>

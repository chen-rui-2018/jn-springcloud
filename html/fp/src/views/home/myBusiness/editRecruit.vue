<template>
  <div class="editProduct" v-loading="loading">
    <div class="ordinary_title">
      <div class="font16">编辑招聘</div>
      <div @click="goBack">返回</div>
    </div>
    <div class="ordinary_content">
       <el-form :model="jobForm" :rules="rules" ref="jobForm" label-width="120px" class="postJobInfo">
  <el-form-item label="招聘岗位:" prop="post">
    <el-input v-model="jobForm.post"></el-input>
  </el-form-item>
  <el-form-item label="薪资待遇:" prop="salary">
    <el-select v-model="jobForm.salary" placeholder="请选择薪资待遇">
    <el-option
      v-for="item in salaryOptions"
      :key="item.codeValue"
      :label="item.codeName"
      :value="item.codeValue">
    </el-option>
  </el-select>
  </el-form-item>
  <el-form-item label="招聘类型:" prop="type">
    <el-select v-model="jobForm.type" placeholder="请选择类型">
       <el-option
      v-for="item in typeOptions"
      :key="item.codeValue"
      :label="item.codeName"
      :value="item.codeValue">
    </el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="招聘人数(名):" prop="num">
    <el-input v-model="jobForm.num"></el-input>
  </el-form-item>
  <el-form-item label="招聘详情:" prop="details" class="ue">
     <div class="editor-container">
            <UE ref="ue" :default-msg="defaultMsg" :config="config" />
          </div>
    <!-- <el-input type="textarea" v-model="jobForm.details"  placeholder="宣传详情宣传详情"></el-input> -->
  </el-form-item>
 <div class="business_footer" @click="submitForm('jobForm')">
        保存修改
  </div>
</el-form>
    </div>
  </div>
</template>
<script>
import UE from '@/components/ue.vue'
export default {
   components: { UE },
  data() {
    return {
      loading:false,
       defaultMsg: '',
      config: {
        initialFrameWidth: '100%',
        initialFrameHeight: 300
      },
      typeOptions:[],
      salaryOptions:[],
        searchData:'',
        jobForm: {
            id:'',
          details: '',
          num: '',
          post: '',
          salary:'',
          type: '',
        },
        rules: {
          num: [
            { required: true, message: '请输入招聘人数', trigger: 'blur' }
          ],
          post: [
            { required: true, message: '请输入招聘岗位', trigger: 'blur' }
          ],
          salary: [
            { required: true, message: '请选择薪资待遇', trigger: 'change' }
          ],
          type: [
            {  required: true, message: '请选择招聘类型', trigger: 'change' }
          ],
          // details: [
          //   { required: true, message: '请填写招聘详情', trigger: 'blur' }
          // ]
        }
    }
  },
  mounted(){
    this.getInvite()
    this.getCompensation()
    this.initList()
  },
  methods: {
     goBack() {
      this.$router.push({ name: "recruitmentManagement" });
    },
    getInvite(){
     this.api.get({
                  url:'getInviteType',
                 data:{groupId:'recruitType'},
                 callback:(res=>{
                   this.typeOptions=res.data
                  })
              })
    },
    getCompensation(){
this.api.get({
                  url:'getCompensation',
                 data:{groupId:'recruitSalary'},
                 callback:(res=>{
                   this.salaryOptions=res.data
                  })
              })
    },
    goputaway(){
      this.$router.push({name:'productPutaway'})
    },
     submitForm(jobForm) {
        this.$refs[jobForm].validate((valid) => {
          if (valid) {

              this.jobForm.details = this.$refs.ue.getUEContent()
          if(!this.jobForm.details ){
            this.$message.error('请填写招聘详情');
            return
          }
            this.jobForm.num=Number(this.jobForm.num)
            this.loading=true
                this.api.post({
                  url:'editRecruitDetails',
                 data:this.jobForm,
                 callback:(res=>{
                   this.loading=false
                   if(res.code==='0000'){
                       this.$message({
                message: '编辑成功',
                type: 'success'
              })
               this.$router.push({name:'recruitmentManagement'})
                   }else{
                        this.$message.error('编辑失败'+res.result)
                   }
                  })
              })

          }
        });
      },
      initList(){
        //   let query=this.$route.query.id
          this.jobForm.id=this.$route.query.id
          this.api.get({
                  url:'getRecruitDetails',
                 data:{recruitId : this.jobForm.id},
                 callback:(res=>{
                     console.log(res)
                this.jobForm.post=res.data.post
                this.jobForm.num=res.data.num
                this.defaultMsg=res.data.details
                // this.jobForm.details=res.data.details
                this.jobForm.salary=res.data.salary
                this.jobForm.type=res.data.type
                  })
              })
      }
  }
}
</script>

<style lang="scss">
  .editProduct{
    width: 100%;

    // .ordinary_title{
    //   background-color: #fff;

    //   padding:24px 28px;
    //   border-radius: 5px;
    // }
     .ordinary_title {
    background-color: #fff;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 17px;
    // font-size: 13px;
    border-radius: 5px;
    div:nth-child(2) {
      width: 50px;
      height: 26px;
      background: rgba(236, 252, 242, 1);
      border: 1px solid rgba(65, 215, 135, 1);
      border-radius: 4px;
      text-align: center;
      line-height: 26px;
      font-size: 12px;
      color: #00a041;
      cursor: pointer;
    }
  }
    .ordinary_content{
        margin-top:14px;
        background: #fff;
        padding:36px 0px;
        .postJobInfo{
            width: 50%;
            margin: 0 auto;

            .el-form-item__content,.el-select{
                width: 266px;
            }
             .el-textarea__inner{
                 width: 348px;
                min-height: 100px !important;
                background: #fff;
            }
        }
         .business_footer {
    margin: 0 auto;
    margin-top: 58px;
    border-radius: 4px;
    text-align: center;
    cursor: pointer;
    height: 29px;
    line-height: 29px;
    width: 90px;
    color: #41d787;
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    margin-bottom: 17px;
  }
    }
     .ue{
        .el-form-item__content,
      .el-select {
        width: 100%!important;
      }
      .el-form-item__content{
        line-height: 22px;
      }
      .edui-default .edui-editor-bottomContainer{
        display: none;
      }
      }
  }
</style>

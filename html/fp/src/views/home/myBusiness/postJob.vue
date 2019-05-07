<template>
  <div class="postJobProduct">
    <div class="ordinary_title">
      <div>发布招聘</div>
    </div>
    <div class="ordinary_content">
      <el-form
        :model="jobForm"
        :rules="rules"
        ref="jobForm"
        label-width="120px"
        class="postJobInfo"
      >
        <el-form-item
          label="招聘岗位:"
          prop="post"
        >
          <el-input v-model="jobForm.post"></el-input>
        </el-form-item>
        <el-form-item
          label="薪资待遇:"
          prop="salary"
        >
          <el-select
            v-model="jobForm.salary"
            placeholder="请选择薪资待遇"
          >
            <el-option
              v-for="item in salaryOptions"
              :key="item.codeValue"
              :label="item.codeName"
              :value="item.codeValue"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="招聘类型:"
          prop="type"
        >
          <el-select
            v-model="jobForm.type"
            placeholder="请选择类型"
          >
            <el-option
              v-for="item in typeOptions"
              :key="item.codeValue"
              :label="item.codeName"
              :value="item.codeValue"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item
          label="招聘人数(名):"
          prop="num"
        >
          <el-input v-model="jobForm.num"></el-input>
        </el-form-item>
        <el-form-item
          label="招聘详情:"
          prop="details"
        >
          <el-input
            type="textarea"
            v-model="jobForm.details"
            placeholder="宣传详情宣传详情"
          ></el-input>
        </el-form-item>
        <div
          class="business_footer"
          @click="submitForm('jobForm')"
        >
          发布招聘
        </div>
      </el-form>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      typeOptions: [],
      salaryOptions: [],
      searchData: "",
      jobForm: {
        details: "",
        num: "",
        post: "",
        recruitNo: "",
        salary: "",
        type: ""
      },
      rules: {
        num: [{ required: true, message: "请输入招聘人数", trigger: "blur" }],
        post: [{ required: true, message: "请输入招聘岗位", trigger: "blur" }],
        salary: [
          { required: true, message: "请选择薪资待遇", trigger: "change" }
        ],
        type: [
          { required: true, message: "请选择招聘类型", trigger: "change" }
        ],
        details: [
          { required: true, message: "请填写招聘详情", trigger: "blur" }
        ]
      }
    };
  },
  mounted() {
    this.getInvite();
    this.getCompensation();
  },
  methods: {
    getInvite() {
      this.api.get({
        url: "getInviteType",
        data: { groupId: "recruitType" },
        callback: res => {
          this.typeOptions = res.data;
        }
      });
    },
    getCompensation() {
      this.api.get({
        url: "getCompensation",
        data: { groupId: "recruitSalary" },
        callback: res => {
          this.salaryOptions = res.data;
        }
      });
    },
    submitForm(jobForm) {
      this.$refs[jobForm].validate(valid => {
        if (valid) {
          this.jobForm.num = Number(this.jobForm.num);
          this.api.post({
            url: "postJob",
            data: this.jobForm,
            callback: res => {
              console.log(res);
              if (res.code === "0000") {
                this.$message({
                  message: "发布成功",
                  type: "success"
                });
                this.$router.push({ name: "recruitmentManagement" });
              } else {
                this.$message.error("发布失败" + res.result);
              }
            }
          });
        } else {
          return false;
        }
      });
    }
  }
};
</script>

<style lang="scss">
.postJobProduct {
  width: 100%;
  .ordinary_title {
    background-color: #fff;

    padding: 24px 28px;
    font-size: 13px;
    border-radius: 5px;
  }
  .ordinary_content {
    margin-top: 14px;
    background: #fff;
    padding: 36px 0px;
    .postJobInfo {
      width: 50%;
      margin: 0 auto;

      .el-form-item__content,
      .el-select {
        width: 266px;
      }
      .el-textarea__inner {
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
}
</style>

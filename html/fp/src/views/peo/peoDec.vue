<template>
    <div class="peoDec w">
        <div class="peoDecNav">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
                <el-breadcrumb-item>
                    <a href="/">申报中心</a>
                </el-breadcrumb-item>
                <el-breadcrumb-item class="mainColor">人才申报</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="peoDecNav">
            <el-card class="box-card">
                <div class="peoDecNavHead clearfix">
                    <div class="headLeft fl">
                        <h3>人才申报
                            <span>(*号未必填项)</span>
                        </h3>
                    </div>
                    <div class="headRight fr">
                        <el-button type="success" plain>流程进度</el-button>
                        <el-button type="success" plain>日志</el-button>
                    </div>
                </div>
                <div class="peoDecNavContent">
                    <el-container>
                        <el-aside width="200px">
                            <ul>
                                <li>人才意向申报</li>
                                <li>区级计划书辅导</li>
                                <li>完善申报资料</li>
                                <li>区级答辩辅导</li>
                                <li>注册落户</li>
                                <li>获取扶持政策</li>
                                <li>市级计划书辅导</li>
                                <li>市级答辩辅导</li>
                                <li>流程完结</li>
                            </ul>
                        </el-aside>
                        <el-main class="pr">
                            <div class="uploadLogo">
                                <el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/" :show-file-list="false">
                                    <img v-if="imageUrl" :src="imageUrl" class="avatar">
                                    <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                </el-upload>
                            </div>
                            <div class="text">请上传企业LOGO，支持png、jpg<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格式，大小请不超过1M</div>
                            <el-form :model="dataForm" :rules="rules" ref="dataForm" label-width="140px" class="demo-ruleForm">
                                <el-form-item prop="name">
                                    <el-radio v-model="radio" label="1">企业</el-radio>
                                    <el-radio v-model="radio" label="2">团队</el-radio>
                                </el-form-item>
                                <el-form-item label="企业名称" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="产业领域" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="统一社会信用代码" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="企业法人" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="企业简介" prop="name">
                                    <el-input type="textarea" style="width: 680px;" :rows="4" placeholder="请填写机构简介" v-model="textarea">
                                    </el-input>
                                </el-form-item>
                                <el-form-item label="公司地址" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="联系人" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="联系人电话" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="联系人邮箱" prop="name">
                                    <el-input style="width: 320px;"></el-input>
                                </el-form-item>
                                <el-form-item label="营业执照：" prop="name">
                                    <span>请填写营业执照信息，附件请上传证书照片，单个文件不超过1M</span>
                                    <div class="licenseTit mainColor">
                                        <span>证书名称</span>
                                        <span>颁发时间</span>
                                        <span>主管部门</span>
                                        <span>上传附件</span>
                                    </div>
                                    <div class="licenseCon">
                                        <span>企业营业执照</span>
                                        <el-date-picker v-model="value1" type="date" placeholder="请选择时间" style="margin-left: 24px; margin-right: 30px;">
                                        </el-date-picker>
                                        <!-- <el-input style="width: 200px;" placeholder="请输入主管部门，最多20字"></el-input> -->
                                        <input type="text" placeholder="请输入主管部门，最多20字">
                                        <div class="liceConImg">
                                            <el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/" :show-file-list="false">
                                                <img v-if="imageUrl" class="avatar">
                                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                            </el-upload>
                                        </div>
                                        <el-button type="text" style="color:#00a042;margin-left:30px">删除</el-button>
                                    </div>
                                </el-form-item>
                                <el-form-item label="其他资质/荣誉：">
                                    <span>附件请上传相关资质荣誉证书照片，单个文件不超过1M</span>
                                    <el-button type="text" style="color:#00a042;float:right">重置</el-button>
                                    <div class="honorTit mainColor">
                                        <span>资质荣誉名称</span>
                                        <span>特色标签</span>
                                        <span>颁发时间</span>
                                        <span>主管部门</span>
                                        <span>上传附件</span>
                                    </div>
                                    <div class="honorCon">
                                        <span>企业营业执照</span>
                                        <el-date-picker v-model="value1" type="date" placeholder="请选择时间" style="margin-left: 24px; margin-right: 30px;">
                                        </el-date-picker>
                                        <!-- <el-input style="width: 200px;" placeholder="请输入主管部门，最多20字"></el-input> -->
                                        <input type="text" placeholder="请输入主管部门，最多20字">
                                        <div class="liceConImg">
                                            <el-upload class="avatar-uploader" action="https://jsonplaceholder.typicode.com/posts/" :show-file-list="false">
                                                <img v-if="imageUrl" class="avatar">
                                                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                                            </el-upload>
                                        </div>
                                        <el-button type="text" style="color:#00a042;margin-left:30px">删除</el-button>
                                    </div>
                                </el-form-item>
                                <el-form-item>
                                    <!-- <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button> -->
                                    <el-button type="success">提交</el-button>
                                </el-form-item>
                            </el-form>
                        </el-main>
                    </el-container>
                </div>
            </el-card>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      radio: "1",
      textarea: "",
      imageUrl: "",
      dataForm: {},
      rules: {
        name: [{ required: true, message: "请输入企业名称", trigger: "blur" }]
      }
    };
  }
};
</script>
<style lang="scss" scoped>
.peoDec {
  margin-bottom: 150px;
  .peoDecNav {
    margin: 10px 0;
    .peoDecNavHead {
      padding: 10px 20px 10px;
      border-bottom: 1px solid #ccc;
    }
    .peoDecNavContent {
      margin-top: 30px;
      padding: 0 30px;
      .el-aside {
        // background-color: #d3dce6;
        color: #333;
        font-weight: bold;
        // text-align: center;
        // line-height: 200px;
        > ul {
          > li {
            padding: 20px 0 20px 30px;
          }
        }
      }

      .el-main {
        // background-color: #e9eef3;
        padding: 0;
        padding-right: 70px;
        color: #333;
        .text {
          position: absolute;
          top: 232px;
          right: 68px;
        }
        .uploadLogo {
          height: 163px;
          width: 163px;
          position: absolute;
          top: 62px;
          right: 74px;
          .avatar-uploader .el-upload {
            border: 1px dashed #d9d9d9;
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
          }
          .avatar-uploader .el-upload:hover {
            border-color: #409eff;
          }
          .avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            height: 163px;
            width: 163px;
            line-height: 163px;
            text-align: center;
            border: 1px dotted #ccc;
          }
          .avatar {
            height: 163px;
            width: 163px;
            display: block;
          }
        }
        .licenseTit {
          border: 1px solid #00a042;
          background-color: #ebfdf1;
          margin-left: -83px;
          padding: 0 50px 0 30px;
          width: 100%;
          > span {
            margin-right: 124px;
          }
          > span:nth-child(3) {
            margin-left: 35px;
          }
        }
        .licenseCon {
          margin-top: 10px;
          margin-left: -68px;
          > input {
            height: 32px;
            border: 1px solid #00a042;
            width: 200px;
            border-radius: 5px;
          }
          .liceConImg {
            width: 50px;
            height: 50px;
            display: inline-block;
            border: 1px dotted #ccc;
            margin-left: 35px;
            .avatar-uploader .el-upload {
              border: 1px dashed #d9d9d9;
              border-radius: 6px;
              cursor: pointer;
              position: relative;
              overflow: hidden;
            }
            .avatar-uploader .el-upload:hover {
              border-color: #409eff;
            }
            .avatar-uploader-icon {
              font-size: 28px;
              color: #8c939d;
              width: 50px;
              height: 50px;
              line-height: 50px;
              text-align: center;
            }
            .avatar {
              width: 50px;
              height: 50px;
              display: block;
            }
          }
        }
        .honorTit {
          border: 1px solid #00a042;
          background-color: #ebfdf1;
          margin-left: -83px;
          padding: 0 50px 0 30px;
          width: 100%;
          > span {
            margin-right: 72px;
          }
          > span:nth-child(2) {
            margin-left:-20px;
          }
          > span:nth-child(3) {
            margin-right: 122px;
          }
        }
        .honorCon {
          margin-top: 10px;
          margin-left: -68px;
          > input {
            height: 32px;
            border: 1px solid #00a042;
            width: 200px;
            border-radius: 5px;
          }
          .liceConImg {
            width: 50px;
            height: 50px;
            display: inline-block;
            border: 1px dotted #ccc;
            margin-left: 35px;
            .avatar-uploader .el-upload {
              border: 1px dashed #d9d9d9;
              border-radius: 6px;
              cursor: pointer;
              position: relative;
              overflow: hidden;
            }
            .avatar-uploader .el-upload:hover {
              border-color: #409eff;
            }
            .avatar-uploader-icon {
              font-size: 28px;
              color: #8c939d;
              width: 50px;
              height: 50px;
              line-height: 50px;
              text-align: center;
            }
            .avatar {
              width: 50px;
              height: 50px;
              display: block;
            }
          }
        }
      }
    }
  }
}
</style>

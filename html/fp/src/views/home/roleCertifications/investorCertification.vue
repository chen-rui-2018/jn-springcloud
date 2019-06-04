<template>
  <div class="investorCertification">
    <div class="investorCertification-header font16">
      <div>投资人认证</div>
    </div>
    <el-main style="padding:0 25px;text-align:left;background:#fff;">
      <div class="investorCertification-content">
        <div class="basicStyle">基本信息</div>
        <div class="basicInfo pr">
          <div class="setdistance uploadImgItem">
            <span class="textRight mg">照片：</span>
            <el-upload class="avatar-uploader avatar-img" :show-file-list="false" :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'" :headers="headers" :before-upload="beforeAvaUpload" style="display:inline-block">
              <img v-if="investorForm.avatar" :src="investorForm.avatar" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <div class="textImg">只支持JPG格式，大小不要超过500k<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;建议使用一寸证件照70*100像素</div>
          </div>
          <el-form :rules="rules" :model="investorForm" label-width="100px" ref="investorForm">
            <el-form-item label="姓名:" prop="investorName" class="maxWidth">
              <label slot="label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
              <el-input v-model="investorForm.investorName" placeholder="请输入姓名" clearable></el-input>
            </el-form-item>
            <el-form-item label="性别:" prop="sex">
              <label slot="label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label>
              <el-radio-group v-model="investorForm.sex">
                <el-radio label="1">男</el-radio>
                <el-radio label="0">女</el-radio>
              </el-radio-group>

            </el-form-item>

            <el-form-item label="所属单位:">
              <el-select v-model="investorForm.orgId" placeholder="请选择所属单位">
                <el-option v-for="item in orgOptions" :key="item.orgId" :label="item.orgName" :value="item.orgId">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="职务:" prop="position" class="maxWidth">
              <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:</label>
              <el-input v-model="investorForm.position" placeholder="请输入职务" clearable></el-input>
            </el-form-item>

            <el-form-item label="常住地:" class="address" prop="domicile">
              <label slot="label">常&nbsp;&nbsp;住&nbsp;&nbsp;地:</label>
              <el-select v-model="investorForm.addressProvince" @change="choseProvince" placeholder="省级地区">
                <el-option v-for="item in province" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
              <el-select v-model="investorForm.addressCity" @change="choseCity" placeholder="市级地区">
                <el-option v-for="item in shi1" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
              <el-select v-model="investorForm.addressArea" @change="choseBlock" placeholder="区级地区">
                <el-option v-for="item in qu1" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>
            <el-form-item label="手机号码:" prop="phone" class="maxWidth">
              <el-input v-model="investorForm.phone" placeholder="请输入手机号码" maxlength='11' clearable></el-input>
            </el-form-item>
            <el-form-item label="邮箱:" prop="email" class="maxWidth">
              <label slot="label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label>

              <el-input v-model="investorForm.email" placeholder="请填写邮箱" clearable></el-input>
            </el-form-item>

            <el-form-item label="个人简介:" prop="personalProfile" class="myPersonalProfile">
              <el-input v-model="investorForm.personalProfile" type="textarea" autosize placeholder="请输入个人简介" clearable></el-input>
            </el-form-item>
            <el-form-item label="主投领域:" prop="investorMainAreaList" class="investorMainAreaList">
              <el-select v-model="investorForm.investorMainAreaList" multiple value-key='mainCode' placeholder="请选择">
                <el-option v-for="(val,index) in investorMainAreaOptions" :key="index" :label="val.mainName" :value="val">
                </el-option>
              </el-select>
              <!-- <div class="checked">
                <el-checkbox-group v-model="investorForm.investorList">
                  <el-checkbox v-for="item in investorMainAreaOptions" :label="item.mainCode" :key="item.mainCode">{{item.mainName}}</el-checkbox>
                </el-checkbox-group>
              </div> -->
            </el-form-item>
            <el-form-item label="主投轮次:" prop="investorMainRoundList" class="investorMainAreaList">
              <el-select v-model="investorForm.investorMainRoundList" value-key='mainRoundCode' multiple placeholder="请选择" >
                <el-option v-for="item in investorMainRoundOptions" :key="item.mainRoundCode" :label="item.mainRoundName"
                  :value="item">
                </el-option>
              </el-select>
              <!-- <div class="checked">
                <el-checkbox-group v-model="investorForm.investorMainRoundList">
                  <el-checkbox v-for="item in investorMainRoundOptions" :label="item.mainRoundCode"  :key="item.mainRoundCode">{{item.mainRoundName}}</el-checkbox>
                </el-checkbox-group>
              </div> -->
            </el-form-item>
            <el-form-item label="投融资经历:" prop="invesFinanExper" class="myPersonalProfile">
              <el-input v-model="investorForm.invesFinanExper" type="textarea" autosize placeholder="请填写投融资经历"
                clearable></el-input>
            </el-form-item>
          </el-form>
        </div>
        <div class="basicStyle">工作经历 <span class="cancel" @click="cancelWorkList" v-if="isShowWorkList">取&nbsp;消</span><span
            @click="addWorkList('workForm')"> <i class="el-icon-plus"></i>&nbsp;{{workText}}</span> </div>
        <div class="marBtn" v-if="!isShowWorkList">
          <el-table :data="workList" style="width: 99%">
            <el-table-column prop="startTime" align="center" label="开始时间">
            </el-table-column>
            <el-table-column prop="endTime" align="center" label="结束时间">
            </el-table-column>
            <el-table-column prop="companyName" label="单位名称" align="center">
            </el-table-column>
            <el-table-column prop="position" align="center" label="职务">
            </el-table-column>

            <el-table-column align="center" label="操作">
              <template slot-scope="scope">
                <span class="mainColor smallSize cur mr" @click="updataWorkList(scope.row)">编辑</span>
                <span class="redColor smallSize cur" @click="deleteWorkList(scope.row)">删除</span>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <el-form class="editForm" v-if="isShowWorkList" :rules="workFormRules" :model="workForm" label-width="100px"
          ref="workForm">
          <el-form-item label="开始时间:" prop="startTime">
            <el-date-picker v-model="workForm.startTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间:" prop="endTime">
            <el-date-picker v-model="workForm.endTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="单位名称:" prop="companyName" class="maxWidth">
            <el-input v-model="workForm.companyName" placeholder="请输入单位名称"  clearable></el-input>
          </el-form-item>
          <el-form-item label="职务:" prop="position" class="maxWidth">
            <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:</label>
            <el-input v-model="workForm.position" placeholder="请输入职务" clearable></el-input>
          </el-form-item>

        </el-form>

        <div class="basicStyle">教育经历 <span class="cancel" @click="cancelEducationList" v-if="isShowEducationList">取&nbsp;消</span><span
            @click="addEducationList('educationForm')"> <i class="el-icon-plus"></i>&nbsp;{{educationText}}</span>
        </div>
        <div class="marBtn" v-if="!isShowEducationList">
          <el-table :data="educationList" style="width: 99%">
            <el-table-column prop="startTime" align="center" label="开始时间">
            </el-table-column>
            <el-table-column prop="endTime" align="center" label="结束时间">
            </el-table-column>
            <el-table-column prop="schoolName" label="学校名称" align="center">
            </el-table-column>
            <el-table-column prop="professionTitle" align="center" label="专业名称">
            </el-table-column>

            <el-table-column align="center" label="操作">
              <template slot-scope="scope">
                <span class="mainColor smallSize cur mr" @click="updataEducationList(scope.row)">编辑</span>
                <span class="redColor smallSize cur" @click="deleteEducationList(scope.row)">删除</span>
              </template>
            </el-table-column>
          </el-table>
        </div>
        <el-form class="editForm" v-if="isShowEducationList" :rules="educationFormRules" :model="educationForm"
          label-width="100px" ref="educationForm">
          <el-form-item label="开始时间:" prop="startTime">
            <el-date-picker v-model="educationForm.startTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间:" prop="endTime">
            <el-date-picker v-model="educationForm.endTime" type="month" value-format="yyyyMM" placeholder="请选择时间">
            </el-date-picker>
          </el-form-item>
          <el-form-item label="学校名称:" prop="schoolName" class="maxWidth">
            <el-input v-model="educationForm.schoolName" placeholder="请输入学校名称" clearable></el-input>
            <!-- <span>{{workingYears}}年</span> -->
          </el-form-item>
          <el-form-item label="专业名称:" prop="professionTitle" class="maxWidth">
            <el-input v-model="educationForm.professionTitle" placeholder="请填写专业名称" clearable></el-input>
          </el-form-item>

        </el-form>
      </div>
      <div v-show="submitBtn" class="footer ct">
        <el-button size="mini" class="mainColor accept" :disabled='disabled' @click="submit('investorForm')">提交</el-button>
        <!-- <el-button size="mini" type="success">返回</el-button> -->
      </div>
    </el-main>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
      var checkPhone = (rule, value, callback) => {
        if (!value) {
          return callback(new Error('手机号不能为空'));
        } else {
          const reg = /^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\d{8}$/
          if (reg.test(value)) {
            callback();
          } else {
            return callback(new Error('请输入正确的手机号'));
          }
        }
      }
    return {
      baseUrl:this.api.host,
      submitBtn:true,
      disabled: false,
      orgOptions: [],
      educationList: [],
      workList: [],
      delWorkList: [],
      educationForm: {
        professionTitle: "",
        endTime: "",
        schoolName: "",
        startTime: "",
        id: 0
      },
      workForm: {
        id: 0,
        companyName: "",
        endTime: "",
        position: "",
        startTime: ""
      },
      isShowWorkList: false,
      isShowEducationList: false,
      educationText: "添加教育经历",
      workText: "添加工作经历",
      investorForm: {
        phone: "",
        orgName: "",
        orgId: "",
        personalProfile: "",
        position: "",
        sex: '1',
        investorName: "",
        invesFinanExper: "",
        avatar: "",
        addressProvince: "",
        addressCity: "",
        addressArea: "",
        email: "",
        investorMainAreaList: [],
        // investorList: [],
        investorMainRoundList: [],
        investorEducationExperienceParamList: [],
        investorWorkExperienceParamList: []
      },
      investorMainAreaOptions: [],
      investorMainRoundOptions: [],
      mapJson: "../static/json/map.json",
      province: "",
      sheng: "",
      shi: "",
      shi1: [],
      qu: "",
      qu1: [],
      city: "",
      block: "",
      // avarUrl: "",
      headers: {
        token: sessionStorage.token
      },
      rules: {
        investorMainRoundList: [
          { required: true, message: "请选择主投轮次", trigger: "change" }
        ],
        investorMainAreaList: [
          { required: true, message: "请选择主投领域", trigger: "change" }
        ],
        investorName: [
          { required: true, message: "请输入姓名", trigger: "blur" }
        ],
        email: [
          { required: true, message: "请选择邮箱", trigger: "blur" },
          {
            type: "email",
            message: "请输入正确的邮箱地址",
            trigger: ["blur", "change"]
          }
        ],
        personalProfile: [
          { required: true, message: "请填写个人简介", trigger: "blur" }
        ],
        phone: [{required: true,validator: checkPhone, trigger: 'blur'}],
        position: [{ required: true, message: "请输入职务", trigger: "blur" }],
        sex: [{ required: true, message: "请选择性别", trigger: "change" }],
        invesFinanExper: [
          { required: true, message: "请填写投融资经历", trigger: "blur" }
        ],
        orgName: [
          { required: true, message: "请选择所属单位", trigger: "change" }
        ]
        // domicile: [
        //   { required: true, message: "请选择常住地", trigger: "change" }
        // ]
      },
      workFormRules: {
        companyName: [
          { required: true, message: "请填写单位名称", trigger: "blur" }
        ],
        position: [
          { required: true, message: "请填写公司职务", trigger: "blur" }
        ],
        endTime: [
          { required: true, message: "请选择结束时间", trigger: "change" }
        ],
        startTime: [
          { required: true, message: "请选择开始时间", trigger: "change" }
        ]
      },
      educationFormRules: {
        schoolName: [
          { required: true, message: "请填写学校名称", trigger: "blur" }
        ],
        professionTitle: [
          { required: true, message: "请填写专业名称", trigger: "blur" }
        ],
        endTime: [
          { required: true, message: "请选择结束时间", trigger: "change" }
        ],
        startTime: [
          { required: true, message: "请选择开始时间", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getTagCodeList();
    this.getCityData();
    this.getInvestorMainRound();
    this.getAffiliationUnit();
  },
  methods: {
    // checkList(val){
    //  console.log(val)
    //  this.investorMainRoundOptions.forEach(item=>{
    //  })
    // },
    // changeFun(val) {

    //   // this.multipleSelection = val;
    //   this.investorForm.investorMainRoundList=val
    // },
    // 提交数据
    submit(investorForm) {
      this.$refs[investorForm].validate(valid => {
        if (valid) {
          // if (!this.investorForm.avatar) {
          //   this.$message.error("请选择照片后在提交");
          //   return;
          // }
          if (!this.investorForm.addressProvince) {
            this.$message.error("请选择常住省份");
          } else if (!this.investorForm.addressCity) {
            this.$message.error("请选择常住市");
          } else if (!this.investorForm.addressArea) {
            this.$message.error("请选择常住区");
          }
          this.disabled = true;
          this.investorForm.investorWorkExperienceParamList = this.workList;
          this.investorForm.investorEducationExperienceParamList = this.educationList;
          console.log(this.investorForm);
          this.api.post({
            url: "addInvestorInfo",
            data: this.investorForm,
            callback: res => {
              if (res.code == "0000") {
                this.$message({
                  message: "认证成功",
                  type: "success"
                });
           this.$router.push({
        path: "/home"
      });
                this.disabled = false;
              } else {
                this.$message.error(res.result);
                this.disabled = false;
              }
            }
          });
        } else {
          return false;
        }
      });
    },
    // 删除工作经历
    deleteWorkList(row) {
      var index = 1;
      this.delWorkList = [];
      this.workList.forEach(val => {
        if (row.id != val.id) {
          this.delWorkList.push({
            id: index,
            companyName: val.companyName,
            endTime: val.endTime,
            position: val.position,
            startTime: val.startTime
          });
          index = index + 1;
        }
      });
      this.workList = this.delWorkList;
    },
    // 编辑工作经历
    updataWorkList(row) {
      this.workForm.startTime = row.startTime;
      this.workForm.endTime = row.endTime;
      this.workForm.companyName = row.companyName;
      this.workForm.position = row.position;
      this.workForm.id = row.id;
      this.isShowWorkList = true;
      this.submitBtn=false
      this.workText = "保存并更新";
    },
    // 取消添加工作经历
    cancelWorkList() {
      this.isShowWorkList = false;
      this.workText = "添加工作经历";
      this.submitBtn=true
    },
    // 添加工作经历表单
    addWorkList(workForm) {
      this.submitBtn=false
      if (this.workText === "添加工作经历") {
        this.workForm.startTime = "";
        this.workForm.endTime = "";
        this.workForm.companyName = "";
        this.workForm.position = "";
        this.workForm.id = 0;
        this.isShowWorkList = true;
        this.workText = "保存并更新";
      } else {
        this.$refs[workForm].validate(valid => {
          if (valid) {
            if (
              new Date(this.workForm.startTime) >
              new Date(this.workForm.endTime)
            ) {
              this.$message.error("开始时间不能大于结束时间");
              return;
            }
            if (this.workForm.id != 0) {
              var obj = this.workForm.id;
              this.workList[obj - 1] = {
                id: obj,
                companyName: this.workForm.companyName,
                endTime: this.workForm.endTime,
                position: this.workForm.position,
                startTime: this.workForm.startTime
              };
            } else {
              this.workList.push({
                id: this.workList.length + 1,
                companyName: this.workForm.companyName,
                endTime: this.workForm.endTime,
                position: this.workForm.position,
                startTime: this.workForm.startTime
              });
            }
            this.isShowWorkList = false;
            this.workText = "添加工作经历";
            this.submitBtn=true
          } else {
            return false;
          }
        });
      }
    },
    // 删除教育经历
    deleteEducationList(row) {
      let idx = 1;
      let delEducationList = [];
      this.educationList.forEach(item => {
        if (row.id != item.id) {
          delEducationList.push({
            id: idx,
            schoolName: item.schoolName,
            startTime: item.startTime,
            endTime: item.endTime,
            professionTitle: item.professionTitle
          });
          idx = idx + 1;
        }
      });
      this.educationList = delEducationList;
    },
    // 编辑教育经历
    updataEducationList(row) {
      this.educationForm.startTime = row.startTime;
      this.educationForm.endTime = row.endTime;
      this.educationForm.schoolName = row.schoolName;
      this.educationForm.id = row.id;
      this.educationForm.professionTitle = row.professionTitle;
      this.isShowEducationList = true;
      this.educationText = "保存并更新";
      this.submitBtn=false
    },
    // 取消添加教育经历
    cancelEducationList() {
      this.isShowEducationList = false;
      this.educationText = "添加教育经历";
      this.submitBtn=true
    },
    // 添加教育经历表单
    addEducationList(educationForm) {
      this.submitBtn=false
      if (this.educationText === "添加教育经历") {
        this.educationForm.startTime = "";
        this.educationForm.endTime = "";
        this.educationForm.schoolName = "";
        this.educationForm.id = 0;
        this.educationForm.professionTitle = "";
        this.isShowEducationList = true;
        this.educationText = "保存并更新";
      } else {
        this.$refs[educationForm].validate(valid => {
          if (valid) {
            if (
              new Date(this.educationForm.startTime) >
              new Date(this.educationForm.endTime)
            ) {
              this.$message.error("开始时间不能大于结束时间");
              return;
            }
            if (this.educationForm.id != 0) {
              let educationFormObj = this.educationForm.id;
              this.educationList[educationFormObj - 1] = {
                id: educationFormObj,
                schoolName: this.educationForm.schoolName,
                startTime: this.educationForm.startTime,
                endTime: this.educationForm.endTime,
                professionTitle: this.educationForm.professionTitle
              };
            } else {
              this.educationList.push({
                id: this.educationList.length + 1,
                schoolName: this.educationForm.schoolName,
                startTime: this.educationForm.startTime,
                endTime: this.educationForm.endTime,
                professionTitle: this.educationForm.professionTitle
              });
            }
            this.submitBtn=true
            this.isShowEducationList = false;
            this.educationText = "添加教育经历";
          } else {
            return false;
          }
        });
      }
    },
    // 加载china地点数据，三级
    getCityData: function() {
      var that = this;
      axios
        .get(this.mapJson)
        .then(function(response) {
          if (response.status == 200) {
            var data = response.data;
            that.province = [];
            that.city = [];
            that.block = [];
            // 省市区数据分类
            for (var item in data) {
              if (item.match(/0000$/)) {
                //省
                that.province.push({
                  id: item,
                  value: data[item],
                  children: []
                });
              } else if (item.match(/00$/)) {
                //市
                that.city.push({ id: item, value: data[item], children: [] });
              } else {
                //区
                that.block.push({ id: item, value: data[item] });
              }
            }
            // 分类市级
            for (var index in that.province) {
              for (var index1 in that.city) {
                if (
                  that.province[index].id.slice(0, 2) ===
                  that.city[index1].id.slice(0, 2)
                ) {
                  that.province[index].children.push(that.city[index1]);
                }
              }
            }
            // 分类区级
            for (var item1 in that.city) {
              for (var item2 in that.block) {
                if (
                  that.block[item2].id.slice(0, 4) ===
                  that.city[item1].id.slice(0, 4)
                ) {
                  that.city[item1].children.push(that.block[item2]);
                }
              }
            }
          } else {
          }
        })
        .catch(function(error) {});
    },
    // 选省
    choseProvince: function(e) {
      for (var index2 in this.province) {
        if (e === this.province[index2].id) {
          this.investorForm.addressProvince = this.province[index2].value;
          this.shi1 = this.province[index2].children;
          this.investorForm.addressCity = this.province[index2].children[0].value
          this.qu1 = this.province[index2].children[0].children;
          this.investorForm.addressArea = this.province[index2].children[0].children[0].value
          this.E = this.qu1[0].id;
        }
      }
    },
    // 选市
    choseCity: function(e) {
      for (var index3 in this.city) {
        if (e === this.city[index3].id) {
          this.investorForm.addressCity = this.city[index3].value;
          this.qu1 = this.city[index3].children;
          this.investorForm.addressArea = this.city[index3].children[0].value
          this.E = this.qu1[0].id;
        }
      }
    },
    // 选区
    choseBlock: function(e) {
      for (var index4 in this.qu1) {
        if (e === this.qu1[index4].id) {
          this.investorForm.addressArea = this.qu1[index4].value;
        }
      }
    },
    init() {},
    beforeAvaUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 < 500;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 500kb!");
        return false;
      }
    },
    handleAvaSuccess(file) {
      this.investorForm.avatar = file.data;
    },
    getTagCodeList() {
      let _this = this;
      this.api.get({
        url: "getInvestorMainArea",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorMainAreaOptions = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getInvestorMainRound() {
      let _this = this;
      this.api.get({
        url: "getInvestorMainRound",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            _this.investorMainRoundOptions = res.data;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getAffiliationUnit() {
      this.api.get({
        url: "getAffiliationUnit",
        data: { needPage: "0" },
        callback: res => {
          console.log(res)
          if (res.code == "0000") {
            this.orgOptions = res.data.rows;
          } else {
            this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.investorCertification {
  .basicInfo {
    padding: 30px 0 20px 87px;
  }
  .mr {
    margin-right: 10px;
  }
  .el-date-editor.el-input, .el-date-editor.el-input__inner{
    width: 266px;
  }
  .el-table__empty-block {
    min-height: 33px;
  }
  .el-table__empty-text {
    min-height: 33px;
    line-height: 33px;
  }
  .footer {
    margin: 50px 0px;
  }
  .investorCertification-header {
    color: #333;
    background-color: #fff;
    padding: 17px;
    margin-bottom: 14px;
    // font-size: 13px;
    border-radius: 5px;
  }
  .el-table__header {
    border-right: 1px solid rgba(65, 215, 135, 1);
    border-left: 1px solid rgba(65, 215, 135, 1);
    table-layout:auto;
  }
  .cancel {
    margin-left: 15px;
  }
  .el-table thead {
    color: #00a041;
  }
  .el-table {
    font-size: 12px;
  }
  .el-table td,
  .el-table th {
    padding: 5px;
  }
  .el-table th {
    height: 28px;
    background: rgba(236, 252, 242, 1);
    border-top: 1px solid rgba(65, 215, 135, 1);
    border-bottom: 1px solid rgba(65, 215, 135, 1);
    // border: 1px solid rgba(65,215,135,1);
    // padding: unset;
    font-size: 12px;
    // color: #00A041;
    font-weight: 400;
    text-align: center;
  }
  .el-form-item__content {
    line-height: 33px;
    height: 33px;
  }
  .el-textarea__inner {
    background: #fff;
    min-height: 97px !important;
  }
  .el-form-item__label {
    line-height: 33px;
    height: 33px;
  }
  .el-radio {
    margin-right: 20px;
  }
  .myPersonalProfile {
    .el-form-item__content {
      line-height: unset;
      height: unset;
    }
  }

  .el-input__inner {
    line-height: 32px;
    height: 32px;
    width: 266px;
  }
  .el-input__icon {
    line-height: 32px;
  }
  .editForm {
    padding-left: 170px;
    margin-top: 20px;
  }
  .investorMainAreaList {
    .el-select {
      width: 100%;
    }
    .el-input__inner {
      width: 100%;
    }
    .el-form-item__content {
      height: unset;
      line-height: unset;
    }
    .checked {
      border: 1px solid #eee;
      //  width: 685px;

      border-radius: 3px;
      padding: 10px;
      margin-top: 20px;
    }
    .el-checkbox {
      margin: 5px 0px;
      margin-right: 30px;
    }
  }
  .address {
    .el-input--suffix .el-input__inner {
      width: 150px;
    }
  }
}
.el-select-dropdown.is-multiple .el-select-dropdown__item.selected {
  color: #00a041;
  background-color: #fff;
}
.el-select .el-input.is-focus .el-input__inner {
  border-color: #00a041;
}
.el-select .el-input__inner:focus {
  border-color: #00a041;
}
.setpw {
  .inputItem {
    background: #fff;
    height: 32px;
  }
}
.investorCertification-content {
  .basicStyle {
    margin-bottom: 16px;
    margin-top: 20px;
    border-left: 4px solid rgb(0, 160, 65);
    font-size: 13px;
    padding: 0px 11px;
    > span {
      float: right;
      font-size: 12px;
      cursor: pointer;
      color: #00a041;
      [class*=" el-icon-"],
      [class^="el-icon-"] {
        font-size: 14px;
        vertical-align: bottom;
      }
    }
  }
  .iconfont {
    margin-right: 10px;
  }
  .icon-icon_xuanzhong {
    color: #00a041;
  }
  .icon-web_xuanzhong {
    color: #00a041;
  }

  .mulSel {
    width: 705px;
  }
  .mulSel .el-select .el-input.is-focus .el-input__inner {
    border-color: none;
  }
  .mulSel .el-select .el-input__inner:focus {
    border-color: none;
  }
  .editBtn1 {
    background: #009f42;
    color: #fff;
    font-size: 13px;
    width: 100px;
    height: 35px;
    line-height: 5px;
    border-color: none;
    margin-left: 150px;
  }
  .editBtn {
    font-size: 13px;
  }
  .infoInput {
    height: 32px;
    border: 1px solid #eee;
    width: 250px;
    border-radius: 3px;
  }
  .infoInput:focus {
    border-color: #00a041;
  }
  // .infoInput:nth-child(2) {
  //   margin: 15px 0;
  // }
  .avatar-img {
    width: 100px;
    height: 100px;
  }
  .avatar-img .el-upload {
    // border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    display: inline-block;
    vertical-align: middle;
  }
  .avatar-img .avatar-uploader-icon {
    border: 2px dashed #eee;
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatar-img .avatar {
    width: 100px;
    height: 100px;
    border-radius: 5px;
    display: inline-block;
  }
  .signInItem {
    display: inline-block;
    width: 80%;
    vertical-align: middle;
    font-size: 13px;
  }
  .signInItem .el-textarea__inner {
    background: #fff;
    border: 1px solid #eee;
  }
  .uploadImgItem {
    position: absolute;
    right: 92px;
    top: 36px;
    z-index: 20;
    > .textRight {
      display: inline-block;
    }
    .textImg {
      color: #666;
      font-size: 12px;
      margin-left: 30px;
      margin-top: 18px;
    }
  }
}
</style>

<template>
  <div class="basicInformation">
    <div class="investorCertification-header">
      <div>服务机构认证</div>
    </div>
    <el-main style="padding:0 25px;text-align:left;background:#fff;">
      <div class="investorCertification-content">
        <div class="step">
          <el-steps :active="status" align-center>
            <el-step title="基本信息"></el-step>
            <el-step title="机构资质"></el-step>
            <el-step title="团队信息"></el-step>
            <el-step title="联系方式"></el-step>
          </el-steps>
        </div>
        <div class="basicStyle">{{investorCertificationTitle}}</div>
        <div v-show="status==0">
          <div class="basicInfo pr">
            <div class="setdistance uploadImgItem">
              <!-- <span class="textRight mg">照片：</span> -->
              <el-upload class="avatar-uploader avatarImg" :show-file-list="false" action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
                :on-success="handleAvaSuccess" :headers="headers" :before-upload="beforeAvaUpload" style="display:inline-block">
                <img v-if="OrgBasicForm.orgLogo" :src="OrgBasicForm.orgLogo" class="avatar">
                <i v-else class="el-icon-plus avatar-uploader-icon"></i>
              </el-upload>
              <div class="textImg">
                请上传企业LOGO,支持png、jpg
                <br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格式，大小不要超过1M
              </div>
            </div>
            <el-form :rules="rules" :model="OrgBasicForm" label-width="140px" ref="OrgBasicForm">
              <el-form-item label="机构名称:" prop="orgName" class="maxWidth">
                <el-input v-model="OrgBasicForm.orgName" placeholder="请输入机构名称" clearable></el-input>
              </el-form-item>
              <el-form-item label="统一社会信用代码/组织机构代码:" class="orgCode maxWidth" prop="orgCode">
                <el-input v-model="OrgBasicForm.orgCode" placeholder="请输入统一社会信用代码/组织机构代码" clearable></el-input>
              </el-form-item>

              <el-form-item label="注册时间:" prop="orgRegisterTime" class="maxWidth">
                <el-date-picker v-model="OrgBasicForm.orgRegisterTime" value-format="yyyy-MM-dd" type="date"
                  placeholder="选择日期"></el-date-picker>
              </el-form-item>
              <el-form-item label="机构简介:" prop="orgSynopsis" class="myPersonalProfile">
                <el-input v-model="OrgBasicForm.orgSynopsis" type="textarea" autosize placeholder="请填写机构简介,限500字"
                  clearable></el-input>
              </el-form-item>
              <el-form-item label="主营业务:" prop="orgBusiness" class="myPersonalProfile">
                <el-input v-model="OrgBasicForm.orgBusiness" type="textarea" autosize placeholder="请填写主营业务,限500字"
                  clearable></el-input>
              </el-form-item>
              <el-form-item label="业务擅长:" prop="orgSpeciality" class="investorMainAreaList">
                <el-select v-model="OrgBasicForm.orgSpeciality" multiple placeholder="请选择业务擅长">
                  <el-option v-for="(val,index) in orgSpecialityOptions" :key="index" :label="val.preValue" :value="val.id"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="客户偏好:" prop="position">
                <!-- <el-input v-model="OrgBasicForm.orgBusiness" placeholder="请选择您主要客户群体的以下特征,最多分别选3项" clearable></el-input> -->
                <span class="curtomer">请选择您主要客户群体的以下特征,最多分别选3项</span>
              </el-form-item>
              <el-form-item label="行业领域:" prop="industrySector" class="investorMainAreaList">
                <el-select v-model="OrgBasicForm.industrySector" multiple :multiple-limit='num' placeholder="请选择行业领域">
                  <el-option v-for="(val,index) in industrySectorOptions" :key="index" :label="val.preValue" :value="val.id"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="发展阶段:" prop="developmentStage" class="investorMainAreaList">
                <el-select v-model="OrgBasicForm.developmentStage" :multiple-limit='num' multiple placeholder="请选择发展阶段">
                  <el-option v-for="item in developmentStageOptions" :key="item.id" :label="item.preValue" :value="item.id"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="企业性质:" prop="companyNature" class="investorMainAreaList">
                <el-select v-model="OrgBasicForm.companyNature" :multiple-limit='num' multiple placeholder="请选择企业性质">
                  <el-option v-for="item in companyNatureOptions" :key="item.id" :label="item.preValue" :value="item.id"></el-option>
                </el-select>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div v-show="status==1">
          <div class="licensesInfo pr">
            <el-form :rules="licensesRules" :model="licensesForm" label-width="110px" ref="licensesForm">
              <el-form-item label="业务领域:" prop="businessType" class="businessType">
                <el-select v-model="licensesForm.businessType" placeholder="请选择业务领域">
                  <el-option v-for="(val,index) in orgSpecialityOptions" :key="index" :label="val.preValue" :value="val.id"></el-option>
                </el-select>
              </el-form-item>
              <el-form-item label="营业执照:">
                <span class="curtomer">请填写营业执照信息。附件请上传证书照片，单个文件不超过1M</span>
              </el-form-item>
              <el-table :data="licenseList" style="width: 100%" class="license">
                <el-table-column label="证书名称" align="center">
                  <template>
                    <span>企业营业执照</span>
                  </template>
                </el-table-column>
                <el-table-column align="center" label="颁发时间">
                  <template slot-scope="scope">
                    <el-date-picker v-model="licenseList[scope.$index].awardTime" type="date" value-format="yyyy-MM-dd"
                      placeholder="请选择颁发时间"></el-date-picker>
                  </template>
                </el-table-column>
                <el-table-column align="center" label="主管部门">
                  <template slot-scope="scope">
                    <el-input v-model="licenseList[scope.$index].awardDepart" placeholder="请输入主管部门" maxlength='20'
                      clearable></el-input>
                  </template>
                </el-table-column>
                <el-table-column align="center" label="上传附件">
                  <template>
                    <el-upload class="avatar-uploader avatarImg" :show-file-list="false" action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
                      :on-success="handlelicense" :headers="headers" :before-upload="beforelicense" style="display:inline-block">
                      <img v-if="fileUrl" :src="fileUrl" class="avatar">
                      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                  </template>
                </el-table-column>
              </el-table>
              <el-form-item label="其它资质/荣誉:" class="otherInfo">
                <span class="curtomer">附件请上传相关资质荣誉证书照片，单个文件不超过1M</span> <span class="otherOperation mainColor pr smailSize cancel"
                  @click="cancelOtherList" v-if="isShowOtherList">取&nbsp;消</span>
                <span class="otherOperation mainColor cur smailSize" @click="addOtherList('otherForm')">
                  <i class="el-icon-plus"></i>
                  &nbsp;{{otherText}}
                </span>
              </el-form-item>
              <div class="marBtn" v-if="!isShowOtherList">
                <el-table :data="otherList" style="width: 100%">
                  <el-table-column prop="certName" label="资质荣誉名称" align="center"></el-table-column>
                  <el-table-column label="特色标签" align="center">
                    <template>
                      <span>否</span>
                    </template>
                  </el-table-column>
                  <el-table-column prop="awardTime" align="center" label="颁发时间"></el-table-column>
                  <el-table-column prop="awardDepart" align="center" label="主管部门"></el-table-column>
                  <el-table-column align="center" label="附件">
                    <template slot-scope="scope">
                      <span v-if="scope.row.fileUrl" class="themeColor smallSize cur" @click="lookPoster(scope.row)">点击查看</span>
                      <span v-if="!scope.row.fileUrl">暂无附件</span>
                    </template>
                  </el-table-column>

                  <el-table-column align="center" label="操作">
                    <template slot-scope="scope">
                      <span class="mainColor smallSize cur mr" @click="updataOtherList(scope.row)">编辑</span>
                      <span class="redColor smallSize cur" @click="deleteOtherList(scope.row)">删除</span>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
              <div v-if="isShowOtherList">
                <el-form class="otherForm" :rules="otherFormRules" :model="otherForm" label-width="110px" ref="otherForm">
                  <el-form-item label="资质荣誉名称:" prop="certName">
                    <el-input v-model="otherForm.certName" placeholder="请输入资质荣誉名称" clearable></el-input>
                  </el-form-item>
                  <el-form-item label="颁发时间:">
                    <el-date-picker v-model="otherForm.awardTime" type="date" value-format="yyyy-MM-dd" placeholder="请选择颁发时间"></el-date-picker>
                  </el-form-item>
                  <el-form-item label="主管部门:">
                    <el-input v-model="otherForm.awardDepart" placeholder="请输入主管部门" maxlength='20' clearable></el-input>
                  </el-form-item>
                  <el-form-item label="附件:" class="otherAccessory">
                    <label slot="label">附&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;件:</label>
                    <el-upload class="accessory" :show-file-list="false" action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload"
                      :on-success="handleOtherSuccess" :headers="headers" :before-upload="beforeAvaUpload" style="display:inline-block">
                      <img v-if="otherForm.fileUrl" :src="otherForm.fileUrl" class="otherAvatar">
                      <i v-else class="el-icon-plus avatar-uploader-icon"></i>
                    </el-upload>
                  </el-form-item>
                </el-form>
              </div>
            </el-form>
          </div>
        </div>
        <div v-show="status==2">
          <div class="licensesInfo pr">
            <el-form :rules="teamRules" :model="teamForm" label-width="200px" ref="teamForm">
              <el-form-item label="机构人员结构:" class="teamForm" prop="team">
                <!-- <el-input v-model="OrgBasicForm.orgName" placeholder="请输入机构名称" clearable></el-input> -->
              </el-form-item>
              <el-form-item label="员工总人数（缴纳公积金）:" class="orientation teamForm" prop="staffCount">
                <el-input v-model="teamForm.staffCount"  placeholder="请填写人数" @blur="BlurText($event)"></el-input><span class="person">人</span>
              </el-form-item>
              <div>
                <el-form-item label="执业人员人数：" class="orientation dis" prop="professionNum">
                  <el-input v-model="teamForm.professionNum" @blur="BlurText($event)" placeholder="请填写人数"></el-input><span class="person">人</span>
                </el-form-item>
                <span>占总人数比&nbsp;<i class="mainColor">{{teamForm.professionNum?((teamForm.professionNum/teamForm.staffCount)*100).toFixed(2):''}}</i>&nbsp;</span>%
              </div>
              <div>
                <el-form-item label="本科人员人数：" class="orientation dis" prop="bachelorNum">
                  <el-input v-model="teamForm.bachelorNum" @blur="BlurText($event)" placeholder="请填写人数"></el-input><span class="person">人</span>
                </el-form-item>
                <span>占总人数比&nbsp;<i class="mainColor">{{teamForm.bachelorNum?((teamForm.bachelorNum/teamForm.staffCount)*100).toFixed(2):''}}</i>&nbsp;</span>%
              </div>
              <div>
                <el-form-item label="硕士人员人数：" class="orientation dis" prop="masterNum">
                  <el-input v-model="teamForm.masterNum" @blur="BlurText($event)" placeholder="请填写人数"></el-input><span class="person">人</span>
                </el-form-item>
                <span>占总人数比&nbsp;<i class="mainColor">{{teamForm.masterNum?((teamForm.masterNum/teamForm.staffCount)*100).toFixed(2):''}}</i>&nbsp;</span>%
              </div>
              <div>
                <el-form-item label="博士人员人数：" class="orientation dis" prop="doctorNum">
                  <el-input v-model="teamForm.doctorNum" @blur="BlurText($event)" placeholder="请填写人数"></el-input><span class="person">人</span>
                </el-form-item>
                <span>占总人数比&nbsp;<i class="mainColor">{{teamForm.doctorNum?((teamForm.doctorNum/teamForm.staffCount)*100).toFixed(2):''}}</i>&nbsp;</span>%
              </div>
              <div>
                <el-form-item label="海归人员人数：" class="orientation dis" prop="returneeNum">
                  <el-input v-model="teamForm.returneeNum" @blur="BlurText($event)" placeholder="请填写人数"></el-input><span class="person">人</span>
                </el-form-item>
                <span>占总人数比&nbsp;<i class="mainColor">{{teamForm.returneeNum?((teamForm.returneeNum/teamForm.staffCount)*100).toFixed(2):''}}</i>&nbsp;</span>%
              </div>
            </el-form>
          </div>
          <div class="kernelInfo">
            <el-form :rules="kernelRules" label-width="110px">
              <el-form-item label="核心服务团队:" class="teamForm" prop="kernelInfo">
                <span class="curtomer">请至少维护3条核心服务团队成员信息，个人资质、业务特长请控制在200字以内。</span><span class="otherOperation mainColor pointer smailSize cancel"
                  @click="cancelKernelList" v-if="isShowKernelList">取&nbsp;消</span>
                <span class="otherOperation mainColor cur smailSize" @click="addKernelList">
                  <i class="el-icon-plus"></i>
                  &nbsp;{{kernelText}}
                </span>
              </el-form-item>
            </el-form>
            <div>
              <div class="marBtn" v-if="!isShowKernelList">
                <el-table :data="kernelList" style="width: 100%">
                  <el-table-column prop="conName" label="姓名" align="center"></el-table-column>
                  <el-table-column label="职务" align="center" prop="conPosition">
                  </el-table-column>
                  <el-table-column prop="conQuali" align="center" label="个人资质" show-overflow-tooltip></el-table-column>
                  <el-table-column prop="conTime" align="center" label="从业起始年份"></el-table-column>
                  <el-table-column prop="conSpeciality" align="center" label="业务特长" show-overflow-tooltip></el-table-column>

                  <el-table-column align="center" label="操作">
                    <template slot-scope="scope">
                      <span class="mainColor smallSize cur mr" @click="updataKernelList(scope.row)">编辑</span>
                      <span class="redColor smallSize cur" @click="deleteKernelList(scope.row)">删除</span>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
              <div v-if="isShowKernelList">
                <el-form class="otherForm" :rules="kernelFormRules" :model="kernelForm" label-width="110px" ref="kernelForm">
                  <el-form-item label="姓名:" prop="conName">
                    <label slot="label">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名:</label>
                    <el-input v-model="kernelForm.conName" placeholder="请输入姓名" clearable></el-input>
                  </el-form-item>
                  <el-form-item label="职务:">
                    <label slot="label">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务:</label>
                    <el-input v-model="kernelForm.conPosition" placeholder="请输入职务"  type="text" maxlength="20" show-word-limit clearable></el-input>
                  </el-form-item>
                  <el-form-item label="从业起始年份:">
                    <el-date-picker v-model="kernelForm.conTime" type="month" value-format="yyyy-MM" placeholder="从业起始年份"></el-date-picker>
                  </el-form-item>
                  <el-form-item label="个人资质:" class="otherAccessory">
                    <el-input v-model="kernelForm.conQuali" placeholder="请输入个人资质,逗号间隔" maxlength="200" show-word-limit
                      type="textarea" clearable></el-input>
                  </el-form-item>
                  <el-form-item label="业务特长:" class="otherAccessory">
                    <el-input v-model="kernelForm.conSpeciality" placeholder="请输入业务特长,逗号间隔" maxlength="200"
                      show-word-limit autosize type="textarea" clearable></el-input>
                  </el-form-item>
                </el-form>
              </div>
            </div>
          </div>
        </div>
        <div v-show="status==3">
          <div class="licensesInfo pr">
           <el-form :rules="contactRules" :model="contactForm" label-width="100px" class="otherForm" ref="contactForm">
            <el-form-item label="办公地址:" class="address" prop="orgProvince">
              <el-select v-model="contactForm.orgProvince" @change="choseProvince" placeholder="省级地区">
                <el-option v-for="item in province" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
              <el-select v-model="contactForm.orgCity" @change="choseCity" placeholder="市级地区">
                <el-option v-for="item in shi1" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
              <el-select v-model="contactForm.orgArea" @change="choseBlock" placeholder="区级地区">
                <el-option v-for="item in qu1" :key="item.id" :label="item.value" :value="item.id">
                </el-option>
              </el-select>
            </el-form-item>
             <el-form-item prop="orgAddress" class="orgAddressInfo">
              <el-input v-model="contactForm.orgAddress" placeholder="请填写详细地址" clearable></el-input>
            </el-form-item>
             <el-form-item label="咨询电话:" prop="orgPhone">
              <el-input v-model="contactForm.orgPhone" placeholder="请输入咨询电话" clearable></el-input>
            </el-form-item>
              <el-form-item label="机构网址:" prop="orgWeb">
              <el-input v-model="contactForm.orgWeb" placeholder="请输入机构网址" clearable></el-input>
            </el-form-item>
             <el-form-item label="联系人姓名:" prop="conName">
              <el-input v-model="contactForm.conName" placeholder="请输入联系人姓名" clearable></el-input>
            </el-form-item>
            <el-form-item label="联系人手机:" prop="conPhone">
              <el-input v-model="contactForm.conPhone" placeholder="请输入联系人手机" clearable></el-input>
            </el-form-item>
            <el-form-item label="联系人邮箱:" prop="conEmail">
              <el-input v-model="contactForm.conEmail" placeholder="请输入联系人邮箱" clearable></el-input>
            </el-form-item>
          </el-form>

          </div>

        </div>
        <div class="ct footerBtn" v-show="!showBtn">
          <el-button size="mini" class="mainColor  footer" @click="submit">{{btnText}}</el-button>
        </div>
      </div>
    </el-main>
    <el-dialog :visible.sync="dialogVisible" width="50%">
      <img :src="otherPhoto" alt="图片" style="width:100%">
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">返 回</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import axios from "axios";
export default {
  data() {
    return {
      btnText:'保存并继续',
      showBtn: false,
      isShowKernelList: false,
      kernelList: [],
      otherList: [],
      otherPhoto: "",
      dialogVisible: false,
      isShowOtherList: false,
      fileUrl: "",
      licensesForm: {
        businessType: ""
      },
      kernelText: "添加核心服务团队人员",
      otherText: "添加其它资质/荣誉",
      status: 0,
      investorCertificationTitle: "基本信息",
      num: 3,
      orgSpecialityOptions: [],
      industrySectorOptions: [],
      developmentStageOptions: [],
      companyNatureOptions: [],
      disabled: false,
      orgOptions: [],
      licenseList: [{}],
      otherForm: {
        id: 0,
        certType: "3",
        awardTime: "",
        fileUrl: "",
        certName: "",
        isFeatures: "0",
        awardDepart: ""
      },
      kernelForm: {
        id: 0,
        conName: "",
        conPosition: "",
        conQuali: "",
        conSpeciality: "",
        conTime: ""
      },
      teamForm: {
        staffCount: "", //员工总人数
        returneeNum: "", //海归员工人数
        professionNum: "", //执业人员人数
        masterNum: "", //硕士学历人数
        doctorNum: "", //博士学历人数
        bachelorNum: "" //本科学历人数
      },
      contactForm:{
        orgProvince:'',
        orgCity:'',
        orgArea:'',
        orgAddress:'',
        orgPhone:'',
        orgWeb:'',
        conName:'',
        conPhone:'',
        conEmail:''
      },
      OrgBasicForm: {
        businessType: "",
        licenses: [], //机构资质集合
        companyNature: [], //客户偏好-企业性质
        developmentStage: [], //客户偏好-发展阶段
        industrySector: [], //客户偏好-行业领域
        orgBusiness: "", //主营业务
        orgCode: "", //统一社会信用代码/组织机构代码
        orgLogo: "", //机构LOGO
        orgName: "", //..机构名称
        orgRegisterTime: "", //注册时间
        orgSpeciality: [], //业务擅长
        orgSynopsis: "", //机构简介
        staffCount: "", //员工总人数
        returneeNum: "", //海归员工人数
        professionNum: "", //执业人员人数
        masterNum: "", //硕士学历人数
        doctorNum: "", //博士学历人数
        bachelorNum: "", //本科学历人数
         orgProvince:'',//省
        orgCity:'',//市
        orgArea:'',//区
        orgAddress:'',//详细地址
        orgPhone:'',//机构咨询电话
        orgWeb:'',//机构网址
        conName:'',//联系人名字
        conPhone:'',//联系人电话
        conEmail:''//联系人邮箱
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
        orgSpeciality: [
          { required: true, message: "请选择业务擅长", trigger: "change" }
        ],
        orgCode: [
          {
            required: true,
            message: "请填写统一社会信用代码/组织机构代码",
            trigger: "blur"
          }
        ],
        orgRegisterTime: [
          { required: true, message: "请选择时间", trigger: "change" }
        ],
        orgSynopsis: [
          { required: true, message: "请填写机构简介", trigger: "blur" }
        ],
        orgBusiness: [{ required: true, message: "主营业务", trigger: "blur" }],
        industrySector: [
          { required: true, message: "请选择行业领域", trigger: "change" }
        ],
        developmentStage: [
          { required: true, message: "请选择发展阶段", trigger: "change" }
        ],
        companyNature: [
          { required: true, message: "请选择企业性质", trigger: "change" }
        ],
        orgName: [
          { required: true, message: "请填写机构名称", trigger: "blur" }
        ]
      },
      licensesRules: {
        businessType: [
          { required: true, message: "请选择业务领域", trigger: "change" }
        ]
      },
      otherFormRules: {
        certName: [
          { required: true, message: "请填写资质荣誉名称", trigger: "blur" }
        ]
      },
      kernelRules: {
        kernelInfo: [
          {
            required: true,
            message: "请填写核心服务团队人员资料",
            trigger: "blur"
          }
        ]
      },
      teamRules: {
        // team: [
        //   { required: true, message: "请输入机构人员结构" }
        // ],
        bachelorNum: [
          {
            required: true,
            message: "请填写本科学历人数",
            trigger: "blur"
          }
        ],
        doctorNum: [
          { required: true, message: "请填写博士学历人数", trigger: "blur" }
        ],
        masterNum: [
          { required: true, message: "请填写硕士学历人数", trigger: "blur" }
        ],
        professionNum: [
          { required: true, message: "请填写执业人员人数", trigger: "blur" }
        ],
        returneeNum: [
          { required: true, message: "请填写海归人员人数", trigger: "blur" }
        ],
        staffCount: [
          { required: true, message: "请填写员工总人数", trigger: "blur" }
        ]
      },
      kernelFormRules: {
        conName: [
          {
            required: true,
            message: "请填写姓名",
            trigger: "blur"
          }
        ]
      },
      contactRules:{
         conEmail: [
          { required: true, message: "请填写邮箱", trigger: "blur" },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        conName: [
          {
            required: true,
            message: "请输入联系人姓名",
            trigger: "blur"
          }
        ],
        conPhone: [
          { required: true, message: "请输入联系人电话", trigger: "blur" }
        ],
         orgPhone: [
          { required: true, message: "请输入咨询电话", trigger: "blur" }
        ],
        orgWeb: [
          { required: true, message: "请输入机构网址", trigger: "blur" }
        ],
        orgProvince: [{ required: true, message: "请选择省份", trigger: "change" }],
        orgAddress: [{ required: true, message: "请填写详细地址", trigger: "blur" }]

      }
    };
  },
  created() {
    this.getCityData();
    this.selectIndustryList();
  },
  methods: {
    // 禁止输入小数和负数
    BlurText(e){
        let boolean=new RegExp("^[1-9][0-9]*$").test(e.target.value)
        if(!boolean){
          this.$message.warning('请输入正整数')
          e.target.value=''
        }
    },
    // 查看图片
    lookPoster(row) {
      //  if(!row.posterUrl){
      //      this.$message.error('此宣传没有宣传海报')
      //  }else{
      this.otherPhoto = row.fileUrl;
      this.dialogVisible = true;
      //  }
    },
    // 保存基本信息
    submit() {
      if (this.investorCertificationTitle == "基本信息") {
        if (!this.OrgBasicForm.orgLogo) {
          this.$message.error("请上传企业LOGO图片在保存");
          return;
        }
        this.$refs["OrgBasicForm"].validate(valid => {
          if (valid) {
            if (!this.OrgBasicForm.orgLogo) {
              this.$message.error("企业LOGO还在上传中,请稍后");
              return;
            }
            this.status = 1;
            this.investorCertificationTitle = "机构资质";

            console.log(this.OrgBasicForm);
          } else {
            return false;
          }
        });
      } else if (this.investorCertificationTitle == "机构资质") {
        this.$refs["licensesForm"].validate(valid => {
          if (valid) {
            if (!this.fileUrl) {
              this.$message.error("请上传企业营业执照照片");
              return;
            }
            this.status = 2;
            this.investorCertificationTitle = "团队信息";
            this.OrgBasicForm.businessType = this.licensesForm.businessType;
            this.licenseList = this.licenseList.map(item =>
              item.fileUrl
                ? item
                : Object.assign(item, { fileUrl: this.fileUrl })
            );
            this.licenseList = this.licenseList.map(item =>
              item.isFeatures ? item : Object.assign(item, { isFeatures: "0" })
            );
            this.licenseList = this.licenseList.map(item =>
              item.certName
                ? item
                : Object.assign(item, { certName: "企业营业执照" })
            );
            this.otherList = this.otherList.map(item =>
              item.isFeatures ? item : Object.assign(item, { isFeatures: "0" })
            );
            this.OrgBasicForm.licenses = this.licenseList.concat(
              this.otherList
            );
            console.log(this.OrgBasicForm);
          } else {
            return false;
          }
        });
      } else if (this.investorCertificationTitle == "团队信息") {
        this.$refs["teamForm"].validate(valid => {
          if (valid) {
            if(this.kernelList.length==0||this.kernelList.length<3){
              this.$message.error("请添加至少3条核心服务团队人员信息");
              return;
            }
            this.OrgBasicForm.staffCount=this.teamForm.staffCount
            this.OrgBasicForm.returneeNum=this.teamForm.returneeNum
            this.OrgBasicForm.professionNum=this.teamForm.professionNum
            this.OrgBasicForm.masterNum=this.teamForm.masterNum
            this.OrgBasicForm.doctorNum=this.teamForm.doctorNum
            this.OrgBasicForm.bachelorNum=this.teamForm.bachelorNum
            this.OrgBasicForm.orgTeams=this.kernelList
            this.status = 3;
            this.investorCertificationTitle = "联系方式";
            this.btnText="保存并认证"
          } else {
            return false;
          }
        });
      }else if (this.investorCertificationTitle == "联系方式") {
        this.$refs["contactForm"].validate(valid => {
          if (valid) {
           console.log(this.contactForm)
            this.OrgBasicForm.orgProvince=this.contactForm.orgProvince
            this.OrgBasicForm.orgCity=this.contactForm.orgCity
            this.OrgBasicForm.orgArea=this.contactForm.orgArea
            this.OrgBasicForm.orgAddress=this.contactForm.orgAddress
            this.OrgBasicForm.orgPhone=this.contactForm.orgPhone
            this.OrgBasicForm.orgWeb=this.contactForm.orgWeb
            this.OrgBasicForm.conName=this.contactForm.conName
            this.OrgBasicForm.conPhone=this.contactForm.conPhone
            this.OrgBasicForm.conEmail=this.contactForm.conEmail
            console.log(this.OrgBasicForm)
             this.api.post({
        url: "saveOrUpdateOrgDetail",
        data: this.OrgBasicForm,
        callback: (res) =>{
          if (res.code == "0000") {
          this.$message({
                  message: "提交成功",
                  type: "success"
                });
           this.$router.push({
        path: "/servicemarket/product/userCenter"
      });
          } else {
            this.$message.error(res.result);
          }
        }
      });

          } else {
            return false;
          }
        });
      }
    },
    // 获取领域
    selectIndustryList() {
      this.api.get({
        url: "selectTeamList",
        data: { preType: "", id: "", preValue: "" },
        callback: res => {
          if (res.code == "0000") {
            for (let it in res.data) {
              if (res.data[it].preType == "0") {
                this.orgSpecialityOptions.push(res.data[it]);
              } else if (res.data[it].preType == "1") {
                this.industrySectorOptions.push(res.data[it]);
              } else if (res.data[it].preType == "2") {
                this.developmentStageOptions.push(res.data[it]);
              } else {
                this.companyNatureOptions.push(res.data[it]);
              }
            }
          } else {
            this.$message.error(res.result);
          }
        }
      });
    },
    // 提交数据

    // // 编辑核心团队人员
    updataKernelList(row) {
      this.kernelForm.conName = row.conName;
      this.kernelForm.conPosition = row.conPosition;
      this.kernelForm.conQuali = row.conQuali;
      this.kernelForm.id = row.id;
      this.kernelForm.conSpeciality = row.conSpeciality;
      this.kernelForm.conTime = row.conTime;
      this.isShowKernelList = true;
         this.showBtn=true
      this.kernelText = "保存并更新";
    },
    // 删除核心团队人员
    deleteKernelList(row) {
      let idx = 1;
      let delKernelList = [];
      this.kernelList.forEach(item => {
        if (row.id != item.id) {
          delKernelList.push({
            id: idx,
            conName: item.conName,
            conPosition: item.conPosition,
            conQuali: item.conQuali,
            conSpeciality: item.conSpeciality,
            conTime: item.conTime
          });
          idx = idx + 1;
        }
      });
      this.kernelList = delKernelList;
    },
    // // 取消添加核心团队人员
    cancelKernelList() {
      this.isShowKernelList = false;
      this.kernelText = "添加核心服务团队人员";
      this.showBtn=false
    },
    // // 添加核心团队人员
    addKernelList() {
      if (this.kernelText === "添加核心服务团队人员") {
        this.kernelForm.conName = "";
        this.kernelForm.conPosition = "";
        this.kernelForm.conQuali = "";
        this.kernelForm.conSpeciality = "";
        this.kernelForm.id = 0;
        this.kernelForm.conTime = "";
        this.isShowKernelList = true;
        this.kernelText = "保存并更新";
        this.showBtn=true
      } else {
        this.$refs["kernelForm"].validate(valid => {
          if (valid) {
            if (this.kernelForm.id != 0) {
              let kernelFormObj = this.kernelForm.id;
              this.kernelList[kernelFormObj - 1] = {
                id: kernelFormObj,
                conPosition: this.kernelForm.conPosition,
                conName: this.kernelForm.conName,
                conTime: this.kernelForm.conTime,
                conQuali: this.kernelForm.conQuali,
                conSpeciality: this.kernelForm.conSpeciality
              };
            } else {
              this.kernelList.push({
                id: this.kernelList.length + 1,
                conTime: this.kernelForm.conTime,
                conPosition: this.kernelForm.conPosition,
                conName: this.kernelForm.conName,
                conSpeciality: this.kernelForm.conSpeciality,
                conQuali: this.kernelForm.conQuali
              });
            }
            this.showBtn=false
            this.isShowKernelList = false;
            this.kernelText = "添加核心服务团队人员";
          } else {
            return false;
          }
        });
      }
    },
    // // 编辑其它资质/荣誉
    updataOtherList(row) {
      this.otherForm.awardDepart = row.awardDepart;
      this.otherForm.awardTime = row.awardTime;
      this.otherForm.certName = row.certName;
      this.otherForm.id = row.id;
      this.otherForm.fileUrl = row.fileUrl;
      this.isShowOtherList = true;
      this.otherText = "保存并更新";
    },
    // 删除其它资质/荣誉
    deleteOtherList(row) {
      let idx = 1;
      let delOtherList = [];
      this.otherList.forEach(item => {
        if (row.id != item.id) {
          delOtherList.push({
            id: idx,
            certName: item.certName,
            awardTime: item.awardTime,
            awardDepart: item.awardDepart,
            fileUrl: item.fileUrl
          });
          idx = idx + 1;
        }
      });
      this.otherList = delOtherList;
    },
    // // 取消添加其它资质/荣誉
    cancelOtherList() {
      this.isShowOtherList = false;
      this.otherText = "添加其它资质/荣誉";
    },
    // // 添加其它荣誉资质表单
    addOtherList(otherForm) {
      if (this.otherText === "添加其它资质/荣誉") {
        this.otherForm.fileUrl = "";
        this.otherForm.certName = "";
        this.otherForm.awardDepart = "";
        this.otherForm.id = 0;
        this.otherForm.awardTime = "";
        this.isShowOtherList = true;
        this.otherText = "保存并更新";
      } else {
        this.$refs[otherForm].validate(valid => {
          if (valid) {
            if (this.otherForm.id != 0) {
              let otherFormObj = this.otherForm.id;
              this.otherList[otherFormObj - 1] = {
                id: otherFormObj,
                awardTime: this.otherForm.awardTime,
                certName: this.otherForm.certName,
                fileUrl: this.otherForm.fileUrl,
                awardDepart: this.otherForm.awardDepart
              };
            } else {
              this.otherList.push({
                id: this.otherList.length + 1,
                certName: this.otherForm.certName,
                awardTime: this.otherForm.awardTime,
                fileUrl: this.otherForm.fileUrl,
                awardDepart: this.otherForm.awardDepart
              });
            }
            this.isShowOtherList = false;
            this.otherText = "添加其它资质/荣誉";
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
          this.contactForm.orgProvince = this.province[index2].value;
          this.shi1 = this.province[index2].children;
          this.contactForm.orgCity = this.province[index2].children[0].value
          this.qu1 = this.province[index2].children[0].children;
           this.contactForm.orgArea = this.province[index2].children[0].children[0].value
          this.E = this.qu1[0].id;
        }
      }
    },
    // 选市
    choseCity: function(e) {
      for (var index3 in this.city) {
        if (e === this.city[index3].id) {
          this.contactForm.orgCity = this.city[index3].value;
          this.qu1 = this.city[index3].children;
          this.contactForm.orgArea = this.city[index3].children[0].value
          this.E = this.qu1[0].id;
        }
      }
    },
    // // 选区
    choseBlock: function(e) {
      for (var index4 in this.qu1) {
        if (e === this.qu1[index4].id) {
          this.contactForm.orgArea = this.qu1[index4].value;
        }
      }
    },
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
      this.OrgBasicForm.orgLogo = file.data;
    },
    beforelicense(file) {
      console.log(file);
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 < 500;

      if (!isJPG) {
        this.$message.error("上传图片只能是 JPG 格式!");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 500kb!");
        return false;
      }
    },
    handlelicense(file) {
      this.fileUrl = file.data;
    },
    handleOtherSuccess(file) {
      this.otherForm.fileUrl = file.data;
    },
  }
};
</script>
<style lang="scss">
  .el-tooltip__popper.is-dark{
    max-width: 260px;
}
.basicInformation {
  .orgAddressInfo{
     .el-input__inner{
      width: 460px;
    }
  }
  .otherOperation {
    float: right;
  }
  .teamForm {
    .el-form-item__label {
      text-align: left;
    }
  }
  .orientation {
    .el-form-item__content {
      position: relative;
    }
    .person {
      position: absolute;
      top: 0px;
      left: 240px;
    }
  }
  .dis {
    display: inline-block;
    margin-right: 23px;
  }
  .otherAccessory {
    .el-form-item__content {
      height: unset;
      line-height: unset;
    }

    .accessory {
      // width: 100px;
      // height: 100px;
      // line-height: 100px;
      // border:2px dashed #eee;
      // text-align: center;
      .el-upload {
        width: 96px;
        height: 96px;
        line-height: 96px;
        border: 2px dashed #eee;
        text-align: center;
        z-index: 10;
      }
      .avatar-uploader-icon {
        font-size: 15px;
        color: #8c939d;
      }
      .otherAvatar {
        width: 96px;
        height: 96px;
      }
    }
  }
  .footerBtn {
    margin: 50px 0px;
  }
  .otherForm {
    .el-input {
      width: 266px;
    }
  }
  .otherInfo {
    margin-top: 60px;
  }
  ::-webkit-input-placeholder {
    /* WebKit, Blink, Edge */
    font-size: 12px;
  }
  :-moz-placeholder {
    /* Mozilla Firefox 4 to 18 */
    font-size: 12px;
  }
  ::-moz-placeholder {
    /* Mozilla Firefox 19+ */
    font-size: 12px;
  }
  :-ms-input-placeholder {
    /* Internet Explorer 10-11 */
    font-size: 12px;
  }
  .curtomer {
    color: rgba(200, 200, 200, 1);
    font-size: 13px;
  }
  .licensesInfo {
    padding: 30px 69px 20px 137px;
    .el-select {
      width: 100%;
    }
  }
  .kernelInfo {
    padding: 0px 77px 0px 80px;
  }
  .basicInfo {
    padding: 30px 0 20px 87px;
  }
  .step {
    padding: 30px 0px 0px 0px;
  }
  .mr {
    margin-right: 10px;
  }
  .el-table__empty-block {
    min-height: 33px;
  }
  .license {
    //  .el-table th.is-leaf, .el-table td{
    //      border:unset !important;
    //    }
    .el-input__inner {
      width: 159px;
    }

    .el-date-editor.el-input,
    .el-date-editor.el-input__inner {
      text-align: center;
      width: 159px;
    }
    //  .el-input__prefix{
    //    left:30px;
    //  }
    //  .el-input__suffix{
    //    right:35px;
    //  }
    .avatarImg {
      margin-left: unset;
      width: 37px;
      height: 37px;
    }
    .avatarImg .el-upload {
      // border: 1px dashed #d9d9d9;
      border-radius: unset;
      cursor: pointer;
      // position: relative;
      // overflow: hidden;
      display: inline-block;
      vertical-align: middle;
    }
    .avatarImg .avatar-uploader-icon {
      border: 1px solid #eee;
      font-size: 15px;
      color: #8c939d;
      width: 35px;
      height: 35px;
      line-height: 35px;
      text-align: center;
    }
    .avatarImg .avatar {
      width: 37px;
      height: 37px;
      // border-radius: 5px;
      display: inline-block;
    }
  }
  .el-table__empty-text {
    min-height: 33px;
    line-height: 33px;
  }
  .footer {
    background: rgba(236, 252, 242, 1);
    border: 1px solid rgba(65, 215, 135, 1);
    border-radius: 4px;
  }
  .businessType {
    .el-input__inner {
      width: 100%;
    }
  }
  .investorCertification-header {
    color: #333;
    background-color: #fff;
    padding: 17px;
    margin-bottom: 14px;
    font-size: 13px;
    border-radius: 5px;
  }
  .el-table__header {
    border-right: 1px solid rgba(65, 215, 135, 1);
    border-left: 1px solid rgba(65, 215, 135, 1);
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
    border: none;
  }
  .el-table th {
    width: 750px;
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
  .orgCode {
    .el-form-item__label {
      line-height: 20px;
      width: 140px;
      // height: px;
    }
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
  }
  .address {
    .el-input--suffix .el-input__inner {
      width: 150px;
    }
    .el-select {
      width: unset;
    }
    .el-input{
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
  .avatarImg {
    width: 100px;
    height: 100px;
    margin-left: 110px;
  }
  .avatarImg .el-upload {
    // border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    display: inline-block;
    vertical-align: middle;
  }
  .avatarImg .avatar-uploader-icon {
    border: 2px dashed #eee;
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatarImg .avatar {
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
      margin-left: 40px;
      margin-top: 13px;
      line-height: 20px;
    }
  }
}
</style>

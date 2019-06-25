<template>
  <div class="addForm">

    <div class="head-basic">
      <div class="head-left-btn">
        <el-button @click="cancel">返回</el-button>
      </div>
      <div class="head-left">
        <img v-if="addForm.employeePortrait" :src="addForm.employeePortrait" class="avatar2">
      </div>

      <div class="head-right">
        <p v-if="!addForm.name">----</p>
        <p v-else>{{ addForm.name }}</p>
        <hr style="color:white;width:100%">
        <p>部门：{{ addForm.departmentName }}</p>
        <p>入职日期：{{ addForm.entryDate }}</p>
        <p>司龄：{{ companyYear }} 年</p>
      </div>

    </div>

    <div class="form-content">

      <el-form ref="addForm" :model="addForm" label-width="140px" style="margin-top:20px;">

        <div class="basic-info">
          <div>基础信息</div>
        </div>
        <hr class="con-hr">

        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：" prop="name">
              <el-input v-model="addForm.name" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="部门：" prop="departmentId">
              <el-cascader
                ref="departRef"
                :options="departmentList"
                v-model="currentDepartmentIds"
                change-on-select
                placeholder="请选择"
                disabled
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="职级：" prop="jobId">
              <el-select
                v-model="addForm.jobId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="岗位：" prop="postId">
              {{ addForm.postName }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="证件类型：" prop="certificateId">
              <el-select
                v-model="addForm.certificateId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in certificateList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="证件号：" prop="certificateNumber">
              <el-input
                v-model="addForm.certificateNumber"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工号：" prop="jobNumber">
              <el-input
                v-model="addForm.jobNumber"
                disabled
                style="width: 200px"
                placeholder=""
                clearable
              />
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="手机号码：" prop="phone">
              <el-input v-model="addForm.phone" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="合同类型：" prop="contractId">
              <el-select
                v-model="addForm.contractId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in contractList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="员工类型：" prop="employeeType">
              <el-select
                v-model="addForm.employeeType"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="正式" value="1"/>
                <el-option label="实习生" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="入职日期：" prop="entryDate">
              <el-date-picker
                v-model="addForm.entryDate"
                :picker-options="pickerOptions"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px"
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="性别：" prop="sex">
              <el-select
                v-model="addForm.sex"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="男" value="1"/>
                <el-option label="女" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="出生日期：" prop="birthDate">
              <el-date-picker
                v-model="addForm.birthDate"
                type="date"
                placeholder="选择日期"
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px"
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="国籍：" prop="nationalityId">
              <el-select
                v-model="addForm.nationalityId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in nationalityList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工作地址：" prop="workAddress" disabled>
              <el-input v-model="addForm.workAddress" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="联系地址：" prop="contactAddress" disabled>
              <el-input v-model="addForm.contactAddress" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="员工状态：" prop="employStatus" disabled>
              <el-select
                v-model="addForm.employStatus"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="在职" value="1"/>
                <el-option label="医疗期" value="2"/>
                <el-option label="退休" value="3"/>
                <el-option label="离职" value="4"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="用户账号：" prop="userAccount">
              <el-input v-model="addForm.userAccount" style="width: 200px" placeholder="请输入用户账号" clearable disabled/>
            </el-form-item>
          </el-col>

        </el-row>

        <div class="sub-basic-info">
          <div class="line-green"/>
          <div style="float:left">合同信息</div>
        </div>

        <el-row>
          <el-col :span="12">
            <el-form-item label="当前合同起始日：" prop="startCurrent">
              <el-date-picker
                v-model="addForm.startCurrent"
                type="date"
                placeholder="选择日期："
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px"
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="当前合同截止日：" prop="endCurrent">
              <el-date-picker
                v-model="addForm.endCurrent"
                type="date"
                placeholder="选择日期："
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px"
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工作邮箱：" prop="workMailbox">
              <el-input
                v-model="addForm.workMailbox"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工作电话：" prop="workPhone">
              <el-input v-model="addForm.workPhone" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="试用到期日：" prop="expirationDate">
              <el-date-picker
                v-model="addForm.expirationDate"
                type="date"
                placeholder="选择日期："
                value-format="yyyy-MM-dd HH:mm:ss"
                style="width: 200px"
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="试用期：" prop="probationPeriod">
              <el-input
                v-model="addForm.probationPeriod"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <div class="sub-basic-info">
          <div class="line-green"/>
          <div style="float:left">员工信息</div>
        </div>

        <el-row>
          <el-col :span="12">
            <el-form-item label="证件姓名：" prop="certificateName">
              <el-input
                v-model="addForm.certificateName"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="民族：" prop="nation">
              <el-input v-model="addForm.nation" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="户口类型：" prop="registeredType">
              <el-select
                v-model="addForm.registeredType"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="城市" value="1"/>
                <el-option label="农村" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="户口所在地：" prop="registeredResidence">
              <el-input
                v-model="addForm.registeredResidence"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="籍贯：" prop="nativePlace">
              <el-input
                v-model="addForm.nativePlace"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="居住地址：" prop="residentialAddress">
              <el-input
                v-model="addForm.residentialAddress"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="最高学历：" prop="highestAcademic">
              <el-select
                v-model="addForm.highestAcademic"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in academicList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="政治面貌：" prop="politicalOutlook">
              <el-select
                v-model="addForm.politicalOutlook"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="党员" value="1"/>
                <el-option label="团员" value="2"/>
                <el-option label="其他" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="婚姻状态：" prop="maritalStatus">
              <el-select
                v-model="addForm.maritalStatus"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option label="未婚" value="1"/>
                <el-option label="已婚" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="紧急联系人姓名：" prop="emergencyContactName">
              <el-input
                v-model="addForm.emergencyContactName"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="紧急联系人电话：" prop="emergencyContactPhone">
              <el-input
                v-model="addForm.emergencyContactPhone"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="QQ：" prop="qq">
              <el-input v-model="addForm.qq" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="微信：" prop="wechat">
              <el-input v-model="addForm.wechat" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="个人邮箱：" prop="mailbox">
              <el-input v-model="addForm.mailbox" style="width: 200px" placeholder="" clearable disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <div class="basic-info">
          <div>教育经历</div>
        </div>
        <hr class="con-hr">

        <ul>
          <li v-for="(itemEducation,indexEducation) in addForm.educationExperienceList" :key="indexEducation">
            <div class="sub-basic-info">
              <div v-if="indexEducation>0" class="delete-btn"/>
              <hr style="color:#DCDDDC">
              <div class="line-green"/>
              <div v-if="indexEducation==0" style="float:left">默认分组</div>
            </div>
            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.school'"
                  label="学校："
                >
                  <el-input
                    v-model="addForm.educationExperienceList[indexEducation].school"
                    style="width: 200px"
                    placeholder=""
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="专业：" prop="major">
                  <el-input
                    v-model="addForm.educationExperienceList[indexEducation].major"
                    style="width: 200px"
                    placeholder=""
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.admissionTime'"
                  label="入校时间："
                >
                  <el-date-picker
                    v-model="addForm.educationExperienceList[indexEducation].admissionTime"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.completionTime'"
                  label="结业时间："
                >
                  <el-date-picker
                    v-model="addForm.educationExperienceList[indexEducation].completionTime"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="学历：" prop="educationCode">
                  <el-select
                    v-model="addForm.educationExperienceList[indexEducation].educationCode"
                    placeholder="请选择"
                    clearable
                    style="width: 200px"
                    class="filter-item"
                    disabled>
                    <el-option label="请选择" value=""/>
                    <el-option v-for="item in academicList" :key="item.key" :label="item.lable" :value="item.key"/>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="是否取得学位：" prop="isAcademicDegree" disabled>
                  <el-radio-group v-model="addForm.educationExperienceList[indexEducation].isAcademicDegree" disabled>
                    <el-radio :label="1">是</el-radio>
                    <el-radio :label="2">否</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="教育证书照1：" prop="certificateEducaUrlOne">
                  <img
                    v-if="addForm.educationExperienceList[indexEducation].certificateEducaUrlOne"
                    :src="addForm.educationExperienceList[indexEducation].certificateEducaUrlOne"
                    class="avatar">
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="教育证书照2：" prop="certificateEducaUrlTwo">
                  <img
                    v-if="addForm.educationExperienceList[indexEducation].certificateEducaUrlTwo"
                    :src="addForm.educationExperienceList[indexEducation].certificateEducaUrlTwo"
                    class="avatar">
                </el-form-item>
              </el-col>
            </el-row>
          </li>
        </ul>

        <div class="basic-info">
          <div>工作经历</div>
        </div>
        <hr class="con-hr">

        <ul>
          <li v-for="(workExperience,indexEducation) in addForm.workExperienceList" :key="indexEducation">
            <div class="sub-basic-info">
              <div v-if="indexEducation>0" class="delete-btn"/>
              <hr style="color:#DCDDDC">
              <div class="line-green"/>
              <div v-if="indexEducation==0" style="float:left">默认分组</div>
            </div>
            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.corporateName'"
                  label="公司名称："
                >
                  <el-input
                    v-model="addForm.workExperienceList[indexEducation].corporateName"
                    style="width: 200px"
                    placeholder=""
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.assumeOffice'"
                  label="担任职位："
                >
                  <el-input
                    v-model="addForm.workExperienceList[indexEducation].assumeOffice"
                    style="width: 200px"
                    placeholder=""
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.entryDate'"
                  label="入职日期："
                >
                  <el-date-picker
                    v-model="addForm.workExperienceList[indexEducation].entryDate"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.leaveDate'"
                  label="离职日期："
                >
                  <el-date-picker
                    v-model="addForm.workExperienceList[indexEducation].leaveDate"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="职位描述：" prop="jobDescription">
                  <el-input
                    v-model="addForm.workExperienceList[indexEducation].jobDescription"
                    style="width: 200px"
                    placeholder=""
                    clearable
                    disabled/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.workType'"
                  label="类型："
                >
                  <el-radio-group v-model="addForm.workExperienceList[indexEducation].workType" disabled>
                    <el-radio :label="1" disabled>社会实践</el-radio>
                    <el-radio :label="2" disabled>工作经历</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

          </li>
        </ul>

        <div class="basic-info">
          <div>社保福利</div>
        </div>
        <hr class="con-hr">

        <el-row>
          <el-col :span="12">
            <el-form-item label="工资开户行：" prop="salaryBank">
              <el-input
                v-model="addForm.socialSecurity.salaryBank"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工资卡号：" prop="salaryNumber">
              <el-input
                v-model="addForm.socialSecurity.salaryNumber"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="公积金账号：" prop="providentFundAccount">
              <el-input
                v-model="addForm.socialSecurity.providentFundAccount"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="公积金缴纳地：" prop="providentFundPayment">
              <el-input
                v-model="addForm.socialSecurity.providentFundPayment"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="社保账号：" prop="socialSecurityAccount">
              <el-input
                v-model="addForm.socialSecurity.socialSecurityAccount"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="社保缴纳地：" prop="socialSecurityPayment">
              <el-input
                v-model="addForm.socialSecurity.socialSecurityPayment"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <div class="basic-info">
          <div>荣誉墙</div>
        </div>
        <hr class="con-hr">

        <ul>
          <li v-for="(honorWall,indexEducation) in addForm.honorWallList" :key="indexEducation">
            <div class="sub-basic-info">
              <div v-if="indexEducation>0" class="delete-btn">
                <i class="el-icon-delete" @click="deleteHonorWall(indexEducation)"/>
              </div>
              <hr style="color:#DCDDDC">
              <div class="line-green"/>
              <div v-if="indexEducation==0" style="float:left">默认分组</div>
            </div>
            <el-row>
              <el-col :span="12">
                <el-form-item label="图片：" prop="honoraryPictures">
                  <img
                    v-if="addForm.honorWallList[indexEducation].honoraryPictures"
                    :src="addForm.honorWallList[indexEducation].honoraryPictures"
                    class="avatar">
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="文件：" prop="honoraryFile">
                  <div v-if="addForm.honorWallList[indexEducation].honoraryFile" class="file-download">
                    <a :href="addForm.honorWallList[indexEducation].honoraryFile" target="_blank">下载</a>
                  </div>
                </el-form-item>
              </el-col>
            </el-row>
          </li>

        </ul>

        <div class="sub-basic-info">
          <div class="line-green"/>
          <div style="float:left">直属领导</div>
        </div>

        <el-row>
          <el-col :span="12">
            <el-form-item label="职级：" prop="directLeaderLevel">
              <el-select
                v-model="addForm.directlyLeader.directLeaderLevel"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item"
                disabled>
                <el-option label="请选择" value=""/>
                <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="岗位：" prop="directLeadership">
              {{ addForm.directlyLeader.directLeadershipName }}
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：" prop="directLeaderName">
              <el-input
                v-model="addForm.directlyLeader.directLeaderName"
                style="width: 200px"
                placeholder=""
                clearable
                disabled/>
            </el-form-item>
          </el-col>
        </el-row>

        <div class="bottom-btn">
          <el-button @click="cancel">返回</el-button>
        </div>

      </el-form>

    </div>

  </div>

</template>

<script>

import {
  getEmployeeBasicInfo
} from '@/api/hr/employeeBasicInfo'
import {
  getCode, setChild, findNodeById, findP
} from '@/api/hr/util'

import {
  api
} from '@/api/axios'

export default {
  data() {
    return {
      nodes: [],
      pNodes: [],
      currentDepartmentIds: [],
      departmentOptions: [],
      departmentListLoading: false,
      departmentList: [],
      jobList: [],
      postList: [],
      certificateList: [],
      contractList: [],
      nationalityList: [],
      academicList: [],
      pickerOptions: {
        shortcuts: [{
          text: '今天',
          onClick(picker) {
            picker.$emit('pick', new Date())
          }
        }, {
          text: '昨天',
          onClick(picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24)
            picker.$emit('pick', date)
          }
        }, {
          text: '一周前',
          onClick(picker) {
            const date = new Date()
            date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', date)
          }
        }]
      },
      title: '员工花名册详情',
      addForm: {
        employStatus: '',
        employeePortrait: '',
        name: '',
        departmentId: '',
        departmentName: '',
        jobId: '',
        jobName: '',
        postId: '',
        postName: '',
        certificateId: '',
        certificateType: '',
        certificateNumber: '',
        jobNumber: '',
        userAccount: '',
        userId: '',
        phone: '',
        contractId: '',
        contractName: '',
        employeeType: '',
        entryDate: '',
        sex: '',
        birthDate: '',
        nationalityId: '',
        nationalityName: '',
        workAddress: '',
        contactAddress: '',
        startCurrent: '',
        endCurrent: '',
        workMailbox: '',
        workPhone: '',
        expirationDate: '',
        probationPeriod: '',
        certificateName: '',
        nation: '',
        registeredType: '',
        registeredResidence: '',
        nativePlace: '',
        residentialAddress: '',
        highestAcademic: '',
        politicalOutlook: '',
        maritalStatus: '',
        emergencyContactName: '',
        emergencyContactPhone: '',
        qq: '',
        wechat: '',
        mailbox: '',
        educationExperienceList: [{
          school: '',
          major: '',
          admissionTime: '',
          completionTime: '',
          educationCode: '',
          educationName: '',
          isAcademicDegree: '',
          certificateEducaUrlOne: '',
          certificateEducaUrlTwo: '',
          jobNumber: ''
        }],
        workExperienceList: [
          {
            corporateName: '',
            assumeOffice: '',
            entryDate: '',
            leaveDate: '',
            jobDescription: '',
            workType: '',
            jobNumber: ''
          }
        ],
        honorWallList: [
          {
            honoraryPictures: '',
            honoraryFile: '',
            jobNumber: ''
          }
        ],
        directlyLeader: {
          id: '',
          jobNumber: '',
          directLeaderLevel: '',
          directLeaderLevelName: '',
          directLeadership: '',
          directLeadershipName: '',
          directLeaderName: ''
        },
        socialSecurity: {
          id: '',
          jobNumber: '',
          salaryBank: '',
          salaryNumber: '',
          providentFundAccount: '',
          providentFundPayment: '',
          socialSecurityAccount: '',
          socialSecurityPayment: ''
        }
      }
    }
  },
  computed: {
    companyYear() {
      if (this.addForm.workExperienceList.length > 0) {
        const startDateArr = this.addForm.workExperienceList.filter(item => {
          return item.entryDate && item.leaveDate
        }).map(item => item.entryDate)
        const endDateArr = this.addForm.workExperienceList.filter(item => {
          return item.entryDate && item.leaveDate
        }).map(item => item.leaveDate)
        startDateArr.sort((a, b) => {
          return new Date(a).getTime() - new Date(b).getTime()
        })
        endDateArr.sort((a, b) => {
          return new Date(a).getTime() - new Date(b).getTime()
        })
        const diff = new Date(endDateArr[endDateArr.length - 1]).getTime() - new Date(startDateArr[0]).getTime()
        const diffYear = diff / 1000 / 86400 / 365
        return diffYear < 0 ? 0 : parseInt(diffYear)
      } else {
        return 0
      }
    }

  },
  watch: {},
  created() {

  },
  mounted() {
    this.initJobList()
    this.initCertificateList()
    this.initContractList()
    this.initNationalityList()
    this.initAcademicList()
    this.initDetail()
  },
  methods: {
    cancel() {
      this.$router.push('employeeBasicInfoList')
    },
    initJobList() {
      getCode({ 'groupCode': 'job', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr' }).then(res => {
        if (res.data.code === '0000') {
          this.jobList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initCertificateList() {
      getCode({
        'groupCode': 'certificate_type',
        'parentGroupCode': 'employee',
        'moduleCode': 'springcloud_hr'
      }).then(res => {
        if (res.data.code === '0000') {
          this.certificateList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initContractList() {
      getCode({
        'groupCode': 'contract',
        'parentGroupCode': 'employee',
        'moduleCode': 'springcloud_hr'
      }).then(res => {
        if (res.data.code === '0000') {
          this.contractList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initNationalityList() {
      getCode({
        'groupCode': 'nationality',
        'parentGroupCode': 'employee',
        'moduleCode': 'springcloud_hr'
      }).then(res => {
        if (res.data.code === '0000') {
          this.nationalityList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initAcademicList() {
      getCode({
        'groupCode': 'education',
        'parentGroupCode': 'employee',
        'moduleCode': 'springcloud_hr'
      }).then(res => {
        if (res.data.code === '0000') {
          this.academicList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initDetail() {
      var query = this.$route.query
      this.title = query.title
      if (query.id) {
        this.addForm.fileId = query.fileId
        getEmployeeBasicInfo(query.id).then(res => {
          if (res.data.code === '0000') {
            this.addForm = Object.assign({}, res.data.data)
            this.getAllDepartment()
            if (!this.addForm.socialSecurity) {
              this.addForm.socialSecurity = {
                id: '',
                jobNumber: '',
                salaryBank: '',
                salaryNumber: '',
                providentFundAccount: '',
                providentFundPayment: '',
                socialSecurityAccount: '',
                socialSecurityPayment: ''
              }
            }
            if (!this.addForm.directlyLeader) {
              this.addForm.directlyLeader = {
                id: '',
                jobNumber: '',
                directLeaderLevel: '',
                directLeaderLevelName: '',
                directLeadership: '',
                directLeadershipName: '',
                directLeaderName: ''
              }
            }
            this.addForm.employStatus = res.data.data.employStatus + ''
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
    },
    getAllDepartment() {
      this.departmentListLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysDepartment/findDepartmentAllByLevel`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentList = res.data.data
          setChild(this.nodes, this.departmentList)
          const currNode = findNodeById(this.nodes, this.addForm.departmentId)
          this.pNodes.push(currNode)
          findP(this.nodes, currNode, this.pNodes)
          this.pNodes.reverse()
          const arr = []
          this.pNodes.forEach(item => {
            arr.push(item.id)
          })
          this.currentDepartmentIds = arr
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    }
  }
}
</script>

<style lang="less">

  .addForm {
    font-family: "Microsoft YaHei";
  }

  .head-basic {
    width: 100%;
    height: 300px;
    position: relative;
    background: #66b1ff;
    .head-left-btn {
      margin-left: 30px;
      padding-top: 20px;
    }
    .head-left {
      width: 180px;
      margin-left: 30px;
      margin-right: 30px;
      padding-top: 15px;
      float: left;
    }

    .avatar-uploader2 {
      width: 180px;
      height: 180px;
    }
    .avatar-uploader2 .el-upload {
      border: 1px dashed #d9d9d9;
      border-radius: 50%;
      -webkit-border-radius: 50%;
      -moz-border-radius: 50%;
      cursor: pointer;
      position: relative;
      overflow: hidden;
    }
    .avatar-uploader2 .el-upload:hover {
      border-color: #409EFF;
    }
    .avatar-uploader2-icon {
      font-size: 28px;
      color: #8c939d;
      width: 180px;
      height: 180px;
      line-height: 180px;
      text-align: center;
      background-color: white;
    }
    .avatar2 {
      width: 180px;
      height: 180px;
      display: block;
      border-radius: 50%;
      -webkit-border-radius: 50%;
      -moz-border-radius: 50%;
    }

    .head-right {
      width: 50%;
      float: left;
      p {
        color: white;
        font-family: "Microsoft YaHei";
        font-weight: bold;
        font-size: 16px;
      }
    }
  }

  .head-bottom {
    height: 140px;
  }

  .head-bottom span {
    display: block;
    height: 20px;
    margin-top: 20px;
    margin-left: 30px;
    line-height: 20px;
    color: white;
    font-family: Arial, sans-serif;
    font-size: 16px;
  }

  .form-content {
    background-color: white;
    border-radius: 10px;
    .con-hr {
      color: #e4e4e4;
      margin-left: 20px;
      margin-bottom: 20px;
    }
  }

  .form-content .basic-info {
    height: 30px;
    margin-left: 20px;
    margin-top: 20px;
  }

  .form-content .basic-info div {
    float: left;
    font-size: 18px;
    color: #c3c3c3;
    font-weight: bold;
    font-family: Arial, sans-serif;
    height: 20px;
    line-height: 20px;

  }

  .form-content .sub-basic-info {
    height: 20px;
    margin: 30px 30px;
    position: relative;
    .line-green {
      width: 5px;
      height: 20px;
      background: #8cbda4;
      margin-right: 10px;
      float: left;
    }
    div {
      font-size: 16px;
      height: 20px;
      margin-left: 2px;
    }
    .delete-btn {
      margin-top: 5px;
      position: absolute;
      right: 4px;
      i {
        font-size: 20px;
      }
    }

  }

  .el-form-item {
    margin-left: 20px;
  }

  .avatar-uploader {
    width: 120px;
    height: 120px;
  }

  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }

  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }

  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 120px;
    height: 120px;
    line-height: 120px;
    text-align: center;
  }

  .avatar {
    width: 120px;
    height: 120px;
    display: block;
  }

  .add-btn {
    background-color: #eaf8f5;
    text-align: center;
    height: 40px;
    line-height: 40px;
    color: #85dbda;
    font-weight: bold;
    margin-left: 72px;
    margin-right: 72px;
    :hover {
      cursor: pointer;
    }
  }

  .bottom-btn {
    margin-bottom: 40px;
    text-align: center
  }
  .file-download a:hover{
    color:red;
  }
  .addForm{
    height:100%;
  }

</style>

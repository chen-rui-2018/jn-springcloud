<template>
  <div class="addForm">

    <div class="head-basic">
      <div class="head-left-btn">
        <el-button @click="cancel">返回</el-button>
      </div>
      <div class="head-left">
        <el-upload
          :action="fileUrl"
          :headers="importHeaders"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeImageUpload"
          class="avatar-uploader2">
          <img v-if="addForm.employeePortrait" :src="addForm.employeePortrait" class="avatar2">
          <i v-else class="el-icon-plus avatar-uploader2-icon"/>
        </el-upload>
      </div>

      <div class="head-right">
        <p v-if="!addForm.name">----</p>
        <p v-else>{{ addForm.name }}</p>
        <hr style="color:white;width:100%">
        <p>部门：{{ addForm.departmentName }}</p>
        <p>入职日期：{{ addForm.entryDate }}</p>
        <p>司龄：{{ companyYear }}年</p>
      </div>

    </div>

    <div class="form-content">

      <el-form ref="addForm" :model="addForm" :rules="rules" label-width="140px" style="margin-top:20px;" validate-on-rule-change>

        <div class="basic-info">
          <div>基础信息</div>
        </div>
        <hr class="con-hr">

        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：" prop="name">
              <el-input v-model.trim="addForm.name" style="width: 200px" placeholder="" clearable/>
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
                clearable
                @change="handleChangeDepartment"
              />
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="职级：" prop="jobId">
              <el-select v-model="addForm.jobId" placeholder="请选择" clearable style="width: 200px" class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="岗位：" prop="postId">
              <el-select v-model="addForm.postId" placeholder="请选择" clearable style="width: 200px" class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in postList" :key="item.id" :label="item.postName" :value="item.id"/>
              </el-select>
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
                @change="setCertificateType">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in certificateList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="证件号：" prop="certificateNumber">
              <el-input
                v-model.trim="addForm.certificateNumber"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工号：" prop="jobNumber">
              <el-input
                v-model.trim="addForm.jobNumber"
                disabled
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="手机号码：" prop="phone">
              <el-input v-model.trim="addForm.phone" style="width: 200px" placeholder="" clearable/>
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
                class="filter-item">
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
                class="filter-item">
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
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="性别：" prop="sex">
              <el-select
                v-model="addForm.sex"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
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
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="国籍：" prop="nationalityId">
              <el-select
                v-model="addForm.nationalityId"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in nationalityList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工作地址：" prop="workAddress">
              <el-input v-model.trim="addForm.workAddress" style="width: 200px" placeholder="" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="联系地址：" prop="contactAddress">
              <el-input v-model.trim="addForm.contactAddress" style="width: 200px" placeholder="" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="员工状态：" prop="employStatus">
              <el-select
                v-model="addForm.employStatus"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
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
              <el-input
                v-model.trim="addForm.userAccount"
                :disabled="true"
                style="width: 200px"
                placeholder="请输入用户账号"
                clearable/>
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
                clearable/>
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
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="工作邮箱：" prop="workMailbox">
              <el-input
                v-model.trim="addForm.workMailbox"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工作电话：" prop="workPhone">
              <el-input v-model.trim="addForm.workPhone" style="width: 200px" placeholder="" clearable/>
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
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="试用期：" prop="probationPeriod">
              <el-input-number v-model.trim="addForm.probationPeriod" :min="0" :max="12" label="" style="width: 200px"/>
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
                v-model.trim="addForm.certificateName"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="民族：" prop="nation">
              <el-input v-model.trim="addForm.nation" style="width: 200px" placeholder="" clearable/>
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
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option label="城市" value="1"/>
                <el-option label="农村" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="户口所在地：" prop="registeredResidence">
              <el-input
                v-model.trim="addForm.registeredResidence"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="籍贯：" prop="nativePlace">
              <el-input
                v-model.trim="addForm.nativePlace"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="居住地址：" prop="residentialAddress">
              <el-input
                v-model.trim="addForm.residentialAddress"
                style="width: 200px"
                placeholder=""
                clearable/>
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
                class="filter-item">
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
                class="filter-item">
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
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option label="未婚" value="1"/>
                <el-option label="已婚" value="2"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="紧急联系人姓名：" prop="emergencyContactName">
              <el-input
                v-model.trim="addForm.emergencyContactName"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="紧急联系人电话：" prop="emergencyContactPhone">
              <el-input
                v-model.trim="addForm.emergencyContactPhone"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="QQ：" prop="qq">
              <el-input v-model.trim="addForm.qq" style="width: 200px" placeholder="" clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="微信：" prop="wechat">
              <el-input v-model.trim="addForm.wechat" style="width: 200px" placeholder="" clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="个人邮箱：" prop="mailbox">
              <el-input v-model.trim="addForm.mailbox" style="width: 200px" placeholder="" clearable/>
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
              <div v-if="indexEducation>0" class="delete-btn"><i
                class="el-icon-delete"
                @click="deleteEducation(indexEducation)"/></div>
              <hr style="color:#DCDDDC">
              <div class="line-green"/>
              <div v-if="indexEducation==0" style="float:left">默认分组</div>
            </div>
            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.school'"
                  :rules="{required: true, message: '请输入学校', trigger: 'blur'}"
                  label="学校：">
                  <el-input
                    v-model.trim="addForm.educationExperienceList[indexEducation].school"
                    style="width: 200px"
                    placeholder=""
                    clearable/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="专业：" prop="major">
                  <el-input
                    v-model.trim="addForm.educationExperienceList[indexEducation].major"
                    style="width: 200px"
                    placeholder=""
                    clearable/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.admissionTime'"
                  :rules="{required: true, message: '请输入入校时间', trigger: 'blur'}"
                  label="入校时间：">
                  <el-date-picker
                    v-model="addForm.educationExperienceList[indexEducation].admissionTime"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'educationExperienceList.' + indexEducation + '.completionTime'"
                  :rules="{required: true, message: '请输入结业时间', trigger: 'blur'}"
                  label="结业时间：">
                  <el-date-picker
                    v-model="addForm.educationExperienceList[indexEducation].completionTime"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable/>
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
                    class="filter-item">
                    <el-option label="请选择" value=""/>
                    <el-option v-for="item in academicList" :key="item.key" :label="item.lable" :value="item.key"/>
                  </el-select>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="是否取得学位：" prop="isAcademicDegree">
                  <el-radio-group v-model="addForm.educationExperienceList[indexEducation].isAcademicDegree">
                    <el-radio :label="1">是</el-radio>
                    <el-radio :label="2">否</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="教育证书照1：" prop="certificateEducaUrlOne">
                  <el-upload
                    :ref="`certificateEducaUrlOne${indexEducation}`"
                    :action="fileUrl"
                    :headers="importHeaders"
                    :show-file-list="true"
                    :file-list="educationFileList1[`${indexEducation}`]"
                    :on-preview="handlePreview"
                    :limit="1"
                    :on-remove="(file, fileList)=>handleEducaRemove( file, fileList,indexEducation,'certificateEducaUrlOne')"
                    :on-success="(response, file, fileList)=>handleEducaSuccess(response, file, fileList,indexEducation,'certificateEducaUrlOne')"
                    :before-upload="(file)=>beforeEducaUpload(file,indexEducation,'certificateEducaUrlOne')"
                    class="avatar-uploader">
                    <img
                      v-if="addForm.educationExperienceList[indexEducation].certificateEducaUrlOne"
                      :src="addForm.educationExperienceList[indexEducation].certificateEducaUrlOne"
                      class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"/>
                  </el-upload>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="教育证书照2：" prop="certificateEducaUrlTwo">
                  <el-upload
                    :ref="`certificateEducaUrlTwo${indexEducation}`"
                    :action="fileUrl"
                    :headers="importHeaders"
                    :show-file-list="true"
                    :file-list="educationFileList2[`${indexEducation}`]"
                    :on-preview="handlePreview"
                    :limit="1"
                    :on-remove="(file, fileList)=>handleEducaRemove( file, fileList,indexEducation,'certificateEducaUrlTwo')"
                    :on-success="(response, file, fileList)=>handleEducaSuccess(response, file, fileList,indexEducation,'certificateEducaUrlTwo')"
                    :before-upload="(file)=>beforeEducaUpload(file,indexEducation,'certificateEducaUrlTwo')"
                    class="avatar-uploader">
                    <img
                      v-if="addForm.educationExperienceList[indexEducation].certificateEducaUrlTwo"
                      :src="addForm.educationExperienceList[indexEducation].certificateEducaUrlTwo"
                      class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"/>
                  </el-upload>
                </el-form-item>
              </el-col>
            </el-row>
          </li>
        </ul>

        <div class="add-btn">
          <i class="el-icon-plus" @click="addEducation()">添加教育经历</i>
        </div>

        <div class="basic-info">
          <div>工作经历</div>
        </div>
        <hr class="con-hr">

        <ul>
          <li v-for="(workExperience,indexEducation) in addForm.workExperienceList" :key="indexEducation">
            <div class="sub-basic-info">
              <div v-if="indexEducation>0" class="delete-btn"><i
                class="el-icon-delete"
                @click="deleteWorkExperience(indexEducation)"/>
              </div>
              <hr style="color:#DCDDDC">
              <div class="line-green"/>
              <div v-if="indexEducation==0" style="float:left">默认分组</div>
            </div>
            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.corporateName'"
                  :rules="{required: true, message: '请输入公司名称', trigger: 'blur'}"
                  label="公司名称：">
                  <el-input
                    v-model.trim="addForm.workExperienceList[indexEducation].corporateName"
                    style="width: 200px"
                    placeholder=""
                    clearable/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.assumeOffice'"
                  :rules="{required: true, message: '请输入担任职位', trigger: 'blur'}"
                  label="担任职位：">
                  <el-input
                    v-model.trim="addForm.workExperienceList[indexEducation].assumeOffice"
                    style="width: 200px"
                    placeholder=""
                    clearable/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.entryDate'"
                  :rules="{required: true, message: '请输入入职日期', trigger: 'blur'}"
                  label="入职日期：">
                  <el-date-picker
                    v-model="addForm.workExperienceList[indexEducation].entryDate"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.leaveDate'"
                  :rules="{required: true, message: '请输入离职日期', trigger: 'blur'}"
                  label="离职日期：">
                  <el-date-picker
                    v-model="addForm.workExperienceList[indexEducation].leaveDate"
                    type="date"
                    placeholder="选择日期："
                    value-format="yyyy-MM-dd HH:mm:ss"
                    style="width: 200px"
                    clearable/>
                </el-form-item>
              </el-col>
            </el-row>

            <el-row>
              <el-col :span="12">
                <el-form-item label="职位描述：" prop="jobDescription">
                  <el-input
                    v-model.trim="addForm.workExperienceList[indexEducation].jobDescription"
                    style="width: 200px"
                    placeholder=""
                    clearable/>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item
                  :prop="'workExperienceList.' + indexEducation + '.workType'"
                  :rules="{required: true, message: '请选择类型', trigger: 'change'}"
                  label="类型：">
                  <el-radio-group v-model="addForm.workExperienceList[indexEducation].workType">
                    <el-radio :label="1">社会实践</el-radio>
                    <el-radio :label="2">工作经历</el-radio>
                  </el-radio-group>
                </el-form-item>
              </el-col>
            </el-row>

          </li>
        </ul>

        <div class="add-btn">
          <i class="el-icon-plus" @click="addWorkExperience()">添加工作经历</i>
        </div>

        <div class="basic-info">
          <div>社保福利</div>
        </div>
        <hr class="con-hr">

        <el-row>
          <el-col :span="12">
            <el-form-item label="工资开户行：" prop="salaryBank">
              <el-input
                v-model.trim="addForm.socialSecurity.salaryBank"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="工资卡号：" prop="salaryNumber">
              <el-input
                v-model.trim="addForm.socialSecurity.salaryNumber"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="公积金账号：" prop="providentFundAccount">
              <el-input
                v-model.trim="addForm.socialSecurity.providentFundAccount"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="公积金缴纳地：" prop="providentFundPayment">
              <el-input
                v-model.trim="addForm.socialSecurity.providentFundPayment"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="社保账号：" prop="socialSecurityAccount">
              <el-input
                v-model.trim="addForm.socialSecurity.socialSecurityAccount"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="社保缴纳地：" prop="socialSecurityPayment">
              <el-input
                v-model.trim="addForm.socialSecurity.socialSecurityPayment"
                style="width: 200px"
                placeholder=""
                clearable/>
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
                  <el-upload
                    :ref="`honoraryPictures${indexEducation}`"
                    :action="fileUrl"
                    :headers="importHeaders"
                    :show-file-list="true"
                    :file-list="honorWallFileList1[`${indexEducation}`]"
                    :on-preview="handlePreview"
                    :limit="1"
                    :on-remove="(file, fileList)=>handleHonoraryRemove( file, fileList,indexEducation,'honoraryPictures')"
                    :on-success="(response, file, fileList)=>handleHonorarySuccess(response, file, fileList,indexEducation,'honoraryPictures')"
                    :before-upload="(file)=>beforeHonoraryUpload(file,indexEducation,'honoraryPictures')"
                    class="avatar-uploader">
                    <img
                      v-if="addForm.honorWallList[indexEducation].honoraryPictures"
                      :src="addForm.honorWallList[indexEducation].honoraryPictures"
                      class="avatar">
                    <i v-else class="el-icon-plus avatar-uploader-icon"/>
                  </el-upload>
                </el-form-item>
              </el-col>

              <el-col :span="12">
                <el-form-item label="文件：" prop="honoraryFile">
                  <el-upload
                    :ref="`honoraryFile${indexEducation}`"
                    :action="fileUrl"
                    :headers="importHeaders"
                    :show-file-list="true"
                    :file-list="honorWallFileList2[`${indexEducation}`]"
                    :on-preview="handlePreview"
                    :limit="1"
                    :on-remove="(file, fileList)=>handleHonoraryRemove( file, fileList,indexEducation,'honoraryFile')"
                    :on-success="(response, file, fileList)=>handleHonorarySuccess(response, file, fileList,indexEducation,'honoraryFile')"
                    :before-upload="(file)=>beforeHonoraryUpload(file,indexEducation,'honoraryFile')"
                    class="avatar-uploader">
                    <i class="el-icon-plus avatar-uploader-icon"/>
                  </el-upload>
                  <div class="el-upload__tip">单个文件不能超过8M，最多上传30个文件，最多上传100M</div>
                </el-form-item>
              </el-col>
            </el-row>
          </li>

        </ul>

        <div class="add-btn">
          <i class="el-icon-plus" @click="addHonorWall()">添加荣誉墙</i>
        </div>

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
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in jobList" :key="item.key" :label="item.lable" :value="item.key"/>
              </el-select>
            </el-form-item>
          </el-col>

          <el-col :span="12">
            <el-form-item label="岗位：" prop="directLeadership">
              <el-select
                v-model="addForm.directlyLeader.directLeadership"
                placeholder="请选择"
                clearable
                style="width: 200px"
                class="filter-item">
                <el-option label="请选择" value=""/>
                <el-option v-for="item in postList" :key="item.id" :label="item.postName" :value="item.id"/>
              </el-select>
            </el-form-item>
          </el-col>
        </el-row>

        <el-row>
          <el-col :span="12">
            <el-form-item label="姓名：" prop="directLeaderName">
              <el-input
                v-model.trim="addForm.directlyLeader.directLeaderName"
                style="width: 200px"
                placeholder=""
                clearable/>
            </el-form-item>
          </el-col>
        </el-row>

        <div class="bottom-btn">
          <el-button type="primary" @click="title==='新增员工花名册'?submitForm():updateData()">提交
          </el-button>
          <el-button @click="cancel">取消</el-button>
        </div>

      </el-form>

    </div>

  </div>

</template>

<script>
import store from '@/store'

import {
  api
} from '@/api/axios'

import {
  addEmployeeBasicInfo, updateEmployeeBasicInfo, getEmployeeBasicInfo
} from '@/api/hr/employeeBasicInfo'
import {
  getCode, isvalidName, isvalidMobile, isvalidPhone, setChild, findNodeById, findP, isvalidZjhm, getApi
} from '@/api/hr/util'
import { getToken } from '@/utils/auth'

export default {
  data() {
    var checkName = (rule, value, callback) => {
      if (!isvalidName(value)) {
        callback(new Error('姓名只允许数字、中文、字母及下划线'))
      } else {
        callback()
      }
    }
    const reg = /^\w{5,18}$/i
    const checkZjhm = (rule, value, callback) => {
      if (!reg.test(value)) {
        callback(new Error('请输入正确的证件号码'))
      } else {
        callback()
      }
    }
    const validMobile = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入手机号码'))
      } else if (!isvalidMobile(value)) {
        callback(new Error('请输入正确的11位手机号码'))
      } else {
        callback()
      }
    }
    const validPhone = (rule, value, callback) => {
      if (value && !isvalidPhone(value) && !isvalidMobile(value)) {
        callback(new Error('请输入正确的联系电话'))
      } else {
        callback()
      }
    }
    const chatReg = /^[a-zA-Z\d_]{5,}$/
    const validWechat = (rule, value, callback) => {
      if (value && value !== '' && !chatReg.test(value)) {
        callback(new Error('请输入正确的微信号'))
      } else {
        callback()
      }
    }

    var checkPhoneExist = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入号码'))
      } else {
        getApi('hr/employeeBasicInfo/checkPhoneExist', { phone: value, id: this.addForm.id }).then(res => {
          if (res.data && res.data.code === '0000' && !res.data.data) {
            callback(new Error('号码在员工花名册中已经存在'))
          } else {
            callback()
          }
        }).catch(error => {
          console.log(error)
          callback(new Error('校验号码是否存在员工花名册失败'))
        })
      }
    }
    var checkMailboxExist = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入邮箱'))
      } else {
        getApi('hr/employeeBasicInfo/checkMailboxExist', { mailbox: value, id: this.addForm.id }).then(res => {
          if (res.data && res.data.code === '0000' && !res.data.data) {
            callback(new Error('邮箱在员工花名册中已经存在'))
          } else {
            callback()
          }
        }).catch(error => {
          console.log(error)
          callback(new Error('校验邮箱是否存在员工花名册失败'))
        })
      }
    }
    var checkCertificateNumberExist = (rule, value, callback) => {
      if (!value) {
        callback(new Error('请输入证件号码'))
      } else {
        getApi('hr/employeeBasicInfo/checkCertificateNumberExist', { certificateNumber: value, id: this.addForm.id }).then(res => {
          if (res.data && res.data.code === '0000' && !res.data.data) {
            callback(new Error('证件号码在员工花名册中已经存在'))
          } else {
            callback()
          }
        }).catch(error => {
          console.log(error)
          callback(new Error('校验证件号码是否存在员工花名册失败'))
        })
      }
    }

    return {
      nodes: [],
      pNodes: [],
      currentDepartmentIds: [],
      departmentOptions: [],
      departmentListLoading: false,
      importHeaders: {
        enctype: 'multipart/form-data',
        token: getToken()
      },
      fileUrl: process.env.BASE_API + 'springcloud-hr/hr/common/uploadAttachment',
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
      title: '',
      isDisabled: false,
      rules: {
        name: [{ required: true, message: '请输入姓名', trigger: 'blur' }, { validator: checkName, trigger: 'blur' }],
        departmentId: [{ required: true, message: '请选择部门', trigger: 'change' }],
        jobId: [{ required: true, message: '请选择职级', trigger: 'change' }],
        postId: [{ required: true, message: '请选择岗位', trigger: 'change' }],
        certificateId: [{ required: true, message: '请选择证件类型', trigger: 'change' }],
        certificateNumber: [{ required: true, message: '请输入证件号码', trigger: 'blur' }, {
          validator: checkZjhm,
          trigger: 'blur'
        }, { validator: checkCertificateNumberExist, trigger: 'blur' }],
        phone: [{ required: true, message: '请输入手机号码', trigger: 'blur' }, { validator: validMobile, trigger: 'blur' },
          { validator: checkPhoneExist, trigger: 'blur' }],
        contractId: [{ required: true, message: '请选择合同类型', trigger: 'change' }],
        employeeType: [{ required: true, message: '请选择员工类型', trigger: 'change' }],
        entryDate: [{ required: true, message: '请输入入职日期', trigger: 'blur' }],
        sex: [{ required: true, message: '请选择性别', trigger: 'change' }],
        birthDate: [{ required: true, message: '请输入出生日期', trigger: 'blur' }],
        nationalityId: [{ required: true, message: '请选择国籍', trigger: 'change' }],
        employStatus: [{ required: true, message: '请选择员工状态', trigger: 'change' }],
        workAddress: [{ required: true, message: '请输入工作地址', trigger: 'blur' }],
        contactAddress: [{ required: true, message: '请输入联系工作地址', trigger: 'blur' }],
        startCurrent: [{ required: true, message: '请输入合同起始日', trigger: 'blur' }],
        endCurrent: [{ required: true, message: '请输入合同截止日', trigger: 'blur' }],
        workMailbox: [{ type: 'email', message: '请正确输入工作邮箱', trigger: 'blur' }],
        workPhone: [{ validator: validPhone, trigger: 'blur' }],
        expirationDate: [{ required: true, message: '请输入试用到期日', trigger: 'blur' }],
        mailbox: [{ type: 'email', message: '请正确输入个人邮箱', trigger: 'blur' },
          { validator: checkMailboxExist, trigger: 'blur' }],
        salaryNumber: [{ type: 'number', message: '请输入正确的工资卡号', trigger: 'blur' }],
        providentFundAccount: [{ type: 'number', message: '请输入正确的公积金账号', trigger: 'blur' }],
        socialSecurityAccount: [{ type: 'number', message: '请输入正确的社保账号', trigger: 'blur' }],
        wechat: [{ validator: validWechat, trigger: 'blur' }],
        emergencyContactPhone: [{ validator: validPhone, trigger: 'blur' }]
      },
      addForm: {
        id: '',
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
      },
      companyYear: 0,
      educationFileList1: [[]],
      educationFileList2: [[]],
      honorWallFileList1: [[]],
      honorWallFileList2: [[]]
    }
  },
  watch: {
    'addForm.workExperienceList': {
      handler(newValue, oldValue) {
        console.log('获取司龄')
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
          this.companyYear = diffYear < 0 ? 0 : parseInt(diffYear)
        } else {
          this.companyYear = 0
        }
      },
      deep: true
    },
    'addForm.certificateType': {
      handler(newValue, oldValue) {
        this.initCheckZjhm()
      },
      deep: true
    }
  },
  created() {

  },
  mounted() {
    this.initJobList()
    this.initPostList()
    this.initCertificateList()
    this.initContractList()
    this.initNationalityList()
    this.initAcademicList()
    this.getAllDepartment()
    this.initDetail()
  },
  methods: {
    setCertificateType() {
      const certificate = this.certificateList.find(item => item.key === this.addForm.certificateId)
      if (certificate) {
        this.addForm.certificateType = certificate['lable']
      }
    },
    initCheckZjhm() {
      const reg = /^\w{5,18}$/i
      if (this.addForm.certificateType === '身份证') {
        this.checkZjhm = (rule, value, callback) => {
          if (!isvalidZjhm(value)) {
            callback(new Error('请输入正确的证件号码'))
          } else {
            callback()
          }
        }
      } else {
        this.checkZjhm = (rule, value, callback) => {
          if (!reg.test(value)) {
            callback(new Error('请输入正确的证件号码'))
          } else {
            callback()
          }
        }
      }
      this.rules.certificateNumber.splice(1, 1, {
        validator: this.checkZjhm,
        trigger: 'blur'
      })
    },
    getAllDepartment() {
      this.departmentListLoading = true
      api(`${this.GLOBAL.systemUrl}system/sysDepartment/findDepartmentAllByLevel`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.departmentList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
        this.departmentListLoading = false
      })
    },
    handleChangeDepartment(value) {
      this.addForm.departmentId = this.currentDepartmentIds[this.currentDepartmentIds.length - 1]
      const arr = this.$refs['departRef'].currentLabels
      this.addForm.departmentName = arr[arr.length - 1]
    },
    setDepartmentInfo() {
      const depart = this.departmentList.find(item => item.departmentId === this.addForm.departmentId)
      if (depart) {
        this.addForm.departmentName = depart['departmentName']
      } else {
        this.addForm.departmentName = ''
      }
    },
    deleteHonorWall(index) {
      this.addForm.honorWallList.splice(index, 1)
    },
    addHonorWall() {
      if (this.addForm.honorWallList.length >= 30) {
        this.$message.warning('最多上传30个文件')
      }
      this.addForm.honorWallList.push({
        honoraryPictures: '',
        honoraryFile: '',
        jobNumber: ''
      })
    },
    deleteWorkExperience(index) {
      this.addForm.workExperienceList.splice(index, 1)
    },
    addWorkExperience() {
      this.addForm.workExperienceList.push({
        corporateName: '',
        assumeOffice: '',
        entryDate: '',
        leaveDate: '',
        jobDescription: '',
        workType: '',
        jobNumber: ''
      })
    },
    deleteEducation(index) {
      this.addForm.educationExperienceList.splice(index, 1)
    },
    addEducation() {
      this.addForm.educationExperienceList.push({
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
      })
    },
    getToken() {
      var token = store.getters.token
      return { 'token': token }
    },
    handlePreview(file) {
      const link = document.createElement('a')
      link.setAttribute('href', file.url)
      link.setAttribute('download', file.name)
      link.style.visibility = 'hidden'
      document.body.appendChild(link)
      link.click()
      document.body.removeChild(link)
    },
    handleAvatarSuccess(response, file, fileList) {
      let flag = false
      if (response.code === '0000' && response.data && response.data !== '[]') {
        const url = JSON.parse(response.data)[0].url
        if (url) {
          this.addForm.employeePortrait = JSON.parse(response.data)[0].url
          flag = true
        }
      }
      if (!flag) {
        this.$message.error('文件上传失败')
      }
    },
    handleEducaSuccess(response, file, fileList, index, prop) {
      let flag = false
      if (response.code === '0000' && response.data && response.data !== '[]') {
        const url = JSON.parse(response.data)[0].url
        if (url) {
          this.addForm.educationExperienceList[index][prop] = url
          flag = true
        }
      }
      if (!flag) {
        this.$message.error('文件上传失败')
        this.$refs[prop + index][0].clearFiles()
      }
    },
    handleEducaRemove(file, fileList, index, prop) {
      this.addForm.educationExperienceList[index][prop] = ''
      if (prop === 'certificateEducaUrlOne') {
        this.educationFileList1[index] = fileList
      } else {
        this.educationFileList2[index] = fileList
      }
    },
    beforeEducaUpload(file, index, prop) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png'
      const isLt6M = file.size / 1024 / 1024 < 6

      if (!isJPG) {
        this.$message.error('上传图片只能是 JPG 格式!')
      }
      if (!isLt6M) {
        this.$message.error('上传图片大小不能超过 6MB!')
      }
      return isJPG && isLt6M
    },
    handleHonorarySuccess(response, file, fileList, index, prop) {
      let flag = false
      if (response.code === '0000') {
        if (response.data && response.data !== '[]') {
          const url = JSON.parse(response.data)[0].url
          if (url) {
            this.addForm.honorWallList[index][prop] = url
            flag = true
          }
        }
      }
      if (!flag) {
        this.$message.error('文件上传失败')
        this.$refs[prop + index][0].clearFiles()
      }
    },
    handleHonoraryRemove(file, fileList, index, prop) {
      this.addForm.honorWallList[index][prop] = ''
      if (prop === 'honoraryPictures') {
        this.honorWallFileList1[index] = fileList
      } else {
        this.honorWallFileList2[index] = fileList
      }
    },
    beforeHonoraryUpload(file, index, prop) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png'
      const isLt6M = file.size / 1024 / 1024 < 6

      if (prop === 'honoraryPictures' && !isJPG) {
        this.$message.error('上传图片只能是 JPG 格式!')
      }
      if (!isLt6M) {
        this.$message.error('上传文件大小不能超过 6MB!')
      }
      return isLt6M
    },
    beforeImageUpload(file) {
      const isJPG = file.type === 'image/jpeg' || file.type === 'image/jpg' || file.type === 'image/png'
      const isLt6M = file.size / 1024 / 1024 < 6

      if (!isJPG) {
        this.$message.error('上传图片只能是 JPG 格式!')
      }
      if (!isLt6M) {
        this.$message.error('上传图片大小不能超过 6MB!')
      }
      return isJPG && isLt6M
    },
    cancel() {
      this.$router.push('employeeBasicInfoList')
    },
    initSelectName() {
      const job = this.jobList.find(item => item.key === this.addForm.jobId)
      if (job) {
        this.addForm.jobName = job['lable']
      }

      const post = this.postList.find(item => item.id === this.addForm.postId)
      if (post) {
        this.addForm.postName = post['postName']
      }

      const certificate = this.certificateList.find(item => item.key === this.addForm.certificateId)
      if (certificate) {
        this.addForm.certificateType = certificate['lable']
      }

      const contract = this.contractList.find(item => item.key === this.addForm.contractId)
      if (contract) {
        this.addForm.contractName = contract['lable']
      }

      const nationality = this.nationalityList.find(item => item.key === this.addForm.nationalityId)
      if (nationality) {
        this.addForm.nationalityName = nationality['lable']
      }

      const leaderjob = this.jobList.find(item => item.key === this.addForm.directlyLeader.directLeaderLevel)
      if (leaderjob) {
        this.addForm.directlyLeader.directLeaderLevelName = leaderjob['lable']
      }

      const leaderpost = this.postList.find(item => item.id === this.addForm.directlyLeader.directLeadership)
      if (leaderpost) {
        this.addForm.directlyLeader.directLeadershipName = leaderpost['postName']
      }
    },
    submitForm() {
      this.addForm.honorWallList.forEach((item, index) => {
        if (!item.honoraryPictures && !item.honoraryFile) {
          this.addForm.honorWallList.splice(index, 1)
        }
      })
      this.isDisabled = true

      this.$refs['addForm'].validate(valid => {
        if (valid) {
          this.initSelectName()
          addEmployeeBasicInfo(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
              this.$router.push('employeeBasicInfoList')
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            // this.$refs['addForm'].resetFields()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    updateData() {
      this.addForm.honorWallList.forEach((item, index) => {
        if (!item.honoraryPictures && !item.honoraryFile) {
          this.addForm.honorWallList.splice(index, 1)
        }
      })

      this.isDisabled = true
      this.$refs['addForm'].validate(valid => {
        if (valid) {
          this.initSelectName()
          updateEmployeeBasicInfo(this.addForm).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              this.$router.push('employeeBasicInfoList')
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
    initJobList() {
      getCode({ 'groupCode': 'job', 'parentGroupCode': 'employee', 'moduleCode': 'springcloud_hr' }).then(res => {
        if (res.data.code === '0000') {
          this.jobList = res.data.data
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    initPostList() {
      api(`${this.GLOBAL.systemUrl}system/sysPost/findSysPostAll`, '', 'post').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.postList = res.data.data
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
    getFileName(name) {
      const index = name.lastIndexOf('\/')
      const fileName = name.substring(index + 1, name.length)
      return fileName
    },
    initDetail() {
      const query = this.$route.query
      this.title = query.title
      if (query.id) {
        this.addForm.id = query.id
        getEmployeeBasicInfo(query.id).then(res => {
          if (res.data.code === '0000') {
            this.addForm = Object.assign({}, res.data.data)
            if (this.addForm.educationExperienceList && this.addForm.educationExperienceList.length > 0) {
              this.addForm.educationExperienceList.forEach((item, index) => {
                this.educationFileList1[index] = []
                this.educationFileList2[index] = []
                if (item.certificateEducaUrlOne && item.certificateEducaUrlOne !== '') {
                  this.educationFileList1[index].push({
                    name: this.getFileName(item.certificateEducaUrlOne),
                    url: [item.certificateEducaUrlOne]
                  })
                }
                if (item.certificateEducaUrlTwo && item.certificateEducaUrlTwo !== '') {
                  this.educationFileList2[index].push({
                    name: this.getFileName(item.certificateEducaUrlTwo),
                    url: [item.certificateEducaUrlTwo]
                  })
                }
              })
            }
            if (this.addForm.honorWallList && this.addForm.honorWallList.length > 0) {
              this.addForm.honorWallList.forEach((item, index) => {
                this.honorWallFileList1[index] = []
                this.honorWallFileList2[index] = []
                if (item.honoraryPictures && item.honoraryPictures !== '') {
                  this.honorWallFileList1[index].push({
                    name: this.getFileName(item.honoraryPictures),
                    url: [item.honoraryPictures]
                  })
                }
                if (item.honoraryFile && item.honoraryFile !== '') {
                  this.honorWallFileList2[index].push({
                    name: this.getFileName(item.honoraryFile),
                    url: [item.honoraryFile]
                  })
                }
              })
            }

            if (!this.addForm.directlyLeader) {
              this.addForm.directlyLeader = {
                id: '',
                jobNumber: this.addForm.jobNumber,
                directLeaderLevel: '',
                directLeaderLevelName: '',
                directLeadership: '',
                directLeadershipName: '',
                directLeaderName: ''
              }
            }
            if (!this.addForm.socialSecurity) {
              this.addForm.socialSecurity = {
                id: '',
                jobNumber: this.addForm.jobNumber,
                salaryBank: '',
                salaryNumber: '',
                providentFundAccount: '',
                providentFundPayment: '',
                socialSecurityAccount: '',
                socialSecurityPayment: ''
              }
            }
            this.addForm.employStatus = res.data.data.employStatus + ''

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

            this.initCheckZjhm()
          } else {
            this.$message.error(res.data.result)
          }
        })
      }
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
    margin: 40px 72px 0px 72px;
    :hover {
      cursor: pointer;
    }
  }

  .bottom-btn {
    margin-bottom: 40px;
    text-align: center
  }

  .el-upload__tip {
    margin-top: 4px;
  }

</style>

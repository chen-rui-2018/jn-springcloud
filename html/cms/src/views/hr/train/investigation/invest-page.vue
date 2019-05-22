<template>
    <div class="invest-entry">
        <el-card>
            <el-row type="flex" justify="center">
                <el-col :span="16" :xs="22">
                    <div class="text">
                        <h6 class="text-tit">{{loginData.researchProject}}</h6>
                        <p>调研时段：{{loginData.effectiveTimeStart}} 至 {{loginData.effectiveTimeEnd}}</p>
                        <p>{{loginData.projectNote}}</p>
                    </div>
                    <!-- 入口 -->
                    <div class="entry" v-if="isEntry">
                        <div class="form">
                            <el-row type="flex" justify="center">
                                <el-col :span="10" :xs="16">
                                    <el-form :model="userData" ref="userData" :rules="rules">
                                        <el-form-item prop="name" label="姓名:" v-if="loginData.isShowName===1">
                                            <el-input v-model="userData.name"></el-input>
                                        </el-form-item>
                                        <el-form-item prop="jobNumber" label="工号:" v-if="loginData.isShowJobNumber===1">
                                            <el-input v-model="userData.jobNumber"></el-input>
                                        </el-form-item>
                                        <el-form-item prop="phone" label="手机:" v-if="loginData.isShowPhone===1">
                                            <el-input v-model="userData.phone"></el-input>
                                        </el-form-item>
                                    </el-form>
                                </el-col>
                            </el-row>
                        </div>
                        <div class="btnGroup"><el-button type="primary" @click="save('userData')">保存</el-button></div>
                    </div>
                    <!-- 进入后内容 -->
                    <div v-if="!isEntry">
                        <div class="examList" v-for="(item,index) of examList">
                            <p style="font-size:14px;"><span>Q{{index+1}}</span>&nbsp;&nbsp;<span>{{item.titleName}}</span>&nbsp;&nbsp;<span v-if="item.titleType===1">[ 单选题 ]</span><span v-if="item.titleType===3">[ 多选题 ]</span><span v-if="item.titleType===3">[ 主观题 ]</span>&nbsp;&nbsp;<span v-if="item.isShowAnswer">(必答)</span></p>
                            <div style="padding-left:26px;" v-if="item.titleType === 1 || item.titleType === 2">
                                <p style="font-size:14px;" v-for="(item2,index2) of item.titleOptionList">
                                    <el-radio v-model="item.answerList[0].optionAnswer" v-if="item.titleType === 1" :label="upperCase[index2]"></el-radio>&nbsp;&nbsp;
                                    <el-checkbox v-model="item.answerList[0].optionAnswer" v-if="item.titleType === 2">{{upperCase[index2]}}</el-checkbox>&nbsp;&nbsp;
                                    <span>{{item2.optionName}}</span>
                                </p>
                            </div>
                            <el-input v-if="item.titleType === 3" v-model="item.answerList[0].subjectiveQuestionAnswer" type="textarea" rows="5"></el-input>
                        </div>
                        <div class="btnGroup"><el-button type="primary" @click="submit">提交</el-button></div>
                    </div>
                </el-col>
            </el-row>
        </el-card>
    </div>
</template>


<script>
import {
  api, paramApi
} from '@/api/hr/train'
import 'element-ui/lib/theme-chalk/display.css'
export default {
    data() {
        return {
            isEntry: true,
            upperCase:['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
            examList:[],
            loginData: {},
            userData: {
                name: null,
                phone: null,
                jobNumber: null
            },
            rules:{
                name:[{required: true, message: '姓名不能为空', trigger: 'blur'}],
                jobNumber:[{required: true, message: '工号不能为空', trigger: 'blur'}],
                phone:[{required: true, message: '手机号码不能为空', trigger: 'blur'}]
            }
        }
    },
    created() {
        this.init()
    },
    methods: {
        // 初始化
        init() {
            let data = {
                projectId: this.$route.query.projectId
            }
            api('hr/train/loginInvestiage', data).then(res => {
                if (res.data.code === '0000') {
                    this.loginData = res.data.data
                } else {
                    this.$message.error(res.data.result)
                }
            })
        },
        // 入口保存
        save(userData) {
            this.$refs[userData].validate((valid) => {
                if (valid) {
                    let data = {
                        projectId: this.$route.query.projectId,
                    }
                    data = Object.assign(data,this.userData)
                    api('hr/train/selectInvestigate', data).then(res => {
                        if (res.data.code === '0000') {
                            this.$message.success('保存成功！')
                            this.isEntry = false
                            this.examList = res.data.data.questionList
                        } else {
                            this.$message.error(res.data.result)
                        }
                    })
                }
            })
        },
        // 提交问卷
        submit() {
            let data = {
                projectId: this.$route.query.projectId,
                name: this.userData.name,
                jobNumber: this.userData.jobNumber,
                phone: this.userData.phone,
                answerInfoList: this.examList
            }
            api('hr/train/addAnswerInfo', data).then(res => {
                if (res.data.code === '0000') {
                    this.$message.success('提交成功，感谢您的参与！')
                    this.goBack(this.$route)
                } else {
                    this.$message.error(res.data.result)
                }
            })
        },
        // 返回
        goBack(view) {
            this.$store.dispatch('delView', view).then(({ visitedViews }) => {
                if (this.isActive(view)) {
                const latestView = visitedViews.slice(-1)[0]
                if (latestView) {
                    this.$router.push('invest-analysis')
                } else {
                    this.$router.push('/')
                }
                }
            })
        },
        isActive(route) {
            return route.path === this.$route.path
        }
    }
}
</script>


<style lang="scss" scoped>
.invest-entry {
    font-size: 14px;
    .text {
        margin-bottom: 60px;
        color: #666;
        .text-tit {
            color: #666;
            font-size: 16px;
            text-align: center;
            margin: 20px auto;
        }
        p {
            line-height: 32px;
        }
    }
    .form /deep/ .el-form-item__label {
        font-weight: normal;
    }
    .form {        
        margin: 60px auto;
    }
    .btnGroup {
        text-align: center;
    }
    .examList {
        margin-bottom: 36px;
        .el-textarea {
            width: 50%;
        }
    }
}
@media screen and (max-width: 768px) {
    .invest-entry {
        font-size: 12px;
        .text {
            margin-bottom: 30px;
            color: #666;
            .text-tit {
                color: #666;
                font-size: 13px;
                text-align: center;
            }
            p {
                line-height: 25px;
            }
        }
        .form /deep/ .el-form-item__label {
            font-weight: normal;
            font-size: 12px;
        }
        .form {        
            margin: 30px auto;
        }
        .btnGroup {
            text-align: center;
        }
        .examList {
            margin-bottom: 30px;
            p {
                font-size: 12px !important;
            }
            .el-textarea {
                width: 80%;
            }
        }
    }
}
</style>
<template>
    <div class="invest-result">
        <el-card>
            <!-- 标题 -->
            <el-tabs v-model="activeName">
                <el-tab-pane label="编辑调研" name="first"></el-tab-pane>
                <el-tab-pane label="发放调研" name="second"></el-tab-pane>
                <el-tab-pane label="调研结果" name="third"></el-tab-pane>
            </el-tabs>
            <!-- Tab -->
            <el-tabs v-model="tabName" type="border-card">
                <el-tab-pane class="total" label="汇总统计" name="total">
                    <!-- 汇总统计 -->
                    <div class="examList" v-for="(item,index) in examList">
                        <el-row>
                            <el-col :span="1">Q{{index+1}}</el-col>
                            <el-col :span="12">
                                <span v-if="item.titleType===1">[ 单选题 ]</span>
                                <span v-if="item.titleType===2">[ 多选题 ]</span>
                                <span v-if="item.titleType===3">[ 主观题 ]</span>
                                {{item.titleName}}
                                <p v-for="(item2,index2) in item.titleOptionList">
                                    {{upperCase[index2]}}、{{item2.optionName}}
                                    <el-row>
                                        <el-col :span="20"><el-progress :percentage="Number((item2.optionPercent?item2.optionPercent:'0%').split('%')[0])"></el-progress></el-col>
                                        <el-col :span="2">{{item2.optionCount?item2.optionCount:0}}</el-col>
                                        <el-col :span="2">{{item2.optionPercent?item2.optionPercent:'0%'}}</el-col>
                                    </el-row>
                                </p>
                            </el-col>
                        </el-row>
                    </div>
                </el-tab-pane>
                <!-- 单人统计列表 -->
                <el-tab-pane v-if="!isDetail" class="single" label="单人统计" name="single">
                    <!-- 搜索 -->
                    <el-row type="flex" justify="end"><el-col :span="4"><el-input @keyup.enter.native="search" v-model="listQuery.name" class="search" placeholder="搜索学员" suffix-icon="el-icon-search"></el-input></el-col></el-row>
                    <el-table :data="tableData" border fit highlight-current-row style="width: 100%;height:100%;">
                        <el-table-column type="index" width="60" label="序号" align="center" />
                        <el-table-column prop="name" label="姓名" align="center"></el-table-column>
                        <el-table-column prop="isEffectiveStr" label="有效性" align="center"></el-table-column>                        
                        <el-table-column prop="submitTimeStr" label="提交时间" align="center"></el-table-column>                        
                        <el-table-column label="详情" align="center">
                            <template slot-scope="scope">
                                <span class="see" @click="detail(scope.row)">查看</span>
                            </template>    
                        </el-table-column>                        
                    </el-table>
                    <!-- 分页 -->
                    <el-pagination
                    v-show="total>0"
                    :current-page="listQuery.page"
                    :page-sizes="[5,10,20,30, 50]"
                    :page-size="listQuery.rows"
                    :total="total"
                    class="tablePagination"
                    background
                    layout="total, sizes, prev, pager, next, jumper"
                    @current-change="handleCurrentChange" />
                </el-tab-pane>
                <!-- 单人统计详情 -->
                <el-tab-pane v-if="isDetail" class="single" label="单人统计" name="single">
                    <!-- 模块一 -->
                    <div class="mode">
                        <div class="modeTit">
                            <span>学员个人信息</span>
                            <span class="line"></span>
                        </div>
                        <div class="modeCon">
                            <el-row type="flex">
                                <el-col :span="5">姓名：{{detailData.name}}</el-col>
                                <el-col :span="5">工号：{{detailData.jobNumber}}</el-col>
                                <el-col :span="5">手机：{{detailData.phone}}</el-col>
                            </el-row>
                        </div>
                    </div>
                    <!-- 模块二 -->
                    <div class="mode">
                        <div class="modeTit">
                            <span>问卷有效性</span>
                            <span class="line"></span>
                        </div>
                        <div class="modeCon" style="display: flex;align-items: center;">
                            <el-row type="flex">
                                <el-col>
                                    <span>有效性：</span>
                                    <el-radio v-model="detailData.isEffective" :label="1">有效</el-radio>
                                    <el-radio v-model="detailData.isEffective" :label="2">无效</el-radio>
                                </el-col>
                            </el-row>
                        </div>
                    </div>
                    <!-- 模块三 -->
                    <div class="mode">
                        <div class="modeTit">
                            <span>调研情况</span>
                            <span class="line"></span>
                        </div>
                        <div class="modeCon">
                            <div class="examList" v-for="(item,index) in detailData.answerList">
                                <el-row>
                                    <el-col :span="1">Q{{index+1}}</el-col>
                                    <el-col :span="12">
                                        <span v-if="item.titleType===1">[ 单选题 ]</span>
                                        <span v-if="item.titleType===2">[ 多选题 ]</span>
                                        <span v-if="item.titleType===3">[ 主观题 ]</span>
                                        {{item.titleName}}<span v-if="item.isShowAnswer">(必答)</span>
                                        <p v-if="item.titleType===1" v-for="(item2,index2) in item.titleOptionList">
                                            <el-radio v-model="item.questionAnswerList[0].optionAnswer" :label="upperCase[index2]"></el-radio>
                                            、{{item2.optionName}}
                                        </p>
                                        <p v-if="item.titleType===2" v-for="(item2,index2) in item.titleOptionList">
                                            <el-checkbox v-model="item.questionAnswerList[0].optionAnswer"></el-checkbox>
                                            {{upperCase[index2]}}、{{item2.optionName}}
                                        </p>
                                        <el-input v-if="item.titleType===3" type="textarea" :value="item.questionAnswerList[0].subjectiveQuestionAnswer" :rows="3" style="margin-top:10px;" :disabled="true"></el-input>
                                    </el-col>
                                </el-row>
                            </div>
                        </div>
                    </div>
                </el-tab-pane>  
            </el-tabs>
        </el-card>
    </div>
</template>


<script>
import {
  api, paramApi
} from '@/api/hr/train'
export default {
    data() {
        return {
            activeName: 'third',
            tabName: 'total',
            Qnum: 1,
            upperCase:['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
            examList: [],
            percentMap: [],
            // 单人统计
            isDetail: false,
            tableData: [],
            listQuery: {
                projectId: this.$route.query.id,
                name: '',
                page: 1,
                rows: 10,
            },
            total:1,
            valid: '1',
            // 单人统计详情
            detailData: {}
        }
        
    },
    created() {
        this.init1()
        this.init2()
    },
    methods:{
        // 汇总统计
        init1() {
            let data = {
                projectId: this.$route.query.id
            }
            api('hr/train/questionAnswerList', data).then(res => {
                if (res.data.code === '0000') {
                    this.examList = res.data.data
                } else {
                    this.$message.error(res.data.result)
                }
            })
        },
        // 单人统计
        init2() {
            api('hr/train/surveyResultList', this.listQuery).then(res => {
                if (res.data.code === '0000') {
                    this.tableData = res.data.data.rows
                    this.total = res.data.data.total
                } else {
                    this.$message.error(res.data.result)
                }
            })
        },
        // 查询
        search() {
            this.listQuery.page = 1
            this.init2()
        },
        // 表格分页功能
        handleCurrentChange(val) {
            this.listQuery.page = val
            this.init2()
        },
        // 查看
        detail(row) {
            this.isDetail = true
            api('hr/train/selectSurveyResult', row).then(res => {
                if (res.data.code === '0000') {
                    this.detailData = res.data.data
                } else {
                    this.$message.error(res.data.result)
                }
            })
        }
    }
}
</script>


<style lang="scss" scoped>
.invest-result {
    font-size: 14px;
    .total {
        padding: 20px;
        .examList {
            margin-bottom: 20px;
        }
        .el-progress /deep/ .el-progress__text {
            display: none;
        }
    }
    .single {
        padding: 20px;
        min-height: 260px;
        .search {
            margin-bottom:20px;
        }
        .see {
            color: #409EFF;
            cursor: pointer;
        }
    }
    .modeTit {
        display: flex;
        align-items: center;
        width: 100%;
        height: 26px;
        span {
            display: inline-block;
            width: 108px;
            font-size: 14px;
            font-weight: bold;
        }
        .line {
            display: inline-block;
            width: 100%;
            height: 2px;
            background-color:#f5f5f5;
        }
    }
    .modeCon {
        padding: 20px;
        font-size: 14px;
        margin-bottom: 36px;
        .examList {
            margin-bottom: 20px;
        }
    }
}
</style>



<template>
    <!-- 多选题 -->
    <div class="examItem examBlock">
        <div class="content">
            <el-row>
                <el-form label-width="46px">
                    <el-form-item :label="'Q'+Qnum" label-width="26px">
                        <el-row class="title">
                            <el-col :span="10"><el-input v-model="titleName" placeholder="在此输入多选题题目..."></el-input></el-col>
                            <el-col :span="6" style="padding:0 10px;">[多选题]<el-checkbox :checked="isShowAnswer===1?true:false" v-model="isShowAnswer" :true-label=1 :false-label=2 style="padding-left:26px;">必答题</el-checkbox></el-col>
                            <!-- <el-col :span="3" style="display:flex;"><span class="score">分值</span><el-input></el-input>分</el-col> -->
                        </el-row>
                    </el-form-item>
                    <el-form-item v-for="(item,index) of titleOptionList" :key="index" :label="upperCase[index]" >
                        <el-row class="option">
                            <el-col :span="9"><el-input v-model="item.optionName" placeholder="在此输入多选题选项..."></el-input></el-col>
                            <!-- <el-col :span="2" :offset="1"><el-checkbox :label="upperCase[index]">设为答案</el-checkbox></el-col> -->
                            <!-- <el-col :span="2"><span class="ptionIcon"><i class="el-icon-upload2"></i><i class="el-icon-download"></i><i class="el-icon-delete"></i></span></el-col> -->
                            <el-col :span="2"><span class="ptionIcon"><i class="el-icon-delete" @click="deleteOption(item,index)"></i></span></el-col>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <el-row><el-col :span="9"><el-button class="addOption" @click="addOption"><i class="el-icon-plus"></i>添加选项</el-button></el-col></el-row>
                    </el-form-item>
                </el-form>
            </el-row>
        </div>
        <div class="operateBtn"><i class="el-icon-delete" @click="deleteQuestion(Qnum)"></i></div>
    </div>
</template>


<script>
export default {
    props:['Qnum'],
    data() {
        return {
            upperCase:['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'],
            titleName:'',
            titleType: 2,
            isShowAnswer: 2,
            titleOptionList:[]
        }
    },
    methods: {
        // 传送数据
        passData() {
             let data = {
                titleName: this.titleName,
                titleOptionList: this.titleOptionList,
                isShowAnswer: this.isShowAnswer
            }
            return data
        },
        // 添加题目选项
        addOption() {
            let item = {
                optionId: this.upperCase[this.titleOptionList.length],
                optionName: ''
            }
            this.titleOptionList.push(item)
        },
        // 删除题目选项
        deleteOption(item, index) {
            this.titleOptionList.splice(index,1)
        },
        // 删除题目
        deleteQuestion(Qnum) {
            this.$confirm(`删除这道多选题, 是否继续?`, '删除提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
               this.$emit('deleteQitem',Qnum)
            })
        }
    }
}
</script>


<style lang="scss" scoped>
.examBlock {
    padding: 20px;
    margin-bottom: 20px;
    .editIcon {
        text-align: right;
        margin-bottom: 20px;
    }
    .showBtn {
        position: absolute;
        right: -57px;
        top: 0;
    }
    .examType {
        display: flex;
        align-items:center;
        i.add {
            font-size:30px;
            color:#67C23A;
            margin-right: 15px;
        }
    }
    .ptionIcon {
        display: flex;
        justify-content: center;
        align-items: center;
        padding-top: 10px;
        color: #999;
        cursor: pointer;
        i {
            font-size:20px;
        }
    }
    .addOption {
        width:100%;
    }
    .score {
        display: inline-block;
        width: 60px;
    }
}
.examItem {
    position:relative;
    background-color:#fafafa;
    .operateBtn {
        display: flex;
        justify-content: center;
        align-items: center;
        width:120px;
        height:100%;
        position:absolute;
        right:0;
        top:0;
        background-color:#F5F5F5;
        i {
            font-size: 22px;
            color: #999;
            cursor: pointer;
        }
    }
}
</style>


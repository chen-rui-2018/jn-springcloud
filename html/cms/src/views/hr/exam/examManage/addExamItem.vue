<template>
	<div class="addExamItem">
		<div class="header-steps">
			<el-steps :active="active" simple finish-status="success">
				<el-step title="1  考试信息"></el-step>
				<el-step title="2  设计试卷"></el-step>
				<el-step title="3  发布考试"></el-step>
			</el-steps>
		</div>
		<!--对应三个步骤-->
		<div class="stepsBox1" v-show="active==1">
			<el-header style="line-height: 60px;">基本信息</el-header>
			<el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
				<el-form-item label="考试名称" prop="examinaName" style="width: 500px;">
					<el-input v-model="ruleForm.examinaName"></el-input>
				</el-form-item>
				<el-form-item label="有效时间" required style="width: 500px;">
					<el-form-item prop="date1">
						<div class="block">
							<el-date-picker @change="chanageDate" v-model="ruleForm.date1" type="datetimerange" value-format="yyyy-MM-dd HH:mm:ss" format="yyyy-MM-dd HH:mm:ss" start-placeholder="开始日期" end-placeholder="结束日期" :default-time="['12:00:00']">
							</el-date-picker>
						</div>
					</el-form-item>
				</el-form-item>
				<el-form-item label="考试须知" prop="examinaNotes" style="width: 500px;">
					<el-input type="textarea" v-model="ruleForm.examinaNotes"></el-input>
				</el-form-item>
			</el-form>
			<el-footer style="text-align: center;">
				<el-button type="primary" @click="submitForm('ruleForm')">保存 & 去设计试卷</el-button>
				<el-button type="primary" @click="$router.go(-1)">返回</el-button>
			</el-footer>
		</div>
		<div class="stepsBox2" v-show="active==2">
			<div>
				<el-header class="el-head">
					<span>第1大题</span>
					<span>({{ruleForm.examinabanksList.length}}道题,共{{columnTotal}}分)</span>
					<div class="fr">
						<el-input placeholder="从试题库选择" class="searchAroblem" @focus="searchExam()">
							<i slot="prefix" class="el-input__icon el-icon-search"></i>
						</el-input>
						<el-button class="addAroblem" @click="addExam('add')" type="primary" size="small" icon="el-icon-plus">新增试题</el-button>
					</div>
				</el-header>
				<el-table :data="ruleForm.examinabanksList" border style="width: 100%">
					<el-table-column type="index" prop="date" label="序号" width="60">
					</el-table-column>
					<el-table-column prop="testQuestionTypeStr" label="试题类型" width="120">
					</el-table-column>
					<el-table-column prop="examinationQuestion" label="试题内容">
					</el-table-column>
					<el-table-column prop="answerNumber" label="标准答案" width="120">
					</el-table-column>
					<el-table-column label="分数" width="160">
						<template slot-scope="scope">
							<el-input-number v-model="scope.row.fraction" size="mini" :min="1"  label="请输入分数"></el-input-number>
							<!--<el-input v-model="scope.row.fraction" placeholder="请输入内容"></el-input>-->
							<!--<input style="width: 80px;" v-model="scope.row.fraction" type="text" />-->
						</template>
					</el-table-column>
					<el-table-column fixed="right" label="操作" width="100">
						<template slot-scope="scope">

							<el-button type="text" size="small" @click="addExam('edit',scope.row)">编辑</el-button>
							<el-button @click="delExam(scope.$index,scope.row)" type="text" size="small">删除</el-button>

						</template>
					</el-table-column>
				</el-table>
				<el-footer style="text-align: center;padding: 10px;">
					<el-button type="primary" @click="submitForm2()">完成设计&去发布考试</el-button>
					<el-button type="primary" @click="goBack()">上一步</el-button>
				</el-footer>
				<!--试卷设置-->
				<el-dialog title="考试设置" :visible.sync="dialogFormVisible">
					<el-form :model="ruleForm" :rules="rules2" ref="ruleForm2" label-width="80px" style="max-width: 500px;">
						<el-form-item label="及格分数" prop="passScore">
							<el-input v-model="ruleForm.passScore" @change="ruleForm.passScore=ruleForm.passScore>ruleForm.totalScore?ruleForm.totalScore:ruleForm.passScore" autocomplete="off" type="number" :min='1' :max='ruleForm.totalScore'>
								<template slot="append">总分 {{ruleForm.totalScore}}</template>
							</el-input>
						</el-form-item>
						<el-form-item label="答题时间" prop="answerTime">
							<el-input v-model="ruleForm.answerTime" autocomplete="off">
								<template slot="append">分钟</template>
							</el-input>
						</el-form-item>
					</el-form>
					<div slot="footer" class="dialog-footer">
						<el-button @click="dialogFormVisible = false">取 消</el-button>
						<el-button type="primary" @click="submitForm3('ruleForm2')">确 定</el-button>
					</div>
				</el-dialog>
				<!--试题选择-->
				<el-dialog title="从试题库选择" width="80%" :visible.sync="dialogExamVisible">
					<examination-lists v-if="dialogExamVisible" @confirmOption="confirmOption"> </examination-lists>

				</el-dialog>
				<!--新增或者编辑试题-->
				<el-dialog :title="titleType" width="80%" :visible.sync="adddialogExamVisible">
					<examination-add-dialog v-if="adddialogExamVisible" @confirmAddExam="confirmAddExam" :examItem="examItem"></examination-add-dialog>
				</el-dialog>
			</div>
		</div>
		<div class="stepsBox3" v-show="active==3">
			<p class="stepsBox3-head">以下任意一种方式通知考生参加考试</p>
			<div class="stepsBox3-content">

				<el-form :model="formData3" label-width="360px" label-position="left">
					<el-form-item label="1、将二维码发给考生，扫描参加考试">
						<vue-qr :size="191" :margin="0" :auto-color="true" :dot-scale="1" :text="formData3.examinaUrl" />
						<!--<img :src="formData3.imgUrl" width="150" height="150" />-->
					</el-form-item>
					<el-form-item label="2、复制考试链接发给考生，打开链接参加考试">
						<!--<el-input v-model="form.name" autocomplete="off">-->
						<el-input class="fl" v-model="formData3.examinaUrl" placeholder="Please input" style="width:400px;max-width:100%;" />
						<el-button class="fl" v-clipboard:copy="formData3.examinaUrl" v-clipboard:success="clipboardSuccess" type="primary" icon="el-icon-document-copy">复制考试链接</el-button>
						<!--</el-input>-->
					</el-form-item>
					<el-form-item label="3、发送考试邮件，通知考生参加考试">
						<el-button icon="el-icon-message">发送考试通知</el-button>
					</el-form-item>
				</el-form>
				<div slot="footer" class="dialog-footer">
					<el-button @click="goLists()">返回考试列表</el-button>
					<el-button @click="goBack()">上一步</el-button>
				</div>
			</div>
		</div>

	</div>
</template>

<script>
	import VueQr from 'vue-qr'
	import examinationLists from '../components/examinationList'
	import examinationAddDialog from '../components/examinationAddDialog'
	import {
		addExamSendExam,
		examSelectExamInfo
	} from '@/api/hr/examManage'
	import clip from '@/utils/clipboard' // use clipboard directly
	import clipboard from '@/directive/clipboard/index.js' // use clipboard by v-directive
	export default {
		directives: {
			clipboard
		},
		components: {
			VueQr,
			examinationAddDialog,
			examinationLists
		},
		data() {
			return {
				active: 1,
				value1: '',
				dialogExamVisible: false,
				adddialogExamVisible: false,
				titleType: '新增试题',
				examItem: {},
				ruleForm: {
					date1: '',
					examinaName: '',
					effectiveTimeStart: '',
					effectiveTimeEnd: '',
					examinaNotes: '',
					totalScore: 88,
					passScore: '',
					answerTime: '',
					examinabanksList: [],
					examinaDimensional: window.location.protocol + '//' + window.location.host + '/#/answerHome',
					examinaUrl: window.location.protocol + '//' + window.location.host + '/#/answerHome'
				},
				formData3: {
					examinaUrl: window.location.protocol + '//' + window.location.host + '/#/answerHome',
					imgUrl: require('../../../../assets/images/testErweima.png'),
					inputData: 'www.baidu.com'
				},
				rules: {
					examinaName: [{
						required: true,
						message: '请输入考试名称',
						trigger: 'blur'
					}],
					date1: [{
						required: true,
						message: '请选择有效时间',
						trigger: 'change'
					}]
				},
				rules2: {
					passScore: [{
						required: true,
						message: '请输入及格分数',
						trigger: 'blur'
					}],
					answerTime: [{
						required: true,
						message: '请输入考试时长',
						trigger: 'change'
					}]
				},
				dialogFormVisible: false,
				form: {
					name: '',
					region: '',
					date1: '',
					date2: '',
					delivery: false,
					type: [],
					resource: '',
					desc: ''
				},
				formLabelWidth: 220
			};
		},
		computed: {
			// 计算属性的 getter
			columnTotal: function() {
				// `this` 指向 vm 实例
				this.ruleForm.totalScore = this.ruleForm.examinabanksList.map(row => parseFloat(row.fraction) > 0 ? parseFloat(row.fraction) : 0).reduce((acc, cur) => (cur + acc), 0);
				return this.ruleForm.examinabanksList.map(row => parseFloat(row.fraction) > 0 ? parseFloat(row.fraction) : 0).reduce((acc, cur) => (cur + acc), 0)
			}
		},
		created(){
			if(this.$route.query.id){			
				this.initData()
			}
		},

		methods: {
			/*编辑试卷回显数据*/
			initData(){
				examSelectExamInfo({id:this.$route.query.id}).then(res => {
					if(res.data.code === '0000') {
						this.ruleForm={...res.data.data}
						this.ruleForm.date1=[this.ruleForm.effectiveTimeStart,this.ruleForm.effectiveTimeEnd]
					} else {
						this.$message.error(res.data.result)
					}
				})
			},
			/*从试题库抽取题目*/
			searchExam() {
				this.dialogExamVisible = true
			},
			/*子组件确认选题*/
			confirmOption(val) {
				console.log(val)
				if(val.type) {
					/*去重*/
					const age = 'testQuestionId';
					this.ruleForm.examinabanksList = this.ruleForm.examinabanksList.concat(val.multipleSelection);
					this.ruleForm.examinabanksList = this.ruleForm.examinabanksList.reduce((all, next) => all.some((atom) => atom[age] == next[age]) ? all : [...all, next], []);
				}
				this.dialogExamVisible = false
			},
			/*子组件确认添加题目*/
			confirmAddExam(val) {
				if(val.type) {
					/*回显有问题，需要整个替换掉*/
					const age = 'testQuestionId';
					this.ruleForm.examinabanksList = this.ruleForm.examinabanksList.concat(val.examItem);
					this.ruleForm.examinabanksList = this.ruleForm.examinabanksList.reduce((all, next) => all.some((atom) => atom[age] == next[age]) ? all : [...all, next], []);
					
					this.ruleForm.examinabanksList.forEach((item,index) =>{
						console.log(item,index)
						if(item.testQuestionId==val.examItem.testQuestionId){
							this.ruleForm.examinabanksList[index]=val.examItem;
						}
					})

				}
				this.adddialogExamVisible = false
			},
			/*新增编辑试题*/
			addExam(type, examItem) {
				if(type == 'add') {
					this.titleType = '新增试题'
					this.examItem = {}
				} else {
					this.titleType = '编辑试题'
					this.examItem = examItem
				}
				this.adddialogExamVisible = true;

			},
			/*移除题目*/
			delExam(index, examItem) {
				this.$confirm('此操作把考题移出该试卷, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					this.ruleForm.examinabanksList.splice(index, 1)
					this.$message({
						type: 'success',
						message: '删除成功!'
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
				
			},

			//			var tableData = [ {calcCol: 1, b: 2}, {calcCol: 2, b: 3}, {calcCol:3, c: 4} ]
			//var total = tableData.map(row => row.calcCol).reduce((acc, cur) => (cur + acc), 0)
			chanageDate() {
				this.ruleForm.effectiveTimeStart = this.ruleForm.date1[0]
				this.ruleForm.effectiveTimeEnd = this.ruleForm.date1[1]
				console.log(this.ruleForm.date1)
			},
			next() {
				console.log(this.active)
				if(this.active++ > 2) this.active = 1;
			},
			goBack() {
				this.active--
			},
			goLists() {
				this.$router.push({
					path: '/hr/exam/examManage/examManageList'
				})
			},
			//第一步 创建试卷
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
						this.next()
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			//第2步 添加考题
			submitForm2() {
				if(this.ruleForm.examinabanksList.length > 0) {
					this.dialogFormVisible = true;
				} else {
					this.$message({
						message: '请先设置考试题目',
						type: 'error',
						duration: 1500
					})
				}

			},
			//第3步 设置分数以及考试时间
			submitForm3(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
						//						this.next()
					} else {
						console.log('error submit!!');
						return false;
					}
				});
				addExamSendExam(this.ruleForm).then(res => {
					if(res.data.code === '0000') {
						console.log(res)
						this.formData3.examinaUrl = res.data.data.examinaUrl;
						this.dialogFormVisible = false;
						console.log(this.formData3)
						this.next()
					} else {
						this.$message.error(res.data.result)
					}
				})
				return;

			},
			/*复制成功回调*/
			clipboardSuccess() {
				this.$message({
					message: '✔ 已成功复制到粘贴板',
					type: 'success',
					duration: 1500
				})
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			},

		}
	}
</script>

<style lang="scss" scoped>
	.addExamItem {
		.stepsBox1 {
			background-color: #fff;
			padding: 0 20px 20px 20px;
		}
		.stepsBox2 {
			background-color: #fff;
			padding: 20px;
			.el-head {
				line-height: 60px;
				border: 1px solid #ccc;
				.searchAroblem {
					width: 180px;
				}
				.addAroblem {}
			}
		}
		.stepsBox3 {
			background-color: #fff;
			.stepsBox3-head {
				margin-top: 0px;
				margin-bottom: 10px;
				height: 40px;
				line-height: 40px;
				text-indent: 20px;
				font-size: 16px;
				color: #555;
				border-top: 1px solid #e6e9ee;
				background-color: #f9f9f9;
			}
			.stepsBox3-content {
				padding: 10px 20px 50px 20px;
			}
			.dialog-footer {
				text-align: center;
			}
		}
	}
</style>
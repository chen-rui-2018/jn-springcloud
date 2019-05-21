<template>
	<!--答题页面-->
	<div class="answerHome">
		<my-container>
			<el-card class="box-card" v-if="!examInfo.examinabanksList">
				<el-header>
					<h3 class="head-top">欢迎参加考试</h3>
				</el-header>
				<div class="examInfo">
					<p>考试名称：{{examInfo.examinaName}}</p>
					<p>有效时间：{{examInfo.effectiveTimeStart}}~{{examInfo.effectiveTimeEnd}}</p>
					<p>可考次数：1(次)</p>
					<p>及格分数：{{examInfo.passScore}}(分)</p>
					<p>试卷总分：{{examInfo.totalScore}}(分)</p>
					<p>答题时间：{{examInfo.answerTime}}(分钟)</p>
					<p class="notesBox"><span>考试须知：</span><br /> <span class="notes">{{examInfo.examinaNotes}}</span></p>
					<p><i class="el-icon-warning" style="color: #09bb07;"></i><span style="color: #999;">参加考试前，请输入以下信息</span></p>
					<el-form :model="userFrom" ref="userFrom" class="demo-ruleForm">
						<el-form-item prop="jobNumber" :rules="[{ required: true, message: '工号不能为空'},]">
							<el-input type="age" v-model="userFrom.jobNumber" autocomplete="off" clearable></el-input>
						</el-form-item>
						<el-form-item>
							<el-button type="success" class="btn" @click="submitForm('userFrom')">参加考试</el-button>
							<p class="user-test">白下新高-提供服务</p>
						</el-form-item>
					</el-form>
				</div>

			</el-card>
			<el-card class="subjectCard" v-if="examInfo.examinabanksList">
				<div class="subject">
					<div class="examList" v-for="(item,index) of examInfo.examinabanksList">
						<el-card style='margin-top: 10px;'>
							<p style="font-size:14px;"><span>Q{{index+1}}</span>&nbsp;&nbsp;<span>{{item.examinationQuestion}}
                            </span>&nbsp;&nbsp;<span v-if="item.testQuestionType==1">[ 单选题 ]</span>
								<span v-if="item.testQuestionType==2">[ 多选题 ]</span>
								<span v-if="item.testQuestionType==3">[ 主观题 ]</span>
								<div style="padding-left:26px;" v-if="item.testQuestionType == 1 || item.testQuestionType == 2">
									<p style="font-size:14px;" v-for="(item2,index2) of item.optionList">
										<el-radio v-model="examInfo.examinabanksList[index].answer" v-if="item.testQuestionType == 1" :label="item2.optionId"></el-radio>&nbsp;&nbsp;
										<el-checkbox v-model="examInfo.examinabanksList[index].answer" v-if="item.testQuestionType == 2" :label="item2.optionId">{{item2.optionId}}</el-checkbox>&nbsp;&nbsp;
										<span>{{item2.optionName}}</span>
									</p>
								</div>
								<el-input v-if="item.testQuestionType == 3" v-model="item.answer" type="textarea" rows="5"></el-input>
						</el-card>
					</div>
					<div class="footerBox">
						<my-container>
							<el-button-group class="subjectCardFooter">
								<el-button class="btn">答题卡</el-button>
								<el-button class="btn" type="danger" @click="submit">交卷{{countdown}}</el-button>
							</el-button-group>
						</my-container>
					</div>

				</div>
			</el-card>

		</my-container>

	</div>
</template>

<script>
	import moment from 'moment'
	import myContainer from '../../components/responseBox/myContainer' // use clipboard by v-directive
	import {
		examLoginManagement,
		examInsterAnswerCard
	} from '@/api/hr/examManage'
	export default {
		components: {
			myContainer
		},
		data() {
			return {
				countdown: '60分00秒',
				userFrom: {
					jobNumber: '',
					id: '',
					examinaStartTime: '', //考试开始时间
					examinaEndTime: '',
					examinaMethod: 1, //用户终端后面加上判断

				},
				examInfo: {

				}
			}
		},
		created() {
			console.log(Date.parse(new Date(moment().format('YYYY-MM-DD hh:mm:ss'))))
			this.userFrom.id = this.$route.query.id
			this.initData();

		},
		methods: {
			initData() {

				examLoginManagement(this.userFrom).then(res => {
					if(res.data.code === '0000') {
						if(res.data.data.examinabanksList && res.data.data.examinabanksList.length > 0) {
							res.data.data.examinabanksList.forEach(item => {
								if(item.testQuestionType == 2) {
									item.answer = []
								}
							})
						}

						this.examInfo = res.data.data
						if(this.userFrom.jobNumber != '') {
							this.userFrom.examinaStartTime = moment().format('YYYY-MM-DD hh:mm:ss');
							this.countdownFun();

						}
						console.log(this.examInfo)
					} else {
						this.$message.error(res.data.result)
					}
				})
			},
			countdownFun() {
				let _this = this;
				var timer = setInterval(function() {
					let time = moment().format('YYYY-MM-DD hh:mm:ss')
					let dateTime = (Date.parse(new Date(time)) - Date.parse(new Date(_this.userFrom.examinaStartTime))) / 1000
					let sumTime = _this.examInfo.answerTime * 60 - dateTime
					_this.countdown = parseInt(sumTime / 60) + '分' + ((sumTime % 60) < 10 ? ('0' + (sumTime % 60)) : (sumTime % 60)) + '秒'
					if(sumTime < 0) {
						_this.submit()
						clearInterval(timer);
					}

				}, 1000);
			},

			/*提交试卷*/
			submit() {
				this.userFrom.examinaEndTime = moment().format('YYYY-MM-DD hh:mm:ss');
				let useTime = 0; //答题时间
				let examQuery = JSON.parse(JSON.stringify(this.examInfo))
				useTime = Date.parse(new Date(this.userFrom.examinaEndTime)) - Date.parse(new Date(this.userFrom.examinaStartTime))
				examQuery.useTime =Math.ceil(useTime / 60000);
				//				examQuery.jobNumber=this.userFrom.jobNumber;				
				if(examQuery.examinabanksList && examQuery.examinabanksList.length > 0) {
					examQuery.examinabanksList.forEach(item => {
						if(item.testQuestionType == 2) {
							item.answer = item.answer.join()
						}
					})
				}
				console.log(JSON.stringify({ ...examQuery,
					...this.userFrom
				}))
				examInsterAnswerCard({ ...examQuery,
					...this.userFrom
				}).then(res => {
					if(res.data.code === '0000') {
						this.$router.push({
							path: '/resultPage',
							query:{
								...this.userFrom
							}
						})
					} else {
						this.$message.error(res.data.result)
					}

				})
			},
			/*登录考试*/
			submitForm(formName) {
				this.$refs[formName].validate((valid) => {
					if(valid) {
						this.initData()
					} else {
						console.log('error submit!!');
						return false;
					}
				});
			},
			resetForm(formName) {
				this.$refs[formName].resetFields();
			}
		}
	}
</script>

<style lang="scss" scoped>
	.answerHome {
		.head-top {
			font-weight: 200;
			font-size: 22px;
			text-align: center;
		}
		.examInfo {
			padding: 10px;
			.notes {
				display: inline-block;
				margin-top: 20px;
				color: red;
				text-indent: 18px;
			}
			.demo-ruleForm {
				.btn {
					margin-top: 10px;
					height: 50px;
					width: 100%;
				}
				.user-test {
					color: #999;
					font-size: 12px;
					text-align: center;
				}
			}
		}
		.subjectCard {
			margin-bottom: 80px;
			.footerBox {
				width: 100%;
				position: fixed;
				left: 0;
				bottom: 0;
			}
			.subjectCardFooter {
				width: 100%;
				text-align: center;
				.btn {
					height: 50px;
					width: 50%;
				}
			}
		}
		background-color: #fff;
	}
</style>
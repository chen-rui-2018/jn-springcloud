/* eslint-disable vue/require-v-for-key */
<template>
  <div class="examManagelist">
    <el-menu :default-active="activeIndex" class="el-menu-demo" mode="horizontal" @select="handleSelect">
      <el-menu-item index="1">处理中心</el-menu-item>
      <el-button class="addexamBtn" type="primary" size="small" icon="el-icon-plus" @click="addExam">创建考试</el-button>
    </el-menu>
    <!---->

    <div class="header-tabs">
      <el-tabs v-model="initFrom.status" type="border-card" @tab-click="handleClick">

        <el-tab-pane name="1">
          <span slot="label">进行中({{ dataStatusNum.underWayStatusCount }})</span>

        </el-tab-pane>
        <el-tab-pane name="0">
          <span slot="label">未开始({{ dataStatusNum.notStartStatusCount }})</span>
        </el-tab-pane>
        <el-tab-pane name="2">
          <span slot="label">已结束({{ dataStatusNum.hasEndStatusCount }})</span>
        </el-tab-pane>
        <el-tab-pane name="3" style="float: right;">
          <span slot="label">全部({{ dataStatusNum.statusCount }})</span>
        </el-tab-pane>
        <div v-loading="examboxLoading" class="examboxF">
          <el-card v-if="dataList.length==0">
            <p style="text-align: center;line-height: 160px;">暂无考试信息，你可先
              <el-button type="text" @click="addExam">创建考试</el-button>
            </p>
          </el-card>
          <el-card v-for="(item,index) in dataList" :key="index" class="exambox box-card">
            <img src="../../../../assets/images/testErweima.png" width="150" height="150" >
            <div class="examlistleft">
              <h6>{{ item.examinaName }}</h6>
              <p><span>参加方式:免登陆考试</span></p>
              <p>
                <span>考试总分:{{ item.totalScore }}分</span>
                <span>及格分数:{{ item.passScore }}分</span>
                <span>答题时间:{{ item.answerTime }}分钟</span>
              </p>
              <p><span>有效时间:{{ item.effectiveTimeStart }}~{{ item.effectiveTimeEnd }}</span></p>
            </div>
            <div class="examListright">
              <div class="examListrightTop">
                <span class="participateIn">{{ item.resultCount }} 人已参加</span>
                <el-select v-model="value" placeholder="更多操作" @change="((val)=>{selectChange(val, item)})">
                  <div v-for="(option,index) in options" :key="index">
                    <el-option v-clipboard:copy="item.examinaUrl" v-clipboard:success="clipboardSuccess" v-if="option.value==2" :key="option.value" :label="option.label" :value="option.value"/>
                    <el-option v-else :key="option.value" :label="option.label" :value="option.value"/>
                  </div>

                </el-select>
              </div>
              <div class="examListrightbottom">
                <span @click="selectChange(&quot;6&quot;, item)"><i class="el-icon-data-line" />查看成绩</span>
                <span @click="selectChange(&quot;0&quot;, item)"><i class="el-icon-setting" />考试设置</span>
              </div>
            </div>
          </el-card>
        </div>

      </el-tabs>
      <div class="inputBox">
        <el-input v-model="initFrom.examinaName" placeholder="输入名称查询" class="input-with-select" clearable>
          <el-button slot="append" icon="el-icon-search" @click="initData()"/>
        </el-input>
      </div>
    </div>
    <!--发送邮件-->
    <el-dialog :visible.sync="emitDialogVisible" :modal-append-to-body="false" title="发送通知" width="80%">
      <emit-dialog v-if="emitDialogVisible" :exam-item="examItem" @confirmEmit="confirmEmit"/>
    </el-dialog>

  </div>

</template>

<script>
import emitDialog from '../components/emitDialog'
import clipboard from '@/directive/clipboard/index.js' // use clipboard by v-directive
import {
  examSelectExaminaManagementList,
  examDeleteExamInfo
} from '@/api/hr/examManage'
export default {
  directives: {
    clipboard
  },
  components: {
    emitDialog
  },
  data() {
    return {
      examboxLoading: false,
      emitDialogVisible: false,
      dataStatusNum: {
        notStartStatusCount: 0,
        underWayStatusCount: 0,
        hasEndStatusCount: 0,
        statusCount: 0
      }, // 对应几个状态的数据数量
      initFrom: {
        status: '3',
        examinaName: ''
      },
      options: [{
        value: '0',
        label: '编辑考试'
      }, {
        value: '1',
        label: '打开考试链接'
      }, {
        value: '2',
        label: '复制考试链接'
      }, {
        value: '3',
        label: '发送考试通知'
      }, {
        value: '4',
        label: '人工评卷'
      }, {
        value: '5',
        label: '删除考试'
      }, {
        value: '6',
        label: '查看成绩'
      }],
      value: '',
      examItem: {}, // 当前操作考试对象
      url: 'https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg',
      dataList: [],
      stateCode: 1,
      activeName: '1',
      activeIndex: '1'
    }
  },
  created() {
    this.initData()
  },
  methods: {
    initData() {
      const queryFrom = {}
      /* 和后台约定状态为3时传空查询全部*/
      // eslint-disable-next-line eqeqeq
      queryFrom.status = this.initFrom.status == 3 ? '' : this.initFrom.status
      queryFrom.examinaName = this.initFrom.examinaName

      this.examboxLoading = true
      examSelectExaminaManagementList(queryFrom).then(res => {
        const _this = this
        window.setTimeout(function() {
          _this.examboxLoading = false
        }, 500)

        this.dataList = []
        if (res.data.code === '0000') {
          if (res.data.data.rows.length === 1) {
            if (res.data.data.rows[0].id) {
              this.dataList = res.data.data.rows
            }
          } else {
            this.dataList = res.data.data.rows
          }
          if (res.data.data.rows.length > 0) {
            this.dataStatusNum = res.data.data.rows[0]
          }
        } else {
          this.examboxLoading = false

          this.$message.error(res.data.result)
        }
      })
    },
    /* 移除试卷*/
    delItem() {

    },
    // 更多操作
    selectChange(val, item) {
      switch (val) {
        case '0':
          console.log(item)
          this.editExam(item)
          console.log('编辑考试')
          break
        case '1':
          this.openUrl(item)
          break
        case '2':
          this.handleCopy(item)
          break
        case '3':
          this.emitDialogVisible = true
          this.examItem = item
          break
        case '4':
          this.goViewScore(item)
          break
        case '5':
          this.delExam(item)
          break
        case '6':
          this.goViewScore(item)
          break
      }
      this.value = ''
    },
    /* 打开考试链接*/
    openUrl(item) {
      window.open(item.examinaUrl)
    },
    clipboardSuccess() {
      this.$message({
        message: '✔ 已成功复制到粘贴板',
        type: 'success',
        duration: 1500
      })
    },
    handleCopy(item) {
      //				clip(item.examinaUrl)
    },
    /* 创建考试*/
    addExam() {
      this.$router.push({
        path: '/hr/exam/examManage/addExamItem'
      })
    },
    delExam(item) {
      //
      this.$confirm('此操作把将永久移除试卷, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        examDeleteExamInfo({
          id: item.id
        }).then(res => {
          if (res.data.code === '0000') {
            this.initData()
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          } else {
            this.$message.error(res.data.result)
          }
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },

    /* 编辑考试*/
    editExam(item) {
      console.log(item)
      this.$router.push({
        path: '/hr/exam/examManage/addExamItem',
        query: {
          id: item.id
        }
      })
    },
    /* 查看成绩*/
    goViewScore(item) {
      this.$router.push({
        path: '/hr/exam/examManage/viewScore',
        query: {
          examinaId: item.id
        }
      })
    },
    /* 邮件弹出窗回调*/
    confirmEmit(obj) {
      console.log(obj)
      this.emitDialogVisible = false
    },
    handleClick(tab, event) {
      this.initData()
      //				this.stateCode = parseInt(this.initFrom.status)
      console.log(this.initFrom.status)
    },
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    }
  }
}
</script>

<style lang="scss" scoped>
	.examManagelist {
		.header-tabs {
			position: relative;
		}
		.addexamBtn {
			float: right;
			margin-top: 15px;
			margin-right: 20px;
		}
		.inputBox {
			position: absolute;
			right: 20px;
			top: 2px;
		}
		.examboxF {
			min-height: 100px;
		}
		.exambox {
			padding-bottom: 10px;
			img {
				float: left;
			}
			.examlistleft {
				float: left;
				margin-left: 20px;
				p {
					span {
						margin-right: 20px;
					}
				}
				h6 {
					font-size: 18px;
					color: #2972ab;
					font-weight: normal;
					line-height: 30px;
					margin: 0;
				}
			}
			.examListright {
				float: right;
				.participateIn {
					margin-right: 60px;
				}
			}
			.examListrightbottom {
				text-align: right;
				margin-top: 60px;
				span {
					margin-left: 20px;
				}
			}
		}
	}

	.examManagelist /deep/ .el-dialog__wrapper {
		z-index: 1000 !important;
	}

	.examManagelist /deep/ .v-modal {
		z-index: 999!important;
	}
</style>

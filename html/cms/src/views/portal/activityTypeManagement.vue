<template>
  <div>
    <div class="filter-container">
      <el-form :inline="true" :model="listQuery">
        <!-- <el-form-item label="类型名称:" style="line-height: 34px;">
          <el-input v-model="listQuery.typeName" maxlength="20" placeholder="请输入类型名称" class="filter-item" clearable @keyup.enter.native="handleFilter"/>
        </el-form-item> -->
        <el-form-item label="状态:" style="line-height: 34px;">
          <el-select v-model="listQuery.status" placeholder="请选择状态" clearable class="filter-item" @change="selecteUserStatus">
            <el-option v-for="(item,index) in statusOptions" :key="item" :label="item" :value="index" />
          </el-select>
        </el-form-item>
        <el-button class="filter-item" type="primary" icon="el-icon-search" @click="handleFilter">搜索</el-button>
        <el-button class="filter-item" style="margin-left:20px" type="primary" icon="el-icon-plus" @click="handleCreate">新增</el-button>
        <!-- <el-button :disabled="tableChecked.length === 0||disabled" type="primary" class="filter-item" style="margin-left:20px" @click="removeBatch(tableChecked)">批量删除</el-button> -->
        <el-button type="primary" class="filter-item" style="margin-left:20px" @click="removeBatch(tableChecked)">批量删除</el-button>
      </el-form>
    </div>

    <!-- 表格 -->
    <el-table v-loading="listLoading" :data="typeList" border fit highlight-current-row style="width: 100%;height:100%;margin-bottom:20px" @selection-change="selsChange">
      <el-table-column type="selection" width="40"/>
      <el-table-column type="index" width="60" label="序号" align="center" />
      <el-table-column label="类型名称" align="center" prop="typeName" />
      <el-table-column label="状态" align="center" prop="typeStatus">
        <template slot-scope="scope">
          <span :class="scope.row.typeStatus==0 ? 'text-red' : 'text-green'">{{ scope.row.typeStatus==0?'无效':'有效' }}</span>
        </template>
      </el-table-column>
      <el-table-column label="模板数量" align="center" prop="fileTotal">
        <template slot-scope="scope">
          <span class="fileTotal" @click="handleFileTotal(scope.row)">{{ scope.row.fileTotal===null||scope.row.fileTotal===0?0: scope.row.fileTotal }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">编辑</el-button>
          <el-button size="mini" type="danger" @click="deleteActiType(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页 -->
    <el-pagination v-show="total>0" :current-page="listQuery.page" :page-sizes="[5,10,20,30, 50]" :page-size="listQuery.rows" :total="total" class="tablePagination" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    <!-- 弹出的新增活动类型对话框 -->
    <template v-if="activityTypedialogFormVisible">
      <el-dialog :visible.sync="activityTypedialogFormVisible" :title="dialogStatus" width="650px">
        <el-form ref="activityTypeForm" :model="activityTypeForm" :rules="rules" label-position="right" label-width="100px">
          <el-form-item label="类型名称:" prop="typeName">
            <el-input v-model.trim="activityTypeForm.typeName" maxlength="20" clearable style="width:350px"/>
          </el-form-item>
          <el-form-item label="状态:" prop="typeStatus">
            <el-select v-model="activityTypeForm.typeStatus" placeholder="请选择" class="filter-item" clearable style="width:350px">
              <el-option v-for="(item,index) in statusOptions" :key="index" :label="item" :value="index" />
            </el-select>
            <!-- <template slot-scope="scope">
              <span v-if="scope.row.typeStatus==='0'">无效</span>
              <span v-if="scope.row.typeStatus==='1'">有效</span>
            </template> -->
          </el-form-item>
          <el-form-item v-loading="loadingUpFlag" label="海报模板:" prop="templateList" style="width:615px;height:280px;overflow:auto">
            <div v-if="dialogStatus==='编辑活动类型'" class="editModule">
              <ul class="editUl">
                <li v-for="(i,k) in activityTypeForm.templateList" :key="k"><img :src="i" alt=""><span @click="delImg(k)">x</span></li>
              </ul>
            </div>
            <el-upload
              ref="upload"
              :headers="headers"
              :on-success="progressU"
              :before-upload="progressULod"
              :on-preview="handlePictureCardPreview"
              :on-remove="handleRemove"
              :action="baseUrl+'springcloud-app-fastdfs/upload/fastUpload'"
              list-type="picture-card">
              <i class="el-icon-plus"/>
            </el-upload>
            <el-dialog :visible.sync="dialogVisible">
              <img :src="dialogImageUrl" width="100%" alt="">
            </el-dialog>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增活动类型'?handleAdd():updateData()">提交</el-button>
          <el-button @click="handleCancle">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- 模板数量弹框 -->
    <template v-if="moduleNumDialogVisible">
      <el-dialog :visible.sync="moduleNumDialogVisible" title="查看">
        <el-table :data="moduleList" border fit highlight-current-row style="width: 100%;height:100%;">
          <el-table-column type="index" width="60" label="序号" align="center" />
          <el-table-column label="类型名称" align="center" prop="typeName" />
          <el-table-column label="状态" align="center" prop="typeStatus">
            <template slot-scope="scope">
              <span :class="scope.row.typeStatus==1 ? 'text-green' : 'text-red'">{{ scope.row.typeStatus==0?'无效':'有效' }}</span>
            </template>
          </el-table-column>
          <el-table-column label="模板数" align="center" prop="fileTotal" />
        </el-table>
        <!-- <div v-if="templateImgList!==undefined&&templateImgList.length>0" style="margin-top:10px"> -->
        <!-- <div v-if="activityTypeForm.templateList!==''" style="margin-top:10px"> -->
        <div style="margin-top:10px">海报模板：</div>
        <div class="acimg">
          <ul class="acUl">
            <li v-for="item in templateImgList" :key="item"><img :src="item" alt="活动海报"></li>
          </ul>
        </div>
        <!-- </div> -->
      </el-dialog>
    </template>
  </div>
</template>

<script>
// import {
//   getTypeList,
//   findActivityType,
//   deleteActivityTypeList,
//   activityTypeAdd,
//   updateActivityType
// } from '@/api/portalManagement/activityType'
import {
  api, paramApi
} from '@/api/axios'
import { getToken } from '@/utils/auth'
export default {
  data() {
    return {
      rules: {
        typeName: [
          { required: true, message: '请输入类型名称', trigger: 'blur' }
        ],
        typeStatus: [
          { required: true, message: '请选择状态', trigger: 'change' }
        ],
        templateList: [
          { required: true, message: '请选择海报图片', trigger: 'blur' }
        ]
      },
      baseUrl: process.env.BASE_API,
      loadingUpFlag: false,
      headers: {
        token: getToken()
      },
      isDisabled: false,
      activityTypeForm: {
        typeName: '',
        typeStatus: '',
        templateList: '',
        typeId: ''
      },
      tableChecked: [],
      ids: [],
      disabled: true,
      dialogStatus: '',
      activityTypedialogFormVisible: false,
      moduleNumDialogVisible: false,
      total: undefined,
      typeList: [],
      moduleList: [{
        typeName: '',
        typeStatus: '',
        fileTotal: ''
      }],
      templateImgList: [],
      templateList: [],
      listLoading: false,
      statusOptions: ['无效', '有效'],
      listQuery: {
        status: undefined,
        typeName: undefined,
        page: 1,
        rows: 10
      },
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  mounted() {
    this.initList()
  },
  methods: {
    delImg(k) {
      this.activityTypeForm.templateList.splice(k, 1)
    },
    progressULod(event) {
      this.loadingUpFlag = true
    },
    progressU(event, file, fileList) {
      // this.activityTypeForm.templateList = file.length
      // console.log(event)
      this.loadingUpFlag = false
      if (event.code === '0000') {
        this.templateList.push(event.data)
        this.$message(event.result)
      } else {
        this.$refs.upload.uploadFiles.splice(this.$refs.upload.uploadFiles.length - 1, 1)
        this.$message.error(event.result)
      }
    },
    handleCancel() {},
    handleRemove(file, fileList) {
      console.log(file, fileList)
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url
      this.dialogVisible = true
    },
    handleFileTotal(row) {
      this.moduleNumDialogVisible = true
      console.log(row)
      this.moduleList[0].typeName = row.typeName
      this.moduleList[0].typeStatus = row.typeStatus
      this.moduleList[0].fileTotal = row.fileTotal
      // const data = { typeId: row.typeId }
      paramApi(`${this.GLOBAL.parkUrl}activity/activityType/findActivityType`, row.typeId, 'typeId').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          if (res.data.data.templateList.length > 0) {
            this.templateImgList = res.data.data.templateList
          }
        }
      })
    },
    //  搜素功能的实现
    handleFilter() {
      this.listQuery.page = 1
      this.initList()
    },
    selecteUserStatus(value) {
      this.listQuery.typeStatus = value
    },
    handleCreate() {
      this.dialogStatus = '新增活动类型'
      this.activityTypeForm.typeName = ''
      this.activityTypeForm.typeStatus = ''
      this.activityTypeForm.templateList = ''
      this.activityTypedialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['activityTypeForm'].clearValidate()
      })
    },
    handleAdd() {
      this.isDisabled = true
      this.$refs['activityTypeForm'].validate(valid => {
        if (valid) {
          api(`${this.GLOBAL.parkUrl}activity/activityType/add`, this.activityTypeForm, 'post').then((res) => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '新增成功',
                type: 'success'
              })
              this.activityTypedialogFormVisible = false
              this.$refs['activityTypeForm'].resetFields()
              // this.progressU()
              this.initList()
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
    handleUpdate(row) {
      this.dialogStatus = '编辑活动类型'
      paramApi(`${this.GLOBAL.parkUrl}activity/activityType/findActivityType`, row.typeId, 'typeId').then(res => {
        if (res.data.code === this.GLOBAL.code) {
          this.templateList = []
          this.activityTypeForm.typeName = res.data.data.typeName
          this.activityTypeForm.typeStatus = res.data.data.typeStatus
          this.activityTypeForm.templateList = res.data.data.templateList
          this.activityTypeForm.typeId = res.data.data.typeId
          this.activityTypedialogFormVisible = true
        }
      })

      // this.$nextTick(() => {
      //   this.$refs['activityTypeForm'].clearValidate()
      // })
    },
    updateData() {
      this.$refs['activityTypeForm'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          // // 调用接口发送请求
          const arr = this.activityTypeForm.templateList.concat(this.templateList)
          const data = {
            templateList: arr.join(','),
            typeId: this.activityTypeForm.typeId,
            typeName: this.activityTypeForm.typeName,
            typeStatus: this.activityTypeForm.typeStatus
          }
          api(`${this.GLOBAL.parkUrl}activity/activityType/updateActivityType`, data, 'post').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
              // 刷新页面显示
              this.initList()
              this.activityTypedialogFormVisible = false
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
          })
        }
      })
    },
    // 取消
    handleCancle() {
      this.activityTypedialogFormVisible = false
      this.loadingUpFlag = false
    },
    deleteActiType(row) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // const data = {
          //   typeId: row.id
          // }
          paramApi(`${this.GLOBAL.parkUrl}activity/activityType/deleteActivityTypeList`, row.typeId, 'typeId').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        })
        .catch(() => {
          // this.$message({
          //   type: 'info',
          //   message: '已取消删除'
          // })
        })
    },
    // 批量删除
    selsChange(val) {
      this.tableChecked = val
      // this.disabled = false
    },
    removeBatch(rows) {
      if (this.tableChecked.length > 0) {
        this.$confirm('是否确认此操作?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          rows.forEach(element => {
            this.ids.push(element.typeId)
          })
          this.ids.join(',')
          // const param = {
          //   'token': getSessiontoken('token'),
          //   'typeId': this.ids
          // }
          paramApi(`${this.GLOBAL.parkUrl}activity/activityType/deleteActivityTypeList`, this.ids, 'typeId').then(res => {
            if (res.data.code === this.GLOBAL.code) {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.listQuery.rows === 1) {
                this.listQuery.page = this.listQuery.page - 1
              }
              this.initList()
            }
          }).catch(() => {
          // alert(2)
          // this.$message({
          //   type: 'info',
          //   message: '已取消'
          // })
          })
        })
      } else {
        alert('请选择要删除的数据')
        return
      }
    },
    // 项目初始化
    initList() {
      this.listLoading = true
      api(`${this.GLOBAL.parkUrl}activity/activityType/findActivityTypeList`, this.listQuery, 'post').then(res => {
        console.log(res)
        if (res.data.code === this.GLOBAL.code) {
          this.typeList = res.data.data.rows
          this.total = res.data.data.total
          if (this.typeList.length === 0 && this.total > 0) {
            this.listQuery.page = 1
            this.initList()
          }
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 分页功能
    handleSizeChange(val) {
      this.listQuery.rows = val
      this.initList()
    },
    // 表格分页功能
    handleCurrentChange(val) {
      this.listQuery.page = val
      this.initList()
    }
  }
}
</script>
<style lang='scss' scoped>
.editModule{
  width: 100%;
  height: 100%;
  ul{
    // display: flex;
    // flex-wrap: wrap;
    padding-left: 0;
    overflow: hidden;
    // width: 350px;
    li{
      // flex:50%;
      float: left;
      width: 148px;
      height: 148px;
      margin-right:10px;
      margin-bottom:5px;
      position: relative;
      img{
        width: 100%;
        height: 100%;
      }
      span{
          position: absolute;
          top: 0;
          right: -5px;
          border: 1px solid #333;
          width: 15px;
          height: 15px;
          text-align: center;
          border-radius: 50%;
          color: red;
          line-height: 13px;
          background: #fff;
          cursor: pointer;
      }
    }
  }
}
.filter-container {
    padding-bottom: 0;
}
.fileTotal {
  cursor: pointer;
  text-decoration: underline;
  color: #409eff;
}
.acimg {
  height: 200px;
  overflow: auto;
  .acUl {
    display: flex;
    flex-wrap: wrap;
    // justify-content: space-between;
    padding-left: 0;
    li {
      // flex: 31%;
      margin-right: 20px;
      margin-bottom: 20px;
      width: 186px;
      height: 150px;
      img {
        width: 100%;
        height: 100%;
        // width: 150px;
        // height: 150px;
      }
    }
    li:nth-child(3n) {
      margin-right: 0;
    }
  }
}
</style>

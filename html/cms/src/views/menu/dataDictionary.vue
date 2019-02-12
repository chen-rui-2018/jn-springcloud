<template>
  <div v-loading="listLoading" class="dictionary">
    <div class="filter-container">
      <el-form :inline="true" :model="dictionaryForm" class="demo-form-inline">
        <el-form-item label="分组编码">
          <el-input v-model="dictionaryForm.groupCode" placeholder="请输入分组编码" maxlength="20" style="width: 130px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="归属模块">
          <el-select v-model="dictionaryForm.moduleCode" placeholder="请选择" style="width: 130px;">
            <el-option v-for="(item,index) in dictionaryOptions" :key="index" :label="item.moduleValue" :value="item.moduleCode"/>
          </el-select>
        </el-form-item>
        <el-form-item label="数据字典键">
          <el-input v-model="dictionaryForm.dictKey" placeholder="请输入数据字典键" maxlength="20" style="width: 130px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-form-item label="数据字典值">
          <el-input v-model="dictionaryForm.dictValue" placeholder="请输入数据字典值" maxlength="20" style="width: 130px;" @keyup.enter.native="handleFilter"/>
        </el-form-item>
        <el-button type="primary" class="searchDd" @click="handleFilter">搜索</el-button>
        <el-button type="primary" @click="handleCreate">添加</el-button>
        <el-button type="primary" @click="handleSort">分组排序</el-button>
        <el-button type="primary" @click="handleModule">模块管理</el-button>
      </el-form>
    </div>
    <el-table ref="dictionaryTable" :key="tableKey" :data="dictionaryData" highlight-current-row border fit style="width: 100%">
      <el-table-column label="序列" type="index" align="center" width="60"/>
      <el-table-column label="父分组编码" prop="parentGroupCode" align="center" width="150" />
      <el-table-column label="分组编码" prop="groupCode" align="center" width="150" />
      <el-table-column label="数据字典键" prop="dictKey" align="center" width="150" />
      <el-table-column label="数据字典值" prop="dictValue" align="center" width="150" />
      <el-table-column label="归属模块" prop="moduleValue" align="center" width="150" />
      <el-table-column label="创建时间" prop="createdTime" align="center"/>
      <el-table-column label="描述" prop="dictDescribe" align="center" width="150" />
      <el-table-column label="操作" prop="operate" align="center">
        <template slot-scope="scope">
          <el-button type="primary" size="mini" @click="handleUpdate(scope.row)">修改</el-button>
          <el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="pagination-container">
      <el-pagination v-show="total>0" :current-page="dictionaryForm.page" :page-sizes="[10,20,30,50]" :page-size="dictionaryForm.rows" :total="total" background layout="total, sizes, prev, pager, next, jumper" @size-change="handleSizeChange" @current-change="handleCurrentChange" />
    </div>
    <!-- 新增弹框 -->
    <template v-if="dictionaryDialogFormVisible">
      <el-dialog :visible.sync="dictionaryDialogFormVisible" :title="dialogStatus" width="450px">
        <el-form ref="dictionaryform" :rules="rules" :model="dictionaryform" label-position="right" label-width="100px" style="max-width:350px;margin-left:20px">
          <el-form-item label="归属模块" prop="moduleCode">
            <el-select v-model="dictionaryform.moduleCode" placeholder="请选择">
              <el-option v-for="(item,index) in dictionaryOptions" :key="index" :label="item.moduleValue" :value="item.moduleCode"/>
            </el-select>
          </el-form-item>
          <el-form-item label="父分组编码:" prop="parentGroupCode">
            <el-input v-model.trim="dictionaryform.parentGroupCode" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="分组编码:" prop="groupCode">
            <el-input v-model.trim="dictionaryform.groupCode" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="数据字典键:" prop="dictKey">
            <el-input v-model.trim="dictionaryform.dictKey" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="数据字典值:" prop="dictValue">
            <el-input v-model.trim="dictionaryform.dictValue" maxlength="100" clearable/>
          </el-form-item>
          <el-form-item label="描述:" prop="dictDescribe">
            <el-input v-model.trim="dictionaryform.dictDescribe" :rows="2" type="textarea" maxlength="100" clearable/>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="dialogStatus==='新增数据字典'?createDictionaryData():updateData()">保存</el-button>
          <el-button @click="dictionaryDialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
    <!-- 分组排序对话框 -->
    <template v-if="groupDialogFormVisible">
      <el-dialog :visible.sync="groupDialogFormVisible" title="选择分组" width="850px">
        <el-form ref="groupform" :inline="true" :model="groupformInline" class="demo-form-inline">
          <el-form-item label="归属模块" prop="moduleCode">
            <el-select v-model="groupformInline.moduleCode" placeholder="请选择" style="width:150px">
              <el-option v-for="(item,index) in dictionaryOptions" :key="index" :label="item.moduleValue" :value="item.moduleCode"/>
            </el-select>
          </el-form-item>
          <el-form-item label="父分组编码">
            <el-input v-model="groupformInline.parentGroupCode" placeholder="请输入父分组编码" style="width:150px"/>
          </el-form-item>
          <el-form-item label="分组编码">
            <el-input v-model="groupformInline.groupCode" placeholder="请输入分组编码" style="width:150px"/>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="handleSearch">搜索</el-button>
          </el-form-item>
        </el-form>
        <div v-show="isShowTab" class="showTab">
          <div v-for="(x,i) in dataItem" :key="i">
            <el-form :inline="true" class="demo-form-inline">
              <el-form-item label="数据字典键">
                <el-input v-model="x.dictKey"/>
              </el-form-item>
              <el-form-item label="数据字典值">
                <el-input v-model="x.dictValue"/>
              </el-form-item>
              <el-form-item>
                <a href="javascript:;" class="fa fa-long-arrow-up" style="color:red" @click="arrON(i)"/>
                <a href="javascript:;" class="fa fa-long-arrow-down" style="color:green;margin-left:10px" @click="arrUP(i)"/>
              </el-form-item>
            </el-form>
          </div>
        </div>
        <div slot="footer" class="dialog-footer" align="center">
          <el-button :disabled="isDisabled" type="primary" @click="handleSaveSort">保存</el-button>
          <el-button @click="groupDialogFormVisible = false">取消</el-button>
        </div>
      </el-dialog>
    </template>
  </div>
</template>
<script>
import { getList, getAllModule, addDictionary, editDictionary, deleteDictionary, sortSearch, groupSort } from '@/api/Permission-model/dataDictionary'
// import '../../utils/index.js'
export default {
  data() {
    var check = (rule, value, callback) => {
      const reg = /^[0-9a-zA-Z_]{1,}$/
      if (!reg.test(value)) {
        callback(new Error('只允许输入数字、字母及下划线'))
      } else {
        callback()
      }
    }
    return {
      listLoading: false,
      dictionaryForm: {
        dictKey: '',
        dictValue: '',
        groupCode: '',
        moduleCode: '',
        page: 1,
        rows: 10
      },
      tableKey: 0,
      dictionaryData: [],
      dictionaryOptions: [],
      total: 0,
      dictionaryDialogFormVisible: false,
      dialogStatus: undefined,
      isDisabled: false,
      dictionaryform: {
        dictId: '',
        moduleCode: '',
        parentGroupCode: '',
        groupCode: '',
        dictKey: '',
        dictValue: '',
        dictDescribe: '',
        sort: 0
      },
      groupDialogFormVisible: false,
      isShowTab: true,
      isData: false,
      isShowInfo: true,
      groupformInline: {
        moduleCode: '',
        parentGroupCode: '',
        groupCode: ''
      },
      rules: {
        moduleCode: [{ required: true, message: '请选择归属模块', trigger: 'change' }],
        parentGroupCode: [
          { required: true, message: '请输入父分组编码', trigger: 'blur' },
          { validator: check, trigger: 'blur' }],
        groupCode: [
          { required: true, message: '请输入分组编码', trigger: 'blur' },
          { validator: check, trigger: 'blur' }
        ],
        dictKey: [
          { required: true, message: '请输入数据字典键', trigger: 'blur' },
          { validator: check, trigger: 'blur' }
        ],
        dictValue: [{ required: true, message: '请输入数据字典值', trigger: 'blur' }]
      },
      dataItem: ''
    }
  },
  mounted() {
    this.initList()
    this.getAllModule()
  },
  methods: {
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`)
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`)
    },
    handleSearch() {
      if (!this.groupformInline.moduleCode) {
        this.$message('请选择归属模块')
        return
      }
      if (!this.groupformInline.parentGroupCode) {
        this.$message('父分组编码不能为空')
        return
      }
      if (!this.groupformInline.groupCode) {
        this.$message('分组编码不能为空')
        return
      }
      this.isShowTab = true
      const data = {
        groupCode: this.groupformInline.groupCode,
        moduleCode: this.groupformInline.moduleCode,
        parentGroupCode: this.groupformInline.parentGroupCode
      }
      sortSearch(data).then(res => {
        if (res.data.code === '0000') {
          this.dataItem = res.data.data
          if (this.dataItem.length === 0) {
            this.$message.error('该搜索条件没有数据')
          }
        } else {
          this.$message.error(res.data.result)
        }
      })
    },
    handleSave() {
      this.$refs['groupform'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          editDictionary().then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.groupDialogFormVisible = false
            this.initList()
          })
        }
      })
    },
    handleCreate() {
      this.dictionaryform.moduleCode = ''
      this.dictionaryform.parentGroupCode = ''
      this.dictionaryform.groupCode = ''
      this.dictionaryform.dictKey = ''
      this.dictionaryform.dictValue = ''
      this.dictionaryform.dictDescribe = ''
      this.dictionaryform.dictId = ''
      this.dialogStatus = '新增数据字典'
      this.dictionaryDialogFormVisible = true
      this.$nextTick(() => {
        this.$refs['dictionaryform'].clearValidate()
      })
    },
    handleSort() {
      this.groupformInline.groupCode = ''
      this.groupformInline.moduleCode = ''
      this.groupformInline.parentGroupCode = ''
      this.dataItem = ''
      this.groupDialogFormVisible = true
    },
    handleModule() {
      this.$router.push({ path: 'moduleManagement' })
    },
    handleUpdate(row) {
      // 显示对话框
      this.dictionaryDialogFormVisible = true
      //  添加默认数据
      this.dialogStatus = '修改数据字典'
      this.dictionaryform.moduleCode = row.moduleCode
      this.dictionaryform.parentGroupCode = row.parentGroupCode
      this.dictionaryform.groupCode = row.groupCode
      this.dictionaryform.dictKey = row.dictKey
      this.dictionaryform.dictValue = row.dictValue
      this.dictionaryform.dictDescribe = row.dictDescribe
      this.dictionaryform.dicyId = row.id
      this.dictionaryform.sort = row.sort
      this.$nextTick(() => {
        this.$refs['dictionaryform'].clearValidate()
      })
    },
    handleDelete(id) {
      this.$confirm(`此操作将永久删除这条数据, 是否继续?`, '删除提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          deleteDictionary(id).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '删除成功',
                type: 'success'
              })
              if (this.total % this.dictionaryForm.rows === 1) {
                debugger
                this.dictionaryForm.page = this.dictionaryForm.page - 1
              }
              this.initList()
            } else {
              this.$message.error(res.data.result)
            }
          })
        }).catch(() => {

        })
    },
    // 初始化
    initList() {
      this.listLoading = true
      getList(this.dictionaryForm).then(res => {
        if (res.data.code === '0000') {
          this.dictionaryData = res.data.data.rows
          this.total = res.data.data.total
        } else {
          this.$message.error(res.data.result)
        }
        this.listLoading = false
      })
    },
    // 获取全部模块
    getAllModule() {
      getAllModule().then(res => {
        if (res.data.code === '0000') {
          res.data.data.forEach(val => {
            this.dictionaryOptions.push({
              value: val.moduleCode,
              label: val.moduleValue
            })
          })
        } else {
          this.$message.error(res.data.result)
        }
        this.dictionaryOptions = res.data.data
      })
    },
    // 新增
    createDictionaryData() {
      this.isDisabled = true
      this.$refs['dictionaryform'].validate(valid => {
        if (valid) {
          // 调用接口发送请求
          addDictionary(this.dictionaryform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '添加成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.dictionaryDialogFormVisible = false
            this.initList()
          })
        } else {
          this.isDisabled = false
        }
      })
    },
    // 编辑
    updateData() {
      this.$refs['dictionaryform'].validate(valid => {
        if (valid) {
          this.isDisabled = true
          editDictionary(this.dictionaryform).then(res => {
            if (res.data.code === '0000') {
              this.$message({
                message: '编辑成功',
                type: 'success'
              })
            } else {
              this.$message.error(res.data.result)
            }
            this.isDisabled = false
            this.dictionaryDialogFormVisible = false
            this.initList()
          })
        }
      })
    },
    // 查询功能
    handleFilter() {
      this.dictionaryForm.page = 1
      this.initList()
    },
    arrON(i) {
      if (i === 0) {
        this.$message.error('到顶了')
        return
      }
      const x = i
      const y = i - 1
      this.dataItem.splice(x, 1, ...this.dataItem.splice(y, 1, this.dataItem[x]))
    },
    arrUP(i) {
      if (i === this.dataItem.length - 1) {
        this.$message.error('到底了')
        return
      }
      const x = i
      const y = i + 1
      this.dataItem.splice(x, 1, ...this.dataItem.splice(y, 1, this.dataItem[x]))
    },
    handleSaveSort() {
      if (this.dataItem.length === 0) {
        this.$message.error('请先输入分组')
        return
      }
      const dictData = []
      let index = 0
      for (const it of this.dataItem) {
        const dictObj = { id: it.id, sort: index }
        dictData.push(dictObj)
        index = index + 1
      }
      groupSort(dictData).then(res => {
        if (res.data.code === '0000') {
          this.groupDialogFormVisible = false
          this.initList()
        }
        // this.$message(res.data.result)
        // this.$message('排序成功')
      })
    }
  }
}
</script>
<style lang="scss">
.searchDd{
  margin-right:30px;
}
.showTab{
  margin-left:70px
}
</style>

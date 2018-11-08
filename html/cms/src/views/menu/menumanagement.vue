<template>
  <div class="menumanagement">
    <header>菜单管理</header>
    <el-row :gutter="20">
      <el-col :span="6">
        <div>
          <el-tree :data="data4" :props="defaultProps" :expand-on-click-node="false" :render-content="renderContent" ref="tree" node-key="id" default-expand-all @node-click="handleNodeClick"/>
        </div>
      </el-col>
      <el-col :span="18">
        <div class=" bgc">
          <div class="down-departmen">下级部门</div>
          <div class="content">
            <div class="left">
              <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item >易软天创</el-breadcrumb-item>
                <el-breadcrumb-item >开发 </el-breadcrumb-item>
                <el-breadcrumb-item>后台</el-breadcrumb-item>
                <el-breadcrumb-item>Java工程师</el-breadcrumb-item>
              </el-breadcrumb>
            </div>
            <div class="right">
              <el-form ref="dynamicValidateForm" :model="dynamicValidateForm" class="demo-dynamic">
                <el-form-item v-for="(item,index) in dynamicValidateForm.domains" :key="index">
                  <el-input v-model="dynamicValidateForm.domains.value1"/>
                </el-form-item>
                <el-form-item class="footer">
                  <el-button type="primary" @click="submitForm('dynamicValidateForm')">保存</el-button>
                  <el-button >新增</el-button>
                  <el-button @click="resetForm('dynamicValidateForm')">取消</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-dialog
      :visible.sync="editdialogVisible"
      title="编辑部门"
    >
      <el-form ref="editform" :model="editform" label-width="180px">
        <el-form-item label="上级部门">
          <el-select v-model="value5" placeholder="请选择">
            <el-option
              v-for="(item,index) in editform.updata"
              :key="index"
              :label="item"
              :value="item"/>
          </el-select>
        </el-form-item>
        <el-form-item label="部门名称">
          <el-input v-model="editform.name" style="width:200px;"/>
        </el-form-item>
        <el-form-item label="负责人">
          <el-select v-model="value6" placeholder="请选择">
            <el-option
              v-for="(item,index) in editform.options"
              :key="index"
              :label="item"
              :value="item"/>
          </el-select>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="editdialogVisible = false">保存</el-button>
          <el-button @click="editdialogVisible = false">取消</el-button>
        </el-form-item>
      </el-form>

    </el-dialog>

  </div>
</template>

<script>
export default {
  data() {
    return {
      value6: '',
      value5: '',
      editdialogVisible: false,
      data4: [
        {
          label: '开发部',
          children: [
            {
              label: '前端',
              children: [
                {
                  label: '前端工程师',
                }
              ]
            },
            {
              label: '后台',
              children: [
                {
                  label: 'Java工程师'
                }
              ]
            }
          ]
        },
        {
          label: '产品',
          children: [
            {
              label: '二级 2-1',
              children: [
                {
                  label: '三级 2-1-1'
                }
              ]
            },
            {
              label: '二级 2-2',
              children: [
                {
                  label: '三级 2-2-1'
                }
              ]
            }
          ]
        },
        {
          label: '测试',
          children: [
            {
              label: '测试1',
              children: [
                {
                  label: '三级 3-1-1',
                  children: [{ label: 155 }]
                }
              ]
            },
            {
              label: '二级 3-2',
              children: [
                {
                  label: '三级 3-2-1'
                }
              ]
            }
          ]
        }
      ],
      defaultProps: {
        children: 'children',
        label: 'label'
      },
      dynamicValidateForm: {
        value: '',
        domains: [
          {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }, {
            value1: ''
          }
        ]
      },
      editform: { name: '开发部', updata: ['开发部', '测试部', '工程部'], options: ['fgvbsrf', 'gfbsfg', 'bfd', 'fdbvd'] }

    }
  },
  methods: {
    handleNodeClick(data) {
      // console.log( this.$refs.currentNode.node)
      console.log( this.$refs.tree.getCurrentNode
)
    },
    renderContent(h, { node, data, store }) {
      return (
        <span style=' align-items: center; font-size: 14px'>
          <span>
            <span>{node.label}</span>
          </span>
          <span style='margin-left:10px'>
            <el-button type='text'>
              排序
            </el-button>
            <el-button on-click={ () => this.edit(data) } type='text' >
              编辑
            </el-button>
          </span>
        </span>
      )
    },
    edit(data) {
      this.editdialogVisible = true
      this.editform.name = data.label
      console.log(data)
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert('submit!')
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    }
  }
}
</script>

<style lang="scss" scoped>
.menumanagement {
  padding: 10px;
  header {
    margin-bottom: 10px;
  }
  .el-col-6 {
    padding: 15px 10px;
    background-color: #fff;
  }
  .bgc {
    padding: 20px;
  }
  .content {
    display: flex;
    .left {
      // flex:1;
      margin-right: 20px;
      display: flex;
      align-items: center;
    }
    .right {
      width: 300px;
      .el-form-item{
        margin-bottom:0;
      }
      .el-input {
        margin-top: 5px;
      }
      .footer{
        margin-top: 10px;
      }
    }
  }
}
</style>

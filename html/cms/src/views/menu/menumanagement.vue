<template>
  <div class="menumanagement">
    <header>菜单管理</header>
    <el-row :gutter="40">
      <el-col :span="6">
        <div>
          <el-tree ref="tree" :data="data4" :expand-on-click-node="false" :render-content="renderContent" node-key="id" default-expand-all @node-click="handleNodeClick" />
        </div>
      </el-col>
      <el-col :span="18">
        <div class=" bgc">
          <div class="down-departmen">下级部门</div>
          <div class="content">
            <div class="left">
              <el-breadcrumb separator-class="el-icon-arrow-right">
                <el-breadcrumb-item>{{ parentlabel }}</el-breadcrumb-item>
                <el-breadcrumb-item>{{ label }} </el-breadcrumb-item>

              </el-breadcrumb>
            </div>
            <div class="right">
              <el-form ref="dynamicValidateForm" :model="dynamicValidateForm" class="demo-dynamic">
                <el-form-item v-for="(item,index) in dynamicValidateForm.domains" :key="index">
                  <el-input v-model="item.label" />
                </el-form-item>
                <el-form-item class="footer">
                  <el-button type="primary" @click="submitForm('dynamicValidateForm')">保存</el-button>
                  <el-button @click="resetForm('dynamicValidateForm')">取消</el-button>
                </el-form-item>
              </el-form>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-dialog :visible.sync="editdialogVisible" title="编辑部门">
      <el-form ref="editform" :model="editform" label-width="180px">
        <el-form-item label="上级部门">
          <el-select v-model="value5" placeholder="请选择">
            <el-option v-for="(item,index) in editform.updata" :key="index" :label="item" :value="item" />
          </el-select>
        </el-form-item>
        <el-form-item label="部门名称">
          <el-input v-model="editform.name" style="width:200px;" />
        </el-form-item>
        <el-form-item label="负责人">
          <el-select v-model="value6" placeholder="请选择">
            <el-option v-for="(item,index) in editform.options" :key="index" :label="item" :value="item" />
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
      parentlabel: '',
      childrenlabel: '',
      label: '',
      value6: '',
      value5: '',
      value3: '',
      editdialogVisible: false,
      data4: [
        {
          id: 1,
          label: '开发部',
          children: [
            {
              id: 4,
              label: '产品',
              parentlabel: '开发部',
              children: [
                {
                  id: 9,
                  label: '前端',
                  parentlabel: '产品'
                },
                {
                  id: 10,
                  label: '后台',
                  parentlabel: '产品'
                }
              ]
            }
          ]
        },
        {
          id: 2,
          label: '测试',
          children: [
            {
              id: 5,
              label: '二级 2-1',
              parentlabel: '测试'
            },
            {
              id: 6,
              label: '二级 2-2',
              parentlabel: '测试'
            }
          ]
        },
        {
          id: 3,
          label: '一级 3',
          children: [
            {
              id: 7,
              label: '二级 3-1',
              parentlabel: '一级3'
            },
            {
              id: 8,
              label: '二级 3-2',
              parentlabel: '一级3'
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
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          },
          {
            label: ''
          }
        ]
      },
      editform: {
        name: '开发部',
        updata: ['开发部', '测试部', '工程部'],
        options: ['fgvbsrf', 'gfbsfg', 'bfd', 'fdbvd']
      }
    }
  },
  mounted() {
    this.parentlabel = '开发部'
  },
  methods: {
    handleNodeClick(data) {
      console.log(data)
      this.label = data.label
      this.parentlabel = data.parentlabel
      if (data.children !== undefined) {
        this.dynamicValidateForm.domains = data.children
      } else {
        console.log(data.children)
        this.dynamicValidateForm.domains
      }
    },
    renderContent(h, { node, data, store }) {
      return (
        <span style=' align-items: center; font-size: 14px'>
          <span>
            <span>{node.label}</span>
          </span>
          <span style='margin-left:10px'>
            <el-button type='text'on-click={() => this.edit(data)} >新增</el-button>
            <el-button on-click={() => this.edit(data)} type='text'>
              编辑
            </el-button>
            <el-button type='text'>删除</el-button>
          </span>
        </span>
      )
    },
    edit(data) {
      this.editdialogVisible = true
      this.editform.name = data.label
      this.value5 = data.parentlabel
      console.log(data)
    },
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          console.log(this.dynamicValidateForm)
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
    padding: 20px 0 20px 20px;
  }
  .content {
    display: flex;
    .left {
      // flex:1;
      margin-right: 30px;
      display: flex;
      align-items: center;
    }
    .right {
      width: 300px;
      .el-form-item {
        margin-bottom: 0;
      }
      .el-input {
        margin-top: 5px;
      }
      .footer {
        margin-top: 10px;
      }
    }
  }
}
</style>

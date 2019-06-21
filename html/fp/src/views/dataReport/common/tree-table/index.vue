<template>
  <el-table
    :row-class-name="setClassName"
    :data="formatData"
    :row-key="getRowKeys"
    :row-style="showRow"
    :header-cell-style="{textAlign: 'center' }"
    v-bind="$attrs">
    <el-table-column v-if="columns.length===0" width="150">
      <template slot-scope="scope">
        <span v-for="space in scope.row._level" :key="space" class="ms-tree-space"/>
        <span v-if="iconShow(0,scope.row)" class="tree-ctrl" @click="toggleExpanded(scope.$index)">
          <i v-if="!scope.row._expanded" class="el-icon-plus"/>
          <i v-else class="el-icon-minus"/>
        </span>
        {{ scope.$index }}
      </template>
    </el-table-column>

    <el-table-column
      v-for="(column, index) in columns"
      :fixed="index === 0 ? 'left' : false"
      v-else :key="column.value"
      :label="column.text"
      :align="index === 0 || column.value === 'inputFormatModel' ? 'left' : 'center'"
      :width="column.width">
      <template slot-scope="scope">
        <div class="td-cell">
          <div v-if="index === 0" class="td-cell-l">
            <span v-if="!isMobile">
              <span v-for="space in scope.row._level" :key="space" class="ms-tree-space"/>
            </span>
            <span v-if="iconShow(index,scope.row)" class="tree-ctrl" @click="toggleExpanded(scope.$index)">
              <i v-if="!scope.row._expanded" class="el-icon-caret-right"/>
              <i v-else class="el-icon-caret-bottom"/>
              <svg class="icon svg-icon" aria-hidden="true">
                 <use xlink:href="#icon-folder"></use>
              </svg>
            </span>
            <span v-else-if="index === 0">
              <i class="icon iconfont icon-document folder-yellow"></i>
            </span>
          </div>
          <div class="td-cell-r">
            <!--          类型（0：文本框1：多行文本框2：数字3：单选框4：多选框5：图片上传）-->
            <div
              v-if="typeof scope.row['inputFormatModel'] === 'object' && column.value === 'inputFormatModel'"
              class="target-row">
              <el-row v-for="(ruleRow, index) in scope.row['inputFormatModel']" :key="index" class="target-bg">
                <el-col v-for="(item, itemIndex) in ruleRow" :key="itemIndex" :span="18" class="target-bg-cell">
                  <el-row v-if="item.formType === '0'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-input
                        :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])"
                        v-model="item.value"
                        :class="{'isMobile': isMobile}"
                        class="target-input"/>
                    </el-col>
                  </el-row>
                  <el-row v-if="item.formType === '1'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-input :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])" v-model="item.value" type="textarea"/>
                    </el-col>
                  </el-row>
                  <el-row v-else-if="item.formType === '2'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-input-number
                        :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])"
                        :min="0"
                        v-model="item.value"
                        :class="{'isMobile': isMobile}"
                        class="target-input"/>
                    </el-col>
                  </el-row>
                  <el-row v-else-if="item.formType === '3'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-radio-group v-model="item.value" :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])">
                        <el-radio v-for="name in item.choiceOption.split(',')" :key="name" :label="name" :name="name"/>
                      </el-radio-group>
                    </el-col>
                  </el-row>
                  <el-row v-else-if="item.formType === '4'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-checkbox-group v-model="item.value" :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])">
                        <el-checkbox v-for="name in item.choiceOption.split(',')" :key="name" :label="name" :name="name"/>
                      </el-checkbox-group>
                    </el-col>
                  </el-row>
                  <el-row v-else-if="item.formType === '5'" :gutter="10" type="flex" align="middle">
                    <el-col :span="leftCol">{{ item.formName }}</el-col>
                    <el-col :span="24 - leftCol">
                      <el-upload
                        :disabled="isReported === 0 || (modelType === 1 && !scope.row['hasJurisdiction'])"
                        :on-error="handleError"
                        :headers="headers"
                        :on-remove="(file, fileList) => { return handleRemove(file, fileList, item)}"
                        :before-upload="beforeUpload"
                        :on-success="(res, file, fileList) => { return uploadDone(res, file, fileList, item)}"
                        :on-exceed="handleExceed"
                        :limit="1"
                        :action="api.host+'springcloud-app-fastdfs/upload/fastUpload'"
                        :file-list="item.fileList"
                        list-type="picture">
                        <el-button size="small" type="primary" v-if="isReported !== 0">点击上传</el-button>
                        <div v-if="isReported === 0 && item.fileList.length === 0">暂无附件</div>
                        <div slot="tip" class="el-upload__tip" v-if="isReported !== 0">只能上传jpg/png文件，且不超过20M</div>
                      </el-upload>
                    </el-col>
                  </el-row>
                </el-col>
                <el-col v-if="scope.row.isMuiltRow === '0' && (isReported === 1 && modelType === 0 || (isReported === 1 && modelType === 1 && scope.row['hasJurisdiction']))" :span="6" style="text-align: right">
                  <el-button size="mini" type="primary" icon="el-icon-plus" @click="addMultipleForm(scope.row['inputFormatModel'], index)"/>
                  <el-button v-if="index !== 0" size="mini" type="warning" icon="el-icon-minus" @click="deleteMultipleForm(scope.row['inputFormatModel'], index)"/>
                </el-col>
              </el-row>
            </div>
            <div v-else-if="typeof scope.row[column.value] === 'object' && column.value !== 'inputFormatModel'" class="target-row">
              <div v-for="(item, index) in scope.row[column.value]" :key="index" class="other-column">
                <span v-if="item.label">{{ item.label + '：' + item.value}}</span>
                <span v-else>{{ item.value }}</span>
              </div>
            </div>
            <span v-else>{{ scope.row[column.value] }}</span>
          </div>
        </div>
      </template>
    </el-table-column>
    <slot/>
  </el-table>
</template>

<script>
import { deepClone, isMobile } from '@/util'
import treeToArray from './eval'
import { getToken } from '@/util/auth'
export default {
  name: 'TreeTable',
  props: {
    modelType: {
      type: Number,
      required: true
    },
    isReported: {
      type: Number,
      required: false
    },
    data: {
      type: [Array, Object],
      required: true
    },
    columns: {
      type: Array,
      default: () => []
    },
    evalFunc: {
      type: Function,
      required: false
    },
    evalArgs: {
      type: Array,
      default() {
        return []
      }
    },
    expandAll: {
      type: Boolean,
      default: false
    }
  },
  created() {
    this.leftCol = !this.isMobile ? 6 : 4
  },
  data() {
    return {
      leftCol: null,
      isMobile: isMobile(),
      headers: {
        token: getToken()
      },
      getRowKeys(row) {
        return row.id;
      },
      setClassName(row) {
        if (row.row.hasJurisdiction) {
          return 'success-row'
        }
      }
    }
  },
  computed: {
    // 格式化数据源
    formatData() {
      let tmp
      if (!Array.isArray(this.data)) {
        tmp = [this.data]
      } else {
        tmp = this.data
      }
      const func = this.evalFunc || treeToArray
      const args = this.evalArgs ? Array.concat([tmp, this.expandAll], this.evalArgs) : [tmp, this.expandAll]
      return func.apply(null, args)
    }
  },
  methods: {
    addMultipleForm(form, index) {
      // 动态添加多行
      const row = deepClone(form[0])
      for (const item of row) {
        switch (item.formType) {
          case '2':
            item.value = null
            break
          case '4':
            item.value = []
            break
          default:
            item.value = ''
        }
      }
      form.splice(index + 1, 0, row)
    },
    deleteMultipleForm(form, index) {
      if (form.length === 1) {
        this.$message.warning('已经是最后一个了!')
        return
      }
      this.$confirm('确定删除该指标组?', '', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        form.splice(index, 1)
        this.$message({
          type: 'success',
          message: '删除成功!'
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    },
    showRow(row) {
      const show = (row.row.parent ? (row.row.parent._expanded && row.row.parent._show) : true)
      row.row._show = show
      return show ? 'animation:treeTableShow 1s;-webkit-animation:treeTableShow 1s;' : 'display:none;'
    },
    // 切换下级是否展开
    toggleExpanded(trIndex) {
      const record = this.formatData[trIndex]
      record._expanded = !record._expanded
    },
    // 图标显示
    iconShow(index, record) {
      return (index === 0 && record.children && record.children.length > 0)
    },
    uploadDone(res, file, fileList, item) {
      item.value = res.data
    },
    beforeUpload(file, isRequireFileType) {
      // 判断上传文件类型
      if (isRequireFileType) {
        const isAccept = this.acceptType.indexOf(file.name.substring(file.name.lastIndexOf('.') + 1).toLowerCase())
        if (isAccept < 0) {
          this.$message.warning(`只支持${this.acceptType.join(',')}文件类型`)
          return false
        }
      }
      if (file.size / 1024 / 1024 > 20) {
        this.$message.warning('文件不能大于20M')
        return false
      }
    },
    handleRemove(file, fileList, value) {
      // value = ''
    },
    handleError(e) {
      throw new Error(e)
    },
    handleExceed(files, fileList) {
      this.$message.warning(`最多只能上传1个附件`)
    }
  }
}
</script>
<style rel="stylesheet/css">
  @keyframes treeTableShow {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }

  @-webkit-keyframes treeTableShow {
    from {
      opacity: 0;
    }
    to {
      opacity: 1;
    }
  }
</style>

<style lang="scss" rel="stylesheet/scss" scoped>
  @import "~@/css/r-common";
  $color-blue: #2196F3;
  $space-width: 1em;
  $gray: #ebebeb;
  .ms-tree-space {
    position: relative;
    top: 1px;
    display: inline-block;
    font-style: normal;
    font-weight: 400;
    line-height: 1;
    width: $space-width;
    height: 14px;

    &::before {
      content: ""
    }
  }

  .processContainer {
    width: 100%;
    height: 100%;
  }

  table td {
    line-height: 26px;
  }
  .svg-icon {
    width: 1em;
    height: 1em;
    fill: currentColor;
    overflow: hidden;
    font-size: 16px;
    vertical-align: middle;
  }
  .folder-yellow {
    color: #F5D46F;
  }
  .el-icon-caret-right {
    color: #666;
  }
  .el-icon-caret-bottom {
    color: #ccc;
  }
  .tree-ctrl {
    position: relative;
    cursor: pointer;
    color: $color-blue;
    margin-left: -$space-width;
  }
  .td-cell {
    @include flex($h: flex-start, $v: flex-start);
    .td-cell-l {
      flex: none;
      margin: 1px 4px;
    }
    .td-cell-r {
      flex: 1;
    }
  }
  .target-row {
    .target-bg {
      margin-top: 20px;
      border-bottom: 1px solid $gray;
      &:last-of-type {
        border-bottom: none;
      }
      &:first-of-type {
        margin-top: 0;
      }
      .target-bg-cell {
        margin-bottom: 20px;
        &:last-of-type {
          margin-bottom: 0;
        }
      }
  }
    .target-input {
      width: 220px;
      &.isMobile {
        width:130px;
      }
    }
    .other-column {
      padding: 10px;
    }
  }
</style>
<style lang="scss">
  .isMobile {
    .el-upload-list {
      width: 200px;
    }
  }
  .el-table {
    .success-row {
      background-color: #f0f9eb;
    }
    .info-row {
      background-color: #fafafa;
    }
  }
</style>

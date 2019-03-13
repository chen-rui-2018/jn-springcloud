<template>
  <div class="table">
    <el-table
      v-loading.iTable="options.loading"
      id="iTable"
      ref="mutipleTable"
      :data="list"
      :stripe="options.stripe"
      @selection-change="handleSelectionChange"
    >
      <!--endregion-->
      <!--region 数据列-->
      <el-table-column type="index" width="60" label="序号" align="center" />
      <template v-for="(column, index) in columns">
        <el-table-column
          :prop="column.prop"
          :key="column.label"
          :label="column.label"
          :align="column.align"
          :width="column.width"
        >
          <template slot-scope="scope">
            <template v-if="!column.render">
              <template v-if="column.formatter">
                <span v-html="column.formatter(scope.row, column)"/>
              </template>
              <template v-else>
                <span>{{ scope.row[column.prop] }}</span>
              </template>
            </template>
            <template v-else>
              <expand-dom
                :column="column"
                :row="scope.row"
                :render="column.render"
                :index="index"
              />
            </template>
          </template>
        </el-table-column>
      </template>
      <!--endregion-->
      <!--region 按钮操作组-->
      <el-table-column
        v-if="operates.list.filter(_x=>_x.show === true).length > 0"
        ref="fixedColumn"
        :width="operates.width"
        :fixed="operates.fixed"
        label="操作"
        align="center"
      >
        <template slot-scope="scope">
          <div class="operate-group">
            <template v-for="(btn, key) in operates.list">
              <div
                v-if="btn.show"
                :key="btn.id"
                class="item"
              >
                <el-button
                  :type="btn.type"
                  :icon="btn.icon"
                  :disabled="btn.disabled"
                  :plain="btn.plain"
                  size="mini"
                  @click.native.prevent="btn.method(key,scope.row)"
                >{{ btn.label }}
                </el-button>
              </div>
            </template>
          </div>
        </template>
      </el-table-column>
      <!--endregion-->
    </el-table>

  </div>
</template>
<!--endregion-->
<script>
export default {
  // 组件
  components: {
    expandDom: {
      functional: true,
      props: {
        row: Object,
        render: Function,
        index: Number,
        column: {
          type: Object,
          default: null
        }
      },
      render: (h, ctx) => {
        const params = {
          row: ctx.props.row,
          index: ctx.props.index
        }
        if (ctx.props.column) params.column = ctx.props.column
        return ctx.props.render(h, params)
      }
    }
  },
  props: {
    list: {
      type: Array,
      default: function() {
        return []
      }
    }, // 数据列表
    columns: {
      type: Array,
      default: function() {
        return []
      }
    }, // 需要展示的列 === prop：列数据对应的属性，label：列名，align：对齐方式，width：列宽
    operates: {
      type: Array,
      default: function() {
        return []
      }
    }, // 操作按钮组 === label: 文本，type :类型（primary / success / warning / danger / info / text），show：是否显示，icon：按钮图标，plain：是否朴素按钮，disabled：是否禁用，method：回调方法
    options: {
      type: Object,
      default: function() {
        return {}
      }
    } // table 表格的控制参数
  },
  // 数据
  data() {
    return {
      pageIndex: 1,
      multipleSelection: [] // 多行选中
    }
  },
  computed: {},
  mounted() {},
  methods: {
    // 多行选中
    handleSelectionChange(val) {
      this.multipleSelection = val
      this.$emit('handleSelectionChange', val)
    },
    // 显示 表格操作弹窗
    showActionTableDialog() {
      console.log(4444)
      this.$emit('handelAction')
    }
  }
}
</script>
<style lang="scss" >
</style>

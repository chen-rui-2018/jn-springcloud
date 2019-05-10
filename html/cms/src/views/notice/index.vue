<template>
  <div class="external-notice">
    <div class="notice-header">
      <div class="search-row">
        <div>
          <el-radio-group
            v-model="searchData.noticeStatus"
            @change="queryChange">
            <el-radio-button
              v-for="item in noticeStatusOptions"
              :key="item.name"
              :label="item.name"
            >{{ item.label }}</el-radio-button>
          </el-radio-group>
          <el-radio-group
            v-model="searchData.homeShow"
            @change="queryChange">
            <el-radio-button
              v-for="item in homeShowOptions"
              :key="item.name"
              :label="item.name"
            >{{ item.label }}</el-radio-button>
          </el-radio-group>
          <el-radio-group
            v-model="searchData.homePopup"
            @change="queryChange">
            <el-radio-button
              v-for="item in homePopupOptions"
              :key="item.name"
              :label="item.name"
            >{{ item.label }}</el-radio-button>
          </el-radio-group>
        </div>
        <div>
          <el-input
            v-model="searchData.keyWord"
            placeholder="公告标题、平台"
            prefix-icon="el-icon-search"
            style="width: 160px"
            @input="queryChange"/>
          <el-button type="primary" @click="addData">新增</el-button>
        </div>
      </div>
    </div>
    <div class="notice-main">
      <el-table
        v-loading="loading"
        :data="tableData"
        :header-cell-style="{backgroundColor: '#e0f1fc'}"
        border
        style="width: 100%; min-height: 400px;"
      >
        <div v-for="column in columns" :key="column.name">
          <el-table-column
            v-if="column.render"
            :label="column.label"
            :width="column.width"
            :fixed="column.fixed"
            align="center">
            <template slot-scope="scope">
              <div>{{ options[column.name + 'Options'][scope.row[column.name]] }}</div>
            </template>
          </el-table-column>
          <el-table-column
            v-else
            :prop="column.name"
            :width="column.width"
            :label="column.label"
            :fixed="column.fixed"
            align="center"/>
        </div>
        <el-table-column
          label="操作"
          width="200"
          fixed="right"
          align="center">
          <template slot-scope="scope">
            <el-button type="text" size="small" @click="editData(scope.row)">编辑</el-button>
            <el-button type="text" size="small" @click="deleteData(scope.row)">下架</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination-row">
        <el-pagination
          :current-page="query.page"
          :page-sizes="[query.rows, 200, 300, 400]"
          :page-size="query.rows"
          :total="total"
          background
          layout="total, sizes, prev, pager, next, jumper"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
        />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'NoticeIndex',
  data() {
    return {
      loading: false,
      originQuery: {},
      query: {
        homePopup: null,
        homeShow: null,
        keyWord: '',
        noticeStatus: null,
        page: 1,
        rows: 100
      },
      total: 0,
      searchData: {
        homePopup: null,
        homeShow: null,
        keyWord: '',
        noticeStatus: null
      },
      noticeStatusOptions: [{
        label: '全部',
        name: null
      }, {
        label: '有效',
        name: '1'
      }, {
        label: '无效',
        name: '0'
      }],
      homePopupOptions: [{
        label: '全部',
        name: null
      }, {
        label: '首页弹出',
        name: '1'
      }, {
        label: '首页不弹出',
        name: '0'
      }],
      homeShowOptions: [{
        label: '全部',
        name: null
      }, {
        label: '首页展示',
        name: '1'
      }, {
        label: '首页不展示',
        name: '0'
      }],
      options: {
        homePopupOptions: {
          '0': '否',
          '1': '是'
        },
        homeShowOptions: {
          '0': '否',
          '1': '是'
        },
        platformNameOptions: {
          '0': '否',
          '1': '是'
        },
        noticeStatusOptions: {
          '0': '无效',
          '1': '有效'
        }
      },
      columns: [{
        label: '序列',
        name: 'index'
      }, {
        label: '公告标题',
        name: 'noticeTitle',
        fixed: true,
        width: 180
      }, {
        label: '公告内容',
        name: 'noticeDetails',
        width: 200
      }, {
        label: '起止时间',
        name: 'startTime',
        width: 120
      }, {
        label: '发布人',
        name: 'publishName'
      }, {
        label: '发布时间',
        name: 'createdTime',
        width: 160
      }, {
        label: '是否首页弹出',
        name: 'homePopup',
        render: true,
        width: 110
      }, {
        label: '是否首页展示',
        name: 'homeShow',
        render: true,
        width: 110
      }, {
        label: '排序',
        name: 'sortField'
      }, {
        label: '状态',
        name: 'noticeStatus',
        render: true,
        width: 120
      }],
      tableData: []
    }
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      // 把初始表单数据保存起来，提交完重置时可能用到
      this.originQuery = Object.assign({}, this.query)
      this.getData()
    },
    handleSizeChange(val) {
      this.query.rows = val
      this.getData()
    },
    handleCurrentChange(val) {
      this.query.page = val
      this.getData()
    },
    addData() {
      this.$router.push({
        path: '/notice/noticePublish'
      })
    },
    editData(row) {
      this.$router.push({
        path: '/notice/noticePublish',
        query: {
          noticeId: row.noticeId
        }
      })
    },
    deleteData(row) {
      const data = {
        noticeId: row.noticeId,
        noticeStatus: row.noticeStatus
      }
      this.$confirm('确定下架这条公告?', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$_post(`${this.GLOBAL.parkUrl}park/notice/noticeShelfOperate`, data)
          .then(data => {
            if (data.code === '0000') {
              this.getData()
              this.$message.success('下架成功!')
            } else {
              this.$message.error(data.result)
            }
          })
      })
    },
    getData() {
      this.loading = true
      this.$_get(`${this.GLOBAL.parkUrl}park/notice/findNoticeList`, this.query)
        .then(data => {
          if (data.code === '0000') {
            this.tableData = data.data.rows.map((item, index) => {
              this.$set(item, 'index', index + 1)
              this.total = data.data.total
              return item
            })
          } else {
            this.$message.error(data.result)
          }
          this.loading = false
        })
    },
    queryChange() {
      this.query = Object.assign(this.query, this.searchData)
      this.getData()
    }
  }
}
</script>

<style lang="scss" scoped>
@import "~@/styles/r-common";
.external-notice {
  .notice-header {
    background-color: #f5f5f5;
    padding: 10px;
  }
  .search-row {
    @include flex($h: space-between);
    flex-wrap: wrap;
  }
  .pagination-row {
    margin-top: 10px;
    padding: 10px;
    text-align: right;
  }
}
</style>

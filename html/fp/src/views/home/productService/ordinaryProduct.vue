<template>
  <div class="ordinaryProduct">
    <div class="ordinary_title">
      <div>常规服务产品</div>
      <div @click="goputaway">常规产品上架</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
        <div></div>
        <el-input placeholder="请输入内容" v-model="searchData">
          <el-button slot="append" icon="el-icon-search"></el-button>
        </el-input>
      </div>
      <div class="ordinary_table">
        <el-table :data="ordinaryTable" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="date" label="产品名称" align="center"> </el-table-column>
          <el-table-column prop="date" label="服务机构" align="center"> </el-table-column>
          <el-table-column prop="date" label="业务领域" align="center"> </el-table-column>
          <el-table-column prop="date" label="服务顾问" align="center"> </el-table-column>
          <el-table-column prop="date" label="发布日期" align="center"> </el-table-column>
          <el-table-column prop="date" label="发布状态" align="center"> </el-table-column>
          <el-table-column prop="date" label="审批状态" align="center"> </el-table-column>
          <el-table-column label="操作" align="center" >
            <template >
              <el-button
                size="mini"
                @click="handleEdit(scope.$index, scope.row)" class="greenColor"><span>编辑</span>
              </el-button>
              <el-button
                size="mini"
                type="danger"
                @click="handleDelete(scope.$index, scope.row)" class="redColor"><span>下架</span>
              </el-button>
              <el-button
                size="mini"
                type="danger"
               class="redColor"><span>详情</span>
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      searchData:'',
      ordinaryTable:[]
    }
  },
  methods: {
    goputaway(){
      this.$router.push({name:'productPutaway'})
    }
  }
}
</script>

<style lang="scss">
  .ordinaryProduct{
    width: 100%;
    .ordinary_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 13px;
      border-radius: 5px;
      div:nth-child(2){
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:8px 11px;
        font-size: 12px;
        cursor: pointer;
      }
    }
    .ordinary_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      // 输入框
      .search{
        display: flex;
        justify-content: space-between;
        .el-input-group{
          width:20%;
        }
        .el-input__inner{
          height: 27px;
          line-height: 27px;
          border: 1px solid #eee;
        }
        .el-input-group__append{
          background-color:#00a041;
          color:#fff;
          border:none;
          font-size: 13px;
          // border-bottom: 1px solid #fff;
        }
      }
      // 表格
      .ordinary_table{
        margin-top: 11px;
        padding-top: 14px;
        border-top: 1px solid #eee;
        .redColor{
          color:#ff0000
        }
        .greenColor{
          color:#00a041
        }
      }
    }
  }
</style>


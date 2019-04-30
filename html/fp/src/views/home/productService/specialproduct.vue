<template>
  <div class="specialproduct">
    <!-- 大标题 -->
    <div class="special_title">
      <div>特色服务产品</div>
      <div>新增特色产品</div>
    </div>
    <div class="special_main">
      <!-- input框 -->
      <div class="special_search">
        <input type="text" placeholder="搜公告" v-model="orgName">
        <i class="iconfont icon-sousuo" ></i>
      </div>
      <!-- tab栏表格 -->
      <div class="special_cont">
        <el-tabs v-model="status"  @tab-click="switchto">
          <el-tab-pane v-for="(statusitem,statusindex) in statusList" :key="statusindex">
            <span slot="label" :name="statusitem.id">{{statusitem.lable}}</span>
            <div class="special_table">
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
          </el-tab-pane>
        </el-tabs>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      orgName:'',
      statusList:[ { lable:'已发布', id:'1' }, { lable:'待审批', id:'0' }, { lable:'已下架', id:'-1' }, { lable:'审批不通过', id:'2' } ],
      status:''
    }
  },
  mounted () {
    
  },
  methods: {
    switchto(){

    }
  }
}
</script>

<style lang="scss">
  .specialproduct{
     width: 100%;
    //  大标题
    .special_title{
      background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 15px;
      border-radius: 5px;
      div:nth-child(2){
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:8px 11px;
        font-size: 14px;
        cursor: pointer;
        color:#00a041;
      }
    }
    // 主体
    .special_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      position: relative;
      .special_search {
        width: 170px;
        height: 26px;
        line-height: 26px;
        text-align: center;
        padding-right: 40px;
        border: 1px solid #eee;
        border-radius: 5px;
        position: absolute;
        z-index: 10;
        right: 17px;
        top: 17px;
        >input {
          border: 0;
          width: 80%;
        }
        input,
        textarea,
        select,
        button {
          text-rendering: auto;
          color: #333;
          letter-spacing: normal;
          word-spacing: normal;
          text-transform: none;
          text-indent: 0;
          text-shadow: none;
          display: inline-block;
          text-align: start;
          margin: 0em;
          font: 400 12px Arial;
        }
        >.icon-sousuo {
          position: absolute;
          top: -1px;
          right: 0;
          cursor: pointer;
          font-size: 20px;
          display: inline-block;
          background-color: #00a041;
          color: #fff;
          // width: 36px;
          line-height: 27px;
          text-align: center;
          border-left: 1px solid #eee;
          border-radius: 0px 5px 5px 0px;
        }
      }
      .special_cont{
        .el-tabs__header{
          margin: 0;
          .el-tabs__active-bar{
            background-color: #00a041;
          }
          .el-tabs__item.is-active{
            color: #00a041;
          }
          .el-tabs__item:hover{
            color:#00a041;
          }
        }
        .special_table{
          margin-top: 35px;
        }
      }
    }
  }
</style>

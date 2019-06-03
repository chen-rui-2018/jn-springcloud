<template>
  <div class="specialproduct">
    <!-- 大标题 -->
    <div class="special_title">
      <div >特色服务产品</div>
      <div @click="addscience">新增特色产品</div>
    </div>
    <div class="special_main">
      <!-- input框 -->
      <div class="special_search">
        <input type="text" placeholder="请输入服务产品名称" v-model="sendData.keyWords">
        <i class="iconfont icon-sousuo" @click="handleSearch"></i>
      </div>
      <!-- tab栏表格 -->
      <div class="special_cont">
        <el-tabs>
          <el-tab-pane v-for="(statusitem,statusindex) in statusList" :key="statusindex">
            <div slot="label" @click="switchto(statusitem.id)" class="1">{{statusitem.lable}}</div>
            <div class="special_table">
              <el-table :data="specialList" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
                <el-table-column prop="productName" label="产品名称" align="center" width="140"> </el-table-column>
                <el-table-column prop="orgName" label="服务机构" align="center"> </el-table-column>
                <el-table-column prop="signoryName" label="业务领域" align="center"> </el-table-column>
                <el-table-column prop="advisorName" label="服务顾问" align="center"> </el-table-column>
                <el-table-column prop="releaseTime" label="发布日期" align="center" width="180"> </el-table-column>
                <el-table-column label="发布状态" align="center"> 
                  <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.status|publishstatus }}</span>
                  </template>
                </el-table-column>
                <el-table-column prop="status" label="审批状态" align="center">
                  <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.status|approvestatus }}</span>
                  </template>  
                </el-table-column>
                <el-table-column label="操作" align="center" width="140" >
                  <template slot-scope="scope">
                    <div class="specialbth" >
                      <span  @click="gospecialdetail(scope.row)">详情</span>
                      <span v-show="scope.row.status!='1'&&scope.row.status!='0'&&scope.row.status!='2'" @click="gospecialedit(scope.row.productId)">编辑</span>
                      <span v-show="scope.row.status!='2'&&scope.row.status!='0'&&scope.row.status!='1'" @click="gospecialshelf('1',scope.row.productId)">上架</span>
                      <span v-show="scope.row.status!='2'&&scope.row.status!='0'&&scope.row.status==='1'" @click="gospecialshelf('-1',scope.row.productId)">下架</span>
                      <span v-show="scope.row.status==='2'" @click="applyagain(scope.row.productId)">重新申请</span>
                    </div>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-tab-pane>
        </el-tabs>
      </div>
      <!-- 分页 -->
      <div class="special_paging">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="[8, 16, 24, 32]"
          :page-size="100"
          layout="total,prev, pager, next,sizes"
          :total="total">
        </el-pagination>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      orgName:'',
      total:0,
      statusList:[ 
        { lable:'已发布', id:'1' }, 
        { lable:'待审批', id:'0' }, 
        { lable:'已下架', id:'-1' }, 
        { lable:'审批不通过', id:'2' } ],
      status:'',
      sendData:{
        keyWords:'',
        orgId:'',//285bfb89580a422ea927200f5d7accc4,cbe0d8ba94844a3a8f7b44822cfc7382 非
        page:1,
        productStatus:'1',
        productType:1,
        rows:8
      },
      specialList:[]
    }
  },
  filters: {
    publishstatus(status){
      if(status==='1'){
        return '已发布'
      }else{
        return '未发布'
      }
    },
     approvestatus(status){
      if(status==='0'){
        return "待审批"
      }else if(status==='2'){
        return "审批不通过"
      }else{
        return "审批通过"
      }
    },
  },
  mounted () {
    // this.getspecialList()
    this. getOrgId()
  },
  methods: {
    // 获取当前登录id
    getOrgId(){
      let _this = this;
      this.api.get({
      url: "getUserExtension",
      data: { },
      callback: function(res) {
        if (res.code == "0000") {
          _this.sendData.orgId= res.data.affiliateCode
          _this.$nextTick(()=>{
            _this.getspecialList()
            })
          }
        }
      })
    },
    // 获取列表
    getspecialList(){
      let _this = this;
      this.api.get({
      url: "getOrgProductList",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          // _this.loading=false
          _this.specialList= res.data.rows
          _this.total=res.data.total
          }
        }
      })
    },
    //详情
    gospecialdetail(row){
      this.$router.push({path:'/servicemarket/product/productService/ordinaryproductDetail',query:{orgid:this.sendData.orgId,productId:row.productId,signoryName:row.signoryName}})
    },
    //新增
    addscience(){
      this.$router.push({path:'/servicemarket/product/productService/addScience',query:{orgid:this.sendData.orgId}})
    },
    //编辑
    gospecialedit(productId){
      this.$router.push({path:'/servicemarket/product/productService/specialEdit',query:{orgid:this.sendData.orgId,productId:productId}})
    },
    //重新
    applyagain(productId){
      let _this = this;
      this.api.post({
      url: "productShelf",
      data: {
        status:'1',
        productId:productId
        },
      callback: function(res) {
        if (res.code == "0000") {
           _this.$message.success("成功")
           _this.getspecialList()
            // console.log(res)
          }
        }
      })
    },
    //上下架
    gospecialshelf(status,productId){
      let _this = this;
      this.api.post({
      url: "productShelf",
      data: {
        status:status,
        productId:productId
        },
      callback: function(res) {
        if (res.code == "0000") {
           _this.$message.success("成功")
           _this.getspecialList()
          }
        }
      })
    },
    switchto(status){
      this.sendData.productStatus=status
      this.getspecialList()
    },
    handleSearch(){
      this.getspecialList()
    },
    handleSizeChange(val) {
      this.sendData.rows=val
      this.getOrgProductList()
    },
    //翻页
    handleCurrentChange(val) {
      this.sendData.page=val
      this.getOrgProductList()
    },
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
      font-size: 16px;
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
      border-radius: 5px;
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
        .specialbth{
          display:flex;
          span{
            display:block;
            width:33%;
            
            &:nth-child(1){
              color:#00a041;
            }
            &:nth-child(2){
              color:#ff0000;
            }
            cursor:pointer;
          }
        }
        }
      }
       //分页
      .special_paging{
        text-align: center;
        margin: 51px 0 76px 0;
        .el-pagination.is-background .btn-prev,.el-pagination.is-background .btn-next{
          border: 1px solid #eee;
          background-color: #fff;
        }
        .el-pagination.is-background .el-pager li{
          background-color: #fff;
          border: 1px solid #eee;
        }
        .el-pagination.is-background .el-pager li:not(.disabled):hover{
          color:#fff;
        }
        .el-pagination.is-background .el-pager li:not(.disabled).active{
          background-color: #00a041;
          color: #fff;
        }
        .el-pagination__sizes .el-input .el-input__inner:hover{
          border-color: #00a041;
        }
        .el-select .el-input__inner:focus{
          border-color:#00a041;
        }
        
      }
    }
  }
</style>

<template>
  <div class="ordinaryProduct"  v-loading="loading">
    <div class="ordinary_title">
      <div>常规服务产品</div>
      <div @click="goputaway()" v-show="isAdd">常规产品上架</div>
    </div>
    <div class="ordinary_main">
      <div class="search">
        <div></div>
        <!-- <el-input placeholder="服务产品名称" v-model="sendData.keyWords">
          <el-button slot="append" icon="el-icon-search" @click="handlesearch"></el-button>
        </el-input> -->
        <div class="special_search">
          <input type="text" placeholder="请输入服务产品名称" v-model="sendData.keyWords">
          <i class="iconfont icon-sousuo" @click="handlesearch"></i>
        </div>
      </div>
      <div class="ordinary_table">
        <el-table :data="orgProductList" stripe border :header-cell-style="{background:'#f8f8f8',color:'#666666'}" style="width: 100%">
          <el-table-column prop="productName" label="产品名称" align="center" width="120"> </el-table-column>
          <el-table-column prop="orgName" label="服务机构" align="center"> </el-table-column>
          <el-table-column prop="signoryName" label="业务领域" align="center"> </el-table-column>
          <el-table-column prop="advisorName" label="服务专员" align="center"> </el-table-column>
          <el-table-column prop="releaseTime" label="发布日期" align="center" width="180"> </el-table-column>
          <el-table-column label="发布状态" align="center"> 
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.status|publishstatus }}</span>
            </template>
          </el-table-column>
          <el-table-column label="审批状态" align="center"> 
            <template slot-scope="scope">
              <span style="margin-left: 10px">{{ scope.row.status|approvestatus }}</span>
            </template>
          </el-table-column>
          <el-table-column label="操作" align="center" width="140">
            <template slot-scope="scope">
              <div class="ordinarybth" >
                <!-- <span v-if="scope.row.status!='1'&&scope.row.status!='0'&&scope.row.status!='2'&&businessType!='technology_finance'" @click="goEdit(scope.row.productId)">编辑</span> -->
                <span @click="goDetail(scope.row)">详情</span>
                <span v-if="scope.row.status!='2'&&scope.row.status!='0'&&scope.row.status==='1'"  @click="handleshelf('-1',scope.row.productId)">下架</span>
                <span v-if="scope.row.status!='2'&&scope.row.status!='0'&&scope.row.status!='1'" @click="handleshelf('1',scope.row.productId)">上架</span>
              </div>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <!-- 分页 -->
      <div class="ordinary_paging">
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
      loading:false,
      total:0,
      sendData:{
        keyWords:'',
        orgId:'',//285bfb89580a422ea927200f5d7accc4,cbe0d8ba94844a3a8f7b44822cfc7382 非
        page:1,
        productStatus:'',
        productType:0,
        rows:8
      },
      orgProductList:[],
      businessType:"",
        isAdd:false
    }
  },
  filters: {
    publishstatus(status){
      if(status==='-1'){
        return '无效'
      }else if(status==='0'){
        return '待审核'
      }else if(status==='1'){
        return '有效'
      }else if(status==='2'){
        return '审核不通过'
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
    this.getOrgId()
    // this.getOrgProductList()
    let menu=JSON.parse(sessionStorage.menuItems)
    let _this=this
    menu.forEach(v=>{
      if(v.label==='产品管理'){
        v.children[0].resourcesList.forEach(i=>{
          if(i.resourcesName==="产品上架下架操作"){
            _this.isAdd=true
          }
        })
      }
    })
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
            _this.getOrgProductList()
            // _this.getType()
            })
          }
        }
      })
    },
    getType(){
      let _this = this;
      this.api.get({
      url: "getActivityDetailsFm",
      data: {orgId:this.sendData.orgId},
      callback: function(res) {
        if (res.code == "0000") {
            // console.log(res)
          _this.businessType= res.data.businessType
          }
        }
      })
    },
    // 获取列表
    getOrgProductList(){
      let _this = this;
      this.api.get({
      url: "getOrgProductList",
      data: this.sendData,
      callback: function(res) {
        if (res.code == "0000") {
          // console.log(res)
          _this.loading=false
          _this.orgProductList= res.data.rows
          _this.total=res.data.total
          }
        }
      })
    },
    //去新增
    goputaway(){
      //territory为0是科技金融，为1是非科技金融
        this.$router.push({path:'/servicemarket/product/productService/productPutaway',query:{orgid:this.sendData.orgId}})
    },
    // 去编辑
    goEdit(productId){
        this.$router.push({path:'/servicemarket/product/productService/ordinaryproductEdit',query:{orgid:this.sendData.orgId,productId:productId}})
    },
    //去详情
    goDetail(row){
      this.$router.push({path:'/servicemarket/product/productService/ordinaryproductDetail',query:{orgid:this.sendData.orgId,productId:row.productId,signoryName:row.signoryName}})
    },
    // 下架
    handleshelf(status,productId){
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
           _this.getOrgProductList()
            // console.log(res)
          }
        }
      })
    },
    //翻页
    handleSizeChange(val) {
      this.sendData.rows=val
      this.getOrgProductList()
    },
    //翻页
    handleCurrentChange(val) {
      this.sendData.page=val
      this.getOrgProductList()
    },
    //搜索
    handlesearch(){
      this.getOrgProductList()
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
      font-size: 16px;
      border-radius: 5px;
      div:nth-child(2){
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:8px 11px;
        font-size: 14px;
        color:#00a041;
        cursor: pointer;
      }
    }
    .ordinary_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      border-radius: 5px;
      position: relative;
      // 输入框
      .search{
        display: flex;
        justify-content: space-between;
        // .el-input-group{
        //   width:20%;
        // }
        // .el-input__inner{
        //   height: 27px;
        //   line-height: 27px;
        //   border: 1px solid #eee;
        //   font-size: 12px;
        // }
        // .el-input-group__append{
        //   background-color:#00a041;
        //   color:#fff;
        //   border:none;
        //   font-size: 13px;
        //   border-bottom: 1px solid #fff;
        //   i{
        //     font-size: 17px;
        //   }
        // }
         .special_search {
        width: 170px;
        height: 26px;
        line-height: 26px;
        text-align: center;
        padding-right: 38px;
        border: 1px solid #eee;
        border-radius: 5px;
        // position: absolute;
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
          // top: 214px;
          // right: 56px;
          cursor: pointer;
          font-size: 20px;
          display: inline-block;
          background-color: #00a041;
          color: #fff;
          // width: 36px;
          line-height: 28px;
          text-align: center;
          border-left: 1px solid #eee;
          border-radius: 0px 4px 4px 0px;
          padding: 0 10px;
        }
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
        .ordinarybth{
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
      //分页
      .ordinary_paging{
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
          color:#000;
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


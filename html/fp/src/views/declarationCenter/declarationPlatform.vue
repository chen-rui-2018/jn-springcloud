<template>
  <div class="declarationPlatform">
    <div class="declarationPlatform_content"><!-- 版心 -->
    <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/declarationCenter">申报中心</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">申报平台</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p><span class="iconfont icon-deng"></span>汇集常用申报平台，便于企业快速查阅和进入。包含了各类科技项目、企业资质、产品认定、人才计划申报、资金兑现、技术合同登记等业务申报系统。</p>
      </div>
      <!-- 平台列表 -->
      <div class="platform_list">
        <div class="platform_recommend">
          <el-tabs v-model="id" @tab-click="switchtype">
            <el-tab-pane v-for="(typeitem,typeindex) in platformType" :key="typeindex">
              <span slot="label" :name="typeitem.id">{{typeitem.name}}</span>
              <div class="platform_titile"><span></span>平台介绍</div>
              <!-- 表格 -->
              <div class="platform_table">
                <div>
                  <el-form v-for="(item,index) in pladformList" :key="index">
                    <div class="full_line" >
                      <el-form-item label="平台名称">
                        <div class="table_item_cont"><span>{{item.platformTitle}}</span> <span class="el-icon-d-arrow-right"></span></div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="平台功能">
                        <div class="table_item_cont">{{item.remark}}</div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="业务咨询">
                        <div class="table_item_cont" v-html="item.businessConsult"></div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="系统支持">
                        <div class="table_item_cont system_support" v-html="item.systemSupport">
                          <!-- <div>邮箱：xxxx@sipac.gov.cn</div>
                          <div>电话：<span>13866666666</span></div> -->
                        </div>
                      </el-form-item>
                    </div>
                  </el-form>
                </div>
              </div>
            </el-tab-pane>
          </el-tabs>
        </div>
      </div>
      <!-- 分页 -->
      <div class="declarationplatform_paging">
        <el-pagination
          background
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :page-sizes="[6, 12, 18, 24]"
          :page-size="100"
          layout="total,prev, pager, next,sizes"
          :total="total">
        </el-pagination>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      id:1,
      platformType:[],
      pladformList:[],
      page:1,
      rows:3,
      total:0
    }
  },
  filters: {
    
  },
  created () {
    this.getPlatformType()//平台类型
    this.getPlatformList()//列表数据
     },
  methods: {
    getPlatformList(){
      let _this = this;
      this.api.get({
        url: "getplatform",
        data: {
          subordinatePlatformName :this.id,
          page:this.page,
          rows:this.rows,
         },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.pladformList = res.data.rows;
            _this.total=res.data.total
          }
        }
      });
    },
    getPlatformType(){
      let _this = this;
      this.api.get({
        url: "getplatformtype",
        data: { },
        callback: function(res) {
          // console.log(res);
          if (res.code == "0000") {
            _this.platformType = res.data;
          }
        }
      });
    },
    //切换平台
    switchtype(id){
      this.getPlatformList()
    },
    handleSizeChange(val) {
      this.rows=val
      this.getPlatformList()
    },
    handleCurrentChange(val) {
      this.page=val
      this.getPlatformList()
    }
  }
}
</script>
<style lang="scss">
  .declarationPlatform{
    margin-top: 230px;
    .declarationPlatform_content{
      width: 1190px;
      margin: 0 auto;
      .approve_breadcrumb{
        padding: 15px 0;
        font-size: 12px;
        .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
          color:#00a041;  
        }
      }
      // 大标题
      .right_headline{
        border: solid 1px #eeeeee;
        p{
          font-size: 13px;
          margin: 21px 17px;
          color:#797979;
          span{
            color:#00a041;
            margin-right: 8px;
            font-size: 16px;
          }
        }
      }
      // 业务列表
      .platform_list{
        margin-top: 30px;
        .platform_recommend{
          margin-top: 17px;
          margin-bottom: 61px;
          .el-tabs__header{
            margin: 0 0 24px;
            .el-tabs__active-bar{
              background-color: #00a041;
            }
            .el-tabs__item.is-active{
              color: #00a041;
            }
            .el-tabs__item:hover{
              color: #00a041;
            }
          }
          .platform_titile{
            font-size: 13px;
            color:#333333;
            display: flex;
            align-items: center;
            span{
              display: inline-block;
              width: 5px;
              height: 5px;
              border-radius: 50%;
              background-color:#00a041;
              margin-right: 8px;
            }
          }
          // 表格
          .platform_table{
            margin-top: 15px;
            margin-bottom: 32px;
            .el-form{
              .full_line{
                width: 100%;
                // background-color: #f8f8f8;
                    /* background-color: #f8f8f8; */
                border-bottom: 1px solid #eeeeee;
              }
              display: flex;
              flex-wrap: wrap;
              border: 1px solid #eeeeee;
              margin-bottom: 32px;
              .el-form-item{
                margin-bottom:0;
                // border-bottom: 1px solid #eeeeee;
                display: flex;
                height: 100%;
                background-color: #f8f8f8;
                .el-form-item__content{
                  line-height: 25px;
                  background: #fff;
                  flex: 1;
                  padding: 10px 0 10px 10px;
                  display: flex;
                  align-items: center;
                  .table_item_cont{
                    padding: 0px 12px;
                    div{
                      line-height: 1;
                      padding: 6px 0;
                    }
                    span{
                        color:#00a041
                      }
                  }
                  .system_support{
                    padding:7px 0 7px 12px;
                  }
                }
                .el-form-item__label{
                  // background-color: #f8f8f8;
                  width: 14%;
                  text-align: left;
                  padding-left: 12px;
                  line-height: 1;
                  margin: auto;
                }
              }
              
            }
          }
        }
      }
      //分页
      .declarationplatform_paging{
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
        .el-pagination.is-background .el-pager li:not(.disabled):hover{
          color:#00a041
        }
      }
    }
  }
</style>


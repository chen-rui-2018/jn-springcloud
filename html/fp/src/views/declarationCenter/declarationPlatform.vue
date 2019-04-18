<template>
  <div class="declarationPlatform">
    <div class="declarationPlatform_content"><!-- 版心 -->
    <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">企业服务</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/compassView">申报中心</a>
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
          <el-tabs v-model="activeName" @tab-click="handleClick">
            <el-tab-pane label="园区本级平台" name="first">
              <div class="platform_titile"><span></span>平台介绍</div>
              <!-- 表格 -->
              <div class="platform_table">
                <div>
                  <el-form>
                    <div class="full_line">
                      <el-form-item label="平台名称">
                        <div class="table_item_cont"><span></span> <span class="el-icon-d-arrow-right"></span></div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="平台功能">
                        <div class="table_item_cont"></div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="业务咨询">
                        <div class="table_item_cont"></div>
                      </el-form-item>
                    </div>
                    <div class="full_line">
                      <el-form-item label="系统支持">
                        <div class="table_item_cont system_support">
                          <div>邮箱：xxxx@sipac.gov.cn</div>
                          <div>电话：<span>13866666666</span></div>
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
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      activeName: 'first',
      id:1,
      pladformList:[]
    }
  },
  filters: {
    
  },
  created () {
   this.getPlatformList()
  },
  methods: {
    getPlatformList(){
      let _this = this;
      this.api.get({
        url: "getplatform",
        data: {
          subordinatePlatformName :'园区本级平台'
         },
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.pladformList = res.data;
          }
        }
      });
    },
    handleClick(tab, event) {
      console.log(tab, event);
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
                background-color: #f8f8f8;
              }
              display: flex;
              flex-wrap: wrap;
              border: 1px solid #eeeeee;
              .el-form-item{
                margin-bottom:0;
                border-bottom: 1px solid #eeeeee;
                display: flex;
                height: 98%;
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
    }
  }
</style>


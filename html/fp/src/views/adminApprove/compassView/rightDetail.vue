<template>
  <div class="rightDetail" v-loading="loading">
    <div class="right_content"><!-- 版心 -->
    <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/compassView">行政审批</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">权利详情</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p>{{powerDetail.name}}</p>
      </div>
      <!-- 业务列表 -->
      <div class="business_list">
        <div class="busness_title">业务列表</div>
        <div class="busness_content">
          <el-collapse @change="handleChange" v-model="activeName">
             <el-collapse-item name="1">
              <template slot="title">
                <div class="content_title">
                  <span>基本信息</span>
                  <span>{{isUnfold}}</span>
                </div>
              </template>
              <div class="baseIfor_table">
                <el-form>
                  <div class="baseIfor_table_item">
                    <el-form-item label="类别：">
                      <div class="table_item_cont">
                        <span>{{powerDetail.type|type}} </span>
                      </div>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="权力基本编码：">
                      <span class="table_item_cont">{{powerDetail.code===null?'暂无':powerDetail.code}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="实施主体：">
                      <span class="table_item_cont">{{powerDetail.departName===null?'暂无':powerDetail.departName}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="行驶层级：">
                      <span class="table_item_cont">{{powerDetail.level===null?'暂无':powerDetail.level}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_gist">
                    <el-form-item label="实施依据：">
                      <div class="table_item_cont">
                        <!-- <span v-if="isWord&&word&&word.length>135" class="66">{{word|word}} </span> -->
                        <span v-if="powerDetail.settingBasis===null">暂无</span>
                        <span v-html="powerDetail.settingBasis" v-else></span>
                        <!-- <span @click="isWord=!isWord" v-show="isWord&&word&&word.length>135" class="pack_up">[点击展开]</span>
                        <span @click="isWord=!isWord" v-show="isWord===false&&word&&word.length>135" class="pack_up">[点击收起]</span> -->
                      </div> 
                    </el-form-item>
                  </div>
                  <!-- <div class="baseIfor_table_item full_line">
                    <el-form-item label="权力来源：">
                      <span class="table_item_cont">{{powerDetail.comeFrom===null?'暂无':powerDetail.level}}</span>
                    </el-form-item>
                  </div> -->
                  <div class="baseIfor_table_item full_line">
                    <el-form-item label="备注：">
                      <span class="table_item_cont">{{ powerDetail.notes===null?'暂无':powerDetail.notes}}</span>
                    </el-form-item>
                  </div>
                </el-form>
              </div>
            </el-collapse-item>
          </el-collapse>
          <div class="busness_approve">
            <div class="approve_title"><span>审批服务业务</span></div>
            <div class="approve_table">
              <el-table
                :data="approveTableList"
                border
                style="width: 100%">
                <el-table-column
                  label="业务序号"
                  width="180"
                   type="index"
                  align="center"
                  >
                 <!--  <template slot-scope="scope">
                    <span @click="goservedetail(scope.row.id)">{{scope.row.id}} </span>
                  </template> -->
                </el-table-column>
                <el-table-column
                  label="业务名称"
                  align="center"
                  >
                  <template slot-scope="scope">
                    <span @click="goservedetail(scope.row.id)">{{scope.row.name}} </span>
                  </template>
                </el-table-column>
                <el-table-column
                  label="办理机构"
                  align="center"
                  width="157">
                  <template>
                    <span @click="goservedetail(scope.row.id)">{{ powerDetail.departName}}</span>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </div>
        </div>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  data () {
    return {
      isUnfold:'收起',
      activeName:'1',
      word:"",
      isWord:true,
      clickUnfold:'点击展开',
      approveTableList:[],
      id:'',
      powerDetail:{},
      loading:true
    }
  },
  filters: {
    word(word){
      if (word.length > 135) {
          return word.substring(0, 135) + "...";
        }
    },
    type(type){
      if(type==='1'){
        return '行政许可'
      }
    }
  },
  mounted () {
    sessionStorage.setItem("url","rightDetail")
    sessionStorage.setItem("name",this.$route.query.name)
    this.id=this.$route.query.id
    this.getPowerDetailList()
  },
  methods: {
    //展开收起
    handleChange(val) {
      if(val){
        if(val.length!=0){
          // console.log(val);
          this.isUnfold='收起'
        }else{
          this.isUnfold='展开'
        }
      }
    },
    getPowerDetailList(){
      let _this = this;
      this.api.get({
        url: "getpowerDetail",
        data: {
          id:this.id
         },
        callback: function(res) {
          if (res.code == "0000") {
            _this.loading=false
            _this.powerDetail=res.data[0];
            _this.approveTableList=_this.powerDetail.busiModelList
            _this.word=_this.powerDetail.settingBasis
            if(_this.word===null){
              _this.word='暂无'
            }
          }else{
            _this.$message.error(res.result)
          }
        }
      });
    },
    goservedetail(id){
      this.$router.push({path:'/serviceDetail',query:{id:id}})
    }
  }
}
</script>
<style lang="scss">
  .rightDetail{
    padding-top: 67px;
    .right_content{
      width: 1190px;
      margin: 0 auto;
    }
    // 加载动画
    .el-loading-mask{
      .el-loading-spinner .path{
        stroke:#00a041;
      }
      .el-loading-spinner{
        top:30%;
      }
    }
    .approve_breadcrumb{
      padding: 15px 0;
      font-size: 12px;
      .el-breadcrumb__item:last-child .el-breadcrumb__inner a{
        color:#00a041;  
      }
    }
    // 大标题
    .right_headline{
      box-shadow: 0px 1px 15px 0px 
        rgba(4, 0, 0, 0.05);
      border-radius: 8px;
      border: solid 1px #eeeeee;
      p{
        font-size: 21px;
        margin:31px 31px 18px 31px;
        border-bottom: 1px solid #eeeeee;
        padding-bottom: 19px;
      }
    }
    // 业务列表
    .business_list{
      margin-top: 30px;
      .busness_title{
        font-size: 17px;
      }
      .busness_content{
        margin-top: 17px;
        box-shadow: 0px 1px 15px 0px 
        rgba(4, 0, 0, 0.05);
        border-radius: 8px;
        border: solid 1px #eeeeee;
        padding:23px 29px 93px 29px;
        margin-bottom: 125px;
        .el-collapse{
          border-top: none;
          .el-collapse-item__header{
            height: 31px;
            line-height: 30px;
            border-bottom: 1px solid #eeeeee;
          }
          .el-collapse-item__content{
            border: 1px solid #eeeeee;
            margin-top: 19px;
            border-bottom: none;
          }
          .el-collapse-item__content{
            padding-bottom:0px;
          }
          .content_title{
            display: flex;
            justify-content: space-between;
            width: 100%;
            color: #00a041;
            span:nth-child(1){
              padding:0 8px;
              border-bottom: 3px solid #00a041;
              font-size: 14px;
            }
          }
          .el-collapse-item__wrap{
            border-bottom: none;
          }
          .baseIfor_table{
            height: 100%;
            .baseIfor_table_item{
              width: 50%;
              background-color: #f8f8f8;
            } 
            .el-form{
              .full_line{
                width:100%;
                background-color: #f8f8f8;  
                .el-form-item{
                  .el-form-item__label{
                    width:14.5%;
                  }
                }
              }
            }
            .el-form{
              display: flex;
              flex-wrap: wrap;
              .el-form-item{
                margin-bottom:0;
                border-bottom: 1px solid #eeeeee;
                display: flex;
                .el-form-item__content{
                  // line-height: 44px;
                  background: #fff;
                  flex: 1;
                  .table_item_cont{
                    padding: 0px 12px;
                  }
                }
                .el-form-item__label{
                  // background-color: #f8f8f8;  
                  width: 29%;
                  text-align: left;
                  padding-left: 12px;
                  line-height: 44px;
                }
              }
              .baseIfor_table_gist{
                background-color: #f8f8f8;
                width: 100%;
                .el-form-item{
                  align-items: center;
                  display: flex;
                }
                .el-form-item__label{
                  width: 14.5%;
                  // line-height: 1;
                  // background-color: #f8f8f8;
                }
                .el-form-item__content{
                  line-height: 1;
                  background-color: #fff;
                  padding: 12px 0;
                }
                .table_item_cont{
                  
                  span:nth-child(1){
                   line-height: 20px;
                  }
                  .pack_up{
                   float: right;
                   color:#00a041;
                    line-height: 20px;
                  }
                }
              }
            }
          }
        }
        .busness_approve{
          margin-top: 39px;
          .approve_title{
            border-bottom: 1px solid #eee;
            padding-bottom: 10px;
            span{
              font-size: 14px;
              border-bottom: 3px solid #00a041;
              color:#00a041;
              padding: 7px 8px;
            }
          }
          .approve_table{
            margin-top: 22px;
            .el-table{
              th{
                background:#f8f8f8
              }
            }
            .el-table__row:hover{
              cursor:pointer;
            }
          }
          
        }
      }
    }
  }
</style>

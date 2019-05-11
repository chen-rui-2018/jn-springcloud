<template>
  <div class="serviceDetail"  v-loading="loading">
    <div class="right_content"><!-- 版心 -->
    <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="#/compassView">行政审批</a>
          </el-breadcrumb-item>
          <el-breadcrumb-item>
            <a href="javascript:;">审批指南详情 </a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p>{{seviceDetail.name}}
          <span @click="messageVisible = true">我要留言</span>
          <span>在线咨询</span>
        </p>
      </div>
      <!-- 我要留言弹窗 -->
      <div class="message">
        <el-dialog title="我要留言" :visible.sync="messageVisible" width="616px" >
          <el-form :model="messageform" label-position="left" label-width="100px" :rules="rules" >
            <el-form-item label="企业名称：" prop="firmName" > 
              <el-input v-model="messageform.firmName" placeholder="请输入内容   默认填入当前企业名称"></el-input>
            </el-form-item>
            <el-form-item label="联系人：" prop="linkman">
              <el-input v-model="messageform.linkman" placeholder="请输入内容   默认填入企业联系人姓名"></el-input>
            </el-form-item>
            <el-form-item label="联系电话：" prop="linkPhone">
              <el-input v-model.number="messageform.linkPhone" placeholder="请输入内容   默认填入企业联系人电话"></el-input>
            </el-form-item>
            <el-form-item label="咨询内容："  prop="content">
              <div class="content_textarea">
                <textarea v-model="messageform.content" :placeholder="contentPlaceholder" maxlength="500" onchange="this.value=this.value.substring(0, 500)" onkeydown="this.value=this.value.substring(0, 500)" onkeyup="this.value=this.value.substring(0, 500)" 
                @input="counselnum">
                </textarea>
              <span>还可以输入<span>{{residuenum}}</span>字</span>
              </div>
            </el-form-item>
          </el-form>
          <div slot="footer" class="dialog-footer">
            <el-button @click="handlesubmit">提  交</el-button>
            <el-button type="primary" @click="messageVisible = false">取  消</el-button>
          </div>
        </el-dialog>
      </div>
      <!-- 业务列表 -->
      <div class="business_list">
        <div class="busness_title">服务详情</div>
        <div class="busness_content">
          <!-- 基本信息 -->
          <el-collapse  v-model="activeName">
             <el-collapse-item name="1">
              <template slot="title">
                <div class="content_title">
                  <span>基本信息</span>
                  <span @click="isUnfold1==='收起'?isUnfold1='展开':isUnfold1='收起'">{{isUnfold1}}</span>
                </div>
              </template>
              <div class="baseIfor_table">
                <el-form>
                  <div class="full_line">
                    <el-form-item label="服务名称：">
                      <div class="table_item_cont">
                        <span>{{seviceDetail.name}}</span>
                      </div>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="发布时间：">
                      <span class="table_item_cont">{{seviceDetail.time|time}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="受理时间：">
                      <span class="table_item_cont">{{seviceDetail.dealTime|time}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="受理地址：">
                      <span class="table_item_cont">{{seviceDetail.dealAddress}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="在线受理地址：">
                      <a :href="dealUrl" target="_blank">
                        <div class="onlineaddr" @click="handleview">点击查看</div>
                      </a>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="联系电话：">
                      <span class="table_item_cont">>{{seviceDetail.linkPhone}}</span>
                    </el-form-item>
                  </div>
                  <div class="baseIfor_table_item">
                    <el-form-item label="承诺办理时限方式：">
                      <span class="table_item_cont">{{seviceDetail.dealLimitDays}}个工作日</span>
                    </el-form-item>
                  </div>
                </el-form>
              </div>
            </el-collapse-item>
          </el-collapse>
          <!-- 办理材料 -->
          <el-collapse  v-model="activeName">
             <el-collapse-item name="2">
              <template slot="title">
                <div class="content_title">
                  <span>办理材料</span>
                  <span @click="isUnfold2==='收起'?isUnfold2='展开':isUnfold2='收起'">{{isUnfold2}}</span>
                </div>
              </template>
              <div class="baseIfor_table">
                 <el-table
                  :data="seviceDetail.materialsModelList"
                  border
                  
                  style="width: 100%">
                  <el-table-column
                    prop="name"
                    label="材料名称"
                    width="163.5"
                    align="center">
                  </el-table-column>
                  <el-table-column
                    prop="name"
                    align="center"
                    label="材料样本"
                    >
                    <template slot-scope="scope">
                      <a :href="'http://112.94.22.222:2381/ibps'+scope.row.sample">{{scope.row.sampleName}}</a>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="纸质材料（份）"
                    width="163.5"
                    align="center"
                    >
                    <template slot-scope="scope">
                      <span>{{scope.row.paperQuantity}}(份) </span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="是否需要电子材料"
                    align="center"
                    width="163.5">
                    <template slot-scope="scope">
                      <span>{{scope.row.isNeedElectronic|idNeed}}</span>
                    </template>
                  </el-table-column>
                  <el-table-column
                    label="材料必要性"
                    align="center"
                    width="163.5">
                    <template slot-scope="scope">
                      <span>{{scope.row.isRequired|isRequired}}</span>
                    </template>
                  </el-table-column>
                </el-table>
              </div>
            </el-collapse-item>
          </el-collapse>
          <!-- 办理指引 -->
          <el-collapse v-model="activeName" class="guide">
             <el-collapse-item name="3">
              <template slot="title">
                <div class="content_title">
                  <span>办理指引</span>
                  <span @click="isUnfold3==='收起'?isUnfold3='展开':isUnfold3='收起'">{{isUnfold3}}</span>
                </div>
              </template>
              <div>
                  <div class="guide_base"><span></span><span>依据</span></div>
                  <div class="table_item_cont">
                    <span v-if="isWord&&word.length>135" class="66">{{word|word}} </span>
                    <span v-else class="55">{{word}}</span>
                    <span @click="isWord=!isWord" v-show="isWord&&word.length>135" class="pack_up">[点击展开]</span>
                    <span @click="isWord=!isWord" v-show="isWord===false&&word.length>135" class="pack_up">[点击收起]</span>
                  </div>
                  <div class="guide_base"><span></span><span>办理流程</span></div>
                  <div v-html="seviceDetail.flowPic" class="flowPic"></div>
              </div>
            </el-collapse-item>
          </el-collapse>
          <!-- 办理条件 -->
          <el-collapse  v-model="activeName" class="condition">
             <el-collapse-item name="4">
              <template slot="title">
                <div class="content_title">
                  <span>办理条件</span>
                  <span @click="isUnfold4==='收起'?isUnfold4='展开':isUnfold4='收起'">{{isUnfold4}}</span>
                </div>
              </template>
              <div class="baseIfor_table">
                <span>{{seviceDetail.dealConditions}} </span>
              </div>
            </el-collapse-item>
          </el-collapse>
          <div class="busness_approve">
            <div class="approve_title"><span>收费标准</span></div>
            <div class="fee">{{seviceDetail.feeStandard}}</div>
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
      loading:true,
      isUnfold1:'收起',
      isUnfold2:'收起',
      isUnfold3:'收起',
      isUnfold4:'收起',
      activeName:['1','2','3','4'],
      word:"",
      isWord:true,
      clickUnfold:'点击展开',
      seviceTableList:[],
      seviceDetail:{},
      messageVisible:false,
      messageform:{
        firmName:"",
        linkman:'',
        linkPhone:'',
        content:'',
        id:''
      },
      contentPlaceholder:`1、问题描述\n2、诉求目的`,
      residuenum:500,
      dealUrl:'',
      rules:{
        firmName:[
          { required: true, message: '企业名称不能为空'}
        ],
        linkman:[
          { required: true, message: '联系人不能为空'}
        ],
        linkPhone:[
          { required: true, message: '联系电话不能为空'},
          { type: 'number', message: '年龄必须为数字值'}
        ],
        content:[
          { required: true, message: '内容不能为空'}
        ],
       
      }
    }
  },
  filters: {
    word(word){
      if (word.length > 250) {
          return word.substring(0, 250) + "...";
        }
    },
    idNeed(val){
      if(val===1){
        return '需要'
      }else if(val===0){
        return '不需要'
      }
    },
    isRequired(val){
      if(val===1){
        return '必要'
      }else if(val===0){
        return '不必要'
      }
    },
    time(time){
        if(time){
          let dateee = new Date(time).toJSON();
          return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '') 
          // return time.split("T")[0]
        }
      }
  },
  created () {
    this.messageform.id=this.$route.query.id
    this.getSeviceDetailList()
  },
  methods: {
    getSeviceDetailList(){
      let _this = this;
      this.api.get({
        url: "getseviceDetail",
        data: {
          id:this.messageform.id
         },
        callback: function(res) {
          console.log(res);
          if (res.code == "0000") {
            _this.loading=false
            _this.seviceDetail = res.data;
            _this.word=_this.seviceDetail.dealConditions
          }
        }
      });
    },
    // 获取在线办理地址
    handleview(){
      this.dealUrl=`http://192.168.10.31:1101/springcloud-park/guest/portal/sp/power/getDealUrl?id=${this.messageform.id}`
    },
    counselnum(){
      this.residuenum=500-this.messageform.content.length
    },
    handlesubmit(){
      let _this = this;
      this.api.post({
        url: "message",
        data: {
          companyName:this.messageform.firmName,
          concatName:this.messageform.linkman,
          concatPhone:this.messageform.linkPhone,
          fromBusiId:this.messageform.id,
          message:this.messageform.content
         },
        callback: function(res) {
          if (res.code == "0000") {
            _this.messageVisible = false
            _this.$message.success("留言成功")
          }
        }
      });

    }
  }
}
</script>
<style lang="scss">
  .serviceDetail{
    // 我要留言弹窗
    .message{
      .el-dialog__body{
        padding: 26px 79px 12px 79px;
        border-bottom: 1px solid #ccc;
        .el-form-item__content{
          line-height: 1;
        }
      }
      input:focus{
        border-color:#00a041; 
      }
      .content_textarea{
            // border: 1px solid #DCDFE6;
            // border-radius: 5px;
        textarea{
          padding: 8px 15px;
          resize: none;
          width: 91%;
          height: 96px;
          border: 1px solid #DCDFE6;
          border-radius: 5px;
          color:#606266;
          margin-bottom: 5px;
        }
        textarea::-webkit-input-placeholder{
          font-size: 14px;
          color:#c0c4cc;
          // padding-left: 8px;
          // padding-top: 8px;
            line-height: 20px
          }    /* 使用webkit内核的浏览器 */
          textarea:-moz-placeholder{
            line-height: 20px;
            padding-left: 8px;
            color:black;
            font-size: 14px;
            padding-top: 8px;
          }                  /* Firefox版本4-18 */
          textarea::-moz-placeholder{
            line-height: 20px;
            padding-left: 8px;
            color:black;
            font-size: 14px;
            padding-top: 8px;
          }                  /* Firefox版本19+ */
        textarea:-ms-input-placeholder{
          line-height: 20px;
          padding-left: 8px;
          color:black;
          font-size: 14px;
          padding-top: 8px;
        }
        span{
          color:#999999;
          span{
            color:#ff0000;
          }
        }
      }
      .el-dialog__footer{
        text-align: center;
        .el-button{
          padding: 7px 20px;
          border-radius: 5px;
         
        }
        button:nth-child(1){
          border: solid 1px #41d787;
          background-color: #ecfcf2;
          &:hover{
            color:#41d787;
          }
        }
        button:nth-child(2){
          background-color: #00a041;
          border:1px solid #00a041;
        }
      }
    }
    .right_content{
      width: 1190px;
      margin: 0 auto;
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
        span{
          float:right;
          font-size: 12px;
          padding:3px 5px;
          border-radius: 5px;
          &:hover{
            cursor:pointer;
          }
        }
        span:nth-child(2){
          background-color: #ecfcf2;
          border-radius: 5px;
          border: solid 1px #41d787;
          color:#00a041;
          border-radius: 5px;
          margin-right: 12px;
        }
        span:nth-child(1){
          background-color: #00a041;
          color:#FFF;
          border: solid 1px #00a041;
        }
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
              margin-bottom: 15px;
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
            span:nth-child(2){
              padding-left: 91%;
              flex: 1;
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
              //在线地址
              .onlineaddr{
                color:#00a041;
                cursor: pointer;
              }
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
                height: 98%;
                .el-form-item__content{
                  line-height: 25px;
                  background: #fff;
                  flex: 1;
                  padding: 10px 0 10px 10px;
                  display: flex;
                  align-items: center;
                  // .table_item_cont{
                  //   padding: 0px 12px;
                  // }
                }
                .el-form-item__label{
                  // background-color: #f8f8f8;  
                  width: 29%;
                  text-align: left;
                  padding-left: 12px;
                  line-height: 1;
                  margin: auto;
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
          }
          
        }
      }
    }
    //name3
    .guide{
      .el-collapse-item .el-collapse-item__wrap .el-collapse-item__content  {
        border:none;
        margin-top:10px;
      }
      .guide_base{
        display: flex;
        align-items: center;
        margin-top: 10px;
        span{
          font-size: 15px;
          &:first-child{
            display: inline-block;
            width: 6px;
            height: 6px;
            border-radius: 50%;
            background-color:#00a041;
            margin-right: 12px;
          }
        }
        
      }
      .table_item_cont{
        margin-top: 8px;
        span:nth-child(1){
          line-height: 20px;
          padding-left: 21px;
        }
        .pack_up{
          float: right;
          color:#00a041;
          line-height: 20px;
        }
      }
    }
    // name 条件
    .condition{
      .el-collapse-item .el-collapse-item__wrap .el-collapse-item__content  {
        border:none;
        // margin-top:10px;
      }
      .baseIfor_table{
        span{
          padding-left: 21px;
        }
      }
    }
    //收费标准
    .fee{
      font-size: 14px;
      margin-top: 15px;
      padding-left: 10px;
    }
    // 办理流程
    .flowPic{}
  }
</style>



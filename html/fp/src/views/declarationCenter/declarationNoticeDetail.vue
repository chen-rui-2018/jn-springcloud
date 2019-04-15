<template>
  <div class="declarationNoticeDetail">
    <div class="declarationNoticeDetail_content"><!-- 版心 -->
      <!-- 面包屑 -->
      <div class="approve_breadcrumb">
        <el-breadcrumb separator="/">
          <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
          <el-breadcrumb-item :to="{path: '/compassView'}">
            <a href="javascript:;">行政审批</a>
          </el-breadcrumb-item>
        </el-breadcrumb>
      </div>
      <!-- 大标题 -->
      <div class="right_headline">
        <p class="detail_maintitle">【白下高新区】关于2019年企业发展沙龙活动征集的通知
          <span>预约申报</span>
          <span>联系电话</span>
        </p>
        <!-- 附件下载 -->
        <div class="accessory_dowload">
          <div class="accessory">
            <span>附件下载:</span>
            <div class="accessory_right">
              <a href="javascript:;">附件一  企业发展沙龙活动承办须知.docx</a>
              <a href="javascript:;">附件一  企业发展沙龙活动承办须知.docx</a>
              <p>
                <span>反馈表递交截止日期2019-01-21</span>
                <span>阅读量: 996次 <span>发布时间: 2018-08-03  09:58</span></span>
                
              </p>
            </div>
          </div>
        </div>
      </div>
      <!-- 公告详情 -->
      <div class="notice_content">
        <div class="notice_title">公告详情</div>
        <div class="notice_detail">
          56238562
        </div>
      </div>
    </div><!-- 版心 -->
  </div>
</template>
<script>
export default {
  
}
</script>
<style lang="scss">
  .declarationNoticeDetail{
    .declarationNoticeDetail_content{
      width: 1190px;
      margin: 0 auto;
      // 面包屑
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
        padding:30px 31px 18px 31px;
        .detail_maintitle{
          font-size: 21px;
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
        .accessory_dowload{
          margin-top: 24px;
          font-size: 13px;
          .accessory{
            display: flex;
            .accessory_right{
              margin-left: 7px;
              flex:1;
              a{
                display: block;
                color:#00a041;
                padding-bottom: 10px;
              }
              p{
                display: flex;
                justify-content: space-between;
                span{
                  font-size: 12px;
                  color:#666666;
                  &:nth-child(2){
                    float: right;
                    span{
                      padding-left: 20px;
                    }
                  }
                }
              }
            }

          }
        }
      }
      // 公告详情
      .notice_content{
        margin-top: 30px;
        .notice_title{
          font-size: 17px;
        }
        .notice_detail{
          margin-top: 17px;
          box-shadow: 0px 1px 15px 0px rgba(4, 0, 0, 0.05);
          border-radius: 8px;
          border: solid 1px #eeeeee;
          padding:46px 41px 62px 41px;
        }
      }
    }
  }
</style>


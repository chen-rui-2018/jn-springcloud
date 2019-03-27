<template>
  <div class="footer">
    <div class="container">
      <div class="footer1 clearfix">
        <div class="footLeft">
          <div class="help">
            <h5>门户</h5>
            <div class="line"></div>
            <ul>
              <li>
                <a href="javascript:viod(0)">首页</a>
              </li>
              <li>
                <a href="javascript:viod(0)">招商引资</a>
              </li>
              <li>
                <a href="javascript:viod(0)">智慧党建</a>
              </li>
              <li>
                <a href="javascript:viod(0)">企业服务</a>
              </li>
            </ul>
          </div>
          <div class="help">
            <h5>帮助</h5>
            <div class="line"></div>
            <ul>
              <li>
                <a href="javascript:viod(0)">联系我们</a>
              </li>
              <li>
                <a href="javascript:viod(0)">关于我们</a>
              </li>
              <li>
                <a href="javascript:viod(0)">申请企业账户</a>
              </li>
              <li>
                <a href="javascript:viod(0)">申请顾问</a>
              </li>
            </ul>
          </div>
          <div class="attention">
            <h5>关注我们</h5>
            <div class="line"></div>
            <div class="attentionIcon">
              <i class="iconfont icon-12sina"></i>
              <i class="iconfont icon-weixin"></i>
            </div>
          </div>
          <div class="erweima clearfix">
            <img src="@/../static/img/weixin.png" alt="" class="fl">
             <!-- <i class="iconfont icon-qr-code"></i> -->
            <div class="aboutUs fr">
              <i class="iconfont icon-weixin1"></i>
              <p>扫描二维码</p>
              <p>关注我们</p>
            </div>
          </div>
        </div>
        <div class="footRight">
          <div class="right1 arialn">HOTLINE</div>
          <div class="phone impact">400-800-9888</div>
          <div class="problem">您有任何问题，都可以联系我们</div>
          <div class="book">
            <a>立即订阅，获得75折优惠</a>
            <i class="iconfont icon-toright"></i>
          </div>
        </div>
      </div>
      <div class="footer2">
        京ICP备09046754&copy;版权所有
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  }
};
</script>

<style lang="scss" scoped>
.icon-weixin{
  font-size: 18px;
}
.icon-weixin1{
  font-size: 20px;
}
.footer {
  border-top:1px solid #ccc;
  .container {
    .footer1 {
      height: 240px;
      width: 1190px;
      margin: 0 auto;
      .footLeft {
        margin-top: 50px;
        float: left;
        .help {
          margin-right: 30px;
          display: inline-block;
          h5 {
            font-size: 14px;
          }
          ul {
            li {
              margin-bottom: 5px;
              a {
                font-size: 12px;
                color: rgba(112, 112, 112, 0.5);
              }
            }
          }
        }
        .attention {
          display: inline-block;
          vertical-align: top;
          >.attentionIcon{
            margin-top:8px;
            color: #999;
          }
        }
        .erweima {
          padding:5px;
          display: inline-block;
          vertical-align: top;
          border: 1px solid #eee;
          height: 100px;
          width: 200px;
          margin-left: 30px;
          text-align: center;
          >img{
            width: 100px;
            height: 100px;
          }
          >.aboutUs{
            margin-top:20px;
            margin-right:10px;
            float:right;
            line-height: 20px;
            color: #999;
            >p{
              font-size: 12px;
            }
          }
        }
        .line {
            height: 1px;
            width: 12px;
            background: #000;
            font-weight: bold;
            margin: 10px 0 15px 0;
          }
      }
      .footRight {
        float: right;
        text-align: right;
        .right1 {
          color: #707070;
          font-size: 14px;
          margin-top: 40px;
        }
        .phone {
          color: #00a041;
          font-size: 47px;
        }
        .problem {
          font-size: 12px;
          color: #9e9e9e;
        }
        .book {
          height: 38px;
          line-height: 38px;
          padding: 0 10px;
          width: 243px;
          color: rgba(112, 112, 112, 0.5);
          font-size: 12px;
          border: 1px solid rgba(112, 112, 112, 0.5);
          margin-top: 20px;
          margin-left: 70px;
          a {
            float: left;
          }
        }
      }
    }
    .footer2 {
      color: #fff;
      height: 48px;
      line-height: 48px;
      background-color: #000;
      text-align: left;
      padding-left: 150px;
    }
  }
}
</style>

<template>
  <div class="footer">
    <div class="container">
      <div class="footer1 clearfix">
        <div class="footLeft clearfix">
          <h5>友情链接</h5>
          <div class="line"></div>
          <div class="help">
            <h5>国家</h5>
            <!-- <div class="line"></div> -->
            <ul>
              <li>
                <a href="http://www.miit.gov.cn/n11293472/index.html" target="_blank">中华人民共和国工业和信息化部</a>
              </li>
              <li>
                <a href="http://www.most.gov.cn/" target="_blank">中华人民共和国科学技术部</a>
              </li>
              <li>
                <a href="http://www.chinatorch.gov.cn/kjb/index.shtml" target="_blank">科技技术部火炬高新技术产业开发中心</a>
              </li>
              <li>
                <a href="http://www.mofcom.gov.cn/" target="_blank">中华人民共和国商务部</a>
              </li>
              <li>
                <a href="http://www.smecn.org.cn/" target="_blank">国家中小企业公共服务示范平台</a>
              </li>
            </ul>
          </div>
          <div class="help">
            <h5>江苏省</h5>
            <!-- <div class="line"></div> -->
            <ul>
              <li>
                <a href="http://www.jszwfw.gov.cn/" target="_blank">江苏政务服务网</a>
              </li>
              <li>
                <a href="http://www.jiangsudoc.gov.cn/" target="_blank">江苏省商务厅</a>
              </li>
              <li>
                <a href="http://www.smejs.cn/" target="_blank">江苏省中小企业公共服务平台</a>
              </li>
              <li>
                <a href="http://www.jsbi.cn/" target="_blank">江苏省高新技术创业服务中心</a>
              </li>
              <li>
                <a href="http://www.jseic.gov.cn/" target="_blank">江苏省经济和信息化委员会</a>
              </li>
              <li>
                <a href="http://www.jstd.gov.cn/" target="_blank">江苏省科技技术厅</a>
              </li>
            </ul>
          </div>
          <div class="help help2">
            <!-- <h5></h5> -->
            <ul>
              <!-- <li>
                <a href="http://www.jstd.gov.cn/" target="_blank">江苏省科技技术厅</a>
              </li> -->
              <li>
                <a href="http://www.js-sme.org.cn/" target="_blank">江苏省中小企业发展中心</a>
              </li>
              <li>
                <a href="http://www.jsjmrhw.org/" target="_blank">江苏省军民融合公共服务平台</a>
              </li>
              <li>
                <a href="http://www.jsdpc.gov.cn/" target="_blank">江苏省发展和改革委员会</a>
              </li>
              <li>
                <a href="https://etax.jiangsu.chinatax.gov.cn/sso/login" target="_blank">国家税务总局江苏省电子税务局</a>
              </li>
              <li>
                <a href="http://218.94.38.242:10001/onlineRegNew-web/userManage/net_user_login.jsp" target="_blank">江苏工商网上登记系统</a>
              </li>
            </ul>
          </div>
          <div class="help">
            <h5>南京市</h5>
            <ul>
              <li>
                <a href="http://www.njkj.gov.cn/" target="_blank">南京市科学技术委员会</a>
              </li>
              <li>
                <a href="http://www.njdpc.gov.cn/" target="_blank">南京市发展和改革委员会</a>
              </li>
              <li>
                <a href="http://www.njsmj.gov.cn/" target="_blank">南京商务信息网</a>
              </li>
              <li>
                <a href="http://www.njec.gov.cn/" target="_blank">南京市经济和信息化委员会</a>
              </li>
              <li>
                <a href="http://www.njsme.org.cn/index.html" target="_blank">南京市中小企业公共服务平台</a>
              </li>
            </ul>
          </div>
          <!-- <div class="attention">
            <h5>关注我们</h5>
            <div class="line"></div>
            <div class="attentionIcon">
              <i class="iconfont icon-12sina"></i>
              <i class="iconfont icon-weixin"></i>
            </div>
          </div> -->
          <!-- <div class="erweima clearfix">
            <img src="@/../static/img/weixin.png" alt="" class="fl">
            <div class="aboutUs fr">
              <i class="iconfont icon-weixin1"></i>
              <p>扫描二维码</p>
              <p>关注我们</p>
            </div>
          </div> -->
        </div>
        <!-- <div class="footRight">
          <div class="right1 arialn">HOTLINE</div>
          <div class="phone impact">400-800-9888</div>
          <div class="problem">您有任何问题，都可以联系我们</div>
          <div class="book">
            <a>立即订阅，获得75折优惠</a>
            <i class="iconfont icon-toright"></i>
          </div>
        </div> -->
        <div class="footRight">
          <div class="erweima1">
            <div><img src="@/../static/img/apple.png" alt=""></div>
            <p>ios</p>
          </div>
          <div class="erweima2">
            <div><img src="@/../static/img/andriod.png" alt=""></div>
            <p>android</p>
          </div>
          <div class="erweima2">
            <div><img src="@/../static/img/xiaocehngxu.png" alt=""></div>
            <p>小程序</p>
          </div>
        </div>
      </div>
      <div class="footer2">
        <div class="w">苏ICP备xxxxxx号&nbsp;&nbsp;&copy;版权所有&nbsp;&nbsp;南京白下高新技术产业园区投资发展有限责任公司</div>
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
.icon-weixin {
  font-size: 18px;
}
.icon-weixin1 {
  font-size: 20px;
}
.footer {
  border-top: 1px solid #ccc;
  .container {
    .footer1 {
      height: 260px;
      width: 1190px;
      margin: 0 auto;
      .footLeft {
        margin-top: 30px;
        float: left;
        h5 {
          font-size: 14px;
        }
        .line {
          height: 1px;
          width: 12px;
          background: #000;
          font-weight: bold;
          margin: 10px 0 15px 0;
        }
        .help {
          margin-right: 20px;
          // display: inline-block;
          float: left;
          h5 {
            font-size: 14px;
          }
          ul {
            li {
              width: 180px;
              margin-bottom: 5px;
              overflow: hidden;
              text-overflow: ellipsis;
              white-space: nowrap;
              a {
                font-size: 12px;
                color: #666;
              }
              a:hover {
                text-decoration: underline;
              }
            }
          }
        }
        .help2{
          margin-top:20px;
        }
        .help1 {
          margin-top: 45px;
        }
        .attention {
          display: inline-block;
          vertical-align: top;
          > .attentionIcon {
            margin-top: 8px;
            color: #999;
          }
        }
        .erweima {
          padding: 5px;
          display: inline-block;
          vertical-align: top;
          border: 1px solid #eee;
          height: 100px;
          width: 200px;
          margin-left: 30px;
          text-align: center;
          > img {
            width: 100px;
            height: 100px;
          }
          > .aboutUs {
            margin-top: 20px;
            margin-right: 10px;
            float: right;
            line-height: 20px;
            color: #999;
            > p {
              font-size: 12px;
            }
          }
        }
        // .line {
        //   height: 1px;
        //   width: 12px;
        //   background: #000;
        //   font-weight: bold;
        //   margin: 10px 0 15px 0;
        // }
      }
      .footRight {
        float: right;
        text-align: center;
        margin-top: 70px;
        .erweima1,
        .erweima2 {
          display: inline-block;
          > div {
            width: 100px;
            height: 100px;
            border: 1px solid #eee;
            > img {
              width: 100%;
              height: 100%;
            }
          }
          > p {
            margin-top: 15px;
            font-size: 13px;
            color: #333;
            font-weight: bold;
          }
        }
        .erweima2 {
          margin-left: 20px;
        }
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
      font-size: 12px;
      background-color: #000;
      text-align: left;
      // padding-left: 160px;
    }
  }
}
</style>

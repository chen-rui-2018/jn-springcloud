<template>
    <div class="noticeList1">
        <div class="banner">
            <img src="@/../static/img/company3.png" alt="">
        </div>
        <div class="noticeCon w">
            <ul class="noticeUl">
                <li class="noticeLi pointer clearfix" v-for="(i,k) in noticeList" :key="k" @click="$router.push({path:'/announcementDetails',query:{noticeId:i.noticeId}})">
                    <div class="date fl" v-if="i.createdTime">
                        <div class="year">{{i.createdTime.slice(0,4)}}</div>
                        <div class="month color3">{{i.createdTime.slice(5,10)}}</div>
                    </div>
                    <div class="noticeCon fl">
                        <h5>{{i.noticeTitle}}</h5>
                        <p class="color3">{{i.noticeBiref}}</p>
                    </div>
                    <div class="buttonDetail fr mainBorder pointer">
                        了解详情
                    </div>
                </li>
            </ul>
        </div>
        <div class="pagination-container">
            <el-pagination background @size-change="handleSizeChange" @current-change="handleCurrentChange" :page-sizes="[10, 20, 30, 40]" :page-size="rows" layout="total,prev, pager, next,sizes" :total="total">
            </el-pagination>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      page: 1,
      rows: 10,
      total: 0,
      noticeList: []
    };
  },
  mounted() {
    this.showNoticeList();
  },
  methods: {
    handleSizeChange(val) {
      //改变每页显示多少条的回调函数
      this.rows = val;
      this.page = 1;
      this.showNoticeList();
    },
    handleCurrentChange(val) {
      //改变当前页码的回调函数
      this.page = val;
      this.showNoticeList();
    },
    showNoticeList() {
      let _this = this;
      this.api.get({
        url: "showNoticeList",
        data: {
          page: _this.page,
          rows: _this.rows
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.noticeList = res.data.rows;
            _this.total = res.data.total;
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.noticeList1 {
  .noticeCon {
    .noticeUl {
      margin: 50px auto;
    }
    .noticeLi {
      //   display: flex;
      //   justify-content: space-between;
      //   align-items: center;
      border-bottom: 1px solid #eee;
      //   border-top: 1px solid #eee;
      padding: 30px 0;
    }
    .noticeLi:hover {
      //   box-shadow: 0px 0px 5px 2px rgba(0, 0, 0, 0.06);
      .buttonDetail {
        background: rgba(0, 160, 65, 1);
        border-radius: 20px;
        color: #fff;
      }
    }
    .noticeLi:nth-child(1) {
      //   padding-top: 0;
      border-top: 1px solid #eee;
    }
    .date {
      width: 5%;
      border-right: 1px solid #eee;
      .year {
        font-size: 15px;
        color: #666;
      }
      .month {
        font-size: 13px;
      }
    }
    .noticeCon {
      width: 80%;
      margin-left: 20px;
      h5 {
        color: #333;
        font-size: 15px;
      }
      p {
        font-size: 13px;
        margin-top: 5px;
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        height: 17px;
        text-align: left !important;
      }
    }
    .buttonDetail {
      padding: 8px 20px;
      text-align: center;
      width: 55px;
    }
    font-size: 13px;
    color: #999;
  }
  .pagination-container {
    margin: 50px auto;
  }
}
</style>

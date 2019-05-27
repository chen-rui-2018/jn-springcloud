<template>
  <div class="workPlan">
    <div class="workPlan-header">
      <span>
        <router-link :to="{path:'addWorkPlan'}">添加任务</router-link>
      </span>
      <span @click="handleQueryCondition"><i class="iconfont icon-icon-"></i></span>
    </div>
    <div v-show="queryCondition">
      <div class="pd">任务状态</div>
      <div class="box">
        <checker v-model="listQuery.workPlanStatus" default-item-class="workPlanStatus-item" selected-item-class="workPlanStatus-item-selected"
          @on-change="init()">
          <checker-item value="0">未开始</checker-item>
          <checker-item value="1">进行中</checker-item>
          <checker-item value="2">已暂停</checker-item>
          <checker-item value="3">已完成</checker-item>
        </checker>
      </div>
      <group>
        <selector title="项目分类" :options="workNameList" placeholder="请选择项目名称" v-model="listQuery.itemId" @on-change="init()"></selector>
      </group>
      <div class="search">
        <input type="text" v-model="listQuery.workPlanName" :class="isActive==0?'input-fcous':''" @focus="setBorder"
          @blur="unsetBorder"><span @click="init()">搜索</span>
      </div>

    </div>
    <!-- <scroller lock-y scrollbar-x> -->
    <!-- <div class="box1"> -->
    <!-- <div class="box1-item" v-for="(i,index) in 7" :key="index"><span>{{' ' + i + ' '}}</span></div> -->
    <scroller lock-x @on-scroll-bottom="onScrollBottom" ref="scrollerBottom" style="height:auto">
      <div class="box2 mg-v-20 workTable">
        <!-- <p v-for="(i,index) in 20" :key="index">placeholder {{i}}</p> -->
        <x-table :cell-bordered="false" style="background-color:#fff;overflow:auto;" class="pd">
          <thead class="pd">
            <tr>
              <th class="">开始时间</th>
              <th>任务名称</th>
              <th>耗时</th>
              <th>状态</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(item,index) in workList" :key="index">
              <td >{{item.planStartTime}}</td>
              <td> <span style="color:rgb(51, 153, 255)" @click="toWorkPlanDetails(item)">{{item.workPlanName}}</span></td>
              <td> {{item.planTime}}</td>
              <td>
                <span v-if="item.workPlanStatusMessage==='未开始'">未开始</span>
                <span v-if="item.workPlanStatusMessage==='进行中'" style="color:red">进行中</span>
                <span v-if="item.workPlanStatusMessage==='已暂停'" style="color:rgb(248, 180, 102)">已暂停</span>
                <span v-if="item.workPlanStatusMessage==='已完成'" style="color:green">已完成</span>
              </td>
              <td>
                <popover placement="top">
                  <div slot="content" class="popover-demo-content">
                    <button :class="item.workPlanStatus!=='0'?'setOpacity':''" :disabled="item.workPlanStatus!=='0'"
                      @click="startWork(item)">开始</button>
                    <button :class="(item.workPlanStatus==='2'||item.workPlanStatus==='3')?'setOpacity':''" :disabled="item.workPlanStatus==='2'||item.workPlanStatus==='3'"
                      @click="pauseWork(item)">暂停</button>
                    <button :class="item.workPlanStatus==='3'?'setOpacity':''" :disabled="item.workPlanStatus==='3'" @click="toEditWorkPlan(item)">编辑</button>
                    <button :class="item.workPlanStatus==='3'?'setOpacity':''" :disabled="item.workPlanStatus==='3'" @click="completeWork(item)">完成</button>
                  </div>
                  <i class="iconfont">&#xe600;</i>
                </popover>
              </td>
            </tr>
          </tbody>
        </x-table>
        <load-more tip="loading" v-if="onFetching"></load-more>
      </div>
      <!-- <div class="mg-v-20 workTable">
      <x-table :cell-bordered="false" style="background-color:#fff;overflow:auto;" class="pd">
        <thead class="pd">
          <tr>
            <th class="">开始时间</th>
            <th>任务名称</th>
            <th>耗时</th>
            <th>状态</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(item,index) in workList" :key="index">
            <td>{{item.planStartTime}}</td>
            <td>{{item.workPlanName}}</td>
            <td> {{item.planTime}}</td>
            <td>
               <span v-if="item.workPlanStatusMessage==='未开始'" >未开始</span>
          <span v-if="item.workPlanStatusMessage==='进行中'" class="$color5" >进行中</span>
          <span v-if="item.workPlanStatusMessage==='已暂停'" style="color:rgb(248, 180, 102)" >已暂停</span>
          <span v-if="item.workPlanStatusMessage==='已完成'" class="$color4" >已完成</span>
            </td>
            <td>
            <popover placement="top">
              <div slot="content" class="popover-demo-content">
                <button :class="item.workPlanStatus!=='0'?'setOpacity':''" :disabled="item.workPlanStatus!=='0'" @click="startWork(item)">开始</button>
                <button :class="(item.workPlanStatus==='2'||item.workPlanStatus==='3')?'setOpacity':''" :disabled="item.workPlanStatus==='2'||item.workPlanStatus==='3'"  @click="abc()">暂停</button>
                <button :class="item.workPlanStatus==='3'?'setOpacity':''" :disabled="item.workPlanStatus==='3'">编辑</button>
                <button :class="item.workPlanStatus==='3'?'setOpacity':''" :disabled="item.workPlanStatus==='3'">完成</button>
              </div>
                <i class="iconfont">&#xe600;</i>
            </popover>
            </td>
          </tr>
        </tbody>
       <load-more tip="loading" v-if="onFetching"></load-more>
      </x-table>
    </div> -->
    </scroller>
    <!-- </div> -->
    <!-- </scroller> -->

  </div>
</template>

<script>
export default {
  data () {
    return {
      listQuery: {
        workPlanName: '',
        itemId: '',
        workPlanStatus: '',
        userAccount: '',
        page: 1,
        rows: 15
      },
      workList: [],
      queryCondition: false,
      isActive: undefined,
      onFetching: true,
      workNameList: [],
      total: 0
    }
  },
  mounted () {
    this.init()
    this.getItemAll()
  },
  methods: {
    toWorkPlanDetails (item) {
      this.$router.push({path: 'workPlanDetails', query: {id: item.id}})
    },
    startWork (item) {
      this.$router.push({path: 'editWorkStatus', query: {id: item.id, title: '开始'}})
    },
    pauseWork (item) {
      this.$router.push({path: 'editWorkStatus', query: {id: item.id, title: '暂停'}})
    },
    toEditWorkPlan (item) {
      console.log(item)
      this.$router.push({path: 'editWorkPlan', query: {id: item.id}})
    },
    completeWork (item) {
      this.$router.push({path: 'editWorkStatus', query: {id: item.id, title: '完成'}})
    },
    handleQueryCondition () {
      // this.$vux.toast.text('hello', 'top')
      this.queryCondition = !this.queryCondition
    },
    setBorder () {
      this.isActive = 0
    },
    unsetBorder () {
      this.isActive = undefined
    },
    // 获取所有项目
    getItemAll () {
      this.api.get({
        url: 'getItemAll',
        data: {},
        callback: res => {
          if (res.code === '0000') {
            res.data.forEach(val => {
              this.workNameList.push({ value: val.itemName, key: val.id })
            })
          } else {
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    },
    onScrollBottom () {
      if (this.onFetching === false) {
        if (this.listQuery.page < Math.ceil(this.total / this.listQuery.rows)) {
          this.onFetching = true
          setTimeout(() => {
            this.listQuery.page++
            this.api.get({
              url: 'getWorkList',
              data: this.listQuery,
              callback: res => {
                if (res.code === '0000') {
                  this.onFetching = false
                  this.workList.push(...res.data.rows)
                  // console.log(...res.data.rows)
                } else {
                  this.$vux.toast.text(res.result, 'top')
                }
              }
            })
          }, 1000)
        } else {
        }
      }
    },
    // 初始化页面
    init () {
      this.api.get({
        url: 'getWorkList',
        data: this.listQuery,
        callback: res => {
          if (res.code === '0000') {
            console.log(res)
            this.workList = res.data.rows
            this.total = res.data.total
            this.onFetching = false
            // this.poweList = res.data.rows
            // this.poweList.forEach(ele => {
            //   this.$set(ele, 'isfold', false)
            // })
            // this.isSlider = false
          } else {
            // this.$worning
            this.$vux.toast.text(res.result, 'top')
          }
        }
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.workPlan {
  padding: 30px;
  font-size: 32px;
  .pd {
    padding: 20px 0px;
  }
  .workPlan-header {
    display: flex;
    margin-top: 1.4rem;
    justify-content: space-between;
    > span:nth-child(1) {
      padding: 10px;
      background: rgb(51, 153, 255);
      font-size: 32px;
      > a {
        color: #fff;
      }
    }
    > span:nth-child(2) i {
      font-size: 50px;
      font-weight: 900;
    }
  }
  .workPlanStatus-item {
    border: 1px solid #ccc;
    padding: 15px 30px;
    //  color:#fff;
    //  background: rgb(117, 201, 251);
  }
  .workPlanStatus-item-selected {
    border: 1px solid rgb(51, 153, 255);
    background: rgb(51, 153, 255);
    color: #fff;
  }
  .search {
    display: flex;
    margin-top: 20px;
    input {
      flex: 1;
      line-height: 50px;
      border: 1px solid #ccc;
      padding: 10px 20px;
    }
    span {
      line-height: 50px;
      font-size: 28px;
      padding: 10px;
      background: rgba(0, 160, 65, 1);
      color: #fff;
      // border-radius:5px;
    }
    .input-fcous {
      border: 1px solid #00a041;
    }
  }
  .workTable {
    overflow: auto;
    .vux-table td,
    .vux-table th {
      padding: 10px;
      font-size: 26px;
    }
    .operationStyle {
      position: relative;
    }
    .operation {
      position: absolute;
      top: 0px;
      left: 0px;
    }
    .iconfont {
      font-size: 0.413333rem;
    }
  }
}
</style>
<style lang="scss">
// .workPlan{
.vux-popover {
  padding: 0.096667rem;
  left: 5.973333rem !important;
}
.vux-popover-arrow-down {
  left: 70% !important;
}
.popover-demo-content {
  button {
    background: unset;
    border: none;
    color: #fff;
  }
}
.setOpacity {
  opacity: 0.5;
}
// }
.workPlan {
  .vux-selector.weui-cell_select-after {
    padding: 10px;
    font-size: 28px;
  }
  .weui-cell_select-after .weui-select {
    padding-left: 0.3rem;
  }
  .weui-label {
    width: 2rem;
    margin-right: 1rem;
  }
  .weui-cell_select .weui-cell__bd:after {
    height: 0.2rem;
    width: 0.2rem;
    top: 42%;
    right: 0.4rem;
  }
}
</style>

<template>
    <div class="userInfo">
        <div class="headerRight fr">
            <router-link to="/messageCenter" class="search" v-if="isLogin">
              <i class="el-icon-bell" style="font-size:20px"></i>
            </router-link>
            <span v-if="isLogin" style="margin-right:10px">您好！{{accoutInfo}}</span>
            <div class="search pointer">
                <i class="el-icon-search" @click="show4=true" style="font-size:20px"></i>
            </div>
            <div class="navlogin">
                <router-link to="/messageCenter" class="" v-if="isLogin">
                    <i class="el-icon-bell" style="font-size:20px"></i>
                </router-link>
                <a @click="$router.push({path:'/login'})" v-else>登录</a>
                <span class="line">|</span>
                <a @click="$router.push({path:'/register'})">注册</a>
            </div>
        </div>
    </div>
</template>
<script>
export default {
  data() {
    return {
      isLogin: false,
      accoutInfo: ""
    };
  },
  mounted(){
      this.islogin()
  },
  methods:{
       islogin(){
        this.accoutInfo=sessionStorage.getItem('account')
        if(this.accoutInfo){
          this.isLogin=true
        }
      },
  }
};
</script>

<style lang="scss" scoped>
.userInfo {
  .headerRight {
    li:hover {
      background: none;
    }
    li:hover a {
      color: #00a041;
    }
  }
}
</style>

<template>
  <div class="park-profile">
    <img class="park-poster" :src="basicInfo.mainPicture" alt="">
    <div v-html="basicInfo.parkIntroduce"></div>
  </div>
</template>

<script>
export default {
  data () {
    return {
      basicInfo: {}
    }
  },
  mounted () {
    this.init()
  },
  methods: {
    init () {
      this.getBasic()
    },
    getBasic () {
      return new Promise((resolve, reject) => {
        this.api.get({
          url: 'getParkDetails',
          data: {
            id: this.$route.query.id
          },
          callback: (res) => {
            if (res.code === '0000') {
              this.basicInfo = res.data
              resolve()
            } else {
              reject(res)
            }
          }
        })
      })
    }
  }
}
</script>

<style lang="scss" scoped>
  @import '~@/assets/styles/common';
  .park-profile {
    padding: 30px;
    .park-profile-title {
      font-size: 30px;
      color: #333333;
      padding: 30px 0 20px;
    }
    .park-poster {
      width: 100%;
      display: block;
      vertical-align: middle;
      margin-bottom: 30px;
    }
  }
</style>

<template>
  <div class="park-profile">
    <div class="park-poster" :style="{backgroundImage: 'url(' + basicInfo.mainPicture + ')'}"></div>
    <div v-html="basicInfo.parkIntroduce"></div>
  </div>
</template>

<script>
export default {
  name: 'ParkProfile',
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
          url: 'basic',
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
      height: 300px;
      background-size: cover;
      background-repeat: no-repeat;
      border-radius: 10px;
      overflow: hidden;
      margin-bottom: 30px;
    }
  }
</style>

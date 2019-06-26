<template>
  <div ref="gantt"/>
</template>

<script>
import gantt from 'dhtmlx-gantt' // 引入模块
import 'dhtmlx-gantt/codebase/dhtmlxgantt.css'
import 'dhtmlx-gantt/codebase/locale/locale_cn'
export default {
  name: 'Gantt',
  props: {
    tasks: {
      type: Object,
      default() {
        return { data: [] }
      }
    }
  },
  // created: {
  //   // '$props.tasks': function() {
  //     // alert(gantt)
  //     // console.log(gantt)
  //     // if (gantt) {
  //       gantt.clearAll()
  //     // }
  //   // }
  // },
  mounted() {
    this.setGant()
    gantt.clearAll()
  },
  methods: {
    setGant() {
      const _this = this
      setTimeout(function() {
        _this.$nextTick(() => {
          gantt.init(_this.$refs.gantt)
          gantt.parse(_this.$props.tasks)
          gantt.config.readonly = true
        })
      }, 300)
      gantt.config.subscales = [
        {
          unit: 'year',
          step: 1,
          date: '%Y' + '年'
        }
      ]
    }
  }
}
</script>

<style>
</style>

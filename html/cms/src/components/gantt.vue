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
        return { data: [], links: [] }
      }
    }
  },

  mounted() {
    gantt.config.subscales = [
      {
        unit: 'year',
        step: 1,
        date: '%Y'
      }
    ]
    this.$nextTick(() => {
      gantt.init(this.$refs.gantt)
      gantt.parse(this.$props.tasks)
      gantt.config.readonly = true
      // gantt.init('gantt_here')
    })
  }
}
</script>

<style>
</style>

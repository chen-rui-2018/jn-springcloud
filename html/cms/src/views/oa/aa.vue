<template>
  <div class="center meetingApplication">
    <div class="topUpday">
      <div style="border-top: 1px solid #ccc;">
        <span>工单编号</span>
        <span>123456789</span>
      </div>
      <div style="border-top: 1px solid #ccc;">
        <span>工单名称</span>
        <span style="border-right: 1px solid #ccc;">工单名称工单名称</span>
      </div>
      <div>
        <span>姓名</span>
        <span>张三</span>
      </div>
      <div>
        <span>部门</span>
        <span style="border-right: 1px solid #ccc;">招商部</span>
      </div>
      <div>
        <span>会议室</span>
        <span>
          <el-input v-model="input1" placeholder="请输入内容"/>
        </span>
      </div>
      <div>
        <span>会议主题</span>
        <span style="border-right: 1px solid #ccc;">
          <el-input v-model="input2" placeholder="请输入内容"/>
        </span>
      </div>
      <div>
        <span>参与人员</span>
        <span>
          <el-input v-model="input3" placeholder="请输入内容"/>
        </span>
      </div>
      <div>
        <span>会议时间</span>
        <span style="border-right: 1px solid #ccc;">
          <el-date-picker
            v-model="value4"
            type="datetimerange"
            range-separator="至"
            start-placeholder="开始日期"
            end-placeholder="结束日期"/>
        </span>
      </div>
    </div>
    <div/>
    <div class="flexTop">
      <span>
        会议内容
      </span>
      <span>
        <quill-editor
          ref="myTextEditor"
          v-model="content"
          :options="editorOption"
          style="height:240px;"/>
      </span>
    </div>
    <div class="flexTop">
      <span>
        审批进度
      </span>
      <span>
        <el-steps :active="active" finish-status="success">
          <el-step title="步骤 1"/>
          <el-step title="步骤 2"/>
          <el-step title="步骤 3"/>
        </el-steps>
      </span>
    </div>
    <div class="flexTop">
      <span>
        审批状态
      </span>
      <span>
        <el-radio v-model="radio" label="1">通过</el-radio>
        <el-radio v-model="radio" label="2">不通过</el-radio>
      </span>
    </div>
    <div class="flexTop">
      <span>
        审批意见
      </span>
      <span>
        <el-input
          :autosize="{ minRows: 2, maxRows: 4}"
          v-model="textarea3"
          type="textarea"
          placeholder="请输入内容"
          style="min-height:200px;"/>
      </span>
    </div>
    <div class="primaryList">
      <el-button class="primary" type="primary" @click="Get()">提交</el-button>
      <el-button class="primary" type="primary">取消</el-button>
    </div>
  </div>
</template>

<script>
const toolbarOptions = [ // 富文本编辑器参数
  ['bold', 'italic', 'underline', 'strike'], // 加粗
  ['blockquote', 'code-block'],
  [{ list: 'ordered' }, { list: 'bullet' }],
  [{ script: 'sub' }, { script: 'super' }], // superscript/subscript
  [{ indent: '-1' }, { indent: '+1' }], // outdent/indent
  [{ size: ['small', false, 'large', 'huge'] }], // custom dropdown
  [{ header: [1, 2, 3, 4, 5, 6, false] }],
  [{ color: [] }, { background: [] }], // dropdown with defaults from theme
  [{ align: [] }],
  ['image']
]
// import { quillEditor } from 'vue-quill-editor'
import 'quill/dist/quill.core.css'
import 'quill/dist/quill.snow.css'
import 'quill/dist/quill.bubble.css'
export default {
  data() {
    return {
      input1: '',
      input2: '',
      input3: '',
      content: '',
      active: 0,
      radio: '1',
      value4: [new Date(2000, 10, 10, 10, 10), new Date(2000, 10, 11, 10, 10)],
      textarea3: '',
      editorOption: { // 设置富文本编辑器
        placeholder: '',
        theme: 'snow', // or 'bubble'
        modules: {
          toolbar: {
            container: toolbarOptions // 工具栏
          }
        }
      }
    }
  },
  methods: {
    Get() { // 这个是点击事件 你点击以后按照接口传参的格式传给后端就ok
    //   var that = this
    //   var data = {
    //     input1: that.input1, // 会议室输入的内容
    //     input2: that.input2, // 会议主题输入的内容
    //     input3: that.input3, // 参与人员输入的内容
    //     content: that.content, // 富文本编辑器的内容
    //     active: that.active, // 审批进度
    //     radio: that.radio, // 审批状态
    //     value4: that.value4, // 会议时间
    //     textarea3: that.textarea3 // 审批意见
    //   }
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.center{
  width: 100%;
  height: 100%;
}
.topUpday{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}
.topUpday div{
  flex-basis: 50%;
  display: flex;
}
.topUpday div span{
  width: 100px;
  padding: 20px 0;
  font-size: 13px;
  border-bottom: 1px solid #ccc;
  border-left: 1px solid #ccc;
}
.topUpday div span:nth-child(2){
  flex: 1;
  padding: 20px 20px 20px 20px;
}
.topUpday div span:nth-child(1){
  background: #f0f0f0;
  text-align: center;
   display: flex;
  justify-content:center;
  align-items:Center
}
.flexTop{
  border-bottom: 1px solid #ccc;
  border-left: 1px solid #ccc;
  border-right: 1px solid #ccc;
  display: flex;
}
.flexTop span:nth-child(1){
  background: #f0f0f0;
  text-align: center;
   display: flex;
  justify-content:center;
  align-items:Center;
  border-right: 1px solid #ccc;
}
.flexTop span:nth-child(2){
  flex: 1;
}
.flexTop span{
  width: 100px;
  font-size: 13px;
  padding:20px;
}
.primary{
  margin-top: 10px;
}
.primaryList{
  text-align: center;
}

</style>
<style lang="scss">
.meetingApplication{
.ql-container.ql-snow{
  height: 180px;
}
.el-textarea__inner{
  min-height: 180px !important;
}
}
</style>

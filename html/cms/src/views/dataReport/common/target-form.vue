<template>
  <div class="target-form">
    <div class="target-form-header">
      <el-input v-model="form.name" style="width: 120px;" placeholder="请输入内容"/>
      <div>
        <el-button v-if="form.editing" :disabled="form.editing">正在编辑中</el-button>
        <el-button v-else @click="editForm">编辑</el-button>
        <i class="el-icon-circle-plus green" @click="addFrom" />
        <i class="el-icon-circle-close red" @click="deleteFrom" />
      </div>
    </div>
    <div class="target-form-body">
      <el-tag
        v-for="(tag, index) in form.tags"
        :key="tag.id"
        :closable="true"
        class="target-tags"
        @close="handleClose(index)"
      >
        {{ tag.label }}
      </el-tag>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TargetForm',
  props: {
    form: {
      type: Object,
      default() {
        return {}
      }
    },
    index: {
      type: Number,
      required: true
    }
  },
  data() {
    return {
      originalData: Object.assign({}, this.form)
    }
  },
  methods: {
    addFrom() {
      this.$emit('addTargetFormData', this.originalData)
    },
    deleteFrom() {
      this.$emit('deleteTargetFormData', this.index)
    },
    editForm() {
      this.$emit('editTargetFormData', this.index)
    },
    handleClose(index) {
      this.$emit('tagClose', index)
    }
  }
}
</script>

<style lang="scss" scoped>
  @import "~@/styles/r-common";
  .target-form{
    $gray: #ebebeb;
    .target-form-header {
      padding: 10px;
      background-color: $gray;
      @include flex($h: space-between);
    }
    .green {
      color: limegreen;
      font-size: 18px;
      margin:0 10px;
    }
    .red {
      color: orangered;
      font-size: 18px;
    }
    .target-form-body {
      padding: 10px;
      border: 1px solid $gray;
      .target-tags {
        margin: 10px;
      }
    }
  }

</style>

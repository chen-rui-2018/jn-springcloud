<template>
    <div>
        <div @click="init">{{msg}}这个是组件的</div>
    </div>
</template>

<script>
import bus from '@/util/bus'
export default {
    props:['msg'],
    data(){
        return {

        }
    },
    methods:{
        init(){
            bus.$emit('ggg','这个是bus使用');
        }
    }
}
</script>

<style>

</style>

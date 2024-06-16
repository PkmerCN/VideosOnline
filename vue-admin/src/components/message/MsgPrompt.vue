<script setup lang="ts">
import { ref } from 'vue'
import generateId from '@/utils/ids'

const msgArr = ref<MessageI[]>([])
const visiable = ref(false)

function showMessage(content:string,msgType:MsgType = 'info') {
  const msg: MessageI = {id:generateId(),content,msgType}
  msgArr.value.push(msg)
  visiable.value = true

  setTimeout(() => {
    // visiable.value = false
    const index = msgArr.value.indexOf(msg)
    if(index !== -1){
      msgArr.value.splice(index,1)
    }
  },3000)
}

defineExpose({showMessage})
</script>

<template>
<div v-if="visiable">
  <div v-for="msg in msgArr" :key="msg.id" :class="['message',msg.msgType]">
    {{msg.content}}
  </div>
</div>
</template>

<style scoped lang="scss">
.message{
  font-size: 26px;
}

.info{
  color:sandybrown;
}
.success{
  color: green;
}
.error{
  color: red;
}
</style>
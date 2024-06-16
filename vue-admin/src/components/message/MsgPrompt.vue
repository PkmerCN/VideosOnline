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
  },300000)
}

defineExpose({showMessage})
</script>

<template>
<div v-if="visiable" class="message-container">
  <div v-for="msg in msgArr" :key="msg.id" :class="['message',msg.msgType]">
    {{msg.content}}
  </div>
</div>
</template>

<style scoped lang="scss">
.message-container{
  //border: 1px solid black;
  //width: 60%;
  position: fixed;
  z-index: 9999;
  left: 50%;
  top: 10px;
  transform: translateX(-50%);
  .message{
    margin-bottom: 10px;
    padding: 10px 20px;
    width: 300px;
    word-break: break-word;
    border-radius: 10px;
    font-size: 18px;
    background-color: white;
    box-shadow: 0 6px 16px 0 rgba(0, 0, 0, .08), 0 3px 6px -4px rgba(0, 0, 0, .12), 0 9px 28px 8px rgba(0, 0, 0, .05);
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
}

</style>
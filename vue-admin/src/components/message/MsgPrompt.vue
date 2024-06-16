<script setup lang="ts">
import { ref } from 'vue'

const messageType = ref<MsgType>('info')
const messageText = ref('')
const visiable = ref(false)

function showMessage(msg:string,msgType:MsgType = 'info') {
  messageText.value = msg
  messageType.value = msgType
  visiable.value = true

  setTimeout(() => {
    visiable.value = false
  },3000)
}

defineExpose({showMessage})
</script>

<template>
<div v-if="visiable" :class="['message', messageType]">
  {{messageText}}
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
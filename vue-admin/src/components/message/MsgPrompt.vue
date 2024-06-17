<script setup lang="ts">
import { ref } from 'vue'
import generateId from '@/utils/ids'
import InfoIcon from '@/components/icons/InfoIcon.vue'
import SuccessIcon from '@/components/icons/SuccessIcon.vue'
import ErrorIcon from '@/components/icons/ErrorIcon.vue'

const msgArr = ref<MessageI[]>([])
const visiable = ref(false)

function showMessage(content: string, msgType: MsgType = 'info') {
  if (msgArr.value.length >= 5) return

  const msg: MessageI = { id: generateId(), content, msgType }
  msgArr.value.push(msg)
  visiable.value = true

  setTimeout(() => {
    // visiable.value = false
    const index = msgArr.value.indexOf(msg)
    if (index !== -1) {
      msgArr.value.splice(index, 1)
    }
  }, 3000)
}

defineExpose({ showMessage })
</script>

<template>
  <div v-if="visiable" class="message-container">
    <div v-for="msg in msgArr" :key="msg.id" :class="['message', msg.msgType]">
      <InfoIcon v-if="'info' === msg.msgType" />
      <SuccessIcon v-if="'success' === msg.msgType" />
      <ErrorIcon v-if="'error' === msg.msgType" />
      <span class="text">{{ msg.content }}</span>
    </div>
  </div>
</template>

<style scoped lang="scss">
.message-container {
  //border: 1px solid black;
  //width: 60%;
  position: fixed;
  z-index: 9999;
  left: 50%;
  top: 10px;
  transform: translateX(-50%);
  .message {
    margin-bottom: 10px;
    padding: 10px 20px;
    width: 300px;
    border-radius: 20px;
    font-size: 18px;
    background-color: white;
    box-shadow:
      0 6px 16px 0 rgba(0, 0, 0, 0.08),
      0 3px 6px -4px rgba(0, 0, 0, 0.12),
      0 9px 28px 8px rgba(0, 0, 0, 0.05);

    display: flex;
    align-items: center;
    .text {
      font-size: 1rem;
      white-space: nowrap;
      overflow: hidden;
      text-overflow: ellipsis; /* 溢出部分显示省略号 */
      margin-left: 10px;
      vertical-align: middle;
      transform: translateY(-2px);
    }
  }

  .info {
    $info-color: sandybrown;
    color: $info-color;
    svg {
      fill: $info-color;
    }
  }
  .success {
    $success-color: green;
    color: $success-color;
    svg {
      fill: $success-color;
    }
  }
  .error {
    $error-color: red;
    color: $error-color;
    svg {
      fill: $error-color;
    }
  }
}
</style>

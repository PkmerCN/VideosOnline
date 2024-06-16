<template>
  <div>
    <button @click="Message.info('infoxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx')">展示info消息</button>
    <button @click="Message.error('error')">展示error消息</button>
    <button @click="Message.success('success')">展示success消息</button>
<!--    <LoginForm/>-->
  </div>
</template>

<script setup lang="ts">
import LoginForm from '@/pages/login'
import Message from '@/utils/message'

</script>

<style lang="scss" scoped>

</style>
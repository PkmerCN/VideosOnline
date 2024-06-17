<script setup lang="ts">
import bgVideo from '@/assets/videos/login.mp4'
import LoginAndSign from './components/LoginAndSign.vue'
</script>

<template>
  <div class="login-form__frame">
    <video autoplay loop muted preload="auto" class="bg-video">
      <source :src="bgVideo" type="video/mp4" />
    </video>
    <div class="login-form__container">
      <LoginAndSign />
    </div>
  </div>
</template>

<style scoped lang="scss">
.login-form__frame {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  position: relative;
  .bg-video {
    width: 100vw;
    height: 100vh;
    object-fit: cover;
  }

  .login-form__container {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  }
}
</style>

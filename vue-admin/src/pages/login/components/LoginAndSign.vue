<template>
  <div class="login-sign__container">
    <img :src="img1" :class="['img-left', { active: !active }]" />
    <img :src="img2" :class="['img-right', { active: active }]" />
    <div :class="['form-bg', { active: active }]"></div>
    <div :class="['form-left', { active: active }]">
      <h1 class="title">注册</h1>
      <form class="sign-up">
        <div class="input-group">
          <input type="text" placeholder="用户名" />
          <ProfileIcon class="icon" v-bind="iconSize"></ProfileIcon>
        </div>
        <div class="input-group">
          <input type="password" placeholder="密码" />
          <LockIcon class="icon" v-bind="iconSize"></LockIcon>
        </div>
        <div class="input-group">
          <input type="email" placeholder="邮箱" />
          <EmailIcon class="icon" v-bind="iconSize" />
        </div>
        <button class="form-btn">注册</button>
      </form>
      <a class="signin-link" @click="active = !active">登录</a>
    </div>
    <div :class="['form-right', { active: !active }]">
      <h1 class="title">登录</h1>
      <form class="sign-in">
        <div class="input-group">
          <input type="text" placeholder="用户名" v-model="loginFormData.email" />
          <ProfileIcon class="icon" v-bind="iconSize"></ProfileIcon>
        </div>
        <div class="input-group">
          <input type="password" placeholder="密码" v-model="loginFormData.password" />
          <LockIcon class="icon" v-bind="iconSize"></LockIcon>
        </div>
        <button :disabled="isLogining" class="form-btn" @click.prevent="submitLogin">登录</button>
      </form>
      <a class="signup-link" @click="active = !active">注册</a>
    </div>
  </div>
</template>

<script setup lang="ts">
import { reactive, ref } from 'vue'
import { useUserStore } from '@/store'
import { useRouter } from 'vue-router'
import useMsg from '@/composables/useMsg'
import { login } from '@/api/user'
import ProfileIcon from '@/components/icons/ProfileIcon.vue'
import EmailIcon from '@/components/icons/EmailIcon.vue'
import LockIcon from '@/components/icons/LockIcon.vue'
import img1 from '@/assets/imgs/img1.png'
import img2 from '@/assets/imgs/img2.png'

const router = useRouter()
const userStore = useUserStore()
const $msg = useMsg()
const loginFormData = reactive({
  email: '1193094618@qq.com',
  password: 'Root.123456'
})
const active = ref(false)
const isLogining = ref(false)
const iconSize = {
  width: 20,
  height: 20
}

async function submitLogin() {
  try {
    isLogining.value = true
    const response = await login(loginFormData.email, loginFormData.password)
    if (response.data && response.data.token) {
      $msg.success('登录成功')
      const { token } = response.data
      userStore.setToken(token)
      console.log(token)
      await router.push('/')
    }
  } finally {
    isLogining.value = false
  }
}
</script>

<style lang="scss" scoped src="./LoginAndSign.scss"></style>

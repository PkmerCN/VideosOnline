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
          <input type="text" placeholder="用户名" />
          <ProfileIcon class="icon" v-bind="iconSize"></ProfileIcon>
        </div>
        <div class="input-group">
          <input type="password" placeholder="密码" />
          <LockIcon class="icon" v-bind="iconSize"></LockIcon>
        </div>
        <button class="form-btn">登录</button>
      </form>
      <a class="signup-link" @click="active = !active">注册</a>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import ProfileIcon from '@/components/icons/ProfileIcon.vue'
import EmailIcon from '@/components/icons/EmailIcon.vue'
import LockIcon from '@/components/icons/LockIcon.vue'
import img1 from '@/assets/imgs/img1.png'
import img2 from '@/assets/imgs/img2.png'

const active = ref(false)
const iconSize = {
  width: 20,
  height: 20
}
</script>

<style lang="scss" scoped>
$main-color: rgb(7, 106, 80);
$shallow-color: rgb(55, 189, 153);
.login-sign__container {
  width: 100%;
  height: 100%;
  background-color: white;

  margin: 10px auto;
  width: 50rem;
  height: 30rem;
  border-radius: 1rem;
  box-shadow: 2px 6px 5px rgba(32, 61, 127, 0.3);
  display: flex;
  justify-content: space-between;
  position: relative;
  overflow: hidden;

  img {
    position: absolute;
    z-index: 100;
    width: 20rem;
    height: auto;

    &.img-left {
      top: 0rem;
      left: -1rem;
      opacity: 0;
      visibility: hidden;
      transition: all 0.5s;

      &.active {
        opacity: 1;
        top: 5rem;
        visibility: visible;
        transition: 0.5s 1s;
      }
    }

    &.img-right {
      top: 0rem;
      right: -1rem;
      opacity: 0;
      visibility: hidden;
      transition: all 0.5s;

      &.active {
        top: 5rem;
        opacity: 1;
        visibility: visible;
        transition: 0.5s 1s;
      }
    }
  }

  .form-bg {
    position: absolute;
    top: -50%;
    left: -50%;

    width: 100%;
    height: 100%;
    border-radius: 5rem;
    transform-origin: right bottom;
    transform: rotateZ(-45deg);
    background-color: $main-color;
    transition: all 1.5s ease-in-out;

    &.active {
      transform: rotateZ(135deg);
    }
  }

  .form-left {
    opacity: 0;
    transition: all 0.5s;

    &.active {
      opacity: 1;
      transition: all 0.5s 1s;
    }
  }

  .form-right {
    opacity: 0;
    transition: all 0.5s;

    &.active {
      opacity: 1;
      transition: all 0.5s 1s;
    }
  }

  .form-right,
  .form-left {
    flex: 1;
    height: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;

    .title {
      color: $main-color;
    }

    .input-group {
      display: flex;
      align-items: center;
      /* background-color: red; */
      position: relative;

      input {
        box-sizing: border-box;
        padding: 0;
        margin: 1rem 0;
        width: 15rem;
        height: 3rem;
        font-size: 1rem;
        color: $shallow-color;

        border: none;
        border-bottom: 1px solid $main-color;
        background-color: transparent;

        &::placeholder {
          color: $shallow-color;
        }

        &:focus {
          outline: none;
        }
      }

      .icon {
        position: absolute;
        right: 0px;
        fill: $shallow-color;
      }
    }

    .form-btn {
      display: block;
      width: 10rem;
      padding: 10px 5px;
      font-size: 1.1rem;
      font-weight: bold;
      color: #fff;
      background-color: $main-color;
      border: none;
      border-radius: 5rem;
      box-shadow: 0 5px 4px $main-color;
    }
  }

  .sign-up,
  .sign-in {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }

  a {
    color: $main-color;
    position: absolute;
    bottom: 2rem;

    &.signup-link {
      right: 4rem;
    }

    &.signin-link {
      left: 2rem;
    }
  }
}
</style>
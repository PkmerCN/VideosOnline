/**
 * 定义user相关的store
 */
import { defineStore } from 'pinia'
import { computed, ref } from 'vue'
import appLocalStorage from '@/utils/appLocalStorage'
import { TOKEN_NAME } from '@/config/global-variables'

export const useUserStore = defineStore('user', () => {
  const count = ref(0)
  const token = ref(appLocalStorage.get<string>(TOKEN_NAME))

  const isLogin = computed(()=> token.value !== null)

  function setToken(tokenV: string) {
    token.value = tokenV
    appLocalStorage.set(TOKEN_NAME, tokenV)
  }

  return { count, token,isLogin, setToken }
})
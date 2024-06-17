import { defineStore } from 'pinia'
import { ref } from 'vue'
import appLocalStorage from '@/utils/appLocalStorage'
import {TOKEN_NAME} from '@/config/global-variables'

export const useUserStore = defineStore('user', () => {
  const count = ref(0)
  const token = ref(appLocalStorage.get<string>(TOKEN_NAME))

  function setToken(tokenV:string){
    token.value = tokenV
    appLocalStorage.set(TOKEN_NAME,tokenV)
  }

  return { count,token,setToken }
})
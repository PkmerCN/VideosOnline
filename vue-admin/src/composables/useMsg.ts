/**
 * 封装获取全局消息提示，方便在组件中使用
 */
import { getCurrentInstance } from 'vue'
import type { MessageType } from '@/utils/message'

const useMsg = () => {
  const instance = getCurrentInstance()
  if (instance) {
    const $msg: MessageType = instance.appContext.config.globalProperties.$msg
    return $msg
  }
  throw new Error(`Property $msg not found`)
}

export default useMsg

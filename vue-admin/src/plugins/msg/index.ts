/**
 * 消息插件
 */
import { type App } from 'vue'
import Message from '@/utils/message'

const msgPlugin = {
  install(app: App) {
    app.config.globalProperties.$msg = Message
  }
}

export default msgPlugin

import {type App} from "vue"
import Message from '@/utils/message'

/**
 * 消息插件
 */
const msgPlugin = {
  install(app:App){
    app.config.globalProperties.$msg = Message
  }
}

export default msgPlugin
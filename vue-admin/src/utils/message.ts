import MsgPrompt from '@/components/message/MsgPrompt.vue'
import { h, render } from 'vue'

const createMessage = () => {
  const containerDiv = document.createElement('div')
  document.body.appendChild(containerDiv)
  // 创建虚拟节点
  const vNode = h(MsgPrompt)
  // 使用render函数将VNode渲染到临时DOM容器
  render(vNode, containerDiv)

  const { showMessage } = vNode.component?.exposed as { showMessage: (msg: string, msgType?: MsgType) => void }

  return {
    info: (msg: string) => showMessage(msg, 'info'),
    success: (msg: string) => showMessage(msg, 'success'),
    error: (msg: string) => showMessage(msg, 'error')
  }
}

const Message = createMessage()
export default Message
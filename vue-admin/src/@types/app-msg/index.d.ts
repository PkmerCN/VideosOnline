type MsgType = 'info' | 'success' | 'error'

interface MessageI {
  id: number
  content: string
  msgType: MsgType
}

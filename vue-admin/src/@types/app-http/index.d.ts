// 全局使用
interface AppBaseResponse<T = unknown>{
  code: number,
  msg: string,
  data: T | null
}

type AppResponse<T> = Promise<AppBaseResponse<T>>
type Data = Record<string, unknown>


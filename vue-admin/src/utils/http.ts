/**
 * axios配置
 */
import axios, { type AxiosRequestConfig } from 'axios'
import { type AppHTTP, StatusCode } from '@/@types/app-http/http'
import { timeout, baseURL } from '@/config/env-variables'
import Message from '@/utils/message'
import { TOKEN_NAME } from '@/config/global-variables'
import appLocalStorage from '@/utils/appLocalStorage'

const axiosInstance = axios.create({
  baseURL,
  timeout
})

/**
 * 请求拦截配置
 */
axiosInstance.interceptors.request.use((config) => {
  console.log('请求拦截')
  config.headers['Content-Type'] = 'application/json'
  // 使用 Bearer 令牌进行认证，通常用于 OAuth 2.0
  config.headers['Authorization'] = `Bear ${appLocalStorage.get(TOKEN_NAME) ?? ''}`
  return config
})

/**
 * 响应拦截配置
 */
axiosInstance.interceptors.response.use((response) => {
  console.log('响应拦截')
  // 先检查业务
  const code = (response.data.code ?? 0) as number

  if (code === StatusCode.OK) {
    return response
  }

  // 检测4开头还是5开头
  if (code) {
    const codeStr = code.toString()
    const msg = response.data.msg ?? '未知错误(后端未处理)'
    if (codeStr.startsWith('4')) {
      Message.info(msg)
    } else if (codeStr.startsWith('5')) {
      Message.error(msg)
    }
  }

  // 再检查网络
  if (response.status === 200) {
    return response
  } else {
    Message.info('网络错误')
  }

  return response
})

/**
 * 封装Get和POST方法
 */
const http: AppHTTP = {
  async get<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    try {
      const response = await axiosInstance.get<AppBaseResponse<T>>(url, {
        params: data,
        ...config
      })
      return response.data
    } catch (error) {
      if (axios.isAxiosError(error)) {
        console.log(error.message)
        Message.error(error.message)
      }
      throw error // 重新抛出错误，以便调用者可以处理它
    }
  },
  async post<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    try {
      const response = await axiosInstance.post<AppBaseResponse<T>>(url, data, config)
      return response.data
    } catch (error) {
      if (axios.isAxiosError(error)) {
        console.log(error.message)
        Message.error(error.message)
      }
      throw error // 重新抛出错误，以便调用者可以处理它
    }
  }
}

export default http

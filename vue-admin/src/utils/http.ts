/**
 * axios配置
 */
import axios, { type AxiosRequestConfig } from 'axios'
import type { AppHTTP } from '@/@types/app-http/http'
import {timeout,baseURL} from '@/config/env-variables'
import Message from '@/utils/message'

const axiosInstance=axios.create({
  baseURL,
  timeout
})

/**
 * 请求拦截配置
 */
axiosInstance.interceptors.request.use((config) => {

  config.headers['Content-Type'] = "application/json";
  // token
  return config;
})

/**
 * 响应拦截配置
 */
axiosInstance.interceptors.response.use((response)=>{
  // 先检查业务
  const code = (response.data.code ?? 0) as number

  if(code === StatusCode.OK){
    return response.data
  }

  // 检测4开头还是5开头
  if(code){
    const codeStr = code.toString()
    const msg = response.data.msg ?? "未知错误(后端未处理)"
    if(codeStr.startsWith('4')){
      Message.info(msg)
    }else if(codeStr.startsWith('5')){
      Message.error(msg)
    }
  }

  // 再检查网络
  if(response.status === 200){
    return response.data
  }else{
    Message.info("网络错误")
  }

  return response.data
})


/**
 * 封装Get和POST方法
 */
const http: AppHTTP = {
  async get<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    const response = await axiosInstance.get<AppBaseResponse<T>>(url, {
      params: data,
      ...config
    })
    return response.data
  },
  async post<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    const response = await axiosInstance.post<AppBaseResponse<T>>(url, data, config);
    return response.data;
  }
};

export default http
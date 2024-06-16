/**
 * axios配置
 */
import axios, { type AxiosRequestConfig } from 'axios'
import type { AppHTTP } from '@/@types/app-http/http'
import {timeout,baseURL} from '@/config/env-variables'


const axiosInstance=axios.create({
  baseURL,
  timeout
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
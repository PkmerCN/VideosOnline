/**
 * axios配置
 */
import axios, { type AxiosRequestConfig } from 'axios'
import type { AppHTTP } from '@/@types/app-http/http'

const http: AppHTTP = {
  async get<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    const response = await axios.get<AppBaseResponse<T>>(url, {
      params: data,
      ...config
    })
    return response.data
  },
  async post<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T> {
    const response = await axios.post<AppBaseResponse<T>>(url, data, config);
    return response.data;
  }
};

export default http
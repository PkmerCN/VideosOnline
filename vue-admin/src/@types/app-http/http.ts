import type { AxiosRequestConfig } from 'axios'

export interface AppHTTP {
  get<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T>;
  post<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T>;
}
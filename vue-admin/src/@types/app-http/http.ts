/**
 * 之所以单独建立一个http.ts文件而不是直接写在index.d.ts文件，
 * 是因为这里有import语句，import语句在.d.ts文件中会导致全局引用失效
 * 所以单独建立一个文件来写类型
 */

import type { AxiosRequestConfig } from 'axios'

export interface AppHTTP {
  get<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T>;
  post<T>(url: string, data?: Data, config?: AxiosRequestConfig): AppResponse<T>;
}

export enum StatusCode{
  OK = 2000
}

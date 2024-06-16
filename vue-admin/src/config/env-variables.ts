// 一个提示信息
if(import.meta.env.PROD){
  console.log("这是生产环境")
}else if(import.meta.env.DEV){
  console.log("这是开发环境")
}

export const baseURL = import.meta.env.VITE_APP_AXIOS_BASE_URL
export const timeout = import.meta.env.VITE_APP_TIMEOUT
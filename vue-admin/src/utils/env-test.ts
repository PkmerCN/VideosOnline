
console.log("MODE = ",import.meta.env.MODE)
console.log("BASE_URL",import.meta.env.BASE_URL)
console.log("DEV = ",import.meta.env.DEV)
console.log("PROD = ",import.meta.env.PROD)

// 访问自己定义的变量
console.log(import.meta.env.VITE_APP_TITLE)
console.log(import.meta.env.VITE_APP_API_URL)
console.log("timeout = ",import.meta.env.VITE_APP_TIMEOUT)
console.log("axios baseUrl = ",import.meta.env.VITE_APP_AXIOS_BASE_URL)
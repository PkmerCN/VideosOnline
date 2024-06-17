const logo = `
88888888b          dP dP               dP                     dP
88                 88 88               88                     88
a88aaaa    dP    dP 88 88    .d8888b. d8888P .d8888b. .d8888b. 88  .dP
88        88    88 88 88    Y8ooooo.   88   88'   88 88'   "" 88888"
88        88.  .88 88 88          88   88   88.  .88 88.  ... 88   8b.
dP         88888P  dP dP     88888P'   dP    88888P8  88888P' dP   YP

                          🤗 Happy Coding!!! 🤗
😊Author: 胖卡(HPangKa)
🍅Email: 1193094618@qq.com
🔥Gitee: https://gitee.com/developeros/videos-online
`

console.log("MODE = ",import.meta.env.MODE)
console.log("BASE_URL",import.meta.env.BASE_URL)
console.log("DEV = ",import.meta.env.DEV)
console.log("PROD = ",import.meta.env.PROD)

// 访问自己定义的变量
console.log(import.meta.env.VITE_APP_TITLE)
console.log(import.meta.env.VITE_APP_API_URL)
console.log("timeout = ",import.meta.env.VITE_APP_TIMEOUT)
console.log("axios baseUrl = ",import.meta.env.VITE_APP_AXIOS_BASE_URL)
console.log(logo)

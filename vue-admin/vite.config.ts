import { fileURLToPath, URL } from 'node:url'

import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import VueDevTools from 'vite-plugin-vue-devtools'

// https://vitejs.dev/config/
export default defineConfig((configEnv)=> {
  const {VITE_APP_API_URL: SERVER_API_URL} = loadEnv(configEnv.mode,process.cwd())
  return {
    plugins: [
      vue(),
      VueDevTools(),
    ],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url))
      }
    },
    server:{
      port: 18080,
      host: "0.0.0.0",
      proxy:{
        '/api':{
          target: SERVER_API_URL,
          changeOrigin:true,
          rewrite: (path) => path.replace(/^\/api/, ''),
        }
      }
    }
  }
})

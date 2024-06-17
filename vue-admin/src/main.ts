import { createApp } from 'vue'
import "@/assets/style/main.scss"
import App from './App.vue'
import '@/utils/env-test'
import msgPlugin from '@/plugins/msg'
import {createPinia} from 'pinia'

const app = createApp(App)
const pinia = createPinia()
app.use(msgPlugin)
app.use(pinia)
app.mount('#app')

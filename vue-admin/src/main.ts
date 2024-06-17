import { createApp } from 'vue'
import "@/assets/style/main.scss"
import App from './App.vue'
import '@/utils/env-test'
import msgPlugin from '@/plugins/msg'
import store from '@/store'

const app = createApp(App)

app.use(msgPlugin)
app.use(store)
app.mount('#app')

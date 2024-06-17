import { createApp } from 'vue'
import '@/assets/style/main.scss'
import App from './App.vue'
import '@/utils/env-test'
import msgPlugin from '@/plugins/msg'
import appStore from '@/store'
import appRouter from '@/router'

const app = createApp(App)

app.use(msgPlugin)
app.use(appStore)
app.use(appRouter)
app.mount('#app')

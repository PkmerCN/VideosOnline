import { createRouter, createWebHashHistory } from 'vue-router'
import defaultRoutes from '@/router/modules/default'

const routes = [...defaultRoutes]

const appRouter = createRouter({
  history:createWebHashHistory(),
  routes,
  scrollBehavior(){
    return {
      el: '#app',
      top: 0,
      behavior: 'smooth'
    }
  }
})

export default appRouter
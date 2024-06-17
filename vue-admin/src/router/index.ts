import { createRouter, createWebHashHistory } from 'vue-router'
import configNavigationGuards from '@/router/guards'
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


configNavigationGuards(appRouter)
export default appRouter
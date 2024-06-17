/**
 * 配置全局导航守卫
 */
import type { Router } from 'vue-router'
import { useUserStore } from '@/store'

function configNavigationGuards(router: Router) {
  router.beforeEach((to, from, next) => {
    const { isLogin } = useUserStore()
    console.log(`从 ${from.path} 导航到 ${to.path}`)
    console.log(`是否已经登录: ${isLogin}`)
    if(isLogin){
      //允许导航
      next()
    }else{
      // 未登录且目标路由不是登录页面，跳转到登录页面
      if (to.path !== '/login') {
        next('/login')
      } else {
        // 允许导航到登录页面
        next()
      }
    }
  })
}

export default configNavigationGuards
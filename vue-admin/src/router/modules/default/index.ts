/**
 * 存放默认的路由
 */
import type { RouteRecordRaw } from 'vue-router'

const defaultRoutes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/home',
    component: () => import('@/pages/home')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('@/pages/login')
  }
]

export default defaultRoutes

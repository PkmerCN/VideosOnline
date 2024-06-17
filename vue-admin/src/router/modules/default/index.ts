/**
 * 存放默认的路由
 */
const defaultRoutes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('@/pages/login')
  }
]

export default defaultRoutes
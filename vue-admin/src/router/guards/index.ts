/**
 * 配置全局导航守卫
 */
import type {Router} from 'vue-router'
function configNavigationGuards(router: Router){
  router.beforeEach((to,from,next)=>{
    console.log(`从 ${from.path} 导航到 ${to.path}`)
    //允许导航
    next()
  })
}
console.log("配置全局导航路由")
export default configNavigationGuards
import http from '@/utils/http'

/**
 * 用户登录
 * @param email
 * @param password
 */
function login(email:string,password:string){
  return http.post<{token: string}>("/auth/login",{email,password})
}



export {
  login
}
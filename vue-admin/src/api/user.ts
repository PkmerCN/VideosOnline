import http from '@/utils/http'

function getCode(phone: string): AppResponse<{ num: number }> {
  return Promise.resolve({
    code: 200,
    msg: 'Success',
    data: { num: 1 }
  });
}

export function login(){
  return http.post<{name: string}>("http://localhost:8080",{name: "a"})
}



function getCode(phone: string): AppResponse<{ num: number }> {
  return Promise.resolve({
    code: 200,
    msg: 'Success',
    data: { num: 1 }
  });
}
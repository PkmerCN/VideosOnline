/**
 * 定义id生成器
 */
function ids() {
  let count = 0
  return () => count++
}

const generateId = ids()

export default generateId
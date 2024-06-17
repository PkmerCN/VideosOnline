/**
 * 封装localStorage
 */
const appLocalStorage = {
  set: <T>(key:string,value: T):void => {
    try{
      localStorage.setItem(key, JSON.stringify(value));
    }catch (e){
      console.error("Error saving to localStorage",e);
    }
  },
  get: <T>(key:string):T | null => {
    try{
      const serializedValue = localStorage.getItem(key)
      if(serializedValue === null) return null;
      return JSON.parse(serializedValue) as T
    }catch (e){
      console.log(`Error reading from localStorage by Key = ${key}`,e);
      return null
    }
  },
  remove: (key:string):void => {
    localStorage.removeItem(key)
  },
  clear: ():void => {
    localStorage.clear()
  }
}


export default appLocalStorage
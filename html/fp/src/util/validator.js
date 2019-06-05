/**
 * Created by jiachenpan on 16/11/18.
 */

export function isvalidUsername(str) {
    const valid_map = ['admin', 'editor']
    return valid_map.indexOf(str.trim()) >= 0
  }

//   /* 合法uri*/
//   export function validateURL(textval) {
//     const urlregex = /^(http|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?*$/
//     return urlregex.test(textval)
//   }

  /* 小写字母*/
  export function validateLowerCase(str) {
    const reg = /^[a-z]+$/
    return reg.test(str)
  }

  /* 大写字母*/
  export function validateUpperCase(str) {
    const reg = /^[A-Z]+$/
    return reg.test(str)
  }

  /* 大小写字母*/
  export function validateAlphabets(str) {
    const reg = /^[A-Za-z]+$/
    return reg.test(str)
  }

  /**
   * validate email
   * @param email
   * @returns {boolean}
   */
  export function validateEmail(email) {
    const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
    return re.test(email)
  }
//   /*手机号码*/
  export function validatePhone(phone) {
    const re = /^(((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8})$/
    return re.test(phone)
  }

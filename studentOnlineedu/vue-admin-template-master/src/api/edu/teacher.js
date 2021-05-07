import request from '@/utils/request'

const api_name = '/edu/teacher'
export default class AnnexIssuedApi{

  static getPageList(data) {
    return request({
      url: `${api_name}/getPageList`,
      method: 'post',
      data: data
    })
  }
  static removeById(teacherId) {
    return request({
      url: `${api_name}/removeById`,
      method: 'post',
      data: { id : id}
    })
  }
  static save(teacher) {
    return request({
      url: `${api_name}/save`,
      method: 'post',
      data: teacher
    })
  }
  getById(id) {
    return request({
      url: `${api_name}/getById`,
      method: 'post',
      data: { id : id}
    })
  }
}

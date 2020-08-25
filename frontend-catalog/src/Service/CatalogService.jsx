import axios from 'axios'


class CatalogService{

retrieveAllStudents(user_name){
    return axios.get(`http://localhost:8080/users/${user_name}/catalog/retrieveAllStudents`)
}
retrieveStudentByCatalogId(user_name, id){
    return axios.get(`http://localhost:8080/users/${user_name}/catalog/retrieveStudentById/${id}`)
}

createStudent(user_name, catalogViewEntity){
    return axios.post(`http://localhost:8080/users/${user_name}/catalog/addStudent`,catalogViewEntity )
}
updateStudent(user_name, id,catalogViewEntity){
    return axios.put(`http://localhost:8080/users/${user_name}/catalog/updateStudent/${id}`, catalogViewEntity)
}

deleteStudent(user_name, id){
    return axios.delete(`http://localhost:8080/users/${user_name}/catalog/deleteStudent/${id}`)
}




}

export default new CatalogService();
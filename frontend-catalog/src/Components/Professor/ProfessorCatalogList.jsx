import React, {Component} from "react";
import CatalogService from "../../Service/CatalogService";
import AuthenticationService from "../Login/AuthenticationService";


export default class ProfessorCatalogList extends Component{

    _isMounted = false; // this fixed the warning error in the console"A component is changing a controlled input of type text to be uncontrolled. Input elements should not switch from controlled to uncontrolled https://www.robinwieruch.de/react-warning-cant-call-setstate-on-an-unmounted-component
    constructor(props) {
        console.log('constructor')
        super(props)
        this.state = {
            students: [],
            message: null   // set it to null and not an empty message to ensure the alert doesnt show by default


        }

        this.deleteStudentClicked = this.deleteStudentClicked.bind(this)
        this.refreshStudentCatalog = this.refreshStudentCatalog.bind(this)
        this.updateStudent =this.updateStudent.bind(this)
        this.addStudent =this.addStudent.bind(this)

    }

        //this actually puts the component on the browser..it makes the call to the api to display the state
        componentDidMount() {
            this._isMounted = true // bug fix for changing a controlled input of type text to be uncontrolled
            console.log('componentDidMount')
            this.refreshStudentCatalog();// this refreshes the page once an item has been updated, deleted, etc

        }

    componentWillUnmount(){
        this._isMounted = false; // bug fix for warning in the console.
    }


    refreshStudentCatalog(){
        let user_name = AuthenticationService.getLoggedInUserName()    //The user name will be retrieved from the authentication service(login validation)
        CatalogService.retrieveAllStudents(user_name)
            .then(
                response =>{
                    if(this._isMounted) {
                        this.setState({students: response.data})//this displays your list!
                    }
                    this.refreshStudentCatalog();

                    //console.log(response)
                }

            )


    }

    deleteStudentClicked(id){
        let user_name = AuthenticationService.getLoggedInUserName() //component that assist with login and logouts
        //console.log(id + " " + username);
        CatalogService.deleteStudent(user_name, id)
            .then(
                response =>{
                    this.setState({ message: `Deleted student at id: ${id}`})
                }
            )


    }

    addStudent() {
        console.log("item added")
        this.props.history.push(`/addStudent/-1`) // "-1" signifies that a new item will be added
    }


    updateStudent(id) {
        console.log('Update student Clicked')
        this.props.history.push(`/studentCatalog/${id}`) // this pushes to my update component..make sure routes match
    }

    render(){
        console.log('render')
        return <div>
            <h1>Student Catalog List</h1>
            {this.state.message && <div className="alert alert-success">{this.state.message}</div>}

            {/*this allows for the alert to only show if something has been deleted successfully*/}
            <div className="container">
                <table className="table">
                    <thead>
                    <tr>
                        <th>Catalog Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Last 4 of SSN</th>
                        <th>Delete</th>
                        <th>Update</th>

                    </tr>
                    </thead>
                    <tbody>
                    {this.state.students.map (
                        students =>
                            <tr key={students.catalog_id}>
                                <td>{students.catalog_id}</td>
                                <td>{students.student_first_name}</td>
                                <td>{students.student_last_name}</td>
                                <td>{students.student_ssn}</td>
                                <td><button className = "btn btn-warning"
                                            onClick={() => this.deleteStudentClicked(students.catalog_id)}>Delete</button></td>
                                <td><button className = "btn btn-success"
                                            onClick={() => this.updateStudent(students.catalog_id)}>Update</button></td>
                            </tr>
                    )
                    }
                    </tbody>
                </table>
                <div className="row">
                    <button className= "btn btn-success" onClick={this.addStudent}>Add Student</button>
                </div>
            </div>
        </div>
    }






}
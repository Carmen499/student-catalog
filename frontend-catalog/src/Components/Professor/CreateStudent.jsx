import React, {Component} from 'react';
import AuthenticationService from "../Login/AuthenticationService";
import CatalogService from "../../Service/CatalogService";



export default class CreateStudent extends Component{
    constructor(props) {
        super(props)
        this.state = {
            catalog_id: this.props.match.params.catalog_id,
            student_first_name: '',
            student_last_name: '',
            student_ssn: ''
        }
        this.handleChange= this.handleChange.bind(this)
        this.handleSubmit = this.handleSubmit.bind(this)

    }

    handleChange(event) {
        event.preventDefault();
        this.setState({
            [event.target.name]: event.target.value
        })

    }

    handleSubmit(event){
        let user_name = AuthenticationService.getLoggedInUserName()
        let catalogViewEntity ={
            catalog_id: this.state.catalog_id,
            student_first_name: this.state.student_first_name,
            student_last_name: this.state.student_last_name,
            student_ssn: this.state.student_ssn
        }
        CatalogService.createStudent(user_name, catalogViewEntity)
            .then(this.props.history.push(`/studentCatalog`))

        event.preventDefault();

    }

    render() {
        return(

            <div>
                <div>
                    <h3 style={{textAlign: "center"}}>Add Student</h3>
                </div>
                <div className="container">
                    <form onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label> Catalog Id:</label>
                            <input className="form-control" type="text" value={this.state.catalog_id} disabled/>
                        </div>
                        <div>
                            <label>First Name:</label>
                            <input className="form-control" type="text" name="student_first_name" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Last Name:</label>
                            <input className="form-control" type="text" name="student_last_name" onChange={this.handleChange}/>
                        </div>
                        <div>
                            <label>Last 4 of SSN:</label>
                            <input className="form-control" type="text" name="student_ssn" onChange={this.handleChange}/>
                        </div>
                        <br/><br/>
                        <button className="btn btn-success" type="submit">Submit</button>
                    </form>
                </div>
            </div>

        )
    }



}
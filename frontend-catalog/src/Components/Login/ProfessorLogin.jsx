import React, {Component} from "react";
import AuthenticationService from "./AuthenticationService";


export default class ProfessorLogin extends Component{
    constructor(props){
        super(props)
        this.state= {
            user_name:"",
            password: "",
            hasLoginFailed:false,
            showSuccessMessage: false
        }
        this.handleChange = this.handleChange.bind(this)
        this.loginClicked = this.loginClicked.bind(this)
    }

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value  // coincides with the name on form and value is to state within constructor
        })
    }

    loginClicked() {
        if (this.state.username && this.state.password ) {
            AuthenticationService.registerSuccessfulLogin(this.state.username,this.state.password);
            this.props.history.push(`/welcome1/${this.state.username}`)
            // this.setState({showSuccessMessage: true})
            // this.setState({hasLoginFailed: false})
        } else {
            console.log('Login failed')
            this.setState({hasLoginFailed: true})
            this.setState({showSuccessMessage: false})
            // console.log(this.state)
        }
    }



    render() {
        return (
            <div>
                <h1>Faculty Login</h1>
                <div className="container">
                    {this.state.hasLoginFailed && <div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage &&<div className="alert alert-success">Login Successful</div>}

                    User Name: <input type="text" name="username" value={this.state.username}
                                      onChange={this.handleChange}/>
                    Password: <input type="password" name="password" value={this.state.password}
                                     onChange={this.handleChange}/>
                    <button className="btn btn-primary" onClick={this.loginClicked}>Login</button>


                </div>
            </div>

        )
    }








}
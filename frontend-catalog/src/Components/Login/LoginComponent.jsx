import React, {Component} from "react";
import AuthenticationService from "./AuthenticationService";
import {Link} from "react-router-dom";


export default class LoginComponent extends Component{
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
        if (this.state.user_name && this.state.password ) {
            AuthenticationService.registerSuccessfulLogin(this.state.user_name,this.state.password);
            this.props.history.push(`/welcome/${this.state.user_name}`)
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
            <form>
                <h1>Fintech Academy Login</h1>
                <div className="form-group">
                    {this.state.hasLoginFailed &&<div className="alert alert-warning">Invalid Credentials</div>}
                    {this.state.showSuccessMessage &&<div className="alert alert-success">Login Successful</div>}

                    <div className="container">
                        <label>User Name</label>
                        <input type="text" name="user_name" className="form-control" value={this.state.user_name}
                               onChange={this.handleChange}/>
                    </div>
                    <div className="container">
                        <label>Password</label>
                        <input type="password" name="password" className="form-control" value={this.state.password}
                                onChange={this.handleChange}/>
                    </div>

                    {/*User Name: <input type="text" name="username" value={this.state.username}*/}
                    {/*                  onChange={this.handleChange}/>*/}
                    {/*Password: <input type="password" name="password" value={this.state.password}*/}
                    {/*                 onChange={this.handleChange}/>*/}
                    <button type="Login" className="btn btn-primary" onClick={this.loginClicked}>Login</button>
                        <br/>
                    <p>Are you a Professor? Login <Link to="/login1">here</Link></p>

                </div>
            </form>

        )
    }








}
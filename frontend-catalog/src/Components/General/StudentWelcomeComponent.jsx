import React, {Component} from "react";
import {Link} from 'react-router-dom'

class StudentWelcomeComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            user_name: ''
        }
    }


    render() {
        return (
            <div className="container">
                <br/><br/>
                <div className="jumbotron" style={{textAlign: "center", backgroundColor: "Blue"}}>
                    <h1 style={{color: "Orange"}}>Welcome {this.state.user_name} to Fintech Academy.</h1>
                    <br/>
                    <h2 style={{color: "white"}}>You can view the student catalog <Link to="/studentCatalog2">here</Link></h2>
                </div>
            </div>
        )
    }
}

export default StudentWelcomeComponent;
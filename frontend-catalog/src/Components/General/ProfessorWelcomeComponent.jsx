import React, {Component} from "react";
import {Link} from 'react-router-dom'
class ProfessorWelcomeComponent extends Component {
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
                <div className="jumbotron" style={{textAlign: "center", backgroundColor: "Orange"}}>
                    <h1 style={{color: "blue"}}>Welcome Faculty Member {this.state.user_name}.</h1>
                    <br/>
                    <h2 style={{color: "white"}}>You can view and manage the student catalog <Link to="/studentCatalog">here</Link></h2>
                </div>
            </div>
        )
    }
}

export default ProfessorWelcomeComponent;
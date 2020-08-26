import React, {Component} from "react";
import AuthenticationService from "../Login/AuthenticationService";
import {Link} from 'react-router-dom'
// import {withRouter} from 'react-router'

class HeaderComponent extends Component {
    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        console.log('user is now logged in');
        //now if this value is true only then all other links will be active

        return(
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <div className="navbar-brand">Fintech Academy</div>
                    {/*<ul className="navbar-nav">*/}
                    {/*    {isUserLoggedIn && <li><Link className="nav-link" to="/login">Home</Link></li>}*/}
                    {/*</ul>*/}
                    <ul className="navbar-nav navbar-collapse justify-content-end">
                        {!isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                        {isUserLoggedIn && <li><Link className="nav-link" to="/logout" onClick={AuthenticationService.logout}>Logout</Link></li>}
                    </ul>
                </nav>
            </header>
        )
    }
}
export default HeaderComponent
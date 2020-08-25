import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import LoginComponent from "../Login/LoginComponent";
import WelcomeComponent from "./WelcomeComponent";
import LogoutComponent from "../Login/LogoutComponent";
import HeaderComponent from "./HeaderComponent";
import AuthenticatedRoute from "../Login/AuthenticatedRoute";
import ErrorComponent from "../Login/ErrorComponent";
import FooterComponent from "./FooterComponent";
import UpdateStudent from "../Professor/UpdateStudent";
import CreateStudent from "../Professor/CreateStudent";

export default class RouterComponent extends Component {
    render() {
        return (
            <div>
                <Router>
                    <HeaderComponent/>
                    <Switch>
                        <Route path="/" exact component={LoginComponent}/>
                        <Route path="/login" component={LoginComponent}/>
                        <AuthenticatedRoute path="/welcome/:user_name" component = {WelcomeComponent}/>
                        <AuthenticatedRoute path="/studentCatalog/:catalog_id" component={UpdateStudent}/>
                        {/*<Route path="/flashCards" exact component={FlashCardsList}/>*/}
                        <AuthenticatedRoute path="/addStudent/-1" component={CreateStudent}/>
                        <Route path="/logout" exact component={LogoutComponent}/>
                        <Route component={ErrorComponent}/>
                    </Switch>
                    <FooterComponent/>
                </Router>

            </div>
        );
    }
}
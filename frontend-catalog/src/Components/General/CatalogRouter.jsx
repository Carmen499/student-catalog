import React, {Component} from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import LoginComponent from "../Login/LoginComponent";
import ProfessorWelcomeComponent from "./ProfessorWelcomeComponent";
import LogoutComponent from "../Login/LogoutComponent";
import HeaderComponent from "./HeaderComponent";
import AuthenticatedRoute from "../Login/AuthenticatedRoute";
import ErrorComponent from "../Login/ErrorComponent";
import FooterComponent from "./FooterComponent";
import UpdateStudent from "../Professor/UpdateStudent";
import CreateStudent from "../Professor/CreateStudent";
import ProfessorCatalogList from "../Professor/ProfessorCatalogList";
import StudentCatalogList from "../Student/StudentCatalogList";
import StudentWelcomeComponent from "./StudentWelcomeComponent";
import ProfessorLogin from "../Login/ProfessorLogin";

export default class RouterComponent extends Component {
    render() {
        return (
            <div>
                <Router>
                    <HeaderComponent/>
                    <Switch>
                        <Route path="/" exact component={LoginComponent}/>
                        <Route path="/login" component={LoginComponent}/>
                        <Route path="/login1" component={ProfessorLogin}/>
                        <AuthenticatedRoute path="/welcome1/:user_name" component = {ProfessorWelcomeComponent}/>
                        <AuthenticatedRoute path="/welcome/:user_name" component = {StudentWelcomeComponent}/>
                        <AuthenticatedRoute path="/studentCatalog/:id" component={UpdateStudent}/>
                        <AuthenticatedRoute path="/studentCatalog" exact component={ProfessorCatalogList}/>
                        <AuthenticatedRoute path="/studentCatalog2" exact component={StudentCatalogList}/>
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
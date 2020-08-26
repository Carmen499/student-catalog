import React, {Component} from "react";
import CatalogService from "../../Service/CatalogService";
import {ErrorMessage, Field, Form, Formik} from "formik";


export default class UpdateStudent extends Component{
    constructor(props) {
        super(props)
        this.state = {
            id: this.props.match.params.id,
            student_first_name: '',
            student_last_name: '',
            student_ssn: ''
        }

        this.onSubmit = this.onSubmit.bind(this)

    }
    componentDidMount() {
        console.log("Component mounted")
        let user_name = CatalogService.getLoggedInUserName
        CatalogService.retrieveStudentByCatalogId(user_name, this.state.id)
            .then(
                response =>
                    this.setState({
                        student_first_name: response.data.student_first_name,
                        student_last_name: response.data.student_last_name,
                        student_ssn:response.data.student_ssn

                    })

            )

    }


    validate(values){  //validates the values within the form... to ensure dates are actual dates etc.
        let errors ={}   //empty object called errors
        if(!values.student_first_name || !values.student_last_name || !values.student_ssn){
            errors.student_first_name ="Please enter a first name"
            errors.student_last_name ="Please enter an last name"
            errors.student_ssn = "Please enter the last 4 of social security number"
        }else if(values.student_ssn.length <4){
            errors.student_ssn ="Enter at least the last 4 of the social security number"
        }

        return errors
    }

    onSubmit(values){  // submit values entered inside of the form
        console.log("onSubmit")
        let user_name= CatalogService.getLoggedInUserName
        let catalogViewEntity = {
            catalog_id: this.state.catalog_id,
            student_first_name: values.student_first_name,
            student_last_name: values.student_last_name,
            student_ssn: values.student_ssn
        }

        CatalogService.updateStudent(user_name, this.state.id, catalogViewEntity)
            .then(() => this.props.history.push(`/studentCatalog`))
    }

    render() {
        let {id, student_first_name, student_last_name, student_ssn} = this.state

        return (
            <div>
                <h3> Update Student </h3>
                <div className="container">

                    <Formik
                        initialValues={{id, student_first_name, student_last_name, student_ssn}}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}   //this keeps the error message from populating by default and only when the save button is clicked. User for when you need to validate OnChange events and related methods
                        validateOnBlur={false}     //this keeps the error message from populating by default and only when the save button is clicked. Useful for when you need to validate whether an input has been touched or not
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>
                                    <ErrorMessage name="student_first_name" component="div"
                                                  className="alert alert-warning"/>
                                    <ErrorMessage name="student_last_name" component="div"
                                                  className="alert alert-warning"/>
                                    <ErrorMessage name="student_ssn" component="div" className="alert alert-warning"/>
                                    <fieldset>
                                        <label>First Name</label>
                                        <Field className="form-control" type="text" name="student_first_name"/>
                                    </fieldset>
                                    <fieldset>
                                        <label>Last Name</label>
                                        <Field className="form-control" type="text" name="student_last_name"/>
                                    </fieldset>
                                    <fieldset>
                                        <label>Last 4 Social Security Number</label>
                                        <Field className="form-control" type="text" name="student_ssn"/>
                                    </fieldset>
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>
                </div>
            </div>

        )

    }

}
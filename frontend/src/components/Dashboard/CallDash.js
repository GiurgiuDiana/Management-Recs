import React, {Component} from "react";
import firebase from "../firebase";
import SearchForm from "../SearchForm/SearchForm";
import ListTable from "../Table/Table";
import {withRouter} from "react-router-dom";
import withStyles from "@material-ui/core/styles/withStyles";
import Dashboard from "./index";


class CallDASH extends Component {
    constructor(props) {
        super(props)
        this.state = {
            Users: [],
            Movies: [],
            loggedUser: '',
            Comments: [],
            Ratings: [],
            message: null
        }
        this.reloadObjectiveList = this.reloadObjectiveList.bind(this);

    }

    reloadObjectiveList() {

    }

    componentDidMount() {
        this.reloadObjectiveList();
        this.setState({loggedUser: firebase.getCurrentUsername()})
    }

    render() {
        return (
            <div>
               <Dashboard/>
            </div>)
    }
    }
    export default withRouter(withStyles(styles)(CallDASH))

import React from "react";
import "./card.css";
import DeleteIcon from "@material-ui/icons/DeleteForeverOutlined";
import MovieApiService from "../Services/MovieApiService";
import UserApiService from "../Services/UserApiService";
import {Paper} from "@material-ui/core";

const styles = theme => ({
    main: {
        width: 'auto',
        display: 'block', // Fix IE 11 issue.
        marginLeft: theme.spacing.unit * 3,
        marginRight: theme.spacing.unit * 3,
        [theme.breakpoints.up(400 + theme.spacing.unit * 3 * 2)]: {
            width: 400,
            marginLeft: 'auto',
            marginRight: 'auto',
        },
    },
    paper: {
        marginTop: theme.spacing.unit * 8,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        padding: `${theme.spacing.unit * 2}px ${theme.spacing.unit * 3}px ${theme.spacing.unit * 3}px`,
    },
})


function  deleteUsers(ObjectiveId) {
    UserApiService.deleteUsers( ObjectiveId)
        .then(res => {
            console.log({message: 'Objective deleted successfully.'});
            // this.setState({Movies: this.state.Movies.filter(Objective => Objective.imdb_id !== ObjectiveId)});
        })
}
const CardUsers = ({ item }) => {
    return (
        <main className={styles.main}>
            <Paper className={styles.paper}>
                <div className="cardMaiMare">
        <div className="card">
            <div className="card-header">
                <div className="card-title">{item.firstName.toUpperCase() +item.lastName.toUpperCase()}</div>
                <div className="card-rating"></div>  <DeleteIcon onClick={() => deleteUsers(item.username)} />
            </div>

            <div className="card-body">
                <div className="card-details">
                    Description: {item.description}
                <br/>
                Email: {item.email}
                </div>

            </div>
        </div>
                </div>
            </Paper>
        </main>
    );
};

export default CardUsers;

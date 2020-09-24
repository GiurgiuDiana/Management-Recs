import React, {Component, useEffect, useState} from 'react'
import { Typography, Paper, Avatar, CircularProgress, Button } from '@material-ui/core'
import VerifiedUserOutlined from '@material-ui/icons/VerifiedUserOutlined'
import withStyles from '@material-ui/core/styles/withStyles'
import firebase from '../firebase'
import { withRouter } from 'react-router-dom'
//import {Col, Row, Table} from "antd";
import uuidv4 from "uuid/v4";
import Utils from "../Services/utilsService";
import UserApiService from "../Services/UserApiService";
import ErrorPage from "./Error page/eRROR";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";
import DeleteIcon from "@material-ui/icons/DeleteForeverOutlined";
import MovieApiService from "../Services/MovieApiService";
import CommentApiService from "../Services/CommentApiService";
import RatingApiService from "../Services/RatingApiService";
import Card from "../CARD/Card"
import CardUsers from "../CARD/CardUsers";
class Dashboard extends Component {

    constructor(props) {
        super(props)
        this.state = {
            Users: [],
            Movies: [],
            Comments: [],
            Ratings: [],
            message: null
        }



        this.reloadObjectiveList = this.reloadObjectiveList.bind(this);
        if (!firebase.getCurrentUsername()) {
            // not logged in
            alert('Please login first')
            props.history.replace('/login')
            return null

        }
    }
    reloadObjectiveList() {
        UserApiService.fetchTourist()
            .then((res) => {
                this.setState({
                    Users: res.data.result
                })
            });

        MovieApiService.fetchMovies()
            .then((res) => {
                this.setState({
                    Movies: res.data.result
                })
            });

        CommentApiService.fetchComments()
            .then((res) => {
                console.log( res.data.result)
                this.setState({

                    Comments:  res.data.result
                })
            });
        RatingApiService.fetchratings()
            .then((res) => {
                console.log( res.data.result)
                this.setState({

                    Ratings:  res.data.result
                })
            });


    }

    deleteUsersComments(ObjectiveId) {
        CommentApiService.deleteComment( ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Comments: this.state.Comments.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }
    deleteUsersRatingss(ObjectiveId) {
        RatingApiService.deleterating( ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Ratings: this.state.Ratings.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }
    deleteMovies(ObjectiveId) {
        MovieApiService.deleteTourist( ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Movies: this.state.Movies.filter(Objective => Objective.imdb_id !== ObjectiveId)});
            })
    }
    deleteUsers(ObjectiveId) {

        UserApiService.deleteTourist( ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Movies: this.state.Movies.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }

    componentDidMount()
    {
        this.reloadObjectiveList();
    }

    render() {
        return (
            <main className={styles.main}>
                <Paper className={styles.paper}>
                    <Typography component="h1" variant="h5">
                        Hello {firebase.getCurrentUsername()}
                    </Typography>
                    <hr/>
                    <Typography component="h1" variant="h5">
                        Users:
                    </Typography>

                    <div className="card-list">

                        {this.state.Users.map(item => (
                            <CardUsers item={item} key={item.username} />
                        ))}
                    </div>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>UserFirstName</TableCell>
                                <TableCell>UserLastName</TableCell>
                                <TableCell>UserEmail</TableCell>


                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {this.state.Users.map(row => (
                                <TableRow key={row.username}>
                                    <TableCell align="center">{row.firstName}</TableCell>
                                    <TableCell align="center">{row.lastName}</TableCell>
                                    <TableCell align="center">{row.email}</TableCell>
                                    <TableCell align="center" onClick={() => this.deleteUsers(row.username)}><DeleteIcon /></TableCell>
                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>
                    <hr/>
                    <Typography component="h1" variant="h5">

                        Comments
                    </Typography>
                    <hr/>

                    <hr/>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>UserId</TableCell>
                                <TableCell>Comment</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {this.state.Comments.map(row => (
                                <TableRow key={row.username}>
                                    <TableCell align="center">{row.username}</TableCell>
                                    <TableHead>
                                        <TableCell>MovieID</TableCell>
                                        <TableCell>Comment</TableCell>
                                    </TableHead>

                                    <TableBody>
                                        {row.commentsList.map(row2 => (
                                            <TableRow key={row2.id}>
                                                <TableCell align="center">{row2.movieID}</TableCell>
                                                <TableCell align="center">{row2.comment}</TableCell>
                                                <TableCell align="center" onClick={() => this.deleteUsersComments(row2)}><DeleteIcon /></TableCell>

                                            </TableRow >))}

                                    </TableBody>


                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>



                    <Typography component="h1" variant="h5">

                        Ratings
                    </Typography>
                    <hr/>

                    <hr/>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <TableCell>UserId</TableCell>
                                <TableCell>Ratings</TableCell>
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {this.state.Ratings.map(row => (
                                <TableRow key={row.username}>
                                    <TableCell align="center">{row.username}</TableCell>
                                    <TableHead>
                                        <TableCell>MovieID</TableCell>
                                        <TableCell>Rating</TableCell>
                                    </TableHead>

                                    <TableBody>
                                        {row.ratingsList.map(row2 => (
                                            <TableRow key={row2.id}>
                                                <TableCell align="center">{row2.movieID}</TableCell>
                                                <TableCell align="center">{row2.rating}</TableCell>
                                                <TableCell align="center" onClick={() => this.deleteUsersRatingss(row2)}><DeleteIcon /></TableCell>

                                            </TableRow >))}

                                    </TableBody>


                                </TableRow>
                            ))}
                        </TableBody>
                    </Table>


                </Paper>
            </main>
        )


    }
}

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
    avatar: {
        margin: theme.spacing.unit,
        backgroundColor: theme.palette.secondary.main,
    },
    submit: {
        marginTop: theme.spacing.unit * 3,
    },
})

export default withRouter(withStyles(styles)(Dashboard))

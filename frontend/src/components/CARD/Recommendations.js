import React, {Component, useEffect, useState} from 'react'
import { Typography, Paper, Avatar, CircularProgress, Button } from '@material-ui/core'
import VerifiedUserOutlined from '@material-ui/icons/VerifiedUserOutlined'
import withStyles from '@material-ui/core/styles/withStyles'
import firebase from '../firebase'
import { withRouter } from 'react-router-dom'

import UserApiService from "../Services/UserApiService";

import MovieApiService from "../Services/MovieApiService";
import CommentApiService from "../Services/CommentApiService";
import RatingApiService from "../Services/RatingApiService";
import Card from "./Card"
import CardUsers from "../CARD/CardUsers";
import CardTamplate from "../CardTemplate/CardTemplate";
import {Col, Row} from "antd";
import uuidv4 from "uuid/v4";
import CardTemplate from "../CardTemplate/CardTemplate";



class Dashboard extends Component {

    constructor(props) {
        super(props)
        this.state = {
            Users: [],
            Movies: [],
            Comments: [],
            Faves:[],
            Warched:[],
            Recs:[],
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

    reloadObjectiveList(key) {
        UserApiService.searchUser(window.localStorage.getItem("faveList"))
            .then((res) => {
                console.log(res.data.favouritesMovies)
                this.setState({
                    Faves: res.data.favouritesMovies,
                    Watched:  res.data.watchedMovies,
                    Recs: res.data.recomendationsMovies,

                    user_id: res.data.username})
            });


        MovieApiService.fetchMovies()
            .then((res) => {
                this.setState({
                    Movies: res.data.result
                })
            });

        CommentApiService.fetchComments()
            .then((res) => {
                console.log(res.data.result)
                this.setState({

                    Comments: res.data.result
                })
            });
        RatingApiService.fetchratings()
            .then((res) => {
                console.log(res.data.result)
                this.setState({

                    Ratings: res.data.result
                })
            });


    }

    deleteUsersComments(ObjectiveId) {
        CommentApiService.deleteComment(ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Comments: this.state.Comments.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }

    deleteUsersRatingss(ObjectiveId) {
        RatingApiService.deleterating(ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Ratings: this.state.Ratings.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }

    deleteMovies(ObjectiveId) {
        MovieApiService.deleteTourist(ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Movies: this.state.Movies.filter(Objective => Objective.imdb_id !== ObjectiveId)});
            })
    }

    deleteUsers(ObjectiveId) {

        UserApiService.deleteTourist(ObjectiveId)
            .then(res => {
                this.setState({message: 'Objective deleted successfully.'});
                this.setState({Movies: this.state.Movies.filter(Objective => Objective.username !== ObjectiveId)});
            })
    }

    componentDidMount() {
        this.reloadObjectiveList();
    }

    render() {
        const {classes} = this.props

        return (
            <main className={classes.main}>
                <Paper className={classes.paper}>
                    <Typography component="h1" variant="h5">
                        Hello, Diana
                    </Typography>
                    <hr/>
                    <Typography component="h1" variant="h5">
                        We think you might like this!
                    </Typography>
                    <hr/>
                    <div>

                        {this.state.Recs.map(film => {
                        return (
                        <Col className='gutter-row' span={5} offset={1} key={uuidv4()}>
                        <CardTemplate
                        name={film.title}
                        date={film.release_date}
                        vote={film.vote_average}
                        image={film.poster_path}
                        id={film.id}
                        />
                        </Col>)
                    })}

                    </div>
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
            width: 1200,
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

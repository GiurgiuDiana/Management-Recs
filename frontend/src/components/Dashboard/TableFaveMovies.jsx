import TableCell from "@material-ui/core/TableCell";
import {withRouter} from "react-router-dom";
import withStyles from "@material-ui/core/styles/withStyles";
import UserApiService from "../Services/UserApiService";
import React, { Component } from 'react'
import TableBody from "@material-ui/core/TableBody";
import DeleteIcon from '@material-ui/icons/DeleteForeverOutlined';
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import {Paper, Typography} from "@material-ui/core";
import {Col, Row} from "antd";
import uuidv4 from "uuid/v4";
import CardTemplate from "../CardTemplate/CardTemplate";

class ViewObjectivsComponent extends Component {

  constructor(props) {
    const { classes } = props

    super(props)
    this.state = {
      Faves: [],
        Watched:[],
        Recs:[],
      user_id:'',
      message: null
    }

    this.reloadObjectiveList = this.reloadObjectiveList.bind(this);
  }

  componentDidMount() {
    this.reloadObjectiveList();
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
  }

  deleteObjective(ObjectiveId) {
    UserApiService.deletefromWishlist(this.state.user_id, ObjectiveId)
        .then(res => {
          this.setState({message: 'Objective deleted successfully.'});
          this.setState({Faves: this.state.Faves.filter(Objective => Objective.id !== ObjectiveId)});
        })
  }

    deleteWatched(ObjectiveId) {
        UserApiService.deletefromWatchlist(this.state.user_id, ObjectiveId)
            .then(res => {
                this.setState({message: 'Watched deleted successfully.'});
                this.setState({Watched: this.state.Watched.filter(Objective => Objective.id !== ObjectiveId)});
            })
    }




    render() {

    return (

        <main className={styles.main}>

          <Paper className={styles.paper}>

              <Typography component="h1" variant="h5">
                  Favourite Movies
              </Typography>
<hr/>
              <div>
                  <Row>
                      <Col span={12} offset={6}>
                          <h1 className='title'>{ this.props.currentPage } </h1>
                      </Col>
                  </Row>
                  <Row gutter={24}>
                      {
                          this.state.Faves.map(film => {
                              return (
                                  <Col className='gutter-row' span={5} offset={1} key={uuidv4()}>
                                      <CardTemplate
                                          name={film.title}
                                          date={film.release_date}
                                          vote={film.vote_average}
                                          image={film.poster_path}
                                          id={film.id}
                                      />
                                  </Col>
                              )
                          })
                      }

                  </Row>
              </div>
              <Typography component="h1" variant="h5">
                  Watched Movies
              </Typography>
              <div>
                  <Row>
                      <Col span={12} offset={6}>
                          <h1 className='title'>{ this.props.currentPage } </h1>
                      </Col>
                  </Row>
                  <Row gutter={24}>
                      {
                          this.state.Watched.map(film => {
                              return (
                                  <Col className='gutter-row' span={5} offset={1} key={uuidv4()}>
                                      <CardTemplate
                                          name={film.title}
                                          date={film.release_date}
                                          vote={film.vote_average}
                                          image={film.poster_path}
                                          id={film.id}
                                      />
                                  </Col>
                              )
                          })
                      }

                  </Row>
              </div>

              <Typography component="h1" variant="h5">
        You might like this
              </Typography>



              <div>
                  <Row>
                      <Col span={12} offset={6}>
                          <h1 className='title'>{ this.props.currentPage } </h1>
                      </Col>
                  </Row>
                  <Row gutter={24}>
                      {
                          this.state.Recs.map(film => {
                              return (
                                  <Col className='gutter-row' span={5} offset={1} key={uuidv4()}>
                                      <CardTemplate
                                          name={film.title}
                                          date={film.release_date}
                                          vote={film.vote_average}
                                          image={film.poster_path}
                                          id={film.id}
                                      />
                                  </Col>
                              )
                          })
                      }

                  </Row>
              </div>
          </Paper>
        </main>

    );
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


export default withRouter(withStyles(styles)(ViewObjectivsComponent))


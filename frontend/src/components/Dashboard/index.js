import React, {Component, useEffect, useState} from 'react'
import { Typography, Paper, Avatar, CircularProgress, Button } from '@material-ui/core'
import VerifiedUserOutlined from '@material-ui/icons/VerifiedUserOutlined'
import withStyles from '@material-ui/core/styles/withStyles'
import firebase from '../firebase'
import { withRouter } from 'react-router-dom'
import {Col, Row, Table} from "antd";
import uuidv4 from "uuid/v4";
import Utils from "../Services/utilsService";
import ErrorPage from "../ADMINstuff/adminView";
import {createMuiTheme, makeStyles, MuiThemeProvider} from "@material-ui/core/styles";

const styles = theme => ({
	main: {
		width: 'auto',
		display: 'block', // Fix IE 11 issue.
		marginLeft: theme.spacing.unit * 3,
		marginRight: theme.spacing.unit * 3,
		[theme.breakpoints.up(400 + theme.spacing.unit * 3 * 2)]: {
			width: 1000,
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

// const useStyles = makeStyles({
// 	root: {
// 		width: 200,
// 		display: 'flex',
// 		alignItems: 'center',
// 	},
// });
// const classes = makeStyles(styles);

const theme = createMuiTheme()


class Dashboard extends Component {

	constructor(props) {

		super(props)
		this.state = {
			Users: [],
			Movies: [],
			loggedUser: '',
			firstName: '',
			lastName: '',
			email: '',
			Comments: [],
			desc: '',
			Ratings: [],
			message: null
		}
		if (!firebase.getCurrentUsername()) {
			// not logged in
			alert('Please login first')
			this.props.history.replace('/login')
			return null
		}
		this.reloadObjectiveList = this.reloadObjectiveList.bind(this);
		this.logout = this.logout.bind(this);
		this.seeList = this.seeList.bind(this);
		this.useremail = this.useremail.bind(this);
		this.Prm = this.Prm.bind(this);


	}

	async logout() {
		await firebase.logout()
		this.props.history.push('/')
	}

	async seeList() {
		//	await firebase.logout()
		window.localStorage.setItem("faveList", firebase.getCurrenUsername())
		this.props.history.push('/favouriteslists')
	}

	async seeRecs() {
		//	await firebase.logout()
		window.localStorage.setItem("faveList", firebase.getCurrenUsername())
		this.props.history.push('/recomendations')
	}


	reloadObjectiveList() {
	}

	async Prm() {
		if (!firebase.getCurrentUsername()) {
			// not logged in
			alert('Please login first')
			this.props.history.replace('/login')
			return null
		}
	}

	async useremail() {
		firebase.getCurrentUserEmail().then(result => {
			console.log(result)
			this.setState({email: result}, () => {
					console.log(this.state)
				}
			)
		})
		firebase.getCurrentUserLastName().then(result => {
			console.log(result)
			this.setState({lastName: result}, () => {
					console.log(this.state)
				}
			)
		})
		firebase.getCurrentUserFirstname().then(result => {
			console.log(result)
			this.setState({firstName: result}, () => {
					console.log(this.state)
				}
			)
		})
		firebase.getCurrentUserDescription().then(result => {
			console.log(result)
			this.setState({desc: result}, () => {
					console.log(this.state)
				}
			)
		})

	}

	componentDidMount() {
		this.Prm().then(r => {
			console.log(r)
		})
		let mm = this.useremail()
		console.log(mm)
		console.log(this.state.email)
		this.reloadObjectiveList();
		console.log(this.state.firstName)
		console.log(this.state.lastName)
	}

	render() {

		const { classes } = this.props

		return (


				<main className={classes.main}>
					<Paper className={classes.paper}>
						<Avatar className={classes.avatar}>
							<VerifiedUserOutlined/>
						</Avatar>
						<Typography component="h1" variant="h5">
							Hello {this.state.email}
						</Typography>
						<Typography component="h1" variant="h5">


							Your first Name: {this.state.firstName}
							<hr/>
							Your Last Name: {this.state.lastName}

						</Typography>
						<Button
							type="submit"
							variant="contained"
							color="secondary"
							onClick={() => this.logout()}
							className={classes.submit}>
							Logout
						</Button>
						<Button
							type="submit"
							variant="contained"
							color="secondary"
							onClick={() => this.seeList()}
							className={classes.submit}>
							Fave
						</Button>
						<Button
							type="submit"
							variant="contained"
							color="secondary"
							onClick={() => this.seeRecs()}
							className={classes.submit}>
							Get Recomendations
						</Button>
					</Paper>
				</main>


		)

	}
}

export default withRouter(withStyles(styles)(Dashboard))

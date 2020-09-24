import React, { useState, useEffect } from 'react'
import './styles.css'
import HomePage from '../HomePage'
import Login from '../Login'
import Register from '../Register'
import Dashboard from '../Dashboard'
import { unstable_createMuiStrictModeTheme } from '@material-ui/core/styles';
import Recommendations from "../CARD/Recommendations";
import { MuiThemeProvider, createMuiTheme } from '@material-ui/core/styles'
import { CssBaseline, CircularProgress } from '@material-ui/core'
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import firebase from '../firebase'
import Showfilms from "../Showfilms/Showfilms";
import Movie from "../Movie/Movie";
import Navbar from "../Navbar/Navbar";
import Home from "../Home/Home";
import Wishlist from "../Movie/Wishlist";
import Review from "../Movie/Review"
import FaveList from "../Dashboard/FaveList"
import TableFaveMovies from "../Dashboard/TableFaveMovies";
import adminView from "../ADMINstuff/adminView";
import ShowShow from "../TVSHOWS/ShowShow";
import tv from "../TVSHOWS/tv";

const theme = createMuiTheme()

export default function App() {

	const [firebaseInitialized, setFirebaseInitialized] = useState(false)

	useEffect(() => {
		firebase.isInitialized().then(val => {
			setFirebaseInitialized(val)
		})
	})


	return firebaseInitialized !== false ? (
		<MuiThemeProvider theme={theme}>
			<CssBaseline />
			<Router>
				<Navbar />
				<Switch>
					<Route exact path='/' component={Home} />
					<Route exact path="/auth" component={HomePage} />
					<Route exact path="/login" component={Login} />
					<Route exact path="/register" component={Register} />
					<Route exact path="/admin" component={adminView} />
					<Route exact path="/dashboard" component={Dashboard} />
					<Route exact path="/add_to_wishlist" component={Wishlist} />
					<Route exact path="/favouriteslists" component={TableFaveMovies} />
					<Route exact path="/review" component={Review} />
					<Route exact path="/recomendations" component={Recommendations} />
					{/*<Route exact path="background" component={Bcks}/>*/}
					<Route exact path='/popular' render={
						props => (<Showfilms currentPage='Popular' category='popular'{...props} />
						)} />
					<Route exact path='/populartv' render={
						props => (<ShowShow currentPage='Popular' category='popular'{...props} />
						)} />
					<Route exact path='/upcoming' render={
						props => (<Showfilms currentPage='Up Coming' category='upcoming' {...props} />
						)} />
					<Route exact path='/nowplaying' render={
						props => (<Showfilms currentPage='Now Playing' category='now_playing' {...props} />
						)} />
					<Route exact path='/toprated' render={
						props => (<Showfilms currentPage='Top Rated' category='top_rated' {...props} />
						)} />
					<Route exact path='/search/:query' render={
						props => (<Showfilms currentPage='Search Results' {...props} />
						)} />
					<Route exact path='/movie/:id' component={Movie} />
					<Route exact path='/tv/:id' component={tv} />

				</Switch>
			</Router>
		</MuiThemeProvider>
	) : <div id="loader"><CircularProgress /></div>
}

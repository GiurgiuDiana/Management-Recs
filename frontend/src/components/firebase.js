import app from 'firebase/app'
import 'firebase/auth'
import 'firebase/firebase-firestore'

const config = {
	apiKey: process.env.REACT_APP_FIREBASE_KEY,
	authDomain: process.env.REACT_APP_FIREBASE_DOMAIN,
	databaseURL: process.env.REACT_APP_FIREBASE_DATABASE,
	projectId: process.env.REACT_APP_PROJECT_ID,
	storageBucket: process.env.REACT_APP_FIREBASE_STORAGE_BUCKET,
	messagingSenderId: process.env.REACT_APP_FIREBASE_SENDER_ID
}

class Firebase {
	constructor() {
		app.initializeApp(config)
		this.auth = app.auth()
		this.db = app.firestore()
	}

	login(email, password) {
		return this.auth.signInWithEmailAndPassword(email, password)
	}

	logout() {
		return this.auth.signOut()
	}

	async register(name, email, password) {
		await this.auth.createUserWithEmailAndPassword(email, password)
		return this.auth.currentUser.updateProfile({
			displayName: name
		})
	}

	deleteUser()
	{
		//var user = firebase.auth().currentUser;

		this.auth.currentUser.delete().then(function() {
			console.log("userWasDeleted")
		}).catch(function(error) {
			console.log(error)
		});
	}
	addQuote(description,firstName,lastName, email, password) {
		let age='0'
		let favouritesMovies=[]
		let watchedMovies=[]
		let recomendationsMovies=[],userComments=[],userReviews=[]
		let username=this.auth.currentUser.uid
		let role="USER"

		if(!this.auth.currentUser) {
			return alert('Not authorized')
		}
		return this.db.doc(`users/${this.auth.currentUser.uid}`).set({
			description,
			email,
			password,
			firstName,
			lastName,
			username,
			age,
			userComments,
			userReviews,
			favouritesMovies,
			watchedMovies,
			recomendationsMovies,
			role


		})
	}

	isInitialized() {
		return new Promise(resolve => {
			this.auth.onAuthStateChanged(resolve)
		})
	}

	getCurrentUsername() {
		return this.auth.currentUser && this.auth.currentUser.displayName
	}

	async getCurrentUserRole() {
		const description = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return description.get('role')
	}
	 getCurrenUsername() {
		return this.auth.currentUser.uid
	}

	async getCurrentUserDescription() {
		const description = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return description.get('description')
	}
	async getCurrentUserFirstname() {
		const firstName = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return firstName.get('firstName')
	}
	async getCurrentUserLastName() {
		const lastName = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return lastName.get('lastName')
	}

	async getCurrentUserWishlist() {
		const favouritesMovies = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return favouritesMovies.get('favouritesMovies')
	}
	async getCurrentUserEmail() {
		const favouritesMovies = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return favouritesMovies.get('email')
	}

	async getCurrentUserPassword() {
		const favouritesMovies = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
		return favouritesMovies.get('password')
	}
    async getCurrentUserWatchlist() {
        const watchedMovies = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
        return watchedMovies.get('watchedMovies')
    }

    async getCurrentUserReccomendedList() {
        const recomendationsMovies = await this.db.doc(`users/${this.auth.currentUser.uid}`).get()
        return recomendationsMovies.get('recomendationsMovies')
    }



}

export default new Firebase()

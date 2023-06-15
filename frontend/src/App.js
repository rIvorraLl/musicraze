import React, { Component } from 'react';
import './App.css';

class App extends Component {
	state = {
		users: []
	}

	async componentDidMount() {
		const response = await fetch('/api/users');
		const body = await response.json();
		this.setState({ users: body });
	}

	render() {
		const { users } = this.state;
		console.log(users);
		return (
			<div className="App">
				<header className="App-header">
					<div className="App-intro">
						<h2>Users</h2>
						{users.map(user =>
							<div key={user.id}>
								{user.name} ({user.email})
							</div>
						)}
					</div>
				</header>
			</div>
		);
	}
}
export default App;
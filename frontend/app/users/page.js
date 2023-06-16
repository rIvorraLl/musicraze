"use client"
import React, { Component } from 'react';
import { useEffect, useState } from 'react'
import '../page.module.css'
import { main } from '../page.module.css';
class App extends Component {
	state = {
		users: []
	}

	async componentDidMount() {
		const response = await fetch('http://localhost:8080/api/users');
		const body = await response.json();
		this.setState({ users: body });
	}

	render() {
		const { users } = this.state;
		console.log(users);
		return (
			<main>
				<div className="main">
					<header className="description">
						<div className="code">
							<h2>Users</h2>
							{users.map(user =>
								<div key={user.id}>
									{user.name} ({user.email})
								</div>
							)}
						</div>
					</header>
				</div>
			</main>
		);
	}
}
export default App;
import React, { useState } from 'react';
import { useHistory } from 'react-router-dom';

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [userPassword, setPassword] = useState('');
  const history = useHistory();  // React Router's useHistory hook for navigation

  const handleSubmit = (e) => {
    e.preventDefault();

    // Here you would typically validate the login or authenticate the user.
    // For now, we'll assume the login is successful if the fields are filled.
    if (username && userPassword) {
      // Redirect to the URI with the username
      history.push(`/welcome/${username}`);
    } else {
      alert('Please enter both username and password');
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="username">Username:</label>
        <input
          type="text"
          id="username"
          value={username}
          onChange={(e) => setUsername(e.target.value)}
          required
        />
      </div>
      <div>
        <label htmlFor="password">Password:</label>
        <input
          type="password"
          id="userPassword"
          value={userPassword}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
      </div>
      <button type="submit">Login</button>
    </form>
  );
};

export default LoginForm;

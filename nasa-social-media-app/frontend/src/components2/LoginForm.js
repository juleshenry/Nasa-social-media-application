import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';  // Import useNavigate from react-router-dom

const LoginForm = () => {
  const [username, setUsername] = useState('');
  const [userPassword, setPassword] = useState('');
  const [error, setError] = useState('');  // New state to store error message
  const navigate = useNavigate();



  const handleSubmit = (e) => {
    e.preventDefault();

    if (username && userPassword) {
      // Redirect to the URI with the username
      navigate(`/profile/${username}`);
    } else {
      alert('Please enter both username and password');
    }
  };


  return (
    <div>
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

      {/* Display error message if there is one */}
      {error && <div style={{ color: 'red' }}>{error}</div>}
    </div>
    
  );
};

export default LoginForm;

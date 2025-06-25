import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';  // Import useNavigate from react-router-dom

const UserLogin = () => {
  const [username, setUsername] = useState('');
  const [userPassword, setPassword] = useState('');
  const [error, setError] = useState('');  // State to store error message
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();

    // Reset error state before each attempt
    setError('');

    try {
      // Send login request to backend API
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ username, userPassword }),
      });

      const data = await response.json();

      if (response.ok) {
        // Login successful, redirect to the welcome page
        navigate(`/profile/${username}`);
      } else {
        // Display error message
        setError(data.error || 'An error occurred');
      }
    } catch (error) {
      setError('Server error. Please try again later.');
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
        <h2> Login</h2>
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







export default UserLogin;

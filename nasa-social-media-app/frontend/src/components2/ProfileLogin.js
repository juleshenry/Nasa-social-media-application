import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const ProfileLogin = () => {
  const [formData, setFormData] = useState({
    username: '',
    userPassword: '',
  });

  const navigate = useNavigate(); // Initialize the navigate function

 
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const response = await fetch('http://localhost:8080/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    });

    if (response.ok) {
      // Assuming the login is successful, navigate to the welcome page with the username
      navigate(`/profile/${formData.username}`);
    } else {
      // Handle error (optional)
      console.log('Login failed');
    }
  };

  return (
    // <form action="http://localhost:8080/login" method="post">
    <form onSubmit={handleSubmit}>
      <div>
      <h2> Login</h2>
        <label htmlFor="username">Username</label>
        <input
          type="text"
          id="username"
          name="username"
          value={formData.username}
          onChange={handleChange}
          required
        />
      </div>
      <div>
        <label htmlFor="password">Password</label>
        <input
          type="password"
          id="userPassword"
          name="userPassword"
          value={formData.userPassword}
          onChange={handleChange}
          required
        />
      </div>
      <button type="submit">Login</button>
    </form>
  );
};

export default ProfileLogin;
